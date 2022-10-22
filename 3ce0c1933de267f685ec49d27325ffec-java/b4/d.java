package b4;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.ImageView;
import b4.e;
import com.amap.api.services.core.AMapException;
import com.mobvoi.wear.permission.PermissionConstant;
import com.mobvoi.wear.providers.OtaColumn;
import com.mobvoi.wear.util.TelephonyUtil;
import com.unionpay.tsmservice.data.Constant;
import java.lang.ref.WeakReference;
import java.util.Map;
import o3.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends b4.c implements e.f, e.g, e.h {

    /* renamed from: f  reason: collision with root package name */
    public final y3.a f4999f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5000g;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4996c = true;

    /* renamed from: d  reason: collision with root package name */
    public String f4997d = "GET";

    /* renamed from: e  reason: collision with root package name */
    public boolean f4998e = false;

    /* renamed from: h  reason: collision with root package name */
    public b4.e f5001h = null;

    /* renamed from: i  reason: collision with root package name */
    public b4.f f5002i = new b4.f();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f4994a.finish();
        }
    }

    /* loaded from: classes.dex */
    public class b extends e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b4.e f5004a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(b4.e eVar) {
            super(null);
            this.f5004a = eVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f5004a.c();
            d.this.f4998e = false;
        }
    }

    /* loaded from: classes.dex */
    public class c extends e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b4.e f5006a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5007b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b4.e eVar, String str) {
            super(null);
            this.f5006a = eVar;
            this.f5007b = str;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            d.this.removeView(this.f5006a);
            d.this.f5001h.f(this.f5007b);
            d.this.f4998e = false;
        }
    }

    /* renamed from: b4.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0067d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f5009a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f5010b;

        /* renamed from: b4.d$d$a */
        /* loaded from: classes.dex */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                RunnableC0067d.this.f5010b.cancel();
                p3.a.h(d.this.f4999f, "net", "SSLDenied", "2");
                o3.b.c(o3.b.a());
                RunnableC0067d.this.f5009a.finish();
            }
        }

        public RunnableC0067d(Activity activity, SslErrorHandler sslErrorHandler) {
            this.f5009a = activity;
            this.f5010b = sslErrorHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            b4.b.b(this.f5009a, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，请安装支付宝后重试。", "确定", new a(), null, null);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<b4.e> f5013a;

        /* renamed from: b  reason: collision with root package name */
        public final String f5014b;

        /* renamed from: c  reason: collision with root package name */
        public final String f5015c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f5016d = false;

        public f(b4.e eVar, String str, String str2, JSONObject jSONObject) {
            this.f5013a = new WeakReference<>(eVar);
            this.f5014b = str;
            this.f5015c = str2;
        }

        public static String a(String str) {
            return TextUtils.isEmpty(str) ? "" : str.replace("'", "");
        }

        public void b(JSONObject jSONObject) {
            b4.e eVar;
            if (!this.f5016d && (eVar = (b4.e) com.alipay.sdk.util.b.e(this.f5013a)) != null) {
                this.f5016d = true;
                eVar.f(String.format("javascript:window.AlipayJSBridge.callBackFromNativeFunc('%s','%s');", a(this.f5015c), a(jSONObject.toString())));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class g implements c.a {

        /* renamed from: a  reason: collision with root package name */
        public final f f5017a;

        /* renamed from: b  reason: collision with root package name */
        public final String f5018b;

        public g(f fVar, String str) {
            this.f5017a = fVar;
            this.f5018b = str;
        }

        @Override // o3.c.a
        public void a(boolean z10, JSONObject jSONObject, String str) {
            try {
                this.f5017a.b(new JSONObject().put(Constant.CASH_LOAD_SUCCESS, z10).put("random", this.f5018b).put("code", jSONObject).put(PermissionConstant.Columns.STATUS, str));
            } catch (JSONException unused) {
            }
        }
    }

    public d(Activity activity, y3.a aVar, String str) {
        super(activity, str);
        this.f4999f = aVar;
        A();
    }

    private synchronized boolean A() {
        try {
            b4.e eVar = new b4.e(this.f4994a, this.f4999f, new e.C0069e(!l(), !l()));
            this.f5001h = eVar;
            eVar.setChromeProxy(this);
            this.f5001h.setWebClientProxy(this);
            this.f5001h.setWebEventProxy(this);
            addView(this.f5001h);
        } catch (Exception unused) {
            return false;
        }
        return true;
    }

    private void B() {
        b4.e eVar = this.f5001h;
        if (eVar != null) {
            eVar.getWebView().loadUrl("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
        }
    }

    private synchronized void C() {
        WebView webView = this.f5001h.getWebView();
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            b4.f fVar = this.f5002i;
            if (fVar == null || fVar.c()) {
                s(false);
            } else {
                y();
            }
        }
    }

    private synchronized void q(String str, String str2, String str3) {
        b4.e eVar = this.f5001h;
        if (eVar != null) {
            JSONObject P = com.alipay.sdk.util.b.P(str3);
            f fVar = new f(eVar, str, str2, P);
            Context context = eVar.getContext();
            String str4 = fVar.f5014b;
            char c10 = 65535;
            int i10 = 4;
            switch (str4.hashCode()) {
                case -1785164386:
                    if (str4.equals("canUseTaoLogin")) {
                        c10 = '\b';
                        break;
                    }
                    break;
                case -552487705:
                    if (str4.equals("taoLogin")) {
                        c10 = '\t';
                        break;
                    }
                    break;
                case 3015911:
                    if (str4.equals("back")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 3127582:
                    if (str4.equals("exit")) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 110371416:
                    if (str4.equals("title")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case 1085444827:
                    if (str4.equals("refresh")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 1703426986:
                    if (str4.equals("pushWindow")) {
                        c10 = 6;
                        break;
                    }
                    break;
                case 1906413305:
                    if (str4.equals("backButton")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case 1947723784:
                    if (str4.equals("sdkInfo")) {
                        c10 = 7;
                        break;
                    }
                    break;
                case 2033767917:
                    if (str4.equals("refreshButton")) {
                        c10 = 5;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    if (P.has("title")) {
                        eVar.getTitle().setText(P.optString("title", ""));
                        break;
                    }
                    break;
                case 1:
                    eVar.getWebView().reload();
                    break;
                case 2:
                    C();
                    break;
                case 3:
                    o3.b.c(P.optString("result", null));
                    s(P.optBoolean(Constant.CASH_LOAD_SUCCESS, false));
                    break;
                case 4:
                    boolean optBoolean = P.optBoolean("show", true);
                    ImageView backButton = eVar.getBackButton();
                    if (optBoolean) {
                        i10 = 0;
                    }
                    backButton.setVisibility(i10);
                    break;
                case 5:
                    boolean optBoolean2 = P.optBoolean("show", true);
                    ImageView refreshButton = eVar.getRefreshButton();
                    if (optBoolean2) {
                        i10 = 0;
                    }
                    refreshButton.setVisibility(i10);
                    break;
                case 6:
                    w(P.optString("url"), P.optString("title", ""));
                    break;
                case 7:
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sdk_version", "15.8.02");
                    jSONObject.put("app_name", this.f4999f.g());
                    jSONObject.put("app_version", this.f4999f.j());
                    fVar.b(jSONObject);
                    break;
                case '\b':
                    String url = eVar.getUrl();
                    if (com.alipay.sdk.util.b.t(this.f4999f, url)) {
                        JSONObject jSONObject2 = new JSONObject();
                        boolean c11 = o3.c.c(this.f4999f, context);
                        jSONObject2.put(OtaColumn.COLUMN_ENABLED, c11);
                        p3.a.c(this.f4999f, "biz", "TbChk", String.valueOf(c11));
                        fVar.b(jSONObject2);
                        break;
                    } else {
                        p3.a.h(this.f4999f, "biz", "jsUrlErr", url);
                        break;
                    }
                case '\t':
                    String url2 = eVar.getUrl();
                    if (com.alipay.sdk.util.b.t(this.f4999f, url2)) {
                        String optString = P.optString("random");
                        JSONObject optJSONObject = P.optJSONObject("options");
                        if (!TextUtils.isEmpty("random") && optJSONObject != null) {
                            String optString2 = optJSONObject.optString("url");
                            String optString3 = optJSONObject.optString(TelephonyUtil.KEY_SIM_ACTION);
                            if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && (context instanceof Activity)) {
                                o3.c.b(this.f4999f, (Activity) context, AMapException.CODE_AMAP_IP_QUERY_OVER_LIMIT, optString2, optString3, new g(fVar, optString));
                                break;
                            }
                        }
                    } else {
                        p3.a.h(this.f4999f, "biz", "jsUrlErr", url2);
                        break;
                    }
                    break;
            }
        }
    }

    private synchronized void s(boolean z10) {
        o3.b.d(z10);
        this.f4994a.finish();
    }

    private synchronized void v(String str) {
        Map<String, String> z10 = com.alipay.sdk.util.b.z(this.f4999f, str);
        if (str.startsWith("callNativeFunc")) {
            q(z10.get("func"), z10.get("cbId"), z10.get("data"));
        } else if (str.startsWith("onBack")) {
            C();
        } else if (str.startsWith("setTitle") && z10.containsKey("title")) {
            this.f5001h.getTitle().setText(z10.get("title"));
        } else if (str.startsWith("onRefresh")) {
            this.f5001h.getWebView().reload();
        } else if (str.startsWith("showBackButton") && z10.containsKey("bshow")) {
            this.f5001h.getBackButton().setVisibility(TextUtils.equals("true", z10.get("bshow")) ? 0 : 4);
        } else if (str.startsWith("onExit")) {
            o3.b.c(z10.get("result"));
            s(TextUtils.equals("true", z10.get("bsucc")));
        } else if (str.startsWith("onLoadJs")) {
            this.f5001h.f("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n");
        }
    }

    private synchronized boolean w(String str, String str2) {
        b4.e eVar = this.f5001h;
        try {
            b4.e eVar2 = new b4.e(this.f4994a, this.f4999f, new e.C0069e(!l(), !l()));
            this.f5001h = eVar2;
            eVar2.setChromeProxy(this);
            this.f5001h.setWebClientProxy(this);
            this.f5001h.setWebEventProxy(this);
            if (!TextUtils.isEmpty(str2)) {
                this.f5001h.getTitle().setText(str2);
            }
            this.f4998e = true;
            this.f5002i.b(eVar);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new c(eVar, str));
            this.f5001h.setAnimation(translateAnimation);
            addView(this.f5001h);
        } catch (Throwable unused) {
            return false;
        }
        return true;
    }

    private synchronized boolean y() {
        if (this.f5002i.c()) {
            this.f4994a.finish();
        } else {
            this.f4998e = true;
            b4.e eVar = this.f5001h;
            this.f5001h = this.f5002i.d();
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new b(eVar));
            eVar.setAnimation(translateAnimation);
            removeView(eVar);
            addView(this.f5001h);
        }
        return true;
    }

    private synchronized void z() {
        Activity activity = this.f4994a;
        b4.e eVar = this.f5001h;
        if (!(activity == null || eVar == null)) {
            if (this.f4996c) {
                activity.finish();
            } else {
                eVar.f("javascript:window.AlipayJSBridge.callListener('h5BackAction');");
            }
        }
    }

    @Override // b4.e.g
    public synchronized boolean a(b4.e eVar, int i10, String str, String str2) {
        this.f5000g = true;
        y3.a aVar = this.f4999f;
        p3.a.h(aVar, "net", "SSLError", "onReceivedError:" + str2);
        eVar.getRefreshButton().setVisibility(0);
        return false;
    }

    @Override // b4.e.g
    public synchronized boolean b(b4.e eVar, String str) {
        y3.a aVar = this.f4999f;
        p3.a.c(aVar, "biz", "h5ldd", SystemClock.elapsedRealtime() + "|" + com.alipay.sdk.util.b.R(str));
        B();
        eVar.getRefreshButton().setVisibility(0);
        return true;
    }

    @Override // b4.e.f
    public synchronized void c(b4.e eVar, String str) {
        if (!str.startsWith("http") && !eVar.getUrl().endsWith(str)) {
            this.f5001h.getTitle().setText(str);
        }
    }

    @Override // b4.e.g
    public synchronized boolean d(b4.e eVar, String str) {
        y3.a aVar = this.f4999f;
        p3.a.c(aVar, "biz", "h5ld", SystemClock.elapsedRealtime() + "|" + com.alipay.sdk.util.b.R(str));
        if (!TextUtils.isEmpty(str) && !str.endsWith(".apk")) {
            B();
        }
        return false;
    }

    @Override // b4.e.f
    public synchronized boolean e(b4.e eVar, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str2.startsWith("<head>") && str2.contains("sdk_result_code:")) {
            this.f4994a.runOnUiThread(new a());
        }
        jsPromptResult.cancel();
        return true;
    }

    @Override // b4.e.g
    public synchronized boolean f(b4.e eVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        Activity activity = this.f4994a;
        if (activity == null) {
            return true;
        }
        y3.a aVar = this.f4999f;
        p3.a.h(aVar, "net", "SSLError", "2-" + sslError);
        activity.runOnUiThread(new RunnableC0067d(activity, sslErrorHandler));
        return true;
    }

    @Override // b4.e.h
    public synchronized void g(b4.e eVar) {
        z();
    }

    @Override // b4.e.g
    public synchronized boolean h(b4.e eVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Activity activity = this.f4994a;
        if (activity == null) {
            return true;
        }
        if (com.alipay.sdk.util.b.u(this.f4999f, str, activity)) {
            return true;
        }
        if (str.startsWith("alipayjsbridge://")) {
            v(str.substring(17));
        } else if (TextUtils.equals(str, "sdklite://h5quit")) {
            s(false);
        } else if (str.startsWith("http://") || str.startsWith("https://")) {
            this.f5001h.f(str);
        } else {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            activity.startActivity(intent);
        }
        return true;
    }

    @Override // b4.e.h
    public synchronized void i(b4.e eVar) {
        eVar.getWebView().reload();
        eVar.getRefreshButton().setVisibility(4);
    }

    @Override // b4.c
    public synchronized boolean m() {
        Activity activity = this.f4994a;
        if (activity == null) {
            return true;
        }
        if (l()) {
            b4.e eVar = this.f5001h;
            if (!(eVar == null || eVar.getWebView() == null)) {
                if (!eVar.getWebView().canGoBack()) {
                    o3.b.c(o3.b.a());
                    activity.finish();
                } else if (x()) {
                    com.alipay.sdk.app.c b10 = com.alipay.sdk.app.c.b(com.alipay.sdk.app.c.NETWORK_ERROR.b());
                    o3.b.c(o3.b.b(b10.b(), b10.a(), ""));
                    activity.finish();
                }
                return true;
            }
            activity.finish();
            return true;
        }
        if (!this.f4998e) {
            z();
        }
        return true;
    }

    @Override // b4.c
    public synchronized void n() {
        this.f5001h.c();
        this.f5002i.a();
    }

    @Override // android.view.ViewGroup
    public synchronized boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f4998e ? true : super.onInterceptTouchEvent(motionEvent);
    }

    public synchronized void p(String str) {
        if ("POST".equals(this.f4997d)) {
            this.f5001h.g(str, null);
        } else {
            this.f5001h.f(str);
        }
        b4.c.j(this.f5001h.getWebView());
    }

    public synchronized void r(String str, String str2, boolean z10) {
        this.f4997d = str2;
        this.f5001h.getTitle().setText(str);
        this.f4996c = z10;
    }

    public boolean x() {
        return this.f5000g;
    }
}
