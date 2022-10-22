package com.unionpay.mobile.android.upwidget;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f24068a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.f24068a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ArrayList arrayList;
        arrayList = this.f24068a.f24064d;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((View.OnClickListener) it.next()).onClick(view);
        }
    }
}
