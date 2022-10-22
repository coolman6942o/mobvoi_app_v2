package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.content.Intent;
import android.text.style.URLSpan;
import android.view.View;
/* loaded from: classes2.dex */
final class b extends URLSpan {

    /* renamed from: a  reason: collision with root package name */
    private Activity f21663a;

    /* renamed from: b  reason: collision with root package name */
    private Class f21664b;

    /* renamed from: c  reason: collision with root package name */
    private b1 f21665c;

    /* renamed from: d  reason: collision with root package name */
    private i f21666d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(URLSpan uRLSpan, Activity activity, Class cls, b1 b1Var, i iVar) {
        super(uRLSpan.getURL());
        this.f21663a = activity;
        this.f21664b = cls;
        this.f21665c = b1Var;
        this.f21666d = iVar;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public final void onClick(View view) {
        Intent intent = new Intent(this.f21663a, this.f21664b);
        intent.putExtra("com.paypal.details.scope", this.f21666d);
        this.f21665c.a();
        this.f21663a.startActivity(intent);
    }
}
