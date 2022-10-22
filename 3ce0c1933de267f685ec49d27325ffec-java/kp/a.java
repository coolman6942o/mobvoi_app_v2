package kp;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okhttp3.Headers;
import okio.e;
/* compiled from: HeadersReader.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private long f30360a = 262144;

    /* renamed from: b  reason: collision with root package name */
    private final e f30361b;

    /* compiled from: HeadersReader.kt */
    /* renamed from: kp.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0377a {
        private C0377a() {
        }

        public /* synthetic */ C0377a(f fVar) {
            this();
        }
    }

    static {
        new C0377a(null);
    }

    public a(e source) {
        i.f(source, "source");
        this.f30361b = source;
    }

    public final Headers a() {
        Headers.a aVar = new Headers.a();
        while (true) {
            String b10 = b();
            if (b10.length() == 0) {
                return aVar.f();
            }
            aVar.c(b10);
        }
    }

    public final String b() {
        String J = this.f30361b.J(this.f30360a);
        this.f30360a -= J.length();
        return J;
    }
}
