package com.unionpay.mobile.android.nocard.views;

import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f23685a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f23685a = bVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        linearLayout = this.f23685a.f23656r;
        linearLayout.getViewTreeObserver().removeOnPreDrawListener(this);
        b bVar = this.f23685a;
        linearLayout2 = bVar.f23656r;
        bVar.f23659u = linearLayout2.getMeasuredHeight();
        b bVar2 = this.f23685a;
        linearLayout3 = bVar2.f23656r;
        bVar2.f23660v = linearLayout3.getTop();
        return true;
    }
}
