package com.mobvoi.companion.account;

import android.app.Application;
import androidx.lifecycle.w;
import com.google.gson.e;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.data.AccountManager;
import com.mobvoi.companion.profile.h;
import com.mobvoi.companion.setting.CompanionSetting;
import rx.c;
import rx.i;
import yp.g;
/* compiled from: ThirdPartyBindModel.java */
/* loaded from: classes2.dex */
public class p extends h {

    /* renamed from: g  reason: collision with root package name */
    private wc.b f16145g = wc.b.v();

    /* renamed from: h  reason: collision with root package name */
    private w<Boolean> f16146h = new w<>();

    /* compiled from: ThirdPartyBindModel.java */
    /* loaded from: classes2.dex */
    class a implements rx.d<Boolean> {
        a() {
        }

        /* renamed from: b */
        public void onNext(Boolean bool) {
            if (bool.booleanValue()) {
                p.this.f16146h.o(Boolean.TRUE);
            }
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.d("HealthInfoModel", th2.getMessage());
        }
    }

    /* compiled from: ThirdPartyBindModel.java */
    /* loaded from: classes2.dex */
    class b extends i<sa.c> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f16148a;

        b(String str) {
            this.f16148a = str;
        }

        /* renamed from: b */
        public void onNext(sa.c cVar) {
            k.c("HealthInfoModel", "unbind result:  %s", new e().s(cVar));
            if (cVar.b()) {
                if ("runkeeper".equals(this.f16148a)) {
                    vc.a.f(((h) p.this).f17336e, false);
                } else if ("strava".equals(this.f16148a)) {
                    vc.a.g(((h) p.this).f17336e, false);
                }
                p.this.f16146h.o(Boolean.TRUE);
            }
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.a("HealthInfoModel", "checkAuthor state fail:" + th2.getMessage());
            p.this.f16146h.o(Boolean.FALSE);
        }
    }

    /* compiled from: ThirdPartyBindModel.java */
    /* loaded from: classes2.dex */
    class c extends i<sa.c> {
        c() {
        }

        /* renamed from: b */
        public void onNext(sa.c cVar) {
            k.c("HealthInfoModel", "unbind google fit: %s", new e().s(cVar));
            if (cVar.errorCode == 0) {
                vc.a.e(((h) p.this).f17336e, false);
                p.this.f16146h.o(Boolean.TRUE);
            }
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.f("HealthInfoModel", "unbind google fit fail: %s", th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ThirdPartyBindModel.java */
    /* loaded from: classes2.dex */
    public class d implements rx.d<sa.b> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f16151a;

        d(boolean z10) {
            this.f16151a = z10;
        }

        /* renamed from: b */
        public void onNext(sa.b bVar) {
            if (bVar.errorCode == 0) {
                CompanionSetting.setArtyAuthorizeStatus(this.f16151a);
                p.this.f16146h.m(Boolean.TRUE);
            }
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            p.this.f16146h.m(Boolean.FALSE);
        }
    }

    public p(Application application) {
        super(application);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ rx.c t(wc.c cVar) {
        k.c("HealthInfoModel", "rk & strava bind State: %s", new e().s(cVar));
        if (cVar.b()) {
            vc.a.g(this.f17336e, cVar.h());
            vc.a.f(this.f17336e, cVar.g());
            return rx.c.A(Boolean.TRUE);
        }
        k.a("HealthInfoModel", "request rk & strava bind State: error");
        return rx.c.A(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ rx.c u(sa.c cVar) {
        k.c("HealthInfoModel", "google fit bind State: %s", new e().s(cVar));
        int i10 = cVar.errorCode;
        if (i10 == 0) {
            vc.a.e(this.f17336e, true);
        } else if (i10 == 50001) {
            vc.a.e(this.f17336e, false);
        }
        return rx.c.A(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ rx.c v(sa.b bVar) {
        if (bVar.errorCode != 0) {
            return rx.c.A(Boolean.FALSE);
        }
        CompanionSetting.setArtyAuthorizeStatus(bVar.authorize);
        return rx.c.A(Boolean.TRUE);
    }

    public void q(boolean z10) {
        a(com.mobvoi.assistant.account.data.a.v().t(AccountManager.h().g().sessionId, z10).Z(cq.a.c()).H(xp.a.b()).U(new d(z10)));
    }

    public void r() {
        sa.a g10 = AccountManager.h().g();
        if (g10 != null) {
            k.a("HealthInfoModel", "check all bind state: ");
            a(rx.c.F(this.f16145g.t(g10.accountId).Z(cq.a.c()).H(xp.a.b()).v(new g() { // from class: com.mobvoi.companion.account.n
                @Override // yp.g
                public final Object call(Object obj) {
                    c t10;
                    t10 = p.this.t((wc.c) obj);
                    return t10;
                }
            }), this.f16145g.u(g10.sessionId).Z(cq.a.c()).H(xp.a.b()).v(new g() { // from class: com.mobvoi.companion.account.m
                @Override // yp.g
                public final Object call(Object obj) {
                    c u10;
                    u10 = p.this.u((sa.c) obj);
                    return u10;
                }
            }), com.mobvoi.assistant.account.data.a.v().y(g10.sessionId).Z(cq.a.c()).H(xp.a.b()).v(o.f16144a)).U(new a()));
        }
    }

    public w<Boolean> s() {
        return this.f16146h;
    }

    public void w(String str) {
        k.c("HealthInfoModel", "unbind: %s", str);
        a(this.f16145g.w(str, AccountManager.h().g().accountId, AccountManager.h().g().sessionId).Z(cq.a.c()).H(xp.a.b()).V(new b(str)));
    }

    public void x() {
        a(wc.b.v().x(AccountManager.h().g().sessionId).Z(cq.a.c()).H(xp.a.b()).V(new c()));
    }
}
