package com.mobvoi.wear.msgproxy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mobvoi.android.common.utils.k;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class MessageProxyReceiver extends BroadcastReceiver implements MessageProxyListener {
    private static final String TAG = "MessageProxyReceiver";

    public void onConnectedNodesChanged(Context context, List<NodeInfo> list) {
        onConnectedNodesChanged(list);
    }

    public void onConnectedNodesChanged(List<NodeInfo> list) {
    }

    public void onMessageReceived(Context context, MessageInfo messageInfo) {
        onMessageReceived(messageInfo);
    }

    public void onMessageReceived(MessageInfo messageInfo) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (MessageProxyConstants.ACTION_MESSAGE_DISPATCH.equals(action)) {
            onMessageReceived(context, new MessageInfo(intent.getStringExtra(MessageProxyConstants.EXTRA_NODE_ID), intent.getStringExtra(MessageProxyConstants.EXTRA_PATH), intent.getByteArrayExtra(MessageProxyConstants.EXTRA_PAYLOAD)));
        } else if (MessageProxyConstants.ACTION_CONNECTED_NODES_CHANGED.equals(action)) {
            onConnectedNodesChanged(context, intent.getParcelableArrayListExtra(MessageProxyConstants.EXTRA_NODES_LIST));
        } else {
            k.s(TAG, "unknown intent: %s", intent);
        }
    }
}
