package com.huawei.hms.hmsscankit;

import android.app.Activity;
import android.view.View;
import com.huawei.hms.hmsscankit.RemoteView;
/* compiled from: RemoteView.java */
/* loaded from: classes2.dex */
class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RemoteView.a f14002a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(RemoteView.a aVar) {
        this.f14002a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        RemoteView.a aVar = this.f14002a;
        RemoteView remoteView = RemoteView.this;
        activity = aVar.f13977g;
        remoteView.startPhotoCode(activity);
    }
}
