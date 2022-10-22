package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okhttp3.w;
import okio.ByteString;
import okio.d;
import okio.n;
import okio.t;
/* compiled from: RequestBody.kt */
/* loaded from: classes3.dex */
public abstract class a0 {
    public static final a Companion = new a(null);

    /* compiled from: RequestBody.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* compiled from: RequestBody.kt */
        /* renamed from: okhttp3.a0$a$a */
        /* loaded from: classes3.dex */
        public static final class C0424a extends a0 {

            /* renamed from: a */
            final /* synthetic */ File f31743a;

            /* renamed from: b */
            final /* synthetic */ w f31744b;

            C0424a(File file, w wVar) {
                this.f31743a = file;
                this.f31744b = wVar;
            }

            @Override // okhttp3.a0
            public long contentLength() {
                return this.f31743a.length();
            }

            @Override // okhttp3.a0
            public w contentType() {
                return this.f31744b;
            }

            @Override // okhttp3.a0
            public void writeTo(d sink) {
                t k10;
                i.f(sink, "sink");
                try {
                    sink.b0(n.k(this.f31743a));
                    th = null;
                } finally {
                    try {
                        throw th;
                    } finally {
                    }
                }
            }
        }

        /* compiled from: RequestBody.kt */
        /* loaded from: classes3.dex */
        public static final class b extends a0 {

            /* renamed from: a */
            final /* synthetic */ ByteString f31745a;

            /* renamed from: b */
            final /* synthetic */ w f31746b;

            b(ByteString byteString, w wVar) {
                this.f31745a = byteString;
                this.f31746b = wVar;
            }

            @Override // okhttp3.a0
            public long contentLength() {
                return this.f31745a.size();
            }

            @Override // okhttp3.a0
            public w contentType() {
                return this.f31746b;
            }

            @Override // okhttp3.a0
            public void writeTo(d sink) {
                i.f(sink, "sink");
                sink.v0(this.f31745a);
            }
        }

        /* compiled from: RequestBody.kt */
        /* loaded from: classes3.dex */
        public static final class c extends a0 {

            /* renamed from: a */
            final /* synthetic */ byte[] f31747a;

            /* renamed from: b */
            final /* synthetic */ w f31748b;

            /* renamed from: c */
            final /* synthetic */ int f31749c;

            /* renamed from: d */
            final /* synthetic */ int f31750d;

            c(byte[] bArr, w wVar, int i10, int i11) {
                this.f31747a = bArr;
                this.f31748b = wVar;
                this.f31749c = i10;
                this.f31750d = i11;
            }

            @Override // okhttp3.a0
            public long contentLength() {
                return this.f31749c;
            }

            @Override // okhttp3.a0
            public w contentType() {
                return this.f31748b;
            }

            @Override // okhttp3.a0
            public void writeTo(d sink) {
                i.f(sink, "sink");
                sink.e(this.f31747a, this.f31750d, this.f31749c);
            }
        }

        private a() {
        }

        public static /* synthetic */ a0 i(a aVar, w wVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                i10 = 0;
            }
            if ((i12 & 8) != 0) {
                i11 = bArr.length;
            }
            return aVar.f(wVar, bArr, i10, i11);
        }

        public static /* synthetic */ a0 j(a aVar, byte[] bArr, w wVar, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                wVar = null;
            }
            if ((i12 & 2) != 0) {
                i10 = 0;
            }
            if ((i12 & 4) != 0) {
                i11 = bArr.length;
            }
            return aVar.h(bArr, wVar, i10, i11);
        }

        public final a0 a(File asRequestBody, w wVar) {
            i.f(asRequestBody, "$this$asRequestBody");
            return new C0424a(asRequestBody, wVar);
        }

        public final a0 b(String toRequestBody, w wVar) {
            i.f(toRequestBody, "$this$toRequestBody");
            Charset charset = kotlin.text.d.f30092a;
            if (wVar != null) {
                Charset d10 = w.d(wVar, null, 1, null);
                if (d10 == null) {
                    w.a aVar = w.f32297g;
                    wVar = aVar.b(wVar + "; charset=utf-8");
                } else {
                    charset = d10;
                }
            }
            byte[] bytes = toRequestBody.getBytes(charset);
            i.e(bytes, "(this as java.lang.String).getBytes(charset)");
            return h(bytes, wVar, 0, bytes.length);
        }

        public final a0 c(w wVar, File file) {
            i.f(file, "file");
            return a(file, wVar);
        }

        public final a0 d(w wVar, String content) {
            i.f(content, "content");
            return b(content, wVar);
        }

        public final a0 e(w wVar, ByteString content) {
            i.f(content, "content");
            return g(content, wVar);
        }

        public final a0 f(w wVar, byte[] content, int i10, int i11) {
            i.f(content, "content");
            return h(content, wVar, i10, i11);
        }

        public final a0 g(ByteString toRequestBody, w wVar) {
            i.f(toRequestBody, "$this$toRequestBody");
            return new b(toRequestBody, wVar);
        }

        public final a0 h(byte[] toRequestBody, w wVar, int i10, int i11) {
            i.f(toRequestBody, "$this$toRequestBody");
            gp.b.i(toRequestBody.length, i10, i11);
            return new c(toRequestBody, wVar, i11, i10);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public static final a0 create(File file, w wVar) {
        return Companion.a(file, wVar);
    }

    public static final a0 create(String str, w wVar) {
        return Companion.b(str, wVar);
    }

    public static final a0 create(w wVar, File file) {
        return Companion.c(wVar, file);
    }

    public static final a0 create(w wVar, String str) {
        return Companion.d(wVar, str);
    }

    public static final a0 create(w wVar, ByteString byteString) {
        return Companion.e(wVar, byteString);
    }

    public static final a0 create(w wVar, byte[] bArr) {
        return a.i(Companion, wVar, bArr, 0, 0, 12, null);
    }

    public static final a0 create(w wVar, byte[] bArr, int i10) {
        return a.i(Companion, wVar, bArr, i10, 0, 8, null);
    }

    public static final a0 create(w wVar, byte[] bArr, int i10, int i11) {
        return Companion.f(wVar, bArr, i10, i11);
    }

    public static final a0 create(ByteString byteString, w wVar) {
        return Companion.g(byteString, wVar);
    }

    public static final a0 create(byte[] bArr) {
        return a.j(Companion, bArr, null, 0, 0, 7, null);
    }

    public static final a0 create(byte[] bArr, w wVar) {
        return a.j(Companion, bArr, wVar, 0, 0, 6, null);
    }

    public static final a0 create(byte[] bArr, w wVar, int i10) {
        return a.j(Companion, bArr, wVar, i10, 0, 4, null);
    }

    public static final a0 create(byte[] bArr, w wVar, int i10, int i11) {
        return Companion.h(bArr, wVar, i10, i11);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract w contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(d dVar) throws IOException;
}
