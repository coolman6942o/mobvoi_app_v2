package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.content.DialogInterface;
/* loaded from: classes2.dex */
final class e3 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ Activity f21717a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e3(Activity activity) {
        this.f21717a = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        this.f21717a.finish();
    }
}
