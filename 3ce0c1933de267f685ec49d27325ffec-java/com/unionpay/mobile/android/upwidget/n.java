package com.unionpay.mobile.android.upwidget;

import android.view.View;
import android.widget.TextView;
import com.unionpay.mobile.android.widgets.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f24103a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.f24103a = jVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TextView textView;
        TextView textView2;
        ad adVar;
        textView = this.f24103a.f24081m;
        textView.setEnabled(false);
        textView2 = this.f24103a.f24080l;
        textView2.setVisibility(8);
        adVar = this.f24103a.f24079k;
        adVar.setVisibility(0);
    }
}
