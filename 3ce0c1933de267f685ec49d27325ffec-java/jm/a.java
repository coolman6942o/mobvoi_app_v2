package jm;

import java.util.Locale;
import km.c;
/* loaded from: classes2.dex */
public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    public int f29646a;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f29647a;

        public b(int i10) {
            this.f29647a = i10;
        }

        public a a() {
            return new a(this.f29647a);
        }
    }

    public a(int i10) {
        this.f29646a = i10;
    }

    public byte[] a() {
        int i10 = this.f29646a;
        return new byte[]{(byte) (i10 & 255), (byte) ((i10 >> 8) & 255)};
    }

    public short b() {
        return (short) 1545;
    }

    public String toString() {
        return String.format("GeTargetImageInfoReq(0x%04X) {", Short.valueOf(b())) + String.format(Locale.US, "\n\timageId=0x%02X", Integer.valueOf(this.f29646a)) + "\n}";
    }
}
