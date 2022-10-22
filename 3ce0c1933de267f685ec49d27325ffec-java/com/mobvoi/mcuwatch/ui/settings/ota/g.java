package com.mobvoi.mcuwatch.ui.settings.ota;

import android.content.SharedPreferences;
import androidx.lifecycle.w;
import com.mobvoi.mcuwatch.engine.d;
import com.mobvoi.mcuwatch.engine.n;
import com.mobvoi.mcuwatch.engine.u;
import com.mobvoi.mcuwatch.ui.settings.ota.f;
import gn.q;
import kotlin.jvm.internal.i;
/* compiled from: GtBleUpdate.kt */
/* loaded from: classes2.dex */
public final class g implements f, d, n.a {

    /* renamed from: a  reason: collision with root package name */
    private f.a f20134a;

    /* renamed from: b  reason: collision with root package name */
    private final int f20135b = 50;

    /* renamed from: c  reason: collision with root package name */
    private final w<String> f20136c = new w<>();

    public g() {
        u uVar = u.f19202a;
        uVar.d0(this);
        uVar.Y();
        n.f19178a.K("key_ble_server_version", this);
        i().m(k());
    }

    private final String k() {
        String f10 = n.f19178a.f();
        if (f10 == null || f10.length() == 0) {
            return null;
        }
        String str = "";
        if (!i.b(q.f27589h, str) && !i.b(q.f27589h, "00000")) {
            str = i.n("_", q.f27589h);
        }
        return i.n(f10, str);
    }

    @Override // com.mobvoi.mcuwatch.engine.n.a
    public void U(SharedPreferences sharedPreferences, String key) {
        i.f(key, "key");
        if (i.b("key_ble_server_version", key)) {
            i().o(k());
        }
    }

    @Override // com.mobvoi.mcuwatch.ui.settings.ota.f
    public String a() {
        n nVar = n.f19178a;
        return i.n(nVar.s(), nVar.n().length() == 0 ? "" : i.n("_", nVar.n()));
    }

    @Override // com.mobvoi.mcuwatch.engine.d
    public void b(int i10) {
        f.a aVar = this.f20134a;
        if (aVar != null) {
            aVar.b(i10);
        }
    }

    @Override // com.mobvoi.mcuwatch.ui.settings.ota.f
    public int c() {
        return this.f20135b;
    }

    @Override // com.mobvoi.mcuwatch.ui.settings.ota.f
    public boolean d() {
        return n.f19178a.z();
    }

    @Override // com.mobvoi.mcuwatch.engine.d
    public void e() {
        f.a aVar = this.f20134a;
        if (aVar != null) {
            aVar.d(6);
        }
    }

    @Override // com.mobvoi.mcuwatch.engine.d
    public void f(boolean z10) {
        int i10 = z10 ? 4 : 5;
        f.a aVar = this.f20134a;
        if (aVar != null) {
            aVar.d(i10);
        }
    }

    @Override // com.mobvoi.mcuwatch.ui.settings.ota.f
    public void g(f.a aVar) {
        this.f20134a = aVar;
    }

    @Override // com.mobvoi.mcuwatch.engine.d
    public void h() {
        f.a aVar = this.f20134a;
        if (aVar != null) {
            aVar.d(3);
        }
    }

    @Override // com.mobvoi.mcuwatch.ui.settings.ota.f
    public w<String> i() {
        return this.f20136c;
    }

    @Override // com.mobvoi.mcuwatch.ui.settings.ota.f
    public void j() {
        u.f19202a.o0();
    }

    @Override // com.mobvoi.mcuwatch.ui.settings.ota.f
    public void release() {
        u uVar = u.f19202a;
        uVar.d0(null);
        uVar.q0();
        n.f19178a.o0("key_ble_server_version", this);
        this.f20134a = null;
    }
}
