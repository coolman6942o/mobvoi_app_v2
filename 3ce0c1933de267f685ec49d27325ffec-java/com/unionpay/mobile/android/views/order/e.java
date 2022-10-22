package com.unionpay.mobile.android.views.order;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class e implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f24214a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.f24214a = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        this.f24214a.c(i10);
    }
}
