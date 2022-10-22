package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class PolygonOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PolygonOptions> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final List<LatLng> f10080a;

    /* renamed from: b  reason: collision with root package name */
    private final List<List<LatLng>> f10081b;

    /* renamed from: c  reason: collision with root package name */
    private float f10082c;

    /* renamed from: d  reason: collision with root package name */
    private int f10083d;

    /* renamed from: e  reason: collision with root package name */
    private int f10084e;

    /* renamed from: f  reason: collision with root package name */
    private float f10085f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10086g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10087h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10088i;

    /* renamed from: j  reason: collision with root package name */
    private int f10089j;

    /* renamed from: k  reason: collision with root package name */
    private List<PatternItem> f10090k;

    public PolygonOptions() {
        this.f10082c = 10.0f;
        this.f10083d = -16777216;
        this.f10084e = 0;
        this.f10085f = 0.0f;
        this.f10086g = true;
        this.f10087h = false;
        this.f10088i = false;
        this.f10089j = 0;
        this.f10090k = null;
        this.f10080a = new ArrayList();
        this.f10081b = new ArrayList();
    }

    public final PolygonOptions G0(Iterable<LatLng> iterable) {
        for (LatLng latLng : iterable) {
            this.f10080a.add(latLng);
        }
        return this;
    }

    public final PolygonOptions H0(int i10) {
        this.f10084e = i10;
        return this;
    }

    public final int I0() {
        return this.f10084e;
    }

    public final List<LatLng> J0() {
        return this.f10080a;
    }

    public final int K0() {
        return this.f10083d;
    }

    public final int L0() {
        return this.f10089j;
    }

    public final List<PatternItem> M0() {
        return this.f10090k;
    }

    public final float N0() {
        return this.f10082c;
    }

    public final float O0() {
        return this.f10085f;
    }

    public final boolean P0() {
        return this.f10088i;
    }

    public final boolean Q0() {
        return this.f10087h;
    }

    public final boolean R0() {
        return this.f10086g;
    }

    public final PolygonOptions S0(float f10) {
        this.f10082c = f10;
        return this;
    }

    public final PolygonOptions T0(float f10) {
        this.f10085f = f10;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.x(parcel, 2, J0(), false);
        a.n(parcel, 3, this.f10081b, false);
        a.i(parcel, 4, N0());
        a.l(parcel, 5, K0());
        a.l(parcel, 6, I0());
        a.i(parcel, 7, O0());
        a.c(parcel, 8, R0());
        a.c(parcel, 9, Q0());
        a.c(parcel, 10, P0());
        a.l(parcel, 11, L0());
        a.x(parcel, 12, M0(), false);
        a.b(parcel, a10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PolygonOptions(List<LatLng> list, List list2, float f10, int i10, int i11, float f11, boolean z10, boolean z11, boolean z12, int i12, List<PatternItem> list3) {
        this.f10082c = 10.0f;
        this.f10083d = -16777216;
        this.f10084e = 0;
        this.f10085f = 0.0f;
        this.f10086g = true;
        this.f10087h = false;
        this.f10088i = false;
        this.f10089j = 0;
        this.f10090k = null;
        this.f10080a = list;
        this.f10081b = list2;
        this.f10082c = f10;
        this.f10083d = i10;
        this.f10084e = i11;
        this.f10085f = f11;
        this.f10086g = z10;
        this.f10087h = z11;
        this.f10088i = z12;
        this.f10089j = i12;
        this.f10090k = list3;
    }
}
