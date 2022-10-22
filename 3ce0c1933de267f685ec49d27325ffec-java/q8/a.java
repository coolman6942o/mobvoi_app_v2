package q8;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.common.b;
import com.google.zxing.g;
import com.google.zxing.h;
import com.google.zxing.i;
import java.util.List;
import java.util.Map;
import o8.c;
import r8.d;
/* compiled from: DataMatrixReader.java */
/* loaded from: classes.dex */
public final class a implements g {

    /* renamed from: b  reason: collision with root package name */
    private static final i[] f32933b = new i[0];

    /* renamed from: a  reason: collision with root package name */
    private final d f32934a = new d();

    private static b b(b bVar) throws NotFoundException {
        int[] j10 = bVar.j();
        int[] e10 = bVar.e();
        if (j10 == null || e10 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        int c10 = c(j10, bVar);
        int i10 = j10[1];
        int i11 = e10[1];
        int i12 = j10[0];
        int i13 = ((e10[0] - i12) + 1) / c10;
        int i14 = ((i11 - i10) + 1) / c10;
        if (i13 <= 0 || i14 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i15 = c10 / 2;
        int i16 = i10 + i15;
        int i17 = i12 + i15;
        b bVar2 = new b(i13, i14);
        for (int i18 = 0; i18 < i14; i18++) {
            int i19 = (i18 * c10) + i16;
            for (int i20 = 0; i20 < i13; i20++) {
                if (bVar.d((i20 * c10) + i17, i19)) {
                    bVar2.m(i20, i18);
                }
            }
        }
        return bVar2;
    }

    private static int c(int[] iArr, b bVar) throws NotFoundException {
        int k10 = bVar.k();
        int i10 = iArr[0];
        int i11 = iArr[1];
        while (i10 < k10 && bVar.d(i10, i11)) {
            i10++;
        }
        if (i10 != k10) {
            int i12 = i10 - iArr[0];
            if (i12 != 0) {
                return i12;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.g
    public h a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        i[] iVarArr;
        o8.b bVar2;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            c c10 = new s8.a(bVar.a()).c();
            bVar2 = this.f32934a.b(c10.a());
            iVarArr = c10.b();
        } else {
            bVar2 = this.f32934a.b(b(bVar.a()));
            iVarArr = f32933b;
        }
        h hVar = new h(bVar2.h(), bVar2.e(), iVarArr, BarcodeFormat.DATA_MATRIX);
        List<byte[]> a10 = bVar2.a();
        if (a10 != null) {
            hVar.h(ResultMetadataType.BYTE_SEGMENTS, a10);
        }
        String b10 = bVar2.b();
        if (b10 != null) {
            hVar.h(ResultMetadataType.ERROR_CORRECTION_LEVEL, b10);
        }
        return hVar;
    }
}
