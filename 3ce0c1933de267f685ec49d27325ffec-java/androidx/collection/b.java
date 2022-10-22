package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* compiled from: ArraySet.java */
/* loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f1441e = new int[0];

    /* renamed from: f  reason: collision with root package name */
    private static final Object[] f1442f = new Object[0];

    /* renamed from: g  reason: collision with root package name */
    private static Object[] f1443g;

    /* renamed from: h  reason: collision with root package name */
    private static int f1444h;

    /* renamed from: i  reason: collision with root package name */
    private static Object[] f1445i;

    /* renamed from: j  reason: collision with root package name */
    private static int f1446j;

    /* renamed from: a  reason: collision with root package name */
    private int[] f1447a;

    /* renamed from: b  reason: collision with root package name */
    Object[] f1448b;

    /* renamed from: c  reason: collision with root package name */
    int f1449c;

    /* renamed from: d  reason: collision with root package name */
    private e<E, E> f1450d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArraySet.java */
    /* loaded from: classes.dex */
    public class a extends e<E, E> {
        a() {
        }

        @Override // androidx.collection.e
        protected void a() {
            b.this.clear();
        }

        @Override // androidx.collection.e
        protected Object b(int i10, int i11) {
            return b.this.f1448b[i10];
        }

        @Override // androidx.collection.e
        protected Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // androidx.collection.e
        protected int d() {
            return b.this.f1449c;
        }

        @Override // androidx.collection.e
        protected int e(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // androidx.collection.e
        protected int f(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // androidx.collection.e
        protected void g(E e10, E e11) {
            b.this.add(e10);
        }

        @Override // androidx.collection.e
        protected void h(int i10) {
            b.this.g(i10);
        }

        @Override // androidx.collection.e
        protected E i(int i10, E e10) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    private void a(int i10) {
        if (i10 == 8) {
            synchronized (b.class) {
                Object[] objArr = f1445i;
                if (objArr != null) {
                    this.f1448b = objArr;
                    f1445i = (Object[]) objArr[0];
                    this.f1447a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1446j--;
                    return;
                }
            }
        } else if (i10 == 4) {
            synchronized (b.class) {
                Object[] objArr2 = f1443g;
                if (objArr2 != null) {
                    this.f1448b = objArr2;
                    f1443g = (Object[]) objArr2[0];
                    this.f1447a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1444h--;
                    return;
                }
            }
        }
        this.f1447a = new int[i10];
        this.f1448b = new Object[i10];
    }

    private static void c(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (f1446j < 10) {
                    objArr[0] = f1445i;
                    objArr[1] = iArr;
                    for (int i11 = i10 - 1; i11 >= 2; i11--) {
                        objArr[i11] = null;
                    }
                    f1445i = objArr;
                    f1446j++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (f1444h < 10) {
                    objArr[0] = f1443g;
                    objArr[1] = iArr;
                    for (int i12 = i10 - 1; i12 >= 2; i12--) {
                        objArr[i12] = null;
                    }
                    f1443g = objArr;
                    f1444h++;
                }
            }
        }
    }

    private e<E, E> d() {
        if (this.f1450d == null) {
            this.f1450d = new a();
        }
        return this.f1450d;
    }

    private int e(Object obj, int i10) {
        int i11 = this.f1449c;
        if (i11 == 0) {
            return -1;
        }
        int a10 = c.a(this.f1447a, i11, i10);
        if (a10 < 0 || obj.equals(this.f1448b[a10])) {
            return a10;
        }
        int i12 = a10 + 1;
        while (i12 < i11 && this.f1447a[i12] == i10) {
            if (obj.equals(this.f1448b[i12])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = a10 - 1; i13 >= 0 && this.f1447a[i13] == i10; i13--) {
            if (obj.equals(this.f1448b[i13])) {
                return i13;
            }
        }
        return ~i12;
    }

    private int f() {
        int i10 = this.f1449c;
        if (i10 == 0) {
            return -1;
        }
        int a10 = c.a(this.f1447a, i10, 0);
        if (a10 < 0 || this.f1448b[a10] == null) {
            return a10;
        }
        int i11 = a10 + 1;
        while (i11 < i10 && this.f1447a[i11] == 0) {
            if (this.f1448b[i11] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = a10 - 1; i12 >= 0 && this.f1447a[i12] == 0; i12--) {
            if (this.f1448b[i12] == null) {
                return i12;
            }
        }
        return ~i11;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e10) {
        int i10;
        int i11;
        if (e10 == null) {
            i11 = f();
            i10 = 0;
        } else {
            int hashCode = e10.hashCode();
            i10 = hashCode;
            i11 = e(e10, hashCode);
        }
        if (i11 >= 0) {
            return false;
        }
        int i12 = ~i11;
        int i13 = this.f1449c;
        int[] iArr = this.f1447a;
        if (i13 >= iArr.length) {
            int i14 = 4;
            if (i13 >= 8) {
                i14 = (i13 >> 1) + i13;
            } else if (i13 >= 4) {
                i14 = 8;
            }
            Object[] objArr = this.f1448b;
            a(i14);
            int[] iArr2 = this.f1447a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f1448b, 0, objArr.length);
            }
            c(iArr, objArr, this.f1449c);
        }
        int i15 = this.f1449c;
        if (i12 < i15) {
            int[] iArr3 = this.f1447a;
            int i16 = i12 + 1;
            System.arraycopy(iArr3, i12, iArr3, i16, i15 - i12);
            Object[] objArr2 = this.f1448b;
            System.arraycopy(objArr2, i12, objArr2, i16, this.f1449c - i12);
        }
        this.f1447a[i12] = i10;
        this.f1448b[i12] = e10;
        this.f1449c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        b(this.f1449c + collection.size());
        boolean z10 = false;
        for (E e10 : collection) {
            z10 |= add(e10);
        }
        return z10;
    }

    public void b(int i10) {
        int[] iArr = this.f1447a;
        if (iArr.length < i10) {
            Object[] objArr = this.f1448b;
            a(i10);
            int i11 = this.f1449c;
            if (i11 > 0) {
                System.arraycopy(iArr, 0, this.f1447a, 0, i11);
                System.arraycopy(objArr, 0, this.f1448b, 0, this.f1449c);
            }
            c(iArr, objArr, this.f1449c);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i10 = this.f1449c;
        if (i10 != 0) {
            c(this.f1447a, this.f1448b, i10);
            this.f1447a = f1441e;
            this.f1448b = f1442f;
            this.f1449c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i10 = 0; i10 < this.f1449c; i10++) {
                try {
                    if (!set.contains(h(i10))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public E g(int i10) {
        Object[] objArr = this.f1448b;
        E e10 = (E) objArr[i10];
        int i11 = this.f1449c;
        if (i11 <= 1) {
            c(this.f1447a, objArr, i11);
            this.f1447a = f1441e;
            this.f1448b = f1442f;
            this.f1449c = 0;
        } else {
            int[] iArr = this.f1447a;
            int i12 = 8;
            if (iArr.length <= 8 || i11 >= iArr.length / 3) {
                int i13 = i11 - 1;
                this.f1449c = i13;
                if (i10 < i13) {
                    int i14 = i10 + 1;
                    System.arraycopy(iArr, i14, iArr, i10, i13 - i10);
                    Object[] objArr2 = this.f1448b;
                    System.arraycopy(objArr2, i14, objArr2, i10, this.f1449c - i10);
                }
                this.f1448b[this.f1449c] = null;
            } else {
                if (i11 > 8) {
                    i12 = i11 + (i11 >> 1);
                }
                a(i12);
                this.f1449c--;
                if (i10 > 0) {
                    System.arraycopy(iArr, 0, this.f1447a, 0, i10);
                    System.arraycopy(objArr, 0, this.f1448b, 0, i10);
                }
                int i15 = this.f1449c;
                if (i10 < i15) {
                    int i16 = i10 + 1;
                    System.arraycopy(iArr, i16, this.f1447a, i10, i15 - i10);
                    System.arraycopy(objArr, i16, this.f1448b, i10, this.f1449c - i10);
                }
            }
        }
        return e10;
    }

    public E h(int i10) {
        return (E) this.f1448b[i10];
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f1447a;
        int i10 = this.f1449c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += iArr[i12];
        }
        return i11;
    }

    public int indexOf(Object obj) {
        return obj == null ? f() : e(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f1449c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return d().m().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        g(indexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= remove(it.next());
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z10 = false;
        for (int i10 = this.f1449c - 1; i10 >= 0; i10--) {
            if (!collection.contains(this.f1448b[i10])) {
                g(i10);
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f1449c;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i10 = this.f1449c;
        Object[] objArr = new Object[i10];
        System.arraycopy(this.f1448b, 0, objArr, 0, i10);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f1449c * 14);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f1449c; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            E h10 = h(i10);
            if (h10 != this) {
                sb2.append(h10);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public b(int i10) {
        if (i10 == 0) {
            this.f1447a = f1441e;
            this.f1448b = f1442f;
        } else {
            a(i10);
        }
        this.f1449c = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f1449c) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f1449c));
        }
        System.arraycopy(this.f1448b, 0, tArr, 0, this.f1449c);
        int length = tArr.length;
        int i10 = this.f1449c;
        if (length > i10) {
            tArr[i10] = null;
        }
        return tArr;
    }
}
