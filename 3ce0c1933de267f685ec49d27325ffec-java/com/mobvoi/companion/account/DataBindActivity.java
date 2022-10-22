package com.mobvoi.companion.account;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.data.AccountManager;
import com.mobvoi.companion.account.d;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.companion.browser.BasicBrowserActivity;
import com.mobvoi.companion.health.thirdparty.StravaBrowserActivity;
import com.mobvoi.companion.setting.CompanionSetting;
import ee.c;
import ee.e;
import k7.b;
import o.b;
/* loaded from: classes2.dex */
public class DataBindActivity extends d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private GoogleFitBindView f16121a;

    /* renamed from: b  reason: collision with root package name */
    private RkStravaBindView f16122b;

    /* renamed from: c  reason: collision with root package name */
    private RkStravaBindView f16123c;

    /* renamed from: d  reason: collision with root package name */
    private ArtyBindView f16124d;

    /* renamed from: e  reason: collision with root package name */
    private p f16125e;

    /* renamed from: f  reason: collision with root package name */
    private SharedPreferences.OnSharedPreferenceChangeListener f16126f = new a();

    /* loaded from: classes2.dex */
    class a implements SharedPreferences.OnSharedPreferenceChangeListener {
        a() {
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (("strava".equals(str) || "runnkeeper".equals(str) || "google_fit".equals(str)) && !sharedPreferences.getBoolean(str, true)) {
                Toast.makeText(DataBindActivity.this, e.f25905p, 0).show();
            }
        }
    }

    private void O(final Runnable runnable) {
        new b(this).h(e.f25904o).d(true).j(e.f25898i, f.f16133a).m(e.f25899j, new DialogInterface.OnClickListener() { // from class: com.mobvoi.companion.account.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                runnable.run();
            }
        }).a().show();
    }

    private void Q(String str, String str2, String str3) {
        Intent intent;
        try {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(str3));
            startActivity(intent2);
            k.a("DataBindActivity", " open with browser");
        } catch (Exception e10) {
            e10.printStackTrace();
            k.a("DataBindActivity", " open with browser failed , using WebView");
            if ("strava".equals(str)) {
                intent = new Intent(this, StravaBrowserActivity.class);
            } else {
                intent = new Intent(this, BasicBrowserActivity.class);
            }
            intent.putExtra("url", str3);
            intent.putExtra(BasicBrowserActivity.KEY_FLAG_GOBACK, true);
            intent.putExtra(BasicBrowserActivity.KEY_TITLE, str2);
            startActivityForResult(intent, 16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T(DialogInterface dialogInterface, int i10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(Boolean bool) {
        if (bool.booleanValue()) {
            this.f16122b.r();
            this.f16123c.r();
            this.f16121a.r();
            this.f16124d.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W() {
        this.f16125e.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X() {
        this.f16125e.w("runkeeper");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y() {
        this.f16125e.w("strava");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(String str, String str2, Activity activity, String str3) {
        Q(str, str2, str3);
    }

    private void a0() {
        b0(String.format("https://passport.mobvoi.com/oauth2/login/url?session_id=%s&type=google&lang=en-us", ta.a.s()), null, null);
    }

    private void b0(String str, final String str2, final String str3) {
        d.c(this, new b.a().c(-14803426).a(), str, new d.a() { // from class: com.mobvoi.companion.account.i
            @Override // com.mobvoi.companion.account.d.a
            public final void a(Activity activity, String str4) {
                DataBindActivity.this.Z(str2, str3, activity, str4);
            }
        });
    }

    private void c0(String str, String str2) {
        String str3 = AccountManager.h().g().accountId;
        if (!TextUtils.isEmpty(str3)) {
            b0(String.format("http://health.ticwear.com/data/%s/oauth/%s", str, str3), str, str2);
        }
    }

    private void d0() {
        c0("runkeeper", getString(e.f25901l));
    }

    private void e0() {
        c0("strava", getString(e.f25902m));
    }

    protected void S() {
        p pVar = (p) new h0(this).a(p.class);
        this.f16125e = pVar;
        pVar.s().i(this, new x() { // from class: com.mobvoi.companion.account.h
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                DataBindActivity.this.V((Boolean) obj);
            }
        });
        vc.a.d(this, this.f16126f);
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return ee.d.c_res_0x7f0e0162;
    }

    protected void initView() {
        setTitle(e.f25903n);
        GoogleFitBindView googleFitBindView = (GoogleFitBindView) findViewById(c.b_res_0x7f0b02be);
        this.f16121a = googleFitBindView;
        googleFitBindView.b(new View.OnClickListener() { // from class: com.mobvoi.companion.account.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DataBindActivity.this.onClick(view);
            }
        });
        RkStravaBindView rkStravaBindView = (RkStravaBindView) findViewById(c.g_res_0x7f0b06ca);
        this.f16122b = rkStravaBindView;
        rkStravaBindView.b(new View.OnClickListener() { // from class: com.mobvoi.companion.account.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DataBindActivity.this.onClick(view);
            }
        });
        this.f16122b.setBindType("strava");
        RkStravaBindView rkStravaBindView2 = (RkStravaBindView) findViewById(c.d_res_0x7f0b05b6);
        this.f16123c = rkStravaBindView2;
        rkStravaBindView2.b(new View.OnClickListener() { // from class: com.mobvoi.companion.account.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DataBindActivity.this.onClick(view);
            }
        });
        this.f16123c.setBindType("runkeeper");
        ArtyBindView artyBindView = (ArtyBindView) findViewById(c.a_res_0x7f0b00a6);
        this.f16124d = artyBindView;
        artyBindView.b(new View.OnClickListener() { // from class: com.mobvoi.companion.account.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DataBindActivity.this.onClick(view);
            }
        });
        if (CompanionSetting.isArtyEnable()) {
            this.f16124d.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == c.b_res_0x7f0b02be) {
            if (this.f16121a.q()) {
                O(new Runnable() { // from class: com.mobvoi.companion.account.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        DataBindActivity.this.W();
                    }
                });
            } else {
                a0();
            }
        } else if (id2 == c.d_res_0x7f0b05b6) {
            if (this.f16123c.q()) {
                O(new Runnable() { // from class: com.mobvoi.companion.account.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        DataBindActivity.this.X();
                    }
                });
            } else {
                d0();
            }
        } else if (id2 == c.g_res_0x7f0b06ca) {
            if (this.f16122b.q()) {
                O(new Runnable() { // from class: com.mobvoi.companion.account.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        DataBindActivity.this.Y();
                    }
                });
            } else {
                e0();
            }
        } else if (id2 == c.a_res_0x7f0b00a6) {
            Intent intent = new Intent();
            intent.setClass(this, ArtyAuthorizeActivity.class);
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        S();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        vc.a.h(this, this.f16126f);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f16125e.r();
    }
}
