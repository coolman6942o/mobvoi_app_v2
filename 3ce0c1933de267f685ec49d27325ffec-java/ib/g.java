package ib;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.AccountConstant;
import com.mobvoi.assistant.account.data.AccountManager;
import java.util.Locale;
import ra.h;
import rx.i;
import sa.j;
import sa.m;
/* compiled from: CaptchaPresenterImpl.java */
/* loaded from: classes2.dex */
public class g implements h {

    /* renamed from: a  reason: collision with root package name */
    private final i f28219a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f28220b;

    /* renamed from: c  reason: collision with root package name */
    private final ra.b f28221c = h.b();

    /* renamed from: d  reason: collision with root package name */
    private final ua.a f28222d = h.a();

    /* renamed from: e  reason: collision with root package name */
    private final dq.b f28223e = new dq.b();

    /* compiled from: CaptchaPresenterImpl.java */
    /* loaded from: classes2.dex */
    class a extends i<sa.c> {
        a() {
        }

        /* renamed from: b */
        public void onNext(sa.c cVar) {
            if (cVar.b()) {
                g.this.f28219a.T();
            } else {
                g.this.f28219a.c(cVar.errorMsg);
            }
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.a("CaptchaPresenterImpl", "send captcha fail:" + th2.getMessage());
            g.this.f28219a.c(g.this.f28220b.getString(pa.i.K));
        }
    }

    /* compiled from: CaptchaPresenterImpl.java */
    /* loaded from: classes2.dex */
    class b extends i<sa.c> {
        b() {
        }

        /* renamed from: b */
        public void onNext(sa.c cVar) {
            if (cVar.b()) {
                Toast.makeText(g.this.f28220b, pa.i.Q, 0).show();
                g.this.f28219a.K();
                return;
            }
            g.this.f28219a.X(cVar.errorMsg);
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.a("CaptchaPresenterImpl", "rebind new account fail:" + th2.getMessage());
        }
    }

    /* compiled from: CaptchaPresenterImpl.java */
    /* loaded from: classes2.dex */
    class c extends i<sa.c> {
        c() {
        }

        /* renamed from: b */
        public void onNext(sa.c cVar) {
            if (cVar.b()) {
                g.this.f28219a.K();
            } else {
                g.this.f28219a.X(cVar.errorMsg);
            }
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.a("CaptchaPresenterImpl", "bindThirdParty fail:" + th2.getMessage());
            g.this.f28219a.X(g.this.f28220b.getString(pa.i.K));
        }
    }

    /* compiled from: CaptchaPresenterImpl.java */
    /* loaded from: classes2.dex */
    class d extends i<sa.c> {
        d() {
        }

        /* renamed from: b */
        public void onNext(sa.c cVar) {
            if (cVar.b()) {
                g.this.f28219a.K();
            } else {
                g.this.f28219a.X(cVar.errorMsg);
            }
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.a("CaptchaPresenterImpl", "pwd fail:" + th2.getMessage());
            g.this.f28219a.X(g.this.f28220b.getString(pa.i.K));
        }
    }

    /* compiled from: CaptchaPresenterImpl.java */
    /* loaded from: classes2.dex */
    class e extends i<sa.c> {
        e() {
        }

        /* renamed from: b */
        public void onNext(sa.c cVar) {
            if (cVar.b()) {
                g.this.f28219a.K();
            } else {
                g.this.f28219a.X(cVar.errorMsg);
            }
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.a("CaptchaPresenterImpl", "pwd fail:" + th2.getMessage());
            g.this.f28219a.X(g.this.f28220b.getString(pa.i.K));
        }
    }

    /* compiled from: CaptchaPresenterImpl.java */
    /* loaded from: classes2.dex */
    class f extends i<sa.g> {
        f() {
        }

        /* renamed from: b */
        public void onNext(sa.g gVar) {
            if (gVar.b()) {
                sa.a e10 = ta.a.e();
                sa.a a10 = sa.a.a(gVar.result);
                if (a10 != null) {
                    boolean z10 = false;
                    boolean z11 = true;
                    if (TextUtils.isEmpty(a10.headUrl) && !TextUtils.isEmpty(e10.headUrl)) {
                        a10.headUrl = e10.headUrl;
                        z10 = true;
                    }
                    if (TextUtils.isEmpty(a10.nickName) && !TextUtils.isEmpty(e10.nickName)) {
                        a10.nickName = e10.nickName;
                        z10 = true;
                    }
                    if (!TextUtils.isEmpty(a10.email) || TextUtils.isEmpty(e10.email)) {
                        z11 = z10;
                    } else {
                        a10.email = e10.email;
                    }
                    if (z11) {
                        g.this.v(a10);
                    }
                    ta.a.E(a10);
                }
                g.this.f28219a.a();
                AccountManager.h().l();
                return;
            }
            g.this.f28219a.b(gVar.errorMsg);
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.a("CaptchaPresenterImpl", "login fail:" + th2.getMessage());
            g.this.f28219a.b(g.this.f28220b.getString(pa.i.K));
        }
    }

