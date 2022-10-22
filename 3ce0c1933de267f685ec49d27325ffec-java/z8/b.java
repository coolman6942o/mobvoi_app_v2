package z8;

import a9.j;
import c9.a;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.g;
import com.google.zxing.h;
import com.google.zxing.i;
import java.util.ArrayList;
import java.util.Map;
/* compiled from: PDF417Reader.java */
/* loaded from: classes.dex */
public final class b implements g {
    private static h[] b(com.google.zxing.b bVar, Map<DecodeHintType, ?> map, boolean z10) throws NotFoundException, FormatException, ChecksumException {
        ArrayList arrayList = new ArrayList();
        c9.b b10 = a.b(bVar, map, z10);
        for (i[] iVarArr : b10.b()) {
            o8.b i10 = j.i(b10.a(), iVarArr[4], iVarArr[5], iVarArr[6], iVarArr[7], e(iVarArr), c(iVarArr));
            h hVar = new h(i10.h(), i10.e(), iVarArr, BarcodeFormat.PDF_417);
            hVar.h(ResultMetadataType.ERROR_CORRECTION_LEVEL, i10.b());
            c cVar = (c) i10.d();
            if (cVar != null) {
                hVar.h(ResultMetadataType.PDF417_EXTRA_METADATA, cVar);
            }
            arrayList.add(hVar);
        }
        return (h[]) arrayList.toArray(new h[arrayList.size()]);
    }

    private static int c(i[] iVarArr) {
        return Math.max(Math.max(d(iVarArr[0], iVarArr[4]), (d(iVarArr[6], iVarArr[2]) * 17) / 18), Math.max(d(iVarArr[1], iVarArr[5]), (d(iVarArr[7], iVarArr[3]) * 17) / 18));
    }

    private static int d(i iVar, i iVar2) {
        if (iVar == null || iVar2 == null) {
            return 0;
        }
        return (int) Math.abs(iVar.c() - iVar2.c());
    }

    private static int e(i[] iVarArr) {
        return Math.min(Math.min(f(iVarArr[0], iVarArr[4]), (f(iVarArr[6], iVarArr[2]) * 17) / 18), Math.min(f(iVarArr[1], iVarArr[5]), (f(iVarArr[7], iVarArr[3]) * 17) / 18));
    }

    private static int f(i iVar, i iVar2) {
        if (iVar == null || iVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(iVar.c() - iVar2.c());
    }

    @Override // com.google.zxing.g
    public h a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        h[] b10 = b(bVar, map, false);
        if (b10 != null && b10.length != 0 && b10[0] != null) {
            return b10[0];
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
