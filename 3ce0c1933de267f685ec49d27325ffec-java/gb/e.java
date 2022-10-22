package gb;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import pa.f;
/* compiled from: BrowserDialog.java */
/* loaded from: classes2.dex */
public class e extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private WebView f27320a;

    /* renamed from: b  reason: collision with root package name */
    private ProgressBar f27321b;

    /* renamed from: c  reason: collision with root package name */
    private final String f27322c;

    /* renamed from: d  reason: collision with root package name */
    private final String f27323d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BrowserDialog.java */
    /* loaded from: classes2.dex */
    public class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            e.this.f27321b.setVisibility(4);
        }
    }

    public e(Activity activity, String str, String str2) {
        super(activity);
        this.f27322c = str;
        this.f27323d = str2;
        c();
    }

    private void c() {
        e();
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
            window.setBackgroundDrawable(new ColorDrawable(0));
            setCancelable(true);
            setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        dismiss();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void e() {
        View inflate = View.inflate(getContext(), f.f32677a, null);
        setContentView(inflate);
        ((ImageView) inflate.findViewById(pa.e.f32673y)).setOnClickListener(new View.OnClickListener() { // from class: gb.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.d(view);
            }
        });
        ((TextView) inflate.findViewById(pa.e.f32656p0)).setText(this.f27323d);
        this.f27321b = (ProgressBar) inflate.findViewById(pa.e.Z);
        WebView webView = (WebView) inflate.findViewById(pa.e.f32674y0);
        this.f27320a = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(0);
        this.f27320a.loadUrl(this.f27322c);
        this.f27320a.setWebViewClient(new a());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.f27320a.destroy();
    }
}
