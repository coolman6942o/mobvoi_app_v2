package com.paypal.android.sdk;

import java.util.List;
import java.util.Map;
import okhttp3.b0;
import okhttp3.v;
import okhttp3.z;
/* loaded from: classes2.dex */
public class e1 implements v {
    @Override // okhttp3.v
    public b0 intercept(v.a aVar) {
        z request = aVar.request();
        for (Map.Entry<String, List<String>> entry : request.f().toMultimap().entrySet()) {
            for (String str : entry.getValue()) {
                entry.getKey();
            }
        }
        return aVar.a(request);
    }
}
