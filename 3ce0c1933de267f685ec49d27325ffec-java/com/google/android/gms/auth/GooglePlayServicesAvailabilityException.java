package com.google.android.gms.auth;
/* loaded from: classes.dex */
public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {
    private final int zzu;

    public int getConnectionStatusCode() {
        return this.zzu;
    }
}
