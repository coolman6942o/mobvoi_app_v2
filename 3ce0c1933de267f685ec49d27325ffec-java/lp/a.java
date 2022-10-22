package lp;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okio.ByteString;
/* compiled from: Header.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final ByteString f30565d;

    /* renamed from: e  reason: collision with root package name */
    public static final ByteString f30566e;

    /* renamed from: f  reason: collision with root package name */
    public static final ByteString f30567f;

    /* renamed from: g  reason: collision with root package name */
    public static final ByteString f30568g;

    /* renamed from: h  reason: collision with root package name */
    public static final ByteString f30569h;

    /* renamed from: i  reason: collision with root package name */
    public static final ByteString f30570i;

    /* renamed from: a  reason: collision with root package name */
    public final int f30571a;

    /* renamed from: b  reason: collision with root package name */
    public final ByteString f30572b;

    /* renamed from: c  reason: collision with root package name */
    public final ByteString f30573c;

    /* compiled from: Header.kt */
    /* renamed from: lp.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0392a {
        private C0392a() {
        }

        public /* synthetic */ C0392a(f fVar) {
            this();
        }
    }

    static {
        new C0392a(null);
        ByteString.a aVar = ByteString.Companion;
        f30565d = aVar.d(":");
        f30566e = aVar.d(":status");
        f30567f = aVar.d(":method");
        f30568g = aVar.d(":path");
        f30569h = aVar.d(":scheme");
        f30570i = aVar.d(":authority");
    }

    public a(ByteString name, ByteString value) {
        i.f(name, "name");
        i.f(value, "value");
        this.f30572b = name;
        this.f30573c = value;
        this.f30571a = name.size() + 32 + value.size();
    }

    public final ByteString a() {
        return this.f30572b;
    }

    public final ByteString b() {
        return this.f30573c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return i.b(this.f30572b, aVar.f30572b) && i.b(this.f30573c, aVar.f30573c);
    }

    public int hashCode() {
        ByteString byteString = this.f30572b;
        int i10 = 0;
        int hashCode = (byteString != null ? byteString.hashCode() : 0) * 31;
        ByteString byteString2 = this.f30573c;
        if (byteString2 != null) {
            i10 = byteString2.hashCode();
        }
        return hashCode + i10;
    }

    public String toString() {
        return this.f30572b.utf8() + ": " + this.f30573c.utf8();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(String name, String value) {
        this(r0.d(name), r0.d(value));
        i.f(name, "name");
        i.f(value, "value");
        ByteString.a aVar = ByteString.Companion;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(ByteString name, String value) {
        this(name, ByteString.Companion.d(value));
        i.f(name, "name");
        i.f(value, "value");
    }
}
