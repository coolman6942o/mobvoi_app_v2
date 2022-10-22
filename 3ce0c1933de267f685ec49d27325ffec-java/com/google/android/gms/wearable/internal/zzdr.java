package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.u;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzdr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdr> CREATOR = new u();

    /* renamed from: a  reason: collision with root package name */
    private final int f10255a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f10256b;

    public zzdr(int i10, boolean z10) {
        this.f10255a = i10;
        this.f10256b = z10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10255a);
        a.c(parcel, 3, this.f10256b);
        a.b(parcel, a10);
    }
}
