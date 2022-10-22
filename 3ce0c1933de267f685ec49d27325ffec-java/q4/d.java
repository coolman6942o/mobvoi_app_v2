package q4;

import java.security.MessageDigest;
import n5.j;
/* compiled from: Option.java */
/* loaded from: classes.dex */
public final class d<T> {

    /* renamed from: e  reason: collision with root package name */
    private static final b<Object> f32924e = new a();

    /* renamed from: a  reason: collision with root package name */
    private final T f32925a;

    /* renamed from: b  reason: collision with root package name */
    private final b<T> f32926b;

    /* renamed from: c  reason: collision with root package name */
    private final String f32927c;

    /* renamed from: d  reason: collision with root package name */
    private volatile byte[] f32928d;

    /* compiled from: Option.java */
    /* loaded from: classes.dex */
    class a implements b<Object> {
        a() {
        }

        @Override // q4.d.b
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }

    /* compiled from: Option.java */
    /* loaded from: classes.dex */
    public interface b<T> {
        void a(byte[] bArr, T t10, MessageDigest messageDigest);
    }

    private d(String str, T t10, b<T> bVar) {
        this.f32927c = j.b(str);
        this.f32925a = t10;
        this.f32926b = (b) j.d(bVar);
    }

    public static <T> d<T> a(String str, T t10, b<T> bVar) {
        return new d<>(str, t10, bVar);
    }

    private static <T> b<T> b() {
        return (b<T>) f32924e;
    }

    private byte[] d() {
        if (this.f32928d == null) {
            this.f32928d = this.f32927c.getBytes(q4.b.f32922a);
        }
        return this.f32928d;
    }

    public static <T> d<T> e(String str) {
        return new d<>(str, null, b());
    }

    public static <T> d<T> f(String str, T t10) {
        return new d<>(str, t10, b());
    }

    public T c() {
        return this.f32925a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f32927c.equals(((d) obj).f32927c);
        }
        return false;
    }

    public void g(T t10, MessageDigest messageDigest) {
        this.f32926b.a(d(), t10, messageDigest);
    }

    public int hashCode() {
        return this.f32927c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f32927c + "'}";
    }
}
