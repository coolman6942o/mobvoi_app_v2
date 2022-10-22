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
/* compiled from: Ints.java */
/* loaded from: classes.dex */
public final class d extends e {

    /* compiled from: Ints.java */
    /* loaded from: classes.dex */
    private static class a extends AbstractList<Integer> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final int[] array;
        final int end;
        final int start;

        a(int[] iArr, int i10, int i11) {
            this.array = iArr;
            this.start = i10;
            this.end = i11;
        }

        /* renamed from: a */
        public Integer get(int i10) {
            p.m(i10, size());
            return Integer.valueOf(this.array[this.start + i10]);
        }

        /* renamed from: b */
        public Integer set(int i10, Integer num) {
            p.m(i10, size());
            int[] iArr = this.array;
            int i11 = this.start;
            int i12 = iArr[i11 + i10];
            iArr[i11 + i10] = ((Integer) p.o(num)).intValue();
            return Integer.valueOf(i12);
        }

        /* renamed from: c */
        public Spliterator.OfInt spliterator() {
            return Spliterators.spliterator(this.array, this.start, this.end, 0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Integer) && d.f(this.array, ((Integer) obj).intValue(), this.start, this.end) != -1;
        }

        int[] d() {
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
                i10 = (i10 * 31) + d.e(this.array[i11]);
            }
            return i10;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int f10;
            if (!(obj instanceof Integer) || (f10 = d.f(this.array, ((Integer) obj).intValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return f10 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int g10;
            if (!(obj instanceof Integer) || (g10 = d.g(this.array, ((Integer) obj).intValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return g10 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i10, int i11) {
            p.t(i10, i11, size());
            if (i10 == i11) {
                return Collections.emptyList();
            }
            int[] iArr = this.array;
            int i12 = this.start;
            return new a(iArr, i10 + i12, i12 + i11);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 5);
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

    public static int c(long j10) {
        int i10 = (int) j10;
        p.h(((long) i10) == j10, "Out of range: %s", j10);
        return i10;
    }

    public static int d(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 > i11 ? 1 : 0;
    }

    public static int e(int i10) {
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(int[] iArr, int i10, int i11, int i12) {
        while (i11 < i12) {
            if (iArr[i11] == i10) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(int[] iArr, int i10, int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            if (iArr[i13] == i10) {
                return i13;
            }
        }
        return -1;
    }

    public static int h(long j10) {
        if (j10 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j10 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j10;
    }

    public static int[] i(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = ((Number) p.o(array[i10])).intValue();
        }
        return iArr;
    }
}
