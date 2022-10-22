package com.bjleisen.iface.sdk.apdu;

import com.bjleisen.iface.sdk.bean.Rapdu;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LeisenIfaceCallback.java */
/* loaded from: classes.dex */
public interface g {
    void onOperFailure(int i10, Error error);

    void onOperSuccess(Rapdu rapdu);
}
