package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import w6.f;
/* loaded from: classes.dex */
public final class LocationSettingsResult extends AbstractSafeParcelable implements h {
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    private final Status f9943a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationSettingsStates f9944b;

    public LocationSettingsResult(Status status, LocationSettingsStates locationSettingsStates) {
        this.f9943a = status;
        this.f9944b = locationSettingsStates;
    }

    public final LocationSettingsStates G0() {
        return this.f9944b;
    }

    @Override // com.google.android.gms.common.api.h
    public final Status getStatus() {
        return this.f9943a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.r(parcel, 1, getStatus(), i10, false);
        a.r(parcel, 2, G0(), i10, false);
        a.b(parcel, a10);
    }
}
