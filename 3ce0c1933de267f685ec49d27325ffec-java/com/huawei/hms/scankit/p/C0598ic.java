package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;
/* compiled from: BarcodeMatrix.java */
/* renamed from: com.huawei.hms.scankit.p.ic  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0598ic {

    /* renamed from: a  reason: collision with root package name */
    private final jc[] f14820a;

    /* renamed from: b  reason: collision with root package name */
    private int f14821b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14822c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14823d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0598ic(int i10, int i11) {
        jc[] jcVarArr = new jc[i10];
        this.f14820a = jcVarArr;
        int length = jcVarArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            this.f14820a[i12] = new jc(((i11 + 4) * 17) + 1);
        }
        this.f14823d = i11 * 17;
        this.f14822c = i10;
        this.f14821b = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public jc a() {
        try {
            int i10 = this.f14821b;
            if (i10 >= 0) {
                jc[] jcVarArr = this.f14820a;
                if (i10 < jcVarArr.length) {
                    return jcVarArr[i10];
                }
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw e10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f14821b++;
    }

    public byte[][] a(int i10, int i11) {
        int i12 = this.f14822c * i11;
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, i12, this.f14823d * i10);
        for (int i13 = 0; i13 < i12; i13++) {
            bArr[(i12 - i13) - 1] = this.f14820a[i13 / i11].a(i10);
        }
        return bArr;
    }
}
