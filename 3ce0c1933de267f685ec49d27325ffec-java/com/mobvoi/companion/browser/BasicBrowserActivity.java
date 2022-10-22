package com.mobvoi.companion.browser;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.core.content.FileProvider;
import ce.e;
import ce.f;
import ce.g;
import ce.h;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.m;
import com.mobvoi.companion.browser.BasicBrowserActivity;
import com.mobvoi.companion.utils.TicwearFileProvider;
import com.mobvoi.wear.util.TelephonyUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class BasicBrowserActivity extends com.mobvoi.companion.base.m3.d {
    public static final String ACTION = "com.mobvoi.companion.action.BBS";
    private static final int CAMERA_REQUEST_CODE = 101;
    public static final int DEFAULT_DELAYED_MILLIS = 120000;
    private static final int GALLERY_REQUEST_CODE = 102;
    public static final String KEY_ADD_WWID_COOKIE = "add_wwid_cookie";
    public static final String KEY_EXTRA_SHARE_URL = "key_extra_share_url";
    public static final String KEY_FLAG_GOBACK = "can_goback";
    public static final String KEY_MULTIPLE_WINDOWS = "multiple_windows";
    public static final String KEY_NO_COOKIE = "no_cookie";
    public static final String KEY_SHOW_SHARE = "key_show_share";
    public static final String KEY_TITLE = "key_title";
    public static final String KEY_URL = "url";
    private static final String MOBVOI_JS_BRIDGE = "MobvoiJSBridge";
    private static final String TAG = "BrowserActivity";
    private String mCameraFilePath;
    private boolean mCanGoBack;
    private FrameLayout mContainer;
    private ProgressBar mProgressBar;
    private String mShareUrl;
    private boolean mShowShare;
    private String mTitle;
    private ValueCallback<Uri> mUploadMessage;
    private ValueCallback<Uri[]> mUploadMessageAboveL;
    private WebView mWebView;
    private HashMap<String, String> mUrlTitleMaps = new HashMap<>();
    private boolean mIsResume = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements DownloadListener {
        a() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            BasicBrowserActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public class b {
        private static final String TAG = "MobvoiJSBridge";

        /* loaded from: classes2.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f16650a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f16651b;

            a(String str, String str2) {
                this.f16650a = str;
                this.f16651b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(BasicBrowserActivity.this.mShareUrl)) {
                    BasicBrowserActivity basicBrowserActivity = BasicBrowserActivity.this;
                    ic.b.d(basicBrowserActivity, basicBrowserActivity.mWebView.getUrl(), this.f16650a, this.f16651b, ce.d.f5760h);
                    return;
                }
                BasicBrowserActivity basicBrowserActivity2 = BasicBrowserActivity.this;
                ic.b.d(basicBrowserActivity2, basicBrowserActivity2.mShareUrl, this.f16650a, this.f16651b, ce.d.f5760h);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public b() {
        }

        @JavascriptInterface
        public void closeWindow() {
            BasicBrowserActivity.this.finish();
        }

        @JavascriptInterface
        public void fitOauthCallback(String str) {
            if (!TextUtils.isEmpty(str)) {
                Intent intent = new Intent();
                intent.putExtra(TelephonyUtil.KEY_SIM_ACTIVITIED_SOURCE, str);
                k.a(TAG, "fitness auth success " + str);
                BasicBrowserActivity.this.setResult(16, intent);
                BasicBrowserActivity.this.finish();
            }
        }

        @JavascriptInterface
        public void gFitOauthCallback() {
            BasicBrowserActivity.this.finish();
        }

        @JavascriptInterface
        public void invokeShare(String str, String str2, String str3) {
            k.a(TAG, "invokeShare");
            BasicBrowserActivity.this.runOnUiThread(new a(str, str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c extends WebChromeClient {

        /* renamed from: a  reason: collision with root package name */
        protected WeakReference<BasicBrowserActivity> f16653a;

        public c(BasicBrowserActivity basicBrowserActivity) {
            this.f16653a = new WeakReference<>(basicBrowserActivity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(BasicBrowserActivity basicBrowserActivity, DialogInterface dialogInterface, int i10) {
            if (i10 == 0) {
                basicBrowserActivity.startCameraCapture();
            } else {
                lb.c.e(basicBrowserActivity, 102);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(BasicBrowserActivity basicBrowserActivity, DialogInterface dialogInterface) {
            if (basicBrowserActivity.mUploadMessage != null) {
                basicBrowserActivity.mUploadMessage.onReceiveValue(null);
            }
            if (basicBrowserActivity.mUploadMessageAboveL != null) {
                basicBrowserActivity.mUploadMessageAboveL.onReceiveValue(null);
            }
            basicBrowserActivity.mUploadMessage = null;
            basicBrowserActivity.mUploadMessageAboveL = null;
        }

        private void e() {
            final BasicBrowserActivity basicBrowserActivity = this.f16653a.get();
            if (basicBrowserActivity != null) {
                new k7.b(basicBrowserActivity).B(new String[]{basicBrowserActivity.getString(h.f5842e), basicBrowserActivity.getString(h.f5846g)}, new DialogInterface.OnClickListener() { // from class: com.mobvoi.companion.browser.b
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        BasicBrowserActivity.c.c(BasicBrowserActivity.this, dialogInterface, i10);
                    }
                }).F(new DialogInterface.OnCancelListener() { // from class: com.mobvoi.companion.browser.a
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        BasicBrowserActivity.c.d(BasicBrowserActivity.this, dialogInterface);
                    }
                }).a().show();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z10, boolean z11, Message message) {
            BasicBrowserActivity basicBrowserActivity = this.f16653a.get();
            if (basicBrowserActivity == null) {
                return super.onCreateWindow(webView, z10, z11, message);
            }
            if (!basicBrowserActivity.mIsResume) {
                return true;
            }
            com.mobvoi.companion.browser.c.r0(message).p0(basicBrowserActivity.getSupportFragmentManager(), "");
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            super.onProgressChanged(webView, i10);
            BasicBrowserActivity basicBrowserActivity = this.f16653a.get();
            if (basicBrowserActivity != null) {
                basicBrowserActivity.mProgressBar.setProgress(i10);
                basicBrowserActivity.mProgressBar.postInvalidate();
                if (i10 == 100) {
                    basicBrowserActivity.mProgressBar.setVisibility(8);
                } else {
                    basicBrowserActivity.mProgressBar.setVisibility(0);
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            BasicBrowserActivity basicBrowserActivity = this.f16653a.get();
            if (basicBrowserActivity != null) {
                basicBrowserActivity.mUrlTitleMaps.put(webView.getUrl(), str);
                if (TextUtils.isEmpty(basicBrowserActivity.mTitle)) {
                    basicBrowserActivity.setTitle(str);
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(21)
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            BasicBrowserActivity basicBrowserActivity = this.f16653a.get();
            if (basicBrowserActivity == null || basicBrowserActivity.mUploadMessageAboveL != null) {
                return false;
            }
            basicBrowserActivity.mUploadMessageAboveL = valueCallback;
            e();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        protected WeakReference<BasicBrowserActivity> f16654a;

        public d(BasicBrowserActivity basicBrowserActivity) {
            this.f16654a = new WeakReference<>(basicBrowserActivity);
        }

        private String a() {
            return PreferenceManager.getDefaultSharedPreferences(com.mobvoi.android.common.utils.b.e()).getString("ga_user_info_args", "");
        }

        private boolean d(Activity activity, String str) {
            if (activity != null) {
                Intent intent = null;
                try {
                    intent = Intent.parseUri(str, 0);
                } catch (URISyntaxException e10) {
                    k.b(BasicBrowserActivity.TAG, "Error parse intent from url.", e10);
                }
                if (!(intent == null || activity.getPackageManager().resolveActivity(intent, 0) == null)) {
                    activity.startActivity(intent);
                    return true;
                }
            }
            return false;
        }

        public String b(String str) {
            String a10 = a();
            if (TextUtils.isEmpty(a10)) {
                return str;
            }
            if (str.contains("?")) {
                return str + a10;
            }
            String substring = a10.substring(1);
            return str + "?" + substring;
        }

        public boolean c(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.contains("?")) {
                str = str.substring(0, str.indexOf("?"));
            }
            return str.contains("https://store.ticwear.com/products/") || str.equals("https://store.ticwear.com/products") || str.contains("https://store.ticwear.com/types/") || str.equals("https://store.ticwear.com/types") || (str.contains("https://store.ticwear.com/pages/") && !str.contains("login-redirect")) || str.equals("https://store.ticwear.com/pages") || str.equals("https://store.ticwear.com");
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            BasicBrowserActivity basicBrowserActivity = this.f16654a.get();
            if (basicBrowserActivity != null && TextUtils.isEmpty(basicBrowserActivity.mTitle)) {
                String str2 = (String) basicBrowserActivity.mUrlTitleMaps.get(str);
                if (!TextUtils.isEmpty(str2)) {
                    basicBrowserActivity.setTitle(str2);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (c(str)) {
                String b10 = b(str);
                k.c(BasicBrowserActivity.TAG, "shouldOverrideUrlLoading: %s", str);
                webView.loadUrl(b10);
                return true;
            } else if (TextUtils.isEmpty(str) || URLUtil.isNetworkUrl(str)) {
                return false;
            } else {
                return !d(this.f16654a.get(), str);
            }
        }
    }

    private String getDomainFromUrl(String str) {
        try {
            String host = new URL(str).getHost();
            int indexOf = host.indexOf(46);
            return indexOf != -1 ? host.substring(indexOf, host.length()) : host;
        } catch (MalformedURLException e10) {
            k.e(TAG, "Error get domain.", e10);
            return "";
        }
    }

    private Uri getUriForFile(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.e(context, TicwearFileProvider.h(this), file);
        }
        return Uri.fromFile(file);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initView() {
        this.mContainer = (FrameLayout) findViewById(e.f5777h);
        WebView webView = new WebView(this);
        this.mWebView = webView;
        this.mContainer.addView(webView);
        this.mProgressBar = (ProgressBar) findViewById(e.R);
        this.mWebView.requestFocus();
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setVerticalScrollBarEnabled(false);
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDomStorageEnabled(true);
        settings.setSavePassword(false);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        this.mWebView.addJavascriptInterface(createJsBridge(), MOBVOI_JS_BRIDGE);
        this.mWebView.clearCache(true);
        this.mWebView.clearHistory();
        if (m.b(getApplicationContext())) {
            this.mWebView.getSettings().setCacheMode(-1);
        } else {
            this.mWebView.getSettings().setCacheMode(1);
        }
        this.mWebView.setWebViewClient(new d(this));
        this.mWebView.setWebChromeClient(new c(this));
        this.mWebView.setDownloadListener(new a());
        processIntent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCameraCapture() {
        File file = new File(com.mobvoi.android.common.utils.b.h(Environment.DIRECTORY_DCIM), "browser-photos");
        file.mkdirs();
        this.mCameraFilePath = file.getAbsolutePath() + File.separator + System.currentTimeMillis() + ".jpg";
        Uri uriForFile = getUriForFile(this, new File(this.mCameraFilePath));
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.putExtra("output", uriForFile);
        startActivityForResult(intent, 101);
    }

    protected b createJsBridge() {
        return new b();
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return f.f5810d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WebView getWebView() {
        return this.mWebView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(int i10, int i11, Intent intent) {
        Uri uri;
        ValueCallback<Uri> valueCallback;
        super.onActivityResult(i10, i11, intent);
        if (101 == i10) {
            if (this.mUploadMessage != null || this.mUploadMessageAboveL != null) {
                if (-1 == i11) {
                    File file = new File(this.mCameraFilePath);
                    if (file.exists()) {
                        uri = getUriForFile(this, file);
                        valueCallback = this.mUploadMessage;
                        if (valueCallback == null) {
                            valueCallback.onReceiveValue(uri);
                        } else {
                            ValueCallback<Uri[]> valueCallback2 = this.mUploadMessageAboveL;
                            if (valueCallback2 != null) {
                                valueCallback2.onReceiveValue(uri != null ? new Uri[]{uri} : null);
                            }
                        }
                        this.mUploadMessage = null;
                        this.mUploadMessageAboveL = null;
                    }
                }
                uri = null;
                valueCallback = this.mUploadMessage;
                if (valueCallback == null) {
                }
                this.mUploadMessage = null;
                this.mUploadMessageAboveL = null;
            }
        } else if (102 != i10) {
            this.mWebView.reload();
        } else if (this.mUploadMessage != null || this.mUploadMessageAboveL != null) {
            Uri data = (intent == null || i11 != -1) ? null : intent.getData();
            ValueCallback<Uri> valueCallback3 = this.mUploadMessage;
            if (valueCallback3 != null) {
                valueCallback3.onReceiveValue(data);
            } else {
                ValueCallback<Uri[]> valueCallback4 = this.mUploadMessageAboveL;
                if (valueCallback4 != null) {
                    valueCallback4.onReceiveValue(data != null ? new Uri[]{data} : null);
                }
            }
            this.mUploadMessage = null;
            this.mUploadMessageAboveL = null;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.mCanGoBack || !this.mWebView.canGoBack()) {
            super.onBackPressed();
        } else {
            this.mWebView.goBack();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ic.b.a((ic.c) kc.b.b().a(ic.c.class));
        initView();
        e.c();
        va.a.c(getApplication());
        androidx.appcompat.app.f.G(ta.a.o());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!this.mShowShare || com.mobvoi.companion.base.settings.a.isOversea()) {
            return super.onCreateOptionsMenu(menu);
        }
        getMenuInflater().inflate(g.f5833a, menu);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mContainer.removeAllViews();
        this.mWebView.removeAllViews();
        this.mWebView.destroy();
        this.mWebView = null;
        k.a(TAG, "close process after 2 minutes..");
        e.e(DEFAULT_DELAYED_MILLIS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        processIntent();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        } else if (menuItem.getItemId() != e.Z) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            if (this.mShowShare) {
                ic.b.d(this, this.mWebView.getUrl(), getResources().getString(h.f5878x), "", ce.d.f5756d);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mIsResume = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mIsResume = true;
    }

    protected void processIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("url");
            this.mTitle = intent.getStringExtra(KEY_TITLE);
            this.mShareUrl = intent.getStringExtra(KEY_EXTRA_SHARE_URL);
            if (!TextUtils.isEmpty(this.mTitle)) {
                setTitle(this.mTitle);
            }
            this.mCanGoBack = intent.getBooleanExtra(KEY_FLAG_GOBACK, false);
            this.mShowShare = intent.getBooleanExtra(KEY_SHOW_SHARE, false);
            boolean booleanExtra = intent.getBooleanExtra(KEY_NO_COOKIE, false);
            boolean booleanExtra2 = intent.getBooleanExtra(KEY_ADD_WWID_COOKIE, false);
            CookieManager cookieManager = CookieManager.getInstance();
            if (booleanExtra) {
                CookieSyncManager.createInstance(this);
                cookieManager.removeAllCookie();
                CookieSyncManager.getInstance().sync();
            } else if (booleanExtra2) {
                CookieSyncManager.createInstance(this);
                String s10 = ta.a.s();
                String e10 = com.mobvoi.android.common.utils.e.e(this);
                String domainFromUrl = getDomainFromUrl(stringExtra);
                cookieManager.setCookie(domainFromUrl, "ww_token=" + s10);
                cookieManager.setCookie(".ticstore.com", "ww_token=" + s10);
                cookieManager.setCookie(".ticstore.com", "device_id=" + e10);
                cookieManager.setCookie(".chumenwenwen.com", "ww_token=" + s10);
                cookieManager.setCookie(".chumenwenwen.com", "device_id=" + e10);
                cookieManager.setCookie(".ticwear.com", "ww_token=" + s10);
                cookieManager.setCookie(".ticwear.com", "device_id=" + e10);
                cookieManager.setCookie(".mobvoi.com", "ww_token=" + s10);
                cookieManager.setCookie(".mobvoi.com", "device_id=" + e10);
                CookieSyncManager.getInstance().sync();
            }
            this.mWebView.getSettings().setSupportMultipleWindows(intent.getBooleanExtra(KEY_MULTIPLE_WINDOWS, false));
            this.mWebView.loadUrl(stringExtra);
            k.c(TAG, "load url %s", stringExtra);
        }
    }
}
