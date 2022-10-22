package v8;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.a;
/* compiled from: EAN8Reader.java */
/* loaded from: classes.dex */
public final class f extends p {

    /* renamed from: h  reason: collision with root package name */
    private final int[] f35652h = new int[4];

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // v8.p
    public int k(a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.f35652h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int g10 = aVar.g();
        int i10 = iArr[1];
        for (int i11 = 0; i11 < 4 && i10 < g10; i11++) {
            sb2.append((char) (p.i(aVar, iArr2, i10, p.f35673f) + 48));
            for (int i12 : iArr2) {
                i10 += i12;
            }
        }
        int i13 = p.m(aVar, i10, true, p.f35672e)[1];
        for (int i14 = 0; i14 < 4 && i13 < g10; i14++) {
            sb2.append((char) (p.i(aVar, iArr2, i13, p.f35673f) + 48));
            for (int i15 : iArr2) {
                i13 += i15;
            }
        }
        return i13;
    }

    @Override // v8.p
    BarcodeFormat p() {
        return BarcodeFormat.EAN_8;
    }
}
