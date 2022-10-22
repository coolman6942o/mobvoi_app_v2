package bm;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public int f5244a;

    /* renamed from: b  reason: collision with root package name */
    public int f5245b;

    /* renamed from: c  reason: collision with root package name */
    public int f5246c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5247d;

    /* renamed from: e  reason: collision with root package name */
    public int f5248e;

    public d(int i10, int i11, int i12, int i13, boolean z10, int i14) {
        this.f5244a = i11;
        this.f5245b = i12;
        this.f5246c = i13;
        this.f5247d = z10;
        this.f5248e = i14;
    }

    public static d a(int i10, int i11, byte[] bArr) {
        short s10;
        boolean z10;
        short s11;
        byte b10;
        byte b11;
        byte b12;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = bArr.length;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        if (i10 == 16) {
            b12 = wrap.get();
            byte b13 = wrap.get();
            b10 = wrap.get();
            s11 = wrap.getShort();
            if (i11 >= 4 || length < 7) {
                b11 = b13;
                z10 = false;
                s10 = 0;
            } else {
                z10 = true;
                s10 = wrap.getShort();
                b11 = b13;
            }
        } else {
            if (i10 == 20) {
                b12 = wrap.get();
                b11 = wrap.get();
                b10 = wrap.get();
                s11 = wrap.getShort();
                z10 = false;
            } else {
                b12 = 0;
                b11 = 0;
                b10 = 0;
                s11 = 0;
                z10 = false;
            }
            short s12 = z10 ? 1 : 0;
            Object[] objArr = z10 ? 1 : 0;
            Object[] objArr2 = z10 ? 1 : 0;
            Object[] objArr3 = z10 ? 1 : 0;
            s10 = s12;
        }
        return new d(b12, b11, b10, s11, z10, s10);
    }

    public boolean b() {
        return this.f5245b == 1;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format("EnableBufferCheckEvent(0x%04X) {", Integer.valueOf(this.f5244a)));
        Locale locale = Locale.US;
        sb2.append(String.format(locale, "\n\tmode=0x%02X, maxBufferCheckSize=0x%08X(%d), bufferCheckMutSizeSupported=%b)", Integer.valueOf(this.f5245b), Integer.valueOf(this.f5246c), Integer.valueOf(this.f5246c), Boolean.valueOf(this.f5247d)));
        if (this.f5247d) {
            sb2.append(String.format(locale, "\n\tbufferCheckMutSize=0x%08X(%d)", Integer.valueOf(this.f5248e), Integer.valueOf(this.f5248e)));
        }
        sb2.append("\n}");
        return sb2.toString();
    }
}
