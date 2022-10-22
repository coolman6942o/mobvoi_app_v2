package com.paypal.android.sdk;
/* loaded from: classes2.dex */
public class l0 {

    /* renamed from: b  reason: collision with root package name */
    private static final String f21426b = "l0";

    /* renamed from: c  reason: collision with root package name */
    public static final l0 f21427c = new l0();

    /* renamed from: a  reason: collision with root package name */
    private byte[] f21428a;

    private l0() {
        this.f21428a = null;
        this.f21428a = null;
    }

    public l0(String str) {
        this.f21428a = null;
        try {
            this.f21428a = new byte[(str.length() + 1) / 2];
            int length = str.length() - 1;
            int i10 = 0;
            while (length >= 0) {
                int i11 = length - 1;
                this.f21428a[i10] = (byte) Integer.parseInt(str.substring(i11 < 0 ? 0 : i11, length + 1), 16);
                length -= 2;
                i10++;
            }
        } catch (Exception e10) {
            m0.m(f21426b, "PPRiskDataBitSet initialize failed", e10);
            this.f21428a = null;
        }
    }

    public final boolean a(bm bmVar) {
        int a10 = bmVar.a() / 8;
        byte[] bArr = this.f21428a;
        if (bArr == null) {
            return true;
        }
        if (a10 >= bArr.length) {
            return false;
        }
        byte b10 = bArr[a10];
        byte a11 = (byte) (1 << (bmVar.a() % 8));
        return (b10 & a11) == a11;
    }
}
