package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.y;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;
/* loaded from: classes.dex */
public final class zzdy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdy> CREATOR = new y();

    /* renamed from: a  reason: collision with root package name */
    private final int f10264a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectionConfiguration[] f10265b;

    public zzdy(int i10, ConnectionConfiguration[] connectionConfigurationArr) {
        this.f10264a = i10;
        this.f10265b = connectionConfigurationArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10264a);
        a.w(parcel, 3, this.f10265b, i10, false);
        a.b(parcel, a10);
    }
}
