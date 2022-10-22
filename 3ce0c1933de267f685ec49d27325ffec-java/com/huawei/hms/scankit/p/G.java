package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
/* compiled from: MultiFormatUPCEANReader.java */
/* loaded from: classes2.dex */
public final class G extends H {

    /* renamed from: a  reason: collision with root package name */
    private final M[] f14531a;

    public G(Map<EnumC0553d, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(EnumC0553d.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new C());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new I());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new D());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new N());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new C());
            arrayList.add(new D());
            arrayList.add(new N());
        }
        this.f14531a = (M[]) arrayList.toArray(new M[arrayList.size()]);
    }

    @Override // com.huawei.hms.scankit.p.H
    public x a(int i10, C0591h hVar, Map<EnumC0553d, ?> map) throws C0550a {
        boolean z10;
        Iterator<int[]> it = M.b(hVar).iterator();
        while (it.hasNext()) {
            int[] next = it.next();
            for (M m10 : this.f14531a) {
                try {
                    x a10 = m10.a(i10, hVar, next, map);
                    boolean z11 = a10.b() == BarcodeFormat.EAN_13 && a10.g().charAt(0) == '0';
                    Collection collection = map == null ? null : (Collection) map.get(EnumC0553d.POSSIBLE_FORMATS);
                    if (collection != null && !collection.contains(BarcodeFormat.UPC_A)) {
                        z10 = false;
                        return (z11 || !z10) ? a10 : new x(a10.g().substring(1), a10.e(), a10.f(), BarcodeFormat.UPC_A);
                    }
                    z10 = true;
                    if (z11) {
                    }
                } catch (C0550a unused) {
                }
            }
        }
        throw C0550a.a();
    }
}
