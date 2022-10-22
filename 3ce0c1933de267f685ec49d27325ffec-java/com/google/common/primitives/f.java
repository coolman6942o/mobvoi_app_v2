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
/* compiled from: Longs.java */
/* loaded from: classes.dex */
public final class f {

    /* compiled from: Longs.java */
    /* loaded from: classes.dex */
    private static class a extends AbstractList<Long> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final long[] array;
        final int end;
        final int start;

        a(long[] jArr, int i10, int i11) {
            this.array = jArr;
            this.start = i10;
            this.end = i11;
        }

        /* renamed from: a */
        public Long get(int i10) {
            p.m(i10, size());
            return Long.valueOf(this.array[this.start + i10]);
        }

        /* renamed from: b */
        public Long set(int i10, Long l10) {
            p.m(i10, size());
            long[] jArr = this.array;
            int i11 = this.start;
            long j10 = jArr[i11 + i10];
            jArr[i11 + i10] = ((Long) p.o(l10)).longValue();
            return Long.valueOf(j10);
        }

        /* renamed from: c */
        public Spliterator.OfLong spliterator() {
            return Spliterators.spliterator(this.array, this.start, this.end, 0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Long) && f.f(this.array, ((Long) obj).longValue(), this.start, this.end) != -1;
        }

        long[] d() {
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
                i10 = (i10 * 31) + f.e(this.array[i11]);
            }
            return i10;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int f10;
            if (!(obj instanceof Long) || (f10 = f.f(this.array, ((Long) obj).longValue(), this.start, this.end)) < 0) {
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
            if (!(obj instanceof Long) || (g10 = f.g(this.array, ((Long) obj).longValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return g10 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i10, int i11) {
            p.t(i10, i11, size());
            if (i10 == i11) {
                return Collections.emptyList();
            }
            long[] jArr = this.array;
            int i12 = this.start;
            return new a(jArr, i10 + i12, i12 + i11);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 10);
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

    public static int c(long j10, long j11) {
        int i10 = (j10 > j11 ? 1 : (j10 == j11 ? 0 : -1));
        if (i10 < 0) {
            return -1;
        }
        return i10 > 0 ? 1 : 0;
    }

    public static long d(byte b10, byte b11, byte b12, byte b13, byte b14, byte b15, byte b16, byte b17) {
        return ((b11 & 255) << 48) | ((b10 & 255) << 56) | ((b12 & 255) << 40) | ((b13 & 255) << 32) | ((b14 & 255) << 24) | ((b15 & 255) << 16) | ((b16 & 255) << 8) | (b17 & 255);
    }

    public static int e(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(long[] jArr, long j10, int i10, int i11) {
        while (i10 < i11) {
            if (jArr[i10] == j10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(long[] jArr, long j10, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            if (jArr[i12] == j10) {
                return i12;
            }
        }
        return -1;
    }

    public static long[] h(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        long[] jArr = new long[length];
        for (int i10 = 0; i10 < length; i10++) {
            jArr[i10] = ((Number) p.o(array[i10])).longValue();
        }
        return jArr;
    }
}
