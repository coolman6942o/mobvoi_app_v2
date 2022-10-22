package kotlin.collections;

import kotlin.jvm.internal.i;
/* compiled from: IndexedValue.kt */
/* loaded from: classes3.dex */
public final class x<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f30060a;

    /* renamed from: b  reason: collision with root package name */
    private final T f30061b;

    public x(int i10, T t10) {
        this.f30060a = i10;
        this.f30061b = t10;
    }

    public final int a() {
        return this.f30060a;
    }

    public final T b() {
        return this.f30061b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f30060a == xVar.f30060a && i.b(this.f30061b, xVar.f30061b);
    }

    public int hashCode() {
        int i10 = this.f30060a * 31;
        T t10 = this.f30061b;
        return i10 + (t10 != null ? t10.hashCode() : 0);
    }

    public String toString() {
        return "IndexedValue(index=" + this.f30060a + ", value=" + this.f30061b + ")";
    }
}
