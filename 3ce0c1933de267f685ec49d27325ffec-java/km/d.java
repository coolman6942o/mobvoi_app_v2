package km;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public short f30024a = 1541;

    /* renamed from: b  reason: collision with root package name */
    public byte f30025b;

    /* renamed from: c  reason: collision with root package name */
    public int f30026c;

    /* renamed from: d  reason: collision with root package name */
    public int f30027d;

    public d(byte b10, int i10, int i11) {
        this.f30025b = b10;
        this.f30026c = i10;
        this.f30027d = i11;
    }

    public static d a(byte[] bArr) {
        int i10 = 0;
        if (bArr == null || bArr.length < 1) {
            return new d((byte) 2, 0, 0);
        }
        int length = bArr.length;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        byte b10 = bArr[0];
        int i11 = length >= 3 ? (((short) (wrap.get(2) & 255)) << 8) | ((short) (wrap.get(1) & 255)) : 0;
        if (length >= 4) {
            i10 = (((short) (wrap.get(4) & 255)) << 8) | ((short) (wrap.get(3) & 255));
        }
        return new d(b10, i11, i10);
    }

    public String toString() {
        return String.format("EnableBufferCheckRsp(0x%04X) {", Short.valueOf(this.f30024a)) + String.format(Locale.US, "\n\tstatus=0x%02X,maxBufferSize=0x%04X(%d), bufferCheckMtuSize=0x%04X(%d)", Byte.valueOf(this.f30025b), Integer.valueOf(this.f30026c), Integer.valueOf(this.f30026c), Integer.valueOf(this.f30027d), Integer.valueOf(this.f30027d)) + "\n}";
    }
}
