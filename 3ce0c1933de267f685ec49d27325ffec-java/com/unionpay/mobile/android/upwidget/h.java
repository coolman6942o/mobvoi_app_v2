package com.unionpay.mobile.android.upwidget;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f24067a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f24067a = gVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        ArrayList arrayList;
        arrayList = this.f24067a.f24063c;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((AdapterView.OnItemClickListener) it.next()).onItemClick(adapterView, view, i10, j10);
        }
    }
}
