package l8;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.g;
import com.google.zxing.h;
import com.google.zxing.i;
import com.google.zxing.j;
import java.util.List;
import java.util.Map;
import n8.a;
/* compiled from: AztecReader.java */
/* loaded from: classes.dex */
public final class b implements g {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005e A[LOOP:0: B:28:0x005c->B:29:0x005e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008f  */
    @Override // com.google.zxing.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        i[] iVarArr;
        FormatException formatException;
        NotFoundException e10;
        i[] iVarArr2;
        List<byte[]> a10;
        String b10;
        j jVar;
        i[] iVarArr3;
        FormatException e11;
        a aVar = new a(bVar.a());
        o8.b bVar2 = null;
        try {
            a a11 = aVar.a(false);
            iVarArr3 = a11.b();
            try {
                bVar2 = new m8.a().c(a11);
                iVarArr = iVarArr3;
                formatException = null;
                e10 = null;
            } catch (FormatException e12) {
                e11 = e12;
                iVarArr = iVarArr3;
                formatException = e11;
                e10 = null;
                if (bVar2 == null) {
                }
                iVarArr2 = iVarArr;
                if (map == null) {
                    while (r11 < r0) {
                    }
                }
                h hVar = new h(bVar2.h(), bVar2.e(), bVar2.c(), iVarArr2, BarcodeFormat.AZTEC, System.currentTimeMillis());
                a10 = bVar2.a();
                if (a10 != null) {
                }
                b10 = bVar2.b();
                if (b10 != null) {
                }
                return hVar;
            } catch (NotFoundException e13) {
                e10 = e13;
                iVarArr = iVarArr3;
                formatException = null;
                if (bVar2 == null) {
                }
                iVarArr2 = iVarArr;
                if (map == null) {
                }
                h hVar2 = new h(bVar2.h(), bVar2.e(), bVar2.c(), iVarArr2, BarcodeFormat.AZTEC, System.currentTimeMillis());
                a10 = bVar2.a();
                if (a10 != null) {
                }
                b10 = bVar2.b();
                if (b10 != null) {
                }
                return hVar2;
            }
        } catch (FormatException e14) {
            e11 = e14;
            iVarArr3 = null;
        } catch (NotFoundException e15) {
            e10 = e15;
            iVarArr3 = null;
        }
        if (bVar2 == null) {
            try {
                a a12 = aVar.a(true);
                iVarArr = a12.b();
                bVar2 = new m8.a().c(a12);
            } catch (FormatException | NotFoundException e16) {
                if (e10 != null) {
                    throw e10;
                } else if (formatException != null) {
                    throw formatException;
                } else {
                    throw e16;
                }
            }
        }
        iVarArr2 = iVarArr;
        if (!(map == null || (jVar = (j) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) == null)) {
            for (i iVar : iVarArr2) {
                jVar.a(iVar);
            }
        }
        h hVar22 = new h(bVar2.h(), bVar2.e(), bVar2.c(), iVarArr2, BarcodeFormat.AZTEC, System.currentTimeMillis());
        a10 = bVar2.a();
        if (a10 != null) {
            hVar22.h(ResultMetadataType.BYTE_SEGMENTS, a10);
        }
        b10 = bVar2.b();
        if (b10 != null) {
            hVar22.h(ResultMetadataType.ERROR_CORRECTION_LEVEL, b10);
        }
        return hVar22;
    }
}
