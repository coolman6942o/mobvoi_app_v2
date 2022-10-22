package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jo.b;
import kotlin.jvm.internal.i;
import vo.c;
/* compiled from: Collections.kt */
/* loaded from: classes3.dex */
public class m extends l {
    public static <T> ArrayList<T> c(T... elements) {
        i.f(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(new d(elements, true));
    }

    public static final <T> Collection<T> d(T[] asCollection) {
        i.f(asCollection, "$this$asCollection");
        return new d(asCollection, false);
    }

    public static final <T extends Comparable<? super T>> int e(List<? extends T> binarySearch, T t10, int i10, int i11) {
        int a10;
        i.f(binarySearch, "$this$binarySearch");
        n(binarySearch.size(), i10, i11);
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) >>> 1;
            a10 = b.a(binarySearch.get(i13), t10);
            if (a10 < 0) {
                i10 = i13 + 1;
            } else if (a10 <= 0) {
                return i13;
            } else {
                i12 = i13 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static /* synthetic */ int f(List list, Comparable comparable, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = list.size();
        }
        return e(list, comparable, i10, i11);
    }

    public static <T> List<T> g() {
        return EmptyList.INSTANCE;
    }

    public static c h(Collection<?> indices) {
        i.f(indices, "$this$indices");
        return new c(0, indices.size() - 1);
    }

    public static <T> int i(List<? extends T> lastIndex) {
        i.f(lastIndex, "$this$lastIndex");
        return lastIndex.size() - 1;
    }

    public static <T> List<T> j(T... elements) {
        List<T> g10;
        List<T> b10;
        i.f(elements, "elements");
        if (elements.length > 0) {
            b10 = h.b(elements);
            return b10;
        }
        g10 = g();
        return g10;
    }

    public static <T> List<T> k(T... elements) {
        List<T> o10;
        i.f(elements, "elements");
        o10 = i.o(elements);
        return o10;
    }

    public static <T> List<T> l(T... elements) {
        i.f(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new d(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> m(List<? extends T> optimizeReadOnlyList) {
        List<T> g10;
        List<T> b10;
        i.f(optimizeReadOnlyList, "$this$optimizeReadOnlyList");
        int size = optimizeReadOnlyList.size();
        if (size == 0) {
            g10 = g();
            return g10;
        } else if (size != 1) {
            return optimizeReadOnlyList;
        } else {
            b10 = l.b(optimizeReadOnlyList.get(0));
            return b10;
        }
    }

    private static final void n(int i10, int i11, int i12) {
        if (i11 > i12) {
            throw new IllegalArgumentException("fromIndex (" + i11 + ") is greater than toIndex (" + i12 + ").");
        } else if (i11 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i11 + ") is less than zero.");
        } else if (i12 > i10) {
            throw new IndexOutOfBoundsException("toIndex (" + i12 + ") is greater than size (" + i10 + ").");
        }
    }

    public static void o() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
