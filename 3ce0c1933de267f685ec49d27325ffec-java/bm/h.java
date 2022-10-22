package bm;

import java.util.Locale;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public int f5265a;

    /* renamed from: b  reason: collision with root package name */
    public int f5266b;

    /* renamed from: c  reason: collision with root package name */
    public int f5267c;

    /* renamed from: d  reason: collision with root package name */
    public byte f5268d;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f5269a;

        /* renamed from: b  reason: collision with root package name */
        public int f5270b;

        /* renamed from: c  reason: collision with root package name */
        public int f5271c;

        /* renamed from: d  reason: collision with root package name */
        public byte f5272d;

        public b(int i10, int i11) {
            this.f5269a = i10;
            this.f5270b = i11;
        }

        public b a(byte b10) {
            this.f5272d = b10;
            return this;
        }

        public b b(int i10) {
            this.f5271c = i10;
            return this;
        }

        public h c() {
            return new h(this.f5269a, this.f5270b, this.f5271c, this.f5272d);
        }
    }

    public h(int i10, int i11, int i12, byte b10) {
        this.f5265a = i10;
        this.f5266b = i11;
        this.f5267c = i12;
        this.f5268d = b10;
    }

    public byte[] a() {
        if (this.f5265a == 20) {
            return b();
        }
        if (this.f5266b >= 2) {
            int i10 = this.f5267c;
            return new byte[]{c(), (byte) (i10 & 255), (byte) ((i10 >> 8) & 255), this.f5268d};
        }
        int i11 = this.f5267c;
        return new byte[]{c(), (byte) (i11 & 255), (byte) ((i11 >> 8) & 255)};
    }

    public final byte[] b() {
        int i10 = this.f5267c;
        return new byte[]{c(), (byte) (i10 & 255), (byte) ((i10 >> 8) & 255), this.f5268d};
    }

    public byte c() {
        return (byte) 3;
    }

    public String toString() {
        return String.format("ValidateFwImageCmd(0x%04X-0x%02X:0x%02X) {", Integer.valueOf(this.f5265a), Integer.valueOf(this.f5266b), Byte.valueOf(c())) + String.format(Locale.US, "\n\timageId=0x%04X, flag=0x%02X", Integer.valueOf(this.f5267c), Byte.valueOf(this.f5268d)) + "\n}";
    }
}
