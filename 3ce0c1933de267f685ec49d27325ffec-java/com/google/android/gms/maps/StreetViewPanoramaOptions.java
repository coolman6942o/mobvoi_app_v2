package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;
import y6.e;
/* loaded from: classes.dex */
public final class StreetViewPanoramaOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOptions> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private StreetViewPanoramaCamera f10001a;

    /* renamed from: b  reason: collision with root package name */
    private String f10002b;

    /* renamed from: c  reason: collision with root package name */
    private LatLng f10003c;

    /* renamed from: d  reason: collision with root package name */
    private Integer f10004d;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f10005e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f10006f;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f10007g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f10008h;

    /* renamed from: i  reason: collision with root package name */
    private Boolean f10009i;

    /* renamed from: j  reason: collision with root package name */
    private StreetViewSource f10010j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreetViewPanoramaOptions(StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b10, byte b11, byte b12, byte b13, byte b14, StreetViewSource streetViewSource) {
        Boolean bool = Boolean.TRUE;
        this.f10005e = bool;
        this.f10006f = bool;
        this.f10007g = bool;
        this.f10008h = bool;
        this.f10010j = StreetViewSource.f10114b;
        this.f10001a = streetViewPanoramaCamera;
        this.f10003c = latLng;
        this.f10004d = num;
        this.f10002b = str;
        this.f10005e = e.b(b10);
        this.f10006f = e.b(b11);
        this.f10007g = e.b(b12);
        this.f10008h = e.b(b13);
        this.f10009i = e.b(b14);
        this.f10010j = streetViewSource;
    }

    public final String G0() {
        return this.f10002b;
    }

    public final LatLng H0() {
        return this.f10003c;
    }

    public final Integer I0() {
        return this.f10004d;
    }

    public final StreetViewSource J0() {
        return this.f10010j;
    }

    public final StreetViewPanoramaCamera K0() {
        return this.f10001a;
    }

    public final String toString() {
        return h.c(this).a("PanoramaId", this.f10002b).a("Position", this.f10003c).a("Radius", this.f10004d).a("Source", this.f10010j).a("StreetViewPanoramaCamera", this.f10001a).a("UserNavigationEnabled", this.f10005e).a("ZoomGesturesEnabled", this.f10006f).a("PanningGesturesEnabled", this.f10007g).a("StreetNamesEnabled", this.f10008h).a("UseViewLifecycleInFragment", this.f10009i).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.r(parcel, 2, K0(), i10, false);
        a.t(parcel, 3, G0(), false);
        a.r(parcel, 4, H0(), i10, false);
        a.m(parcel, 5, I0(), false);
        a.e(parcel, 6, e.a(this.f10005e));
        a.e(parcel, 7, e.a(this.f10006f));
        a.e(parcel, 8, e.a(this.f10007g));
        a.e(parcel, 9, e.a(this.f10008h));
        a.e(parcel, 10, e.a(this.f10009i));
        a.r(parcel, 11, J0(), i10, false);
        a.b(parcel, a10);
    }

    public StreetViewPanoramaOptions() {
        Boolean bool = Boolean.TRUE;
        this.f10005e = bool;
        this.f10006f = bool;
        this.f10007g = bool;
        this.f10008h = bool;
        this.f10010j = StreetViewSource.f10114b;
    }
}
