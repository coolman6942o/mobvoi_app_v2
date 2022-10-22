package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.local.model.a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, b> f13848a = new ConcurrentHashMap(16);

    /* renamed from: b  reason: collision with root package name */
    private a f13849b;

    public b(Context context, GrsBaseInfo grsBaseInfo) {
        a(context);
        Map<String, b> map = f13848a;
        map.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
    }

    public static b a(String str, GrsBaseInfo grsBaseInfo) {
        Map<String, b> map = f13848a;
        return map.get(str + grsBaseInfo.uniqueCode());
    }

    public a a() {
        return this.f13849b.a();
    }

    public String a(Context context, com.huawei.hms.framework.network.grs.a.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z10) {
        return this.f13849b.a(context, aVar, grsBaseInfo, str, str2, z10);
    }

    public Map<String, String> a(Context context, com.huawei.hms.framework.network.grs.a.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z10) {
        return this.f13849b.a(context, aVar, grsBaseInfo, str, z10);
    }

    public void a(Context context) {
        d dVar = new d(context);
        this.f13849b = dVar;
        if (!dVar.b()) {
            this.f13849b = new c(context);
        }
    }

    public void a(GrsBaseInfo grsBaseInfo) {
        this.f13849b.a(grsBaseInfo);
    }
}
