package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: AbstractList.kt */
/* loaded from: classes3.dex */
public abstract class b<E> extends kotlin.collections.a<E> implements List<E> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30048a = new a(null);

    /* compiled from: AbstractList.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final void a(int i10, int i11) {
            if (i10 < 0 || i10 >= i11) {
                throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
            }
        }

        public final void b(int i10, int i11) {
            if (i10 < 0 || i10 > i11) {
                throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
            }
        }

        public final void c(int i10, int i11, int i12) {
            if (i10 < 0 || i11 > i12) {
                throw new IndexOutOfBoundsException("fromIndex: " + i10 + ", toIndex: " + i11 + ", size: " + i12);
            } else if (i10 > i11) {
                throw new IllegalArgumentException("fromIndex: " + i10 + " > toIndex: " + i11);
            }
        }

        public final boolean d(Collection<?> c10, Collection<?> other) {
            i.f(c10, "c");
            i.f(other, "other");
            if (c10.size() != other.size()) {
                return false;
            }
            Iterator<?> it = other.iterator();
            Iterator<?> it2 = c10.iterator();
            while (it2.hasNext()) {
                if (!i.b(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int e(Collection<?> c10) {
            i.f(c10, "c");
            Iterator<?> it = c10.iterator();
            int i10 = 1;
            while (it.hasNext()) {
                Object next = it.next();
                i10 = (i10 * 31) + (next != null ? next.hashCode() : 0);
            }
            return i10;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractList.kt */
    /* renamed from: kotlin.collections.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0371b implements Iterator<E>, ro.a {

        /* renamed from: a  reason: collision with root package name */
        private int f30049a;

        public C0371b() {
        }

        protected final int a() {
            return this.f30049a;
        }

        protected final void b(int i10) {
            this.f30049a = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30049a < b.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                b bVar = b.this;
                int i10 = this.f30049a;
                this.f30049a = i10 + 1;
                return (E) bVar.get(i10);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    /* loaded from: classes3.dex */
    private class c extends b<E>.C0371b implements ListIterator<E> {
        public c(int i10) {
            super();
            b.f30048a.b(i10, b.this.size());
            b(i10);
        }

        @Override // java.util.ListIterator
        public void add(E e10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious()) {
                b bVar = b.this;
                b(a() - 1);
                return (E) bVar.get(a());
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    /* loaded from: classes3.dex */
    private static final class d<E> extends b<E> implements RandomAccess {

        /* renamed from: b  reason: collision with root package name */
        private int f30052b;

        /* renamed from: c  reason: collision with root package name */
        private final b<E> f30053c;

        /* renamed from: d  reason: collision with root package name */
        private final int f30054d;

        /* JADX WARN: Multi-variable type inference failed */
        public d(b<? extends E> list, int i10, int i11) {
            i.f(list, "list");
            this.f30053c = list;
            this.f30054d = i10;
            b.f30048a.c(i10, i11, list.size());
            this.f30052b = i11 - i10;
        }

        @Override // kotlin.collections.a
        public int a() {
            return this.f30052b;
        }

        @Override // kotlin.collections.b, java.util.List
        public E get(int i10) {
            b.f30048a.a(i10, this.f30052b);
            return this.f30053c.get(this.f30054d + i10);
        }
    }

    @Override // java.util.List
    public void add(int i10, E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        return f30048a.d(this, (Collection) obj);
    }

    @Override // java.util.List
    public abstract E get(int i10);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f30048a.e(this);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        int i10 = 0;
        for (E e10 : this) {
            if (i.b(e10, obj)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new C0371b();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (i.b(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public E remove(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i10, E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i10, int i11) {
        return new d(this, i10, i11);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i10) {
        return new c(i10);
    }
}
