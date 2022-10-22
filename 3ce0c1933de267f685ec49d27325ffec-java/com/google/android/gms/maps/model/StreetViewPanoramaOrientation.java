package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import b6.i;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import z6.o;
/* loaded from: classes.dex */
public class StreetViewPanoramaOrientation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOrientation> CREATOR = new o();

    /* renamed from: a  reason: collision with root package name */
    public final float f10110a;

    /* renamed from: b  reason: collision with root package name */
    public final float f10111b;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public float f10112a;

        /* renamed from: b  reason: collision with root package name */
        public float f10113b;

        public final a a(float f10) {
            this.f10112a = f10;
            return this;
        }

        public final StreetViewPanoramaOrientation b() {
            return new StreetViewPanoramaOrientation(this.f10113b, this.f10112a);
        }

        public final a c(float f10) {
            this.f10113b = f10;
            return this;
        }
    }

    public StreetViewPanoramaOrientation(float f10, float f11) {
        boolean z10 = -90.0f <= f10 && f10 <= 90.0f;
        StringBuilder sb2 = new StringBuilder(62);
        sb2.append("Tilt needs to be between -90 and 90 inclusive: ");
        sb2.append(f10);
        i.b(z10, sb2.toString());
        this.f10110a = f10 + 0.0f;
        this.f10111b = (((double) f11) <= 0.0d ? (f11 % 360.0f) + 360.0f : f11) % 360.0f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaOrientation)) {
            return false;
        }
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) obj;
        return Float.floatToIntBits(this.f10110a) == Float.floatToIntBits(streetViewPanoramaOrientation.f10110a) && Float.floatToIntBits(this.f10111b) == Float.floatToIntBits(streetViewPanoramaOrientation.f10111b);
    }

    public int hashCode() {
        return h.b(Float.valueOf(this.f10110a), Float.valueOf(this.f10111b));
    }

    public String toString() {
        return h.c(this).a("tilt", Float.valueOf(this.f10110a)).a("bearing", Float.valueOf(this.f10111b)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = c6.a.a(parcel);
        c6.a.i(parcel, 2, this.f10110a);
        c6.a.i(parcel, 3, this.f10111b);
        c6.a.b(parcel, a10);
    }
}
