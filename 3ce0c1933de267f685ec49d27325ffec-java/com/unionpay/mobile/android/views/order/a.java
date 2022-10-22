package com.unionpay.mobile.android.views.order;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AbstractMethod f24188a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbstractMethod abstractMethod) {
        this.f24188a = abstractMethod;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AbstractMethod abstractMethod = this.f24188a;
        if (abstractMethod.f24174f != null) {
            boolean z10 = abstractMethod.c() == null;
            AbstractMethod abstractMethod2 = this.f24188a;
            abstractMethod2.f24174f.a(abstractMethod2.b(), z10, this.f24188a.d(), this.f24188a.c());
        }
    }
}
