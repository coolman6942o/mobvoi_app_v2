package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.x;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;
@Deprecated
/* loaded from: classes.dex */
public final class zzdw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdw> CREATOR = new x();

    /* renamed from: a  reason: collision with root package name */
    private final int f10262a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectionConfiguration f10263b;

    public zzdw(int i10, ConnectionConfiguration connectionConfiguration) {
        this.f10262a = i10;
        this.f10263b = connectionConfiguration;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10262a);
        a.r(parcel, 3, this.f10263b, i10, false);
        a.b(parcel, a10);
    }
}
