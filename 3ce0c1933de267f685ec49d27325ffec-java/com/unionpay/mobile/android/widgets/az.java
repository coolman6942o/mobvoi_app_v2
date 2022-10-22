package com.unionpay.mobile.android.widgets;

import android.view.View;
import com.unionpay.mobile.android.widgets.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class az implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ay f24342a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ay ayVar) {
        this.f24342a = ayVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ay.a aVar;
        ay.a aVar2;
        aVar = this.f24342a.f24341k;
        if (aVar != null) {
            aVar2 = this.f24342a.f24341k;
            aVar2.l();
        }
    }
}
