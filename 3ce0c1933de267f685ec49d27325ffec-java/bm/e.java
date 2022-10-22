package bm;

import java.util.Locale;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f5249a;

    /* renamed from: b  reason: collision with root package name */
    public int f5250b;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f5251a;

        /* renamed from: b  reason: collision with root package name */
        public int f5252b;

        /* renamed from: c  reason: collision with root package name */
        public int f5253c;

        public b(int i10) {
            this.f5251a = i10;
        }

        public b a(int i10) {
            this.f5252b = i10;
            return this;
        }

        public e b() {
            return new e(this.f5251a, this.f5252b, this.f5253c);
        }

        public b c(int i10) {
            this.f5253c = i10;
            return this;
        }
    }

    public e(int i10, int i11, int i12) {
        this.f5249a = i11;
        this.f5250b = i12;
    }

    public byte[] a() {
        int i10 = this.f5249a;
        int i11 = this.f5250b;
        return new byte[]{b(), (byte) (i10 & 255), (byte) ((i10 >> 8) & 255), (byte) (i11 & 255), (byte) ((i11 >> 8) & 255), (byte) ((i11 >> 16) & 255), (byte) ((i11 >> 24) & 255)};
    }

    public byte b() {
        return (byte) 2;
    }

    public String toString() {
        return String.format("ValidateFwImageCmd(0x%02X) {", Byte.valueOf(b())) + String.format(Locale.US, "\n\timageId=0x%04X, offset=0x%08X(%d)", Integer.valueOf(this.f5249a), Integer.valueOf(this.f5250b), Integer.valueOf(this.f5250b)) + "\n}";
    }
}
