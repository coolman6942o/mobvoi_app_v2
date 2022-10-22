package com.google.zxing;

import d9.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import l8.b;
import v8.i;
/* compiled from: MultiFormatReader.java */
/* loaded from: classes.dex */
public final class d implements g {

    /* renamed from: a  reason: collision with root package name */
    private Map<DecodeHintType, ?> f13435a;

    /* renamed from: b  reason: collision with root package name */
    private g[] f13436b;

    private h c(b bVar) throws NotFoundException {
        g[] gVarArr = this.f13436b;
        if (gVarArr != null) {
            for (g gVar : gVarArr) {
                try {
                    return gVar.a(bVar, this.f13435a);
                } catch (ReaderException unused) {
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.g
    public h a(b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        d(map);
        return c(bVar);
    }

    public h b(b bVar) throws NotFoundException {
        d(null);
        return c(bVar);
    }

    public void d(Map<DecodeHintType, ?> map) {
        this.f13435a = map;
        boolean z10 = true;
        boolean z11 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (!collection.contains(BarcodeFormat.UPC_A) && !collection.contains(BarcodeFormat.UPC_E) && !collection.contains(BarcodeFormat.EAN_13) && !collection.contains(BarcodeFormat.EAN_8) && !collection.contains(BarcodeFormat.CODABAR) && !collection.contains(BarcodeFormat.CODE_39) && !collection.contains(BarcodeFormat.CODE_93) && !collection.contains(BarcodeFormat.CODE_128) && !collection.contains(BarcodeFormat.ITF) && !collection.contains(BarcodeFormat.RSS_14) && !collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                z10 = false;
            }
            if (z10 && !z11) {
                arrayList.add(new i(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new a());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new q8.a());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new b());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new z8.b());
            }
            if (collection.contains(BarcodeFormat.MAXICODE)) {
                arrayList.add(new t8.a());
            }
            if (z10 && z11) {
                arrayList.add(new i(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z11) {
                arrayList.add(new i(map));
            }
            arrayList.add(new a());
            arrayList.add(new q8.a());
            arrayList.add(new b());
            arrayList.add(new z8.b());
            arrayList.add(new t8.a());
            if (z11) {
                arrayList.add(new i(map));
            }
        }
        this.f13436b = (g[]) arrayList.toArray(new g[arrayList.size()]);
    }
}
