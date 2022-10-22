package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import w6.l;
/* loaded from: classes.dex */
public class DetectedActivity extends AbstractSafeParcelable {

    /* renamed from: a  reason: collision with root package name */
    private int f9919a;

    /* renamed from: b  reason: collision with root package name */
    private int f9920b;

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f9918c = {0, 1, 2, 3, 7, 8, 16, 17};
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new l();

    static {
        new k();
    }

    public DetectedActivity(int i10, int i11) {
        this.f9919a = i10;
        this.f9920b = i11;
    }

    public static void I0(int i10) {
        boolean z10 = false;
        for (int i11 : f9918c) {
            if (i11 == i10) {
                z10 = true;
            }
        }
        if (!z10) {
            StringBuilder sb2 = new StringBuilder(81);
            sb2.append(i10);
            sb2.append(" is not a valid DetectedActivity supported by Activity Transition API.");
            Log.w("DetectedActivity", sb2.toString());
        }
    }

    public int G0() {
        return this.f9920b;
    }

    public int H0() {
        int i10 = this.f9919a;
        if (i10 > 19 || i10 < 0) {
            return 4;
        }
        return i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DetectedActivity detectedActivity = (DetectedActivity) obj;
            if (this.f9919a == detectedActivity.f9919a && this.f9920b == detectedActivity.f9920b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return h.b(Integer.valueOf(this.f9919a), Integer.valueOf(this.f9920b));
    }

    public String toString() {
        String str;
        int H0 = H0();
        if (H0 == 0) {
            str = "IN_VEHICLE";
        } else if (H0 == 1) {
            str = "ON_BICYCLE";
        } else if (H0 == 2) {
            str = "ON_FOOT";
        } else if (H0 == 3) {
            str = "STILL";
        } else if (H0 == 4) {
            str = GrsBaseInfo.CountryCodeSource.UNKNOWN;
        } else if (H0 == 5) {
            str = "TILTING";
        } else if (H0 == 7) {
            str = "WALKING";
        } else if (H0 != 8) {
            switch (H0) {
                case 16:
                    str = "IN_ROAD_VEHICLE";
                    break;
                case 17:
                    str = "IN_RAIL_VEHICLE";
                    break;
                case 18:
                    str = "IN_TWO_WHEELER_VEHICLE";
                    break;
                case 19:
                    str = "IN_FOUR_WHEELER_VEHICLE";
                    break;
                default:
                    str = Integer.toString(H0);
                    break;
            }
        } else {
            str = "RUNNING";
        }
        int i10 = this.f9920b;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 48);
        sb2.append("DetectedActivity [type=");
        sb2.append(str);
        sb2.append(", confidence=");
        sb2.append(i10);
        sb2.append("]");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f9919a);
        a.l(parcel, 2, this.f9920b);
        a.b(parcel, a10);
    }
}
