package q4;

import androidx.collection.a;
import java.security.MessageDigest;
import n5.b;
/* compiled from: Options.java */
/* loaded from: classes.dex */
public final class e implements b {

    /* renamed from: b  reason: collision with root package name */
    private final a<d<?>, Object> f32929b = new b();

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void f(d<T> dVar, Object obj, MessageDigest messageDigest) {
        dVar.g(obj, messageDigest);
    }

    @Override // q4.b
    public void b(MessageDigest messageDigest) {
        for (int i10 = 0; i10 < this.f32929b.size(); i10++) {
            f(this.f32929b.j(i10), this.f32929b.n(i10), messageDigest);
        }
    }

    public <T> T c(d<T> dVar) {
        return this.f32929b.containsKey(dVar) ? (T) this.f32929b.get(dVar) : dVar.c();
    }

    public void d(e eVar) {
        this.f32929b.k(eVar.f32929b);
    }

    public <T> e e(d<T> dVar, T t10) {
        this.f32929b.put(dVar, t10);
        return this;
    }

    @Override // q4.b
    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f32929b.equals(((e) obj).f32929b);
        }
        return false;
    }

    @Override // q4.b
    public int hashCode() {
        return this.f32929b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f32929b + '}';
    }
}
