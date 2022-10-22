package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import o3.b;
/* loaded from: classes.dex */
public class APayEntranceActivity extends Activity {

    /* renamed from: c  reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f6853c = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public String f6854a;

    /* renamed from: b  reason: collision with root package name */
    public String f6855b;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str);
    }

    @Override // android.app.Activity
    public void finish() {
        a remove;
        String str = this.f6855b;
        if (TextUtils.isEmpty(this.f6854a)) {
            this.f6854a = b.a();
        }
        if (!(str == null || (remove = f6853c.remove(str)) == null)) {
            remove.a(this.f6854a);
        }
        try {
            super.finish();
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1000) {
            try {
                if (intent != null) {
                    this.f6854a = intent.getStringExtra("result");
                } else {
                    this.f6854a = b.a();
                }
            } catch (Throwable unused) {
                this.f6854a = b.a();
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            String string = extras.getString("ap_order_info");
            String string2 = extras.getString("ap_target_packagename");
            this.f6855b = extras.getString("ap_session");
            String string3 = extras.getString("ap_local_info", "{}");
            Intent intent = new Intent();
            intent.putExtra("order_info", string);
            intent.putExtra("localInfo", string3);
            intent.setClassName(string2, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            try {
                startActivityForResult(intent, 1000);
            } catch (Throwable unused) {
                finish();
            }
        } catch (Throwable unused2) {
            finish();
        }
    }
}
