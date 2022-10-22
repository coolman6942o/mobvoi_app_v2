package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import z6.j;
/* loaded from: classes.dex */
public class PatternItem extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PatternItem> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    private final int f10075a;

    /* renamed from: b  reason: collision with root package name */
    private final Float f10076b;

    public PatternItem(int i10, Float f10) {
        boolean z10 = true;
        if (i10 != 1 && (f10 == null || f10.floatValue() < 0.0f)) {
            z10 = false;
        }
        String valueOf = String.valueOf(f10);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 45);
        sb2.append("Invalid PatternItem: type=");
        sb2.append(i10);
        sb2.append(" length=");
        sb2.append(valueOf);
        i.b(z10, sb2.toString());
        this.f10075a = i10;
        this.f10076b = f10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PatternItem)) {
            return false;
        }
        PatternItem patternItem = (PatternItem) obj;
        return this.f10075a == patternItem.f10075a && h.a(this.f10076b, patternItem.f10076b);
    }

    public int hashCode() {
        return h.b(Integer.valueOf(this.f10075a), this.f10076b);
    }

    public String toString() {
        int i10 = this.f10075a;
        String valueOf = String.valueOf(this.f10076b);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 39);
        sb2.append("[PatternItem: type=");
        sb2.append(i10);
        sb2.append(" length=");
        sb2.append(valueOf);
        sb2.append("]");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10075a);
        a.j(parcel, 3, this.f10076b, false);
        a.b(parcel, a10);
    }
}
