package com.tendcloud.tenddata;

import com.mobvoi.wear.util.TelephonyUtil;
import com.tendcloud.tenddata.zz;
import java.util.HashMap;
import java.util.Map;
/* compiled from: td */
/* loaded from: classes2.dex */
public class bc {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bc f22722a;

    static {
        try {
            v.a().register(a());
        } catch (Throwable unused) {
        }
    }

    private bc() {
    }

    public static bc a() {
        if (f22722a == null) {
            synchronized (bc.class) {
                if (f22722a == null) {
                    f22722a = new bc();
                }
            }
        }
        return f22722a;
    }

    public final void onTDEBEventIndustry(zz.a aVar) {
        if (aVar != null) {
            try {
                HashMap<String, Object> hashMap = aVar.paraMap;
                if (hashMap != null && Integer.parseInt(String.valueOf(hashMap.get("apiType"))) == 17) {
                    bi biVar = new bi();
                    Object obj = aVar.paraMap.get("data");
                    a aVar2 = (a) aVar.paraMap.get("service");
                    biVar.f22732b = String.valueOf(aVar.paraMap.get("domain"));
                    biVar.f22733c = String.valueOf(aVar.paraMap.get(TelephonyUtil.KEY_SIM_ACTION));
                    if (obj instanceof Map) {
                        biVar.f22734d = (Map) obj;
                    }
                    biVar.f22731a = aVar2;
                    v.a().post(biVar);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
