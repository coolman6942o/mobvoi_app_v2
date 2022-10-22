package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import z6.p;
/* loaded from: classes.dex */
public final class StreetViewSource extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewSource> CREATOR = new p();

    /* renamed from: b  reason: collision with root package name */
    public static final StreetViewSource f10114b = new StreetViewSource(0);

    /* renamed from: a  reason: collision with root package name */
    private final int f10115a;

    static {
        new StreetViewSource(1);
    }

    public StreetViewSource(int i10) {
        this.f10115a = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StreetViewSource) && this.f10115a == ((StreetViewSource) obj).f10115a;
    }

    public final int hashCode() {
        return h.b(Integer.valueOf(this.f10115a));
    }

    public final String toString() {
        String str;
        int i10 = this.f10115a;
        if (i10 != 0) {
            str = i10 != 1 ? String.format("UNKNOWN(%s)", Integer.valueOf(i10)) : "OUTDOOR";
        } else {
            str = "DEFAULT";
        }
        return String.format("StreetViewSource:%s", str);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10115a);
        a.b(parcel, a10);
    }
}
