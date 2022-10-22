package rx.internal.util.unsafe;

import rx.internal.util.atomic.LinkedQueueNode;
/* compiled from: BaseLinkedQueue.java */
/* loaded from: classes3.dex */
abstract class b<E> extends d<E> {

    /* renamed from: b  reason: collision with root package name */
    protected static final long f34158b = f0.a(b.class, "consumerNode");
    protected LinkedQueueNode<E> consumerNode;

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> c() {
        return (LinkedQueueNode) f0.f34169a.getObjectVolatile(this, f34158b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(LinkedQueueNode<E> linkedQueueNode) {
        this.consumerNode = linkedQueueNode;
    }
}
