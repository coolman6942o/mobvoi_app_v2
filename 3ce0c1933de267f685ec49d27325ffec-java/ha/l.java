package ha;

import android.content.Context;
import com.huawei.agconnect.exception.AGCServerException;
import com.mobvoi.android.common.utils.f;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.apollo.client.c0;
import com.mobvoi.apollo.client.q;
import com.mobvoi.apollo.client.r;
import ia.d;
import ia.g;
import ia.h;
import io.m;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.text.u;
import okhttp3.y;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.c;
import rx.i;
/* compiled from: ApolloUpgrade.kt */
/* loaded from: classes2.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private final Context f27776a;

    /* renamed from: b  reason: collision with root package name */
    private final a f27777b;

    /* renamed from: c  reason: collision with root package name */
    private final m f27778c = new p();

    /* renamed from: d  reason: collision with root package name */
    private final r f27779d;

    /* renamed from: e  reason: collision with root package name */
    private h f27780e;

    /* renamed from: f  reason: collision with root package name */
    private File f27781f;

    /* renamed from: g  reason: collision with root package name */
    private final y f27782g;

    /* renamed from: h  reason: collision with root package name */
    private final Retrofit f27783h;

    /* renamed from: i  reason: collision with root package name */
    private final ha.a f27784i;

    /* renamed from: j  reason: collision with root package name */
    private String f27785j;

    /* renamed from: k  reason: collision with root package name */
    private String f27786k;

    /* renamed from: l  reason: collision with root package name */
    private String f27787l;

    /* renamed from: m  reason: collision with root package name */
    private long f27788m;

    /* renamed from: n  reason: collision with root package name */
    private long f27789n;

    /* compiled from: ApolloUpgrade.kt */
    /* loaded from: classes2.dex */
    public interface a {
        void b();

        void onProgress(int i10);
    }

    /* compiled from: ApolloUpgrade.kt */
    /* loaded from: classes2.dex */
    public static final class b extends c0 {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ i<? super String> f27791d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(i<? super String> iVar) {
            super(338);
            this.f27791d = iVar;
        }

        @Override // com.mobvoi.apollo.client.c0
        public void l(int i10) {
            this.f27791d.onError(new Throwable("unread imei"));
        }

        @Override // com.mobvoi.apollo.client.c0
        public void m(byte[] bArr) {
            l lVar = l.this;
            lVar.f27787l = lVar.f27779d.g();
            this.f27791d.onNext(l.this.f27787l);
            this.f27791d.onCompleted();
        }
    }

    /* compiled from: ApolloUpgrade.kt */
    /* loaded from: classes2.dex */
    public static final class c extends i<okhttp3.c0> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f27793b;

        c(h hVar) {
            this.f27793b = hVar;
        }

        /* renamed from: b */
        public void onNext(okhttp3.c0 c0Var) {
        }

        @Override // rx.d
        public void onCompleted() {
            if (k.j()) {
                String i10 = f.i(l.this.y());
                k.a("ApolloUpgrade", "online md5: " + this.f27793b.a().d() + ", local md5: " + ((Object) i10));
            }
            l.this.f27789n = System.currentTimeMillis() / 1000;
            l.this.A("1");
        }

        @Override // rx.d
        public void onError(Throwable e10) {
            kotlin.jvm.internal.i.f(e10, "e");
            l.this.f27789n = System.currentTimeMillis() / 1000;
            l.this.A("7");
            e10.printStackTrace();
        }

        @Override // rx.i
        public void onStart() {
            l.this.f27788m = System.currentTimeMillis() / 1000;
        }
    }

    public l(Context context, a aVar) {
        kotlin.jvm.internal.i.f(context, "context");
        this.f27776a = context;
        this.f27777b = aVar;
        r rVar = new r(context);
        this.f27779d = rVar;
        y.a e10 = new y.a().e(15L, TimeUnit.SECONDS);
        m mVar = m.f28349a;
        y c10 = e10.c();
        this.f27782g = c10;
        Retrofit build = new Retrofit.Builder().client(c10).baseUrl("http://iotapi.abupdate.com").addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.createAsync()).build();
        this.f27783h = build;
        this.f27784i = (ha.a) build.create(ha.a.class);
        this.f27785j = rVar.b();
        this.f27786k = rVar.c();
        this.f27787l = rVar.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(String str) {
        h hVar = this.f27780e;
        if (hVar != null) {
            g a10 = hVar.a();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            ia.f fVar = new ia.f(this.f27787l, a10.a(), str, this.f27788m, this.f27789n, currentTimeMillis, D(currentTimeMillis));
            ha.a aVar = this.f27784i;
            String productId = this.f27778c.getProductId();
            String str2 = this.f27785j;
            kotlin.jvm.internal.i.d(str2);
            aVar.d(productId, str2, fVar).T();
        }
    }

    private final void B(String str) {
        this.f27785j = str;
        this.f27779d.r(str);
    }

    private final void C(String str) {
        this.f27786k = str;
        this.f27779d.s(str);
    }

    private final String D(long j10) {
        o oVar = o.f27794a;
        String str = ((Object) this.f27785j) + this.f27778c.getProductId() + j10;
        String str2 = this.f27786k;
        kotlin.jvm.internal.i.d(str2);
        return oVar.a(str, str2);
    }

    private final rx.a n() {
        if (!z()) {
            rx.a g02 = rx.c.i0(new c.a() { // from class: ha.e
                @Override // yp.b
                public final void call(Object obj) {
                    l.o(l.this, (i) obj);
                }
            }).D(new yp.g() { // from class: ha.k
                @Override // yp.g
                public final Object call(Object obj) {
                    d p10;
                    p10 = l.p(l.this, (String) obj);
                    return p10;
                }
            }).v(new yp.g() { // from class: ha.j
                @Override // yp.g
                public final Object call(Object obj) {
                    c q5;
                    q5 = l.q(l.this, (d) obj);
                    return q5;
                }
            }).c(d.c()).p(new yp.b() { // from class: ha.f
                @Override // yp.b
                public final void call(Object obj) {
                    l.r(l.this, (ia.c) obj);
                }
            }).g0();
            kotlin.jvm.internal.i.e(g02, "{\n            Observable.unsafeCreate<String> {\n                if (mid.isEmpty()) {\n                    ApolloHandler.sendData(Constants.COMMAND_LPA_QUERY_EID,\n                        callback = object : ResponseCallback(Constants.COMMAND_LPA_QUERY_EID_RESP) {\n                            override fun onResponse(byteArray: ByteArray?) {\n                                mid = prefs.getIMEI()\n                                it.onNext(mid)\n                                it.onCompleted()\n                            }\n\n                            override fun onFail(state: Int) {\n                                it.onError(Throwable(\"unread imei\"))\n                            }\n                        })\n                } else {\n                    it.onNext(mid)\n                    it.onCompleted()\n                }\n            }.map { config.createRegister(mid) }\n                .flatMap { register ->\n                    abupService.register(config.productId, register)\n                }\n                .compose(unpack())\n                .doOnNext {\n                    deviceId = it.deviceId\n                    deviceSecret = it.deviceSecret\n                    LogUtil.d(\"TAG\", it.toString())\n                }\n                .toCompletable()\n        }");
            return g02;
        }
        rx.a b10 = rx.a.b();
        kotlin.jvm.internal.i.e(b10, "{\n            Completable.complete()\n        }");
        return b10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(l this$0, i iVar) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (this$0.f27787l.length() == 0) {
            q.L(q.f15504a, 336, null, new b(iVar), 2, null);
            return;
        }
        iVar.onNext(this$0.f27787l);
        iVar.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d p(l this$0, String str) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        return n.a(this$0.f27778c, this$0.f27787l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final rx.c q(l this$0, d register) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        ha.a aVar = this$0.f27784i;
        String productId = this$0.f27778c.getProductId();
        kotlin.jvm.internal.i.e(register, "register");
        return aVar.a(productId, register);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(l this$0, ia.c cVar) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.B(cVar.a());
        this$0.C(cVar.b());
        k.a("TAG", cVar.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final rx.c t(l this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        return this$0.u();
    }

    private final rx.c<h> u() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        ia.b bVar = new ia.b(this.f27787l, this.f27779d.e(), currentTimeMillis, D(currentTimeMillis));
        ha.a aVar = this.f27784i;
        String productId = this.f27778c.getProductId();
        String str = this.f27785j;
        kotlin.jvm.internal.i.d(str);
        rx.c<h> p10 = aVar.c(productId, str, bVar).c(d.c()).p(new yp.b() { // from class: ha.g
            @Override // yp.b
            public final void call(Object obj) {
                l.v(l.this, (h) obj);
            }
        });
        kotlin.jvm.internal.i.e(p10, "abupService.checkVersion(config.productId, deviceId!!, data)\n            .compose(unpack())\n            .doOnNext {\n                versionInfo = it\n                LogUtil.d(\"TAG\", it.toString())\n            }");
        return p10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(l this$0, h hVar) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.f27780e = hVar;
        k.a("TAG", hVar.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(Ref$LongRef downloadedLength, RandomAccessFile randomFile, long j10, l this$0, okhttp3.c0 c0Var) {
        kotlin.jvm.internal.i.f(downloadedLength, "$downloadedLength");
        kotlin.jvm.internal.i.f(randomFile, "$randomFile");
        kotlin.jvm.internal.i.f(this$0, "this$0");
        InputStream byteStream = c0Var.byteStream();
        byte[] bArr = new byte[AGCServerException.UNKNOW_EXCEPTION];
        while (true) {
            try {
                try {
                    int read = byteStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    downloadedLength.element += read;
                    randomFile.write(bArr, 0, read);
                    int i10 = (int) ((downloadedLength.element * 100) / j10);
                    a aVar = this$0.f27777b;
                    if (aVar != null) {
                        aVar.onProgress(i10);
                    }
                } catch (Exception e10) {
                    throw e10;
                }
            } finally {
                byteStream.close();
                randomFile.close();
            }
        }
        a aVar2 = this$0.f27777b;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    private final boolean z() {
        return this.f27785j != null;
    }

    public final rx.c<h> s() {
        rx.c<h> a10 = n().a(rx.c.k(new yp.f() { // from class: ha.i
            @Override // yp.f, java.util.concurrent.Callable
            public final Object call() {
                c t10;
                t10 = l.t(l.this);
                return t10;
            }
        }));
        kotlin.jvm.internal.i.e(a10, "checkRegister()\n            .andThen(Observable.defer { checkVersion() })");
        return a10;
    }

    public final void w() {
        int X;
        h hVar = this.f27780e;
        if (hVar != null) {
            g a10 = hVar.a();
            String b10 = a10.b();
            X = u.X(a10.b(), '/', 0, false, 6, null);
            Objects.requireNonNull(b10, "null cannot be cast to non-null type java.lang.String");
            String substring = b10.substring(X + 1);
            kotlin.jvm.internal.i.e(substring, "(this as java.lang.String).substring(startIndex)");
            this.f27781f = new File(this.f27776a.getCacheDir(), substring);
            final long c10 = a10.c();
            final RandomAccessFile randomAccessFile = new RandomAccessFile(y(), "rwd");
            final Ref$LongRef ref$LongRef = new Ref$LongRef();
            if (y().exists()) {
                ref$LongRef.element = y().length();
            }
            long j10 = ref$LongRef.element;
            if (j10 == c10) {
                a aVar = this.f27777b;
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            randomAccessFile.seek(j10);
            ha.a aVar2 = this.f27784i;
            String b11 = a10.b();
            aVar2.b(b11, "bytes=" + ref$LongRef.element + '-').Z(cq.a.c()).p(new yp.b() { // from class: ha.h
                @Override // yp.b
                public final void call(Object obj) {
                    l.x(Ref$LongRef.this, randomAccessFile, c10, this, (okhttp3.c0) obj);
                }
            }).V(new c(hVar));
        }
    }

    public final File y() {
        File file = this.f27781f;
        if (file != null) {
            return file;
        }
        kotlin.jvm.internal.i.u("packageFile");
        throw null;
    }
}
