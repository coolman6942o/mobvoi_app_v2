package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.i;
/* compiled from: AtomicReferenceArrayQueue.java */
/* loaded from: classes3.dex */
abstract class a<E> extends AbstractQueue<E> {

    /* renamed from: a  reason: collision with root package name */
    protected final AtomicReferenceArray<E> f34100a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f34101b;

    public a(int i10) {
        int b10 = i.b(i10);
        this.f34101b = b10 - 1;
        this.f34100a = new AtomicReferenceArray<>(b10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(long j10) {
        return ((int) j10) & this.f34101b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int b(long j10, int i10) {
        return ((int) j10) & i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E c(int i10) {
        return d(this.f34100a, i10);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E d(AtomicReferenceArray<E> atomicReferenceArray, int i10) {
        return atomicReferenceArray.get(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e(AtomicReferenceArray<E> atomicReferenceArray, int i10, E e10) {
        atomicReferenceArray.lazySet(i10, e10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
