package xo;

import java.util.Iterator;
import kotlin.jvm.internal.i;
import qo.l;
/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class n<T, R> implements e<R> {

    /* renamed from: a  reason: collision with root package name */
    private final e<T> f36639a;

    /* renamed from: b  reason: collision with root package name */
    private final l<T, R> f36640b;

    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<R>, ro.a {

        /* renamed from: a  reason: collision with root package name */
        private final Iterator<T> f36641a;

        a() {
            this.f36641a = n.this.f36639a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f36641a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) n.this.f36640b.invoke(this.f36641a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(e<? extends T> sequence, l<? super T, ? extends R> transformer) {
        i.f(sequence, "sequence");
        i.f(transformer, "transformer");
        this.f36639a = sequence;
        this.f36640b = transformer;
    }

    @Override // xo.e
    public Iterator<R> iterator() {
        return new a();
    }
}
