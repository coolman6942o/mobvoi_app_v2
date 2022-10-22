package rx.internal.util.atomic;

import java.util.Objects;
/* compiled from: SpscLinkedAtomicQueue.java */
/* loaded from: classes3.dex */
public final class d<E> extends b<E> {
    public d() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        f(linkedQueueNode);
        e(linkedQueueNode);
        linkedQueueNode.soNext(null);
    }

    @Override // java.util.Queue
    public boolean offer(E e10) {
        Objects.requireNonNull(e10, "null elements not allowed");
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e10);
        b().soNext(linkedQueueNode);
        f(linkedQueueNode);
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueNode<E> lvNext = a().lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> lvNext = a().lvNext();
        if (lvNext == null) {
            return null;
        }
        E andNullValue = lvNext.getAndNullValue();
        e(lvNext);
        return andNullValue;
    }
}
