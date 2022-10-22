package com.huawei.hms.scankit;

import android.os.RemoteException;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
import com.huawei.hms.ml.camera.CameraManager;
import com.huawei.hms.scankit.util.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CaptureHelper.java */
/* renamed from: com.huawei.hms.scankit.b  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0556b implements CameraManager.CameraStatusListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0559e f14308a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0556b(C0559e eVar) {
        this.f14308a = eVar;
    }

    @Override // com.huawei.hms.ml.camera.CameraManager.CameraStatusListener
    public void onClosed() {
    }

    @Override // com.huawei.hms.ml.camera.CameraManager.CameraStatusListener
    public void onFailed() {
        IOnErrorCallback iOnErrorCallback;
        IOnErrorCallback iOnErrorCallback2;
        iOnErrorCallback = this.f14308a.G;
        if (iOnErrorCallback != null) {
            try {
                iOnErrorCallback2 = this.f14308a.G;
                iOnErrorCallback2.onError(-1000);
            } catch (RemoteException unused) {
                a.b(C0559e.f14347a, "RemoteException");
            }
        }
    }

    @Override // com.huawei.hms.ml.camera.CameraManager.CameraStatusListener
    public void onOpened() {
    }
}
