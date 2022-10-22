package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.nocard.views.bd;
import com.unionpay.mobile.android.utils.o;
/* loaded from: classes2.dex */
final class bg implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f23672a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f23673b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f23674c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ bd.a f23675d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bd.a aVar, int i10, String str, String str2) {
        this.f23675d = aVar;
        this.f23672a = i10;
        this.f23673b = str;
        this.f23674c = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String[] strArr = o.f24167i;
        bd.this.a("", this.f23674c);
    }
}
