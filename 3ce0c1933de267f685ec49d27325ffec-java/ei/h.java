package ei;

import android.content.Context;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.mcuwatch.settings.persistence.DeviceDataSourceImpl;
import mi.a;
import nj.q;
import pk.f;
/* compiled from: McuBtServiceClientManager.java */
/* loaded from: classes2.dex */
public class h implements g {

    /* renamed from: b  reason: collision with root package name */
    private static h f26094b;

    /* renamed from: a  reason: collision with root package name */
    protected g f26095a;

    private h() {
    }

    public static h a() {
        if (f26094b == null) {
            synchronized (h.class) {
                if (f26094b == null) {
                    f26094b = new h();
                }
            }
        }
        return f26094b;
    }

    private void b(Context context, int i10) {
        if (i10 == 5) {
            this.f26095a = e.x();
        } else {
            this.f26095a = f.a();
        }
        this.f26095a.p(context);
    }

    public void c(Context context) {
        if (q.g().l() == -1) {
            k.h("McuBtManager", " getPairingMcuWatchModel = " + q.g().m());
            b(context, q.g().m());
            return;
        }
        k.h("McuBtManager", " getPairedMcuWatchModel = " + q.g().l());
        b(context, q.g().l());
    }

    public void d() {
        j(b.e());
        f a10 = a.a();
        if (a10 != null) {
            DeviceDataSourceImpl.getInstance().deleteDevice(a10.a());
        }
        a.c();
    }

    @Override // ei.g
    public void e(Context context) {
        g gVar = this.f26095a;
        if (gVar != null) {
            gVar.e(context);
        }
    }

    @Override // ei.g
    public void f(Context context) {
        d();
        g gVar = this.f26095a;
        if (gVar != null) {
            gVar.f(context);
        }
    }

    @Override // ei.g
    public void g(Context context, String str) {
        g gVar = this.f26095a;
        if (gVar != null) {
            gVar.g(context, str);
        }
    }

    @Override // ei.g
    public void h() {
        g gVar = this.f26095a;
        if (gVar != null) {
            gVar.h();
        }
    }

    @Override // ei.g
    public void j(Context context) {
        g gVar = this.f26095a;
        if (gVar != null) {
            gVar.j(context);
        }
    }

    @Override // ei.g
    public void l(Context context, String str) {
        g gVar = this.f26095a;
        if (gVar != null) {
            gVar.l(context, str);
        }
    }

    @Override // ei.g
    public boolean n() {
        g gVar = this.f26095a;
        if (gVar == null) {
            return false;
        }
        return gVar.n();
    }

    @Override // ei.g
    public void o(Context context) {
        g gVar = this.f26095a;
        if (gVar != null) {
            gVar.o(context);
        }
    }

    @Override // ei.g
    public void p(Context context) {
        c(context);
    }

    @Override // ei.g
    public fi.a q(String str) {
        g gVar = this.f26095a;
        return gVar == null ? fi.a.a(str) : gVar.q(str);
    }

    @Override // ei.g
    public void r() {
        g gVar = this.f26095a;
        if (gVar != null) {
            gVar.r();
        }
    }

    @Override // ei.g
    public void s() {
        g gVar = this.f26095a;
        if (gVar != null) {
            gVar.s();
        }
    }

    @Override // ei.g
    public boolean t() {
        g gVar = this.f26095a;
        if (gVar == null) {
            return false;
        }
        return gVar.t();
    }
}
