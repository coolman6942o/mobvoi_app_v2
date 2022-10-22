package sl;

import il.b;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
import wl.a;
/* loaded from: classes2.dex */
public class c extends a {
    public c(InputStream inputStream) {
        super(inputStream);
    }

    @Override // wl.a
    public int k0() {
        return (this.f36313m * 4) - this.f36325y;
    }

    @Override // wl.a
    public void o() {
        super.o();
        ByteBuffer wrap = ByteBuffer.wrap(this.f36307g, 0, 12);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        this.f36309i = (byte) 3;
        this.f36318r = wrap.getShort() & 65535;
        this.f36310j = wrap.getShort() & 65535;
        this.f36312l = wrap.getShort() & 65535;
        this.f36321u = wrap.getShort();
        this.f36313m = wrap.getShort() & 65535;
        byte[] bArr = this.f36307g;
        this.f36320t = bArr[10];
        byte b10 = bArr[11];
        b.j(String.format(Locale.US, "flashAddr=0x%04X, imageId=0x%04X, imageVersion=0x%08X(%d), crc16=0x%04X, imageSize=0x%04X(%d), otaFlag=0x%02X", Integer.valueOf(this.f36318r), Integer.valueOf(this.f36310j), Integer.valueOf(this.f36312l), Integer.valueOf(this.f36312l), Short.valueOf(this.f36321u), Integer.valueOf(this.f36313m), Integer.valueOf(this.f36313m), Byte.valueOf(this.f36320t)));
    }
}
