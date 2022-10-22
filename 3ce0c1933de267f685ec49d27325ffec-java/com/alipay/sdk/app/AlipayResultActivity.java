package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import y3.a;
/* loaded from: classes.dex */
public class AlipayResultActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f6856a = new ConcurrentHashMap<>();

    /* loaded from: classes.dex */
    public interface a {
        void a(int i10, String str, String str2);
    }

    private void a(String str, Bundle bundle) {
        a remove = f6856a.remove(str);
        if (remove != null) {
            try {
                remove.a(bundle.getInt("endCode"), bundle.getString("memo"), bundle.getString("result"));
            } finally {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Throwable th2;
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            String stringExtra = intent.getStringExtra("session");
            Bundle bundleExtra = intent.getBundleExtra("result");
            String stringExtra2 = intent.getStringExtra("scene");
            y3.a b10 = a.C0536a.b(stringExtra);
            if (b10 == null) {
                finish();
                return;
            }
            p3.a.c(b10, "biz", "BSPSession", stringExtra + "|" + SystemClock.elapsedRealtime());
            if (TextUtils.equals("mqpSchemePay", stringExtra2)) {
                a(stringExtra, bundleExtra);
                return;
            }
            if ((TextUtils.isEmpty(stringExtra) || bundleExtra == null) && intent.getData() != null) {
                try {
                    JSONObject jSONObject = new JSONObject(new String(Base64.decode(intent.getData().getQuery(), 2), "UTF-8"));
                    JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                    stringExtra = jSONObject.getString("session");
                    p3.a.c(b10, "biz", "BSPUriSession", stringExtra);
                    Bundle bundle2 = new Bundle();
                    try {
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            bundle2.putString(next, jSONObject2.getString(next));
                        }
                        bundleExtra = bundle2;
                    } catch (Throwable th3) {
                        th2 = th3;
                        bundleExtra = bundle2;
                        p3.a.d(b10, "biz", "BSPResEx", th2);
                        p3.a.d(b10, "biz", "ParseSchemeQueryError", th2);
                        if (!TextUtils.isEmpty(stringExtra)) {
                        }
                        p3.a.g(this, b10, "", b10.f36738d);
                        finish();
                        return;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                }
            }
            if (!TextUtils.isEmpty(stringExtra) || bundleExtra == null) {
                p3.a.g(this, b10, "", b10.f36738d);
                finish();
                return;
            }
            p3.a.c(b10, "biz", "PgReturn", "" + SystemClock.elapsedRealtime());
            p3.a.c(b10, "biz", "PgReturnV", bundleExtra.getInt("endCode", -1) + "|" + bundleExtra.getString("memo", "-"));
            OpenAuthTask.a(stringExtra, 9000, "OK", bundleExtra);
            p3.a.g(this, b10, "", b10.f36738d);
            finish();
        } catch (Throwable unused) {
            finish();
        }
    }
}
