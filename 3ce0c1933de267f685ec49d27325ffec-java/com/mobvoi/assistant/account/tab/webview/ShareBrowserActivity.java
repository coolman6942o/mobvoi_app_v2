package com.mobvoi.assistant.account.tab.webview;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import androidx.appcompat.app.c;
import cb.a;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.unionpay.tsmservice.data.Constant;
import hc.e;
import java.util.Locale;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.u;
import mb.g;
import org.json.JSONObject;
/* compiled from: ShareBrowserActivity.kt */
/* loaded from: classes2.dex */
public final class ShareBrowserActivity extends OverseaBrowserActivity {

    /* renamed from: g  reason: collision with root package name */
    private boolean f15661g;

    /* renamed from: i  reason: collision with root package name */
    private final io.d f15663i;

    /* renamed from: j  reason: collision with root package name */
    private final io.d f15664j;

    /* renamed from: f  reason: collision with root package name */
    private final String f15660f = "MobvoiJSBridge";

    /* renamed from: h  reason: collision with root package name */
    private final String[] f15662h = {"android.permission.WRITE_EXTERNAL_STORAGE"};

    /* compiled from: ShareBrowserActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: ShareBrowserActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f15665a = "MobvoiJSBridge";

        @JavascriptInterface
        public final void getUserDataBayKey(String packageName) {
            i.f(packageName, "packageName");
            k.c(this.f15665a, "getUserDataBayKey packageName = %s", packageName);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pkg", packageName);
            jSONObject.put("hasPaid", false);
            jSONObject.put("category", 0);
            String jSONObject2 = jSONObject.toString();
            i.e(jSONObject2, "wfObj.toString()");
            MessageProxyClient messageProxyClient = MessageProxyClient.getInstance();
            byte[] bytes = jSONObject2.getBytes(kotlin.text.d.f30092a);
            i.e(bytes, "(this as java.lang.String).getBytes(charset)");
            messageProxyClient.sendMessage(WearPath.WatchfaceMarket.SET, bytes);
        }
    }

    /* compiled from: ShareBrowserActivity.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements qo.a<com.google.android.material.bottomsheet.a> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final com.google.android.material.bottomsheet.a invoke() {
            com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(ShareBrowserActivity.this);
            ShareBrowserActivity shareBrowserActivity = ShareBrowserActivity.this;
            aVar.setContentView(shareBrowserActivity.W(), new ViewGroup.LayoutParams(-1, (int) ((shareBrowserActivity.getResources().getDisplayMetrics().widthPixels * 170.0f) / 375)));
            return aVar;
        }
    }

    /* compiled from: ShareBrowserActivity.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements qo.a<View> {
        d() {
            super(0);
        }

        /* renamed from: a */
        public final View invoke() {
            View inflate = View.inflate(ShareBrowserActivity.this, mb.d.e_res_0x7f0e018d, null);
            final ShareBrowserActivity shareBrowserActivity = ShareBrowserActivity.this;
            inflate.findViewById(mb.c.f30624h0).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.assistant.account.tab.webview.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShareBrowserActivity.this.U(view);
                }
            });
            inflate.findViewById(mb.c.f30623g0).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.assistant.account.tab.webview.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShareBrowserActivity.this.T(view);
                }
            });
            return inflate;
        }
    }

    static {
        new a(null);
    }

    public ShareBrowserActivity() {
        io.d a10;
        io.d a11;
        a10 = io.f.a(new c());
        this.f15663i = a10;
        a11 = io.f.a(new d());
        this.f15664j = a11;
    }

    private final b S() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(View view) {
        a.C0081a aVar = cb.a.f5678a;
        FrameLayout mWebContainer = this.f15655c;
        i.e(mWebContainer, "mWebContainer");
        Bitmap a10 = aVar.a(mWebContainer);
        if (a10 != null) {
            new cb.b(this).execute(a10);
        }
        V().dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(View view) {
        if (e.j(this)) {
            X();
        } else {
            Y(this.f15662h, 10);
        }
        V().dismiss();
    }

    private final com.google.android.material.bottomsheet.a V() {
        return (com.google.android.material.bottomsheet.a) this.f15663i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View W() {
        return (View) this.f15664j.getValue();
    }

    private final void X() {
        a.C0081a aVar = cb.a.f5678a;
        FrameLayout mWebContainer = this.f15655c;
        i.e(mWebContainer, "mWebContainer");
        Bitmap a10 = aVar.a(mWebContainer);
        if (a10 != null) {
            aVar.b(this, a10);
        }
    }

    private final void Y(final String[] strArr, final int i10) {
        c.a aVar = new c.a(this);
        aVar.q(g.f30644p);
        aVar.h(g.f30645s);
        aVar.m(g.f30637f, new DialogInterface.OnClickListener() { // from class: com.mobvoi.assistant.account.tab.webview.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                ShareBrowserActivity.Z(ShareBrowserActivity.this, strArr, i10, dialogInterface, i11);
            }
        });
        aVar.j(g.f30635d, com.mobvoi.assistant.account.tab.webview.b.f15669a);
        aVar.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(ShareBrowserActivity this$0, String[] permissions, int i10, DialogInterface dialogInterface, int i11) {
        i.f(this$0, "this$0");
        i.f(permissions, "$permissions");
        if (this$0.shouldShowRequestPermissionRationale(permissions[0])) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", this$0.getPackageName(), null));
            this$0.startActivity(intent);
        } else {
            this$0.requestPermissions(permissions, i10);
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.assistant.account.tab.webview.OverseaBrowserActivity
    public void I() {
        boolean I;
        String str;
        super.I();
        if (this.f15661g) {
            Locale locale = getResources().getConfiguration().locale;
            String mBrowserUrl = this.f15657e;
            i.e(mBrowserUrl, "mBrowserUrl");
            I = u.I(mBrowserUrl, "?", false, 2, null);
            if (I) {
                str = "&wwid=" + ((Object) ta.a.x()) + "&sessionId=" + ((Object) ta.a.s()) + "&language=" + ((Object) locale.getLanguage()) + "&pkg=" + ((Object) getPackageName());
            } else {
                str = "?wwid=" + ((Object) ta.a.x()) + "&sessionId=" + ((Object) ta.a.s()) + "&language=" + ((Object) locale.getLanguage()) + "&pkg=" + ((Object) getPackageName());
            }
            this.f15657e = i.n(this.f15657e, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.assistant.account.tab.webview.OverseaBrowserActivity, com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    @SuppressLint({"JavascriptInterface"})
    public void onCreate(Bundle bundle) {
        Boolean valueOf = bundle == null ? null : Boolean.valueOf(bundle.getBoolean(Constant.KEY_PARAMS));
        this.f15661g = valueOf == null ? getIntent().getBooleanExtra(Constant.KEY_PARAMS, false) : valueOf.booleanValue();
        super.onCreate(bundle);
        this.f15656d.addJavascriptInterface(S(), this.f15660f);
        webViewBack();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        i.f(menu, "menu");
        MenuInflater menuInflater = getMenuInflater();
        i.e(menuInflater, "menuInflater");
        menuInflater.inflate(mb.e.f30630a, menu);
        return true;
    }

    @Override // com.mobvoi.assistant.account.tab.webview.OverseaBrowserActivity, androidx.appcompat.app.d, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyDown(i10, keyEvent);
        }
        finish();
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        i.f(item, "item");
        if (item.getItemId() != mb.c.f30621a0) {
            return super.onOptionsItemSelected(item);
        }
        V().show();
        return true;
    }

    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] permissions, int[] grantResults) {
        i.f(permissions, "permissions");
        i.f(grantResults, "grantResults");
        super.onRequestPermissionsResult(i10, permissions, grantResults);
        if (i10 == 10) {
            if (!(!(grantResults.length == 0)) || grantResults[0] != 0) {
                Y(this.f15662h, 10);
            } else {
                X();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        i.f(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean(Constant.KEY_PARAMS, this.f15661g);
    }
}
