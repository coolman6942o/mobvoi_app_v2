package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import z6.k;
/* loaded from: classes.dex */
public final class PointOfInterest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PointOfInterest> CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    public final LatLng f10077a;

    /* renamed from: b  reason: collision with root package name */
    public final String f10078b;

    /* renamed from: c  reason: collision with root package name */
    public final String f10079c;

    public PointOfInterest(LatLng latLng, String str, String str2) {
        this.f10077a = latLng;
        this.f10078b = str;
        this.f10079c = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.r(parcel, 2, this.f10077a, i10, false);
        a.t(parcel, 3, this.f10078b, false);
        a.t(parcel, 4, this.f10079c, false);
        a.b(parcel, a10);
    }
}
