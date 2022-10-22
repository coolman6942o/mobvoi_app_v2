package com.laser.tsm.sdk.oma;
/* loaded from: classes2.dex */
public interface SmartCardCallback {
    void onOperFailure(Error error);

    void onOperSuccess(String str);
}
