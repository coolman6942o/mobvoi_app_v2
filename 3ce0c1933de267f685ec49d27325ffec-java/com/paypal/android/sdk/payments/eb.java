package com.paypal.android.sdk.payments;

import android.text.style.URLSpan;
import android.view.View;
/* loaded from: classes2.dex */
final class eb extends URLSpan {

    /* renamed from: a  reason: collision with root package name */
    private b1 f21718a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(URLSpan uRLSpan, b1 b1Var) {
        super(uRLSpan.getURL());
        this.f21718a = b1Var;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public final void onClick(View view) {
        this.f21718a.a();
        super.onClick(view);
    }
}
