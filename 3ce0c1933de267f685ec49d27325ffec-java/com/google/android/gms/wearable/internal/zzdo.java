package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import c6.a;
import c7.t;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzdo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdo> CREATOR = new t();

    /* renamed from: a  reason: collision with root package name */
    public final int f10253a;

    /* renamed from: b  reason: collision with root package name */
    public final ParcelFileDescriptor f10254b;

    public zzdo(int i10, ParcelFileDescriptor parcelFileDescriptor) {
        this.f10253a = i10;
        this.f10254b = parcelFileDescriptor;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10253a);
        a.r(parcel, 3, this.f10254b, i10, false);
        a.b(parcel, a10);
    }
}
