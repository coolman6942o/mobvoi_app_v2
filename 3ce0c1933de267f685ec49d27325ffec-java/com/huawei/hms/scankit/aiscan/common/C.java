package com.huawei.hms.scankit.aiscan.common;

import java.util.HashMap;
/* compiled from: ToneMapping.java */
/* loaded from: classes2.dex */
public class C {

    /* renamed from: a  reason: collision with root package name */
    private static float f14153a = 2.51f;

    /* renamed from: b  reason: collision with root package name */
    private static float f14154b = 0.03f;

    /* renamed from: c  reason: collision with root package name */
    private static float f14155c = 2.43f;

    /* renamed from: d  reason: collision with root package name */
    private static float f14156d = 0.59f;

    /* renamed from: e  reason: collision with root package name */
    private static float f14157e = 0.14f;

    /* renamed from: f  reason: collision with root package name */
    private static HashMap<Integer, Integer> f14158f = new HashMap<>(255);

    private static int a(int i10, float f10) {
        if (f14158f.containsKey(Integer.valueOf(i10))) {
            return f14158f.get(Integer.valueOf(i10)).intValue();
        }
        float f11 = i10 / f10;
        int i11 = (int) ((f10 * (((f14153a * f11) + f14154b) * f11)) / ((f11 * ((f14155c * f11) + f14156d)) + f14157e));
        f14158f.put(Integer.valueOf(i10), Integer.valueOf(i11));
        return i11;
    }

    private static int b(m mVar) {
        byte[] b10 = mVar.b();
        if (b10 == null) {
            return 1;
        }
        long j10 = 0;
        int c10 = mVar.c();
        int a10 = mVar.a();
        for (int i10 = a10 / 4; i10 < (a10 * 3) / 4; i10++) {
            for (int i11 = c10 / 4; i11 < (c10 * 3) / 4; i11++) {
                j10 += b10[(i10 * c10) + i11] & 255;
            }
        }
        return (int) ((j10 / b10.length) * 4);
    }

    public static m a(m mVar) {
        int b10 = b(mVar);
        int c10 = mVar.c();
        int a10 = mVar.a();
        byte[] b11 = mVar.b();
        byte[] bArr = new byte[a10 * c10];
        for (int i10 = 0; i10 < a10; i10++) {
            for (int i11 = 0; i11 < c10; i11++) {
                int i12 = (i10 * c10) + i11;
                bArr[i12] = (byte) (a(b11[i12] & 255, b10) & 255);
            }
        }
        f14158f = new HashMap<>(255);
        return new r(bArr, c10, a10, 0, 0, c10, a10, false);
    }
}
