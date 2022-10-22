package com.huawei.hms.scankit;

import android.app.Activity;
import android.content.Context;
import android.view.OrientationEventListener;
import com.huawei.hms.ml.camera.CameraConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IRemoteCustomedViewDelegateImpl.java */
/* loaded from: classes2.dex */
public class o extends OrientationEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f14425a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(q qVar, Context context) {
        super(context);
        this.f14425a = qVar;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i10) {
        int rotation = ((Activity) this.f14425a.f15051e).getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 0) {
            this.f14425a.a(90);
        } else if (rotation == 1) {
            this.f14425a.a(0);
        } else if (rotation == 2) {
            this.f14425a.a(270);
        } else if (rotation == 3) {
            this.f14425a.a((int) CameraConfig.CAMERA_THIRD_DEGREE);
        }
    }
}
