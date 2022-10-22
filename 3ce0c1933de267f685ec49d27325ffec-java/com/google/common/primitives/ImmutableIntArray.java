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
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
/* loaded from: classes.dex */
public final class ImmutableIntArray implements Serializable {
    private static final ImmutableIntArray EMPTY = new ImmutableIntArray(new int[0]);
    private final int[] array;
    private final int end;
    private final transient int start;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends AbstractList<Integer> implements RandomAccess, Serializable {
        private final ImmutableIntArray parent;

        /* renamed from: a */
        public Integer get(int i10) {
            return Integer.valueOf(this.parent.get(i10));
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
                if (obj2 instanceof Integer) {
                    i10++;
                    if (this.parent.array[i10] != ((Integer) obj2).intValue()) {
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
            if (obj instanceof Integer) {
                return this.parent.indexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.parent.lastIndexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        public Spliterator<Integer> spliterator() {
            return this.parent.h();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i10, int i11) {
            return this.parent.subArray(i10, i11).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        private b(ImmutableIntArray immutableIntArray) {
            this.parent = immutableIntArray;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private int[] f12349a;

        /* renamed from: b  reason: collision with root package name */
        private int f12350b = 0;

        c(int i10) {
            this.f12349a = new int[i10];
        }

        private void e(int i10) {
            int i11 = this.f12350b + i10;
            int[] iArr = this.f12349a;
            if (i11 > iArr.length) {
                this.f12349a = Arrays.copyOf(iArr, f(iArr.length, i11));
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

        public c a(int i10) {
            e(1);
            int[] iArr = this.f12349a;
            int i11 = this.f12350b;
            iArr[i11] = i10;
            this.f12350b = i11 + 1;
            return this;
        }

        public c b(Iterable<Integer> iterable) {
            if (iterable instanceof Collection) {
                return c((Collection) iterable);
            }
            for (Integer num : iterable) {
                a(num.intValue());
            }
            return this;
        }

        public c c(Collection<Integer> collection) {
            e(collection.size());
            for (Integer num : collection) {
                int[] iArr = this.f12349a;
                int i10 = this.f12350b;
                this.f12350b = i10 + 1;
                iArr[i10] = num.intValue();
            }
            return this;
        }

        public ImmutableIntArray d() {
            return this.f12350b == 0 ? ImmutableIntArray.EMPTY : new ImmutableIntArray(this.f12349a, 0, this.f12350b);
        }
    }

    public static c builder(int i10) {
        p.f(i10 >= 0, "Invalid initialCapacity: %s", i10);
        return new c(i10);
    }

    public static ImmutableIntArray copyOf(int[] iArr) {
        return iArr.length == 0 ? EMPTY : new ImmutableIntArray(Arrays.copyOf(iArr, iArr.length));
    }

    private boolean g() {
        return this.start > 0 || this.end < this.array.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Spliterator.OfInt h() {
        return Spliterators.spliterator(this.array, this.start, this.end, 1040);
    }

    public static ImmutableIntArray of() {
        return EMPTY;
    }

    public List<Integer> asList() {
        return new b();
    }

    public boolean contains(int i10) {
        return indexOf(i10) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableIntArray)) {
            return false;
        }
        ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
        if (length() != immutableIntArray.length()) {
            return false;
        }
        for (int i10 = 0; i10 < length(); i10++) {
            if (get(i10) != immutableIntArray.get(i10)) {
                return false;
            }
        }
        return true;
    }

    public void forEach(IntConsumer intConsumer) {
        p.o(intConsumer);
        for (int i10 = this.start; i10 < this.end; i10++) {
            intConsumer.accept(this.array[i10]);
        }
    }

    public int get(int i10) {
        p.m(i10, length());
        return this.array[this.start + i10];
    }

    public int hashCode() {
        int i10 = 1;
        for (int i11 = this.start; i11 < this.end; i11++) {
            i10 = (i10 * 31) + d.e(this.array[i11]);
        }
        return i10;
    }

    public int indexOf(int i10) {
        for (int i11 = this.start; i11 < this.end; i11++) {
            if (this.array[i11] == i10) {
                return i11 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(int i10) {
        int i11 = this.end;
        while (true) {
            i11--;
            int i12 = this.start;
            if (i11 < i12) {
                return -1;
            }
            if (this.array[i11] == i10) {
                return i11 - i12;
            }
        }
    }

    public int length() {
        return this.end - this.start;
    }

    public IntStream stream() {
        return Arrays.stream(this.array, this.start, this.end);
    }

    public ImmutableIntArray subArray(int i10, int i11) {
        p.t(i10, i11, length());
        if (i10 == i11) {
            return EMPTY;
        }
        int[] iArr = this.array;
        int i12 = this.start;
        return new ImmutableIntArray(iArr, i10 + i12, i12 + i11);
    }

    public int[] toArray() {
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

    public ImmutableIntArray trimmed() {
        return g() ? new ImmutableIntArray(toArray()) : this;
    }

    private ImmutableIntArray(int[] iArr) {
        this(iArr, 0, iArr.length);
    }

    public static ImmutableIntArray copyOf(Collection<Integer> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableIntArray(d.i(collection));
    }

    public static ImmutableIntArray of(int i10) {
        return new ImmutableIntArray(new int[]{i10});
    }

    private ImmutableIntArray(int[] iArr, int i10, int i11) {
        this.array = iArr;
        this.start = i10;
        this.end = i11;
    }

    public static c builder() {
        return new c(10);
    }

    public static ImmutableIntArray copyOf(Iterable<Integer> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Integer>) iterable);
        }
        return builder().b(iterable).d();
    }

    public static ImmutableIntArray of(int i10, int i11) {
        return new ImmutableIntArray(new int[]{i10, i11});
    }

    public static ImmutableIntArray of(int i10, int i11, int i12) {
        return new ImmutableIntArray(new int[]{i10, i11, i12});
    }

    public static ImmutableIntArray of(int i10, int i11, int i12, int i13) {
        return new ImmutableIntArray(new int[]{i10, i11, i12, i13});
    }

    public static ImmutableIntArray copyOf(IntStream intStream) {
        int[] array = intStream.toArray();
        return array.length == 0 ? EMPTY : new ImmutableIntArray(array);
    }

    public static ImmutableIntArray of(int i10, int i11, int i12, int i13, int i14) {
        return new ImmutableIntArray(new int[]{i10, i11, i12, i13, i14});
    }

    public static ImmutableIntArray of(int i10, int i11, int i12, int i13, int i14, int i15) {
        return new ImmutableIntArray(new int[]{i10, i11, i12, i13, i14, i15});
    }

    public static ImmutableIntArray of(int i10, int... iArr) {
        p.e(iArr.length <= 2147483646, "the total number of elements must fit in an int");
        int[] iArr2 = new int[iArr.length + 1];
        iArr2[0] = i10;
        System.arraycopy(iArr, 0, iArr2, 1, iArr.length);
        return new ImmutableIntArray(iArr2);
    }
}
