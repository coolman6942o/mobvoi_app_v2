package com.google.zxing.qrcode.decoder;

import com.google.zxing.i;
/* compiled from: QRCodeDecoderMetaData.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f13465a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(boolean z10) {
        this.f13465a = z10;
    }

    public void a(i[] iVarArr) {
        if (this.f13465a && iVarArr != null && iVarArr.length >= 3) {
            i iVar = iVarArr[0];
            iVarArr[0] = iVarArr[2];
            iVarArr[2] = iVar;
        }
    }
}
