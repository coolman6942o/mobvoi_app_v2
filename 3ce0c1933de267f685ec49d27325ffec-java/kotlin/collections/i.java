package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import vo.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Arrays.kt */
/* loaded from: classes3.dex */
public class i extends h {
    public static final <T> T[] A(T[] sortedArrayWith, Comparator<? super T> comparator) {
        kotlin.jvm.internal.i.f(sortedArrayWith, "$this$sortedArrayWith");
        kotlin.jvm.internal.i.f(comparator, "comparator");
        if (sortedArrayWith.length == 0) {
            return sortedArrayWith;
        }
        T[] tArr = (T[]) Arrays.copyOf(sortedArrayWith, sortedArrayWith.length);
        kotlin.jvm.internal.i.e(tArr, "java.util.Arrays.copyOf(this, size)");
        h.m(tArr, comparator);
        return tArr;
    }

    public static <T> List<T> B(T[] sortedWith, Comparator<? super T> comparator) {
        List<T> b10;
        kotlin.jvm.internal.i.f(sortedWith, "$this$sortedWith");
        kotlin.jvm.internal.i.f(comparator, "comparator");
        b10 = h.b(A(sortedWith, comparator));
        return b10;
    }

    public static <T> List<T> C(T[] take, int i10) {
        List<T> b10;
        List<T> D;
        List<T> g10;
        kotlin.jvm.internal.i.f(take, "$this$take");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        } else if (i10 == 0) {
            g10 = m.g();
            return g10;
        } else if (i10 >= take.length) {
            D = D(take);
            return D;
        } else if (i10 == 1) {
            b10 = l.b(take[0]);
            return b10;
        } else {
            ArrayList arrayList = new ArrayList(i10);
            int i11 = 0;
            for (T t10 : take) {
                arrayList.add(t10);
                i11++;
                if (i11 == i10) {
                    break;
                }
            }
            return arrayList;
        }
    }

    public static <T> List<T> D(T[] toList) {
        List<T> g10;
        List<T> b10;
        List<T> E;
        kotlin.jvm.internal.i.f(toList, "$this$toList");
        int length = toList.length;
        if (length == 0) {
            g10 = m.g();
            return g10;
        } else if (length != 1) {
            E = E(toList);
            return E;
        } else {
            b10 = l.b(toList[0]);
            return b10;
        }
    }

    public static <T> List<T> E(T[] toMutableList) {
        kotlin.jvm.internal.i.f(toMutableList, "$this$toMutableList");
        return new ArrayList(m.d(toMutableList));
    }

    public static final <T> boolean n(T[] contains, T t10) {
        kotlin.jvm.internal.i.f(contains, "$this$contains");
        return v(contains, t10) >= 0;
    }

    public static <T> List<T> o(T[] filterNotNull) {
        kotlin.jvm.internal.i.f(filterNotNull, "$this$filterNotNull");
        return (List) p(filterNotNull, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C p(T[] filterNotNullTo, C destination) {
        kotlin.jvm.internal.i.f(filterNotNullTo, "$this$filterNotNullTo");
        kotlin.jvm.internal.i.f(destination, "destination");
        for (T t10 : filterNotNullTo) {
            if (t10 != null) {
                destination.add(t10);
            }
        }
        return destination;
    }

    public static <T> T q(T[] first) {
        kotlin.jvm.internal.i.f(first, "$this$first");
        if (!(first.length == 0)) {
            return first[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> c r(T[] indices) {
        int u10;
        kotlin.jvm.internal.i.f(indices, "$this$indices");
        u10 = u(indices);
        return new c(0, u10);
    }

    public static final int s(byte[] lastIndex) {
        kotlin.jvm.internal.i.f(lastIndex, "$this$lastIndex");
        return lastIndex.length - 1;
    }

    public static final int t(int[] lastIndex) {
        kotlin.jvm.internal.i.f(lastIndex, "$this$lastIndex");
        return lastIndex.length - 1;
    }

    public static <T> int u(T[] lastIndex) {
        kotlin.jvm.internal.i.f(lastIndex, "$this$lastIndex");
        return lastIndex.length - 1;
    }

    public static final <T> int v(T[] indexOf, T t10) {
        kotlin.jvm.internal.i.f(indexOf, "$this$indexOf");
        int i10 = 0;
        if (t10 == null) {
            int length = indexOf.length;
            while (i10 < length) {
                if (indexOf[i10] == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        int length2 = indexOf.length;
        while (i10 < length2) {
            if (kotlin.jvm.internal.i.b(t10, indexOf[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static void w(byte[] reverse) {
        kotlin.jvm.internal.i.f(reverse, "$this$reverse");
        int length = (reverse.length / 2) - 1;
        if (length >= 0) {
            int s10 = s(reverse);
            int i10 = 0;
            if (length >= 0) {
                while (true) {
                    byte b10 = reverse[i10];
                    reverse[i10] = reverse[s10];
                    reverse[s10] = b10;
                    s10--;
                    if (i10 != length) {
                        i10++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public static int[] x(int[] reversedArray) {
        kotlin.jvm.internal.i.f(reversedArray, "$this$reversedArray");
        int i10 = 0;
        if (reversedArray.length == 0) {
            return reversedArray;
        }
        int[] iArr = new int[reversedArray.length];
        int t10 = t(reversedArray);
        if (t10 >= 0) {
            while (true) {
                iArr[t10 - i10] = reversedArray[i10];
                if (i10 == t10) {
                    break;
                }
                i10++;
            }
        }
        return iArr;
    }

    public static char y(char[] single) {
        kotlin.jvm.internal.i.f(single, "$this$single");
        int length = single.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return single[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static <T> T z(T[] singleOrNull) {
        kotlin.jvm.internal.i.f(singleOrNull, "$this$singleOrNull");
        if (singleOrNull.length == 1) {
            return singleOrNull[0];
        }
        return null;
    }
}
