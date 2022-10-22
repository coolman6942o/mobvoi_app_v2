package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k6.b;
import z6.a;
/* loaded from: classes.dex */
public final class MarkerOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MarkerOptions> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    private LatLng f10061a;

    /* renamed from: b  reason: collision with root package name */
    private String f10062b;

    /* renamed from: c  reason: collision with root package name */
    private String f10063c;

    /* renamed from: d  reason: collision with root package name */
    private a f10064d;

    /* renamed from: e  reason: collision with root package name */
    private float f10065e;

    /* renamed from: f  reason: collision with root package name */
    private float f10066f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10067g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10068h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10069i;

    /* renamed from: j  reason: collision with root package name */
    private float f10070j;

    /* renamed from: k  reason: collision with root package name */
    private float f10071k;

    /* renamed from: l  reason: collision with root package name */
    private float f10072l;

    /* renamed from: m  reason: collision with root package name */
    private float f10073m;

    /* renamed from: n  reason: collision with root package name */
    private float f10074n;

    public MarkerOptions() {
        this.f10065e = 0.5f;
        this.f10066f = 1.0f;
        this.f10068h = true;
        this.f10069i = false;
        this.f10070j = 0.0f;
        this.f10071k = 0.5f;
        this.f10072l = 0.0f;
        this.f10073m = 1.0f;
    }

    public final MarkerOptions G0(float f10, float f11) {
        this.f10065e = f10;
        this.f10066f = f11;
        return this;
    }

    public final MarkerOptions H0(boolean z10) {
        this.f10067g = z10;
        return this;
    }

    public final float I0() {
        return this.f10073m;
    }

    public final float J0() {
        return this.f10065e;
    }

    public final float K0() {
        return this.f10066f;
    }

    public final float L0() {
        return this.f10071k;
    }

    public final float M0() {
        return this.f10072l;
    }

    public final LatLng N0() {
        return this.f10061a;
    }

    public final float O0() {
        return this.f10070j;
    }

    public final String P0() {
        return this.f10063c;
    }

    public final String Q0() {
        return this.f10062b;
    }

    public final float R0() {
        return this.f10074n;
    }

    public final MarkerOptions S0(a aVar) {
        this.f10064d = aVar;
        return this;
    }

    public final boolean T0() {
        return this.f10067g;
    }

    public final boolean U0() {
        return this.f10069i;
    }

    public final boolean V0() {
        return this.f10068h;
    }

    public final MarkerOptions W0(LatLng latLng) {
        if (latLng != null) {
            this.f10061a = latLng;
            return this;
        }
        throw new IllegalArgumentException("latlng cannot be null - a position is required.");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c6.a.a(parcel);
        c6.a.r(parcel, 2, N0(), i10, false);
        c6.a.t(parcel, 3, Q0(), false);
        c6.a.t(parcel, 4, P0(), false);
        a aVar = this.f10064d;
        c6.a.k(parcel, 5, aVar == null ? null : aVar.a().asBinder(), false);
        c6.a.i(parcel, 6, J0());
        c6.a.i(parcel, 7, K0());
        c6.a.c(parcel, 8, T0());
        c6.a.c(parcel, 9, V0());
        c6.a.c(parcel, 10, U0());
        c6.a.i(parcel, 11, O0());
        c6.a.i(parcel, 12, L0());
        c6.a.i(parcel, 13, M0());
        c6.a.i(parcel, 14, I0());
        c6.a.i(parcel, 15, R0());
        c6.a.b(parcel, a10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MarkerOptions(LatLng latLng, String str, String str2, IBinder iBinder, float f10, float f11, boolean z10, boolean z11, boolean z12, float f12, float f13, float f14, float f15, float f16) {
        this.f10065e = 0.5f;
        this.f10066f = 1.0f;
        this.f10068h = true;
        this.f10069i = false;
        this.f10070j = 0.0f;
        this.f10071k = 0.5f;
        this.f10072l = 0.0f;
        this.f10073m = 1.0f;
        this.f10061a = latLng;
        this.f10062b = str;
        this.f10063c = str2;
        if (iBinder == null) {
            this.f10064d = null;
        } else {
            this.f10064d = new a(b.a.m1(iBinder));
        }
        this.f10065e = f10;
        this.f10066f = f11;
        this.f10067g = z10;
        this.f10068h = z11;
        this.f10069i = z12;
        this.f10070j = f12;
        this.f10071k = f13;
        this.f10072l = f14;
        this.f10073m = f15;
        this.f10074n = f16;
    }
}
