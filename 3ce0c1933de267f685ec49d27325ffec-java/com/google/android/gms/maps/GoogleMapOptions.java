package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import y6.e;
/* loaded from: classes.dex */
public final class GoogleMapOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private Boolean f9975a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f9976b;

    /* renamed from: c  reason: collision with root package name */
    private int f9977c;

    /* renamed from: d  reason: collision with root package name */
    private CameraPosition f9978d;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f9979e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f9980f;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f9981g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f9982h;

    /* renamed from: i  reason: collision with root package name */
    private Boolean f9983i;

    /* renamed from: j  reason: collision with root package name */
    private Boolean f9984j;

    /* renamed from: k  reason: collision with root package name */
    private Boolean f9985k;

    /* renamed from: l  reason: collision with root package name */
    private Boolean f9986l;

    /* renamed from: m  reason: collision with root package name */
    private Boolean f9987m;

    /* renamed from: n  reason: collision with root package name */
    private Float f9988n;

    /* renamed from: o  reason: collision with root package name */
    private Float f9989o;

    /* renamed from: p  reason: collision with root package name */
    private LatLngBounds f9990p;

    /* renamed from: q  reason: collision with root package name */
    private Boolean f9991q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleMapOptions(byte b10, byte b11, int i10, CameraPosition cameraPosition, byte b12, byte b13, byte b14, byte b15, byte b16, byte b17, byte b18, byte b19, byte b20, Float f10, Float f11, LatLngBounds latLngBounds, byte b21) {
        this.f9977c = -1;
        this.f9988n = null;
        this.f9989o = null;
        this.f9990p = null;
        this.f9975a = e.b(b10);
        this.f9976b = e.b(b11);
        this.f9977c = i10;
        this.f9978d = cameraPosition;
        this.f9979e = e.b(b12);
        this.f9980f = e.b(b13);
        this.f9981g = e.b(b14);
        this.f9982h = e.b(b15);
        this.f9983i = e.b(b16);
        this.f9984j = e.b(b17);
        this.f9985k = e.b(b18);
        this.f9986l = e.b(b19);
        this.f9987m = e.b(b20);
        this.f9988n = f10;
        this.f9989o = f11;
        this.f9990p = latLngBounds;
        this.f9991q = e.b(b21);
    }

    public static GoogleMapOptions J0(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, x6.e.f36462a);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        int i10 = x6.e.f36476o;
        if (obtainAttributes.hasValue(i10)) {
            googleMapOptions.S0(obtainAttributes.getInt(i10, -1));
        }
        int i11 = x6.e.f36486y;
        if (obtainAttributes.hasValue(i11)) {
            googleMapOptions.a1(obtainAttributes.getBoolean(i11, false));
        }
        int i12 = x6.e.f36485x;
        if (obtainAttributes.hasValue(i12)) {
            googleMapOptions.Z0(obtainAttributes.getBoolean(i12, false));
        }
        int i13 = x6.e.f36477p;
        if (obtainAttributes.hasValue(i13)) {
            googleMapOptions.I0(obtainAttributes.getBoolean(i13, true));
        }
        int i14 = x6.e.f36479r;
        if (obtainAttributes.hasValue(i14)) {
            googleMapOptions.V0(obtainAttributes.getBoolean(i14, true));
        }
        int i15 = x6.e.f36481t;
        if (obtainAttributes.hasValue(i15)) {
            googleMapOptions.X0(obtainAttributes.getBoolean(i15, true));
        }
        int i16 = x6.e.f36480s;
        if (obtainAttributes.hasValue(i16)) {
            googleMapOptions.W0(obtainAttributes.getBoolean(i16, true));
        }
        int i17 = x6.e.f36482u;
        if (obtainAttributes.hasValue(i17)) {
            googleMapOptions.Y0(obtainAttributes.getBoolean(i17, true));
        }
        int i18 = x6.e.f36484w;
        if (obtainAttributes.hasValue(i18)) {
            googleMapOptions.c1(obtainAttributes.getBoolean(i18, true));
        }
        int i19 = x6.e.f36483v;
        if (obtainAttributes.hasValue(i19)) {
            googleMapOptions.b1(obtainAttributes.getBoolean(i19, true));
        }
        int i20 = x6.e.f36475n;
        if (obtainAttributes.hasValue(i20)) {
            googleMapOptions.Q0(obtainAttributes.getBoolean(i20, false));
        }
        int i21 = x6.e.f36478q;
        if (obtainAttributes.hasValue(i21)) {
            googleMapOptions.R0(obtainAttributes.getBoolean(i21, true));
        }
        int i22 = x6.e.f36463b;
        if (obtainAttributes.hasValue(i22)) {
            googleMapOptions.G0(obtainAttributes.getBoolean(i22, false));
        }
        int i23 = x6.e.f36466e;
        if (obtainAttributes.hasValue(i23)) {
            googleMapOptions.U0(obtainAttributes.getFloat(i23, Float.NEGATIVE_INFINITY));
        }
        if (obtainAttributes.hasValue(i23)) {
            googleMapOptions.T0(obtainAttributes.getFloat(x6.e.f36465d, Float.POSITIVE_INFINITY));
        }
        googleMapOptions.P0(d1(context, attributeSet));
        googleMapOptions.H0(e1(context, attributeSet));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public static LatLngBounds d1(Context context, AttributeSet attributeSet) {
        Float f10;
        Float f11;
        Float f12;
        Float f13;
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, x6.e.f36462a);
        int i10 = x6.e.f36473l;
        if (obtainAttributes.hasValue(i10)) {
            f10 = Float.valueOf(obtainAttributes.getFloat(i10, 0.0f));
        } else {
            f10 = null;
        }
        int i11 = x6.e.f36474m;
        if (obtainAttributes.hasValue(i11)) {
            f11 = Float.valueOf(obtainAttributes.getFloat(i11, 0.0f));
        } else {
            f11 = null;
        }
        int i12 = x6.e.f36471j;
        if (obtainAttributes.hasValue(i12)) {
            f12 = Float.valueOf(obtainAttributes.getFloat(i12, 0.0f));
        } else {
            f12 = null;
        }
        int i13 = x6.e.f36472k;
        if (obtainAttributes.hasValue(i13)) {
            f13 = Float.valueOf(obtainAttributes.getFloat(i13, 0.0f));
        } else {
            f13 = null;
        }
        obtainAttributes.recycle();
        if (f10 == null || f11 == null || f12 == null || f13 == null) {
            return null;
        }
        return new LatLngBounds(new LatLng(f10.floatValue(), f11.floatValue()), new LatLng(f12.floatValue(), f13.floatValue()));
    }

    public static CameraPosition e1(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, x6.e.f36462a);
        int i10 = x6.e.f36467f;
        float f10 = obtainAttributes.hasValue(i10) ? obtainAttributes.getFloat(i10, 0.0f) : 0.0f;
        int i11 = x6.e.f36468g;
        LatLng latLng = new LatLng(f10, obtainAttributes.hasValue(i11) ? obtainAttributes.getFloat(i11, 0.0f) : 0.0f);
        CameraPosition.a G0 = CameraPosition.G0();
        G0.c(latLng);
        int i12 = x6.e.f36470i;
        if (obtainAttributes.hasValue(i12)) {
            G0.e(obtainAttributes.getFloat(i12, 0.0f));
        }
        int i13 = x6.e.f36464c;
        if (obtainAttributes.hasValue(i13)) {
            G0.a(obtainAttributes.getFloat(i13, 0.0f));
        }
        int i14 = x6.e.f36469h;
        if (obtainAttributes.hasValue(i14)) {
            G0.d(obtainAttributes.getFloat(i14, 0.0f));
        }
        obtainAttributes.recycle();
        return G0.b();
    }

    public final GoogleMapOptions G0(boolean z10) {
        this.f9987m = Boolean.valueOf(z10);
        return this;
    }

    public final GoogleMapOptions H0(CameraPosition cameraPosition) {
        this.f9978d = cameraPosition;
        return this;
    }

    public final GoogleMapOptions I0(boolean z10) {
        this.f9980f = Boolean.valueOf(z10);
        return this;
    }

    public final CameraPosition K0() {
        return this.f9978d;
    }

    public final LatLngBounds L0() {
        return this.f9990p;
    }

    public final int M0() {
        return this.f9977c;
    }

    public final Float N0() {
        return this.f9989o;
    }

    public final Float O0() {
        return this.f9988n;
    }

    public final GoogleMapOptions P0(LatLngBounds latLngBounds) {
        this.f9990p = latLngBounds;
        return this;
    }

    public final GoogleMapOptions Q0(boolean z10) {
        this.f9985k = Boolean.valueOf(z10);
        return this;
    }

    public final GoogleMapOptions R0(boolean z10) {
        this.f9986l = Boolean.valueOf(z10);
        return this;
    }

    public final GoogleMapOptions S0(int i10) {
        this.f9977c = i10;
        return this;
    }

    public final GoogleMapOptions T0(float f10) {
        this.f9989o = Float.valueOf(f10);
        return this;
    }

    public final GoogleMapOptions U0(float f10) {
        this.f9988n = Float.valueOf(f10);
        return this;
    }

    public final GoogleMapOptions V0(boolean z10) {
        this.f9984j = Boolean.valueOf(z10);
        return this;
    }

    public final GoogleMapOptions W0(boolean z10) {
        this.f9981g = Boolean.valueOf(z10);
        return this;
    }

    public final GoogleMapOptions X0(boolean z10) {
        this.f9991q = Boolean.valueOf(z10);
        return this;
    }

    public final GoogleMapOptions Y0(boolean z10) {
        this.f9983i = Boolean.valueOf(z10);
        return this;
    }

    public final GoogleMapOptions Z0(boolean z10) {
        this.f9976b = Boolean.valueOf(z10);
        return this;
    }

    public final GoogleMapOptions a1(boolean z10) {
        this.f9975a = Boolean.valueOf(z10);
        return this;
    }

    public final GoogleMapOptions b1(boolean z10) {
        this.f9979e = Boolean.valueOf(z10);
        return this;
    }

    public final GoogleMapOptions c1(boolean z10) {
        this.f9982h = Boolean.valueOf(z10);
        return this;
    }

    public final String toString() {
        return h.c(this).a("MapType", Integer.valueOf(this.f9977c)).a("LiteMode", this.f9985k).a("Camera", this.f9978d).a("CompassEnabled", this.f9980f).a("ZoomControlsEnabled", this.f9979e).a("ScrollGesturesEnabled", this.f9981g).a("ZoomGesturesEnabled", this.f9982h).a("TiltGesturesEnabled", this.f9983i).a("RotateGesturesEnabled", this.f9984j).a("ScrollGesturesEnabledDuringRotateOrZoom", this.f9991q).a("MapToolbarEnabled", this.f9986l).a("AmbientEnabled", this.f9987m).a("MinZoomPreference", this.f9988n).a("MaxZoomPreference", this.f9989o).a("LatLngBoundsForCameraTarget", this.f9990p).a("ZOrderOnTop", this.f9975a).a("UseViewLifecycleInFragment", this.f9976b).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.e(parcel, 2, e.a(this.f9975a));
        a.e(parcel, 3, e.a(this.f9976b));
        a.l(parcel, 4, M0());
        a.r(parcel, 5, K0(), i10, false);
        a.e(parcel, 6, e.a(this.f9979e));
        a.e(parcel, 7, e.a(this.f9980f));
        a.e(parcel, 8, e.a(this.f9981g));
        a.e(parcel, 9, e.a(this.f9982h));
        a.e(parcel, 10, e.a(this.f9983i));
        a.e(parcel, 11, e.a(this.f9984j));
        a.e(parcel, 12, e.a(this.f9985k));
        a.e(parcel, 14, e.a(this.f9986l));
        a.e(parcel, 15, e.a(this.f9987m));
        a.j(parcel, 16, O0(), false);
        a.j(parcel, 17, N0(), false);
        a.r(parcel, 18, L0(), i10, false);
        a.e(parcel, 19, e.a(this.f9991q));
        a.b(parcel, a10);
    }

    public GoogleMapOptions() {
        this.f9977c = -1;
        this.f9988n = null;
        this.f9989o = null;
        this.f9990p = null;
    }
}
