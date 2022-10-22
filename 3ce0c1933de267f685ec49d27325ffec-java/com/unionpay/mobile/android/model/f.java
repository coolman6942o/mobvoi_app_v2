package com.unionpay.mobile.android.model;

import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, Object> f23551a = new HashMap<>();

    public final JSONObject a(String str) {
        Object obj = this.f23551a.get(str);
        if (obj == null || !(obj instanceof JSONObject)) {
            return null;
        }
        return (JSONObject) obj;
    }

    public final void a(String str, Object obj) {
        this.f23551a.put(str, obj);
    }
}
