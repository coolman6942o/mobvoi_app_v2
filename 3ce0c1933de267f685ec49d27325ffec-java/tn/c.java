package tn;

import java.util.Objects;
/* compiled from: Preconditions.java */
/* loaded from: classes2.dex */
public final class c {
    public static <T> T a(T t10) {
        Objects.requireNonNull(t10);
        return t10;
    }

    public static <T> T b(T t10, String str) {
        Objects.requireNonNull(t10, str);
        return t10;
    }

    public static void c(boolean z10, String str, Object... objArr) {
        if (!z10) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }
}