    /* compiled from: CaptchaPresenterImpl.java */
    /* renamed from: ib.g$g  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0313g extends i<sa.c> {
        C0313g() {
        }

        /* renamed from: b */
        public void onNext(sa.c cVar) {
            if (cVar.b()) {
                g.this.f28219a.K();
            } else {
                g.this.f28219a.X(cVar.errorMsg);
            }
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.a("CaptchaPresenterImpl", "login fail:" + th2.getMessage());
            g.this.f28219a.X(g.this.f28220b.getString(pa.i.K));
        }
    }

    public g(Context context, i iVar) {
        this.f28220b = context;
        this.f28219a = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(sa.c cVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(sa.a aVar) {
        if (aVar != null) {
            this.f28223e.a(this.f28221c.e(aVar).Z(this.f28222d.b()).H(this.f28222d.a()).Y(ib.e.f28217a, ib.f.f28218a));
        }
    }

    @Override // ib.h
    public void b(String str, String str2) {
        String str3;
        String str4;
        String d10 = AccountConstant.d(str);
        String str5 = "sms";
        if (lb.c.p(str2)) {
            str4 = str2;
            str3 = null;
        } else if (lb.c.n(str2)) {
            str5 = "email";
            str3 = str2;
            str4 = null;
        } else {
            str4 = null;
            str3 = null;
        }
        this.f28223e.a(this.f28221c.i(str5, str4, str3, d10, lb.c.l()).Z(this.f28222d.b()).H(this.f28222d.a()).V(new a()));
    }

    @Override // ib.h
    public void f(String str, String str2, String str3, String str4, String str5) {
        m mVar = new m();
        if (lb.c.p(str)) {
            mVar.phone = str;
        } else if (lb.c.n(str)) {
            mVar.email = str;
        }
        mVar.password = lb.c.g(str3);
        mVar.captcha = str2;
        mVar.type = str4;
        mVar.uid = str5;
        mVar.source = AccountConstant.a();
        this.f28223e.a(this.f28221c.l(mVar).Z(this.f28222d.b()).H(this.f28222d.a()).V(new C0313g()));
    }

    @Override // ib.h
    public void h(String str, String str2, String str3, String str4) {
        j jVar = new j();
        jVar.needCaptcha = true;
        if (lb.c.p(str)) {
            jVar.phone = str;
            jVar.captchaType = "sms";
        } else if (lb.c.n(str)) {
            jVar.email = str;
            jVar.captchaType = "email";
        }
        if (!TextUtils.isEmpty(str4)) {
            jVar.captchaType = str4;
        }
        jVar.password = lb.c.g(str3);
        jVar.captcha = str2;
        jVar.appkey = AccountConstant.a();
        jVar.agree = true;
        if (com.mobvoi.companion.base.settings.a.isOversea()) {
            jVar.region = Locale.getDefault().getDisplayCountry(Locale.ENGLISH);
        }
        this.f28223e.a(this.f28221c.n(jVar).Z(this.f28222d.b()).H(this.f28222d.a()).V(new d()));
    }

    @Override // ib.h
    public void j(String str, String str2, String str3) {
        sa.h hVar = new sa.h();
        hVar.captcha = str3;
        hVar.usage = "rebind";
        if (lb.c.p(str2)) {
            hVar.phone = str2;
        } else if (lb.c.n(str2)) {
            hVar.email = str2;
        }
        this.f28223e.a(this.f28221c.m(AccountManager.h().g().sessionId, hVar).Z(this.f28222d.b()).H(this.f28222d.a()).V(new b()));
    }

    @Override // ib.h
    public void k(String str, String str2, String str3, String str4) {
        sa.k kVar = new sa.k();
        kVar.uid = str4;
        kVar.type = str3;
        kVar.captcha = str2;
        kVar.source = AccountConstant.a();
        if (lb.c.p(str)) {
            kVar.phone = str;
        } else if (lb.c.n(str)) {
            kVar.email = str;
        }
        this.f28223e.a(this.f28221c.a(kVar).Z(this.f28222d.b()).H(this.f28222d.a()).V(new c()));
    }

    @Override // ib.h
    public void m(String str, String str2) {
        sa.e eVar = new sa.e();
        if (lb.c.p(str)) {
            eVar.phone = str;
        } else if (lb.c.n(str)) {
            eVar.email = str;
        }
        eVar.password = lb.c.g(str2);
        eVar.app = AccountConstant.a();
        this.f28223e.a(this.f28221c.b(eVar).Z(this.f28222d.b()).H(this.f28222d.a()).V(new f()));
    }

    @Override // ib.h
    public void o(String str, String str2, String str3) {
        sa.i iVar = new sa.i();
        iVar.needCaptcha = true;
        if (lb.c.p(str)) {
            iVar.phone = str;
            iVar.captchaType = "sms";
        } else if (lb.c.n(str)) {
            iVar.email = str;
            iVar.captchaType = "email";
        }
        iVar.password = lb.c.g(str3);
        iVar.captcha = str2;
        iVar.appkey = AccountConstant.a();
        this.f28223e.a(this.f28221c.d(iVar).Z(this.f28222d.b()).H(this.f28222d.a()).V(new e()));
    }

    @Override // qa.a
    public void unsubscribe() {
        this.f28223e.unsubscribe();
    }
}
