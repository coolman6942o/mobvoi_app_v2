package com.huawei.hianalytics.mn.no.b;
/* loaded from: classes.dex */
public class mn {

    /* renamed from: mn  reason: collision with root package name */
    private byte[] f13530mn;

    /* renamed from: no  reason: collision with root package name */
    private int f13531no;

    /* renamed from: op  reason: collision with root package name */
    private int f13532op;

    public mn() {
        this.f13530mn = null;
        this.f13531no = 1024;
        this.f13532op = 0;
        this.f13530mn = new byte[1024];
    }

    public mn(int i10) {
        this.f13530mn = null;
        this.f13531no = 1024;
        this.f13532op = 0;
        this.f13531no = i10;
        this.f13530mn = new byte[i10];
    }

    public int mn() {
        return this.f13532op;
    }

    public void mn(byte[] bArr, int i10) {
        if (i10 > 0) {
            byte[] bArr2 = this.f13530mn;
            int length = bArr2.length;
            int i11 = this.f13532op;
            if (length - i11 >= i10) {
                System.arraycopy(bArr, 0, bArr2, i11, i10);
            } else {
                byte[] bArr3 = new byte[(bArr2.length + i10) << 1];
                System.arraycopy(bArr2, 0, bArr3, 0, i11);
                System.arraycopy(bArr, 0, bArr3, this.f13532op, i10);
                this.f13530mn = bArr3;
            }
            this.f13532op += i10;
        }
    }

    public byte[] no() {
        int i10 = this.f13532op;
        if (i10 <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i10];
        System.arraycopy(this.f13530mn, 0, bArr, 0, i10);
        return bArr;
    }
}
