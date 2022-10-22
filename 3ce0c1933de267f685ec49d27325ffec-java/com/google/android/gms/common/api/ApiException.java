package com.google.android.gms.common.api;
/* loaded from: classes.dex */
public class ApiException extends Exception {
    protected final Status mStatus;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ApiException(Status status) {
        super(r3.toString());
        int H0 = status.H0();
        String I0 = status.I0() != null ? status.I0() : "";
        StringBuilder sb2 = new StringBuilder(String.valueOf(I0).length() + 13);
        sb2.append(H0);
        sb2.append(": ");
        sb2.append(I0);
        this.mStatus = status;
    }

    public int getStatusCode() {
        return this.mStatus.H0();
    }

    @Deprecated
    public String getStatusMessage() {
        return this.mStatus.I0();
    }
}
