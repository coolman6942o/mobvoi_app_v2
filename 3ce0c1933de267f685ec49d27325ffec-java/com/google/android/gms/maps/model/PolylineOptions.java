package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class PolylineOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PolylineOptions> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    private final List<LatLng> f10091a;

    /* renamed from: b  reason: collision with root package name */
    private float f10092b;

    /* renamed from: c  reason: collision with root package name */
    private int f10093c;

    /* renamed from: d  reason: collision with root package name */
    private float f10094d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10095e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10096f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10097g;

    /* renamed from: h  reason: collision with root package name */
    private Cap f10098h;

    /* renamed from: i  reason: collision with root package name */
    private Cap f10099i;

    /* renamed from: j  reason: collision with root package name */
    private int f10100j;

    /* renamed from: k  reason: collision with root package name */
    private List<PatternItem> f10101k;

    public PolylineOptions() {
        this.f10092b = 10.0f;
        this.f10093c = -16777216;
        this.f10094d = 0.0f;
        this.f10095e = true;
        this.f10096f = false;
        this.f10097g = false;
        this.f10098h = new ButtCap();
        this.f10099i = new ButtCap();
        this.f10100j = 0;
        this.f10101k = null;
        this.f10091a = new ArrayList();
    }

    public final PolylineOptions G0(LatLng latLng) {
        this.f10091a.add(latLng);
        return this;
    }

    public final PolylineOptions H0(int i10) {
        this.f10093c = i10;
        return this;
    }

    public final int I0() {
        return this.f10093c;
    }

    public final Cap J0() {
        return this.f10099i;
    }

    public final int K0() {
        return this.f10100j;
    }

    public final List<PatternItem> L0() {
        return this.f10101k;
    }

    public final List<LatLng> M0() {
        return this.f10091a;
    }

    public final Cap N0() {
        return this.f10098h;
    }

    public final float O0() {
        return this.f10092b;
    }

    public final float P0() {
        return this.f10094d;
    }

    public final boolean Q0() {
        return this.f10097g;
    }

    public final boolean R0() {
        return this.f10096f;
    }

    public final boolean S0() {
        return this.f10095e;
    }

    public final PolylineOptions T0(List<PatternItem> list) {
        this.f10101k = list;
        return this;
    }

    public final PolylineOptions U0(float f10) {
        this.f10092b = f10;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.x(parcel, 2, M0(), false);
        a.i(parcel, 3, O0());
        a.l(parcel, 4, I0());
        a.i(parcel, 5, P0());
        a.c(parcel, 6, S0());
        a.c(parcel, 7, R0());
        a.c(parcel, 8, Q0());
        a.r(parcel, 9, N0(), i10, false);
        a.r(parcel, 10, J0(), i10, false);
        a.l(parcel, 11, K0());
        a.x(parcel, 12, L0(), false);
        a.b(parcel, a10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PolylineOptions(List list, float f10, int i10, float f11, boolean z10, boolean z11, boolean z12, Cap cap, Cap cap2, int i11, List<PatternItem> list2) {
        this.f10092b = 10.0f;
        this.f10093c = -16777216;
        this.f10094d = 0.0f;
        this.f10095e = true;
        this.f10096f = false;
        this.f10097g = false;
        this.f10098h = new ButtCap();
        this.f10099i = new ButtCap();
        this.f10100j = 0;
        this.f10101k = null;
        this.f10091a = list;
        this.f10092b = f10;
        this.f10093c = i10;
        this.f10094d = f11;
        this.f10095e = z10;
        this.f10096f = z11;
        this.f10097g = z12;
        if (cap != null) {
            this.f10098h = cap;
        }
        if (cap2 != null) {
            this.f10099i = cap2;
        }
        this.f10100j = i11;
        this.f10101k = list2;
    }
}
