package com.huawei.hms.scankit;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IRemoteCustomedViewDelegateImpl.java */
/* loaded from: classes2.dex */
public class n implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f14424a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(q qVar) {
        this.f14424a = qVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f14424a.f15054h.a(motionEvent);
        return true;
    }
}
