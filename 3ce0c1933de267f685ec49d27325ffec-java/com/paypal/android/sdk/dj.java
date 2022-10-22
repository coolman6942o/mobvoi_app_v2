package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class dj implements Parcelable {
    public static final Parcelable.Creator CREATOR = new g2();

    /* renamed from: a  reason: collision with root package name */
    private es f21136a;

    /* renamed from: b  reason: collision with root package name */
    private String f21137b;

    /* renamed from: c  reason: collision with root package name */
    private dl f21138c;

    public dj() {
    }

    public dj(Parcel parcel) {
        this.f21136a = (es) parcel.readParcelable(es.class.getClassLoader());
        this.f21137b = parcel.readString();
        this.f21138c = (dl) parcel.readSerializable();
    }

    public dj(String str, es esVar, dl dlVar) {
        this.f21137b = str;
        this.f21136a = esVar;
        this.f21138c = dlVar;
    }

    public final es a() {
        return this.f21136a;
    }

    public final void b(dl dlVar) {
        this.f21138c = dlVar;
    }

    public final void c(es esVar) {
        this.f21136a = esVar;
    }

    public final void d(String str) {
        this.f21137b = str;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f21137b;
    }

    public final dl f() {
        return this.f21138c;
    }

    public final boolean g() {
        dl dlVar = this.f21138c;
        return !(dlVar == null || ((this.f21136a == null && dlVar.equals(dl.PHONE)) || (TextUtils.isEmpty(this.f21137b) && this.f21138c.equals(dl.EMAIL))));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f21136a, 0);
        parcel.writeString(this.f21137b);
        parcel.writeSerializable(this.f21138c);
    }
}
