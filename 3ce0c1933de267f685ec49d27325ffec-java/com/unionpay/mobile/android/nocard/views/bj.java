package com.unionpay.mobile.android.nocard.views;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes2.dex */
final class bj implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bi f23682a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bi biVar) {
        this.f23682a = biVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if ((action != 0 && action != 1) || view.hasFocus()) {
            return false;
        }
        view.requestFocus();
        return false;
    }
}
