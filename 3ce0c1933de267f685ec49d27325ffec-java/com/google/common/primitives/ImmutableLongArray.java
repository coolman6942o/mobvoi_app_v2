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
import java.util.function.LongConsumer;
import java.util.stream.LongStream;
/* loaded from: classes.dex */
public final class ImmutableLongArray implements Serializable {
    private static final ImmutableLongArray EMPTY = new ImmutableLongArray(new long[0]);
    private final long[] array;
    private final int end;
    private final transient int start;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends AbstractList<Long> implements RandomAccess, Serializable {
        private final ImmutableLongArray parent;

        /* renamed from: a */
        public Long get(int i10) {
            return Long.valueOf(this.parent.get(i10));
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
                if (obj2 instanceof Long) {
                    i10++;
                    if (this.parent.array[i10] != ((Long) obj2).longValue()) {
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
            if (obj instanceof Long) {
                return this.parent.indexOf(((Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Long) {
                return this.parent.lastIndexOf(((Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        public Spliterator<Long> spliterator() {
            return this.parent.h();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i10, int i11) {
            return this.parent.subArray(i10, i11).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        private b(ImmutableLongArray immutableLongArray) {
            this.parent = immutableLongArray;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private long[] f12351a;

        /* renamed from: b  reason: collision with root package name */
        private int f12352b = 0;

        c(int i10) {
            this.f12351a = new long[i10];
        }

        private void e(int i10) {
            int i11 = this.f12352b + i10;
            long[] jArr = this.f12351a;
            if (i11 > jArr.length) {
                this.f12351a = Arrays.copyOf(jArr, f(jArr.length, i11));
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

        public c a(long j10) {
            e(1);
            long[] jArr = this.f12351a;
            int i10 = this.f12352b;
            jArr[i10] = j10;
            this.f12352b = i10 + 1;
            return this;
        }

        public c b(Iterable<Long> iterable) {
            if (iterable instanceof Collection) {
                return c((Collection) iterable);
            }
            for (Long l10 : iterable) {
                a(l10.longValue());
            }
            return this;
        }

        public c c(Collection<Long> collection) {
            e(collection.size());
            for (Long l10 : collection) {
                long[] jArr = this.f12351a;
                int i10 = this.f12352b;
                this.f12352b = i10 + 1;
                jArr[i10] = l10.longValue();
            }
            return this;
        }

        public ImmutableLongArray d() {
            return this.f12352b == 0 ? ImmutableLongArray.EMPTY : new ImmutableLongArray(this.f12351a, 0, this.f12352b);
        }
    }

    public static c builder(int i10) {
        p.f(i10 >= 0, "Invalid initialCapacity: %s", i10);
        return new c(i10);
    }

    public static ImmutableLongArray copyOf(long[] jArr) {
        if (jArr.length == 0) {
            return EMPTY;
        }
        return new ImmutableLongArray(Arrays.copyOf(jArr, jArr.length));
    }

    private boolean g() {
        return this.start > 0 || this.end < this.array.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Spliterator.OfLong h() {
        return Spliterators.spliterator(this.array, this.start, this.end, 1040);
    }

    public static ImmutableLongArray of() {
        return EMPTY;
    }

    public List<Long> asList() {
        return new b();
    }

    public boolean contains(long j10) {
        return indexOf(j10) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableLongArray)) {
            return false;
        }
        ImmutableLongArray immutableLongArray = (ImmutableLongArray) obj;
        if (length() != immutableLongArray.length()) {
            return false;
        }
        for (int i10 = 0; i10 < length(); i10++) {
            if (get(i10) != immutableLongArray.get(i10)) {
                return false;
            }
        }
        return true;
    }

    public void forEach(LongConsumer longConsumer) {
        p.o(longConsumer);
        for (int i10 = this.start; i10 < this.end; i10++) {
            longConsumer.accept(this.array[i10]);
        }
    }

    public long get(int i10) {
        p.m(i10, length());
        return this.array[this.start + i10];
    }

    public int hashCode() {
        int i10 = 1;
        for (int i11 = this.start; i11 < this.end; i11++) {
            i10 = (i10 * 31) + f.e(this.array[i11]);
        }
        return i10;
    }

    public int indexOf(long j10) {
        for (int i10 = this.start; i10 < this.end; i10++) {
            if (this.array[i10] == j10) {
                return i10 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(long j10) {
        int i10 = this.end;
        while (true) {
            i10--;
            int i11 = this.start;
            if (i10 < i11) {
                return -1;
            }
            if (this.array[i10] == j10) {
                return i10 - i11;
            }
        }
    }

    public int length() {
        return this.end - this.start;
    }

    public LongStream stream() {
        return Arrays.stream(this.array, this.start, this.end);
    }

    public ImmutableLongArray subArray(int i10, int i11) {
        p.t(i10, i11, length());
        if (i10 == i11) {
            return EMPTY;
        }
        long[] jArr = this.array;
        int i12 = this.start;
        return new ImmutableLongArray(jArr, i10 + i12, i12 + i11);
    }

    public long[] toArray() {
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

    public ImmutableLongArray trimmed() {
        return g() ? new ImmutableLongArray(toArray()) : this;
    }

    private ImmutableLongArray(long[] jArr) {
        this(jArr, 0, jArr.length);
    }

    public static ImmutableLongArray of(long j10) {
        return new ImmutableLongArray(new long[]{j10});
    }

    private ImmutableLongArray(long[] jArr, int i10, int i11) {
        this.array = jArr;
        this.start = i10;
        this.end = i11;
    }

    public static c builder() {
        return new c(10);
    }

    public static ImmutableLongArray of(long j10, long j11) {
        return new ImmutableLongArray(new long[]{j10, j11});
    }

    public static ImmutableLongArray copyOf(Collection<Long> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableLongArray(f.h(collection));
    }

    public static ImmutableLongArray of(long j10, long j11, long j12) {
        return new ImmutableLongArray(new long[]{j10, j11, j12});
    }

    public static ImmutableLongArray copyOf(Iterable<Long> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Long>) iterable);
        }
        return builder().b(iterable).d();
    }

    public static ImmutableLongArray of(long j10, long j11, long j12, long j13) {
        return new ImmutableLongArray(new long[]{j10, j11, j12, j13});
    }

    public static ImmutableLongArray of(long j10, long j11, long j12, long j13, long j14) {
        return new ImmutableLongArray(new long[]{j10, j11, j12, j13, j14});
    }

    public static ImmutableLongArray of(long j10, long j11, long j12, long j13, long j14, long j15) {
        return new ImmutableLongArray(new long[]{j10, j11, j12, j13, j14, j15});
    }

    public static ImmutableLongArray copyOf(LongStream longStream) {
        long[] array = longStream.toArray();
        return array.length == 0 ? EMPTY : new ImmutableLongArray(array);
    }

    public static ImmutableLongArray of(long j10, long... jArr) {
        p.e(jArr.length <= 2147483646, "the total number of elements must fit in an int");
        long[] jArr2 = new long[jArr.length + 1];
        jArr2[0] = j10;
        System.arraycopy(jArr, 0, jArr2, 1, jArr.length);
        return new ImmutableLongArray(jArr2);
    }
}
