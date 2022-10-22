package com.unionpay;

import android.view.View;
/* loaded from: classes2.dex */
final class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPPayWapActivity f23301a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(UPPayWapActivity uPPayWapActivity) {
        this.f23301a = uPPayWapActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f23301a.finish();
    }
}
