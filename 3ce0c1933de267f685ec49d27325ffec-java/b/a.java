package b;

import java.util.Locale;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public short f4919a;

    /* renamed from: b  reason: collision with root package name */
    public byte f4920b;

    public a() {
        this.f4919a = (short) 0;
        this.f4920b = (byte) 0;
        this.f4919a = (short) 0;
        this.f4920b = (byte) 0;
    }

    public static byte[] c(short s10, byte b10) {
        return new byte[]{0, 0, (byte) (s10 & 255), (byte) ((s10 >> 8) & 255), b10};
    }

    public static a d(byte[] bArr) {
        a aVar = new a();
        if (aVar.b(bArr)) {
            return aVar;
        }
        return null;
    }

    public byte a() {
        return this.f4920b;
    }

    public boolean b(byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            return false;
        }
        this.f4919a = (short) (((bArr[0] & 255) | (bArr[1] << 8)) & 65535);
        this.f4920b = (byte) (bArr[2] & 255);
        return true;
    }

    public short e() {
        return this.f4919a;
    }

    public String toString() {
        return "ACK {" + String.format(Locale.US, "\n\topcode=0x%04X, status=0x%02X", Short.valueOf(this.f4919a), Byte.valueOf(this.f4920b)) + "\n}";
    }
}
