package kotlin.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.i;
/* compiled from: _ArraysJvm.kt */
/* loaded from: classes3.dex */
public class h extends g {
    public static <T> List<T> b(T[] asList) {
        i.f(asList, "$this$asList");
        List<T> a10 = j.a(asList);
        i.e(a10, "ArraysUtilJVM.asList(this)");
        return a10;
    }

    public static byte[] c(byte[] copyInto, byte[] destination, int i10, int i11, int i12) {
        i.f(copyInto, "$this$copyInto");
        i.f(destination, "destination");
        System.arraycopy(copyInto, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static final <T> T[] d(T[] copyInto, T[] destination, int i10, int i11, int i12) {
        i.f(copyInto, "$this$copyInto");
        i.f(destination, "destination");
        System.arraycopy(copyInto, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static /* synthetic */ byte[] e(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, Object obj) {
        byte[] c10;
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = bArr.length;
        }
        c10 = c(bArr, bArr2, i10, i11, i12);
        return c10;
    }

    public static /* synthetic */ Object[] f(Object[] objArr, Object[] objArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = objArr.length;
        }
        return d(objArr, objArr2, i10, i11, i12);
    }

    public static byte[] g(byte[] copyOfRangeImpl, int i10, int i11) {
        i.f(copyOfRangeImpl, "$this$copyOfRangeImpl");
        f.a(i11, copyOfRangeImpl.length);
        byte[] copyOfRange = Arrays.copyOfRange(copyOfRangeImpl, i10, i11);
        i.e(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static <T> T[] h(T[] copyOfRangeImpl, int i10, int i11) {
        i.f(copyOfRangeImpl, "$this$copyOfRangeImpl");
        f.a(i11, copyOfRangeImpl.length);
        T[] tArr = (T[]) Arrays.copyOfRange(copyOfRangeImpl, i10, i11);
        i.e(tArr, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return tArr;
    }

    public static <T> void i(T[] fill, T t10, int i10, int i11) {
        i.f(fill, "$this$fill");
        Arrays.fill(fill, i10, i11, t10);
    }

    public static /* synthetic */ void j(Object[] objArr, Object obj, int i10, int i11, int i12, Object obj2) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = objArr.length;
        }
        i(objArr, obj, i10, i11);
    }

    public static byte[] k(byte[] plus, byte[] elements) {
        i.f(plus, "$this$plus");
        i.f(elements, "elements");
        int length = plus.length;
        int length2 = elements.length;
        byte[] result = Arrays.copyOf(plus, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        i.e(result, "result");
        return result;
    }

    public static final <T> void l(T[] sort) {
        i.f(sort, "$this$sort");
        if (sort.length > 1) {
            Arrays.sort(sort);
        }
    }

    public static final <T> void m(T[] sortWith, Comparator<? super T> comparator) {
        i.f(sortWith, "$this$sortWith");
        i.f(comparator, "comparator");
        if (sortWith.length > 1) {
            Arrays.sort(sortWith, comparator);
        }
    }
}
