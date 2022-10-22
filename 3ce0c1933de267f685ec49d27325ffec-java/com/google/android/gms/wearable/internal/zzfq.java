package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.i0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzfq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfq> CREATOR = new i0();

    /* renamed from: a  reason: collision with root package name */
    public final int f10283a;

    /* renamed from: b  reason: collision with root package name */
    public final zzay f10284b;

    public zzfq(int i10, zzay zzayVar) {
        this.f10283a = i10;
        this.f10284b = zzayVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10283a);
        a.r(parcel, 3, this.f10284b, i10, false);
        a.b(parcel, a10);
    }
}
