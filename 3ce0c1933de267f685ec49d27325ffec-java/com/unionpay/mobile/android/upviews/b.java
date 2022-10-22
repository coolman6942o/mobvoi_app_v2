package com.unionpay.mobile.android.upviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tendcloud.tenddata.ab;
import java.util.ArrayList;
import java.util.Timer;
/* loaded from: classes2.dex */
public final class b extends WebView implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private WebSettings f23997a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f23998b;

    /* renamed from: c  reason: collision with root package name */
    private a f23999c;

    /* renamed from: d  reason: collision with root package name */
    private Timer f24000d = new Timer();

    /* renamed from: e  reason: collision with root package name */
    private boolean f24001e = false;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<String> f24002f = null;

    /* loaded from: classes2.dex */
    public interface a {
        void r();

        void s();
    }

    /* renamed from: com.unionpay.mobile.android.upviews.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0267b extends a {
        void c(String str);
    }

    /* loaded from: classes2.dex */
    private class c extends WebChromeClient {
        private c() {
        }

        /* synthetic */ c(b bVar, byte b10) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public final void onProgressChanged(WebView webView, int i10) {
            if (i10 == 100) {
                b.this.f23998b.sendEmptyMessage(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d extends WebViewClient {
        private d() {
        }

        /* synthetic */ d(b bVar, byte b10) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            b.this.f24000d.cancel();
            b.this.f24000d.purge();
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            b.this.f24000d = new Timer();
            b.this.f24000d.schedule(new com.unionpay.mobile.android.upviews.c(this), ab.Y);
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, int i10, String str, String str2) {
            b.this.a();
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String str2 = null;
            if (b.this.f24002f != null && b.this.f24002f.size() != 0 && str != null && str.length() > 0) {
                int i10 = 0;
                while (true) {
                    if (b.this.f24002f == null || i10 >= b.this.f24002f.size()) {
                        break;
                    } else if (str.startsWith((String) b.this.f24002f.get(i10))) {
                        str2 = (String) b.this.f24002f.get(i10);
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            if (str2 != null) {
                Message obtainMessage = b.this.f23998b.obtainMessage(4);
                obtainMessage.obj = str;
                b.this.f23998b.sendMessage(obtainMessage);
                return true;
            }
            webView.loadUrl(str);
            return true;
        }
    }

    public b(Context context, a aVar) {
        super(context);
        this.f23997a = null;
        this.f23998b = null;
        this.f23999c = null;
        this.f23998b = new Handler(this);
        this.f23999c = aVar;
        setScrollBarStyle(33554432);
        WebSettings settings = getSettings();
        this.f23997a = settings;
        settings.setJavaScriptEnabled(true);
        setWebChromeClient(new c(this, (byte) 0));
        setWebViewClient(new d(this, (byte) 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        loadData(String.format("<div align=\"center\">%s</div>", "&#x7F51;&#x9875;&#x52A0;&#x8F7D;&#x5931;&#x8D25;&#xFF0C;&#x8BF7;&#x91CD;&#x8BD5;"), "text/html", "utf-8");
    }

    public final void a(String str) {
        if (this.f24002f == null) {
            this.f24002f = new ArrayList<>();
        }
        if (str != null && str.length() > 0) {
            this.f24002f.add(str);
        }
    }

    public final void b(String str) {
        Message obtainMessage = this.f23998b.obtainMessage(0);
        obtainMessage.obj = str;
        this.f23998b.sendMessage(obtainMessage);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        a aVar;
        int i10 = message.what;
        if (i10 != 0) {
            if (!(i10 == 1 || i10 == 2)) {
                if (i10 == 3) {
                    a();
                } else if (i10 == 4 && (aVar = this.f23999c) != null && (aVar instanceof AbstractC0267b)) {
                    ((AbstractC0267b) aVar).c((String) message.obj);
                }
            }
            if (message.what == 1) {
                this.f24001e = true;
            }
            a aVar2 = this.f23999c;
            if (aVar2 != null) {
                aVar2.s();
            }
        } else {
            a aVar3 = this.f23999c;
            if (aVar3 != null) {
                aVar3.r();
            }
            Object obj = message.obj;
            String str = obj != null ? (String) obj : "";
            Log.e("uppay", "url = " + str);
            loadUrl(str);
        }
        return true;
    }
}
