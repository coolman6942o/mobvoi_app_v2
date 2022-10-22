package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okhttp3.Headers;
import okhttp3.w;
import okio.ByteString;
import okio.d;
/* compiled from: MultipartBody.kt */
/* loaded from: classes3.dex */
public final class x extends a0 {

    /* renamed from: f  reason: collision with root package name */
    public static final w f32302f;

    /* renamed from: g  reason: collision with root package name */
    public static final w f32303g;

    /* renamed from: j  reason: collision with root package name */
    private static final byte[] f32306j;

    /* renamed from: a  reason: collision with root package name */
    private final w f32308a;

    /* renamed from: b  reason: collision with root package name */
    private long f32309b = -1;

    /* renamed from: c  reason: collision with root package name */
    private final ByteString f32310c;

    /* renamed from: d  reason: collision with root package name */
    private final w f32311d;

    /* renamed from: e  reason: collision with root package name */
    private final List<c> f32312e;

    /* renamed from: k  reason: collision with root package name */
    public static final b f32307k = new b(null);

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f32304h = {(byte) 58, (byte) 32};

    /* renamed from: i  reason: collision with root package name */
    private static final byte[] f32305i = {(byte) 13, (byte) 10};

    /* compiled from: MultipartBody.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public final void a(StringBuilder appendQuotedString, String key) {
            i.f(appendQuotedString, "$this$appendQuotedString");
            i.f(key, "key");
            appendQuotedString.append('\"');
            int length = key.length();
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = key.charAt(i10);
                if (charAt == '\n') {
                    appendQuotedString.append("%0A");
                } else if (charAt == '\r') {
                    appendQuotedString.append("%0D");
                } else if (charAt != '\"') {
                    appendQuotedString.append(charAt);
                } else {
                    appendQuotedString.append("%22");
                }
            }
            appendQuotedString.append('\"');
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    /* compiled from: MultipartBody.kt */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        public static final a f32316c = new a(null);

        /* renamed from: a  reason: collision with root package name */
        private final Headers f32317a;

        /* renamed from: b  reason: collision with root package name */
        private final a0 f32318b;

        /* compiled from: MultipartBody.kt */
        /* loaded from: classes3.dex */
        public static final class a {
            private a() {
            }

            public final c a(Headers headers, a0 body) {
                i.f(body, "body");
                boolean z10 = true;
                if ((headers != null ? headers.get("Content-Type") : null) == null) {
                    if ((headers != null ? headers.get("Content-Length") : null) != null) {
                        z10 = false;
                    }
                    if (z10) {
                        return new c(headers, body, null);
                    }
                    throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
                }
                throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
            }

            public final c b(String name, String str, a0 body) {
                i.f(name, "name");
                i.f(body, "body");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("form-data; name=");
                b bVar = x.f32307k;
                bVar.a(sb2, name);
                if (str != null) {
                    sb2.append("; filename=");
                    bVar.a(sb2, str);
                }
                String sb3 = sb2.toString();
                i.e(sb3, "StringBuilder().apply(builderAction).toString()");
                return a(new Headers.a().e("Content-Disposition", sb3).f(), body);
            }

            public /* synthetic */ a(f fVar) {
                this();
            }
        }

        private c(Headers headers, a0 a0Var) {
            this.f32317a = headers;
            this.f32318b = a0Var;
        }

        public static final c b(String str, String str2, a0 a0Var) {
            return f32316c.b(str, str2, a0Var);
        }

        public final a0 a() {
            return this.f32318b;
        }

        public final Headers c() {
            return this.f32317a;
        }

