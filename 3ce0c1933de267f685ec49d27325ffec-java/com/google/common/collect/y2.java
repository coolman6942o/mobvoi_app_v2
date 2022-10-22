package com.google.common.collect;

import com.google.common.base.p;
import com.mobvoi.wear.providers.OtaColumn;
import java.util.Collection;
import java.util.Iterator;
/* compiled from: Collections2.java */
/* loaded from: classes.dex */
public final class y2 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Collection<?> collection, Collection<?> collection2) {
        Iterator<?> it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder b(int i10) {
        p2.b(i10, OtaColumn.COLUMN_SIZE);
        return new StringBuilder((int) Math.min(i10 * 8, 1073741824L));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Collection<?> collection, Object obj) {
        p.o(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(Collection<?> collection, Object obj) {
        p.o(collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(Collection<?> collection) {
        StringBuilder b10 = b(collection.size());
        b10.append('[');
        boolean z10 = true;
        for (Object obj : collection) {
            if (!z10) {
                b10.append(", ");
            }
            z10 = false;
            if (obj == collection) {
                b10.append("(this Collection)");
            } else {
                b10.append(obj);
            }
        }
        b10.append(']');
        return b10.toString();
    }
}
