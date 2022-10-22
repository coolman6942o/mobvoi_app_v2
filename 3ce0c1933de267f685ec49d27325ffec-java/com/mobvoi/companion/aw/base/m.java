package com.mobvoi.companion.aw.base;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.b0;
import androidx.lifecycle.f0;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.common.base.v;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mobvoi.companion.aw.fcm.MyFirebaseInstanceIDService;
import com.mobvoi.companion.aw.ui.main.HomeActivity;
import com.mobvoi.companion.aw.watchfacecenter.AWWatchFaceActivity;
import com.mobvoi.companion.aw.watchfacecenter.WatchFaceViewModel;
import com.mobvoi.companion.aw.watchfacecenter.k0;
import com.mobvoi.companion.health.CardManagementActivity;
import com.mobvoi.companion.health.CareHealthActivity;
import com.mobvoi.companion.health.CareHealthViewModel;
import com.mobvoi.companion.health.HealthFragment;
import com.mobvoi.companion.health.MainViewModel;
import com.mobvoi.companion.health.MedalCenterActivity;
import com.mobvoi.companion.health.MonthMedalAdapter;
import com.mobvoi.companion.health.SportMedalViewModel;
import com.mobvoi.companion.health.b1;
import com.mobvoi.companion.health.c1;
import com.mobvoi.companion.health.c3;
import com.mobvoi.companion.health.d1;
import com.mobvoi.companion.health.d3;
import com.mobvoi.companion.health.e1;
import com.mobvoi.companion.health.e3;
import com.mobvoi.companion.health.f1;
import com.mobvoi.companion.health.f3;
import com.mobvoi.companion.health.g1;
import com.mobvoi.companion.health.g3;
import com.mobvoi.companion.health.h1;
import com.mobvoi.companion.health.h3;
import com.mobvoi.companion.health.j0;
import com.mobvoi.companion.health.j1;
import com.mobvoi.companion.health.l0;
import com.mobvoi.companion.health.n;
import com.mobvoi.companion.health.n0;
import com.mobvoi.companion.health.o;
import com.mobvoi.companion.health.p;
import com.mobvoi.companion.health.r;
import com.mobvoi.companion.health.t;
import com.mobvoi.companion.health.t1;
import com.mobvoi.companion.health.t2;
import com.mobvoi.companion.health.t3;
import com.mobvoi.companion.health.u;
import com.mobvoi.companion.health.v1;
import com.mobvoi.companion.health.v2;
import com.mobvoi.companion.health.w1;
import com.mobvoi.companion.health.w2;
import com.mobvoi.companion.health.w3;
import com.mobvoi.companion.lpa.JupiterEsimActivity;
import com.mobvoi.companion.lpa.SimOpenBaseActivity;
import com.mobvoi.companion.lpa.m0;
import com.mobvoi.companion.lpa.o0;
import com.mobvoi.companion.lpa.p0;
import com.mobvoi.companion.lpa.q0;
import com.mobvoi.companion.lpa.r0;
import com.mobvoi.companion.lpa.s;
import com.mobvoi.companion.lpa.s0;
import com.mobvoi.record.RecordActivity;
import com.mobvoi.record.RecordViewModel;
import com.mobvoi.record.fragment.convert.RecordConvertFragment;
import com.mobvoi.record.fragment.detail.RecordDetailFragment;
import com.mobvoi.record.fragment.records.RecordsFragment;
import com.mobvoi.record.fragment.redeem.RedeemCodeFragment;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ne.q;
import okhttp3.y;
import retrofit2.Retrofit;
import rn.a;
/* compiled from: DaggerApp_HiltComponents_SingletonC.java */
/* loaded from: classes2.dex */
public final class m extends com.mobvoi.companion.aw.base.j {

    /* renamed from: a  reason: collision with root package name */
    private final ub.c f16167a;

    /* renamed from: b  reason: collision with root package name */
    private final sn.c f16168b;

    /* renamed from: c  reason: collision with root package name */
    private final fk.g f16169c;

    /* renamed from: d  reason: collision with root package name */
    private final qi.l f16170d;

    /* renamed from: e  reason: collision with root package name */
    private final sc.c f16171e;

    /* renamed from: f  reason: collision with root package name */
    private final m f16172f;

    /* renamed from: g  reason: collision with root package name */
    private ho.a<qk.a> f16173g;

    /* renamed from: h  reason: collision with root package name */
    private ho.a<qk.a> f16174h;

    /* renamed from: i  reason: collision with root package name */
    private ho.a<qk.a> f16175i;

    /* renamed from: j  reason: collision with root package name */
    private ho.a<Set<qk.a>> f16176j;

    /* renamed from: k  reason: collision with root package name */
    private ho.a<y> f16177k;

    /* renamed from: l  reason: collision with root package name */
    private ho.a<Retrofit> f16178l;