        public /* synthetic */ c(Headers headers, a0 a0Var, f fVar) {
            this(headers, a0Var);
        }
    }

    static {
        w.a aVar = w.f32297g;
        f32302f = aVar.a("multipart/mixed");
        aVar.a("multipart/alternative");
        aVar.a("multipart/digest");
        aVar.a("multipart/parallel");
        f32303g = aVar.a("multipart/form-data");
        byte b10 = (byte) 45;
        f32306j = new byte[]{b10, b10};
    }

    public x(ByteString boundaryByteString, w type, List<c> parts) {
        i.f(boundaryByteString, "boundaryByteString");
        i.f(type, "type");
        i.f(parts, "parts");
        this.f32310c = boundaryByteString;
        this.f32311d = type;
        this.f32312e = parts;
        w.a aVar = w.f32297g;
        this.f32308a = aVar.a(type + "; boundary=" + a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long b(d dVar, boolean z10) throws IOException {
        okio.c cVar;
        if (z10) {
            dVar = new okio.c();
            cVar = dVar;
        } else {
            cVar = 0;
        }
        int size = this.f32312e.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            c cVar2 = this.f32312e.get(i10);
            Headers c10 = cVar2.c();
            a0 a10 = cVar2.a();
            i.d(dVar);
            dVar.s0(f32306j);
            dVar.v0(this.f32310c);
            dVar.s0(f32305i);
            if (c10 != null) {
                int size2 = c10.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    dVar.R(c10.name(i11)).s0(f32304h).R(c10.value(i11)).s0(f32305i);
                }
            }
            w contentType = a10.contentType();
            if (contentType != null) {
                dVar.R("Content-Type: ").R(contentType.toString()).s0(f32305i);
            }
            long contentLength = a10.contentLength();
            if (contentLength != -1) {
                dVar.R("Content-Length: ").C0(contentLength).s0(f32305i);
            } else if (z10) {
                i.d(cVar);
                cVar.c();
                return -1L;
            }
            byte[] bArr = f32305i;
            dVar.s0(bArr);
            if (z10) {
                j10 += contentLength;
            } else {
                a10.writeTo(dVar);
            }
            dVar.s0(bArr);
        }
        i.d(dVar);
        byte[] bArr2 = f32306j;
        dVar.s0(bArr2);
        dVar.v0(this.f32310c);
        dVar.s0(bArr2);
        dVar.s0(f32305i);
        if (!z10) {
            return j10;
        }
        i.d(cVar);
        long i02 = j10 + cVar.i0();
        cVar.c();
        return i02;
    }

    public final String a() {
        return this.f32310c.utf8();
    }

    @Override // okhttp3.a0
    public long contentLength() throws IOException {
        long j10 = this.f32309b;
        if (j10 != -1) {
            return j10;
        }
        long b10 = b(null, true);
        this.f32309b = b10;
        return b10;
    }

    @Override // okhttp3.a0
    public w contentType() {
        return this.f32308a;
    }

    @Override // okhttp3.a0
    public void writeTo(d sink) throws IOException {
        i.f(sink, "sink");
        b(sink, false);
    }

    /* compiled from: MultipartBody.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ByteString f32313a;

        /* renamed from: b  reason: collision with root package name */
        private w f32314b;

        /* renamed from: c  reason: collision with root package name */
        private final List<c> f32315c;

        public a() {
            this(null, 1, null);
        }

        public a(String boundary) {
            i.f(boundary, "boundary");
            this.f32313a = ByteString.Companion.d(boundary);
            this.f32314b = x.f32302f;
            this.f32315c = new ArrayList();
        }

        public final a a(Headers headers, a0 body) {
            i.f(body, "body");
            b(c.f32316c.a(headers, body));
            return this;
        }

        public final a b(c part) {
            i.f(part, "part");
            this.f32315c.add(part);
            return this;
        }

        public final x c() {
            if (!this.f32315c.isEmpty()) {
                return new x(this.f32313a, this.f32314b, gp.b.O(this.f32315c));
            }
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }

        public final a d(w type) {
            i.f(type, "type");
            if (i.b(type.h(), "multipart")) {
                this.f32314b = type;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + type).toString());
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ a(String str, int i10, f fVar) {
            this(str);
            if ((i10 & 1) != 0) {
                str = UUID.randomUUID().toString();
                i.e(str, "UUID.randomUUID().toString()");
            }
        }
    }
}
