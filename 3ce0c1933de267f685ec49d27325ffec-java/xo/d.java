package xo;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.jvm.internal.i;
import qo.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class d<T> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    private final qo.a<T> f36627a;

    /* renamed from: b  reason: collision with root package name */
    private final l<T, T> f36628b;

    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<T>, ro.a {

        /* renamed from: a  reason: collision with root package name */
        private T f36629a;

        /* renamed from: b  reason: collision with root package name */
        private int f36630b = -2;

        a() {
        }

        private final void a() {
            T t10;
            if (this.f36630b == -2) {
                t10 = (T) d.this.f36627a.invoke();
            } else {
                l lVar = d.this.f36628b;
                T t11 = this.f36629a;
                i.d(t11);
                t10 = (T) lVar.invoke(t11);
            }
            this.f36629a = t10;
            this.f36630b = t10 == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f36630b < 0) {
                a();
            }
            return this.f36630b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f36630b < 0) {
                a();
            }
            if (this.f36630b != 0) {
                T t10 = this.f36629a;
                Objects.requireNonNull(t10, "null cannot be cast to non-null type T");
                this.f36630b = -1;
                return t10;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(qo.a<? extends T> getInitialValue, l<? super T, ? extends T> getNextValue) {
        i.f(getInitialValue, "getInitialValue");
        i.f(getNextValue, "getNextValue");
        this.f36627a = getInitialValue;
        this.f36628b = getNextValue;
    }

    @Override // xo.e
    public Iterator<T> iterator() {
        return new a();
    }
}
