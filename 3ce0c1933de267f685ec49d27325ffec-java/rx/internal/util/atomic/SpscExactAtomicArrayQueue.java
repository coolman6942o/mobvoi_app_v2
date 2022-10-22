package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.i;
/* loaded from: classes3.dex */
public final class SpscExactAtomicArrayQueue<T> extends AtomicReferenceArray<T> implements Queue<T> {
    private static final long serialVersionUID = 6210984603741293445L;
    final int capacitySkip;
    final int mask;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public SpscExactAtomicArrayQueue(int i10) {
        super(i.b(i10));
        int length = length();
        this.mask = length - 1;
        this.capacitySkip = length - i10;
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T element() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.producerIndex == this.consumerIndex;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public boolean offer(T t10) {
        Objects.requireNonNull(t10);
        long j10 = this.producerIndex.get();
        int i10 = this.mask;
        if (get(((int) (this.capacitySkip + j10)) & i10) != null) {
            return false;
        }
        this.producerIndex.lazySet(j10 + 1);
        lazySet(i10 & ((int) j10), t10);
        return true;
    }

    @Override // java.util.Queue
    public T peek() {
        return get(((int) this.consumerIndex.get()) & this.mask);
    }

    @Override // java.util.Queue
    public T poll() {
        long j10 = this.consumerIndex.get();
        int i10 = ((int) j10) & this.mask;
        T t10 = get(i10);
        if (t10 == null) {
            return null;
        }
        this.consumerIndex.lazySet(j10 + 1);
        lazySet(i10, null);
        return t10;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public int size() {
        long j10 = this.consumerIndex.get();
        while (true) {
            long j11 = this.producerIndex.get();
            long j12 = this.consumerIndex.get();
            if (j10 == j12) {
                return (int) (j11 - j12);
            }
            j10 = j12;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }
}
