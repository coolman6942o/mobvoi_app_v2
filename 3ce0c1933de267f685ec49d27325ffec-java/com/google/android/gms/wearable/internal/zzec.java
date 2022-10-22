package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.a0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzec extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzec> CREATOR = new a0();

    /* renamed from: a  reason: collision with root package name */
    public final int f10268a;

    /* renamed from: b  reason: collision with root package name */
    public final zzdd f10269b;

    public zzec(int i10, zzdd zzddVar) {
        this.f10268a = i10;
        this.f10269b = zzddVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10268a);
        a.r(parcel, 3, this.f10269b, i10, false);
        a.b(parcel, a10);
    }
}
