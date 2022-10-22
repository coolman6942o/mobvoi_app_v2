package com.paypal.android.sdk.payments;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ EditText f21783a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(LoginActivity loginActivity, EditText editText) {
        this.f21783a = editText;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21783a.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 9999.0f, 0.0f, 0));
        this.f21783a.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 9999.0f, 0.0f, 0));
    }
}
