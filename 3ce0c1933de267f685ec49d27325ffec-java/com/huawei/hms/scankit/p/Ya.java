package com.huawei.hms.scankit.p;

import android.os.Bundle;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.scankit.util.a;
/* compiled from: HaLog60002.java */
/* loaded from: classes2.dex */
public final class Ya extends Za {
    public Ya() {
        super(null, DynamicModuleInitializer.getContext());
    }

    public void a(Bundle bundle) {
        if (bundle != null && a()) {
            try {
                if (bundle.containsKey("scanType") && (bundle.get("scanType") instanceof Integer)) {
                    bundle.putString("scanType", Za.a(bundle.getInt("scanType")));
                }
                Xa xa2 = new Xa(this);
                for (String str : bundle.keySet()) {
                    xa2.put(str, String.valueOf(bundle.get(str)));
                }
                C0569bb.a().a("60002", xa2);
            } catch (RuntimeException unused) {
                a.b("HaLog60002", "RuntimeException");
            } catch (Exception unused2) {
                a.b("HaLog60002", "Exception");
            }
        }
    }
}
