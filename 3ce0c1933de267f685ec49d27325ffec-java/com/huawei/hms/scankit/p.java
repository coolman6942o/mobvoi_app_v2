package com.huawei.hms.scankit;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IRemoteCustomedViewDelegateImpl.java */
/* loaded from: classes2.dex */
public class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f14426a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(q qVar) {
        this.f14426a = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f14426a.f15061o.dismiss();
    }
}
