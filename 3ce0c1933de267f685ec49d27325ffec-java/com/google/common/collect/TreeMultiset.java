package com.google.common.collect;

import com.google.common.base.l;
import com.google.common.base.p;
import com.google.common.collect.j6;
import com.google.common.collect.m6;
import com.mobvoi.wear.contacts.ContactConstant;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;
/* loaded from: classes.dex */
public final class TreeMultiset<E> extends v<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient f<E> header;
    private final transient v3<E> range;
    private final transient g<f<E>> rootReference;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends m6.b<E> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f11871a;

        a(f fVar) {
            this.f11871a = fVar;
        }

        @Override // com.google.common.collect.j6.a
        public E a() {
            return (E) this.f11871a.y();
        }

        @Override // com.google.common.collect.j6.a
        public int getCount() {
            int x10 = this.f11871a.x();
            return x10 == 0 ? TreeMultiset.this.count(a()) : x10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Iterator<j6.a<E>> {

        /* renamed from: a  reason: collision with root package name */
        f<E> f11873a;

        /* renamed from: b  reason: collision with root package name */
        j6.a<E> f11874b;

        b() {
            this.f11873a = TreeMultiset.this.u();
        }

        /* renamed from: a */
        public j6.a<E> next() {
            if (hasNext()) {
                j6.a<E> A = TreeMultiset.this.A(this.f11873a);
                this.f11874b = A;
                if (((f) this.f11873a).f11888i == TreeMultiset.this.header) {
                    this.f11873a = null;
                } else {
                    this.f11873a = ((f) this.f11873a).f11888i;
                }
                return A;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f11873a == null) {
                return false;
            }
            if (!TreeMultiset.this.range.n(this.f11873a.y())) {
                return true;
            }
            this.f11873a = null;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            p2.e(this.f11874b != null);
            TreeMultiset.this.setCount(this.f11874b.a(), 0);
            this.f11874b = null;
        }
    }

    /* loaded from: classes.dex */
    class c implements Iterator<j6.a<E>> {

        /* renamed from: a  reason: collision with root package name */
        f<E> f11876a;

        /* renamed from: b  reason: collision with root package name */
        j6.a<E> f11877b = null;

        c() {
            this.f11876a = TreeMultiset.this.w();
        }

        /* renamed from: a */
        public j6.a<E> next() {
            if (hasNext()) {
                j6.a<E> A = TreeMultiset.this.A(this.f11876a);
                this.f11877b = A;
                if (((f) this.f11876a).f11887h == TreeMultiset.this.header) {
                    this.f11876a = null;
                } else {
                    this.f11876a = ((f) this.f11876a).f11887h;
                }
                return A;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f11876a == null) {
                return false;
            }
            if (!TreeMultiset.this.range.o(this.f11876a.y())) {
                return true;
            }
            this.f11876a = null;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            p2.e(this.f11877b != null);
            TreeMultiset.this.setCount(this.f11877b.a(), 0);
            this.f11877b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11879a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f11879a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11879a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: classes.dex */
    public static abstract class e extends Enum<e> {
        public static final e SIZE = new a("SIZE", 0);
        public static final e DISTINCT = new b("DISTINCT", 1);
        private static final /* synthetic */ e[] $VALUES = a();

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes.dex */
        final class a extends e {
            a(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.collect.TreeMultiset.e
            int b(f<?> fVar) {
                return ((f) fVar).f11881b;
            }

            @Override // com.google.common.collect.TreeMultiset.e
            long c(f<?> fVar) {
                if (fVar == null) {
                    return 0L;
                }
                return ((f) fVar).f11883d;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes.dex */
        final class b extends e {
            b(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.collect.TreeMultiset.e
            int b(f<?> fVar) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.e
            long c(f<?> fVar) {
                if (fVar == null) {
                    return 0L;
                }
                return ((f) fVar).f11882c;
            }
        }

        private e(String str, int i10) {
        }

        private static /* synthetic */ e[] a() {
            return new e[]{SIZE, DISTINCT};
        }

        public static e valueOf(String str) {
            return (e) Enum.valueOf(e.class, str);
        }

        public static e[] values() {
            return (e[]) $VALUES.clone();
        }

        abstract int b(f<?> fVar);

        abstract long c(f<?> fVar);

        /* synthetic */ e(String str, int i10, a aVar) {
            this(str, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class f<E> {

        /* renamed from: a  reason: collision with root package name */
        private final E f11880a;

        /* renamed from: b  reason: collision with root package name */
        private int f11881b;

        /* renamed from: c  reason: collision with root package name */
        private int f11882c;

        /* renamed from: d  reason: collision with root package name */
        private long f11883d;

        /* renamed from: e  reason: collision with root package name */
        private int f11884e;

        /* renamed from: f  reason: collision with root package name */
        private f<E> f11885f;

        /* renamed from: g  reason: collision with root package name */
        private f<E> f11886g;

        /* renamed from: h  reason: collision with root package name */
        private f<E> f11887h;

        /* renamed from: i  reason: collision with root package name */
        private f<E> f11888i;

        f(E e10, int i10) {
            p.d(i10 > 0);
            this.f11880a = e10;
            this.f11881b = i10;
            this.f11883d = i10;
            this.f11882c = 1;
            this.f11884e = 1;
            this.f11885f = null;
            this.f11886g = null;
        }

        private f<E> A() {
            int s10 = s();
            if (s10 == -2) {
                if (this.f11886g.s() > 0) {
                    this.f11886g = this.f11886g.I();
                }
                return H();
            } else if (s10 != 2) {
                C();
                return this;
            } else {
                if (this.f11885f.s() < 0) {
                    this.f11885f = this.f11885f.H();
                }
                return I();
            }
        }

        private void B() {
            D();
            C();
        }

        private void C() {
            this.f11884e = Math.max(z(this.f11885f), z(this.f11886g)) + 1;
        }

        private void D() {
            this.f11882c = TreeMultiset.t(this.f11885f) + 1 + TreeMultiset.t(this.f11886g);
            this.f11883d = this.f11881b + L(this.f11885f) + L(this.f11886g);
        }

        private f<E> F(f<E> fVar) {
            f<E> fVar2 = this.f11886g;
            if (fVar2 == null) {
                return this.f11885f;
            }
            this.f11886g = fVar2.F(fVar);
            this.f11882c--;
            this.f11883d -= fVar.f11881b;
            return A();
        }

        private f<E> G(f<E> fVar) {
            f<E> fVar2 = this.f11885f;
            if (fVar2 == null) {
                return this.f11886g;
            }
            this.f11885f = fVar2.G(fVar);
            this.f11882c--;
            this.f11883d -= fVar.f11881b;
            return A();
        }

        private f<E> H() {
            p.u(this.f11886g != null);
            f<E> fVar = this.f11886g;
            this.f11886g = fVar.f11885f;
            fVar.f11885f = this;
            fVar.f11883d = this.f11883d;
            fVar.f11882c = this.f11882c;
            B();
            fVar.C();
            return fVar;
        }

        private f<E> I() {
            p.u(this.f11885f != null);
            f<E> fVar = this.f11885f;
            this.f11885f = fVar.f11886g;
            fVar.f11886g = this;
            fVar.f11883d = this.f11883d;
            fVar.f11882c = this.f11882c;
            B();
            fVar.C();
            return fVar;
        }

        private static long L(f<?> fVar) {
            if (fVar == null) {
                return 0L;
            }
            return ((f) fVar).f11883d;
        }

        private f<E> q(E e10, int i10) {
            f<E> fVar = new f<>(e10, i10);
            this.f11885f = fVar;
            TreeMultiset.z(this.f11887h, fVar, this);
            this.f11884e = Math.max(2, this.f11884e);
            this.f11882c++;
            this.f11883d += i10;
            return this;
        }

        private f<E> r(E e10, int i10) {
            f<E> fVar = new f<>(e10, i10);
            this.f11886g = fVar;
            TreeMultiset.z(this, fVar, this.f11888i);
            this.f11884e = Math.max(2, this.f11884e);
            this.f11882c++;
            this.f11883d += i10;
            return this;
        }

        private int s() {
            return z(this.f11885f) - z(this.f11886g);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public f<E> t(Comparator<? super E> comparator, E e10) {
            int compare = comparator.compare(e10, (E) this.f11880a);
            if (compare < 0) {
                f<E> fVar = this.f11885f;
                return fVar == null ? this : (f) l.a(fVar.t(comparator, e10), this);
            } else if (compare == 0) {
                return this;
            } else {
                f<E> fVar2 = this.f11886g;
                if (fVar2 == null) {
                    return null;
                }
                return fVar2.t(comparator, e10);
            }
        }

        private f<E> v() {
            int i10 = this.f11881b;
            this.f11881b = 0;
            TreeMultiset.y(this.f11887h, this.f11888i);
            f<E> fVar = this.f11885f;
            if (fVar == null) {
                return this.f11886g;
            }
            f<E> fVar2 = this.f11886g;
            if (fVar2 == null) {
                return fVar;
            }
            if (fVar.f11884e >= fVar2.f11884e) {
                f<E> fVar3 = this.f11887h;
                fVar3.f11885f = fVar.F(fVar3);
                fVar3.f11886g = this.f11886g;
                fVar3.f11882c = this.f11882c - 1;
                fVar3.f11883d = this.f11883d - i10;
                return fVar3.A();
            }
            f<E> fVar4 = this.f11888i;
            fVar4.f11886g = fVar2.G(fVar4);
            fVar4.f11885f = this.f11885f;
            fVar4.f11882c = this.f11882c - 1;
            fVar4.f11883d = this.f11883d - i10;
            return fVar4.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public f<E> w(Comparator<? super E> comparator, E e10) {
            int compare = comparator.compare(e10, (E) this.f11880a);
            if (compare > 0) {
                f<E> fVar = this.f11886g;
                return fVar == null ? this : (f) l.a(fVar.w(comparator, e10), this);
            } else if (compare == 0) {
                return this;
            } else {
                f<E> fVar2 = this.f11885f;
                if (fVar2 == null) {
                    return null;
                }
                return fVar2.w(comparator, e10);
            }
        }

        private static int z(f<?> fVar) {
            if (fVar == null) {
                return 0;
            }
            return ((f) fVar).f11884e;
        }

        /* JADX WARN: Multi-variable type inference failed */
        f<E> E(Comparator<? super E> comparator, E e10, int i10, int[] iArr) {
            int compare = comparator.compare(e10, (E) this.f11880a);
            if (compare < 0) {
                f<E> fVar = this.f11885f;
                if (fVar == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f11885f = fVar.E(comparator, e10, i10, iArr);
                if (iArr[0] > 0) {
                    if (i10 >= iArr[0]) {
                        this.f11882c--;
                        this.f11883d -= iArr[0];
                    } else {
                        this.f11883d -= i10;
                    }
                }
                return iArr[0] == 0 ? this : A();
            } else if (compare > 0) {
                f<E> fVar2 = this.f11886g;
                if (fVar2 == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f11886g = fVar2.E(comparator, e10, i10, iArr);
                if (iArr[0] > 0) {
                    if (i10 >= iArr[0]) {
                        this.f11882c--;
                        this.f11883d -= iArr[0];
                    } else {
                        this.f11883d -= i10;
                    }
                }
                return A();
            } else {
                int i11 = this.f11881b;
                iArr[0] = i11;
                if (i10 >= i11) {
                    return v();
                }
                this.f11881b = i11 - i10;
                this.f11883d -= i10;
                return this;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        f<E> J(Comparator<? super E> comparator, E e10, int i10, int i11, int[] iArr) {
            int compare = comparator.compare(e10, (E) this.f11880a);
            if (compare < 0) {
                f<E> fVar = this.f11885f;
                if (fVar == null) {
                    iArr[0] = 0;
                    return (i10 != 0 || i11 <= 0) ? this : q(e10, i11);
                }
                this.f11885f = fVar.J(comparator, e10, i10, i11, iArr);
                if (iArr[0] == i10) {
                    if (i11 == 0 && iArr[0] != 0) {
                        this.f11882c--;
                    } else if (i11 > 0 && iArr[0] == 0) {
                        this.f11882c++;
                    }
                    this.f11883d += i11 - iArr[0];
                }
                return A();
            } else if (compare > 0) {
                f<E> fVar2 = this.f11886g;
                if (fVar2 == null) {
                    iArr[0] = 0;
                    return (i10 != 0 || i11 <= 0) ? this : r(e10, i11);
                }
                this.f11886g = fVar2.J(comparator, e10, i10, i11, iArr);
                if (iArr[0] == i10) {
                    if (i11 == 0 && iArr[0] != 0) {
                        this.f11882c--;
                    } else if (i11 > 0 && iArr[0] == 0) {
                        this.f11882c++;
                    }
                    this.f11883d += i11 - iArr[0];
                }
                return A();
            } else {
                int i12 = this.f11881b;
                iArr[0] = i12;
                if (i10 == i12) {
                    if (i11 == 0) {
                        return v();
                    }
                    this.f11883d += i11 - i12;
                    this.f11881b = i11;
                }
                return this;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        f<E> K(Comparator<? super E> comparator, E e10, int i10, int[] iArr) {
            int i11;
            int compare = comparator.compare(e10, (E) this.f11880a);
            if (compare < 0) {
                f<E> fVar = this.f11885f;
                if (fVar == null) {
                    iArr[0] = 0;
                    return i10 > 0 ? q(e10, i10) : this;
                }
                this.f11885f = fVar.K(comparator, e10, i10, iArr);
                if (i10 == 0 && iArr[0] != 0) {
                    this.f11882c--;
                } else if (i10 > 0 && iArr[0] == 0) {
                    this.f11882c++;
                }
                this.f11883d += i10 - iArr[0];
                return A();
            } else if (compare > 0) {
                f<E> fVar2 = this.f11886g;
                if (fVar2 == null) {
                    iArr[0] = 0;
                    return i10 > 0 ? r(e10, i10) : this;
                }
                this.f11886g = fVar2.K(comparator, e10, i10, iArr);
                if (i10 == 0 && iArr[0] != 0) {
                    this.f11882c--;
                } else if (i10 > 0 && iArr[0] == 0) {
                    this.f11882c++;
                }
                this.f11883d += i10 - iArr[0];
                return A();
            } else {
                iArr[0] = this.f11881b;
                if (i10 == 0) {
                    return v();
                }
                this.f11883d += i10 - i11;
                this.f11881b = i10;
                return this;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        f<E> p(Comparator<? super E> comparator, E e10, int i10, int[] iArr) {
            int compare = comparator.compare(e10, (E) this.f11880a);
            boolean z10 = true;
            if (compare < 0) {
                f<E> fVar = this.f11885f;
                if (fVar == null) {
                    iArr[0] = 0;
                    return q(e10, i10);
                }
                int i11 = fVar.f11884e;
                f<E> p10 = fVar.p(comparator, e10, i10, iArr);
                this.f11885f = p10;
                if (iArr[0] == 0) {
                    this.f11882c++;
                }
                this.f11883d += i10;
                return p10.f11884e == i11 ? this : A();
            } else if (compare > 0) {
                f<E> fVar2 = this.f11886g;
                if (fVar2 == null) {
                    iArr[0] = 0;
                    return r(e10, i10);
                }
                int i12 = fVar2.f11884e;
                f<E> p11 = fVar2.p(comparator, e10, i10, iArr);
                this.f11886g = p11;
                if (iArr[0] == 0) {
                    this.f11882c++;
                }
                this.f11883d += i10;
                return p11.f11884e == i12 ? this : A();
            } else {
                int i13 = this.f11881b;
                iArr[0] = i13;
                long j10 = i10;
                if (i13 + j10 > 2147483647L) {
                    z10 = false;
                }
                p.d(z10);
                this.f11881b += i10;
                this.f11883d += j10;
                return this;
            }
        }

        public String toString() {
            return m6.g(y(), x()).toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int u(Comparator<? super E> comparator, E e10) {
            int compare = comparator.compare(e10, (E) this.f11880a);
            if (compare < 0) {
                f<E> fVar = this.f11885f;
                if (fVar == null) {
                    return 0;
                }
                return fVar.u(comparator, e10);
            } else if (compare <= 0) {
                return this.f11881b;
            } else {
                f<E> fVar2 = this.f11886g;
                if (fVar2 == null) {
                    return 0;
                }
                return fVar2.u(comparator, e10);
            }
        }

        int x() {
            return this.f11881b;
        }

        E y() {
            return this.f11880a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class g<T> {

        /* renamed from: a  reason: collision with root package name */
        private T f11889a;

        private g() {
        }

        public void a(T t10, T t11) {
            if (this.f11889a == t10) {
                this.f11889a = t11;
                return;
            }
            throw new ConcurrentModificationException();
        }

        void b() {
            this.f11889a = null;
        }

        public T c() {
            return this.f11889a;
        }

        /* synthetic */ g(a aVar) {
            this();
        }
    }

    TreeMultiset(g<f<E>> gVar, v3<E> v3Var, f<E> fVar) {
        super(v3Var.b());
        this.rootReference = gVar;
        this.range = v3Var;
        this.header = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public j6.a<E> A(f<E> fVar) {
        return new a(fVar);
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(q6.g());
    }

    private long q(e eVar, f<E> fVar) {
        long c10;
        long q5;
        if (fVar == null) {
            return 0L;
        }
        int compare = comparator().compare(this.range.j(), ((f) fVar).f11880a);
        if (compare > 0) {
            return q(eVar, ((f) fVar).f11886g);
        }
        if (compare == 0) {
            int i10 = d.f11879a[this.range.i().ordinal()];
            if (i10 == 1) {
                c10 = eVar.b(fVar);
                q5 = eVar.c(((f) fVar).f11886g);
            } else if (i10 == 2) {
                return eVar.c(((f) fVar).f11886g);
            } else {
                throw new AssertionError();
            }
        } else {
            c10 = eVar.c(((f) fVar).f11886g) + eVar.b(fVar);
            q5 = q(eVar, ((f) fVar).f11885f);
        }
        return c10 + q5;
    }

    private long r(e eVar, f<E> fVar) {
        long c10;
        long r10;
        if (fVar == null) {
            return 0L;
        }
        int compare = comparator().compare(this.range.h(), ((f) fVar).f11880a);
        if (compare < 0) {
            return r(eVar, ((f) fVar).f11885f);
        }
        if (compare == 0) {
            int i10 = d.f11879a[this.range.g().ordinal()];
            if (i10 == 1) {
                c10 = eVar.b(fVar);
                r10 = eVar.c(((f) fVar).f11885f);
            } else if (i10 == 2) {
                return eVar.c(((f) fVar).f11885f);
            } else {
                throw new AssertionError();
            }
        } else {
            c10 = eVar.c(((f) fVar).f11885f) + eVar.b(fVar);
            r10 = r(eVar, ((f) fVar).f11886g);
        }
        return c10 + r10;
    }

    private long s(e eVar) {
        f<E> c10 = this.rootReference.c();
        long c11 = eVar.c(c10);
        if (this.range.k()) {
            c11 -= r(eVar, c10);
        }
        return this.range.l() ? c11 - q(eVar, c10) : c11;
    }

    static int t(f<?> fVar) {
        if (fVar == null) {
            return 0;
        }
        return ((f) fVar).f11882c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f<E> u() {
        f<E> fVar;
        if (this.rootReference.c() == null) {
            return null;
        }
        if (this.range.k()) {
            E h10 = this.range.h();
            fVar = this.rootReference.c().t(comparator(), h10);
            if (fVar == null) {
                return null;
            }
            if (this.range.g() == BoundType.OPEN && comparator().compare(h10, fVar.y()) == 0) {
                fVar = ((f) fVar).f11888i;
            }
        } else {
            fVar = ((f) this.header).f11888i;
        }
        if (fVar == this.header || !this.range.c(fVar.y())) {
            return null;
        }
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f<E> w() {
        f<E> fVar;
        if (this.rootReference.c() == null) {
            return null;
        }
        if (this.range.l()) {
            E j10 = this.range.j();
            fVar = this.rootReference.c().w(comparator(), j10);
            if (fVar == null) {
                return null;
            }
            if (this.range.i() == BoundType.OPEN && comparator().compare(j10, fVar.y()) == 0) {
                fVar = ((f) fVar).f11887h;
            }
        } else {
            fVar = ((f) this.header).f11887h;
        }
        if (fVar == this.header || !this.range.c(fVar.y())) {
            return null;
        }
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void y(f<T> fVar, f<T> fVar2) {
        ((f) fVar).f11888i = fVar2;
        ((f) fVar2).f11887h = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void z(f<T> fVar, f<T> fVar2, f<T> fVar3) {
        y(fVar, fVar2);
        y(fVar2, fVar3);
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public int add(E e10, int i10) {
        p2.b(i10, "occurrences");
        if (i10 == 0) {
            return count(e10);
        }
        p.d(this.range.c(e10));
        f<E> c10 = this.rootReference.c();
        if (c10 == null) {
            comparator().compare(e10, e10);
            f<E> fVar = new f<>(e10, i10);
            f<E> fVar2 = this.header;
            z(fVar2, fVar, fVar2);
            this.rootReference.a(c10, fVar);
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.a(c10, c10.p(comparator(), e10, i10, iArr));
        return iArr[0];
    }

    @Override // com.google.common.collect.p
    int b() {
        return com.google.common.primitives.d.h(s(e.DISTINCT));
    }

    @Override // com.google.common.collect.p
    Iterator<E> c() {
        return m6.e(d());
    }

    @Override // com.google.common.collect.p, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (this.range.k() || this.range.l()) {
            j5.d(d());
            return;
        }
        f<E> fVar = ((f) this.header).f11888i;
        while (true) {
            f<E> fVar2 = this.header;
            if (fVar != fVar2) {
                f<E> fVar3 = ((f) fVar).f11888i;
                ((f) fVar).f11881b = 0;
                ((f) fVar).f11885f = null;
                ((f) fVar).f11886g = null;
                ((f) fVar).f11887h = null;
                ((f) fVar).f11888i = null;
                fVar = fVar3;
            } else {
                y(fVar2, fVar2);
                this.rootReference.b();
                return;
            }
        }
    }

    @Override // com.google.common.collect.v, com.google.common.collect.t7, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.p, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.j6
    public int count(Object obj) {
        try {
            f<E> c10 = this.rootReference.c();
            if (this.range.c(obj) && c10 != null) {
                return c10.u(comparator(), obj);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.p
    public Iterator<j6.a<E>> d() {
        return new b();
    }

    @Override // com.google.common.collect.v, com.google.common.collect.t7
    public /* bridge */ /* synthetic */ t7 descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.common.collect.v, com.google.common.collect.p, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.v, com.google.common.collect.t7
    public /* bridge */ /* synthetic */ j6.a firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.p, java.lang.Iterable
    public /* bridge */ /* synthetic */ void forEach(Consumer<? super E> consumer) {
        i6.a(this, consumer);
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public void forEachEntry(ObjIntConsumer<? super E> objIntConsumer) {
        p.o(objIntConsumer);
        for (f<E> u10 = u(); u10 != this.header && u10 != null && !this.range.n(u10.y()); u10 = ((f) u10).f11888i) {
            objIntConsumer.accept(u10.y(), u10.x());
        }
    }

    @Override // com.google.common.collect.t7
    public t7<E> headMultiset(E e10, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.m(v3.p(comparator(), e10, boundType)), this.header);
    }

    @Override // com.google.common.collect.v
    Iterator<j6.a<E>> i() {
        return new c();
    }

    @Override // com.google.common.collect.p, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return m6.i(this);
    }

    @Override // com.google.common.collect.v, com.google.common.collect.t7
    public /* bridge */ /* synthetic */ j6.a lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.v, com.google.common.collect.t7
    public /* bridge */ /* synthetic */ j6.a pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.v, com.google.common.collect.t7
    public /* bridge */ /* synthetic */ j6.a pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public int remove(Object obj, int i10) {
        p2.b(i10, "occurrences");
        if (i10 == 0) {
            return count(obj);
        }
        f<E> c10 = this.rootReference.c();
        int[] iArr = new int[1];
        try {
            if (this.range.c(obj) && c10 != null) {
                this.rootReference.a(c10, c10.E(comparator(), obj, i10, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public int setCount(E e10, int i10) {
        p2.b(i10, ContactConstant.CallsRecordKeys.COUNT);
        boolean z10 = true;
        if (!this.range.c(e10)) {
            if (i10 != 0) {
                z10 = false;
            }
            p.d(z10);
            return 0;
        }
        f<E> c10 = this.rootReference.c();
        if (c10 == null) {
            if (i10 > 0) {
                add(e10, i10);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.a(c10, c10.K(comparator(), e10, i10, iArr));
        return iArr[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j6
    public int size() {
        return com.google.common.primitives.d.h(s(e.SIZE));
    }

    @Override // com.google.common.collect.p, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator<E> spliterator() {
        return i6.c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.v, com.google.common.collect.t7
    public /* bridge */ /* synthetic */ t7 subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.t7
    public t7<E> tailMultiset(E e10, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.m(v3.d(comparator(), e10, boundType)), this.header);
    }

    public static <E> TreeMultiset<E> create(Comparator<? super E> comparator) {
        if (comparator == null) {
            return new TreeMultiset<>(q6.g());
        }
        return new TreeMultiset<>(comparator);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> create = create();
        h5.a(create, iterable);
        return create;
    }

    TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.range = v3.a(comparator);
        f<E> fVar = new f<>(null, 1);
        this.header = fVar;
        y(fVar, fVar);
        this.rootReference = new g<>(null);
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public boolean setCount(E e10, int i10, int i11) {
        p2.b(i11, "newCount");
        p2.b(i10, "oldCount");
        p.d(this.range.c(e10));
        f<E> c10 = this.rootReference.c();
        if (c10 != null) {
            int[] iArr = new int[1];
            this.rootReference.a(c10, c10.J(comparator(), e10, i10, i11, iArr));
            return iArr[0] == i10;
        } else if (i10 != 0) {
            return false;
        } else {
            if (i11 > 0) {
                add(e10, i11);
            }
            return true;
        }
    }
}
