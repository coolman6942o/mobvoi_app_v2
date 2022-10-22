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
/* compiled from: MultiFormatUPCEANReader.java */
/* loaded from: classes.dex */
public final class j extends k {

    /* renamed from: a  reason: collision with root package name */
    private final p[] f35661a;

    public j(Map<DecodeHintType, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new e());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new l());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new f());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new q());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new e());
            arrayList.add(new f());
            arrayList.add(new q());
        }
        this.f35661a = (p[]) arrayList.toArray(new p[arrayList.size()]);
    }

    @Override // v8.k
    public h b(int i10, a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        int[] o10 = p.o(aVar);
        boolean z10 = false;
        for (p pVar : this.f35661a) {
            try {
                h l10 = pVar.l(i10, aVar, o10, map);
                boolean z11 = l10.b() == BarcodeFormat.EAN_13 && l10.f().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
                if (collection == null || collection.contains(BarcodeFormat.UPC_A)) {
                    z10 = true;
                }
                if (!z11 || !z10) {
                    return l10;
                }
                h hVar = new h(l10.f().substring(1), l10.c(), l10.e(), BarcodeFormat.UPC_A);
                hVar.g(l10.d());
                return hVar;
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
