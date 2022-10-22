package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;
import kotlin.text.d;
import okhttp3.w;
import okio.ByteString;
import okio.c;
import okio.e;
import qo.l;
/* compiled from: ResponseBody.kt */
/* loaded from: classes3.dex */
public abstract class c0 implements Closeable {
    public static final b Companion = new b(null);
    private Reader reader;

    /* compiled from: ResponseBody.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Reader {

        /* renamed from: a  reason: collision with root package name */
        private boolean f31810a;

        /* renamed from: b  reason: collision with root package name */
        private Reader f31811b;

        /* renamed from: c  reason: collision with root package name */
        private final e f31812c;

        /* renamed from: d  reason: collision with root package name */
        private final Charset f31813d;

        public a(e source, Charset charset) {
            i.f(source, "source");
            i.f(charset, "charset");
            this.f31812c = source;
            this.f31813d = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f31810a = true;
            Reader reader = this.f31811b;
            if (reader != null) {
                reader.close();
            } else {
                this.f31812c.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cbuf, int i10, int i11) throws IOException {
            i.f(cbuf, "cbuf");
            if (!this.f31810a) {
                Reader reader = this.f31811b;
                if (reader == null) {
                    reader = new InputStreamReader(this.f31812c.F0(), gp.b.F(this.f31812c, this.f31813d));
                    this.f31811b = reader;
                }
                return reader.read(cbuf, i10, i11);
            }
            throw new IOException("Stream closed");
        }
    }

    /* compiled from: ResponseBody.kt */
    /* loaded from: classes3.dex */
    public static final class b {

        /* compiled from: ResponseBody.kt */
        /* loaded from: classes3.dex */
        public static final class a extends c0 {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ e f31814a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ w f31815b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ long f31816c;

            a(e eVar, w wVar, long j10) {
                this.f31814a = eVar;
                this.f31815b = wVar;
                this.f31816c = j10;
            }

            @Override // okhttp3.c0
            public long contentLength() {
                return this.f31816c;
            }

            @Override // okhttp3.c0
            public w contentType() {
                return this.f31815b;
            }

            @Override // okhttp3.c0
            public e source() {
                return this.f31814a;
            }
        }

        private b() {
        }

        public static /* synthetic */ c0 i(b bVar, byte[] bArr, w wVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                wVar = null;
            }
            return bVar.h(bArr, wVar);
        }

        public final c0 a(String toResponseBody, w wVar) {
            i.f(toResponseBody, "$this$toResponseBody");
            Charset charset = d.f30092a;
            if (wVar != null) {
                Charset d10 = w.d(wVar, null, 1, null);
                if (d10 == null) {
                    w.a aVar = w.f32297g;
                    wVar = aVar.b(wVar + "; charset=utf-8");
                } else {
                    charset = d10;
                }
            }
            c J0 = new c().J0(toResponseBody, charset);
            return f(J0, wVar, J0.i0());
        }

        public final c0 b(w wVar, long j10, e content) {
            i.f(content, "content");
            return f(content, wVar, j10);
        }

        public final c0 c(w wVar, String content) {
            i.f(content, "content");
            return a(content, wVar);
        }

        public final c0 d(w wVar, ByteString content) {
            i.f(content, "content");
            return g(content, wVar);
        }

        public final c0 e(w wVar, byte[] content) {
            i.f(content, "content");
            return h(content, wVar);
        }

        public final c0 f(e asResponseBody, w wVar, long j10) {
            i.f(asResponseBody, "$this$asResponseBody");
            return new a(asResponseBody, wVar, j10);
        }

        public final c0 g(ByteString toResponseBody, w wVar) {
            i.f(toResponseBody, "$this$toResponseBody");
            return f(new c().v0(toResponseBody), wVar, toResponseBody.size());
        }

        public final c0 h(byte[] toResponseBody, w wVar) {
            i.f(toResponseBody, "$this$toResponseBody");
            return f(new c().s0(toResponseBody), wVar, toResponseBody.length);
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    private final Charset charset() {
        Charset c10;
        w contentType = contentType();
        return (contentType == null || (c10 = contentType.c(d.f30092a)) == null) ? d.f30092a : c10;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Object] */
    private final <T> T consumeSource(l<? super e, ? extends T> lVar, l<? super T, Integer> lVar2) {
        long contentLength = contentLength();
        if (contentLength <= Integer.MAX_VALUE) {
            e source = source();
            try {
                T invoke = lVar.invoke(source);
                h.b(1);
                oo.b.a(source, null);
                h.a(1);
                int intValue = lVar2.invoke(invoke).intValue();
                if (contentLength == -1 || contentLength == intValue) {
                    return invoke;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + intValue + ") disagree");
            } finally {
                try {
                    throw th;
                } catch (Throwable th2) {
                }
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
    }

    public static final c0 create(String str, w wVar) {
        return Companion.a(str, wVar);
    }

    public static final c0 create(w wVar, long j10, e eVar) {
        return Companion.b(wVar, j10, eVar);
    }

    public static final c0 create(w wVar, String str) {
        return Companion.c(wVar, str);
    }

    public static final c0 create(w wVar, ByteString byteString) {
        return Companion.d(wVar, byteString);
    }

    public static final c0 create(w wVar, byte[] bArr) {
        return Companion.e(wVar, bArr);
    }

    public static final c0 create(ByteString byteString, w wVar) {
        return Companion.g(byteString, wVar);
    }

    public static final c0 create(e eVar, w wVar, long j10) {
        return Companion.f(eVar, wVar, j10);
    }

    public static final c0 create(byte[] bArr, w wVar) {
        return Companion.h(bArr, wVar);
    }

    public final InputStream byteStream() {
        return source().F0();
    }

    /* JADX WARN: Finally extract failed */
    public final ByteString byteString() throws IOException {
        long contentLength = contentLength();
        if (contentLength <= Integer.MAX_VALUE) {
            e source = source();
            try {
                ByteString d02 = source.d0();
                oo.b.a(source, null);
                int size = d02.size();
                if (contentLength == -1 || contentLength == size) {
                    return d02;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + size + ") disagree");
            } finally {
                try {
                    throw th;
                } catch (Throwable th2) {
                }
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
    }

    /* JADX WARN: Finally extract failed */
    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength <= Integer.MAX_VALUE) {
            e source = source();
            try {
                byte[] z10 = source.z();
                oo.b.a(source, null);
                int length = z10.length;
                if (contentLength == -1 || contentLength == length) {
                    return z10;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + length + ") disagree");
            } finally {
                try {
                    throw th;
                } catch (Throwable th2) {
                }
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        a aVar = new a(source(), charset());
        this.reader = aVar;
        return aVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        gp.b.j(source());
    }

    public abstract long contentLength();

    public abstract w contentType();

    public abstract e source();

    public final String string() throws IOException {
        e source = source();
        try {
            th = null;
            return source.X(gp.b.F(source, charset()));
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }
}
