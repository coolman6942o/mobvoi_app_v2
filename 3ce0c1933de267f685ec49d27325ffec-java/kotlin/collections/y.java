package kotlin.collections;

import java.util.Iterator;
import ro.a;
/* compiled from: Iterators.kt */
/* loaded from: classes3.dex */
public abstract class y implements Iterator<Integer>, a {
    /* renamed from: a */
    public final Integer next() {
        return Integer.valueOf(b());
    }

    public abstract int b();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
