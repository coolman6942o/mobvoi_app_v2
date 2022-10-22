package ei;

import android.annotation.SuppressLint;
import android.content.Context;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.mcuwatch.engine.s;
import com.mobvoi.mcuwatch.engine.u;
import com.mobvoi.mcuwatch.pair.service.DataSyncService;
import fi.a;
/* compiled from: GtWatchServiceClient.java */
/* loaded from: classes2.dex */
public class f implements g {

    /* renamed from: b  reason: collision with root package name */
    private static final f f26092b = new f();

    /* renamed from: a  reason: collision with root package name */
    protected u f26093a;

    public static f a() {
        return f26092b;
    }

    @Override // ei.g
    public void e(Context context) {
        DataSyncService.w(context);
    }

    @Override // ei.g
    public void f(Context context) {
        u uVar = u.f19202a;
        com.mobvoi.mcuwatch.engine.f.d(uVar);
        uVar.B();
        uVar.r0();
    }

    @Override // ei.g
    @SuppressLint({"MissingPermission"})
    public void g(Context context, String str) {
        DataSyncService.l(context, str);
    }

    @Override // ei.g
    public void h() {
        com.mobvoi.mcuwatch.engine.f.d(u.f19202a);
    }

    @Override // ei.g
    public void j(Context context) {
        DataSyncService.s(context);
    }

    @Override // ei.g
    @SuppressLint({"MissingPermission"})
    public void l(Context context, String str) {
        int c10 = this.f26093a.x(str).c();
        k.c("TAG", "startConnect %d", Integer.valueOf(c10));
        if (c10 != 1) {
            DataSyncService.l(context, str);
        }
    }

    @Override // ei.g
    public boolean n() {
        return u.f19202a.T();
    }

    @Override // ei.g
    @SuppressLint({"MissingPermission"})
    public void o(Context context) {
        DataSyncService.p(context);
    }

    @Override // ei.g
    public void p(Context context) {
        u uVar = u.f19202a;
        uVar.Q(context);
        this.f26093a = uVar;
    }

    @Override // ei.g
    public a q(String str) {
        return u.f19202a.x(str);
    }

    @Override // ei.g
    public void r() {
        s.f19186a.p(111);
    }

    @Override // ei.g
    public void s() {
        com.mobvoi.mcuwatch.engine.f.a(u.f19202a);
    }

    @Override // ei.g
    public boolean t() {
        u uVar = u.f19202a;
        uVar.w();
        if (!ci.a.b().e()) {
            return false;
        }
        uVar.n0();
        return true;
    }
}
