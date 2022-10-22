package com.google.protobuf.nano;

import java.io.IOException;
/* compiled from: WireFormatNano.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f13298a = new byte[0];

    public static final int a(a aVar, int i10) throws IOException {
        int c10 = aVar.c();
        aVar.A(i10);
        int i11 = 1;
        while (aVar.v() == i10) {
            aVar.A(i10);
            i11++;
        }
        aVar.z(c10);
        return i11;
    }

    public static int b(int i10) {
        return i10 >>> 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i10) {
        return i10 & 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i10, int i11) {
        return (i10 << 3) | i11;
    }

    public static boolean e(a aVar, int i10) throws IOException {
        return aVar.A(i10);
    }
}
