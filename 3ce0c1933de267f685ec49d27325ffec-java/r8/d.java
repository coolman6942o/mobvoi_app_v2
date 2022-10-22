package r8;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.common.reedsolomon.a;
import com.google.zxing.common.reedsolomon.c;
import o8.b;
/* compiled from: Decoder.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final c f33452a = new c(a.f13422m);

    private void a(byte[] bArr, int i10) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        try {
            this.f33452a.a(iArr, bArr.length - i10);
            for (int i12 = 0; i12 < i10; i12++) {
                bArr[i12] = (byte) iArr[i12];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public b b(com.google.zxing.common.b bVar) throws FormatException, ChecksumException {
        a aVar = new a(bVar);
        b[] b10 = b.b(aVar.c(), aVar.b());
        int i10 = 0;
        for (b bVar2 : b10) {
            i10 += bVar2.c();
        }
        byte[] bArr = new byte[i10];
        int length = b10.length;
        for (int i11 = 0; i11 < length; i11++) {
            b bVar3 = b10[i11];
            byte[] a10 = bVar3.a();
            int c10 = bVar3.c();
            a(a10, c10);
            for (int i12 = 0; i12 < c10; i12++) {
                bArr[(i12 * length) + i11] = a10[i12];
            }
        }
        return c.a(bArr);
    }
}
