package com.google.common.primitives;

import com.google.common.base.p;
/* compiled from: SignedBytes.java */
/* loaded from: classes.dex */
public final class h {
    public static byte a(long j10) {
        byte b10 = (byte) j10;
        p.h(((long) b10) == j10, "Out of range: %s", j10);
        return b10;
    }
}
