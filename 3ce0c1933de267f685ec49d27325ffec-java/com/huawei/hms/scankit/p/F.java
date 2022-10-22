package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
/* compiled from: MultiFormatOneDReader.java */
/* loaded from: classes2.dex */
public final class F extends H {

    /* renamed from: a  reason: collision with root package name */
    private static final H[] f14514a = new H[0];

    /* renamed from: b  reason: collision with root package name */
    private final H[] f14515b;

    public F(Map<EnumC0553d, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(EnumC0553d.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new G(map));
            }
            if (collection.contains(BarcodeFormat.CODE_39)) {
                arrayList.add(new A(false));
            }
            if (collection.contains(BarcodeFormat.CODE_93)) {
                arrayList.add(new B());
            }
            if (collection.contains(BarcodeFormat.CODE_128)) {
                arrayList.add(new C0646z());
            }
            if (collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new E());
            }
            if (collection.contains(BarcodeFormat.CODABAR)) {
                arrayList.add(new C0643y());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new G(map));
            arrayList.add(new A());
            arrayList.add(new C0643y());
            arrayList.add(new B());
            arrayList.add(new C0646z());
            arrayList.add(new E());
        }
        this.f14515b = (H[]) arrayList.toArray(f14514a);
    }

    @Override // com.huawei.hms.scankit.p.H
    public x a(int i10, C0591h hVar, Map<EnumC0553d, ?> map) throws C0550a {
        for (H h10 : this.f14515b) {
            try {
                return h10.a(i10, hVar, map);
            } catch (C0550a unused) {
            }
        }
        throw C0550a.a();
    }
}
