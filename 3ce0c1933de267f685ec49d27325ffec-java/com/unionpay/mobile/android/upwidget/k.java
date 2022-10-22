package com.unionpay.mobile.android.upwidget;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class k implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f24100a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f24100a = jVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        int i11;
        int i12;
        int i13;
        ArrayList arrayList;
        int i14;
        int i15;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i16;
        i11 = this.f24100a.f24083o;
        view.setTag(Integer.valueOf(i11));
        i12 = this.f24100a.f24082n;
        i13 = this.f24100a.f24072d;
        if (i12 != i13) {
            arrayList3 = this.f24100a.f24075g;
            i16 = this.f24100a.f24082n;
            Object obj = arrayList3.get(i16);
            if (obj instanceof c) {
                ((c) obj).a(-1);
            }
        }
        arrayList = this.f24100a.f24075g;
        i14 = this.f24100a.f24083o;
        Object obj2 = arrayList.get(i14);
        if (obj2 instanceof c) {
            ((c) obj2).a(i10);
        }
        j jVar = this.f24100a;
        i15 = jVar.f24083o;
        jVar.f24082n = i15;
        this.f24100a.f24084p = i10;
        arrayList2 = this.f24100a.f24088t;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((AdapterView.OnItemClickListener) it.next()).onItemClick(adapterView, view, i10, j10);
        }
    }
}
