package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.m0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new m0();

    /* renamed from: a  reason: collision with root package name */
    public final int f10274a;

    public zzf(int i10) {
        this.f10274a = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10274a);
        a.b(parcel, a10);
    }
}
