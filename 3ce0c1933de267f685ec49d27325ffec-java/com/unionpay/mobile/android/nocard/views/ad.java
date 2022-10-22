package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.unionpay.mobile.android.nocard.views.o;
import com.unionpay.mobile.android.upwidget.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ad implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o.b f23588a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(o.b bVar) {
        this.f23588a = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        PopupWindow popupWindow;
        List list;
        o.a aVar;
        o.a aVar2;
        c cVar;
        c cVar2;
        List list2;
        c cVar3;
        int i11;
        popupWindow = this.f23588a.f23726b;
        popupWindow.dismiss();
        list = this.f23588a.f23734j;
        if (list != null) {
            cVar2 = this.f23588a.f23727c;
            int c10 = i10 - cVar2.c();
            list2 = this.f23588a.f23734j;
            if (c10 < list2.size()) {
                this.f23588a.f23731g = i10;
                cVar3 = this.f23588a.f23727c;
                i11 = this.f23588a.f23731g;
                cVar3.a(i11);
            }
        }
        aVar = this.f23588a.f23735k;
        if (aVar != null) {
            aVar2 = this.f23588a.f23735k;
            cVar = this.f23588a.f23727c;
            aVar2.a(i10 - cVar.c());
        }
    }
}
