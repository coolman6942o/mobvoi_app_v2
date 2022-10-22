package com.google.common.collect;

import java.util.Iterator;
/* compiled from: RangeSet.java */
/* loaded from: classes.dex */
public final /* synthetic */ class v6 {
    public static void a(w6 _this, Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            _this.add((Range) it.next());
        }
    }

    public static boolean b(w6 _this, Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (!_this.encloses((Range) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static void c(w6 _this, Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            _this.remove((Range) it.next());
        }
    }
}
