package vb;

import android.content.Context;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.wear.WearNode;
import com.mobvoi.companion.wear.WearPairingPool;
import com.mobvoi.companion.wear.a;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import fg.f;
import java.util.ArrayList;
import java.util.List;
import nf.m;
/* compiled from: TicWatchManagerImpl.java */
/* loaded from: classes2.dex */
public class c extends tb.c implements WearPairingPool.f {

    /* renamed from: b  reason: collision with root package name */
    private static volatile c f35709b;

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f35710c = new byte[0];

    private c() {
        new ArrayList();
        new m();
    }

    public static c i() {
        if (f35709b == null) {
            synchronized (tb.c.class) {
                if (f35709b == null) {
                    f35709b = new c();
                }
            }
        }
        return f35709b;
    }

    @Override // tb.c
    public void e(Context context) {
        super.e(context);
        WearPairingPool.i().c(this);
    }

    public WearNode h() {
        String h10 = WearPairingPool.i().h();
        List<WearNode> g10 = WearPairingPool.i().g();
        if (TextUtils.isEmpty(h10) || g10 == null || g10.size() <= 0) {
            return null;
        }
        for (int i10 = 0; i10 < g10.size(); i10++) {
            WearNode wearNode = g10.get(i10);
            if (wearNode != null && h10.equals(wearNode.nodeId)) {
                return wearNode;
            }
        }
        return null;
    }

    public void j(Context context) {
    }

    public void k() {
        f.b(this.f35107a);
    }

    @Override // com.mobvoi.companion.wear.WearPairingPool.f
    public void l(List<WearNode> list, String str) {
        if (list.size() > 0) {
            for (WearNode wearNode : list) {
                if (!wearNode.persisted) {
                    WearPairingPool.i().o(this.f35107a, wearNode.nodeId);
                }
                if (wearNode.connectionState != WearPairingPool.ConnectionState.Disconnected && wearNode.batteryLevel < 0) {
                    k.c("TicWatchManagerImpl", "Battery level not init for %s, send a sync", wearNode.nodeId);
                    MessageProxyClient.getInstance().sendMessage(wearNode.nodeId, WearPath.Companion.SYNC_WEAR_BATTERY, f35710c);
                }
                if (a.f().c(wearNode.nodeId) == null) {
                    k.c("TicWatchManagerImpl", "WearInfo not init for %s, send a sync", wearNode.nodeId);
                    MessageProxyClient.getInstance().sendMessage(wearNode.nodeId, WearPath.Companion.SYNC_WEAR_INFO, f35710c);
                }
            }
        }
    }
}
