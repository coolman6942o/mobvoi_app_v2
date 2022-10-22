package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static final long[] f9598a = new long[0];

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f9599b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f9600c = new byte[0];

    public static final int a(g gVar, int i10) throws IOException {
        int a10 = gVar.a();
        gVar.g(i10);
        int i11 = 1;
        while (gVar.n() == i10) {
            gVar.g(i10);
            i11++;
        }
        gVar.l(a10, i10);
        return i11;
    }
}
