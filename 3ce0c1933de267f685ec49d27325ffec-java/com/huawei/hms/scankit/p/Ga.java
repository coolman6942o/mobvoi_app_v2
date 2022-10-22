package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.z;
/* compiled from: QRCodeDecoderMetaData.java */
/* loaded from: classes2.dex */
public final class Ga {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f14532a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ga(boolean z10) {
        this.f14532a = z10;
    }

    public void a(z[] zVarArr) {
        if (this.f14532a && zVarArr != null && zVarArr.length >= 3) {
            z zVar = zVarArr[0];
            zVarArr[0] = zVarArr[2];
            zVarArr[2] = zVar;
        }
    }
}
