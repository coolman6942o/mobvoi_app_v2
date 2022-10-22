package n5;
/* compiled from: MultiClassKey.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f31042a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f31043b;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f31044c;

    public i() {
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f31042a = cls;
        this.f31043b = cls2;
        this.f31044c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f31042a.equals(iVar.f31042a) && this.f31043b.equals(iVar.f31043b) && k.c(this.f31044c, iVar.f31044c);
    }

    public int hashCode() {
        int hashCode = ((this.f31042a.hashCode() * 31) + this.f31043b.hashCode()) * 31;
        Class<?> cls = this.f31044c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f31042a + ", second=" + this.f31043b + '}';
    }

    public i(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}
