package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzeu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzeu> CREATOR = new o0();

    /* renamed from: a  reason: collision with root package name */
    public final String f9888a;

    /* renamed from: b  reason: collision with root package name */
    public final zzer f9889b;

    /* renamed from: c  reason: collision with root package name */
    public final String f9890c;

    /* renamed from: d  reason: collision with root package name */
    public final long f9891d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeu(zzeu zzeuVar, long j10) {
        i.k(zzeuVar);
        this.f9888a = zzeuVar.f9888a;
        this.f9889b = zzeuVar.f9889b;
        this.f9890c = zzeuVar.f9890c;
        this.f9891d = j10;
    }

    public zzeu(String str, zzer zzerVar, String str2, long j10) {
        this.f9888a = str;
        this.f9889b = zzerVar;
        this.f9890c = str2;
        this.f9891d = j10;
    }

    public final String toString() {
        String str = this.f9890c;
        String str2 = this.f9888a;
        String valueOf = String.valueOf(this.f9889b);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + valueOf.length());
        sb2.append("origin=");
        sb2.append(str);
        sb2.append(",name=");
        sb2.append(str2);
        sb2.append(",params=");
        sb2.append(valueOf);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.t(parcel, 2, this.f9888a, false);
        a.r(parcel, 3, this.f9889b, i10, false);
        a.t(parcel, 4, this.f9890c, false);
        a.o(parcel, 5, this.f9891d);
        a.b(parcel, a10);
    }
}
