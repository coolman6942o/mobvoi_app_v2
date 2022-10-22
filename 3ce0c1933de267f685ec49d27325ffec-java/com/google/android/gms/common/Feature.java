package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.mobvoi.wear.contacts.ContactConstant;
import z5.d;
/* loaded from: classes.dex */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    private final String f8436a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    private final int f8437b;

    /* renamed from: c  reason: collision with root package name */
    private final long f8438c;

    public Feature(String str, int i10, long j10) {
        this.f8436a = str;
        this.f8437b = i10;
        this.f8438c = j10;
    }

    public long G0() {
        long j10 = this.f8438c;
        return j10 == -1 ? this.f8437b : j10;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((getName() != null && getName().equals(feature.getName())) || (getName() == null && feature.getName() == null)) && G0() == feature.G0()) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return this.f8436a;
    }

    public int hashCode() {
        return h.b(getName(), Long.valueOf(G0()));
    }

    public String toString() {
        return h.c(this).a(ContactConstant.CallsRecordKeys.NAME, getName()).a("version", Long.valueOf(G0())).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.t(parcel, 1, getName(), false);
        a.l(parcel, 2, this.f8437b);
        a.o(parcel, 3, G0());
        a.b(parcel, a10);
    }
}
