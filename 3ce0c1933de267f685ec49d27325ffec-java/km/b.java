package km;

import java.util.Locale;
/* loaded from: classes2.dex */
public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    public int f30020a;

    /* renamed from: b  reason: collision with root package name */
    public int f30021b;

    /* renamed from: km.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0368b {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f30022a;

        /* renamed from: b  reason: collision with root package name */
        public int f30023b;

        public C0368b a(byte[] bArr, int i10) {
            this.f30022a = bArr;
            this.f30023b = i10;
            return this;
        }

        public b b() {
            return new b(this.f30023b, b.d(this.f30022a, this.f30023b));
        }
    }

    public b(int i10, int i11) {
        this.f30020a = i10;
        this.f30021b = i11;
    }

    public static short d(byte[] bArr, int i10) {
        short s10 = 0;
        for (int i11 = 0; i11 < i10; i11 += 2) {
            s10 = (short) (s10 ^ ((short) ((bArr[i11 + 1] << 8) | (bArr[i11] & 255))));
        }
        return (short) (((s10 & 255) << 8) | ((65280 & s10) >> 8));
    }

    public byte[] b() {
        int i10 = this.f30020a;
        int i11 = this.f30021b;
        return new byte[]{(byte) (i10 & 255), (byte) (i10 >> 8), (byte) (i11 & 255), (byte) ((i11 >> 8) & 255)};
    }

    public short c() {
        return (short) 1544;
    }

    public String toString() {
        return String.format("BufferCheckReq(0x%04X) {", Short.valueOf(c())) + String.format(Locale.US, "\n\tbufferSize=%d, crc16=0x%02X", Integer.valueOf(this.f30020a), Integer.valueOf(this.f30021b)) + "\n}";
    }
}
