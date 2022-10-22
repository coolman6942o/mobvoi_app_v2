package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public final class d8 {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f9238a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f9239b;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f9239b = bArr;
        ByteBuffer.wrap(bArr);
        a8.a(bArr, 0, bArr.length, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + bArr[i13];
        }
        return i10;
    }
}
