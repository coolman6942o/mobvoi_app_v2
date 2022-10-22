package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import z6.r;
/* loaded from: classes.dex */
public final class VisibleRegion extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VisibleRegion> CREATOR = new r();

    /* renamed from: a  reason: collision with root package name */
    public final LatLng f10124a;

    /* renamed from: b  reason: collision with root package name */
    public final LatLng f10125b;

    /* renamed from: c  reason: collision with root package name */
    public final LatLng f10126c;

    /* renamed from: d  reason: collision with root package name */
    public final LatLng f10127d;

    /* renamed from: e  reason: collision with root package name */
    public final LatLngBounds f10128e;

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.f10124a = latLng;
        this.f10125b = latLng2;
        this.f10126c = latLng3;
        this.f10127d = latLng4;
        this.f10128e = latLngBounds;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        return this.f10124a.equals(visibleRegion.f10124a) && this.f10125b.equals(visibleRegion.f10125b) && this.f10126c.equals(visibleRegion.f10126c) && this.f10127d.equals(visibleRegion.f10127d) && this.f10128e.equals(visibleRegion.f10128e);
    }

    public final int hashCode() {
        return h.b(this.f10124a, this.f10125b, this.f10126c, this.f10127d, this.f10128e);
    }

    public final String toString() {
        return h.c(this).a("nearLeft", this.f10124a).a("nearRight", this.f10125b).a("farLeft", this.f10126c).a("farRight", this.f10127d).a("latLngBounds", this.f10128e).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.r(parcel, 2, this.f10124a, i10, false);
        a.r(parcel, 3, this.f10125b, i10, false);
        a.r(parcel, 4, this.f10126c, i10, false);
        a.r(parcel, 5, this.f10127d, i10, false);
        a.r(parcel, 6, this.f10128e, i10, false);
        a.b(parcel, a10);
    }
}
