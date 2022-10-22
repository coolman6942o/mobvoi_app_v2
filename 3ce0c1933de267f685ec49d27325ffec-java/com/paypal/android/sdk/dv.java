package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class dv implements Parcelable {
    public static final Parcelable.Creator CREATOR = new l2();

    /* renamed from: a  reason: collision with root package name */
    private String f21167a;

    /* renamed from: b  reason: collision with root package name */
    private String f21168b;

    public dv(Parcel parcel) {
        this.f21167a = parcel.readString();
        this.f21168b = parcel.readString();
    }

    public dv(String str, String str2) {
        this.f21167a = str;
        this.f21168b = str2;
    }

    public final String a() {
        return this.f21167a;
    }

    public final String b() {
        return this.f21168b;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return dv.class.getSimpleName() + "(authCode:" + this.f21167a + ", scope:" + this.f21168b + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f21167a);
        parcel.writeString(this.f21168b);
    }
}
