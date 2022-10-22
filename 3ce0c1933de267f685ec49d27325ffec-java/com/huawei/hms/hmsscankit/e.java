package com.huawei.hms.hmsscankit;

import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.util.a;
/* compiled from: OnResultCallbackDelegate.java */
/* loaded from: classes2.dex */
class e extends IOnResultCallback.Stub {

    /* renamed from: a  reason: collision with root package name */
    private final OnResultCallback f13996a;

    /* renamed from: b  reason: collision with root package name */
    private String f13997b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13998c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(OnResultCallback onResultCallback, boolean z10) {
        this.f13998c = true;
        this.f13996a = onResultCallback;
        this.f13998c = z10;
    }

    @Override // com.huawei.hms.hmsscankit.api.IOnResultCallback
    public void onResult(HmsScan[] hmsScanArr) throws RemoteException {
        a.c("OnResultCallbackDelegat", "result callback sdk continueScan" + this.f13998c);
        if (this.f13998c) {
            this.f13996a.onResult(hmsScanArr);
        } else if (hmsScanArr != null && hmsScanArr.length > 0 && hmsScanArr[0] != null && !TextUtils.equals(this.f13997b, hmsScanArr[0].getOriginalValue())) {
            this.f13997b = hmsScanArr[0].getOriginalValue();
            a.c("OnResultCallbackDelegat", "result callback sdk continueScan" + this.f13998c);
            this.f13996a.onResult(hmsScanArr);
        }
    }
}
