package y2;

import java.lang.reflect.Array;
import x2.c;
import x2.h;
import z2.a;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static /* synthetic */ a f36733a = z2.b.a().b();

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[8];
        bArr4[0] = Byte.MIN_VALUE;
        if (bArr3 == null) {
            f36733a.b(b.class.getName(), h.e("M\u001aU记篛斱．攭挶丩`<(s", 3, 91));
        }
        if (bArr2 == null) {
            bArr2 = new byte[8];
        }
        byte[] s10 = c.s(bArr3, c.k(bArr4, bArr3.length % 8 != 0 ? 8 - (bArr3.length % 8) : 8));
        int length = s10.length / 8;
        byte[][] bArr5 = (byte[][]) Array.newInstance(byte.class, length, 8);
        for (int i10 = 0; i10 < length; i10++) {
            for (int i11 = 0; i11 < 8; i11++) {
                bArr5[i10][i11] = s10[(i10 << 3) + i11];
            }
        }
        byte[] w10 = c.w(bArr2, bArr5[0]);
        for (int i12 = 1; i12 < length; i12++) {
            w10 = c.w(a.c(bArr, w10), bArr5[i12]);
        }
        return a.c(bArr, w10);
    }
}
