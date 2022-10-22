package com.mobvoi.wear.msgproxy;

import java.util.List;
/* loaded from: classes2.dex */
public interface MessageProxyListener {
    void onConnectedNodesChanged(List<NodeInfo> list);

    void onMessageReceived(MessageInfo messageInfo);
}
