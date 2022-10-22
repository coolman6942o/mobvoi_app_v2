package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import b6.i;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import z6.g;
/* loaded from: classes.dex */
public final class LatLngBounds extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new g();

    /* renamed from: a  reason: collision with root package name */
    public final LatLng f10054a;

    /* renamed from: b  reason: collision with root package name */
    public final LatLng f10055b;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private double f10056a = Double.POSITIVE_INFINITY;

        /* renamed from: b  reason: collision with root package name */
        private double f10057b = Double.NEGATIVE_INFINITY;

        /* renamed from: c  reason: collision with root package name */
        private double f10058c = Double.NaN;

        /* renamed from: d  reason: collision with root package name */
        private double f10059d = Double.NaN;

        public final LatLngBounds a() {
            i.o(!Double.isNaN(this.f10058c), "no included points");
            return new LatLngBounds(new LatLng(this.f10056a, this.f10058c), new LatLng(this.f10057b, this.f10059d));
        }

        public final a b(LatLng latLng) {
            this.f10056a = Math.min(this.f10056a, latLng.f10052a);
            this.f10057b = Math.max(this.f10057b, latLng.f10052a);
            double d10 = latLng.f10053b;
            if (Double.isNaN(this.f10058c)) {
                this.f10058c = d10;
            } else {
                double d11 = this.f10058c;
                double d12 = this.f10059d;
                boolean z10 = false;
                z10 = true;
                if (d11 > d12 ? d11 <= d10 || d10 <= d12 : d11 <= d10 && d10 <= d12) {
                }
                if (!z10) {
                    if (LatLngBounds.G0(d11, d10) < LatLngBounds.H0(this.f10059d, d10)) {
                        this.f10058c = d10;
                    }
                }
                return this;
            }
            this.f10059d = d10;
            return this;
        }
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        i.l(latLng, "null southwest");
        i.l(latLng2, "null northeast");
        double d10 = latLng2.f10052a;
        double d11 = latLng.f10052a;
        i.c(d10 >= d11, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(d11), Double.valueOf(latLng2.f10052a));
        this.f10054a = latLng;
        this.f10055b = latLng2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double G0(double d10, double d11) {
        return ((d10 - d11) + 360.0d) % 360.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double H0(double d10, double d11) {
        return ((d11 - d10) + 360.0d) % 360.0d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.f10054a.equals(latLngBounds.f10054a) && this.f10055b.equals(latLngBounds.f10055b);
    }

    public final int hashCode() {
        return h.b(this.f10054a, this.f10055b);
    }

    public final String toString() {
        return h.c(this).a("southwest", this.f10054a).a("northeast", this.f10055b).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c6.a.a(parcel);
        c6.a.r(parcel, 2, this.f10054a, i10, false);
        c6.a.r(parcel, 3, this.f10055b, i10, false);
        c6.a.b(parcel, a10);
    }
}
