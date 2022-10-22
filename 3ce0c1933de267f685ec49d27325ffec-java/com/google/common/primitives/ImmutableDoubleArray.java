package com.google.common.primitives;

import com.google.common.base.p;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;
/* loaded from: classes.dex */
public final class ImmutableDoubleArray implements Serializable {
    private static final ImmutableDoubleArray EMPTY = new ImmutableDoubleArray(new double[0]);
    private final double[] array;
    private final int end;
    private final transient int start;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends AbstractList<Double> implements RandomAccess, Serializable {
        private final ImmutableDoubleArray parent;

        /* renamed from: a */
        public Double get(int i10) {
            return Double.valueOf(this.parent.get(i10));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.parent.equals(((b) obj).parent);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int i10 = this.parent.start;
            for (Object obj2 : list) {
                if (obj2 instanceof Double) {
                    i10++;
                    if (!ImmutableDoubleArray.h(this.parent.array[i10], ((Double) obj2).doubleValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Double) {
                return this.parent.indexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Double) {
                return this.parent.lastIndexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        public Spliterator<Double> spliterator() {
            return this.parent.j();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i10, int i11) {
            return this.parent.subArray(i10, i11).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        private b(ImmutableDoubleArray immutableDoubleArray) {
            this.parent = immutableDoubleArray;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private double[] f12347a;

        /* renamed from: b  reason: collision with root package name */
        private int f12348b = 0;

        c(int i10) {
            this.f12347a = new double[i10];
        }

        private void e(int i10) {
            int i11 = this.f12348b + i10;
            double[] dArr = this.f12347a;
            if (i11 > dArr.length) {
                this.f12347a = Arrays.copyOf(dArr, f(dArr.length, i11));
            }
        }

        private static int f(int i10, int i11) {
            if (i11 >= 0) {
                int i12 = i10 + (i10 >> 1) + 1;
                if (i12 < i11) {
                    i12 = Integer.highestOneBit(i11 - 1) << 1;
                }
                if (i12 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i12;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        public c a(double d10) {
            e(1);
            double[] dArr = this.f12347a;
            int i10 = this.f12348b;
            dArr[i10] = d10;
            this.f12348b = i10 + 1;
            return this;
        }

        public c b(Iterable<Double> iterable) {
            if (iterable instanceof Collection) {
                return c((Collection) iterable);
            }
            for (Double d10 : iterable) {
                a(d10.doubleValue());
            }
            return this;
        }

        public c c(Collection<Double> collection) {
            e(collection.size());
            for (Double d10 : collection) {
                double[] dArr = this.f12347a;
                int i10 = this.f12348b;
                this.f12348b = i10 + 1;
                dArr[i10] = d10.doubleValue();
            }
            return this;
        }

        public ImmutableDoubleArray d() {
            return this.f12348b == 0 ? ImmutableDoubleArray.EMPTY : new ImmutableDoubleArray(this.f12347a, 0, this.f12348b);
        }
    }

    public static c builder(int i10) {
        p.f(i10 >= 0, "Invalid initialCapacity: %s", i10);
        return new c(i10);
    }

    public static ImmutableDoubleArray copyOf(double[] dArr) {
        if (dArr.length == 0) {
            return EMPTY;
        }
        return new ImmutableDoubleArray(Arrays.copyOf(dArr, dArr.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean h(double d10, double d11) {
        return Double.doubleToLongBits(d10) == Double.doubleToLongBits(d11);
    }

    private boolean i() {
        return this.start > 0 || this.end < this.array.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Spliterator.OfDouble j() {
        return Spliterators.spliterator(this.array, this.start, this.end, 1040);
    }

    public static ImmutableDoubleArray of() {
        return EMPTY;
    }

    public List<Double> asList() {
        return new b();
    }

    public boolean contains(double d10) {
        return indexOf(d10) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableDoubleArray)) {
            return false;
        }
        ImmutableDoubleArray immutableDoubleArray = (ImmutableDoubleArray) obj;
        if (length() != immutableDoubleArray.length()) {
            return false;
        }
        for (int i10 = 0; i10 < length(); i10++) {
            if (!h(get(i10), immutableDoubleArray.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public void forEach(DoubleConsumer doubleConsumer) {
        p.o(doubleConsumer);
        for (int i10 = this.start; i10 < this.end; i10++) {
            doubleConsumer.accept(this.array[i10]);
        }
    }

    public double get(int i10) {
        p.m(i10, length());
        return this.array[this.start + i10];
    }

    public int hashCode() {
        int i10 = 1;
        for (int i11 = this.start; i11 < this.end; i11++) {
            i10 = (i10 * 31) + com.google.common.primitives.b.d(this.array[i11]);
        }
        return i10;
    }

    public int indexOf(double d10) {
        for (int i10 = this.start; i10 < this.end; i10++) {
            if (h(this.array[i10], d10)) {
                return i10 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(double d10) {
        int i10 = this.end;
        while (true) {
            i10--;
            if (i10 < this.start) {
                return -1;
            }
            if (h(this.array[i10], d10)) {
                return i10 - this.start;
            }
        }
    }

    public int length() {
        return this.end - this.start;
    }

    public DoubleStream stream() {
        return Arrays.stream(this.array, this.start, this.end);
    }

    public ImmutableDoubleArray subArray(int i10, int i11) {
        p.t(i10, i11, length());
        if (i10 == i11) {
            return EMPTY;
        }
        double[] dArr = this.array;
        int i12 = this.start;
        return new ImmutableDoubleArray(dArr, i10 + i12, i12 + i11);
    }

    public double[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder(length() * 5);
        sb2.append('[');
        sb2.append(this.array[this.start]);
        int i10 = this.start;
        while (true) {
            i10++;
            if (i10 < this.end) {
                sb2.append(", ");
                sb2.append(this.array[i10]);
            } else {
                sb2.append(']');
                return sb2.toString();
            }
        }
    }

    public ImmutableDoubleArray trimmed() {
        return i() ? new ImmutableDoubleArray(toArray()) : this;
    }

    private ImmutableDoubleArray(double[] dArr) {
        this(dArr, 0, dArr.length);
    }

    public static ImmutableDoubleArray of(double d10) {
        return new ImmutableDoubleArray(new double[]{d10});
    }

    private ImmutableDoubleArray(double[] dArr, int i10, int i11) {
        this.array = dArr;
        this.start = i10;
        this.end = i11;
    }

    public static c builder() {
        return new c(10);
    }

    public static ImmutableDoubleArray of(double d10, double d11) {
        return new ImmutableDoubleArray(new double[]{d10, d11});
    }

    public static ImmutableDoubleArray copyOf(Collection<Double> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableDoubleArray(com.google.common.primitives.b.h(collection));
    }

    public static ImmutableDoubleArray of(double d10, double d11, double d12) {
        return new ImmutableDoubleArray(new double[]{d10, d11, d12});
    }

    public static ImmutableDoubleArray copyOf(Iterable<Double> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Double>) iterable);
        }
        return builder().b(iterable).d();
    }

    public static ImmutableDoubleArray of(double d10, double d11, double d12, double d13) {
        return new ImmutableDoubleArray(new double[]{d10, d11, d12, d13});
    }

    public static ImmutableDoubleArray of(double d10, double d11, double d12, double d13, double d14) {
        return new ImmutableDoubleArray(new double[]{d10, d11, d12, d13, d14});
    }

    public static ImmutableDoubleArray of(double d10, double d11, double d12, double d13, double d14, double d15) {
        return new ImmutableDoubleArray(new double[]{d10, d11, d12, d13, d14, d15});
    }

    public static ImmutableDoubleArray copyOf(DoubleStream doubleStream) {
        double[] array = doubleStream.toArray();
        return array.length == 0 ? EMPTY : new ImmutableDoubleArray(array);
    }

    public static ImmutableDoubleArray of(double d10, double... dArr) {
        p.e(dArr.length <= 2147483646, "the total number of elements must fit in an int");
        double[] dArr2 = new double[dArr.length + 1];
        dArr2[0] = d10;
        System.arraycopy(dArr, 0, dArr2, 1, dArr.length);
        return new ImmutableDoubleArray(dArr2);
    }
}
