package com.huawei.hms.hmsscankit;

import android.app.Activity;
import android.view.View;
import com.huawei.hms.hmsscankit.RemoteView;
/* compiled from: RemoteView.java */
/* loaded from: classes2.dex */
class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RemoteView.a f14001a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(RemoteView.a aVar) {
        this.f14001a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        RemoteView.a aVar = this.f14001a;
        RemoteView remoteView = RemoteView.this;
        activity = aVar.f13977g;
        remoteView.startPhotoCode(activity);
    }
}
