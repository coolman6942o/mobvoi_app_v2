package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import z6.l;
/* loaded from: classes.dex */
public class StreetViewPanoramaCamera extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaCamera> CREATOR = new l();

    /* renamed from: a  reason: collision with root package name */
    public final float f10102a;

    /* renamed from: b  reason: collision with root package name */
    public final float f10103b;

    /* renamed from: c  reason: collision with root package name */
    public final float f10104c;

    public StreetViewPanoramaCamera(float f10, float f11, float f12) {
        boolean z10 = -90.0f <= f11 && f11 <= 90.0f;
        StringBuilder sb2 = new StringBuilder(62);
        sb2.append("Tilt needs to be between -90 and 90 inclusive: ");
        sb2.append(f11);
        i.b(z10, sb2.toString());
        this.f10102a = ((double) f10) <= 0.0d ? 0.0f : f10;
        this.f10103b = 0.0f + f11;
        this.f10104c = (((double) f12) <= 0.0d ? (f12 % 360.0f) + 360.0f : f12) % 360.0f;
        new StreetViewPanoramaOrientation.a().c(f11).a(f12).b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaCamera)) {
            return false;
        }
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) obj;
        return Float.floatToIntBits(this.f10102a) == Float.floatToIntBits(streetViewPanoramaCamera.f10102a) && Float.floatToIntBits(this.f10103b) == Float.floatToIntBits(streetViewPanoramaCamera.f10103b) && Float.floatToIntBits(this.f10104c) == Float.floatToIntBits(streetViewPanoramaCamera.f10104c);
    }

    public int hashCode() {
        return h.b(Float.valueOf(this.f10102a), Float.valueOf(this.f10103b), Float.valueOf(this.f10104c));
    }

    public String toString() {
        return h.c(this).a("zoom", Float.valueOf(this.f10102a)).a("tilt", Float.valueOf(this.f10103b)).a("bearing", Float.valueOf(this.f10104c)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.i(parcel, 2, this.f10102a);
        a.i(parcel, 3, this.f10103b);
        a.i(parcel, 4, this.f10104c);
        a.b(parcel, a10);
    }
}
