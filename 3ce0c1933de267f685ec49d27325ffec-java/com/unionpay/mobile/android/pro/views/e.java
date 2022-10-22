package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.view.View;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.nocard.utils.c;
import com.unionpay.mobile.android.views.order.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f23929a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.f23929a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        b bVar;
        b bVar2;
        context = ((com.unionpay.mobile.android.nocard.views.b) this.f23929a).f23642d;
        bVar = ((com.unionpay.mobile.android.nocard.views.b) this.f23929a).f23639a;
        int a10 = c.a(context, bVar);
        this.f23929a.m();
        this.f23929a.m();
        Integer num = l.f24229c;
        if (a10 != num.intValue()) {
            bVar2 = ((com.unionpay.mobile.android.nocard.views.b) this.f23929a).f23639a;
            bVar2.aP = num.intValue();
            this.f23929a.d(2);
        }
    }
}
