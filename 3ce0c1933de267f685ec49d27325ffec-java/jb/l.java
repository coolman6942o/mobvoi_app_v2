package jb;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.AccountConstant;
import com.mobvoi.assistant.account.data.AccountManager;
import db.e;
import java.lang.ref.WeakReference;
import ra.h;
import rx.i;
import sa.f;
import sa.g;
/* compiled from: LoginPresenterImpl.java */
/* loaded from: classes2.dex */
public class l implements jb.a, db.b {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<jb.b> f29496a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Fragment> f29497b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f29498c;

    /* renamed from: d  reason: collision with root package name */
    private final e f29499d;

    /* renamed from: e  reason: collision with root package name */
    private ra.b f29500e = h.b();

    /* renamed from: f  reason: collision with root package name */
    private ua.a f29501f = h.a();

    /* renamed from: g  reason: collision with root package name */
    private dq.b f29502g = new dq.b();

    /* renamed from: h  reason: collision with root package name */
    private String f29503h;

    /* compiled from: LoginPresenterImpl.java */
    /* loaded from: classes2.dex */
    class a extends i<g> {
        a() {
        }

        /* renamed from: b */
        public void onNext(g gVar) {
            k.c("LoginPresenterImpl", "login success? = %s", Boolean.valueOf(gVar.b()));
            if (gVar.b()) {
                ta.a.E(sa.a.a(gVar.result));
                jb.b bVar = (jb.b) l.this.f29496a.get();
                if (bVar != null) {
                    bVar.a();
                }
                AccountManager.h().l();
                return;
            }
            jb.b bVar2 = (jb.b) l.this.f29496a.get();
            if (bVar2 != null) {
                bVar2.b(gVar.errorMsg);
            }
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.b("LoginPresenterImpl", "login fail:", th2);
            jb.b bVar = (jb.b) l.this.f29496a.get();
            if (bVar != null) {
                bVar.b(l.this.f29498c.getString(pa.i.K));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginPresenterImpl.java */
    /* loaded from: classes2.dex */
    public class b extends i<g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f29505a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f29506b;

        b(String str, String str2) {
            this.f29505a = str;
            this.f29506b = str2;
        }

        /* renamed from: b */
        public void onNext(g gVar) {
            if (gVar.b()) {
                ta.a.E(sa.a.a(gVar.result));
                jb.b bVar = (jb.b) l.this.f29496a.get();
                if (bVar != null) {
                    bVar.a();
                }
                AccountManager.h().l();
            } else if (gVar.c() || gVar.f()) {
                jb.b bVar2 = (jb.b) l.this.f29496a.get();
                if (bVar2 != null) {
                    bVar2.O(this.f29505a, this.f29506b);
                }
            } else {
                jb.b bVar3 = (jb.b) l.this.f29496a.get();
                if (bVar3 != null) {
                    bVar3.b(gVar.errorMsg);
                }
            }
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.a("LoginPresenterImpl", "login fail:" + th2.getMessage());
            jb.b bVar = (jb.b) l.this.f29496a.get();
            if (bVar != null) {
                bVar.b(l.this.f29498c.getString(pa.i.K));
            }
        }
    }

    /* compiled from: LoginPresenterImpl.java */
    /* loaded from: classes2.dex */
    class c extends i<sa.c> {
        c() {
        }

        /* renamed from: b */
        public void onNext(sa.c cVar) {
            k.a("LoginPresenterImpl", "send captcha success:" + cVar.toString());
            if (cVar.b()) {
                ((jb.b) l.this.f29496a.get()).G();
            } else {
                ((jb.b) l.this.f29496a.get()).z(cVar.errorMsg);
            }
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.d("LoginPresenterImpl", "send captcha fail:" + th2.getMessage());
            ((jb.b) l.this.f29496a.get()).z(l.this.f29498c.getString(pa.i.K));
        }
    }

    public l(Fragment fragment, jb.b bVar) {
        e eVar = (e) kc.b.b().a(e.class);
        this.f29499d = eVar;
        this.f29498c = fragment.requireContext();
        this.f29497b = new WeakReference<>(fragment);
        this.f29496a = new WeakReference<>(bVar);
        if (eVar.h()) {
            eVar.i(fragment.requireActivity(), this);
        }
    }

    private void s(String str, String str2) {
        jb.b bVar = this.f29496a.get();
        if (bVar != null) {
            bVar.W();
        }
        sa.l lVar = new sa.l();
        lVar.uid = str2;
        lVar.type = str;
        String i10 = ta.a.i();
        if (!TextUtils.isEmpty(i10)) {
            lVar.email = i10;
        }
        this.f29502g.a(this.f29500e.g(lVar).Z(this.f29501f.b()).H(this.f29501f.a()).V(new b(str, str2)));
    }

    @Override // jb.a
    public void a(int i10, int i11, Intent intent) {
        this.f29499d.b(this.f29503h, i10, i11, intent);
    }

    @Override // jb.a
    public void c(String str) {
        this.f29503h = str;
        Fragment fragment = this.f29497b.get();
        if (fragment != null) {
            sb.a.d(fragment.requireContext(), str);
            this.f29499d.g(fragment, str, this);
        }
    }

    @Override // db.b
    public void d(String str, String str2) {
        k.c("LoginPresenterImpl", "authFail type : %s, msg : %s", str, str2);
    }

    @Override // db.b
    public void g(String str, String str2) {
        k.c("LoginPresenterImpl", "authSuccess type : %s, uid : %s", str, str2);
        s(str, str2);
    }

    @Override // jb.a
    public void l(boolean z10, String str, String str2) {
        rx.c<g> cVar;
        if (z10) {
            f fVar = new f();
            if (lb.c.p(str)) {
                fVar.phone = str;
            }
            fVar.captcha = str2;
            fVar.app = AccountConstant.a();
            cVar = this.f29500e.h(fVar);
        } else {
            sa.e eVar = new sa.e();
            if (lb.c.p(str)) {
                eVar.phone = str;
            } else if (lb.c.n(str)) {
                eVar.email = str;
            }
            eVar.password = lb.c.g(str2);
            eVar.app = AccountConstant.a();
            cVar = this.f29500e.b(eVar);
        }
        this.f29502g.a(cVar.Z(this.f29501f.b()).H(this.f29501f.a()).V(new a()));
    }

    @Override // jb.a
    public void n(String str) {
        String str2;
        String str3;
        String str4 = "sms";
        if (lb.c.p(str)) {
            str3 = str;
            str2 = null;
        } else if (lb.c.n(str)) {
            str4 = "email";
            str2 = str;
            str3 = null;
        } else {
            str3 = null;
            str2 = null;
        }
        this.f29502g.a(this.f29500e.i(str4, str3, str2, "login", lb.c.l()).Z(this.f29501f.b()).H(this.f29501f.a()).V(new c()));
    }

    @Override // qa.a
    public void unsubscribe() {
        this.f29502g.unsubscribe();
        if (this.f29499d.h()) {
            this.f29499d.release();
        }
    }
}
