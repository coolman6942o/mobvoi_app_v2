package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wearable.b;
import com.google.android.gms.wearable.j;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public final class zzah extends AbstractSafeParcelable implements b {
    public static final Parcelable.Creator<zzah> CREATOR = new c7.b();

    /* renamed from: b  reason: collision with root package name */
    private final String f10225b;

    /* renamed from: c  reason: collision with root package name */
    private final List<zzfo> f10226c;

    /* renamed from: a  reason: collision with root package name */
    private final Object f10224a = new Object();

    /* renamed from: d  reason: collision with root package name */
    private Set<j> f10227d = null;

    public zzah(String str, List<zzfo> list) {
        this.f10225b = str;
        this.f10226c = list;
        i.k(str);
        i.k(list);
    }

    @Override // com.google.android.gms.wearable.b
    public final Set<j> d() {
        Set<j> set;
        synchronized (this.f10224a) {
            if (this.f10227d == null) {
                this.f10227d = new HashSet(this.f10226c);
            }
            set = this.f10227d;
        }
        return set;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzah.class != obj.getClass()) {
            return false;
        }
        zzah zzahVar = (zzah) obj;
        String str = this.f10225b;
        if (str == null ? zzahVar.f10225b != null : !str.equals(zzahVar.f10225b)) {
            return false;
        }
        List<zzfo> list = this.f10226c;
        List<zzfo> list2 = zzahVar.f10226c;
        return list == null ? list2 == null : list.equals(list2);
    }

    @Override // com.google.android.gms.wearable.b
    public final String getName() {
        return this.f10225b;
    }

    public final int hashCode() {
        String str = this.f10225b;
        int i10 = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + 31) * 31;
        List<zzfo> list = this.f10226c;
        if (list != null) {
            i10 = list.hashCode();
        }
        return hashCode + i10;
    }

    public final String toString() {
        String str = this.f10225b;
        String valueOf = String.valueOf(this.f10226c);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 18 + valueOf.length());
        sb2.append("CapabilityInfo{");
        sb2.append(str);
        sb2.append(", ");
        sb2.append(valueOf);
        sb2.append("}");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.t(parcel, 2, getName(), false);
        a.x(parcel, 3, this.f10226c, false);
        a.b(parcel, a10);
    }
}
