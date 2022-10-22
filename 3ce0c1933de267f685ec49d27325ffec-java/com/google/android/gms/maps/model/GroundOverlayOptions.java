package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k6.b;
import z6.a;
/* loaded from: classes.dex */
public final class GroundOverlayOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GroundOverlayOptions> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private a f10040a;

    /* renamed from: b  reason: collision with root package name */
    private LatLng f10041b;

    /* renamed from: c  reason: collision with root package name */
    private float f10042c;

    /* renamed from: d  reason: collision with root package name */
    private float f10043d;

    /* renamed from: e  reason: collision with root package name */
    private LatLngBounds f10044e;

    /* renamed from: f  reason: collision with root package name */
    private float f10045f;

    /* renamed from: g  reason: collision with root package name */
    private float f10046g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10047h;

    /* renamed from: i  reason: collision with root package name */
    private float f10048i;

    /* renamed from: j  reason: collision with root package name */
    private float f10049j;

    /* renamed from: k  reason: collision with root package name */
    private float f10050k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10051l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GroundOverlayOptions(IBinder iBinder, LatLng latLng, float f10, float f11, LatLngBounds latLngBounds, float f12, float f13, boolean z10, float f14, float f15, float f16, boolean z11) {
        this.f10047h = true;
        this.f10048i = 0.0f;
        this.f10049j = 0.5f;
        this.f10050k = 0.5f;
        this.f10051l = false;
        this.f10040a = new a(b.a.m1(iBinder));
        this.f10041b = latLng;
        this.f10042c = f10;
        this.f10043d = f11;
        this.f10044e = latLngBounds;
        this.f10045f = f12;
        this.f10046g = f13;
        this.f10047h = z10;
        this.f10048i = f14;
        this.f10049j = f15;
        this.f10050k = f16;
        this.f10051l = z11;
    }

    public final float G0() {
        return this.f10049j;
    }

    public final float H0() {
        return this.f10050k;
    }

    public final float I0() {
        return this.f10045f;
    }

    public final LatLngBounds J0() {
        return this.f10044e;
    }

    public final float K0() {
        return this.f10043d;
    }

    public final LatLng L0() {
        return this.f10041b;
    }

    public final float M0() {
        return this.f10048i;
    }

    public final float N0() {
        return this.f10042c;
    }

    public final float O0() {
        return this.f10046g;
    }

    public final boolean P0() {
        return this.f10051l;
    }

    public final boolean Q0() {
        return this.f10047h;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c6.a.a(parcel);
        c6.a.k(parcel, 2, this.f10040a.a().asBinder(), false);
        c6.a.r(parcel, 3, L0(), i10, false);
        c6.a.i(parcel, 4, N0());
        c6.a.i(parcel, 5, K0());
        c6.a.r(parcel, 6, J0(), i10, false);
        c6.a.i(parcel, 7, I0());
        c6.a.i(parcel, 8, O0());
        c6.a.c(parcel, 9, Q0());
        c6.a.i(parcel, 10, M0());
        c6.a.i(parcel, 11, G0());
        c6.a.i(parcel, 12, H0());
        c6.a.c(parcel, 13, P0());
        c6.a.b(parcel, a10);
    }

    public GroundOverlayOptions() {
        this.f10047h = true;
        this.f10048i = 0.0f;
        this.f10049j = 0.5f;
        this.f10050k = 0.5f;
        this.f10051l = false;
    }
}