    /* renamed from: m  reason: collision with root package name */
    private ho.a<v<nc.a>> f16179m;

    /* renamed from: n  reason: collision with root package name */
    private ho.a<Retrofit> f16180n;

    /* renamed from: o  reason: collision with root package name */
    private ho.a<v<nc.a>> f16181o;

    /* renamed from: p  reason: collision with root package name */
    private ho.a<nc.d> f16182p;

    /* compiled from: DaggerApp_HiltComponents_SingletonC.java */
    /* loaded from: classes2.dex */
    private static final class b implements qn.a {

        /* renamed from: a  reason: collision with root package name */
        private final m f16183a;

        /* renamed from: b  reason: collision with root package name */
        private final e f16184b;

        /* renamed from: c  reason: collision with root package name */
        private Activity f16185c;

        /* renamed from: b */
        public b a(Activity activity) {
            this.f16185c = (Activity) un.b.b(activity);
            return this;
        }

        /* renamed from: c */
        public com.mobvoi.companion.aw.base.f build() {
            un.b.a(this.f16185c, Activity.class);
            return new c(this.f16184b, new com.mobvoi.companion.aw.watchfacecenter.g(), new o(), new ne.k(), new b1(), new s(), new d3(), new com.mobvoi.record.b(), this.f16185c);
        }

