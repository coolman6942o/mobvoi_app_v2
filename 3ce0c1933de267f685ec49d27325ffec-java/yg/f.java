package yg;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.m;
import com.mobvoi.fitness.core.data.db.gen.FitnessDatabase;
import com.mobvoi.health.companion.system.b;
import fg.u;
import hf.h;
import hf.j;
import java.util.Arrays;
import java.util.List;
import jf.d;
import jf.g;
import p002if.i;
import ve.l;
import xe.e;
/* compiled from: SportStorageImpl.java */
/* loaded from: classes2.dex */
public class f extends l {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: l  reason: collision with root package name */
    private static f f37085l;

    /* renamed from: g  reason: collision with root package name */
    private final xe.b f37086g;

    /* renamed from: h  reason: collision with root package name */
    private final i f37087h;

    /* renamed from: i  reason: collision with root package name */
    private final g f37088i;

    /* renamed from: k  reason: collision with root package name */
    private boolean f37090k = false;

    /* renamed from: j  reason: collision with root package name */
    private final yg.a f37089j = new yg.a();

    /* compiled from: SportStorageImpl.java */
    /* loaded from: classes2.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            k.c("fit.data.storage", "Connectivity changed to connected? %s", Boolean.valueOf(f.this.h0(context)));
        }
    }

    /* compiled from: SportStorageImpl.java */
    /* loaded from: classes2.dex */
    class b extends h {
        b() {
        }

        @Override // hf.h
        protected xe.b f() {
            return f.this.p();
        }

        @Override // hf.h
        protected List<hf.i> g() {
            return Arrays.asList(f.this.f37087h);
        }

        @Override // hf.h
        protected j h() {
            return f.this.f37087h;
        }

        @Override // hf.h
        protected hf.k i() {
            return f.this.f37087h;
        }

        @Override // hf.h
        protected hf.l j() {
            return f.this.f37087h;
        }

        @Override // hf.h
        public String k() {
            return f.this.f37087h.a();
        }
    }

    /* compiled from: SportStorageImpl.java */
    /* loaded from: classes2.dex */
    class c extends g {
        c(boolean z10) {
            super(z10);
        }

        @Override // jf.g
        protected h g() {
            return f.this.o();
        }

        @Override // jf.g
        protected xe.b h() {
            return f.this.p();
        }

        @Override // jf.g
        protected jf.a i() {
            return f.this.f37088i;
        }

        @Override // jf.g
        protected jf.b j() {
            return f.this.f37088i;
        }

        @Override // jf.g
        protected jf.c k() {
            return f.this.f37088i;
        }

        @Override // jf.g
        protected d l() {
            return f.this.f37088i;
        }
    }

    protected f(final Context context) {
        kg.g gVar = new kg.g(context);
        this.f37086g = e.u(FitnessDatabase.G(context));
        this.f37087h = new i(context, gVar, W());
        this.f37088i = new g(context);
        J(context.getApplicationContext());
        q().post(new Runnable() { // from class: yg.c
            @Override // java.lang.Runnable
            public final void run() {
                f.this.b0();
            }
        });
        String a10 = ah.c.a().a(context);
        k.i("fit.data.storage", "Sport storage init with account %s, session %s", a10, ah.c.a().b(context));
        g0(a10, false);
        ah.c.a().d(context, new b.a() { // from class: yg.b
            @Override // com.mobvoi.health.companion.system.b.a
            public final void a(boolean z10) {
                f.this.c0(context, z10);
            }
        });
        eg.a.e().d().a(new nf.k() { // from class: yg.e
            @Override // nf.k
            public final void i(nf.h hVar, Object obj) {
                f.this.d0(context, hVar, (Boolean) obj);
            }
        });
        context.registerReceiver(new a(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        k.c("fit.data.storage", "Connectivity initial to connected? %s", Boolean.valueOf(h0(context)));
    }

    private int W() {
        return vg.a.a().b() ? 0 : 2;
    }

    public static f X() {
        f fVar = f37085l;
        if (fVar != null) {
            return fVar;
        }
        throw new RuntimeException("Call SportStorage.init(Context) before using it.");
    }

    public static void Y(Context context) {
        f37085l = new f(context);
    }

    private boolean a0(Context context) {
        return ah.c.a().k(context).a(context.getString(u.f26932n));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0() {
        this.f37088i.l();
        this.f37089j.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(Context context, boolean z10) {
        String str;
        if (z10) {
            str = ah.c.a().c(context);
        } else {
            str = ah.c.a().a(context);
        }
        k.i("fit.data.storage", "Sport storage account changed to %s, session %s", str, ah.c.a().b(context));
        g0(str, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(Context context, nf.h hVar, Boolean bool) {
        if (bool.booleanValue()) {
            f0(context);
            M(5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0() {
        p().s();
    }

    private void f0(Context context) {
        boolean a02 = a0(context);
        this.f37088i.k(a02);
        this.f37089j.k(a02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h0(Context context) {
        boolean b10 = m.b(context);
        if (b10 && !this.f37090k) {
            M(5000L);
        }
        this.f37090k = b10;
        return b10;
    }

    public boolean Z(Context context) {
        return ah.c.a().k(context).a(context.getString(u.f26926m));
    }

    public void g0(String str, boolean z10) {
        this.f37087h.i(str, z10);
        this.f37088i.j(str);
        this.f37089j.m(str);
        p().r(str);
        q().post(new Runnable() { // from class: yg.d
            @Override // java.lang.Runnable
            public final void run() {
                f.this.e0();
            }
        });
    }

    @Override // ve.l
    protected h l(Context context) {
        return new b();
    }

    @Override // ve.l
    protected g m(Context context) {
        return new c(Z(context));
    }

    @Override // ve.l
    public xe.b p() {
        return this.f37086g;
    }
}
