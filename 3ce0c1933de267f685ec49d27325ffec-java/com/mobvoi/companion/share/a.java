package com.mobvoi.companion.share;

import android.app.Activity;
import com.mobvoi.companion.BuildConfig;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;
import java.util.Map;
/* compiled from: WechatShareUtil.java */
/* loaded from: classes2.dex */
public class a extends ChinaShareUtil {

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, String> f17413c;

    /* renamed from: b  reason: collision with root package name */
    private final IWXAPI f17414b;

    static {
        HashMap hashMap = new HashMap();
        f17413c = hashMap;
        hashMap.put(BuildConfig.LIBRARY_PACKAGE_NAME, "wxae399a44829855e9");
        f17413c.put("com.mobvoi.baiding", "wx4de775c4090faa82");
    }

    public a(Activity activity) {
        super(activity);
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this.f17412a, f17413c.get(activity.getPackageName()), false);
        this.f17414b = createWXAPI;
        createWXAPI.registerApp(f17413c.get(activity.getPackageName()));
    }

    public boolean a() {
        return this.f17414b.isWXAppInstalled();
    }
}
