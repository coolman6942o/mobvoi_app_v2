package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.i;
/* compiled from: Tuples.kt */
/* loaded from: classes3.dex */
public final class Pair<A, B> implements Serializable {
    private final A first;
    private final B second;

    public Pair(A a10, B b10) {
        this.first = a10;
        this.second = b10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Pair copy$default(Pair pair, Object obj, Object obj2, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            obj = pair.first;
        }
        if ((i10 & 2) != 0) {
            obj2 = pair.second;
        }
        return pair.copy(obj, obj2);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final Pair<A, B> copy(A a10, B b10) {
        return new Pair<>(a10, b10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return i.b(this.first, pair.first) && i.b(this.second, pair.second);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public int hashCode() {
        A a10 = this.first;
        int i10 = 0;
        int hashCode = (a10 != null ? a10.hashCode() : 0) * 31;
        B b10 = this.second;
        if (b10 != null) {
            i10 = b10.hashCode();
        }
        return hashCode + i10;
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}
