package d9;

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
import com.google.zxing.qrcode.decoder.e;
import java.util.List;
import java.util.Map;
import o8.c;
/* compiled from: QRCodeReader.java */
/* loaded from: classes.dex */
public class a implements g {

    /* renamed from: b  reason: collision with root package name */
    private static final i[] f25569b = new i[0];

    /* renamed from: a  reason: collision with root package name */
    private final e f25570a = new e();

    private static b c(b bVar) throws NotFoundException {
        int[] j10 = bVar.j();
        int[] e10 = bVar.e();
        if (j10 == null || e10 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float d10 = d(j10, bVar);
        int i10 = j10[1];
        int i11 = e10[1];
        int i12 = j10[0];
        int i13 = e10[0];
        if (i12 >= i13 || i10 >= i11) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i14 = i11 - i10;
        if (i14 == i13 - i12 || (i13 = i12 + i14) < bVar.k()) {
            int round = Math.round(((i13 - i12) + 1) / d10);
            int round2 = Math.round((i14 + 1) / d10);
            if (round <= 0 || round2 <= 0) {
                throw NotFoundException.getNotFoundInstance();
            } else if (round2 == round) {
                int i15 = (int) (d10 / 2.0f);
                int i16 = i10 + i15;
                int i17 = i12 + i15;
                int i18 = (((int) ((round - 1) * d10)) + i17) - i13;
                if (i18 > 0) {
                    if (i18 <= i15) {
                        i17 -= i18;
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
                int i19 = (((int) ((round2 - 1) * d10)) + i16) - i11;
                if (i19 > 0) {
                    if (i19 <= i15) {
                        i16 -= i19;
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
                b bVar2 = new b(round, round2);
                for (int i20 = 0; i20 < round2; i20++) {
                    int i21 = ((int) (i20 * d10)) + i16;
                    for (int i22 = 0; i22 < round; i22++) {
                        if (bVar.d(((int) (i22 * d10)) + i17, i21)) {
                            bVar2.m(i22, i20);
                        }
                    }
                }
                return bVar2;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        } else {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private static float d(int[] iArr, b bVar) throws NotFoundException {
        int g10 = bVar.g();
        int k10 = bVar.k();
        int i10 = iArr[0];
        boolean z10 = true;
        int i11 = iArr[1];
        int i12 = 0;
        while (i10 < k10 && i11 < g10) {
            if (z10 != bVar.d(i10, i11)) {
                i12++;
                if (i12 == 5) {
                    break;
                }
                z10 = !z10;
            }
            i10++;
            i11++;
        }
        if (i10 != k10 && i11 != g10) {
            return (i10 - iArr[0]) / 7.0f;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.g
    public final h a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        i[] iVarArr;
        o8.b bVar2;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            c e10 = new e9.c(bVar.a()).e(map);
            bVar2 = this.f25570a.b(e10.a(), map);
            iVarArr = e10.b();
        } else {
            bVar2 = this.f25570a.b(c(bVar.a()), map);
            iVarArr = f25569b;
        }
        if (bVar2.d() instanceof com.google.zxing.qrcode.decoder.g) {
            ((com.google.zxing.qrcode.decoder.g) bVar2.d()).a(iVarArr);
        }
        h hVar = new h(bVar2.h(), bVar2.e(), iVarArr, BarcodeFormat.QR_CODE);
        List<byte[]> a10 = bVar2.a();
        if (a10 != null) {
            hVar.h(ResultMetadataType.BYTE_SEGMENTS, a10);
        }
        String b10 = bVar2.b();
        if (b10 != null) {
            hVar.h(ResultMetadataType.ERROR_CORRECTION_LEVEL, b10);
        }
        if (bVar2.i()) {
            hVar.h(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(bVar2.g()));
            hVar.h(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(bVar2.f()));
        }
        return hVar;
    }

    public h b(com.google.zxing.b bVar) throws NotFoundException, ChecksumException, FormatException {
        return a(bVar, null);
    }

    public void e() {
    }
}
