package com.huawei.hms.framework.network.grs;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, d> f13960a = new ConcurrentHashMap(16);

    /* renamed from: b  reason: collision with root package name */
    private static final Object f13961b = new Object();

    public static d a(GrsBaseInfo grsBaseInfo, Context context) {
        synchronized (f13961b) {
            int uniqueCode = grsBaseInfo.uniqueCode();
            Map<String, d> map = f13960a;
            d dVar = map.get(context.getPackageName() + uniqueCode);
            if (dVar == null) {
                d dVar2 = new d(context, grsBaseInfo);
                Map<String, d> map2 = f13960a;
                map2.put(context.getPackageName() + uniqueCode, dVar2);
                return dVar2;
            } else if (dVar.a((Object) new d(grsBaseInfo))) {
                return dVar;
            } else {
                d dVar3 = new d(context, grsBaseInfo);
                Map<String, d> map3 = f13960a;
                map3.put(context.getPackageName() + uniqueCode, dVar3);
                return dVar3;
            }
        }
    }
}
