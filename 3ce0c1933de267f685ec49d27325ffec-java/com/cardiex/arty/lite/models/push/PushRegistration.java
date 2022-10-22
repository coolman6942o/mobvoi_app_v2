package com.cardiex.arty.lite.models.push;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.i;
import kotlinx.parcelize.Parcelize;
/* compiled from: PushRegistration.kt */
@Parcelize
/* loaded from: classes.dex */
public final class PushRegistration implements Parcelable {
    public static final Parcelable.Creator<PushRegistration> CREATOR = new Creator();
    private String deviceId;
    private String deviceName;
    private PushRegistrationKind kind;
    private String osVersion;
    private String registrationToken;
    private String userId;

    /* compiled from: PushRegistration.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<PushRegistration> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PushRegistration createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            return new PushRegistration(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), PushRegistrationKind.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PushRegistration[] newArray(int i10) {
            return new PushRegistration[i10];
        }
    }

    public PushRegistration(String deviceId, String str, String registrationToken, String deviceName, String userId, PushRegistrationKind kind) {
        i.f(deviceId, "deviceId");
        i.f(registrationToken, "registrationToken");
        i.f(deviceName, "deviceName");
        i.f(userId, "userId");
        i.f(kind, "kind");
        this.deviceId = deviceId;
        this.osVersion = str;
        this.registrationToken = registrationToken;
        this.deviceName = deviceName;
        this.userId = userId;
        this.kind = kind;
    }

    public static /* synthetic */ PushRegistration copy$default(PushRegistration pushRegistration, String str, String str2, String str3, String str4, String str5, PushRegistrationKind pushRegistrationKind, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = pushRegistration.deviceId;
        }
        if ((i10 & 2) != 0) {
            str2 = pushRegistration.osVersion;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = pushRegistration.registrationToken;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = pushRegistration.deviceName;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = pushRegistration.userId;
        }
        String str9 = str5;
        if ((i10 & 32) != 0) {
            pushRegistrationKind = pushRegistration.kind;
        }
        return pushRegistration.copy(str, str6, str7, str8, str9, pushRegistrationKind);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final String component2() {
        return this.osVersion;
    }

    public final String component3() {
        return this.registrationToken;
    }

    public final String component4() {
        return this.deviceName;
    }

    public final String component5() {
        return this.userId;
    }

    public final PushRegistrationKind component6() {
        return this.kind;
    }

    public final PushRegistration copy(String deviceId, String str, String registrationToken, String deviceName, String userId, PushRegistrationKind kind) {
        i.f(deviceId, "deviceId");
        i.f(registrationToken, "registrationToken");
        i.f(deviceName, "deviceName");
        i.f(userId, "userId");
        i.f(kind, "kind");
        return new PushRegistration(deviceId, str, registrationToken, deviceName, userId, kind);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PushRegistration)) {
            return false;
        }
        PushRegistration pushRegistration = (PushRegistration) obj;
        return i.b(this.deviceId, pushRegistration.deviceId) && i.b(this.osVersion, pushRegistration.osVersion) && i.b(this.registrationToken, pushRegistration.registrationToken) && i.b(this.deviceName, pushRegistration.deviceName) && i.b(this.userId, pushRegistration.userId) && this.kind == pushRegistration.kind;
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

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int hashCode = this.deviceId.hashCode() * 31;
        String str = this.osVersion;
        return ((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.registrationToken.hashCode()) * 31) + this.deviceName.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.kind.hashCode();
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

    public final void setUserId(String str) {
        i.f(str, "<set-?>");
        this.userId = str;
    }

    public String toString() {
        return "PushRegistration(deviceId=" + this.deviceId + ", osVersion=" + ((Object) this.osVersion) + ", registrationToken=" + this.registrationToken + ", deviceName=" + this.deviceName + ", userId=" + this.userId + ", kind=" + this.kind + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i10) {
        i.f(out, "out");
        out.writeString(this.deviceId);
        out.writeString(this.osVersion);
        out.writeString(this.registrationToken);
        out.writeString(this.deviceName);
        out.writeString(this.userId);
        out.writeString(this.kind.name());
    }
}
