package km;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public short f30017a = 1544;

    /* renamed from: b  reason: collision with root package name */
    public byte f30018b;

    /* renamed from: c  reason: collision with root package name */
    public int f30019c;

    public a(byte b10, int i10) {
        this.f30018b = b10;
        this.f30019c = i10;
    }

    public static a a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = bArr.length;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        int i10 = 0;
        byte b10 = bArr[0];
        if (length >= 5) {
            i10 = wrap.getInt(1);
        }
        return new a(b10, i10);
    }

    public String toString() {
        return String.format("BufferCheckEvent(0x%04X) {", Short.valueOf(this.f30017a)) + String.format(Locale.US, "\n\tstatus=0x%02X, updateOffset=0x%08X(%d)", Byte.valueOf(this.f30018b), Integer.valueOf(this.f30019c), Integer.valueOf(this.f30019c)) + "\n}";
    }
}
