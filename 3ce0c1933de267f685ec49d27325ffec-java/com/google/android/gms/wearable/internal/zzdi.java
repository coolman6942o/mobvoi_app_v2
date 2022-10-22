package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
/* loaded from: classes.dex */
public final class zzdi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdi> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    public final int f10247a;

    /* renamed from: b  reason: collision with root package name */
    public final List<zzah> f10248b;

    public zzdi(int i10, List<zzah> list) {
        this.f10247a = i10;
        this.f10248b = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10247a);
        a.x(parcel, 3, this.f10248b, false);
        a.b(parcel, a10);
    }
}
