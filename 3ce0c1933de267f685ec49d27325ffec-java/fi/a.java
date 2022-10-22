package fi;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.Regex;
/* compiled from: LeConnectState.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final C0288a f27043c = new C0288a(null);

    /* renamed from: a  reason: collision with root package name */
    private final int f27044a;

    /* renamed from: b  reason: collision with root package name */
    private final String f27045b;

    /* compiled from: LeConnectState.kt */
    /* renamed from: fi.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0288a {
        private C0288a() {
        }

        public /* synthetic */ C0288a(f fVar) {
            this();
        }

        public final a a(String address) {
            i.f(address, "address");
            return new a(1, address);
        }

        public final a b(String address) {
            i.f(address, "address");
            return new a(2, address);
        }

        public final a c(String address) {
            i.f(address, "address");
            return new a(0, address);
        }
    }

    public a(int i10, String address) {
        i.f(address, "address");
        this.f27044a = i10;
        this.f27045b = address;
    }

    public static final a a(String str) {
        return f27043c.c(str);
    }

    public final String b() {
        return this.f27045b;
    }

    public final int c() {
        return this.f27044a;
    }

    public final boolean d(String macAddress) {
        i.f(macAddress, "macAddress");
        return i.b(this.f27045b, macAddress) || i.b(new Regex(":").replace(macAddress, ""), this.f27045b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f27044a == aVar.f27044a && i.b(this.f27045b, aVar.f27045b);
    }

    public int hashCode() {
        return (this.f27044a * 31) + this.f27045b.hashCode();
    }

    public String toString() {
        return "LeConnectState(status=" + this.f27044a + ", address=" + this.f27045b + ')';
    }
}
