package okhttp3.logging;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import jp.e;
import kotlin.collections.i0;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import okhttp3.Headers;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.internal.platform.h;
import okhttp3.j;
import okhttp3.v;
import okhttp3.w;
import okhttp3.z;
import okio.c;
import okio.k;
/* compiled from: HttpLoggingInterceptor.kt */
/* loaded from: classes3.dex */
public final class HttpLoggingInterceptor implements v {

    /* renamed from: a  reason: collision with root package name */
    private volatile Set<String> f32235a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Level f32236b;

    /* renamed from: c  reason: collision with root package name */
    private final a f32237c;

    /* compiled from: HttpLoggingInterceptor.kt */
    /* loaded from: classes3.dex */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* compiled from: HttpLoggingInterceptor.kt */
    /* loaded from: classes3.dex */
    public interface a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32238a = new C0439a.C0440a();

        /* compiled from: HttpLoggingInterceptor.kt */
        /* renamed from: okhttp3.logging.HttpLoggingInterceptor$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0439a {

            /* compiled from: HttpLoggingInterceptor.kt */
            /* renamed from: okhttp3.logging.HttpLoggingInterceptor$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            private static final class C0440a implements a {
                @Override // okhttp3.logging.HttpLoggingInterceptor.a
                public void a(String message) {
                    i.f(message, "message");
                    h.l(h.f32213c.g(), message, 0, null, 6, null);
                }
            }

            private C0439a() {
            }

            public /* synthetic */ C0439a(f fVar) {
                this();
            }
        }

        static {
            new C0439a(null);
        }

        void a(String str);
    }

    public HttpLoggingInterceptor() {
        this(null, 1, null);
    }

    public HttpLoggingInterceptor(a logger) {
        Set<String> b10;
        i.f(logger, "logger");
        this.f32237c = logger;
        b10 = i0.b();
        this.f32235a = b10;
        this.f32236b = Level.NONE;
    }

    private final boolean a(Headers headers) {
        boolean p10;
        boolean p11;
        String str = headers.get("Content-Encoding");
        if (str == null) {
            return false;
        }
        p10 = t.p(str, "identity", true);
        if (p10) {
            return false;
        }
        p11 = t.p(str, "gzip", true);
        return !p11;
    }

    private final void c(Headers headers, int i10) {
        String value = this.f32235a.contains(headers.name(i10)) ? "██" : headers.value(i10);
        a aVar = this.f32237c;
        aVar.a(headers.name(i10) + ": " + value);
    }

    public final void b(Level level) {
        i.f(level, "<set-?>");
        this.f32236b = level;
    }

    public final HttpLoggingInterceptor d(Level level) {
        i.f(level, "level");
        this.f32236b = level;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.lang.Long] */
    @Override // okhttp3.v
    public b0 intercept(v.a chain) throws IOException {
        char c10;
        String str;
        String str2;
        boolean p10;
        Charset UTF_8;
        Charset UTF_82;
        i.f(chain, "chain");
        Level level = this.f32236b;
        z request = chain.request();
        if (level == Level.NONE) {
            return chain.a(request);
        }
        boolean z10 = level == Level.BODY;
        boolean z11 = z10 || level == Level.HEADERS;
        a0 a10 = request.a();
        j b10 = chain.b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("--> ");
        sb2.append(request.h());
        sb2.append(' ');
        sb2.append(request.l());
        sb2.append(b10 != null ? " " + b10.a() : "");
        String sb3 = sb2.toString();
        if (!z11 && a10 != 0) {
            sb3 = sb3 + " (" + a10.contentLength() + "-byte body)";
        }
        this.f32237c.a(sb3);
        if (z11) {
            Headers f10 = request.f();
            if (a10 != null) {
                w contentType = a10.contentType();
                if (contentType != null && f10.get("Content-Type") == null) {
                    this.f32237c.a("Content-Type: " + contentType);
                }
                if (a10.contentLength() != -1 && f10.get("Content-Length") == null) {
                    this.f32237c.a("Content-Length: " + a10.contentLength());
                }
            }
            int size = f10.size();
            for (int i10 = 0; i10 < size; i10++) {
                c(f10, i10);
            }
            if (!z10 || a10 == null) {
                this.f32237c.a("--> END " + request.h());
            } else if (a(request.f())) {
                this.f32237c.a("--> END " + request.h() + " (encoded body omitted)");
            } else if (a10.isDuplex()) {
                this.f32237c.a("--> END " + request.h() + " (duplex request body omitted)");
            } else if (a10.isOneShot()) {
                this.f32237c.a("--> END " + request.h() + " (one-shot body omitted)");
            } else {
                c cVar = new c();
                a10.writeTo(cVar);
                w contentType2 = a10.contentType();
                if (contentType2 == null || (UTF_82 = contentType2.c(StandardCharsets.UTF_8)) == null) {
                    UTF_82 = StandardCharsets.UTF_8;
                    i.e(UTF_82, "UTF_8");
                }
                this.f32237c.a("");
                if (qp.a.a(cVar)) {
                    this.f32237c.a(cVar.X(UTF_82));
                    this.f32237c.a("--> END " + request.h() + " (" + a10.contentLength() + "-byte body)");
                } else {
                    this.f32237c.a("--> END " + request.h() + " (binary " + a10.contentLength() + "-byte body omitted)");
                }
            }
        }
        long nanoTime = System.nanoTime();
        try {
            b0 a11 = chain.a(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            c0 c11 = a11.c();
            i.d(c11);
            long contentLength = c11.contentLength();
            String str3 = contentLength != -1 ? contentLength + "-byte" : "unknown-length";
            a aVar = this.f32237c;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("<-- ");
            sb4.append(a11.n());
            if (a11.I().length() == 0) {
                str = "-byte body omitted)";
                str2 = "";
                c10 = ' ';
            } else {
                String I = a11.I();
                StringBuilder sb5 = new StringBuilder();
                str = "-byte body omitted)";
                c10 = ' ';
                sb5.append(String.valueOf(' '));
                sb5.append(I);
                str2 = sb5.toString();
            }
            sb4.append(str2);
            sb4.append(c10);
            sb4.append(a11.g0().l());
            sb4.append(" (");
            sb4.append(millis);
            sb4.append("ms");
            sb4.append(!z11 ? ", " + str3 + " body" : "");
            sb4.append(')');
            aVar.a(sb4.toString());
            if (z11) {
                Headers x10 = a11.x();
                int size2 = x10.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    c(x10, i11);
                }
                if (!z10 || !e.b(a11)) {
                    this.f32237c.a("<-- END HTTP");
                } else if (a(a11.x())) {
                    this.f32237c.a("<-- END HTTP (encoded body omitted)");
                } else {
                    okio.e source = c11.source();
                    source.request(Long.MAX_VALUE);
                    c b11 = source.b();
                    p10 = t.p("gzip", x10.get("Content-Encoding"), true);
                    Throwable th2 = null;
                    if (p10) {
                        ?? valueOf = Long.valueOf(b11.i0());
                        k kVar = new k(b11.clone());
                        try {
                            b11 = new c();
                            b11.b0(kVar);
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    }
                    w contentType3 = c11.contentType();
                    if (contentType3 == null || (UTF_8 = contentType3.c(StandardCharsets.UTF_8)) == null) {
                        UTF_8 = StandardCharsets.UTF_8;
                        i.e(UTF_8, "UTF_8");
                    }
                    if (!qp.a.a(b11)) {
                        this.f32237c.a("");
                        this.f32237c.a("<-- END HTTP (binary " + b11.i0() + str);
                        return a11;
                    }
                    if (contentLength != 0) {
                        this.f32237c.a("");
                        this.f32237c.a(b11.clone().X(UTF_8));
                    }
                    if (th2 != null) {
                        this.f32237c.a("<-- END HTTP (" + b11.i0() + "-byte, " + th2 + "-gzipped-byte body)");
                    } else {
                        this.f32237c.a("<-- END HTTP (" + b11.i0() + "-byte body)");
                    }
                }
            }
            return a11;
        } catch (Exception e10) {
            this.f32237c.a("<-- HTTP FAILED: " + e10);
            throw e10;
        }
    }

    public /* synthetic */ HttpLoggingInterceptor(a aVar, int i10, f fVar) {
        this((i10 & 1) != 0 ? a.f32238a : aVar);
    }
}
