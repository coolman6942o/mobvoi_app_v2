package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.z0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new z0();

    /* renamed from: a  reason: collision with root package name */
    private byte f10298a;

    /* renamed from: b  reason: collision with root package name */
    private final byte f10299b;

    /* renamed from: c  reason: collision with root package name */
    private final String f10300c;

    public zzi(byte b10, byte b11, String str) {
        this.f10298a = b10;
        this.f10299b = b11;
        this.f10300c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzi.class != obj.getClass()) {
            return false;
        }
        zzi zziVar = (zzi) obj;
        return this.f10298a == zziVar.f10298a && this.f10299b == zziVar.f10299b && this.f10300c.equals(zziVar.f10300c);
    }

    public final int hashCode() {
        return ((((this.f10298a + 31) * 31) + this.f10299b) * 31) + this.f10300c.hashCode();
    }

    public final String toString() {
        byte b10 = this.f10298a;
        byte b11 = this.f10299b;
        String str = this.f10300c;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 73);
        sb2.append("AmsEntityUpdateParcelable{, mEntityId=");
        sb2.append((int) b10);
        sb2.append(", mAttributeId=");
        sb2.append((int) b11);
        sb2.append(", mValue='");
        sb2.append(str);
        sb2.append('\'');
        sb2.append('}');
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.e(parcel, 2, this.f10298a);
        a.e(parcel, 3, this.f10299b);
        a.t(parcel, 4, this.f10300c, false);
        a.b(parcel, a10);
    }
}
