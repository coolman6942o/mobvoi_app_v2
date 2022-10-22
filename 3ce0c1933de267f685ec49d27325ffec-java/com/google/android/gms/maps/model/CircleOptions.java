package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
/* loaded from: classes.dex */
public final class CircleOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CircleOptions> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private LatLng f10027a;

    /* renamed from: b  reason: collision with root package name */
    private double f10028b;

    /* renamed from: c  reason: collision with root package name */
    private float f10029c;

    /* renamed from: d  reason: collision with root package name */
    private int f10030d;

    /* renamed from: e  reason: collision with root package name */
    private int f10031e;

    /* renamed from: f  reason: collision with root package name */
    private float f10032f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10033g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10034h;

    /* renamed from: i  reason: collision with root package name */
    private List<PatternItem> f10035i;

    public CircleOptions() {
        this.f10027a = null;
        this.f10028b = 0.0d;
        this.f10029c = 10.0f;
        this.f10030d = -16777216;
        this.f10031e = 0;
        this.f10032f = 0.0f;
        this.f10033g = true;
        this.f10034h = false;
        this.f10035i = null;
    }

    public final LatLng G0() {
        return this.f10027a;
    }

    public final int H0() {
        return this.f10031e;
    }

    public final double I0() {
        return this.f10028b;
    }

    public final int J0() {
        return this.f10030d;
    }

    public final List<PatternItem> K0() {
        return this.f10035i;
    }

    public final float L0() {
        return this.f10029c;
    }

    public final float M0() {
        return this.f10032f;
    }

    public final boolean N0() {
        return this.f10034h;
    }

    public final boolean O0() {
        return this.f10033g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.r(parcel, 2, G0(), i10, false);
        a.g(parcel, 3, I0());
        a.i(parcel, 4, L0());
        a.l(parcel, 5, J0());
        a.l(parcel, 6, H0());
        a.i(parcel, 7, M0());
        a.c(parcel, 8, O0());
        a.c(parcel, 9, N0());
        a.x(parcel, 10, K0(), false);
        a.b(parcel, a10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircleOptions(LatLng latLng, double d10, float f10, int i10, int i11, float f11, boolean z10, boolean z11, List<PatternItem> list) {
        this.f10027a = null;
        this.f10028b = 0.0d;
        this.f10029c = 10.0f;
        this.f10030d = -16777216;
        this.f10031e = 0;
        this.f10032f = 0.0f;
        this.f10033g = true;
        this.f10034h = false;
        this.f10035i = null;
        this.f10027a = latLng;
        this.f10028b = d10;
        this.f10029c = f10;
        this.f10030d = i10;
        this.f10031e = i11;
        this.f10032f = f11;
        this.f10033g = z10;
        this.f10034h = z11;
        this.f10035i = list;
    }
}
