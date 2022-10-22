package com.bjleisen.iface.sdk.nfc;
/* loaded from: classes.dex */
public interface NfcOperatorCallback {
    void onOperFailure(int i10, Error error);

    void onOperSuccess(String str);
}
