package rx.internal.util;

import yp.g;
/* compiled from: UtilityFunctions.java */
/* loaded from: classes3.dex */
public final class j {

    /* compiled from: UtilityFunctions.java */
    /* loaded from: classes3.dex */
    enum a implements g<Object, Boolean> {
        INSTANCE;

        /* renamed from: a */
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }

    /* compiled from: UtilityFunctions.java */
    /* loaded from: classes3.dex */
    enum b implements g<Object, Object> {
        INSTANCE;

        @Override // yp.g
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> g<? super T, Boolean> a() {
        return a.INSTANCE;
    }

    public static <T> g<T, T> b() {
        return b.INSTANCE;
    }
}
