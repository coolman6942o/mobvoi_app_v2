package com.google.android.gms.common;

import android.content.Intent;
/* loaded from: classes.dex */
public class GooglePlayServicesRepairableException extends UserRecoverableException {
    private final int zzag;

    public GooglePlayServicesRepairableException(int i10, String str, Intent intent) {
        super(str, intent);
        this.zzag = i10;
    }

    public int getConnectionStatusCode() {
        return this.zzag;
    }
}
