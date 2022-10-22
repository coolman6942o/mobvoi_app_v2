package rx.internal.util.unsafe;

import rx.internal.util.atomic.LinkedQueueNode;
/* compiled from: BaseLinkedQueue.java */
/* loaded from: classes3.dex */
abstract class e<E> extends c<E> {

    /* renamed from: a  reason: collision with root package name */
    protected static final long f34163a = f0.a(e.class, "producerNode");
    protected LinkedQueueNode<E> producerNode;

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> a() {
        return (LinkedQueueNode) f0.f34169a.getObjectVolatile(this, f34163a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.producerNode = linkedQueueNode;
    }
}
