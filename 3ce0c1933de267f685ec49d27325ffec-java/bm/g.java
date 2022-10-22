package bm;

import java.util.Locale;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f5262a;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f5263a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f5264b;

        public b(int i10) {
            this.f5263a = i10;
        }

        public b a(byte[] bArr) {
            this.f5264b = bArr;
            return this;
        }

        public g b() {
            return new g(this.f5263a, this.f5264b);
        }
    }

    public g(int i10, byte[] bArr) {
        this.f5262a = bArr;
    }

    public byte[] a() {
        byte[] bArr = new byte[17];
        bArr[0] = b();
        byte[] bArr2 = this.f5262a;
        if (bArr2 != null && bArr2.length >= 16) {
            System.arraycopy(bArr2, 0, bArr, 1, 16);
        }
        return bArr;
    }

    public byte b() {
        return (byte) 1;
    }

    public String toString() {
        return String.format("StartDfuCmd(0x%02X) {", Byte.valueOf(b())) + String.format(Locale.US, "\n\tparams=%s", jl.a.a(this.f5262a)) + "\n}";
    }
}
