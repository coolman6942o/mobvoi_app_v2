package com.mobvoi.wear.proxy;

import android.os.SystemClock;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.base.TicwatchModels;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes2.dex */
public class ProxyTcpSocketIoManager {
    private static final int BANDWIDTH_LIMIT = 75;
    private static final String TAG = "proxy.tcp.mgr";
    private final Delegate mDelegate;
    private boolean mIsTicwatch;
    private ServerSocketChannel mListeningChannel;
    private volatile boolean mRunning;
    private Selector mSocketSelector;
    private long mTimestamp;
    private final ByteBuffer mByteBuffer = ByteBuffer.allocate(12288);
    private final Set<SocketChannel> mConnectingChannelSet = new HashSet();
    private final Set<SocketChannel> mPendingCloseChannelSet = new HashSet();
    private final Set<SocketChannel> mWritingChannelSet = new HashSet();

    /* loaded from: classes2.dex */
    public interface Delegate {
        void doAccept(SocketChannel socketChannel);

        void doClose(SocketChannel socketChannel);

        void doRead(SocketChannel socketChannel, ByteBuffer byteBuffer);

        int doWrite(SocketChannel socketChannel);
    }

    ProxyTcpSocketIoManager(Delegate delegate) {
        this.mDelegate = delegate;
    }

    private void close(SelectionKey selectionKey) {
        selectionKey.cancel();
        doCloseWithChannel((SocketChannel) selectionKey.channel());
    }

