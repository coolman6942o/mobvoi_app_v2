package kotlin.jvm.internal;
/* compiled from: PackageReference.kt */
/* loaded from: classes3.dex */
public final class k implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f30083a;

    public k(Class<?> jClass, String moduleName) {
        i.f(jClass, "jClass");
        i.f(moduleName, "moduleName");
        this.f30083a = jClass;
    }

    @Override // kotlin.jvm.internal.c
    public Class<?> b() {
        return this.f30083a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof k) && i.b(b(), ((k) obj).b());
    }

    public int hashCode() {
        return b().hashCode();
    }

    public String toString() {
        return b().toString() + " (Kotlin reflection is not available)";
    }
}
