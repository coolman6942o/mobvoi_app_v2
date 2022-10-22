package com.google.common.primitives;

import com.google.common.base.p;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.regex.Pattern;
/* compiled from: Doubles.java */
/* loaded from: classes.dex */
public final class b extends c {

    /* compiled from: Doubles.java */
    /* loaded from: classes.dex */
    private static class a extends AbstractList<Double> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final double[] array;
        final int end;
        final int start;

        a(double[] dArr, int i10, int i11) {
            this.array = dArr;
            this.start = i10;
            this.end = i11;
        }

        /* renamed from: a */
        public Double get(int i10) {
            p.m(i10, size());
            return Double.valueOf(this.array[this.start + i10]);
        }

        /* renamed from: b */
        public Double set(int i10, Double d10) {
            p.m(i10, size());
            double[] dArr = this.array;
            int i11 = this.start;
            double d11 = dArr[i11 + i10];
            dArr[i11 + i10] = ((Double) p.o(d10)).doubleValue();
            return Double.valueOf(d11);
        }

        /* renamed from: c */
        public Spliterator.OfDouble spliterator() {
            return Spliterators.spliterator(this.array, this.start, this.end, 0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Double) && b.e(this.array, ((Double) obj).doubleValue(), this.start, this.end) != -1;
        }

        double[] d() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            int size = size();
            if (aVar.size() != size) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (this.array[this.start + i10] != aVar.array[aVar.start + i10]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i10 = 1;
            for (int i11 = this.start; i11 < this.end; i11++) {
                i10 = (i10 * 31) + b.d(this.array[i11]);
            }
            return i10;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int e10;
            if (!(obj instanceof Double) || (e10 = b.e(this.array, ((Double) obj).doubleValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return e10 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int g10;
            if (!(obj instanceof Double) || (g10 = b.g(this.array, ((Double) obj).doubleValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return g10 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i10, int i11) {
            p.t(i10, i11, size());
            if (i10 == i11) {
                return Collections.emptyList();
            }
            double[] dArr = this.array;
            int i12 = this.start;
            return new a(dArr, i10 + i12, i12 + i11);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 12);
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
    }

    static {
        c();
    }

    private static Pattern c() {
        String concat = "(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)".concat("(?:[eE][+-]?\\d+#)?[fFdD]?");
        StringBuilder sb2 = new StringBuilder("(?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)".length() + 25);
        sb2.append("0[xX]");
        sb2.append("(?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)");
        sb2.append("[pP][+-]?\\d+#[fFdD]?");
        String sb3 = sb2.toString();
        StringBuilder sb4 = new StringBuilder(String.valueOf(concat).length() + 23 + String.valueOf(sb3).length());
        sb4.append("[+-]?(?:NaN|Infinity|");
        sb4.append(concat);
        sb4.append("|");
        sb4.append(sb3);
        sb4.append(")");
        return Pattern.compile(sb4.toString().replace("#", "+"));
    }

    public static int d(double d10) {
        return Double.valueOf(d10).hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(double[] dArr, double d10, int i10, int i11) {
        while (i10 < i11) {
            if (dArr[i10] == d10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static boolean f(double d10) {
        return Double.NEGATIVE_INFINITY < d10 && d10 < Double.POSITIVE_INFINITY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(double[] dArr, double d10, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            if (dArr[i12] == d10) {
                return i12;
            }
        }
        return -1;
    }

    public static double[] h(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        double[] dArr = new double[length];
        for (int i10 = 0; i10 < length; i10++) {
            dArr[i10] = ((Number) p.o(array[i10])).doubleValue();
        }
        return dArr;
    }
}
