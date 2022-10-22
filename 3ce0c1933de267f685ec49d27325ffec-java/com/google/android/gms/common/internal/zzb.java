package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new s();

    /* renamed from: a  reason: collision with root package name */
    Bundle f8969a;

    /* renamed from: b  reason: collision with root package name */
    Feature[] f8970b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(Bundle bundle, Feature[] featureArr) {
        this.f8969a = bundle;
        this.f8970b = featureArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.d(parcel, 1, this.f8969a, false);
        a.w(parcel, 2, this.f8970b, i10, false);
        a.b(parcel, a10);
    }

    public zzb() {
    }
}
