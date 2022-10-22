package v8;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.a;
/* compiled from: UPCEReader.java */
/* loaded from: classes.dex */
public final class q extends p {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f35678i = {1, 1, 1, 1, 1, 1};

    /* renamed from: j  reason: collision with root package name */
    private static final int[][] f35679j = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* renamed from: h  reason: collision with root package name */
    private final int[] f35680h = new int[4];

    public static String q(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb2 = new StringBuilder(12);
        sb2.append(str.charAt(0));
        char c10 = cArr[5];
        switch (c10) {
            case '0':
            case '1':
            case '2':
                sb2.append(cArr, 0, 2);
                sb2.append(c10);
                sb2.append("0000");
                sb2.append(cArr, 2, 3);
                break;
            case '3':
                sb2.append(cArr, 0, 3);
                sb2.append("00000");
                sb2.append(cArr, 3, 2);
                break;
            case '4':
                sb2.append(cArr, 0, 4);
                sb2.append("00000");
                sb2.append(cArr[4]);
                break;
            default:
                sb2.append(cArr, 0, 5);
                sb2.append("0000");
                sb2.append(c10);
                break;
        }
        sb2.append(str.charAt(7));
        return sb2.toString();
    }

    private static void r(StringBuilder sb2, int i10) throws NotFoundException {
        for (int i11 = 0; i11 <= 1; i11++) {
            for (int i12 = 0; i12 < 10; i12++) {
                if (i10 == f35679j[i11][i12]) {
                    sb2.insert(0, (char) (i11 + 48));
                    sb2.append((char) (i12 + 48));
                    return;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // v8.p
    public boolean g(String str) throws FormatException {
        return super.g(q(str));
    }

    @Override // v8.p
    protected int[] j(a aVar, int i10) throws NotFoundException {
        return p.m(aVar, i10, true, f35678i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // v8.p
    public int k(a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.f35680h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int g10 = aVar.g();
        int i10 = iArr[1];
        int i11 = 0;
        for (int i12 = 0; i12 < 6 && i10 < g10; i12++) {
            int i13 = p.i(aVar, iArr2, i10, p.f35674g);
            sb2.append((char) ((i13 % 10) + 48));
            for (int i14 : iArr2) {
                i10 += i14;
            }
            if (i13 >= 10) {
                i11 |= 1 << (5 - i12);
            }
        }
        r(sb2, i11);
        return i10;
    }

    @Override // v8.p
    BarcodeFormat p() {
        return BarcodeFormat.UPC_E;
    }
}
