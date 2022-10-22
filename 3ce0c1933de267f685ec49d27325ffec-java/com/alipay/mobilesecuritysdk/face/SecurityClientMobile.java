package com.alipay.mobilesecuritysdk.face;

import android.content.Context;
import c4.a;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class SecurityClientMobile {
    public static synchronized String GetApdid(Context context, Map<String, String> map) {
        String a10;
        synchronized (SecurityClientMobile.class) {
            HashMap hashMap = new HashMap();
            hashMap.put("utdid", a.c(map, "utdid", ""));
            hashMap.put("tid", a.c(map, "tid", ""));
            hashMap.put("userId", a.c(map, "userId", ""));
            APSecuritySdk.getInstance(context).initToken(0, hashMap, null);
            a10 = com.alipay.apmobilesecuritysdk.a.a.a(context);
        }
        return a10;
    }
}
