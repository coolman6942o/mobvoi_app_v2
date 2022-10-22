package wc;

import com.mobvoi.android.common.utils.o;
import com.mobvoi.assistant.account.data.c;
import okhttp3.y;
import ra.f;
/* compiled from: AuthorizeController.java */
/* loaded from: classes2.dex */
public class b extends f {

    /* renamed from: c  reason: collision with root package name */
    private static b f36219c;

    /* renamed from: b  reason: collision with root package name */
    protected a f36220b = (a) this.f33485a.create(a.class);

    private b() {
    }

    public static synchronized b v() {
        b bVar;
        synchronized (b.class) {
            if (f36219c == null) {
                f36219c = new b();
            }
            bVar = f36219c;
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ra.f
    public void p(y.a aVar) {
        super.p(aVar);
        aVar.a(new c());
    }

    @Override // ra.f
    protected String q() {
        return "http://health.ticwear.com/";
    }

    public rx.c<c> t(String str) {
        o.e(str);
        return this.f36220b.a(str);
    }

    public rx.c<sa.c> u(String str) {
        o.e(str);
        return this.f36220b.d(str);
    }

    public rx.c<sa.c> w(String str, String str2, String str3) {
        o.e(str);
        o.e(str2);
        o.e(str3);
        return this.f36220b.c(str, str2, str3);
    }

    public rx.c<sa.c> x(String str) {
        o.e(str);
        return this.f36220b.b(str);
    }
}
