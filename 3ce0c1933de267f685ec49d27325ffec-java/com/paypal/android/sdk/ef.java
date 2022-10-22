package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class ef implements Parcelable {
    public static final Parcelable.Creator CREATOR = new u2();

    /* renamed from: a  reason: collision with root package name */
    private final String f21181a;

    public ef(Parcel parcel) {
        this.f21181a = parcel.readString();
    }

    public ef(String str) {
        if (str.equals("OTHER") || str.length() == 2) {
            this.f21181a = str;
        } else {
            this.f21181a = "US";
        }
    }

    public final String a() {
        return this.f21181a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.f21181a.equals(((ef) obj).f21181a);
        }
        return false;
    }

    public int hashCode() {
        return this.f21181a.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f21181a);
    }
}
