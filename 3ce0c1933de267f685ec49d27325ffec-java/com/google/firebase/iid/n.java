package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
final class n {

    /* renamed from: d  reason: collision with root package name */
    private static final long f12505d = TimeUnit.DAYS.toMillis(7);

    /* renamed from: a  reason: collision with root package name */
    final String f12506a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12507b;

    /* renamed from: c  reason: collision with root package name */
    private final long f12508c;

    private n(String str, String str2, long j10) {
        this.f12506a = str;
        this.f12507b = str2;
        this.f12508c = j10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2, long j10) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j10);
            return jSONObject.toString();
        } catch (JSONException e10) {
            String valueOf = String.valueOf(e10);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 24);
            sb2.append("Failed to encode token: ");
            sb2.append(valueOf);
            Log.w("FirebaseInstanceId", sb2.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new n(str, null, 0L);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new n(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
        } catch (JSONException e10) {
            String valueOf = String.valueOf(e10);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 23);
            sb2.append("Failed to parse token: ");
            sb2.append(valueOf);
            Log.w("FirebaseInstanceId", sb2.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c(String str) {
        return System.currentTimeMillis() > this.f12508c + f12505d || !str.equals(this.f12507b);
    }
}
