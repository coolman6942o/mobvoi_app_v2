package com.google.firebase.iid;
/* loaded from: classes.dex */
public final class zzac extends Exception {
    private final int errorCode;

    public zzac(int i10, String str) {
        super(str);
        this.errorCode = i10;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
