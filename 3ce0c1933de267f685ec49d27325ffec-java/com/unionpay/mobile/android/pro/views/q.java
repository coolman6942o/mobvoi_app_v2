package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.unionpay.mobile.android.nocard.views.b;
import com.unionpay.mobile.android.plugin.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f23956a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(k kVar) {
        this.f23956a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        context = ((b) this.f23956a).f23642d;
        ((BaseActivity) context).startActivityForResult(new Intent("android.settings.NFC_SETTINGS"), 0);
    }
}
