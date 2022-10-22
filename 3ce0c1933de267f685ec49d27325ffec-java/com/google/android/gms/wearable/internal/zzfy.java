package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.l0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzfy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfy> CREATOR = new l0();

    /* renamed from: a  reason: collision with root package name */
    public final int f10292a;

    public zzfy(int i10) {
        this.f10292a = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10292a);
        a.b(parcel, a10);
    }
}
