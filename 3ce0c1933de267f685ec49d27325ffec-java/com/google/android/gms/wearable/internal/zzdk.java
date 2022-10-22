package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.r;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzdk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdk> CREATOR = new r();

    /* renamed from: a  reason: collision with root package name */
    public final int f10249a;

    /* renamed from: b  reason: collision with root package name */
    public final zzah f10250b;

    public zzdk(int i10, zzah zzahVar) {
        this.f10249a = i10;
        this.f10250b = zzahVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10249a);
        a.r(parcel, 3, this.f10250b, i10, false);
        a.b(parcel, a10);
    }
}
