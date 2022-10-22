package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* compiled from: BarcodeValue.java */
/* loaded from: classes2.dex */
final class P {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Integer, Integer> f14608a = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i10) {
        Integer num = this.f14608a.get(Integer.valueOf(i10));
        if (num == null) {
            num = 0;
        }
        this.f14608a.put(Integer.valueOf(i10), Integer.valueOf(num.intValue() + 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a() {
        ArrayList arrayList = new ArrayList();
        int i10 = -1;
        for (Map.Entry<Integer, Integer> entry : this.f14608a.entrySet()) {
            if (entry.getValue().intValue() > i10) {
                i10 = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == i10) {
                arrayList.add(entry.getKey());
            }
        }
        return C0576da.a(arrayList);
    }
}
