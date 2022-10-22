package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import z6.i;
/* loaded from: classes.dex */
public final class MapStyleOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MapStyleOptions> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private String f10060a;

    public MapStyleOptions(String str) {
        this.f10060a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.t(parcel, 2, this.f10060a, false);
        a.b(parcel, a10);
    }
}
