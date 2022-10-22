package com.mobvoi.wear.msgproxy.server;

import com.mobvoi.wear.msgproxy.NodeInfo;
import java.util.List;
/* loaded from: classes2.dex */
public interface WearableClient {
    List<NodeInfo> getConnectedNodes();

    boolean hasConnectedNodes();

    void sendMessage(String str, String str2, byte[] bArr);
}
