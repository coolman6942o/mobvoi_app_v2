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
/* compiled from: UPCEANExtension2Support.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f35663a = new int[4];

    /* renamed from: b  reason: collision with root package name */
    private final StringBuilder f35664b = new StringBuilder();

    private int a(a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.f35663a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int g10 = aVar.g();
        int i10 = iArr[1];
        int i11 = 0;
        for (int i12 = 0; i12 < 2 && i10 < g10; i12++) {
            int i13 = p.i(aVar, iArr2, i10, p.f35674g);
            sb2.append((char) ((i13 % 10) + 48));
            for (int i14 : iArr2) {
                i10 += i14;
            }
            if (i13 >= 10) {
                i11 |= 1 << (1 - i12);
            }
            if (i12 != 1) {
                i10 = aVar.f(aVar.e(i10));
            }
        }
        if (sb2.length() != 2) {
            throw NotFoundException.getNotFoundInstance();
        } else if (Integer.parseInt(sb2.toString()) % 4 == i11) {
            return i10;
        } else {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private static Map<ResultMetadataType, Object> c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put((EnumMap) ResultMetadataType.ISSUE_NUMBER, (ResultMetadataType) Integer.valueOf(str));
        return enumMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h b(int i10, a aVar, int[] iArr) throws NotFoundException {
        StringBuilder sb2 = this.f35664b;
        sb2.setLength(0);
        int a10 = a(aVar, iArr, sb2);
        String sb3 = sb2.toString();
        Map<ResultMetadataType, Object> c10 = c(sb3);
        float f10 = i10;
        h hVar = new h(sb3, null, new i[]{new i((iArr[0] + iArr[1]) / 2.0f, f10), new i(a10, f10)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (c10 != null) {
            hVar.g(c10);
        }
        return hVar;
    }
}
