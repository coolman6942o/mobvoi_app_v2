package com.alipay.sdk.app;

import a4.d;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import y3.a;
/* loaded from: classes.dex */
public final class PayResultActivity extends Activity {

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Object> f6872b = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public y3.a f6873a = null;

    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6874a;

        public a(Activity activity) {
            this.f6874a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6874a.finish();
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static volatile String f6875a;

        /* renamed from: b  reason: collision with root package name */
        public static volatile String f6876b;
    }

    public static void a(Activity activity, int i10) {
        new Handler().postDelayed(new a(activity), i10);
    }

    public static void b(Activity activity, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            Intent intent = new Intent();
            try {
                intent.setPackage("hk.alipay.wallet");
                intent.setData(Uri.parse("alipayhk://platformapi/startApp?appId=20000125&schemePaySession=" + URLEncoder.encode(str, "UTF-8") + "&orderSuffix=" + URLEncoder.encode(str2, "UTF-8") + "&packageName=" + URLEncoder.encode(str3, "UTF-8") + "&externalPkgName=" + URLEncoder.encode(str3, "UTF-8")));
            } catch (UnsupportedEncodingException e10) {
                d.d(e10);
            }
            if (activity != null) {
                try {
                    activity.startActivity(intent);
                } catch (Throwable unused) {
                    activity.finish();
                }
            }
        }
    }

    public static void c(String str) {
        b.f6876b = o3.b.a();
        e(f6872b, str);
    }

    public static void d(String str, String str2) {
        b.f6876b = str;
        e(f6872b, str2);
    }

    public static boolean e(HashMap<String, Object> hashMap, String str) {
        Object obj;
        if (hashMap == null || str == null || (obj = hashMap.get(str)) == null) {
            return false;
        }
        synchronized (obj) {
            obj.notifyAll();
        }
        return true;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (!TextUtils.isEmpty(intent.getStringExtra("orderSuffix"))) {
                b.f6875a = intent.getStringExtra("phonecashier.pay.hash");
                String stringExtra = intent.getStringExtra("orderSuffix");
                String stringExtra2 = intent.getStringExtra("externalPkgName");
                y3.a a10 = a.C0536a.a(intent);
                this.f6873a = a10;
                if (a10 == null) {
                    finish();
                }
                b(this, b.f6875a, stringExtra, stringExtra2);
                a(this, 300);
                return;
            }
            if (this.f6873a == null) {
                finish();
            }
            String stringExtra3 = intent.getStringExtra("phonecashier.pay.result");
            int intExtra = intent.getIntExtra("phonecashier.pay.resultOrderHash", 0);
            if (intExtra != 0 && TextUtils.equals(b.f6875a, String.valueOf(intExtra))) {
                if (!TextUtils.isEmpty(stringExtra3)) {
                    d(stringExtra3, b.f6875a);
                } else {
                    c(b.f6875a);
                }
                b.f6875a = "";
                a(this, 300);
                return;
            }
            y3.a aVar = this.f6873a;
            p3.a.h(aVar, "biz", "SchemePayWrongHashEx", "Expected " + b.f6875a + ", got " + intExtra);
            c(b.f6875a);
            a(this, 300);
        } catch (Throwable unused) {
            finish();
        }
    }
}
