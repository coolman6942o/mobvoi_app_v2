package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okhttp3.u;
import okio.c;
import okio.d;
/* compiled from: FormBody.kt */
/* loaded from: classes3.dex */
public final class s extends a0 {

    /* renamed from: c  reason: collision with root package name */
    private static final w f32263c = w.f32297g.a("application/x-www-form-urlencoded");

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f32264a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f32265b;

    /* compiled from: FormBody.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    static {
        new b(null);
    }

    public s(List<String> encodedNames, List<String> encodedValues) {
        i.f(encodedNames, "encodedNames");
        i.f(encodedValues, "encodedValues");
        this.f32264a = gp.b.O(encodedNames);
        this.f32265b = gp.b.O(encodedValues);
    }

    private final long a(d dVar, boolean z10) {
        c cVar;
        if (z10) {
            cVar = new c();
        } else {
            i.d(dVar);
            cVar = dVar.b();
        }
        int size = this.f32264a.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                cVar.C(38);
            }
            cVar.R(this.f32264a.get(i10));
            cVar.C(61);
            cVar.R(this.f32265b.get(i10));
        }
        if (!z10) {
            return 0L;
        }
        long i02 = cVar.i0();
        cVar.c();
        return i02;
    }

    @Override // okhttp3.a0
    public long contentLength() {
        return a(null, true);
    }

    @Override // okhttp3.a0
    public w contentType() {
        return f32263c;
    }

    @Override // okhttp3.a0
    public void writeTo(d sink) throws IOException {
        i.f(sink, "sink");
        a(sink, false);
    }

    /* compiled from: FormBody.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f32266a;

        /* renamed from: b  reason: collision with root package name */
        private final List<String> f32267b;

        /* renamed from: c  reason: collision with root package name */
        private final Charset f32268c;

        public a() {
            this(null, 1, null);
        }

        public a(Charset charset) {
            this.f32268c = charset;
            this.f32266a = new ArrayList();
            this.f32267b = new ArrayList();
        }

        public final a a(String name, String value) {
            i.f(name, "name");
            i.f(value, "value");
            List<String> list = this.f32266a;
            u.b bVar = u.f32275l;
            list.add(u.b.b(bVar, name, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.f32268c, 91, null));
            this.f32267b.add(u.b.b(bVar, value, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.f32268c, 91, null));
            return this;
        }

        public final a b(String name, String value) {
            i.f(name, "name");
            i.f(value, "value");
            List<String> list = this.f32266a;
            u.b bVar = u.f32275l;
            list.add(u.b.b(bVar, name, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.f32268c, 83, null));
            this.f32267b.add(u.b.b(bVar, value, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.f32268c, 83, null));
            return this;
        }

        public final s c() {
            return new s(this.f32266a, this.f32267b);
        }

        public /* synthetic */ a(Charset charset, int i10, f fVar) {
            this((i10 & 1) != 0 ? null : charset);
        }
    }
}
