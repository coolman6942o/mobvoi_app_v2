package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
/* loaded from: classes.dex */
public class ResolvableApiException extends ApiException {
    public ResolvableApiException(Status status) {
        super(status);
    }

    public PendingIntent getResolution() {
        return this.mStatus.G0();
    }

    public void startResolutionForResult(Activity activity, int i10) throws IntentSender.SendIntentException {
        this.mStatus.L0(activity, i10);
    }
}
