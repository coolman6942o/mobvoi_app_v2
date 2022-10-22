package sl;

import com.amap.api.services.core.AMapException;
import il.b;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
import wl.a;
/* loaded from: classes2.dex */
public class d extends a {
    public d(InputStream inputStream) {
        super(inputStream);
    }

    @Override // wl.a
    public void o() {
        super.o();
        ByteBuffer wrap = ByteBuffer.wrap(this.f36307g, 0, 12);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        if (this.f36308h == 0) {
            this.f36309i = wrap.get();
            this.f36319s = wrap.get();
            wrap.getShort();
            this.f36310j = wrap.getShort() & 65535;
            this.f36321u = wrap.getShort();
            if (this.f36314n <= 0) {
                this.f36313m = wrap.getInt() + AMapException.CODE_AMAP_INSUFFICIENT_PRIVILEGES;
            }
        } else {
            this.f36309i = wrap.get();
            wrap.get();
            wrap.getShort();
            if (!this.f36311k) {
                this.f36310j = wrap.getShort() & 65535;
            }
            this.f36321u = wrap.getShort();
            wrap.getInt();
        }
        b.j(String.format(Locale.US, "icType=0x%02X, secure_version=0x%02x, otaFlag=0x%02x, imageId=0x%04x, imageVersion=0x%08X, crc16=0x%04x, imageSize=0x%08X(%d)", Byte.valueOf(this.f36309i), Integer.valueOf(this.f36319s), Byte.valueOf(this.f36320t), Integer.valueOf(this.f36310j), Integer.valueOf(this.f36312l), Short.valueOf(this.f36321u), Integer.valueOf(this.f36313m), Integer.valueOf(this.f36313m)));
    }
}
