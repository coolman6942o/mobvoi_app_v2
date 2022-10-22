package com.unionpay.mobile.android.widgets;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
/* loaded from: classes2.dex */
final class n extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f24426a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(m mVar, Context context) {
        super(context);
        this.f24426a = mVar;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }
}