    private void closePendingChannels() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mPendingCloseChannelSet) {
            arrayList.addAll(this.mPendingCloseChannelSet);
            this.mPendingCloseChannelSet.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                doCloseWithChannel((SocketChannel) it.next());
            }
        }
    }

    private void disconnectAllPendingSockets(SelectableChannel selectableChannel) {
        for (SelectionKey selectionKey : this.mSocketSelector.keys()) {
            if (selectionKey.channel() != selectableChannel && selectionKey.channel().isOpen()) {
                close(selectionKey);
            }
        }
    }

    private void doAcceptWithKey(SelectionKey selectionKey) throws IOException {
        SocketChannel accept = ((ServerSocketChannel) selectionKey.channel()).accept();
        accept.configureBlocking(false);
        accept.socket().setTcpNoDelay(true);
        accept.register(this.mSocketSelector, 1);
        this.mDelegate.doAccept(accept);
    }

    private void doCloseWithChannel(SocketChannel socketChannel) {
        try {
            this.mDelegate.doClose(socketChannel);
            socketChannel.close();
        } catch (IOException e10) {
            k.d(TAG, "Failed to close channel: " + e10);
        }
    }

    private void doConnectWithKey(SelectionKey selectionKey) throws IOException {
        if (!((SocketChannel) selectionKey.channel()).finishConnect()) {
            close(selectionKey);
        } else {
            selectionKey.interestOps((selectionKey.interestOps() & (-9)) | 1);
        }
    }

    private int doReadWithKey(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        this.mByteBuffer.clear();
        int read = socketChannel.read(this.mByteBuffer);
        if (read == -1) {
            k.a(TAG, "Channel has reached EOF, closing");
            close(selectionKey);
            return read;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.mTimestamp;
        if (!this.mIsTicwatch && elapsedRealtime > 0) {
            float f10 = ((read / ((float) elapsedRealtime)) * 1000.0f) / 1024.0f;
            if (f10 > 75.0f) {
                long j10 = (((read / 75) * 1000) / 1024) - elapsedRealtime;
                k.c(TAG, "readBytes=%d, delta=%d, bandwidth=%fKB/s, timeToSleep=%d", Integer.valueOf(read), Long.valueOf(elapsedRealtime), Float.valueOf(f10), Long.valueOf(j10));
                if (j10 > 0) {
                    SystemClock.sleep(j10);
                }
            }
            this.mTimestamp = SystemClock.elapsedRealtime();
        }
        this.mByteBuffer.flip();
        this.mDelegate.doRead(socketChannel, this.mByteBuffer);
        return read;
    }

    private void doWriteWithKey(SelectionKey selectionKey) throws IOException {
        int doWrite = this.mDelegate.doWrite((SocketChannel) selectionKey.channel());
        if (doWrite == 0) {
            selectionKey.interestOps(selectionKey.interestOps() & (-5));
            return;
        }
        k.a(TAG, "Wrote " + doWrite + " bytes");
    }

    private void registerConnectingChannels() throws IOException {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mConnectingChannelSet) {
            arrayList.addAll(this.mConnectingChannelSet);
            this.mConnectingChannelSet.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((SocketChannel) it.next()).register(this.mSocketSelector, 8);
            }
        }
        if (!arrayList.isEmpty()) {
            k.a(TAG, "Registered " + arrayList.size() + " connecting channels");
        }
    }

    private void registerWritingChannels() throws IOException {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mWritingChannelSet) {
            arrayList.addAll(this.mWritingChannelSet);
            this.mWritingChannelSet.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                SelectionKey keyFor = ((SocketChannel) it.next()).keyFor(this.mSocketSelector);
                if (keyFor != null && keyFor.isValid()) {
                    keyFor.interestOps(keyFor.interestOps() | 4);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            k.a(TAG, "Registered " + arrayList.size() + " writing channels");
        }
    }

    public void cleanup() throws IOException {
        ServerSocketChannel serverSocketChannel = this.mListeningChannel;
        if (serverSocketChannel != null) {
            serverSocketChannel.close();
            this.mListeningChannel = null;
        }
        this.mSocketSelector.close();
    }

    public void closeChannel(SocketChannel socketChannel) {
        synchronized (this.mPendingCloseChannelSet) {
            this.mPendingCloseChannelSet.add(socketChannel);
            Selector selector = this.mSocketSelector;
            if (selector != null) {
                selector.wakeup();
            }
        }
    }

    public void registerConnectingChannel(SocketChannel socketChannel) {
        synchronized (this.mConnectingChannelSet) {
            this.mConnectingChannelSet.add(socketChannel);
            Selector selector = this.mSocketSelector;
            if (selector != null) {
                selector.wakeup();
            }
        }
    }

    void reportWritingChannel(SocketChannel socketChannel) {
        synchronized (this.mWritingChannelSet) {
            this.mWritingChannelSet.add(socketChannel);
            Selector selector = this.mSocketSelector;
            if (selector != null) {
                selector.wakeup();
            }
        }
    }

    void runSelectLoop() throws IOException {
        k.h(TAG, "TCP relaying thread started");
        while (this.mRunning) {
            this.mSocketSelector.select();
            Iterator<SelectionKey> it = this.mSocketSelector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                if (!next.isValid()) {
                    k.a(TAG, "Invalid selection key " + next.toString());
                    it.remove();
                } else {
                    try {
                        if (next.isConnectable()) {
                            doConnectWithKey(next);
                        }
                        if (next.isAcceptable()) {
                            doAcceptWithKey(next);
                        }
                        if (!next.isReadable() || doReadWithKey(next) != -1) {
                            if (next.isWritable()) {
                                doWriteWithKey(next);
                            }
                            it.remove();
                        } else {
                            it.remove();
                        }
                    } catch (IOException e10) {
                        k.e(TAG, "Error when operating socket channels", e10);
                        close(next);
                    }
                }
            }
            registerConnectingChannels();
            registerWritingChannels();
            closePendingChannels();
        }
        disconnectAllPendingSockets(this.mListeningChannel);
    }

    public void setup(int i10) throws IOException {
        this.mRunning = true;
        this.mSocketSelector = SelectorProvider.provider().openSelector();
        if (i10 > 0) {
            InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getLocalHost(), i10);
            ServerSocketChannel open = ServerSocketChannel.open();
            this.mListeningChannel = open;
            open.configureBlocking(false);
            this.mListeningChannel.socket().bind(inetSocketAddress);
            this.mListeningChannel.register(this.mSocketSelector, 16);
            k.c(TAG, "Listening to TCP sockets at %s", inetSocketAddress);
        }
        this.mTimestamp = SystemClock.elapsedRealtime();
        this.mIsTicwatch = TicwatchModels.isTicwatch();
    }

    public void shutdown() {
        this.mRunning = false;
        Selector selector = this.mSocketSelector;
        if (selector != null) {
            selector.wakeup();
        }
    }
}
