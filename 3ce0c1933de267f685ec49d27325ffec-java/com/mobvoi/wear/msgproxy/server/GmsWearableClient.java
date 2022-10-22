package com.mobvoi.wear.msgproxy.server;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.wearable.a;
import com.google.android.gms.wearable.b;
import com.google.android.gms.wearable.j;
import com.google.android.gms.wearable.k;
import com.google.android.gms.wearable.l;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.msgproxy.MessageInfo;
import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import com.mobvoi.wear.msgproxy.MessageProxyDispatcher;
import com.mobvoi.wear.msgproxy.NodeInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes2.dex */
public class GmsWearableClient implements d.b, d.c, WearableClient {
    private static final long CONNECTING_TIMEOUT = 30000;
    private static final int MAX_PENDING_QUEUE_SIZE = 100;
    private static final String TAG = "GmsWearableClient";
    @SuppressLint({"StaticFieldLeak"})
    private static volatile GmsWearableClient sInstance;
    private final Context mAppContext;
    private boolean mConnectedNodesInitialized;
    private final d mGoogleApiClient;
    private NodeInfo mLocalNode;
    private ArrayList<NodeInfo> mConnectedNodes = new ArrayList<>();
    private final Queue<MessageInfo> mPendingMessages = new ConcurrentLinkedQueue();
    private final Runnable mReconnectTask = new Runnable() { // from class: com.mobvoi.wear.msgproxy.server.h
        @Override // java.lang.Runnable
        public final void run() {
            GmsWearableClient.this.reconnectIfNeeded();
        }
    };
    private final Runnable mConnectingTimeoutTask = new Runnable() { // from class: com.mobvoi.wear.msgproxy.server.GmsWearableClient.1
        {
            GmsWearableClient.this = this;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GmsWearableClient.this.mConnectState == 2) {
                GmsWearableClient.this.mConnectState = 1;
            }
        }
    };
    private int mConnectState = 2;

    private GmsWearableClient(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mAppContext = applicationContext;
        d e10 = new d.a(applicationContext).a(l.f10318f).c(this).d(this).e();
        this.mGoogleApiClient = e10;
        e10.f();
    }

    private boolean checkNodeConnected(ArrayList<NodeInfo> arrayList, String str) {
        Iterator<NodeInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<NodeInfo> convertNodes(Set<j> set) {
        ArrayList<NodeInfo> arrayList = new ArrayList<>(set.size());
        int remoteNodeType = getRemoteNodeType();
        for (j jVar : set) {
            arrayList.add(new NodeInfo(remoteNodeType, jVar.getId(), jVar.Q(), jVar.j0()));
        }
        return arrayList;
    }

    public static GmsWearableClient getInstance(Context context) {
        if (sInstance == null) {
            synchronized (GmsWearableClient.class) {
                if (sInstance == null) {
                    sInstance = new GmsWearableClient(context);
                }
            }
        }
        return sInstance;
    }

    private static int getLocalNodeType() {
        int deviceType = MpsConfig.getInstance().getDeviceType();
        if (deviceType == 1) {
            return 3;
        }
        return deviceType == 2 ? 1 : -1;
    }

    private static int getRemoteNodeType() {
        int deviceType = MpsConfig.getInstance().getDeviceType();
        if (deviceType == 1) {
            return 1;
        }
        return deviceType == 2 ? 3 : -1;
    }

    public /* synthetic */ void lambda$onConnected$0(a.b bVar) {
        b h02 = bVar.h0();
        k.c(TAG, "get capability result: %s", h02);
        if (h02 != null) {
            Set<j> d10 = h02.d();
            if (d10 == null || d10.isEmpty()) {
                refreshNodesIfCapabilityNotFound();
                return;
            }
            updateConnectedNodes(h02.d());
            onNodesInitialized();
        }
    }

    public /* synthetic */ void lambda$onConnected$1(k.b bVar) {
        j k02 = bVar.k0();
        com.mobvoi.android.common.utils.k.c(TAG, "local node: %s", k02);
        if (k02 != null) {
            this.mLocalNode = new NodeInfo(getLocalNodeType(), k02.getId(), k02.Q(), k02.j0());
        }
    }

    public /* synthetic */ void lambda$refreshNodesIfCapabilityNotFound$2(k.a aVar) {
        updateConnectedNodes(new HashSet(aVar.d()));
        onNodesInitialized();
    }

    private void onNodesInitialized() {
        this.mConnectedNodesInitialized = true;
        com.mobvoi.android.common.ipc.b.b().post(new g(this));
    }

    private void postReconnectTaskIfNeeded() {
        if (this.mConnectState == 1) {
            com.mobvoi.android.common.utils.l.a().removeCallbacks(this.mReconnectTask);
            com.mobvoi.android.common.utils.l.a().post(this.mReconnectTask);
        }
    }

    public void reconnectIfNeeded() {
        if (this.mConnectState == 1) {
            com.mobvoi.android.common.utils.k.a(TAG, "try to reconnect");
            com.mobvoi.android.common.utils.l.a().removeCallbacks(this.mConnectingTimeoutTask);
            com.mobvoi.android.common.utils.l.a().postDelayed(this.mConnectingTimeoutTask, 30000L);
            this.mConnectState = 2;
            this.mGoogleApiClient.s();
        }
    }

    private void refreshNodesIfCapabilityNotFound() {
        com.mobvoi.android.common.utils.k.a(TAG, "refreshNodesIfCapabilityNotFound");
        l.f10315c.a(this.mGoogleApiClient).e(new i() { // from class: com.mobvoi.wear.msgproxy.server.e
            @Override // com.google.android.gms.common.api.i
            public final void a(h hVar) {
                GmsWearableClient.this.lambda$refreshNodesIfCapabilityNotFound$2((k.a) hVar);
            }
        });
    }

    public void sendPendingMessages() {
        MessageInfo poll;
        com.mobvoi.android.common.utils.k.c(TAG, "sendPendingMessages: %d", Integer.valueOf(this.mPendingMessages.size()));
        while (this.mConnectState == 3 && this.mConnectedNodesInitialized && (poll = this.mPendingMessages.poll()) != null) {
            sendMessage(poll.getNodeId(), poll.getPath(), poll.getPayload());
        }
        com.mobvoi.android.common.utils.k.c(TAG, "sendPendingMessages done: %d", Integer.valueOf(this.mPendingMessages.size()));
    }

    @Override // com.mobvoi.wear.msgproxy.server.WearableClient
    public List<NodeInfo> getConnectedNodes() {
        postReconnectTaskIfNeeded();
        return this.mConnectedNodes;
    }

    public NodeInfo getLocalNode() {
        return this.mLocalNode;
    }

    @Override // com.mobvoi.wear.msgproxy.server.WearableClient
    public boolean hasConnectedNodes() {
        postReconnectTaskIfNeeded();
        return this.mConnectedNodes.size() > 0;
    }

    @Override // com.google.android.gms.common.api.d.b
    public void onConnected(Bundle bundle) {
        com.mobvoi.android.common.utils.k.h(TAG, "GMS connected");
        this.mConnectState = 3;
        String peerNodeCapability = MpsConfig.getInstance().getPeerNodeCapability();
        if (!TextUtils.isEmpty(peerNodeCapability)) {
            l.f10313a.a(this.mGoogleApiClient, peerNodeCapability, 1).e(new i() { // from class: com.mobvoi.wear.msgproxy.server.d
                @Override // com.google.android.gms.common.api.i
                public final void a(h hVar) {
                    GmsWearableClient.this.lambda$onConnected$0((a.b) hVar);
                }
            });
        } else {
            com.mobvoi.android.common.utils.k.q(TAG, "No expected capability. Cannot get connected nodes.");
        }
        l.f10315c.b(this.mGoogleApiClient).e(new i() { // from class: com.mobvoi.wear.msgproxy.server.f
            @Override // com.google.android.gms.common.api.i
            public final void a(h hVar) {
                GmsWearableClient.this.lambda$onConnected$1((k.b) hVar);
            }
        });
        com.mobvoi.android.common.ipc.b.b().post(new g(this));
    }

    @Override // com.google.android.gms.common.api.d.c
    public void onConnectionFailed(ConnectionResult connectionResult) {
        com.mobvoi.android.common.utils.k.h(TAG, "GMS connect failed: " + connectionResult);
        this.mConnectState = 1;
    }

    @Override // com.google.android.gms.common.api.d.b
    public void onConnectionSuspended(int i10) {
        com.mobvoi.android.common.utils.k.h(TAG, "GMS connection suspended: " + i10);
        com.mobvoi.android.common.utils.l.a().removeCallbacks(this.mConnectingTimeoutTask);
        com.mobvoi.android.common.utils.l.a().postDelayed(this.mConnectingTimeoutTask, 30000L);
        this.mConnectState = 2;
    }

    @Override // com.mobvoi.wear.msgproxy.server.WearableClient
    public void sendMessage(String str, String str2, byte[] bArr) {
        if (this.mConnectState != 3 || !this.mConnectedNodesInitialized) {
            if (this.mPendingMessages.size() >= 100) {
                com.mobvoi.android.common.utils.k.c(TAG, "Discard oldest message: %s", this.mPendingMessages.poll().getPath());
            }
            com.mobvoi.android.common.utils.k.a(TAG, "GMS not connected, put the message into pending queue");
            this.mPendingMessages.add(new MessageInfo(str, str2, bArr));
            postReconnectTaskIfNeeded();
            return;
        }
        ArrayList<NodeInfo> arrayList = this.mConnectedNodes;
        com.mobvoi.android.common.utils.k.c(TAG, "sendMessage, nodeId=[%s], path=[%s], nodes=%s", str, str2, arrayList);
        if (str.equals(MessageProxyConstants.NODE_ID_ANY)) {
            Iterator<NodeInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                l.f10314b.a(this.mGoogleApiClient, it.next().getId(), str2, bArr);
            }
        } else if (checkNodeConnected(arrayList, str)) {
            l.f10314b.a(this.mGoogleApiClient, str, str2, bArr);
        } else {
            com.mobvoi.android.common.utils.k.c(TAG, "skip message, nodeId: %s, path: %s", str, str2);
        }
    }

    public void updateConnectedNodes(Set<j> set) {
        ArrayList<NodeInfo> convertNodes = convertNodes(set);
        this.mConnectedNodes = convertNodes;
        com.mobvoi.android.common.utils.k.c(TAG, "updateConnectedNodes: %s", convertNodes);
        MessageProxyDispatcher.getInstance(this.mAppContext).onConnectedNodesChanged(getRemoteNodeType(), this.mConnectedNodes);
    }
}
