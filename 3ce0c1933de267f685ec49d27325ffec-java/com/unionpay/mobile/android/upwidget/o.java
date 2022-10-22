package com.unionpay.mobile.android.upwidget;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f24104a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.f24104a = jVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10;
        int i11;
        int i12;
        int i13;
        ArrayList arrayList;
        ArrayList arrayList2;
        int i14;
        i10 = this.f24104a.f24082n;
        i11 = this.f24104a.f24072d;
        if (i10 != i11) {
            arrayList2 = this.f24104a.f24075g;
            i14 = this.f24104a.f24082n;
            Object obj = arrayList2.get(i14);
            if (obj instanceof c) {
                ((c) obj).a(-1);
            }
        }
        j jVar = this.f24104a;
        i12 = jVar.f24083o;
        jVar.f24082n = i12;
        j jVar2 = this.f24104a;
        i13 = jVar2.f24072d;
        jVar2.f24084p = i13;
        arrayList = this.f24104a.f24092x;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((View.OnClickListener) it.next()).onClick(view);
        }
    }
}
