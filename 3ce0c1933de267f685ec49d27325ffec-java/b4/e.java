package b4;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class e extends LinearLayout {

    /* renamed from: l  reason: collision with root package name */
    public static Handler f5019l = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public ImageView f5020a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f5021b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f5022c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f5023d;

    /* renamed from: e  reason: collision with root package name */
    public WebView f5024e;

    /* renamed from: f  reason: collision with root package name */
    public final C0069e f5025f;

    /* renamed from: g  reason: collision with root package name */
    public f f5026g;

    /* renamed from: h  reason: collision with root package name */
    public g f5027h;

    /* renamed from: i  reason: collision with root package name */
    public h f5028i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f5029j;

    /* renamed from: k  reason: collision with root package name */
    public final float f5030k;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: b4.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0068a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View f5032a;

            public RunnableC0068a(a aVar, View view) {
                this.f5032a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f5032a.setEnabled(true);
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar = e.this.f5028i;
            if (hVar != null) {
                view.setEnabled(false);
                e.f5019l.postDelayed(new RunnableC0068a(this, view), 256L);
                if (view == e.this.f5020a) {
                    hVar.g(e.this);
                } else if (view == e.this.f5022c) {
                    hVar.i(e.this);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements DownloadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f5033a;

        public b(e eVar, Context context) {
            this.f5033a = context;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                this.f5033a.startActivity(intent);
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends WebChromeClient {
        public c() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return e.this.f5026g.e(e.this, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            if (!e.this.f5025f.f5037b) {
                e.this.f5023d.setVisibility(8);
            } else if (i10 > 90) {
                e.this.f5023d.setVisibility(4);
            } else {
                if (e.this.f5023d.getVisibility() == 4) {
                    e.this.f5023d.setVisibility(0);
                }
                e.this.f5023d.setProgress(i10);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            e.this.f5026g.c(e.this, str);
        }
    }

    /* loaded from: classes.dex */
    public class d extends WebViewClient {
        public d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (!e.this.f5027h.b(e.this, str)) {
                super.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (!e.this.f5027h.d(e.this, str)) {
                super.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            if (!e.this.f5027h.a(e.this, i10, str, str2)) {
                super.onReceivedError(webView, i10, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (!e.this.f5027h.f(e.this, sslErrorHandler, sslError)) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!e.this.f5027h.h(e.this, str)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return true;
        }
    }

    /* renamed from: b4.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0069e {

        /* renamed from: a  reason: collision with root package name */
        public boolean f5036a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5037b;

        public C0069e(boolean z10, boolean z11) {
            this.f5036a = z10;
            this.f5037b = z11;
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void c(e eVar, String str);

        boolean e(e eVar, String str, String str2, String str3, JsPromptResult jsPromptResult);
    }

    /* loaded from: classes.dex */
    public interface g {
        boolean a(e eVar, int i10, String str, String str2);

        boolean b(e eVar, String str);

        boolean d(e eVar, String str);

        boolean f(e eVar, SslErrorHandler sslErrorHandler, SslError sslError);

        boolean h(e eVar, String str);
    }

    /* loaded from: classes.dex */
    public interface h {
        void g(e eVar);

        void i(e eVar);
    }

    public e(Context context, y3.a aVar, C0069e eVar) {
        this(context, null, aVar, eVar);
    }

    private int a(int i10) {
        return (int) (i10 * this.f5030k);
    }

    private void d(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(-218103809);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setVisibility(this.f5025f.f5036a ? 0 : 8);
        ImageView imageView = new ImageView(context);
        this.f5020a = imageView;
        imageView.setOnClickListener(this.f5029j);
        this.f5020a.setScaleType(ImageView.ScaleType.CENTER);
        this.f5020a.setImageDrawable(a4.g.a("iVBORw0KGgoAAAANSUhEUgAAAEgAAABIBAMAAACnw650AAAAFVBMVEUAAAARjusRkOkQjuoRkeoRj+oQjunya570AAAABnRSTlMAinWeSkk7CjRNAAAAZElEQVRIx+3MOw6AIBQF0YsrMDGx1obaLeGH/S9BQgkJ82rypp4ceTN1ilvyKizmZIAyU7FML0JVYig55BBAfQ2EU4V4CpZJ+2AiSj11C6rUoTannBpRn4W6xNQjLBSI2+TN0w/+3HT2wPClrQAAAABJRU5ErkJggg==", context));
        this.f5020a.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.f5020a, new LinearLayout.LayoutParams(-2, -2));
        View view = new View(context);
        view.setBackgroundColor(-2500135);
        linearLayout.addView(view, new LinearLayout.LayoutParams(a(1), a(25)));
        TextView textView = new TextView(context);
        this.f5021b = textView;
        textView.setTextColor(-15658735);
        this.f5021b.setTextSize(17.0f);
        this.f5021b.setMaxLines(1);
        this.f5021b.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(a(17), 0, 0, 0);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.f5021b, layoutParams);
        ImageView imageView2 = new ImageView(context);
        this.f5022c = imageView2;
        imageView2.setOnClickListener(this.f5029j);
        this.f5022c.setScaleType(ImageView.ScaleType.CENTER);
        this.f5022c.setImageDrawable(a4.g.a("iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAMAAABiM0N1AAAAmVBMVEUAAAARj+oQjuoRkOsVk/AQj+oRjuoQj+oSkO3///8Rj+kRj+oQkOsTk+whm/8Qj+oRj+oQj+oSkus2p/8QjuoQj+oQj+oQj+oQj+oRj+oTkuwRj+oQj+oRj+oRj+oSkOsSkO0ZlfMbk+8XnPgQj+oRj+oQj+oQj+sSj+sRkOoSkescqv8Rj+oQj+oSj+sXku4Rj+kQjuoQjumXGBCVAAAAMnRSTlMAxPtPF8ry7CoB9npbGwe6lm0wBODazb1+aSejm5GEYjcTDwvls6uJc0g/CdWfRCF20AXrk5QAAAJqSURBVFjD7ZfXmpswEIUFphmDCxi3talurGvm/R8uYSDe5FNBwlzsxf6XmvFBmiaZ/PCdWDk9CWn61OhHCMAaXfoRAth7wx6EkMXnWyrho4yg4bDpquI8Jy78Q7eoj9cmUFijsaLM0JsD9CD0uQAa9aNdPuCFvbA7B9t/Becap8Pu6Q/2jcyH81VHc/WCHDQZXwbvtUhQ61iDlqadncU6Rp31yGkZIzOAu7AjtPpYGREzq/pY5DRFHS1siyO6HfkOKTrMjdb2qevV4zosK7MbkFY2LmYk55hL6juCIFWMOI2KGzblmho3b18EIbxL1hs6r5m2Q2WaEElwS3NW4xh6ZZJuzTtUsBKT4G0h35s4y1mNgkNoS6TZ8SKBXTZQGBNYdPTozXGYKoyLAmOasttjThT4xT6Ch+2qIjRhV9Ja3NC87Kyo5We1vCNEMW1T+j1VLZ9UhE54Q1DL52r5piJ0YxdegvWlHOwTu76uKkJX+MOTHno4YFSEbHYdhViojsLrCTg/MKnhKWaEYzvkZFM8aOkPH7iTSvoFZKD7jGEJbarkRaxQyOeWvGVIbsji152jK7TbDgRzcIuz7SGj89BFU8d30TqWeDtrILxyTkD1IXfvmHseuU3lVHDz607bw0f3xDqejm5ncd0j8VDwfoibRy8RcgTkWHBvocbDbMlJsQAkGnAOHwGy90kLmQY1Wkob07/GaCNRIzdoWK7/+6y/XkLDJCcynOGFuUrKIMuCMonNr9VpSOQoIxBgJ0SacGbzZNy4ICrkscvU2fpElYz+U3sd+aQThjfVmjNa5i15kLcojM3Gz8kP34jf4VaV3X55gNEAAAAASUVORK5CYII=", context));
        this.f5022c.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.f5022c, new LinearLayout.LayoutParams(-2, -2));
        addView(linearLayout, new LinearLayout.LayoutParams(-1, a(48)));
    }

    private void j(Context context) {
        ProgressBar progressBar = new ProgressBar(context, null, 16973855);
        this.f5023d = progressBar;
        progressBar.setProgressDrawable(context.getResources().getDrawable(17301612));
        this.f5023d.setMax(100);
        this.f5023d.setBackgroundColor(-218103809);
        addView(this.f5023d, new LinearLayout.LayoutParams(-1, a(2)));
    }

    private void l(Context context) {
        WebView webView = new WebView(context);
        this.f5024e = webView;
        webView.setVerticalScrollbarOverlay(true);
        e(this.f5024e, context);
        WebSettings settings = this.f5024e.getSettings();
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setSupportMultipleWindows(true);
        settings.setUseWideViewPort(true);
        settings.setAppCacheMaxSize(5242880L);
        settings.setAppCachePath(context.getCacheDir().getAbsolutePath());
        settings.setAllowFileAccess(false);
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        settings.setAppCacheEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setAllowContentAccess(false);
        this.f5024e.setVerticalScrollbarOverlay(true);
        this.f5024e.setDownloadListener(new b(this, context));
        try {
            try {
                this.f5024e.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f5024e.removeJavascriptInterface("accessibility");
                this.f5024e.removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable unused) {
            }
        } catch (Exception unused2) {
            Method method = this.f5024e.getClass().getMethod("removeJavascriptInterface", new Class[0]);
            if (method != null) {
                method.invoke(this.f5024e, "searchBoxJavaBridge_");
                method.invoke(this.f5024e, "accessibility");
                method.invoke(this.f5024e, "accessibilityTraversal");
            }
        }
        b4.c.j(this.f5024e);
        addView(this.f5024e, new LinearLayout.LayoutParams(-1, -1));
    }

    public void c() {
        removeAllViews();
        this.f5024e.removeAllViews();
        this.f5024e.setWebViewClient(null);
        this.f5024e.setWebChromeClient(null);
        this.f5024e.destroy();
    }

    public void e(WebView webView, Context context) {
        String userAgentString = webView.getSettings().getUserAgentString();
        WebSettings settings = webView.getSettings();
        settings.setUserAgentString(userAgentString + com.alipay.sdk.util.b.Q(context));
    }

    public void f(String str) {
        this.f5024e.loadUrl(str);
        b4.c.j(this.f5024e);
    }

    public void g(String str, byte[] bArr) {
        this.f5024e.postUrl(str, bArr);
    }

    public ImageView getBackButton() {
        return this.f5020a;
    }

    public ProgressBar getProgressbar() {
        return this.f5023d;
    }

    public ImageView getRefreshButton() {
        return this.f5022c;
    }

    public TextView getTitle() {
        return this.f5021b;
    }

    public String getUrl() {
        return this.f5024e.getUrl();
    }

    public WebView getWebView() {
        return this.f5024e;
    }

    public void setChromeProxy(f fVar) {
        this.f5026g = fVar;
        if (fVar == null) {
            this.f5024e.setWebChromeClient(null);
        } else {
            this.f5024e.setWebChromeClient(new c());
        }
    }

    public void setWebClientProxy(g gVar) {
        this.f5027h = gVar;
        if (gVar == null) {
            this.f5024e.setWebViewClient(null);
        } else {
            this.f5024e.setWebViewClient(new d());
        }
    }

    public void setWebEventProxy(h hVar) {
        this.f5028i = hVar;
    }

    public e(Context context, AttributeSet attributeSet, y3.a aVar, C0069e eVar) {
        super(context, attributeSet);
        this.f5029j = new a();
        this.f5025f = eVar == null ? new C0069e(false, false) : eVar;
        this.f5030k = context.getResources().getDisplayMetrics().density;
        setOrientation(1);
        d(context);
        j(context);
        l(context);
    }
}
