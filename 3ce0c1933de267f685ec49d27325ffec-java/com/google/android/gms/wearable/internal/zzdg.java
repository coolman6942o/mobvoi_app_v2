package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzdg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdg> CREATOR = new p();

    /* renamed from: a  reason: collision with root package name */
    public final int f10245a;

    /* renamed from: b  reason: collision with root package name */
    public final int f10246b;

    public zzdg(int i10, int i11) {
        this.f10245a = i10;
        this.f10246b = i11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10245a);
        a.l(parcel, 3, this.f10246b);
        a.b(parcel, a10);
    }
}
