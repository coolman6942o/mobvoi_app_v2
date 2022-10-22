package com.cardiex.arty.lite.utils;

import kotlin.jvm.internal.i;
/* compiled from: ArtyAuthenticationHeaderProvider.kt */
/* loaded from: classes.dex */
public final class MobVoiTokenRequest {
    private String mobvoiToken;

    public MobVoiTokenRequest(String mobvoiToken) {
        i.f(mobvoiToken, "mobvoiToken");
        this.mobvoiToken = mobvoiToken;
    }

    public static /* synthetic */ MobVoiTokenRequest copy$default(MobVoiTokenRequest mobVoiTokenRequest, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = mobVoiTokenRequest.mobvoiToken;
        }
        return mobVoiTokenRequest.copy(str);
    }

    public final String component1() {
        return this.mobvoiToken;
    }

    public final MobVoiTokenRequest copy(String mobvoiToken) {
        i.f(mobvoiToken, "mobvoiToken");
        return new MobVoiTokenRequest(mobvoiToken);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MobVoiTokenRequest) && i.b(this.mobvoiToken, ((MobVoiTokenRequest) obj).mobvoiToken);
    }

    public final String getMobvoiToken() {
        return this.mobvoiToken;
    }

    public int hashCode() {
        return this.mobvoiToken.hashCode();
    }

    public final void setMobvoiToken(String str) {
        i.f(str, "<set-?>");
        this.mobvoiToken = str;
    }

    public String toString() {
        return "MobVoiTokenRequest(mobvoiToken=" + this.mobvoiToken + ')';
    }
}
