package com.google.gson.internal;

import java.util.Objects;
/* compiled from: $Gson$Preconditions.java */
/* loaded from: classes.dex */
public final class a {
    public static void a(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T b(T t10) {
        Objects.requireNonNull(t10);
        return t10;
    }
}
