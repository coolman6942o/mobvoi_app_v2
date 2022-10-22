package com.tendcloud.tenddata;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
/* compiled from: td */
/* loaded from: classes2.dex */
public final class ai {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f22609a = new HashMap();

    public ai a(String str, String str2) {
        this.f22609a.put(str, str2);
        return this;
    }

    public String toString() {
        return this.f22609a.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HttpURLConnection httpURLConnection) {
        try {
            if (u.a(14) && u.b(19)) {
                this.f22609a.put("Connection", "close");
            }
            for (String str : this.f22609a.keySet()) {
                httpURLConnection.setRequestProperty(str, this.f22609a.get(str));
            }
        } catch (Throwable unused) {
        }
    }
}
