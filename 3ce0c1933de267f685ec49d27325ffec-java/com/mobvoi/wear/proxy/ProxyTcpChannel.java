package com.mobvoi.wear.proxy;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class ProxyTcpChannel {
    private final SocketChannel mChannel;
    private final int mStreamId;
    private final LinkedList<ByteBuffer> mBuffer = new LinkedList<>();
    private final AtomicBoolean mIsOtherNodeClosed = new AtomicBoolean(false);
    private long mLastReceivedSeqNum = -1;
    private long mLastSentSeqNum = -1;
    private long mBytesSent = 0;
    private long mBytesReceived = 0;

    public ProxyTcpChannel(SocketChannel socketChannel, int i10) {
        this.mChannel = socketChannel;
        this.mStreamId = i10;
    }

    void appendWrite(ByteBuffer byteBuffer) {
        synchronized (this.mBuffer) {
            this.mBuffer.add(byteBuffer);
        }
    }

    long getBytesReceived() {
        return this.mBytesReceived;
    }

    long getBytesSent() {
        return this.mBytesSent;
    }

    boolean getIsOtherNodeClosed() {
        return this.mIsOtherNodeClosed.get();
    }

    long getNextExpectedReceivedSeqNum() {
        long j10 = this.mLastReceivedSeqNum;
        if (j10 < 0) {
            return 0L;
        }
        return 1 + j10;
    }

    long getNextSentSeqNum() {
        long j10 = this.mLastSentSeqNum;
        if (j10 < 0) {
            return 0L;
        }
        return 1 + j10;
    }

    public SocketChannel getSocketChannel() {
        return this.mChannel;
    }

    int getStreamId() {
        return this.mStreamId;
    }

    boolean hasPendingWrites() {
        boolean z10;
        synchronized (this.mBuffer) {
            z10 = !this.mBuffer.isEmpty();
        }
        return z10;
    }

    void setBytesReceived(long j10) {
        this.mBytesReceived = j10;
    }

    void setBytesSent(long j10) {
        this.mBytesSent = j10;
    }

    void setIsOtherNodeClosed() {
        this.mIsOtherNodeClosed.set(true);
    }

    void setLastReceivedSeqNum(long j10) {
        this.mLastReceivedSeqNum = j10;
    }

    void setLastSentSeqNum(long j10) {
        this.mLastSentSeqNum = j10;
    }

    int writeNow() throws IOException {
        int i10;
        synchronized (this.mBuffer) {
            i10 = 0;
            while (!this.mBuffer.isEmpty()) {
                ByteBuffer first = this.mBuffer.getFirst();
                i10 += this.mChannel.write(first);
                if (first.hasRemaining()) {
                    break;
                }
                this.mBuffer.removeFirst();
            }
        }
        return i10;
    }
}
