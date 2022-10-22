package com.mobvoi.companion.browser;

import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import ce.e;
import ce.f;
import com.mobvoi.android.common.utils.k;
import java.lang.ref.WeakReference;
/* compiled from: BrowserDialogFragment.java */
/* loaded from: classes2.dex */
public class c extends androidx.fragment.app.c {

    /* renamed from: q  reason: collision with root package name */
    private Message f16657q;

    /* renamed from: r  reason: collision with root package name */
    private ProgressBar f16658r;

    /* compiled from: BrowserDialogFragment.java */
    /* loaded from: classes2.dex */
    private static class a extends WebChromeClient {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<c> f16659a;

        a(c cVar) {
            this.f16659a = new WeakReference<>(cVar);
        }

        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
            super.onCloseWindow(webView);
            c cVar = this.f16659a.get();
            if (cVar != null) {
                cVar.c0();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            super.onProgressChanged(webView, i10);
            c cVar = this.f16659a.get();
            if (cVar != null) {
                cVar.f16658r.setProgress(i10);
                cVar.f16658r.postInvalidate();
                if (i10 == 100) {
                    cVar.f16658r.setVisibility(8);
                } else {
                    cVar.f16658r.setVisibility(0);
                }
            }
        }
    }

    /* compiled from: BrowserDialogFragment.java */
    /* loaded from: classes2.dex */
    private static class b extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<c> f16660a;

        b(c cVar) {
            this.f16660a = new WeakReference<>(cVar);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.f16660a.get() != null) {
                k.c("BrowserDialogFragment", "url = %s", str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c r0(Message message) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putParcelable("resultMsg", message);
        cVar.setArguments(bundle);
        return cVar;
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f16657q = (Message) getArguments().getParcelable("resultMsg");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (e0().getWindow() != null) {
            e0().getWindow().requestFeature(1);
        }
        return layoutInflater.inflate(f.f5812f, viewGroup, false);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (e0().getWindow() != null) {
            e0().getWindow().setLayout(-1, -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.f16657q == null) {
            c0();
            return;
        }
        WebView webView = new WebView(getActivity());
        ((FrameLayout) view.findViewById(e.f5777h)).addView(webView);
        this.f16658r = (ProgressBar) view.findViewById(e.R);
        webView.setWebViewClient(new b(this));
        webView.setWebChromeClient(new a(this));
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) this.f16657q.obj;
        if (webViewTransport == null) {
            c0();
            return;
        }
        webViewTransport.setWebView(webView);
        this.f16657q.sendToTarget();
    }
}
