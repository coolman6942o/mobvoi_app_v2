package sl;

import il.b;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
/* loaded from: classes2.dex */
public class a extends wl.a {
    public a(InputStream inputStream) {
        super(inputStream);
    }

    @Override // wl.a
    public boolean g0() {
        return true;
    }

    @Override // wl.a
    public void i() {
        super.i();
        ByteBuffer wrap = ByteBuffer.wrap(this.f36322v, 0, 12);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        if (this.f36308h == 0) {
            this.f36309i = wrap.get();
            this.f36320t = wrap.get();
            this.f36310j = wrap.getShort() & 65535;
            this.f36312l = wrap.getShort() & 65535;
            this.f36321u = wrap.getShort();
            if (this.f36314n <= 0) {
                this.f36313m = wrap.getInt();
            }
        } else {
            this.f36309i = wrap.get(2);
            this.f36320t = wrap.get();
            if (!this.f36311k) {
                this.f36310j = wrap.getShort(6) & 65535;
            }
            wrap.getShort();
            this.f36321u = wrap.getShort();
            wrap.getInt();
        }
        if (this.f36301a) {
            b.c(String.format(Locale.US, "binHeader: icType=0x%02X, otaFlag=0x%02X, imageId=0x%04X, imageVersion=0x%08X, crc16=0x%04X, imageSize(exclude image header)=0x%08X(%d)", Byte.valueOf(this.f36309i), Byte.valueOf(this.f36320t), Integer.valueOf(this.f36310j), Integer.valueOf(this.f36312l), Short.valueOf(this.f36321u), Integer.valueOf(this.f36313m), Integer.valueOf(this.f36313m)));
        }
    }

    @Override // wl.a
    public void o() {
        super.o();
    }
}
