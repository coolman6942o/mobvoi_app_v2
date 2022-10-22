package v8;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.common.a;
import com.google.zxing.h;
import com.google.zxing.i;
import java.util.EnumMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UPCEANExtension5Support.java */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f35665c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* renamed from: a  reason: collision with root package name */
    private final int[] f35666a = new int[4];

    /* renamed from: b  reason: collision with root package name */
    private final StringBuilder f35667b = new StringBuilder();

    private int a(a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.f35666a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int g10 = aVar.g();
        int i10 = iArr[1];
        int i11 = 0;
        for (int i12 = 0; i12 < 5 && i10 < g10; i12++) {
            int i13 = p.i(aVar, iArr2, i10, p.f35674g);
            sb2.append((char) ((i13 % 10) + 48));
            for (int i14 : iArr2) {
                i10 += i14;
            }
            if (i13 >= 10) {
                i11 |= 1 << (4 - i12);
            }
            if (i12 != 4) {
                i10 = aVar.f(aVar.e(i10));
            }
        }
        if (sb2.length() == 5) {
            if (d(sb2.toString()) == c(i11)) {
                return i10;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int c(int i10) throws NotFoundException {
        for (int i11 = 0; i11 < 10; i11++) {
            if (i10 == f35665c[i11]) {
                return i11;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        for (int i11 = length - 2; i11 >= 0; i11 -= 2) {
            i10 += charSequence.charAt(i11) - '0';
        }
        int i12 = i10 * 3;
        for (int i13 = length - 1; i13 >= 0; i13 -= 2) {
            i12 += charSequence.charAt(i13) - '0';
        }
        return (i12 * 3) % 10;
    }

    private static String e(String str) {
        String str2;
        char charAt = str.charAt(0);
        String str3 = "";
        if (charAt == '0') {
            str3 = "£";
        } else if (charAt == '5') {
            str3 = "$";
        } else if (charAt == '9') {
            if ("90000".equals(str)) {
                return null;
            }
            if ("99991".equals(str)) {
                return "0.00";
            }
            if ("99990".equals(str)) {
                return "Used";
            }
        }
        int parseInt = Integer.parseInt(str.substring(1));
        String valueOf = String.valueOf(parseInt / 100);
        int i10 = parseInt % 100;
        if (i10 < 10) {
            str2 = "0" + i10;
        } else {
            str2 = String.valueOf(i10);
        }
        return str3 + valueOf + '.' + str2;
    }

    private static Map<ResultMetadataType, Object> f(String str) {
        String e10;
        if (str.length() != 5 || (e10 = e(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put((EnumMap) ResultMetadataType.SUGGESTED_PRICE, (ResultMetadataType) e10);
        return enumMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h b(int i10, a aVar, int[] iArr) throws NotFoundException {
        StringBuilder sb2 = this.f35667b;
        sb2.setLength(0);
        int a10 = a(aVar, iArr, sb2);
        String sb3 = sb2.toString();
        Map<ResultMetadataType, Object> f10 = f(sb3);
        float f11 = i10;
        h hVar = new h(sb3, null, new i[]{new i((iArr[0] + iArr[1]) / 2.0f, f11), new i(a10, f11)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (f10 != null) {
            hVar.g(f10);
        }
        return hVar;
    }
}
