package com.mobvoi.wear.msgproxy;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.RemoteException;
import android.util.Pair;
import com.mobvoi.android.common.ipc.a;
import com.mobvoi.android.common.ipc.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.o;
import com.mobvoi.android.common.utils.t;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class MessageProxyClient extends t<MessageProxyListener> implements a {
    private static final byte[] EMPTY_PAYLOAD = new byte[0];
    private static final String TAG = "MessageProxyClient";
    @SuppressLint({"StaticFieldLeak"})
    private static volatile MessageProxyClient sInstance;
    private Context mAppContext;
    private MessageProxyServiceClient mServiceClient;
    private boolean mStandalone = false;
    private List<Pair<String, Integer>> mMessagePathFilters = new ArrayList();
    private AtomicBoolean mConnectReceiverRegistered = new AtomicBoolean(false);
    private final Queue<MessageInfo> mPendingMessages = new ConcurrentLinkedQueue();
    private BroadcastReceiver mMessageReceiver = new MessageProxyReceiver() { // from class: com.mobvoi.wear.msgproxy.MessageProxyClient.2
        @Override // com.mobvoi.wear.msgproxy.MessageProxyReceiver, com.mobvoi.wear.msgproxy.MessageProxyListener
        public void onConnectedNodesChanged(final List<NodeInfo> list) {
            k.c(MessageProxyClient.TAG, "onConnectedNodesChanged: %s", list);
            MessageProxyClient.this.notifyListeners(new t.b<MessageProxyListener>() { // from class: com.mobvoi.wear.msgproxy.MessageProxyClient.2.1
                public void notify(MessageProxyListener messageProxyListener) {
                    messageProxyListener.onConnectedNodesChanged(list);
                }
            });
            if (list.size() > 0) {
                b.b().post(new Runnable() { // from class: com.mobvoi.wear.msgproxy.MessageProxyClient.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageProxyClient.this.sendPendingMessages();
                    }
                });
            }
        }

        @Override // com.mobvoi.wear.msgproxy.MessageProxyReceiver, com.mobvoi.wear.msgproxy.MessageProxyListener
        public void onMessageReceived(final MessageInfo messageInfo) {
            k.c(MessageProxyClient.TAG, "onMessageReceived: %s", messageInfo);
            MessageProxyClient.this.notifyListeners(new t.b<MessageProxyListener>() { // from class: com.mobvoi.wear.msgproxy.MessageProxyClient.2.3
                public void notify(MessageProxyListener messageProxyListener) {
                    messageProxyListener.onMessageReceived(messageInfo);
                }
            });
        }
    };

    private MessageProxyClient() {
        Application e10 = com.mobvoi.android.common.utils.b.e();
        this.mAppContext = e10;
        MessageProxyServiceClient messageProxyServiceClient = new MessageProxyServiceClient(e10);
        this.mServiceClient = messageProxyServiceClient;
        messageProxyServiceClient.addListener(this);
    }

    public static MessageProxyClient getInstance() {
        if (sInstance == null) {
            synchronized (MessageProxyClient.class) {
                if (sInstance == null) {
                    sInstance = new MessageProxyClient();
                }
            }
        }
        return sInstance;
    }

    private void registerConnectReceiver() {
        if (this.mConnectReceiverRegistered.compareAndSet(false, true)) {
            k.h(TAG, "add connect change receiver");
            IntentFilter intentFilter = new IntentFilter(MessageProxyConstants.ACTION_CONNECTED_NODES_CHANGED);
            if (this.mStandalone) {
                this.mAppContext.registerReceiver(this.mMessageReceiver, intentFilter);
            } else {
                this.mAppContext.registerReceiver(this.mMessageReceiver, intentFilter, MessageProxyConstants.PERM_WEAR_MPS, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPendingMessages() {
        MessageInfo poll;
        k.c(TAG, "sendPendingMessages: %d", Integer.valueOf(this.mPendingMessages.size()));
        while (isProxyServiceConnected() && (poll = this.mPendingMessages.poll()) != null) {
            sendMessage(poll);
        }
        k.c(TAG, "sendPendingMessages done: %d", Integer.valueOf(this.mPendingMessages.size()));
    }

    public void addConnectListener(a aVar) {
        this.mServiceClient.addListener(aVar);
    }

    public void connectProxyService() {
        if (!isProxyServiceConnected()) {
            this.mServiceClient.connect();
        } else {
            k.a(TAG, "already connected");
        }
    }

    public List<NodeInfo> getConnectedNodes() throws MessageProxyException {
        IMessageProxyService service = this.mServiceClient.getService();
        if (service == null || !service.asBinder().isBinderAlive()) {
            connectProxyService();
            throw new MessageProxyException("MessageProxyService not connected");
        }
        try {
            return service.getConnectedNodes();
        } catch (RemoteException e10) {
            throw new MessageProxyException(e10);
        }
    }

    public boolean hasConnectedNodes() throws MessageProxyException {
        IMessageProxyService service = this.mServiceClient.getService();
        if (service == null || !service.asBinder().isBinderAlive()) {
            connectProxyService();
            throw new MessageProxyException("MessageProxyService not connected");
        }
        try {
            return service.hasConnectedNodes();
        } catch (RemoteException e10) {
            throw new MessageProxyException(e10);
        }
    }

    public boolean isProxyServiceConnected() {
        IMessageProxyService service = this.mServiceClient.getService();
        return service != null && service.asBinder().isBinderAlive();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isStandalone() {
        return this.mStandalone;
    }

    @Override // com.mobvoi.android.common.utils.t
    protected void onFirstListenerAdd() {
        k.h(TAG, "add message receiver");
        if (!this.mMessagePathFilters.isEmpty()) {
            IntentFilter intentFilter = new IntentFilter(MessageProxyConstants.ACTION_MESSAGE_DISPATCH);
            intentFilter.addDataScheme("wear");
            intentFilter.addDataAuthority(MessageProxyConstants.MESSAGE_DISPATCH_DATA_HOST, null);
            for (Pair<String, Integer> pair : this.mMessagePathFilters) {
                intentFilter.addDataPath((String) pair.first, ((Integer) pair.second).intValue());
            }
            if (this.mStandalone) {
                this.mAppContext.registerReceiver(this.mMessageReceiver, intentFilter);
            } else {
                this.mAppContext.registerReceiver(this.mMessageReceiver, intentFilter, MessageProxyConstants.PERM_WEAR_MPS, null);
            }
        } else {
            k.q(TAG, "No message path filters provided, cannot receive messages");
        }
        registerConnectReceiver();
    }

    @Override // com.mobvoi.android.common.utils.t
    protected void onLastListenerRemoved() {
        k.h(TAG, "onLastListenerRemoved");
    }

    @Override // com.mobvoi.android.common.ipc.a
    public void onStateChanged(int i10) {
        k.i(TAG, "MPS connect state changed: %d", Integer.valueOf(i10));
        if (i10 == 3) {
            b.b().post(new Runnable() { // from class: com.mobvoi.wear.msgproxy.MessageProxyClient.1
                @Override // java.lang.Runnable
                public void run() {
                    MessageProxyClient.this.sendPendingMessages();
                }
            });
        }
    }

    public void registerMessagePath(String str, int i10) {
        o.b(str.startsWith("/"), "path must start with '/'");
        boolean z10 = true;
        if (!(i10 == 0 || i10 == 1)) {
            z10 = false;
        }
        o.b(z10, "not supported pattern type: " + i10);
        this.mMessagePathFilters.add(new Pair<>(str, Integer.valueOf(i10)));
    }

    public void removeConnectListener(a aVar) {
        this.mServiceClient.removeListener(aVar);
    }

    public void sendMessage(String str) {
        sendMessage(MessageProxyConstants.NODE_ID_ANY, str, EMPTY_PAYLOAD);
    }

    public void setStandalone(boolean z10) {
        k.i(TAG, "enabled standalone: %s", Boolean.valueOf(z10));
        this.mStandalone = z10;
    }

    public void waitForProxyServiceConnected() {
        this.mServiceClient.waitForConnected();
    }

    public void sendMessage(String str, byte[] bArr) {
        sendMessage(MessageProxyConstants.NODE_ID_ANY, str, bArr);
    }

    public void waitForProxyServiceConnected(long j10) {
        this.mServiceClient.waitForConnected(j10);
    }

    public void sendMessage(String str, String str2, byte[] bArr) {
        IMessageProxyService service = this.mServiceClient.getService();
        if (service == null || !service.asBinder().isBinderAlive()) {
            k.a(TAG, "MPS not available, put the message into pending queue");
            connectProxyService();
            this.mPendingMessages.add(new MessageInfo(str, str2, bArr));
            registerConnectReceiver();
            return;
        }
        try {
            service.sendMessage(str, str2, bArr);
        } catch (RemoteException e10) {
            k.r(TAG, "Failed to send message", e10, new Object[0]);
            this.mPendingMessages.add(new MessageInfo(str, str2, bArr));
            registerConnectReceiver();
        }
    }

    public void sendMessage(MessageInfo messageInfo) {
        sendMessage(messageInfo.getNodeId(), messageInfo.getPath(), messageInfo.getPayload());
    }
}
