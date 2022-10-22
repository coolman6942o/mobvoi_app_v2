package com.huawei.hms.scankit;

import com.huawei.hms.ml.camera.CameraManager;
import com.huawei.hms.scankit.util.a;
/* compiled from: PreviewCallback.java */
/* loaded from: classes2.dex */
public class C implements CameraManager.FrameCallback {

    /* renamed from: a  reason: collision with root package name */
    private m f14070a;

    public C(m mVar) {
        this.f14070a = mVar;
    }

    @Override // com.huawei.hms.ml.camera.CameraManager.FrameCallback
    public void onFrame(byte[] bArr) {
        a.a("scan-time", "request frame time:" + System.currentTimeMillis());
        this.f14070a.a().obtainMessage(R.id.scankit_decode, bArr).sendToTarget();
    }
}
