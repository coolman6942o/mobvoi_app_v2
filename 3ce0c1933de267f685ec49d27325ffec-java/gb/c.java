package gb;

import android.content.Context;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.AccountConstant;
import ra.b;
import ra.h;
import rx.i;
/* compiled from: AccountPresenterImpl.java */
/* loaded from: classes2.dex */
public class c implements f {

    /* renamed from: a  reason: collision with root package name */
    private final g f27313a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f27314b;

    /* renamed from: c  reason: collision with root package name */
    private b f27315c = h.b();

    /* renamed from: d  reason: collision with root package name */
    private ua.a f27316d = h.a();

    /* renamed from: e  reason: collision with root package name */
    private dq.b f27317e = new dq.b();

    /* compiled from: AccountPresenterImpl.java */
    /* loaded from: classes2.dex */
    class a extends i<sa.c> {
        a() {
        }

        /* renamed from: b */
        public void onNext(sa.c cVar) {
            if (cVar.b()) {
                c.this.f27313a.x(false);
            } else if (cVar.d()) {
                c.this.f27313a.x(true);
            } else {
                c.this.f27313a.c(cVar.errorMsg);
            }
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.a("AccountPresenterImpl", "send captcha fail:" + th2.getMessage());
            c.this.f27313a.c(c.this.f27314b.getString(pa.i.K));
        }
    }

    public c(Context context, g gVar) {
        this.f27314b = context;
        this.f27313a = gVar;
    }

    @Override // gb.f
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
        this.f27317e.a(this.f27315c.i(str5, str4, str3, d10, lb.c.l()).Z(this.f27316d.b()).H(this.f27316d.a()).V(new a()));
    }

    @Override // qa.a
    public void unsubscribe() {
        this.f27317e.unsubscribe();
    }
}
