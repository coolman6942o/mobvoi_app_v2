package com.huawei.hms.scankit;

import android.app.Activity;
import android.content.Context;
import android.view.View;
/* compiled from: IRemoteLocalViewDelegateImpl.java */
/* loaded from: classes2.dex */
class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v f15080a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(v vVar) {
        this.f15080a = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context = this.f15080a.f15051e;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }
}
