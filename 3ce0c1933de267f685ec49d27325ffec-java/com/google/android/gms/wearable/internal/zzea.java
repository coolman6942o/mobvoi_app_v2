package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.z;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
/* loaded from: classes.dex */
public final class zzea extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzea> CREATOR = new z();

    /* renamed from: a  reason: collision with root package name */
    public final int f10266a;

    /* renamed from: b  reason: collision with root package name */
    public final List<zzfo> f10267b;

    public zzea(int i10, List<zzfo> list) {
        this.f10266a = i10;
        this.f10267b = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10266a);
        a.x(parcel, 3, this.f10267b, false);
        a.b(parcel, a10);
    }
}
