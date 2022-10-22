package t8;

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
import java.util.Map;
import u8.c;
/* compiled from: MaxiCodeReader.java */
/* loaded from: classes.dex */
public final class a implements g {

    /* renamed from: b  reason: collision with root package name */
    private static final i[] f35088b = new i[0];

    /* renamed from: a  reason: collision with root package name */
    private final c f35089a = new c();

    private static b b(b bVar) throws NotFoundException {
        int[] f10 = bVar.f();
        if (f10 != null) {
            int i10 = f10[0];
            int i11 = f10[1];
            int i12 = f10[2];
            int i13 = f10[3];
            b bVar2 = new b(30, 33);
            for (int i14 = 0; i14 < 33; i14++) {
                int i15 = (((i14 * i13) + (i13 / 2)) / 33) + i11;
                for (int i16 = 0; i16 < 30; i16++) {
                    if (bVar.d(((((i16 * i12) + (i12 / 2)) + (((i14 & 1) * i12) / 2)) / 30) + i10, i15)) {
                        bVar2.m(i16, i14);
                    }
                }
            }
            return bVar2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.g
    public h a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            throw NotFoundException.getNotFoundInstance();
        }
        o8.b b10 = this.f35089a.b(b(bVar.a()), map);
        h hVar = new h(b10.h(), b10.e(), f35088b, BarcodeFormat.MAXICODE);
        String b11 = b10.b();
        if (b11 != null) {
            hVar.h(ResultMetadataType.ERROR_CORRECTION_LEVEL, b11);
        }
        return hVar;
    }
}
