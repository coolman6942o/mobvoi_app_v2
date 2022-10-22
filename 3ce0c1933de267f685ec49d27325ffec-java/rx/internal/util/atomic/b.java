package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: BaseLinkedAtomicQueue.java */
/* loaded from: classes3.dex */
abstract class b<E> extends AbstractQueue<E> {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<LinkedQueueNode<E>> f34102a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<LinkedQueueNode<E>> f34103b = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> a() {
        return this.f34103b.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> b() {
        return this.f34102a.get();
    }

    protected final LinkedQueueNode<E> c() {
        return this.f34103b.get();
    }

    protected final LinkedQueueNode<E> d() {
        return this.f34102a.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e(LinkedQueueNode<E> linkedQueueNode) {
        this.f34103b.lazySet(linkedQueueNode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f(LinkedQueueNode<E> linkedQueueNode) {
        this.f34102a.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return c() == d();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> c10 = c();
        LinkedQueueNode<E> d10 = d();
        int i10 = 0;
        while (c10 != d10 && i10 < Integer.MAX_VALUE) {
            do {
                lvNext = c10.lvNext();
            } while (lvNext == null);
            i10++;
            c10 = lvNext;
        }
        return i10;
    }
}
