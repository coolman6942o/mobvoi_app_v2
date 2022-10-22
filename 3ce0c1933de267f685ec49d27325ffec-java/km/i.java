package km;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public short f30030a = 1543;

    /* renamed from: b  reason: collision with root package name */
    public byte f30031b;

    /* renamed from: c  reason: collision with root package name */
    public int f30032c;

    /* renamed from: d  reason: collision with root package name */
    public int f30033d;

    /* renamed from: e  reason: collision with root package name */
    public int f30034e;

    public i(byte b10, int i10, int i11, int i12) {
        this.f30031b = b10;
        this.f30032c = i10;
        this.f30033d = i11;
        this.f30034e = i12;
    }

    public static i b(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = bArr.length;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        short s10 = 0;
        byte b10 = bArr[0];
        int i10 = length >= 5 ? wrap.getInt(1) : 0;
        int i11 = length >= 9 ? wrap.getInt(5) : 0;
        if (length >= 11) {
            s10 = wrap.getShort(9);
        }
        return new i(b10, i10, i11, s10);
    }

    public int a() {
        return this.f30034e;
    }

    public byte c() {
        return this.f30031b;
    }

    public int d() {
        return this.f30033d;
    }

    public String toString() {
        return String.format("GeTargetImageInfoRsp(0x%04X) {", Short.valueOf(this.f30030a)) + String.format(Locale.US, "\n\tstatus=0x%02X,imageVersion=0x%08X, updateOffset=0x%08X(%d),bufferCheckOffset=0x%08X(%d)", Byte.valueOf(this.f30031b), Integer.valueOf(this.f30032c), Integer.valueOf(this.f30033d), Integer.valueOf(this.f30033d), Integer.valueOf(this.f30034e), Integer.valueOf(this.f30034e)) + "\n}";
    }
}
