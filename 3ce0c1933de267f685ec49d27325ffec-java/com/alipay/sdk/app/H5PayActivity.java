package com.alipay.sdk.app;

import a4.d;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import b4.c;
import com.alipay.sdk.util.b;
import com.unionpay.tsmservice.data.Constant;
import java.lang.ref.WeakReference;
import y3.a;
/* loaded from: classes.dex */
public class H5PayActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public c f6863a;

    /* renamed from: b  reason: collision with root package name */
    public String f6864b;

    /* renamed from: c  reason: collision with root package name */
    public String f6865c;

    /* renamed from: d  reason: collision with root package name */
    public String f6866d;

    /* renamed from: e  reason: collision with root package name */
    public String f6867e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6868f;

    /* renamed from: g  reason: collision with root package name */
    public String f6869g;

    /* renamed from: h  reason: collision with root package name */
    public WeakReference<a> f6870h;

    private void b() {
        try {
            super.requestWindowFeature(1);
            getWindow().addFlags(8192);
        } catch (Throwable th2) {
            d.d(th2);
        }
    }

    public void a() {
        Object obj = PayTask.f6877h;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        a();
        super.finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1010) {
            o3.c.a((a) b.e(this.f6870h), i10, i11, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        c cVar = this.f6863a;
        if (cVar == null) {
            finish();
        } else if (cVar.l()) {
            cVar.m();
        } else {
            if (!cVar.m()) {
                super.onBackPressed();
            }
            o3.b.c(o3.b.a());
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        b();
        super.onCreate(bundle);
        try {
            a a10 = a.C0536a.a(getIntent());
            if (a10 == null) {
                finish();
                return;
            }
            this.f6870h = new WeakReference<>(a10);
            if (!r3.a.G().D()) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(3);
            }
            try {
                Bundle extras = getIntent().getExtras();
                String string = extras.getString("url", null);
                this.f6864b = string;
                if (!b.H(string)) {
                    finish();
                    return;
                }
                this.f6866d = extras.getString("cookie", null);
                this.f6865c = extras.getString(Constant.KEY_METHOD, null);
                this.f6867e = extras.getString("title", null);
                this.f6869g = extras.getString("version", "v1");
                this.f6868f = extras.getBoolean("backisexit", false);
                try {
                    b4.d dVar = new b4.d(this, a10, this.f6869g);
                    setContentView(dVar);
                    dVar.r(this.f6867e, this.f6865c, this.f6868f);
                    dVar.k(this.f6864b, this.f6866d);
                    dVar.p(this.f6864b);
                    this.f6863a = dVar;
                } catch (Throwable th2) {
                    p3.a.d(a10, "biz", "GetInstalledAppEx", th2);
                    finish();
                }
            } catch (Exception unused) {
                finish();
            }
        } catch (Exception unused2) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.f6863a;
        if (cVar != null) {
            cVar.n();
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i10) {
        try {
            super.setRequestedOrientation(i10);
        } catch (Throwable th2) {
            try {
                p3.a.d((a) b.e(this.f6870h), "biz", "H5PayDataAnalysisError", th2);
            } catch (Throwable unused) {
            }
        }
    }
}
