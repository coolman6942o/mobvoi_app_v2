package yd;

import android.text.TextUtils;
import com.mobvoi.companion.wear.WearNode;
import com.mobvoi.companion.wear.WearPairingPool;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyException;
import com.mobvoi.wear.msgproxy.NodeInfo;
/* compiled from: TicConnectUtils.java */
/* loaded from: classes2.dex */
public class k {
    @Deprecated
    public static boolean a() {
        try {
            String h10 = WearPairingPool.i().h();
            for (NodeInfo nodeInfo : MessageProxyClient.getInstance().getConnectedNodes()) {
                com.mobvoi.android.common.utils.k.a("TicConnectUtils", "currentNodeId == " + h10 + ", deviceNodeId == " + nodeInfo.getId());
                if (h10.equals(nodeInfo.getId())) {
                    return true;
                }
            }
            return false;
        } catch (MessageProxyException e10) {
            com.mobvoi.android.common.utils.k.e("TicConnectUtils", "message proxy error, ", e10);
            return false;
        }
    }

    public static boolean b(WearNode wearNode) {
        if (wearNode != null) {
            try {
                if (!TextUtils.isEmpty(wearNode.nodeId)) {
                    String str = wearNode.nodeId;
                    for (NodeInfo nodeInfo : MessageProxyClient.getInstance().getConnectedNodes()) {
                        if (str.equals(nodeInfo.getId())) {
                            return true;
                        }
                    }
                    return false;
                }
            } catch (MessageProxyException e10) {
                com.mobvoi.android.common.utils.k.e("TicConnectUtils", "message proxy error, ", e10);
            }
        }
        return false;
    }

    public static boolean c(String str) {
        try {
            for (NodeInfo nodeInfo : MessageProxyClient.getInstance().getConnectedNodes()) {
                com.mobvoi.android.common.utils.k.a("TicConnectUtils", "currentNodeId == " + str + ", deviceNodeId == " + nodeInfo.getId());
                if (TextUtils.equals(str, nodeInfo.getId())) {
                    return true;
                }
            }
            return false;
        } catch (MessageProxyException e10) {
            com.mobvoi.android.common.utils.k.e("TicConnectUtils", "message proxy error, ", e10);
            return false;
        }
    }
}
