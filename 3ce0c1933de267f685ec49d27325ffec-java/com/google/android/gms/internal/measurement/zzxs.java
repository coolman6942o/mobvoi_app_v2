package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzxs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxs> CREATOR = new l7();

    /* renamed from: a  reason: collision with root package name */
    private String f9899a;

    /* renamed from: b  reason: collision with root package name */
    private String f9900b;

    public zzxs(String str, String str2) {
        this.f9899a = str;
        this.f9900b = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.t(parcel, 2, this.f9899a, false);
        a.t(parcel, 3, this.f9900b, false);
        a.b(parcel, a10);
    }
}
