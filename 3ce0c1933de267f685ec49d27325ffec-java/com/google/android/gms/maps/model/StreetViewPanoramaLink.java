package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import z6.m;
/* loaded from: classes.dex */
public class StreetViewPanoramaLink extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaLink> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    public final String f10105a;

    /* renamed from: b  reason: collision with root package name */
    public final float f10106b;

    public StreetViewPanoramaLink(String str, float f10) {
        this.f10105a = str;
        this.f10106b = (((double) f10) <= 0.0d ? (f10 % 360.0f) + 360.0f : f10) % 360.0f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) obj;
        return this.f10105a.equals(streetViewPanoramaLink.f10105a) && Float.floatToIntBits(this.f10106b) == Float.floatToIntBits(streetViewPanoramaLink.f10106b);
    }

    public int hashCode() {
        return h.b(this.f10105a, Float.valueOf(this.f10106b));
    }

    public String toString() {
        return h.c(this).a("panoId", this.f10105a).a("bearing", Float.valueOf(this.f10106b)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.t(parcel, 2, this.f10105a, false);
        a.i(parcel, 3, this.f10106b);
        a.b(parcel, a10);
    }
}
