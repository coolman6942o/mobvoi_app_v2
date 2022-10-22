package com.cardiex.arty.lite.models.push;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: AddPushRegistration.kt */
/* loaded from: classes.dex */
public final class AddPushRegistration {
    private String deviceId;
    private String deviceName;
    private PushRegistrationKind kind;
    private String osVersion;
    private String registrationToken;

    public AddPushRegistration(String deviceName, String registrationToken, String deviceId, String str, PushRegistrationKind kind) {
        i.f(deviceName, "deviceName");
        i.f(registrationToken, "registrationToken");
        i.f(deviceId, "deviceId");
        i.f(kind, "kind");
        this.deviceName = deviceName;
        this.registrationToken = registrationToken;
        this.deviceId = deviceId;
        this.osVersion = str;
        this.kind = kind;
    }

    public static /* synthetic */ AddPushRegistration copy$default(AddPushRegistration addPushRegistration, String str, String str2, String str3, String str4, PushRegistrationKind pushRegistrationKind, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = addPushRegistration.deviceName;
        }
        if ((i10 & 2) != 0) {
            str2 = addPushRegistration.registrationToken;
        }
        String str5 = str2;
        if ((i10 & 4) != 0) {
            str3 = addPushRegistration.deviceId;
        }
        String str6 = str3;
        if ((i10 & 8) != 0) {
            str4 = addPushRegistration.osVersion;
        }
        String str7 = str4;
        if ((i10 & 16) != 0) {
            pushRegistrationKind = addPushRegistration.kind;
        }
        return addPushRegistration.copy(str, str5, str6, str7, pushRegistrationKind);
    }

    public final String component1() {
        return this.deviceName;
    }

    public final String component2() {
        return this.registrationToken;
    }

    public final String component3() {
        return this.deviceId;
    }

    public final String component4() {
        return this.osVersion;
    }

    public final PushRegistrationKind component5() {
        return this.kind;
    }

    public final AddPushRegistration copy(String deviceName, String registrationToken, String deviceId, String str, PushRegistrationKind kind) {
        i.f(deviceName, "deviceName");
        i.f(registrationToken, "registrationToken");
        i.f(deviceId, "deviceId");
        i.f(kind, "kind");
        return new AddPushRegistration(deviceName, registrationToken, deviceId, str, kind);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddPushRegistration)) {
            return false;
        }
        AddPushRegistration addPushRegistration = (AddPushRegistration) obj;
        return i.b(this.deviceName, addPushRegistration.deviceName) && i.b(this.registrationToken, addPushRegistration.registrationToken) && i.b(this.deviceId, addPushRegistration.deviceId) && i.b(this.osVersion, addPushRegistration.osVersion) && this.kind == addPushRegistration.kind;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final PushRegistrationKind getKind() {
        return this.kind;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getRegistrationToken() {
        return this.registrationToken;
    }

    public int hashCode() {
        int hashCode = ((((this.deviceName.hashCode() * 31) + this.registrationToken.hashCode()) * 31) + this.deviceId.hashCode()) * 31;
        String str = this.osVersion;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.kind.hashCode();
    }

    public final void setDeviceId(String str) {
        i.f(str, "<set-?>");
        this.deviceId = str;
    }

    public final void setDeviceName(String str) {
        i.f(str, "<set-?>");
        this.deviceName = str;
    }

    public final void setKind(PushRegistrationKind pushRegistrationKind) {
        i.f(pushRegistrationKind, "<set-?>");
        this.kind = pushRegistrationKind;
    }

    public final void setOsVersion(String str) {
        this.osVersion = str;
    }

    public final void setRegistrationToken(String str) {
        i.f(str, "<set-?>");
        this.registrationToken = str;
    }

    public String toString() {
        return "AddPushRegistration(deviceName=" + this.deviceName + ", registrationToken=" + this.registrationToken + ", deviceId=" + this.deviceId + ", osVersion=" + ((Object) this.osVersion) + ", kind=" + this.kind + ')';
    }

    public /* synthetic */ AddPushRegistration(String str, String str2, String str3, String str4, PushRegistrationKind pushRegistrationKind, int i10, f fVar) {
        this(str, str2, str3, str4, (i10 & 16) != 0 ? PushRegistrationKind.FCM : pushRegistrationKind);
    }
}
