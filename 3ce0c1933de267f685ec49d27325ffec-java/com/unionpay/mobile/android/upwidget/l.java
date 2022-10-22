package com.unionpay.mobile.android.upwidget;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f24101a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.f24101a = jVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ArrayList arrayList;
        arrayList = this.f24101a.f24089u;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((View.OnClickListener) it.next()).onClick(view);
        }
    }
}
