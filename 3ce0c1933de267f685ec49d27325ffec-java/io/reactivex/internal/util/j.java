package io.reactivex.internal.util;
/* compiled from: Pow2.java */
/* loaded from: classes3.dex */
public final class j {
    public static int a(int i10) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i10 - 1));
    }
}
