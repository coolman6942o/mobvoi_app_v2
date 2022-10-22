package com.mobvoi.android.common.utils;

import android.os.Looper;
import java.util.Objects;
/* compiled from: Preconditions.java */
/* loaded from: classes2.dex */
public class o {
    public static void a(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void c() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new RuntimeException("MUST be invoked in UI thread");
        }
    }

    public static void d() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new RuntimeException("MUST be invoked in non-UI thread");
        }
    }

    public static <T> T e(T t10) {
        Objects.requireNonNull(t10);
        return t10;
    }

    public static void f(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
