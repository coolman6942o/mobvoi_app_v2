package com.unionpay;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import com.unionpay.utils.f;
import com.unionpay.utils.g;
import com.unionpay.utils.h;
import com.unionpay.utils.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class UPPayWapActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f23249a;

    /* renamed from: b  reason: collision with root package name */
    private WebView f23250b;

    /* renamed from: c  reason: collision with root package name */
    private WebViewJavascriptBridge f23251c;

    /* renamed from: d  reason: collision with root package name */
    private AlertDialog f23252d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(UPPayWapActivity uPPayWapActivity, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("pay_result", str);
        intent.putExtra("result_data", str2);
        uPPayWapActivity.setResult(-1, intent);
        uPPayWapActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject("{\"code\":\"0\",\"msg\":\"success\"}");
            if (str != null) {
                jSONObject.put("code", str);
            }
            if (str2 != null) {
                jSONObject.put("msg", str2);
            }
            if (str3 != null) {
                jSONObject.put(HealthDataProviderContracts.NAME_VALUE, str3);
            }
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        View.OnClickListener onClickListener;
        super.onCreate(bundle);
        try {
            try {
                if (!"949A1CC".equalsIgnoreCase(getIntent().getStringExtra("magic_data"))) {
                    finish();
                }
                String stringExtra = getIntent().getStringExtra("waptype");
                String str2 = "";
                if (stringExtra == null || !stringExtra.equals("new_page")) {
                    String stringExtra2 = getIntent().getStringExtra("wapurl");
                    String stringExtra3 = getIntent().getStringExtra("paydata");
                    if (stringExtra3 != null) {
                        str2 = stringExtra2 + "?s=" + stringExtra3;
                    }
                    str2 = k.a().f24590e;
                    onClickListener = new j(this);
                    str = str2;
                } else {
                    str = getIntent().getStringExtra("wapurl");
                    String stringExtra4 = getIntent().getStringExtra("waptitle");
                    if (str == null) {
                        str = str2;
                    }
                    if (stringExtra4 != null) {
                        str2 = stringExtra4;
                    }
                    onClickListener = new f(this);
                }
                getWindow().requestFeature(1);
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setOrientation(1);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                RelativeLayout relativeLayout = new RelativeLayout(this);
                relativeLayout.setLayoutParams(layoutParams);
                int a10 = f.a(this, 10.0f);
                int a11 = f.a(this, 52.0f);
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, a11));
                relativeLayout.setBackgroundColor(-10705958);
                LinearLayout linearLayout2 = new LinearLayout(this);
                this.f23249a = linearLayout2;
                linearLayout2.setPadding(a10, a10, a10, a10);
                this.f23249a.setGravity(16);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(9, -1);
                layoutParams2.addRule(15, -1);
                layoutParams2.leftMargin = a10;
                this.f23249a.setOnClickListener(onClickListener);
                relativeLayout.addView(this.f23249a, layoutParams2);
                int a12 = f.a(this, 20.0f);
                int a13 = f.a(this, 11.0f);
                ImageView imageView = new ImageView(this);
                imageView.setBackgroundDrawable(g.a(h.f24583a));
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(a13, a12);
                layoutParams3.addRule(15, -1);
                this.f23249a.addView(imageView, layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(f.a(this, 320.0f), a11);
                layoutParams4.addRule(13, -1);
                TextView textView = new TextView(this);
                textView.setTextSize(20.0f);
                textView.setTextColor(-1);
                textView.setText(str2);
                textView.setGravity(17);
                textView.setSingleLine(true);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                relativeLayout.addView(textView, layoutParams4);
                linearLayout.addView(relativeLayout);
                WebView webView = new WebView(this);
                this.f23250b = webView;
                webView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                linearLayout.addView(this.f23250b);
                setContentView(linearLayout);
                this.f23251c = new WebViewJavascriptBridge(this, this.f23250b, null);
                this.f23250b.loadUrl(str);
                this.f23251c.registerHandler("getDeviceInfo", new m(this));
                this.f23251c.registerHandler("saveData", new n(this));
                this.f23251c.registerHandler("getData", new o(this));
                this.f23251c.registerHandler("removeData", new p(this));
                this.f23251c.registerHandler("setPageBackEnable", new q(this));
                this.f23251c.registerHandler("payBySDK", new r(this));
                this.f23251c.registerHandler("downloadApp", new s(this));
                this.f23251c.registerHandler("payResult", new g(this));
                this.f23251c.registerHandler("closePage", new h(this));
                this.f23251c.registerHandler("openNewPage", new i(this));
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            finish();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyDown(i10, keyEvent);
        }
        onPause();
        return true;
    }
}
