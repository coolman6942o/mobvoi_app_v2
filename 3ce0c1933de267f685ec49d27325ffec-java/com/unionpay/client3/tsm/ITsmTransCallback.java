package com.unionpay.client3.tsm;

import android.os.Bundle;
/* loaded from: classes2.dex */
public interface ITsmTransCallback {
    void onFailed(int i10, int i11, String str, String str2);

    void onSuccess(int i10, int i11, Bundle bundle);
}
