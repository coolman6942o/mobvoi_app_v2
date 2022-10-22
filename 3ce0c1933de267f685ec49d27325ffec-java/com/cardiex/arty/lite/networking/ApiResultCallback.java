package com.cardiex.arty.lite.networking;
/* compiled from: BaseApiRepository.kt */
/* loaded from: classes.dex */
public interface ApiResultCallback<TResult> {
    void onError(Exception exc);

    void onSuccess(TResult tresult);
}
