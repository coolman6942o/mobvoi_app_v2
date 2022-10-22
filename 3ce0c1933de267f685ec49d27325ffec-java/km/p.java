package km;

import java.util.Locale;
/* loaded from: classes2.dex */
public class p extends c {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f30043a;

    /* renamed from: b  reason: collision with root package name */
    public byte f30044b;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f30045a;

        /* renamed from: b  reason: collision with root package name */
        public byte f30046b = 0;

        public b a(byte b10) {
            this.f30046b = b10;
            return this;
        }

        public b b(byte[] bArr) {
            this.f30045a = bArr;
            return this;
        }

        public p c() {
            return new p(this.f30045a, this.f30046b);
        }
    }

    public p(byte[] bArr, byte b10) {
        this.f30043a = bArr;
        this.f30044b = b10;
    }

    public byte[] a() {
        byte[] bArr = new byte[16];
        byte[] bArr2 = this.f30043a;
        if (bArr2 != null && bArr2.length >= 12) {
            System.arraycopy(bArr2, 0, bArr, 0, 12);
        }
        bArr[12] = this.f30044b;
        return bArr;
    }

    public short b() {
        return (short) 1538;
    }

    public String toString() {
        return String.format("StartDfuReq(0x%04X) {", Short.valueOf(b())) + String.format(Locale.US, "\n\tmode=0x%02X, imageHeader=%s", Byte.valueOf(this.f30044b), jl.a.a(this.f30043a)) + "\n}";
    }
}
