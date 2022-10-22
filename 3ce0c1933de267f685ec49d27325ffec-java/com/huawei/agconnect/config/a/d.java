package com.huawei.agconnect.config.a;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f13494a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(InputStream inputStream) {
        this.f13494a = a(inputStream);
    }

    private JSONObject a(InputStream inputStream) {
        String str;
        if (inputStream != null) {
            try {
                return new JSONObject(h.a(inputStream, "UTF-8"));
            } catch (IOException unused) {
                str = "IOException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            } catch (JSONException unused2) {
                str = "JSONException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            }
        }
        return new JSONObject();
    }

    @Override // com.huawei.agconnect.config.a.b
    public String a(String str, String str2) {
        if (str.endsWith("/")) {
            return str2;
        }
        String[] split = str.split("/");
        try {
            JSONObject jSONObject = this.f13494a;
            for (int i10 = 1; i10 < split.length; i10++) {
                if (i10 == split.length - 1) {
                    str = jSONObject.get(split[i10]).toString();
                    return str;
                }
                jSONObject = jSONObject.getJSONObject(split[i10]);
            }
        } catch (JSONException unused) {
            Log.w("InputStreamReader", "JSONException when reading 'path': " + str);
        }
        return str2;
    }
}
