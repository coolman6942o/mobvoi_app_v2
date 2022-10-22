package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.os.Bundle;
import com.paypal.android.sdk.ft;
import com.paypal.android.sdk.z3;
/* loaded from: classes2.dex */
public final class FuturePaymentInfoActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private j f21514a;

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(16973934);
        requestWindowFeature(8);
        j jVar = new j(this, (i) getIntent().getExtras().getSerializable("com.paypal.details.scope"));
        this.f21514a = jVar;
        setContentView(jVar.f21743a);
        c2.o(this, this.f21514a.f21744b, null);
        this.f21514a.f21748f.setText(z3.a(ft.BACK_BUTTON));
        this.f21514a.f21748f.setOnClickListener(new h(this));
    }
}
