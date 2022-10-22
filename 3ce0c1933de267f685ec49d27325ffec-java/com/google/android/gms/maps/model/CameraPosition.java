package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import b6.i;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import z6.f;
/* loaded from: classes.dex */
public final class CameraPosition extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CameraPosition> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    public final LatLng f10016a;

    /* renamed from: b  reason: collision with root package name */
    public final float f10017b;

    /* renamed from: c  reason: collision with root package name */
    public final float f10018c;

    /* renamed from: d  reason: collision with root package name */
    public final float f10019d;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private LatLng f10020a;

        /* renamed from: b  reason: collision with root package name */
        private float f10021b;

        /* renamed from: c  reason: collision with root package name */
        private float f10022c;

        /* renamed from: d  reason: collision with root package name */
        private float f10023d;

        public final a a(float f10) {
            this.f10023d = f10;
            return this;
        }

        public final CameraPosition b() {
            return new CameraPosition(this.f10020a, this.f10021b, this.f10022c, this.f10023d);
        }

        public final a c(LatLng latLng) {
            this.f10020a = latLng;
            return this;
        }

        public final a d(float f10) {
            this.f10022c = f10;
            return this;
        }

        public final a e(float f10) {
            this.f10021b = f10;
            return this;
        }
    }

    public CameraPosition(LatLng latLng, float f10, float f11, float f12) {
        i.l(latLng, "null camera target");
        i.c(0.0f <= f11 && f11 <= 90.0f, "Tilt needs to be between 0 and 90 inclusive: %s", Float.valueOf(f11));
        this.f10016a = latLng;
        this.f10017b = f10;
        this.f10018c = f11 + 0.0f;
        this.f10019d = (((double) f12) <= 0.0d ? (f12 % 360.0f) + 360.0f : f12) % 360.0f;
    }

    public static a G0() {
        return new a();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.f10016a.equals(cameraPosition.f10016a) && Float.floatToIntBits(this.f10017b) == Float.floatToIntBits(cameraPosition.f10017b) && Float.floatToIntBits(this.f10018c) == Float.floatToIntBits(cameraPosition.f10018c) && Float.floatToIntBits(this.f10019d) == Float.floatToIntBits(cameraPosition.f10019d);
    }

    public final int hashCode() {
        return h.b(this.f10016a, Float.valueOf(this.f10017b), Float.valueOf(this.f10018c), Float.valueOf(this.f10019d));
    }

    public final String toString() {
        return h.c(this).a("target", this.f10016a).a("zoom", Float.valueOf(this.f10017b)).a("tilt", Float.valueOf(this.f10018c)).a("bearing", Float.valueOf(this.f10019d)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c6.a.a(parcel);
        c6.a.r(parcel, 2, this.f10016a, i10, false);
        c6.a.i(parcel, 3, this.f10017b);
        c6.a.i(parcel, 4, this.f10018c);
        c6.a.i(parcel, 5, this.f10019d);
        c6.a.b(parcel, a10);
    }
}
