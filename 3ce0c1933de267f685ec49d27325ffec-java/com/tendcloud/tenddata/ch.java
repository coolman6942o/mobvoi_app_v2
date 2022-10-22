package com.tendcloud.tenddata;

import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public abstract class ch {

    /* renamed from: b  reason: collision with root package name */
    protected JSONObject f22803b = new JSONObject();

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, Object obj) {
        if (obj != null) {
            try {
                if (!a(obj)) {
                    this.f22803b.put(str, obj);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public Object b() {
        return this.f22803b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, JSONObject jSONObject) {
        if (str != null) {
            try {
                if (jSONObject.has(str)) {
                    jSONObject.remove(str);
                }
            } catch (Throwable unused) {
            }
        }
    }

    protected boolean a(Object obj) {
        return obj instanceof JSONObject ? ((JSONObject) obj).length() <= 0 : (obj instanceof JSONArray) && ((JSONArray) obj).length() <= 0;
    }
}
