package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import w6.g;
/* loaded from: classes.dex */
public final class LocationSettingsStates extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new g();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f9945a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f9946b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f9947c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f9948d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f9949e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f9950f;

    public LocationSettingsStates(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        this.f9945a = z10;
        this.f9946b = z11;
        this.f9947c = z12;
        this.f9948d = z13;
        this.f9949e = z14;
        this.f9950f = z15;
    }

    public final boolean G0() {
        return this.f9950f;
    }

    public final boolean H0() {
        return this.f9947c;
    }

    public final boolean I0() {
        return this.f9948d;
    }

    public final boolean J0() {
        return this.f9945a;
    }

    public final boolean K0() {
        return this.f9949e;
    }

    public final boolean L0() {
        return this.f9946b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.c(parcel, 1, J0());
        a.c(parcel, 2, L0());
        a.c(parcel, 3, H0());
        a.c(parcel, 4, I0());
        a.c(parcel, 5, K0());
        a.c(parcel, 6, G0());
        a.b(parcel, a10);
    }
}
