package com.mobvoi.wear.msgproxy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.info.IntentInfo;
import com.mobvoi.wear.util.WatchInfoUtils;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class MessageProxyDispatcher {
    private static final String TAG = "MessageProxyDispatcher";
    @SuppressLint({"StaticFieldLeak"})
    private static volatile MessageProxyDispatcher sInstance;
    private Context mAppContext;
    private ArrayList<NodeInfo> mGmsNodes = new ArrayList<>();
    private ArrayList<NodeInfo> mMmsNodes = new ArrayList<>();
    private boolean mIsAwSystem = !WatchInfoUtils.isTicwearSystem();

    private MessageProxyDispatcher(Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    public static MessageProxyDispatcher getInstance(Context context) {
        if (sInstance == null) {
            synchronized (MessageProxyDispatcher.class) {
                if (sInstance == null) {
                    sInstance = new MessageProxyDispatcher(context);
                }
            }
        }
        return sInstance;
    }

    @SuppressLint({"WrongConstant"})
    private void sendBroadcast(Intent intent) {
        intent.setFlags(IntentInfo.FLAG_RECEIVER_INCLUDE_BACKGROUND);
        if (MessageProxyClient.getInstance().isStandalone()) {
            intent.setPackage(this.mAppContext.getPackageName());
            this.mAppContext.sendBroadcast(intent);
            return;
        }
        this.mAppContext.sendBroadcast(intent, MessageProxyConstants.PERM_WEAR_MPS);
    }

    public void onConnectedNodesChanged(int i10, ArrayList<NodeInfo> arrayList) {
        ArrayList<NodeInfo> arrayList2;
        k.c(TAG, "onConnectedNodesChanged, gmsNodes: %s, mmsNodes: %s, nodeType: %d, nodes: %s", this.mGmsNodes, this.mMmsNodes, Integer.valueOf(i10), arrayList);
        if (i10 == 1) {
            arrayList2 = new ArrayList<>(this.mMmsNodes);
            arrayList2.addAll(arrayList);
            this.mGmsNodes = arrayList;
        } else {
            if (i10 == 2) {
                arrayList2 = new ArrayList<>(this.mGmsNodes);
                arrayList2.addAll(arrayList);
                this.mMmsNodes = arrayList;
            }
            Intent intent = new Intent(MessageProxyConstants.ACTION_CONNECTED_NODES_CHANGED);
            intent.putParcelableArrayListExtra(MessageProxyConstants.EXTRA_NODES_LIST, arrayList);
            sendBroadcast(intent);
        }
        arrayList = arrayList2;
        Intent intent2 = new Intent(MessageProxyConstants.ACTION_CONNECTED_NODES_CHANGED);
        intent2.putParcelableArrayListExtra(MessageProxyConstants.EXTRA_NODES_LIST, arrayList);
        sendBroadcast(intent2);
    }

    public void onMessageReceived(String str, String str2, byte[] bArr) {
        Intent data = new Intent(MessageProxyConstants.ACTION_MESSAGE_DISPATCH).putExtra(MessageProxyConstants.EXTRA_NODE_ID, str).putExtra(MessageProxyConstants.EXTRA_PATH, str2).putExtra(MessageProxyConstants.EXTRA_PAYLOAD, bArr).setData(new Uri.Builder().scheme("wear").authority(MessageProxyConstants.MESSAGE_DISPATCH_DATA_HOST).path(str2).build());
        if (this.mIsAwSystem && str2.startsWith(WearPath.Speech.SPEECH) && !MessageProxyClient.getInstance().isStandalone()) {
            data.setPackage("com.mobvoi.ticwear.sidewearvoicesearch");
            this.mAppContext.sendBroadcast(data);
        } else if (!this.mIsAwSystem || !str2.startsWith(WearPath.Lpa.PREFIX) || MessageProxyClient.getInstance().isStandalone()) {
            sendBroadcast(data);
        } else {
            data.setPackage("com.mobvoi.wear.lpa.aw");
            this.mAppContext.sendBroadcast(data);
        }
    }
}
