package com.cardiex.arty.lite.utils;

import h8.c;
/* compiled from: TokenRefreshUtil.kt */
/* loaded from: classes.dex */
public final class AuthResponse {
    @c("exp")
    private long expiresOn;
    @c("sub")
    private String owner;

    public final long getExpiresOn() {
        return this.expiresOn;
    }

    public final String getOwner() {
        return this.owner;
    }

    public final void setExpiresOn(long j10) {
        this.expiresOn = j10;
    }

    public final void setOwner(String str) {
        this.owner = str;
    }
}
