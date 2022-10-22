package m5;

import java.security.MessageDigest;
import n5.j;
/* compiled from: ObjectKey.java */
/* loaded from: classes.dex */
public final class b implements q4.b {

    /* renamed from: b  reason: collision with root package name */
    private final Object f30605b;

    public b(Object obj) {
        this.f30605b = j.d(obj);
    }

    @Override // q4.b
    public void b(MessageDigest messageDigest) {
        messageDigest.update(this.f30605b.toString().getBytes(q4.b.f32922a));
    }

    @Override // q4.b
    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f30605b.equals(((b) obj).f30605b);
        }
        return false;
    }

    @Override // q4.b
    public int hashCode() {
        return this.f30605b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f30605b + '}';
    }
}
