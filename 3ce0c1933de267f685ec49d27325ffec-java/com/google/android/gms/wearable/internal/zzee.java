package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import c6.a;
import c7.b0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzee extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzee> CREATOR = new b0();

    /* renamed from: a  reason: collision with root package name */
    public final int f10270a;

    /* renamed from: b  reason: collision with root package name */
    public final ParcelFileDescriptor f10271b;

    public zzee(int i10, ParcelFileDescriptor parcelFileDescriptor) {
        this.f10270a = i10;
        this.f10271b = parcelFileDescriptor;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10270a);
        a.r(parcel, 3, this.f10271b, i10 | 1, false);
        a.b(parcel, a10);
    }
}