        private b(m mVar, e eVar) {
            this.f16183a = mVar;
            this.f16184b = eVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DaggerApp_HiltComponents_SingletonC.java */
    /* loaded from: classes2.dex */
    public static final class c extends com.mobvoi.companion.aw.base.f {
        private ho.a<RecyclerView.n> A;
        private ho.a<List<tc.i>> B;
        private ho.a<List<tc.i>> C;
        private ho.a<RecyclerView.n> D;
        private ho.a<t1> E;
        private ho.a<n0> F;
        private ho.a<GridLayoutManager> G;
        private ho.a<NavController> H;

        /* renamed from: a  reason: collision with root package name */
        private final com.mobvoi.companion.aw.watchfacecenter.g f16186a;

        /* renamed from: b  reason: collision with root package name */
        private final Activity f16187b;

        /* renamed from: c  reason: collision with root package name */
        private final o f16188c;

        /* renamed from: d  reason: collision with root package name */
        private final d3 f16189d;

        /* renamed from: e  reason: collision with root package name */
        private final s f16190e;

        /* renamed from: f  reason: collision with root package name */
        private final ne.k f16191f;

        /* renamed from: g  reason: collision with root package name */
        private final b1 f16192g;

        /* renamed from: h  reason: collision with root package name */
        private final com.mobvoi.record.b f16193h;

        /* renamed from: i  reason: collision with root package name */
        private final m f16194i;

        /* renamed from: j  reason: collision with root package name */
        private final e f16195j;

        /* renamed from: k  reason: collision with root package name */
        private final c f16196k;

        /* renamed from: l  reason: collision with root package name */
        private ho.a<androidx.fragment.app.f> f16197l;

        /* renamed from: m  reason: collision with root package name */
        private ho.a<ec.a> f16198m;

        /* renamed from: n  reason: collision with root package name */
        private ho.a<List<com.mobvoi.companion.health.viewholder.k>> f16199n;

        /* renamed from: o  reason: collision with root package name */
        private ho.a<List<com.mobvoi.companion.health.viewholder.k>> f16200o;

        /* renamed from: p  reason: collision with root package name */
        private ho.a<u> f16201p;

        /* renamed from: q  reason: collision with root package name */
        private ho.a<androidx.recyclerview.widget.g> f16202q;

        /* renamed from: r  reason: collision with root package name */
        private ho.a<n> f16203r;

        /* renamed from: s  reason: collision with root package name */
        private ho.a<RecyclerView.n> f16204s;

        /* renamed from: t  reason: collision with root package name */
        private ho.a<Runnable> f16205t;

        /* renamed from: u  reason: collision with root package name */
        private ho.a<MonthMedalAdapter> f16206u;

        /* renamed from: v  reason: collision with root package name */
        private ho.a<LinearLayoutManager> f16207v;

        /* renamed from: w  reason: collision with root package name */
        private ho.a<List<tc.d>> f16208w;

        /* renamed from: x  reason: collision with root package name */
        private ho.a<fe.a> f16209x;

        /* renamed from: y  reason: collision with root package name */
        private ho.a<List<ne.b>> f16210y;

        /* renamed from: z  reason: collision with root package name */
        private ho.a<q> f16211z;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: DaggerApp_HiltComponents_SingletonC.java */
        /* loaded from: classes2.dex */
        public static final class a<T> implements ho.a<T> {

            /* renamed from: a  reason: collision with root package name */
            private final c f16212a;

            /* renamed from: b  reason: collision with root package name */
            private final int f16213b;

            a(m mVar, e eVar, c cVar, int i10) {
                this.f16212a = cVar;
                this.f16213b = i10;
            }

            @Override // ho.a
            public T get() {
                switch (this.f16213b) {
                    case 0:
                        return (T) com.mobvoi.companion.aw.watchfacecenter.h.a(this.f16212a.f16186a, (androidx.fragment.app.f) this.f16212a.f16197l.get());
                    case 1:
                        return (T) sn.b.a(this.f16212a.f16187b);
                    case 2:
                        return (T) com.mobvoi.companion.health.q.a(this.f16212a.f16188c);
                    case 3:
                        return (T) r.a(this.f16212a.f16188c);
                    case 4:
                        return (T) t.a(this.f16212a.f16188c, (u) this.f16212a.f16201p.get());
                    case 5:
                        return (T) p.a(this.f16212a.f16188c);
                    case 6:
                        return (T) new n(this.f16212a.f16187b, (androidx.recyclerview.widget.g) this.f16212a.f16202q.get(), (List) this.f16212a.f16199n.get(), (List) this.f16212a.f16200o.get());
                    case 7:
                        return (T) com.mobvoi.companion.health.s.a(this.f16212a.f16188c, this.f16212a.f16187b);
                    case 8:
                        return (T) f3.a(this.f16212a.f16189d, this.f16212a.f16187b, (Runnable) this.f16212a.f16205t.get());
                    case 9:
                        return (T) g3.a(this.f16212a.f16189d, (androidx.fragment.app.f) this.f16212a.f16197l.get());
                    case 10:
                        return (T) e3.a(this.f16212a.f16189d, this.f16212a.f16187b);
                    case 11:
                        return (T) h3.a(this.f16212a.f16189d);
                    case 12:
                        return (T) com.mobvoi.companion.lpa.t.a(this.f16212a.f16190e, (androidx.fragment.app.f) this.f16212a.f16197l.get());
                    case 13:
                        return (T) ne.l.a(this.f16212a.f16191f, this.f16212a.f16187b);
                    case 14:
                        return (T) ne.m.a(this.f16212a.f16191f, this.f16212a.f16187b, (List) this.f16212a.f16210y.get());
                    case 15:
                        return (T) ne.n.a(this.f16212a.f16191f, this.f16212a.f16187b);
                    case 16:
                        return (T) h1.a(this.f16212a.f16192g);
                    case 17:
                        return (T) e1.a(this.f16212a.f16192g);
                    case 18:
                        return (T) g1.a(this.f16212a.f16192g, this.f16212a.f16187b, (List) this.f16212a.C.get());
                    case 19:
                        return (T) f1.a(this.f16212a.f16192g, (List) this.f16212a.C.get());
                    case 20:
                        return (T) c1.a(this.f16212a.f16192g, this.f16212a.f16187b);
                    case 21:
                        return (T) d1.a(this.f16212a.f16192g, this.f16212a.f16187b, (List) this.f16212a.C.get());
                    case 22:
                        return (T) com.mobvoi.record.c.a(this.f16212a.f16193h, this.f16212a.f16187b);
                    default:
                        throw new AssertionError(this.f16213b);
                }
            }
        }

        private sc.b H() {
            return new sc.b(this.f16194i.t());
        }

        private void I(com.mobvoi.companion.aw.watchfacecenter.g gVar, o oVar, ne.k kVar, b1 b1Var, s sVar, d3 d3Var, com.mobvoi.record.b bVar, Activity activity) {
            this.f16197l = un.c.a(new a(this.f16194i, this.f16195j, this.f16196k, 1));
            this.f16198m = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 0));
            this.f16199n = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 2));
            this.f16200o = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 3));
            this.f16201p = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 5));
            this.f16202q = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 4));
            this.f16203r = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 6));
            this.f16204s = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 7));
            this.f16205t = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 9));
            this.f16206u = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 8));
            this.f16207v = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 10));
            this.f16208w = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 11));
            this.f16209x = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 12));
            this.f16210y = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 13));
            this.f16211z = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 14));
            this.A = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 15));
            this.B = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 16));
            this.C = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 17));
            this.D = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 18));
            this.E = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 19));
            this.F = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 20));
            this.G = un.a.b(new a(this.f16194i, this.f16195j, this.f16196k, 21));
            this.H = new a(this.f16194i, this.f16195j, this.f16196k, 22);
        }

        private AWWatchFaceActivity J(AWWatchFaceActivity aWWatchFaceActivity) {
            com.mobvoi.companion.aw.watchfacecenter.f.a(aWWatchFaceActivity, this.f16198m.get());
            return aWWatchFaceActivity;
        }

        private CardManagementActivity K(CardManagementActivity cardManagementActivity) {
            com.mobvoi.companion.health.k.e(cardManagementActivity, H());
            com.mobvoi.companion.health.k.c(cardManagementActivity, this.f16199n.get());
            com.mobvoi.companion.health.k.d(cardManagementActivity, this.f16200o.get());
            com.mobvoi.companion.health.k.g(cardManagementActivity, this.f16202q.get());
            com.mobvoi.companion.health.k.a(cardManagementActivity, this.f16203r.get());
            com.mobvoi.companion.health.k.b(cardManagementActivity, this.f16201p.get());
            com.mobvoi.companion.health.k.f(cardManagementActivity, this.f16204s.get());
            return cardManagementActivity;
        }

        private HomeActivity L(HomeActivity homeActivity) {
            com.mobvoi.companion.aw.ui.main.p.a(homeActivity, (nc.d) this.f16194i.f16182p.get());
            return homeActivity;
        }

        private JupiterEsimActivity M(JupiterEsimActivity jupiterEsimActivity) {
            com.mobvoi.companion.lpa.r.a(jupiterEsimActivity, this.f16209x.get());
            return jupiterEsimActivity;
        }

        private MedalCenterActivity N(MedalCenterActivity medalCenterActivity) {
            c3.b(medalCenterActivity, this.f16206u.get());
            c3.a(medalCenterActivity, this.f16207v.get());
            c3.c(medalCenterActivity, this.f16205t.get());
            c3.d(medalCenterActivity, this.f16208w.get());
            return medalCenterActivity;
        }

        public Set<String> G() {
            return ImmutableSet.of(l0.a(), v2.a(), com.mobvoi.record.q.a(), t3.a(), k0.a());
        }

        @Override // rn.a.AbstractC0464a
        public a.c a() {
            return rn.b.a(sn.d.a(this.f16194i.f16168b), G(), new l(this.f16195j));
        }

        @Override // com.mobvoi.companion.health.w
        public void b(CareHealthActivity careHealthActivity) {
        }

        @Override // com.mobvoi.companion.aw.watchfacecenter.e
        public void c(AWWatchFaceActivity aWWatchFaceActivity) {
            J(aWWatchFaceActivity);
        }

        @Override // com.mobvoi.companion.health.b3
        public void d(MedalCenterActivity medalCenterActivity) {
            N(medalCenterActivity);
        }

        @Override // com.mobvoi.companion.lpa.h0
        public void e(SimOpenBaseActivity simOpenBaseActivity) {
        }

        @Override // com.mobvoi.companion.health.j
        public void f(CardManagementActivity cardManagementActivity) {
            K(cardManagementActivity);
        }

        @Override // com.mobvoi.companion.lpa.q
        public void g(JupiterEsimActivity jupiterEsimActivity) {
            M(jupiterEsimActivity);
        }

        @Override // com.mobvoi.companion.aw.ui.main.o
        public void h(HomeActivity homeActivity) {
            L(homeActivity);
        }

        @Override // dagger.hilt.android.internal.managers.f.a
        public qn.c i() {
            return new g(this.f16195j, this.f16196k);
        }

        @Override // com.mobvoi.record.m
        public void j(RecordActivity recordActivity) {
        }

        private c(m mVar, e eVar, com.mobvoi.companion.aw.watchfacecenter.g gVar, o oVar, ne.k kVar, b1 b1Var, s sVar, d3 d3Var, com.mobvoi.record.b bVar, Activity activity) {
            this.f16196k = this;
            this.f16194i = mVar;
            this.f16195j = eVar;
            this.f16186a = gVar;
            this.f16187b = activity;
            this.f16188c = oVar;
            this.f16189d = d3Var;
            this.f16190e = sVar;
            this.f16191f = kVar;
            this.f16192g = b1Var;
            this.f16193h = bVar;
            I(gVar, oVar, kVar, b1Var, sVar, d3Var, bVar, activity);
        }
    }

    /* compiled from: DaggerApp_HiltComponents_SingletonC.java */
    /* loaded from: classes2.dex */
    private static final class d implements qn.b {

        /* renamed from: a  reason: collision with root package name */
        private final m f16214a;

        /* renamed from: a */
        public com.mobvoi.companion.aw.base.g build() {
            return new e(new v1());
        }

        private d(m mVar) {
            this.f16214a = mVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DaggerApp_HiltComponents_SingletonC.java */
    /* loaded from: classes2.dex */
    public static final class e extends com.mobvoi.companion.aw.base.g {

        /* renamed from: a  reason: collision with root package name */
        private final v1 f16215a;

        /* renamed from: b  reason: collision with root package name */
        private final m f16216b;

        /* renamed from: c  reason: collision with root package name */
        private final e f16217c;

        /* renamed from: d  reason: collision with root package name */
        private ho.a f16218d;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: DaggerApp_HiltComponents_SingletonC.java */
        /* loaded from: classes2.dex */
        public static final class a<T> implements ho.a<T> {

            /* renamed from: a  reason: collision with root package name */
            private final int f16219a;

            a(m mVar, e eVar, int i10) {
                this.f16219a = i10;
            }

            @Override // ho.a
            public T get() {
                if (this.f16219a == 0) {
                    return (T) dagger.hilt.android.internal.managers.c.a();
                }
                throw new AssertionError(this.f16219a);
            }
        }

        private void d(v1 v1Var) {
            this.f16218d = un.a.b(new a(this.f16216b, this.f16217c, 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String e() {
            return w1.a(this.f16215a, sn.e.a(this.f16216b.f16168b));
        }

        @Override // dagger.hilt.android.internal.managers.b.d
        public mn.a a() {
            return (mn.a) this.f16218d.get();
        }

        @Override // dagger.hilt.android.internal.managers.a.AbstractC0271a
        public qn.a b() {
            return new b(this.f16217c);
        }

        private e(m mVar, v1 v1Var) {
            this.f16217c = this;
            this.f16216b = mVar;
            this.f16215a = v1Var;
            d(v1Var);
        }
    }

    /* compiled from: DaggerApp_HiltComponents_SingletonC.java */
    /* loaded from: classes2.dex */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        private sn.c f16220a;

        /* renamed from: b  reason: collision with root package name */
        private ub.c f16221b;

        /* renamed from: c  reason: collision with root package name */
        private sc.c f16222c;

        /* renamed from: d  reason: collision with root package name */
        private fk.g f16223d;

        /* renamed from: e  reason: collision with root package name */
        private qi.l f16224e;

        public f a(sn.c cVar) {
            this.f16220a = (sn.c) un.b.b(cVar);
            return this;
        }

        public com.mobvoi.companion.aw.base.j b() {
            un.b.a(this.f16220a, sn.c.class);
            if (this.f16221b == null) {
                this.f16221b = new ub.c();
            }
            if (this.f16222c == null) {
                this.f16222c = new sc.c();
            }
            if (this.f16223d == null) {
                this.f16223d = new fk.g();
            }
            if (this.f16224e == null) {
                this.f16224e = new qi.l();
            }
            return new m(this.f16220a, this.f16221b, this.f16222c, this.f16223d, this.f16224e);
        }

        private f() {
        }
    }

    /* compiled from: DaggerApp_HiltComponents_SingletonC.java */
    /* loaded from: classes2.dex */
    private static final class g implements qn.c {

        /* renamed from: a  reason: collision with root package name */
        private final m f16225a;

        /* renamed from: b  reason: collision with root package name */
        private final e f16226b;

        /* renamed from: c  reason: collision with root package name */
        private final c f16227c;

        /* renamed from: d  reason: collision with root package name */
        private Fragment f16228d;

        /* renamed from: b */
        public com.mobvoi.companion.aw.base.h build() {
            un.b.a(this.f16228d, Fragment.class);
            return new h(this.f16226b, this.f16227c, new p0(), this.f16228d);
        }

        /* renamed from: c */
        public g a(Fragment fragment) {
            this.f16228d = (Fragment) un.b.b(fragment);
            return this;
        }

        private g(m mVar, e eVar, c cVar) {
            this.f16225a = mVar;
            this.f16226b = eVar;
            this.f16227c = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DaggerApp_HiltComponents_SingletonC.java */
    /* loaded from: classes2.dex */
    public static final class h extends com.mobvoi.companion.aw.base.h {

        /* renamed from: a  reason: collision with root package name */
        private final p0 f16229a;

        /* renamed from: b  reason: collision with root package name */
        private final m f16230b;

        /* renamed from: c  reason: collision with root package name */
        private final e f16231c;

        /* renamed from: d  reason: collision with root package name */
        private final c f16232d;

        /* renamed from: e  reason: collision with root package name */
        private final h f16233e;

        /* renamed from: f  reason: collision with root package name */
        private ho.a<androidx.appcompat.app.c> f16234f;

        /* renamed from: g  reason: collision with root package name */
        private ho.a<com.mobvoi.android.common.utils.s> f16235g;

        /* renamed from: h  reason: collision with root package name */
        private ho.a<BroadcastReceiver> f16236h;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: DaggerApp_HiltComponents_SingletonC.java */
        /* loaded from: classes2.dex */
        public static final class a<T> implements ho.a<T> {

            /* renamed from: a  reason: collision with root package name */
            private final c f16237a;

            /* renamed from: b  reason: collision with root package name */
            private final h f16238b;

            /* renamed from: c  reason: collision with root package name */
            private final int f16239c;

            a(m mVar, e eVar, c cVar, h hVar, int i10) {
                this.f16237a = cVar;
                this.f16238b = hVar;
                this.f16239c = i10;
            }

            @Override // ho.a
            public T get() {
                int i10 = this.f16239c;
                if (i10 == 0) {
                    return (T) s0.a(this.f16238b.f16229a, (androidx.fragment.app.f) this.f16237a.f16197l.get());
                }
                if (i10 == 1) {
                    return (T) q0.a(this.f16238b.f16229a, (androidx.fragment.app.f) this.f16237a.f16197l.get(), (androidx.appcompat.app.c) this.f16238b.f16234f.get(), (com.mobvoi.android.common.utils.s) this.f16238b.f16235g.get());
                }
                if (i10 == 2) {
                    return (T) r0.a(this.f16238b.f16229a, (androidx.fragment.app.f) this.f16237a.f16197l.get());
                }
                throw new AssertionError(this.f16239c);
            }
        }

        private void n(p0 p0Var, Fragment fragment) {
            this.f16234f = un.a.b(new a(this.f16230b, this.f16231c, this.f16232d, this.f16233e, 0));
            this.f16235g = un.a.b(new a(this.f16230b, this.f16231c, this.f16232d, this.f16233e, 2));
            this.f16236h = un.a.b(new a(this.f16230b, this.f16231c, this.f16232d, this.f16233e, 1));
        }

        private HealthFragment o(HealthFragment healthFragment) {
            j1.f(healthFragment, (List) this.f16232d.B.get());
            j1.c(healthFragment, (List) this.f16232d.C.get());
            j1.e(healthFragment, (RecyclerView.n) this.f16232d.D.get());
            j1.d(healthFragment, (t1) this.f16232d.E.get());
            j1.a(healthFragment, (n0) this.f16232d.F.get());
            j1.b(healthFragment, (GridLayoutManager) this.f16232d.G.get());
            return healthFragment;
        }

        private RecordConvertFragment p(RecordConvertFragment recordConvertFragment) {
            com.mobvoi.record.fragment.convert.d.a(recordConvertFragment, this.f16232d.H);
            return recordConvertFragment;
        }

        private RecordDetailFragment q(RecordDetailFragment recordDetailFragment) {
            com.mobvoi.record.fragment.detail.j.a(recordDetailFragment, this.f16232d.H);
            return recordDetailFragment;
        }

        private RecordsFragment r(RecordsFragment recordsFragment) {
            com.mobvoi.record.fragment.records.h.a(recordsFragment, this.f16232d.H);
            return recordsFragment;
        }

        private RedeemCodeFragment s(RedeemCodeFragment redeemCodeFragment) {
            com.mobvoi.record.fragment.redeem.d.a(redeemCodeFragment, this.f16232d.H);
            return redeemCodeFragment;
        }

        private m0 t(m0 m0Var) {
            o0.b(m0Var, this.f16234f.get());
            o0.c(m0Var, this.f16236h.get());
            o0.a(m0Var, this.f16235g.get());
            return m0Var;
        }

        @Override // rn.a.b
        public a.c a() {
            return this.f16232d.a();
        }

        @Override // com.mobvoi.record.fragment.records.g
        public void b(RecordsFragment recordsFragment) {
            r(recordsFragment);
        }

        @Override // com.mobvoi.companion.lpa.n0
        public void c(m0 m0Var) {
            t(m0Var);
        }

        @Override // com.mobvoi.record.fragment.redeem.c
        public void d(RedeemCodeFragment redeemCodeFragment) {
            s(redeemCodeFragment);
        }

        @Override // com.mobvoi.record.fragment.convert.c
        public void e(RecordConvertFragment recordConvertFragment) {
            p(recordConvertFragment);
        }

        @Override // tj.e
        public void f(tj.d dVar) {
        }

        @Override // com.mobvoi.companion.lpa.f
        public void g(com.mobvoi.companion.lpa.e eVar) {
        }

        @Override // com.mobvoi.record.fragment.detail.i
        public void h(RecordDetailFragment recordDetailFragment) {
            q(recordDetailFragment);
        }

        @Override // com.mobvoi.companion.health.i1
        public void i(HealthFragment healthFragment) {
            o(healthFragment);
        }

        @Override // com.mobvoi.companion.health.x3
        public void j(w3 w3Var) {
        }

        private h(m mVar, e eVar, c cVar, p0 p0Var, Fragment fragment) {
            this.f16233e = this;
            this.f16230b = mVar;
            this.f16231c = eVar;
            this.f16232d = cVar;
            this.f16229a = p0Var;
            n(p0Var, fragment);
        }
    }

    /* compiled from: DaggerApp_HiltComponents_SingletonC.java */
    /* loaded from: classes2.dex */
    private static final class i implements qn.d {

        /* renamed from: a  reason: collision with root package name */
        private final m f16240a;

        /* renamed from: b  reason: collision with root package name */
        private Service f16241b;

        /* renamed from: b */
        public com.mobvoi.companion.aw.base.i build() {
            un.b.a(this.f16241b, Service.class);
            return new j(this.f16241b);
        }

        /* renamed from: c */
        public i a(Service service) {
            this.f16241b = (Service) un.b.b(service);
            return this;
        }

        private i(m mVar) {
            this.f16240a = mVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DaggerApp_HiltComponents_SingletonC.java */
    /* loaded from: classes2.dex */
    public static final class j extends com.mobvoi.companion.aw.base.i {

        /* renamed from: a  reason: collision with root package name */
        private final m f16242a;

        private MyFirebaseInstanceIDService b(MyFirebaseInstanceIDService myFirebaseInstanceIDService) {
            com.mobvoi.companion.aw.fcm.c.a(myFirebaseInstanceIDService, (nc.d) this.f16242a.f16182p.get());
            return myFirebaseInstanceIDService;
        }

        @Override // com.mobvoi.companion.aw.fcm.b
        public void a(MyFirebaseInstanceIDService myFirebaseInstanceIDService) {
            b(myFirebaseInstanceIDService);
        }

        private j(m mVar, Service service) {
            this.f16242a = mVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DaggerApp_HiltComponents_SingletonC.java */
    /* loaded from: classes2.dex */
    public static final class k<T> implements ho.a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final m f16243a;

        /* renamed from: b  reason: collision with root package name */
        private final int f16244b;

        k(m mVar, int i10) {
            this.f16243a = mVar;
            this.f16244b = i10;
        }

        @Override // ho.a
        public T get() {
            switch (this.f16244b) {
                case 0:
                    return (T) ImmutableSet.of((qk.a) this.f16243a.f16173g.get(), (qk.a) this.f16243a.f16174h.get(), (qk.a) this.f16243a.f16175i.get());
                case 1:
                    return (T) ub.d.a(this.f16243a.f16167a, sn.e.a(this.f16243a.f16168b));
                case 2:
                    return (T) fk.h.a(this.f16243a.f16169c, sn.e.a(this.f16243a.f16168b));
                case 3:
                    return (T) qi.m.a(this.f16243a.f16170d, sn.e.a(this.f16243a.f16168b));
                case 4:
                    m mVar = this.f16243a;
                    return (T) mVar.w(nc.e.a(sn.e.a(mVar.f16168b)));
                case 5:
                    return (T) nc.k.a((Retrofit) this.f16243a.f16178l.get());
                case 6:
                    return (T) nc.n.a((y) this.f16243a.f16177k.get());
                case 7:
                    return (T) nc.l.a();
                case 8:
                    return (T) nc.j.a((Retrofit) this.f16243a.f16180n.get());
                case 9:
                    return (T) nc.m.a((y) this.f16243a.f16177k.get());
                default:
                    throw new AssertionError(this.f16244b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DaggerApp_HiltComponents_SingletonC.java */
    /* loaded from: classes2.dex */
    public static final class l implements qn.e {

        /* renamed from: a  reason: collision with root package name */
        private final m f16245a;

        /* renamed from: b  reason: collision with root package name */
        private final e f16246b;

        /* renamed from: c  reason: collision with root package name */
        private b0 f16247c;

        /* renamed from: b */
        public com.mobvoi.companion.aw.base.k build() {
            un.b.a(this.f16247c, b0.class);
            return new C0197m(this.f16246b, this.f16247c);
        }

        /* renamed from: c */
        public l a(b0 b0Var) {
            this.f16247c = (b0) un.b.b(b0Var);
            return this;
        }

        private l(m mVar, e eVar) {
            this.f16245a = mVar;
            this.f16246b = eVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DaggerApp_HiltComponents_SingletonC.java */
    /* renamed from: com.mobvoi.companion.aw.base.m$m  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0197m extends com.mobvoi.companion.aw.base.k {

        /* renamed from: a  reason: collision with root package name */
        private final m f16248a;

        /* renamed from: b  reason: collision with root package name */
        private final e f16249b;

        /* renamed from: c  reason: collision with root package name */
        private final C0197m f16250c;

        /* renamed from: d  reason: collision with root package name */
        private ho.a<CareHealthViewModel> f16251d;

        /* renamed from: e  reason: collision with root package name */
        private ho.a<MainViewModel> f16252e;

        /* renamed from: f  reason: collision with root package name */
        private ho.a<RecordViewModel> f16253f;

        /* renamed from: g  reason: collision with root package name */
        private ho.a<SportMedalViewModel> f16254g;

        /* renamed from: h  reason: collision with root package name */
        private ho.a<WatchFaceViewModel> f16255h;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: DaggerApp_HiltComponents_SingletonC.java */
        /* renamed from: com.mobvoi.companion.aw.base.m$m$a */
        /* loaded from: classes2.dex */
        public static final class a<T> implements ho.a<T> {

            /* renamed from: a  reason: collision with root package name */
            private final m f16256a;

            /* renamed from: b  reason: collision with root package name */
            private final C0197m f16257b;

            /* renamed from: c  reason: collision with root package name */
            private final int f16258c;

            a(m mVar, e eVar, C0197m mVar2, int i10) {
                this.f16256a = mVar;
                this.f16257b = mVar2;
                this.f16258c = i10;
            }

            @Override // ho.a
            public T get() {
                int i10 = this.f16258c;
                if (i10 == 0) {
                    return (T) this.f16257b.g(j0.a(sn.d.a(this.f16256a.f16168b)));
                }
                if (i10 == 1) {
                    return (T) this.f16257b.h(t2.a(sn.d.a(this.f16256a.f16168b)));
                }
                if (i10 == 2) {
                    return (T) new RecordViewModel();
                }
                if (i10 == 3) {
                    return (T) new SportMedalViewModel(this.f16257b.i());
                }
                if (i10 == 4) {
                    return (T) new WatchFaceViewModel(sn.d.a(this.f16256a.f16168b));
                }
                throw new AssertionError(this.f16258c);
            }
        }

        private sc.b e() {
            return new sc.b(this.f16248a.t());
        }

        private void f(b0 b0Var) {
            this.f16251d = new a(this.f16248a, this.f16249b, this.f16250c, 0);
            this.f16252e = new a(this.f16248a, this.f16249b, this.f16250c, 1);
            this.f16253f = new a(this.f16248a, this.f16249b, this.f16250c, 2);
            this.f16254g = new a(this.f16248a, this.f16249b, this.f16250c, 3);
            this.f16255h = new a(this.f16248a, this.f16249b, this.f16250c, 4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CareHealthViewModel g(CareHealthViewModel careHealthViewModel) {
            com.mobvoi.companion.health.m0.a(careHealthViewModel, e());
            return careHealthViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MainViewModel h(MainViewModel mainViewModel) {
            w2.b(mainViewModel, this.f16249b.e());
            w2.a(mainViewModel, e());
            return mainViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public sc.i i() {
            return new sc.i(this.f16248a.x());
        }

        @Override // rn.c.b
        public Map<String, ho.a<f0>> a() {
            return ImmutableMap.of("com.mobvoi.companion.health.CareHealthViewModel", (ho.a<WatchFaceViewModel>) this.f16251d, "com.mobvoi.companion.health.MainViewModel", (ho.a<WatchFaceViewModel>) this.f16252e, "com.mobvoi.record.RecordViewModel", (ho.a<WatchFaceViewModel>) this.f16253f, "com.mobvoi.companion.health.SportMedalViewModel", (ho.a<WatchFaceViewModel>) this.f16254g, "com.mobvoi.companion.aw.watchfacecenter.WatchFaceViewModel", this.f16255h);
        }

        private C0197m(m mVar, e eVar, b0 b0Var) {
            this.f16250c = this;
            this.f16248a = mVar;
            this.f16249b = eVar;
            f(b0Var);
        }
    }

    public static f s() {
        return new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public sc.a t() {
        sc.c cVar = this.f16171e;
        return sc.d.a(cVar, sc.f.a(cVar));
    }

    private void u(sn.c cVar, ub.c cVar2, sc.c cVar3, fk.g gVar, qi.l lVar) {
        this.f16173g = un.a.b(new k(this.f16172f, 1));
        this.f16174h = un.a.b(new k(this.f16172f, 2));
        this.f16175i = un.a.b(new k(this.f16172f, 3));
        this.f16176j = new k(this.f16172f, 0);
        this.f16177k = un.a.b(new k(this.f16172f, 7));
        this.f16178l = un.a.b(new k(this.f16172f, 6));
        this.f16179m = un.a.b(new k(this.f16172f, 5));
        this.f16180n = un.a.b(new k(this.f16172f, 9));
        this.f16181o = un.a.b(new k(this.f16172f, 8));
        this.f16182p = un.a.b(new k(this.f16172f, 4));
    }

    private App v(App app) {
        com.mobvoi.companion.aw.base.l.a(app, un.a.a(this.f16176j));
        return app;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public nc.d w(nc.d dVar) {
        nc.f.b(dVar, this.f16179m.get());
        nc.f.a(dVar, this.f16181o.get());
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public sc.h x() {
        sc.c cVar = this.f16171e;
        return sc.g.a(cVar, sc.e.a(cVar));
    }

    @Override // dagger.hilt.android.internal.managers.g.a
    public qn.d a() {
        return new i();
    }

    @Override // com.mobvoi.companion.aw.base.e
    public void b(App app) {
        v(app);
    }

    @Override // on.a.AbstractC0446a
    public Set<Boolean> c() {
        return ImmutableSet.of();
    }

    @Override // dagger.hilt.android.internal.managers.b.AbstractC0272b
    public qn.b d() {
        return new d();
    }

    private m(sn.c cVar, ub.c cVar2, sc.c cVar3, fk.g gVar, qi.l lVar) {
        this.f16172f = this;
        this.f16167a = cVar2;
        this.f16168b = cVar;
        this.f16169c = gVar;
        this.f16170d = lVar;
        this.f16171e = cVar3;
        u(cVar, cVar2, cVar3, gVar, lVar);
    }
}
