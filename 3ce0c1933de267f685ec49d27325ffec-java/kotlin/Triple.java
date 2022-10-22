package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.i;
/* compiled from: Tuples.kt */
/* loaded from: classes3.dex */
public final class Triple<A, B, C> implements Serializable {
    private final A first;
    private final B second;
    private final C third;

    public Triple(A a10, B b10, C c10) {
        this.first = a10;
        this.second = b10;
        this.third = c10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Triple copy$default(Triple triple, Object obj, Object obj2, Object obj3, int i10, Object obj4) {
        if ((i10 & 1) != 0) {
            obj = triple.first;
        }
        if ((i10 & 2) != 0) {
            obj2 = triple.second;
        }
        if ((i10 & 4) != 0) {
            obj3 = triple.third;
        }
        return triple.copy(obj, obj2, obj3);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    public final Triple<A, B, C> copy(A a10, B b10, C c10) {
        return new Triple<>(a10, b10, c10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        return i.b(this.first, triple.first) && i.b(this.second, triple.second) && i.b(this.third, triple.third);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }

    public int hashCode() {
        A a10 = this.first;
        int i10 = 0;
        int hashCode = (a10 != null ? a10.hashCode() : 0) * 31;
        B b10 = this.second;
        int hashCode2 = (hashCode + (b10 != null ? b10.hashCode() : 0)) * 31;
        C c10 = this.third;
        if (c10 != null) {
            i10 = c10.hashCode();
        }
        return hashCode2 + i10;
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ", " + this.third + ')';
    }
}
