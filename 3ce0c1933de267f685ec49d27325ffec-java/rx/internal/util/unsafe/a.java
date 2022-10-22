package rx.internal.util.unsafe;

import java.util.Iterator;
import rx.internal.util.atomic.LinkedQueueNode;
/* compiled from: BaseLinkedQueue.java */
/* loaded from: classes3.dex */
abstract class a<E> extends b<E> {
    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return c() == a();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> c10 = c();
        LinkedQueueNode<E> a10 = a();
        int i10 = 0;
        while (c10 != a10 && i10 < Integer.MAX_VALUE) {
            do {
                lvNext = c10.lvNext();
            } while (lvNext == null);
            i10++;
            c10 = lvNext;
        }
        return i10;
    }
}
