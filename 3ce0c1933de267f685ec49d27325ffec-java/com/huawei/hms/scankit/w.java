package com.huawei.hms.scankit;

import android.view.View;
/* compiled from: IRemoteViewDelegateImpl.java */
/* loaded from: classes2.dex */
class w implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f15082a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(y yVar) {
        this.f15082a = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.f15082a.f15057k;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
