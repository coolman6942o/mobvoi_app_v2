package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
/* compiled from: ObjectArrays.java */
/* loaded from: classes.dex */
public final class p6 {
    static Object a(Object obj, int i10) {
        if (obj != null) {
            return obj;
        }
        StringBuilder sb2 = new StringBuilder(20);
        sb2.append("at index ");
        sb2.append(i10);
        throw new NullPointerException(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] b(Object... objArr) {
        return c(objArr, objArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] c(Object[] objArr, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            a(objArr[i11], i11);
        }
        return objArr;
    }

    private static Object[] d(Iterable<?> iterable, Object[] objArr) {
        Iterator<?> it = iterable.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10++;
            objArr[i10] = it.next();
        }
        return objArr;
    }

    public static <T> T[] e(T[] tArr, int i10) {
        return (T[]) s6.b(tArr, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] f(Collection<?> collection, T[] tArr) {
        int size = collection.size();
        if (tArr.length < size) {
            tArr = (T[]) e(tArr, size);
        }
        d(collection, tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }
}
