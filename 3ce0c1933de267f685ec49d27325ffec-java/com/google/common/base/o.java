package com.google.common.base;

import java.lang.ref.WeakReference;
import java.util.logging.Logger;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Platform.java */
/* loaded from: classes.dex */
public final class o {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Platform.java */
    /* loaded from: classes.dex */
    public static final class b implements n {
        private b() {
        }
    }

    static {
        Logger.getLogger(o.class.getName());
        b();
    }

    private o() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends Enum<T>> Optional<T> a(Class<T> cls, String str) {
        WeakReference<? extends Enum<?>> weakReference = f.a(cls).get(str);
        return weakReference == null ? Optional.absent() : Optional.of(cls.cast(weakReference.get()));
    }

    private static n b() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(String str) {
        return str == null || str.isEmpty();
    }
}
