package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.j6;
import com.google.common.collect.m6;
import com.google.common.primitives.d;
import com.mobvoi.wear.contacts.ContactConstant;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;
/* loaded from: classes.dex */
public final class EnumMultiset<E extends Enum<E>> extends p<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private transient int[] counts;
    private transient int distinctElements;
    private transient E[] enumConstants;
    private transient long size;
    private transient Class<E> type;

    /* loaded from: classes.dex */
    class a extends EnumMultiset<E>.c<E> {
        a() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public E a(int i10) {
            return (E) EnumMultiset.this.enumConstants[i10];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends EnumMultiset<E>.c<j6.a<E>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends m6.b<E> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f11742a;

            a(int i10) {
                this.f11742a = i10;
            }

            /* renamed from: b */
            public E a() {
                return (E) EnumMultiset.this.enumConstants[this.f11742a];
            }

            @Override // com.google.common.collect.j6.a
            public int getCount() {
                return EnumMultiset.this.counts[this.f11742a];
            }
        }

        b() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public j6.a<E> a(int i10) {
            return new a(i10);
        }
    }

    /* loaded from: classes.dex */
    abstract class c<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        int f11744a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f11745b = -1;

        c() {
        }

        abstract T a(int i10);

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (this.f11744a < EnumMultiset.this.enumConstants.length) {
                int[] iArr = EnumMultiset.this.counts;
                int i10 = this.f11744a;
                if (iArr[i10] > 0) {
                    return true;
                }
                this.f11744a = i10 + 1;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T a10 = a(this.f11744a);
                int i10 = this.f11744a;
                this.f11745b = i10;
                this.f11744a = i10 + 1;
                return a10;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            p2.e(this.f11745b >= 0);
            if (EnumMultiset.this.counts[this.f11745b] > 0) {
                EnumMultiset.i(EnumMultiset.this);
                EnumMultiset enumMultiset = EnumMultiset.this;
                EnumMultiset.j(enumMultiset, enumMultiset.counts[this.f11745b]);
                EnumMultiset.this.counts[this.f11745b] = 0;
            }
            this.f11745b = -1;
        }
    }

    private EnumMultiset(Class<E> cls) {
        this.type = cls;
        p.d(cls.isEnum());
        E[] enumConstants = cls.getEnumConstants();
        this.enumConstants = enumConstants;
        this.counts = new int[enumConstants.length];
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> cls) {
        return new EnumMultiset<>(cls);
    }

    static /* synthetic */ int i(EnumMultiset enumMultiset) {
        int i10 = enumMultiset.distinctElements;
        enumMultiset.distinctElements = i10 - 1;
        return i10;
    }

    static /* synthetic */ long j(EnumMultiset enumMultiset, long j10) {
        long j11 = enumMultiset.size - j10;
        enumMultiset.size = j11;
        return j11;
    }

    private boolean l(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r52 = (Enum) obj;
        int ordinal = r52.ordinal();
        E[] eArr = this.enumConstants;
        return ordinal < eArr.length && eArr[ordinal] == r52;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ int add(Object obj, int i10) {
        return add((EnumMultiset<E>) ((Enum) obj), i10);
    }

    @Override // com.google.common.collect.p
    int b() {
        return this.distinctElements;
    }

    @Override // com.google.common.collect.p
    Iterator<E> c() {
        return new a();
    }

    @Override // com.google.common.collect.p, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Arrays.fill(this.counts, 0);
        this.size = 0L;
        this.distinctElements = 0;
    }

    @Override // com.google.common.collect.p, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.j6
    public int count(Object obj) {
        if (!l(obj)) {
            return 0;
        }
        return this.counts[((Enum) obj).ordinal()];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.p
    public Iterator<j6.a<E>> d() {
        return new b();
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.p, java.lang.Iterable
    public /* bridge */ /* synthetic */ void forEach(Consumer<? super E> consumer) {
        i6.a(this, consumer);
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public void forEachEntry(ObjIntConsumer<? super E> objIntConsumer) {
        p.o(objIntConsumer);
        int i10 = 0;
        while (true) {
            E[] eArr = this.enumConstants;
            if (i10 < eArr.length) {
                int[] iArr = this.counts;
                if (iArr[i10] > 0) {
                    objIntConsumer.accept(eArr[i10], iArr[i10]);
                }
                i10++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.common.collect.p, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return m6.i(this);
    }

    void k(Object obj) {
        p.o(obj);
        if (!l(obj)) {
            String valueOf = String.valueOf(this.type);
            String valueOf2 = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 21 + valueOf2.length());
            sb2.append("Expected an ");
            sb2.append(valueOf);
            sb2.append(" but got ");
            sb2.append(valueOf2);
            throw new ClassCastException(sb2.toString());
        }
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public int remove(Object obj, int i10) {
        if (!l(obj)) {
            return 0;
        }
        Enum r02 = (Enum) obj;
        p2.b(i10, "occurrences");
        if (i10 == 0) {
            return count(obj);
        }
        int ordinal = r02.ordinal();
        int[] iArr = this.counts;
        int i11 = iArr[ordinal];
        if (i11 == 0) {
            return 0;
        }
        if (i11 <= i10) {
            iArr[ordinal] = 0;
            this.distinctElements--;
            this.size -= i11;
        } else {
            iArr[ordinal] = i11 - i10;
            this.size -= i10;
        }
        return i11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ int setCount(Object obj, int i10) {
        return setCount((EnumMultiset<E>) ((Enum) obj), i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j6
    public int size() {
        return d.h(this.size);
    }

    @Override // com.google.common.collect.p, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator<E> spliterator() {
        return i6.c(this);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable) {
        Iterator<E> it = iterable.iterator();
        p.e(it.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> enumMultiset = new EnumMultiset<>(it.next().getDeclaringClass());
        h5.a(enumMultiset, iterable);
        return enumMultiset;
    }

    public int add(E e10, int i10) {
        k(e10);
        p2.b(i10, "occurrences");
        if (i10 == 0) {
            return count(e10);
        }
        int ordinal = e10.ordinal();
        int i11 = this.counts[ordinal];
        long j10 = i10;
        long j11 = i11 + j10;
        p.h(j11 <= 2147483647L, "too many occurrences: %s", j11);
        this.counts[ordinal] = (int) j11;
        if (i11 == 0) {
            this.distinctElements++;
        }
        this.size += j10;
        return i11;
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ boolean setCount(Object obj, int i10, int i11) {
        return super.setCount(obj, i10, i11);
    }

    public int setCount(E e10, int i10) {
        k(e10);
        p2.b(i10, ContactConstant.CallsRecordKeys.COUNT);
        int ordinal = e10.ordinal();
        int[] iArr = this.counts;
        int i11 = iArr[ordinal];
        iArr[ordinal] = i10;
        this.size += i10 - i11;
        if (i11 == 0 && i10 > 0) {
            this.distinctElements++;
        } else if (i11 > 0 && i10 == 0) {
            this.distinctElements--;
        }
        return i11;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable, Class<E> cls) {
        EnumMultiset<E> create = create(cls);
        h5.a(create, iterable);
        return create;
    }
}
