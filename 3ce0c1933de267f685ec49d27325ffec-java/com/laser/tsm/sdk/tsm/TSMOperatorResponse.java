package com.laser.tsm.sdk.tsm;

import com.laser.tsm.sdk.bean.Rapdu;
/* loaded from: classes2.dex */
public interface TSMOperatorResponse {
    void onOperFailure(int i10, Error error);

    void onOperSuccess(Rapdu rapdu);
}
