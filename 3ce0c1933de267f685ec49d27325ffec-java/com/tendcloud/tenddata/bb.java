package com.tendcloud.tenddata;

import com.mobvoi.wear.util.TelephonyUtil;
import com.tendcloud.tenddata.bh;
import com.tendcloud.tenddata.zz;
import java.util.HashMap;
import java.util.Map;
/* compiled from: td */
/* loaded from: classes2.dex */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bb f22721a;

    static {
        try {
            v.a().register(a());
        } catch (Throwable unused) {
        }
    }

    private bb() {
    }

    public static bb a() {
        if (f22721a == null) {
            synchronized (bb.class) {
                if (f22721a == null) {
                    f22721a = new bb();
                }
            }
        }
        return f22721a;
    }

    public final void onTDEBEventIAP(zz.a aVar) {
        if (aVar != null) {
            try {
                HashMap<String, Object> hashMap = aVar.paraMap;
                if (hashMap != null && Integer.parseInt(String.valueOf(hashMap.get("apiType"))) == 8) {
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
                    bh bhVar = new bh();
                    bhVar.f22729a = aVar2;
                    bhVar.f22730b = bh.a.IMMEDIATELY;
                    v.a().post(bhVar);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
