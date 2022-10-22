package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.c0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzeg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzeg> CREATOR = new c0();

    /* renamed from: a  reason: collision with root package name */
    public final int f10272a;

    /* renamed from: b  reason: collision with root package name */
    public final zzfo f10273b;

    public zzeg(int i10, zzfo zzfoVar) {
        this.f10272a = i10;
        this.f10273b = zzfoVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10272a);
        a.r(parcel, 3, this.f10273b, i10, false);
        a.b(parcel, a10);
    }
}
