package kb;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.huawei.agconnect.exception.AGCServerException;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.AccountConstant;
import com.mobvoi.assistant.account.data.AccountManager;
import com.mobvoi.wear.common.base.WearPath;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import okhttp3.a0;
import okhttp3.w;
import okhttp3.x;
import ra.h;
import rx.c;
import rx.i;
import sa.d;
import sa.g;
/* compiled from: ProfilePresenterImpl.java */
/* loaded from: classes2.dex */
public class m implements g {

    /* renamed from: a  reason: collision with root package name */
    private final h f29852a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f29853b;

    /* renamed from: c  reason: collision with root package name */
    private ra.b f29854c = h.b();

    /* renamed from: d  reason: collision with root package name */
    private ua.a f29855d = h.a();

    /* renamed from: e  reason: collision with root package name */
    private dq.b f29856e = new dq.b();

    /* compiled from: ProfilePresenterImpl.java */
    /* loaded from: classes2.dex */
    class a extends i<g> {
        a() {
        }

        /* renamed from: b */
        public void onNext(g gVar) {
            if (gVar.b()) {
                sa.a a10 = sa.a.a(gVar.result);
                if (ta.a.b() && !a10.pii) {
                    a10.pii = true;
                    m.this.A(true);
                }
                ta.a.E(a10);
                m.this.f29852a.Q(a10);
            } else if (gVar.a()) {
                ta.a.c();
                AccountManager.h().f();
                m.this.f29852a.M();
                k.a("ProfilePresenterImpl", "load account info fail:" + gVar.errorMsg);
            }
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.a("ProfilePresenterImpl", "load account info fail:" + th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProfilePresenterImpl.java */
    /* loaded from: classes2.dex */
    public class b extends i<sa.c> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f29858a;

        b(m mVar, boolean z10) {
            this.f29858a = z10;
        }

        /* renamed from: b */
        public void onNext(sa.c cVar) {
            if (cVar.b()) {
                k.a("ProfilePresenterImpl", "pii modify success: " + this.f29858a);
                return;
            }
            k.a("ProfilePresenterImpl", "pii modify failed: " + this.f29858a);
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.e("ProfilePresenterImpl", "modify fail", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProfilePresenterImpl.java */
    /* loaded from: classes2.dex */
    public class c implements yp.g<sa.c, rx.c<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ sa.d f29859a;

        c(sa.d dVar) {
            this.f29859a = dVar;
        }

        /* renamed from: a */
        public rx.c<String> call(sa.c cVar) {
            String string = m.this.f29853b.getString(pa.i.I);
            if (cVar != null) {
                ta.a.M(this.f29859a.result.imageUrl);
                if (cVar.b()) {
                    string = "";
                } else if (cVar.e()) {
                    string = cVar.errorMsg;
                }
            }
            return rx.c.A(string).H(m.this.f29855d.a());
        }
    }

    /* compiled from: ProfilePresenterImpl.java */
    /* loaded from: classes2.dex */
    private static class d implements ra.c {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<h> f29861a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<Context> f29862b;

        public d(h hVar, Context context) {
            this.f29861a = new WeakReference<>(hVar);
            this.f29862b = new WeakReference<>(context);
        }

        @Override // ra.c
        public void a() {
            h hVar = this.f29861a.get();
            Context context = this.f29862b.get();
            if (hVar != null && context != null) {
                hVar.i(context.getString(pa.i.H));
            }
        }

        @Override // ra.c
        public void b(String str) {
            h hVar = this.f29861a.get();
            Context context = this.f29862b.get();
            if (hVar != null && context != null) {
                if (TextUtils.isEmpty(str)) {
                    str = context.getString(pa.i.K);
                }
                hVar.A(str);
            }
        }
    }

    public m(Context context, h hVar) {
        this.f29853b = context;
        this.f29852a = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public rx.c<sa.d> B(Bitmap bitmap) {
        File h10 = lb.c.h(this.f29853b);
        if (bitmap != null) {
            try {
                w(v(bitmap, AGCServerException.UNKNOW_EXCEPTION), 1048576, h10);
            } catch (Exception e10) {
                k.d("ProfilePresenterImpl", e10.getMessage());
            }
        }
        x.c b10 = x.c.b(WearPath.RecorderV2.MAP_KEY_FILE, h10.getName(), a0.create(w.f("image/*"), h10));
        return this.f29854c.k(a0.create(x.f32303g, "user header"), b10).Z(this.f29855d.b()).H(this.f29855d.a());
    }

    private Bitmap v(Bitmap bitmap, int i10) {
        int i11;
        float width = bitmap.getWidth() / bitmap.getHeight();
        if (width >= 1.0f) {
            i11 = (int) (i10 / width);
        } else {
            i10 = (int) (i10 * width);
            i11 = i10;
        }
        return Bitmap.createScaledBitmap(bitmap, i10, i11, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        if (r2 == 5) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void w(Bitmap bitmap, int i10, File file) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i11 = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        while (byteArrayOutputStream.toByteArray().length > i10) {
            byteArrayOutputStream.reset();
            i11 -= 5;
            if (i11 <= 5) {
                i11 = 5;
            }
            bitmap.compress(Bitmap.CompressFormat.JPEG, i11, byteArrayOutputStream);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            bitmap.recycle();
        } catch (Exception e10) {
            k.d("ProfilePresenterImpl", e10.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(Bitmap bitmap, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f29852a.D(bitmap, this.f29853b.getString(pa.i.J));
        } else {
            this.f29852a.S(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(Throwable th2) {
        this.f29852a.m(this.f29853b.getString(pa.i.I));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public rx.c<String> z(sa.d dVar) {
        if (dVar == null || !dVar.b() || dVar.result == null) {
            return rx.c.A(this.f29853b.getString(pa.i.I)).H(this.f29855d.a());
        }
        boolean delete = lb.c.h(this.f29853b).delete();
        k.a("ProfilePresenterImpl", "Del file is " + delete);
        sa.a e10 = ta.a.e();
        e10.headUrl = dVar.result.imageUrl;
        return this.f29854c.e(e10).Z(this.f29855d.b()).v(new c(dVar)).H(this.f29855d.a());
    }

    public void A(boolean z10) {
        this.f29854c.f(ta.a.s(), z10).Z(cq.a.c()).H(xp.a.b()).V(new b(this, z10));
    }

    @Override // kb.g
    public void e() {
        AccountManager.h();
        this.f29856e.a(AccountManager.n(new d(this.f29852a, this.f29853b)));
    }

    @Override // kb.g
    public void i(final Bitmap bitmap) {
        this.f29856e.a(rx.c.A(bitmap).Z(this.f29855d.b()).v(new yp.g() { // from class: kb.k
            @Override // yp.g
            public final Object call(Object obj) {
                c B;
                B = m.this.B((Bitmap) obj);
                return B;
            }
        }).v(new yp.g() { // from class: kb.l
            @Override // yp.g
            public final Object call(Object obj) {
                c z10;
                z10 = m.this.z((d) obj);
                return z10;
            }
        }).H(this.f29855d.a()).Y(new yp.b() { // from class: kb.j
            @Override // yp.b
            public final void call(Object obj) {
                m.this.x(bitmap, (String) obj);
            }
        }, new yp.b() { // from class: kb.i
            @Override // yp.b
            public final void call(Object obj) {
                m.this.y((Throwable) obj);
            }
        }));
    }

    @Override // kb.g
    public void p(String str, String str2) {
        this.f29856e.a(this.f29854c.j(str, str2, AccountConstant.a()).Z(this.f29855d.b()).H(this.f29855d.a()).V(new a()));
    }

    @Override // qa.a
    public void unsubscribe() {
        this.f29856e.unsubscribe();
    }
}
