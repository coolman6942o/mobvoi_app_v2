package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.b;
/* compiled from: BarcodeRow.java */
/* loaded from: classes2.dex */
final class jc {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f14840a;

    /* renamed from: b  reason: collision with root package name */
    private int f14841b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jc(int i10) {
        this.f14840a = new byte[i10];
    }

    private void a(int i10, boolean z10) {
        try {
            if (b.a(this.f14840a, i10)) {
                this.f14840a[i10] = z10 ? (byte) 1 : (byte) 0;
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw e10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z10, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = this.f14841b;
            this.f14841b = i12 + 1;
            a(i12, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a(int i10) {
        int length = this.f14840a.length * i10;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr[i11] = this.f14840a[i11 / i10];
        }
        return bArr;
    }
}
