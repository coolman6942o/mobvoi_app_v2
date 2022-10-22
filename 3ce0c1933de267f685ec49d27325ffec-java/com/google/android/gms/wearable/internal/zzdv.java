package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.w;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzdv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdv> CREATOR = new w();

    /* renamed from: a  reason: collision with root package name */
    private final int f10260a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f10261b;

    public zzdv(int i10, boolean z10) {
        this.f10260a = i10;
        this.f10261b = z10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10260a);
        a.c(parcel, 3, this.f10261b);
        a.b(parcel, a10);
    }
}
