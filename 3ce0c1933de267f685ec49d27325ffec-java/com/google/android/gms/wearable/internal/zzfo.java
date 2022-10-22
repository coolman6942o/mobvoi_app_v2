package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.h0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wearable.j;
/* loaded from: classes.dex */
public final class zzfo extends AbstractSafeParcelable implements j {
    public static final Parcelable.Creator<zzfo> CREATOR = new h0();

    /* renamed from: a  reason: collision with root package name */
    private final String f10279a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10280b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10281c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f10282d;

    public zzfo(String str, String str2, int i10, boolean z10) {
        this.f10279a = str;
        this.f10280b = str2;
        this.f10281c = i10;
        this.f10282d = z10;
    }

    @Override // com.google.android.gms.wearable.j
    public final String Q() {
        return this.f10280b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfo)) {
            return false;
        }
        return ((zzfo) obj).f10279a.equals(this.f10279a);
    }

    @Override // com.google.android.gms.wearable.j
    public final String getId() {
        return this.f10279a;
    }

    public final int hashCode() {
        return this.f10279a.hashCode();
    }

    @Override // com.google.android.gms.wearable.j
    public final boolean j0() {
        return this.f10282d;
    }

    public final String toString() {
        String str = this.f10280b;
        String str2 = this.f10279a;
        int i10 = this.f10281c;
        boolean z10 = this.f10282d;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 45 + String.valueOf(str2).length());
        sb2.append("Node{");
        sb2.append(str);
        sb2.append(", id=");
        sb2.append(str2);
        sb2.append(", hops=");
        sb2.append(i10);
        sb2.append(", isNearby=");
        sb2.append(z10);
        sb2.append("}");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.t(parcel, 2, getId(), false);
        a.t(parcel, 3, Q(), false);
        a.l(parcel, 4, this.f10281c);
        a.c(parcel, 5, j0());
        a.b(parcel, a10);
    }
}
