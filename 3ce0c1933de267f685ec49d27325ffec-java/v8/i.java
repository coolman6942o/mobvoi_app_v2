package v8;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.common.a;
import com.google.zxing.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import w8.e;
import x8.d;
/* compiled from: MultiFormatOneDReader.java */
/* loaded from: classes.dex */
public final class i extends k {

    /* renamed from: a  reason: collision with root package name */
    private final k[] f35660a;

    public i(Map<DecodeHintType, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        boolean z10 = (map == null || map.get(DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new j(map));
            }
            if (collection.contains(BarcodeFormat.CODE_39)) {
                arrayList.add(new c(z10));
            }
            if (collection.contains(BarcodeFormat.CODE_93)) {
                arrayList.add(new d());
            }
            if (collection.contains(BarcodeFormat.CODE_128)) {
                arrayList.add(new b());
            }
            if (collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new h());
            }
            if (collection.contains(BarcodeFormat.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(BarcodeFormat.RSS_14)) {
                arrayList.add(new e());
            }
            if (collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                arrayList.add(new d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new j(map));
            arrayList.add(new c());
            arrayList.add(new a());
            arrayList.add(new d());
            arrayList.add(new b());
            arrayList.add(new h());
            arrayList.add(new e());
            arrayList.add(new d());
        }
        this.f35660a = (k[]) arrayList.toArray(new k[arrayList.size()]);
    }

    @Override // v8.k
    public h b(int i10, a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        for (k kVar : this.f35660a) {
            try {
                return kVar.b(i10, aVar, map);
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
