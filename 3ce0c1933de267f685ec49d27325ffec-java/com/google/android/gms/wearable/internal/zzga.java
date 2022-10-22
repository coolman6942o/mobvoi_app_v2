package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.n0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzga extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzga> CREATOR = new n0();

    /* renamed from: a  reason: collision with root package name */
    public final int f10293a;

    /* renamed from: b  reason: collision with root package name */
    public final int f10294b;

    public zzga(int i10, int i11) {
        this.f10293a = i10;
        this.f10294b = i11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10293a);
        a.l(parcel, 3, this.f10294b);
        a.b(parcel, a10);
    }
}
