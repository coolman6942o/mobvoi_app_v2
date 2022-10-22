package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import u6.d;
import u6.e;
/* loaded from: classes.dex */
public final class TileOverlayOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TileOverlayOptions> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    private d f10119a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f10120b;

    /* renamed from: c  reason: collision with root package name */
    private float f10121c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10122d;

    /* renamed from: e  reason: collision with root package name */
    private float f10123e;

    public TileOverlayOptions() {
        this.f10120b = true;
        this.f10122d = true;
        this.f10123e = 0.0f;
    }

    public final boolean G0() {
        return this.f10122d;
    }

    public final float H0() {
        return this.f10123e;
    }

    public final float I0() {
        return this.f10121c;
    }

    public final boolean J0() {
        return this.f10120b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.k(parcel, 2, this.f10119a.asBinder(), false);
        a.c(parcel, 3, J0());
        a.i(parcel, 4, I0());
        a.c(parcel, 5, G0());
        a.i(parcel, 6, H0());
        a.b(parcel, a10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TileOverlayOptions(IBinder iBinder, boolean z10, float f10, boolean z11, float f11) {
        this.f10120b = true;
        this.f10122d = true;
        this.f10123e = 0.0f;
        d m12 = e.m1(iBinder);
        this.f10119a = m12;
        if (m12 != null) {
            new g(this);
        }
        this.f10120b = z10;
        this.f10121c = f10;
        this.f10122d = z11;
        this.f10123e = f11;
    }
}
