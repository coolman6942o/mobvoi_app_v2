package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import c6.a;
import c7.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzdm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdm> CREATOR = new s();

    /* renamed from: a  reason: collision with root package name */
    public final int f10251a;

    /* renamed from: b  reason: collision with root package name */
    public final ParcelFileDescriptor f10252b;

    public zzdm(int i10, ParcelFileDescriptor parcelFileDescriptor) {
        this.f10251a = i10;
        this.f10252b = parcelFileDescriptor;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10251a);
        a.r(parcel, 3, this.f10252b, i10, false);
        a.b(parcel, a10);
    }
}
