package com.unionpay;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.unionpay.tsmservice.data.Constant;
import com.unionpay.utils.j;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class WebViewJavascriptBridge implements Serializable {
    y _messageHandler;
    Map _messageHandlers = new HashMap();
    Map _responseCallbacks = new HashMap();
    long _uniqueId = 0;
    Activity mContext;
    WebView mWebView;

    public WebViewJavascriptBridge(Activity activity, WebView webView, y yVar) {
        this.mContext = activity;
        this.mWebView = webView;
        this._messageHandler = yVar;
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        this.mWebView.addJavascriptInterface(this, "_WebViewJavascriptBridge");
        this.mWebView.setWebViewClient(new x(this, (byte) 0));
        this.mWebView.setWebChromeClient(new w(this, (byte) 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _callbackJs(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("responseId", str);
        hashMap.put(Constant.KEY_RESPONSE_DATA, str2);
        _dispatchMessage(hashMap);
    }

    private void _dispatchMessage(Map map) {
        String jSONObject = new JSONObject(map).toString();
        j.a("test", "sending:" + jSONObject);
        this.mContext.runOnUiThread(new u(this, String.format("javascript:WebViewJavascriptBridge._handleMessageFromJava('%s');", doubleEscapeString(jSONObject))));
    }

    private void _sendData(String str, z zVar, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("data", str);
        if (zVar != null) {
            StringBuilder sb2 = new StringBuilder("java_cb_");
            long j10 = this._uniqueId + 1;
            this._uniqueId = j10;
            sb2.append(j10);
            String sb3 = sb2.toString();
            this._responseCallbacks.put(sb3, zVar);
            hashMap.put("callbackId", sb3);
        }
        if (str2 != null) {
            hashMap.put("handlerName", str2);
        }
        _dispatchMessage(hashMap);
    }

    public static String convertStreamToString(InputStream inputStream) {
        String str = "";
        try {
            Scanner useDelimiter = new Scanner(inputStream, "UTF-8").useDelimiter("\\A");
            if (useDelimiter.hasNext()) {
                str = useDelimiter.next();
            }
            inputStream.close();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        return str;
    }

    private String doubleEscapeString(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace("\n", "\\n").replace("\r", "\\r").replace("\f", "\\f");
    }

    private void loadWebViewJavascriptBridgeJs(WebView webView) {
        String convertStreamToString = convertStreamToString(getClass().getResourceAsStream("res/webviewjavascriptbridge.js"));
        webView.loadUrl("javascript:" + convertStreamToString);
    }

    @JavascriptInterface
    public void _handleMessageFromJs(String str, String str2, String str3, String str4, String str5) {
        y yVar;
        if (str2 != null) {
            ((z) this._responseCallbacks.get(str2)).a(str3);
            this._responseCallbacks.remove(str2);
            return;
        }
        v vVar = null;
        if (str4 != null) {
            vVar = new v(this, str4);
        }
        if (str5 != null) {
            yVar = (y) this._messageHandlers.get(str5);
            if (yVar == null) {
                j.b("test", "WVJB Warning: No handler for " + str5);
                return;
            }
        } else {
            yVar = this._messageHandler;
        }
        try {
            this.mContext.runOnUiThread(new t(this, yVar, str, vVar));
        } catch (Exception e10) {
            j.b("test", "WebViewJavascriptBridge: WARNING: java handler threw. " + e10.getMessage());
        }
    }

    public void callHandler(String str) {
        callHandler(str, null, null);
    }

    public void callHandler(String str, String str2) {
        callHandler(str, str2, null);
    }

    public void callHandler(String str, String str2, z zVar) {
        _sendData(str2, zVar, str);
    }

    public void registerHandler(String str, y yVar) {
        this._messageHandlers.put(str, yVar);
    }

    public void send(String str) {
        send(str, null);
    }

    public void send(String str, z zVar) {
        _sendData(str, zVar, null);
    }
}
