package ub;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.mobvoi.companion.wear.WearNode;
import com.mobvoi.companion.wear.WearPairingPool;
import com.mobvoi.wear.common.base.TicwatchModels;
import com.mobvoi.wear.info.WearInfo;
import java.util.ArrayList;
import java.util.List;
import pc.g;
import qk.a;
import vb.b;
import vb.c;
/* compiled from: ITicWatchDeviceManager.java */
/* loaded from: classes2.dex */
public abstract class e implements a, WearPairingPool.f {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f35362b = false;

    /* renamed from: a  reason: collision with root package name */
    protected Context f35363a;

    public e(Application application) {
        this.f35363a = application.getApplicationContext();
        c.i().e(this.f35363a);
        WearPairingPool.i().c(this);
        if (e()) {
            i();
        }
    }

    private void i() {
        if (!f35362b) {
            h();
            f35362b = true;
        }
    }

    @Override // qk.a
    public rk.a b() {
        return null;
    }

    @Override // qk.a
    public List<qk.c> d() {
        ArrayList arrayList = new ArrayList();
        if (e()) {
            List<WearNode> g10 = WearPairingPool.i().g();
            if (!g10.isEmpty()) {
                for (WearNode wearNode : g10) {
                    WearInfo c10 = com.mobvoi.companion.wear.a.f().c(wearNode.nodeId);
                    g gVar = new g();
                    gVar.f32752a = wearNode.deviceId;
                    gVar.f32754c = wearNode.nodeName;
                    if (c10 != null) {
                        gVar.f32755d = c10.btAddress;
                        gVar.f32753b = TicwatchModels.getFixedModel(c10.region, c10.wearType);
                    }
                    arrayList.add(gVar);
                }
            }
        }
        return arrayList;
    }

    @Override // qk.a
    public boolean e() {
        return !WearPairingPool.i().l() && !TextUtils.isEmpty(ta.a.x());
    }

    @Override // qk.a
    public void f(int i10) {
        if (!e()) {
            i();
        }
        b.f(this.f35363a);
    }

    public List<WearNode> g() {
        if (e()) {
            return WearPairingPool.i().g();
        }
        return null;
    }

    @Override // qk.a
    public String getDeviceType() {
        return "android_wear";
    }

    protected void h() {
        c.i().j(this.f35363a);
        c.i().d(this.f35363a);
        xd.c.x().C();
        ic.b.a((ic.c) kc.b.b().a(ic.c.class));
    }

    @Override // com.mobvoi.companion.wear.WearPairingPool.f
    public void l(List<WearNode> list, String str) {
        if (list.size() > 0) {
            i();
        }
    }
}
