package km;

import java.util.Locale;
/* loaded from: classes2.dex */
public class h extends c {

    /* renamed from: a  reason: collision with root package name */
    public int f30028a;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f30029a;

        public b(int i10) {
            this.f30029a = i10;
        }

        public h a() {
            return new h(this.f30029a);
        }
    }

    public h(int i10) {
        this.f30028a = i10;
    }

    public byte[] a() {
        int i10 = this.f30028a;
        return new byte[]{(byte) (i10 & 255), (byte) ((i10 >> 8) & 255)};
    }

    public short b() {
        return (short) 1545;
    }

    public String toString() {
        return String.format("GeTargetImageInfoReq(0x%04X) {", Short.valueOf(b())) + String.format(Locale.US, "\n\timageId=0x%02X", Integer.valueOf(this.f30028a)) + "\n}";
    }
}
