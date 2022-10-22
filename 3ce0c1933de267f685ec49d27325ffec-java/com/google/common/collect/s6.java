package com.google.common.collect;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
/* compiled from: Platform.java */
/* loaded from: classes.dex */
final class s6 {
    static {
        Logger.getLogger(s6.class.getName());
    }

    private s6() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] a(Object[] objArr, int i10, int i11, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i10, i11, tArr.getClass());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] b(T[] tArr, int i10) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Map<K, V> c(int i10) {
        return w5.l(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Set<E> d(int i10) {
        return l7.d(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Map<K, V> e(int i10) {
        return w5.n(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Set<E> f(int i10) {
        return l7.f(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Set<E> g() {
        return l7.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Map<K, V> h() {
        return w5.m();
    }
}
