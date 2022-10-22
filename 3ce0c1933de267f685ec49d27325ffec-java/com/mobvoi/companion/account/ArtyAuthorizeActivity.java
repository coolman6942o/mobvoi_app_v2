package com.mobvoi.companion.account;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.d;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import com.mobvoi.assistant.account.tab.webview.OverseaBrowserActivity;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.companion.setting.Constants;
import ee.b;
import ee.e;
import lb.c;
/* loaded from: classes2.dex */
public class ArtyAuthorizeActivity extends d {

    /* renamed from: a  reason: collision with root package name */
    protected Toolbar f16113a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f16114b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f16115c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f16116d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16117e;

    /* renamed from: f  reason: collision with root package name */
    private p f16118f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            OverseaBrowserActivity.J(ArtyAuthorizeActivity.this, c.d() ? "https://www.mobvoi.com/tw/pages/privacy-policy" : Constants.PRIVACY_URL);
        }
    }

    private void I() {
        this.f16115c.setMovementMethod(LinkMovementMethod.getInstance());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = getString(e.f25890a);
        String string2 = getString(e.f25892c);
        spannableStringBuilder.append((CharSequence) string2);
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.setSpan(new a(), string2.length(), string2.length() + string.length(), 33);
        spannableStringBuilder.setSpan(new UnderlineSpan() { // from class: com.mobvoi.companion.account.ArtyAuthorizeActivity.2
            @Override // android.text.style.UnderlineSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(ArtyAuthorizeActivity.this.getResources().getColor(ee.a.a_res_0x7f06014c, null));
                textPaint.setUnderlineText(false);
            }
        }, string2.length(), string2.length() + string.length(), 33);
        this.f16115c.setText(spannableStringBuilder);
    }

    private void J() {
        boolean isArtyAuthorize = CompanionSetting.isArtyAuthorize();
        this.f16117e = isArtyAuthorize;
        if (isArtyAuthorize) {
            this.f16114b.setText(getString(e.f25894e));
            this.f16114b.setCompoundDrawablesWithIntrinsicBounds(b.f25886b, 0, 0, 0);
            this.f16116d.setText(getString(e.f25896g));
            return;
        }
        this.f16114b.setText(getString(e.f25895f));
        this.f16114b.setCompoundDrawablesWithIntrinsicBounds(b.f25885a, 0, 0, 0);
        this.f16116d.setText(getString(e.f25893d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(Boolean bool) {
        if (bool.booleanValue()) {
            J();
        } else {
            Toast.makeText(this, getString(this.f16117e ? e.f25897h : e.f25891b), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(View view) {
        this.f16118f.q(!this.f16117e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ee.d.b_res_0x7f0e014c);
        findViewById(ee.c.f25889l).setVisibility(8);
        Toolbar toolbar = (Toolbar) findViewById(ee.c.f25888h);
        this.f16113a = toolbar;
        toolbar.setNavigationIcon(b.f25887c);
        setSupportActionBar(this.f16113a);
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
            supportActionBar.u(false);
        }
        this.f16114b = (TextView) findViewById(ee.c.j_res_0x7f0b07c3);
        this.f16115c = (TextView) findViewById(ee.c.i_res_0x7f0b07c2);
        this.f16116d = (TextView) findViewById(ee.c.k_res_0x7f0b07d7);
        p pVar = (p) new h0(this).a(p.class);
        this.f16118f = pVar;
        pVar.s().i(this, new x() { // from class: com.mobvoi.companion.account.b
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                ArtyAuthorizeActivity.this.K((Boolean) obj);
            }
        });
        J();
        I();
        this.f16116d.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.account.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtyAuthorizeActivity.this.L(view);
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
