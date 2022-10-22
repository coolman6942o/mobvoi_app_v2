package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import z6.n;
/* loaded from: classes.dex */
public class StreetViewPanoramaLocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaLocation> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    public final StreetViewPanoramaLink[] f10107a;

    /* renamed from: b  reason: collision with root package name */
    public final LatLng f10108b;

    /* renamed from: c  reason: collision with root package name */
    public final String f10109c;

    public StreetViewPanoramaLocation(StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this.f10107a = streetViewPanoramaLinkArr;
        this.f10108b = latLng;
        this.f10109c = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) obj;
        return this.f10109c.equals(streetViewPanoramaLocation.f10109c) && this.f10108b.equals(streetViewPanoramaLocation.f10108b);
    }

    public int hashCode() {
        return h.b(this.f10108b, this.f10109c);
    }

    public String toString() {
        return h.c(this).a("panoId", this.f10109c).a("position", this.f10108b.toString()).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.w(parcel, 2, this.f10107a, i10, false);
        a.r(parcel, 3, this.f10108b, i10, false);
        a.t(parcel, 4, this.f10109c, false);
        a.b(parcel, a10);
    }
}
