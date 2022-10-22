package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.content.DialogInterface;
/* loaded from: classes2.dex */
final class d3 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ Activity f21698a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ int f21699b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d3(Activity activity, int i10) {
        this.f21698a = activity;
        this.f21699b = i10;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        this.f21698a.removeDialog(this.f21699b);
        this.f21698a.finish();
    }
}
