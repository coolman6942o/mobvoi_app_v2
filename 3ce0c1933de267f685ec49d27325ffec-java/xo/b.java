package xo;

import java.util.Iterator;
import kotlin.jvm.internal.i;
/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class b<T> implements e<T>, c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final e<T> f36623a;

    /* renamed from: b  reason: collision with root package name */
    private final int f36624b;

    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<T>, ro.a {

        /* renamed from: a  reason: collision with root package name */
        private final Iterator<T> f36625a;

        /* renamed from: b  reason: collision with root package name */
        private int f36626b;

        a(b bVar) {
            this.f36625a = bVar.f36623a.iterator();
            this.f36626b = bVar.f36624b;
        }

        private final void a() {
            while (this.f36626b > 0 && this.f36625a.hasNext()) {
                this.f36625a.next();
                this.f36626b--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f36625a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            return this.f36625a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(e<? extends T> sequence, int i10) {
        i.f(sequence, "sequence");
        this.f36623a = sequence;
        this.f36624b = i10;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("count must be non-negative, but was " + i10 + '.').toString());
        }
    }

    @Override // xo.c
    public e<T> a(int i10) {
        int i11 = this.f36624b + i10;
        return i11 < 0 ? new b(this, i10) : new b(this.f36623a, i11);
    }

    @Override // xo.e
    public Iterator<T> iterator() {
        return new a(this);
    }
}
