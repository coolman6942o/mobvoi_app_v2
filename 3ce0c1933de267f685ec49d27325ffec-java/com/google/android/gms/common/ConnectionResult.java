package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.feature.dynamic.b;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.mlsdk.common.internal.client.event.MonitorResult;
/* loaded from: classes.dex */
public final class ConnectionResult extends AbstractSafeParcelable {

    /* renamed from: a  reason: collision with root package name */
    private final int f8432a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8433b;

    /* renamed from: c  reason: collision with root package name */
    private final PendingIntent f8434c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8435d;

    /* renamed from: e  reason: collision with root package name */
    public static final ConnectionResult f8431e = new ConnectionResult(0);
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new g();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConnectionResult(int i10, int i11, PendingIntent pendingIntent, String str) {
        this.f8432a = i10;
        this.f8433b = i11;
        this.f8434c = pendingIntent;
        this.f8435d = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String L0(int i10) {
        if (i10 == 99) {
            return "UNFINISHED";
        }
        if (i10 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i10) {
            case -1:
                return GrsBaseInfo.CountryCodeSource.UNKNOWN;
            case 0:
                return MonitorResult.SUCCESS;
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i10) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    default:
                        StringBuilder sb2 = new StringBuilder(31);
                        sb2.append("UNKNOWN_ERROR_CODE(");
                        sb2.append(i10);
                        sb2.append(")");
                        return sb2.toString();
                }
        }
    }

    public final int G0() {
        return this.f8433b;
    }

    public final String H0() {
        return this.f8435d;
    }

    public final PendingIntent I0() {
        return this.f8434c;
    }

    public final boolean J0() {
        return (this.f8433b == 0 || this.f8434c == null) ? false : true;
    }

    public final boolean K0() {
        return this.f8433b == 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f8433b == connectionResult.f8433b && h.a(this.f8434c, connectionResult.f8434c) && h.a(this.f8435d, connectionResult.f8435d);
    }

    public final int hashCode() {
        return h.b(Integer.valueOf(this.f8433b), this.f8434c, this.f8435d);
    }

    public final String toString() {
        return h.c(this).a("statusCode", L0(this.f8433b)).a(b.f13797h, this.f8434c).a("message", this.f8435d).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8432a);
        a.l(parcel, 2, G0());
        a.r(parcel, 3, I0(), i10, false);
        a.t(parcel, 4, H0(), false);
        a.b(parcel, a10);
    }

    public ConnectionResult(int i10) {
        this(i10, null, null);
    }

    public ConnectionResult(int i10, PendingIntent pendingIntent) {
        this(i10, pendingIntent, null);
    }

    public ConnectionResult(int i10, PendingIntent pendingIntent, String str) {
        this(1, i10, pendingIntent, str);
    }
}
