package com.cardiex.arty.lite.utils;

import kotlin.jvm.internal.i;
/* compiled from: ArtyAuthenticationHeaderProvider.kt */
/* loaded from: classes.dex */
public final class MobVoiTokenResponse {
    private String jwt;

    public MobVoiTokenResponse(String str) {
        this.jwt = str;
    }

    public static /* synthetic */ MobVoiTokenResponse copy$default(MobVoiTokenResponse mobVoiTokenResponse, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = mobVoiTokenResponse.jwt;
        }
        return mobVoiTokenResponse.copy(str);
    }

    public final String component1() {
        return this.jwt;
    }

    public final MobVoiTokenResponse copy(String str) {
        return new MobVoiTokenResponse(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MobVoiTokenResponse) && i.b(this.jwt, ((MobVoiTokenResponse) obj).jwt);
    }

    public final String getJwt() {
        return this.jwt;
    }

    public int hashCode() {
        String str = this.jwt;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final void setJwt(String str) {
        this.jwt = str;
    }

    public String toString() {
        return "MobVoiTokenResponse(jwt=" + ((Object) this.jwt) + ')';
    }
}
