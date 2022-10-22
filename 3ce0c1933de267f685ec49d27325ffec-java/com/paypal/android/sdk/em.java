package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class em implements Parcelable {
    public static final Parcelable.Creator CREATOR = new z2();

    /* renamed from: a  reason: collision with root package name */
    private String f21182a;

    /* renamed from: b  reason: collision with root package name */
    private String f21183b;

    /* renamed from: c  reason: collision with root package name */
    private es f21184c;

    /* renamed from: d  reason: collision with root package name */
    private String f21185d;

    public em(Parcel parcel) {
        this.f21182a = parcel.readString();
        this.f21183b = parcel.readString();
        this.f21184c = (es) parcel.readParcelable(es.class.getClassLoader());
        this.f21185d = parcel.readString();
    }

    public em(es esVar, String str) {
        this.f21184c = esVar;
        this.f21185d = str;
    }

    public em(String str, String str2) {
        this.f21182a = str;
        this.f21183b = str2;
    }

    public final boolean a() {
        return this.f21182a != null;
    }

    public final String b() {
        return this.f21182a;
    }

    public final String c() {
        return this.f21183b;
    }

    public final es d() {
        return this.f21184c;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f21185d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f21182a);
        parcel.writeString(this.f21183b);
        parcel.writeParcelable(this.f21184c, 0);
        parcel.writeString(this.f21185d);
    }
}
