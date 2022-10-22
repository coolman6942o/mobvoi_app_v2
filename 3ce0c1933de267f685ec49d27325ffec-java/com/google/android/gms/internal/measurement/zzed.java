package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzed extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzed> CREATOR = new z();

    /* renamed from: a  reason: collision with root package name */
    public String f9876a;

    /* renamed from: b  reason: collision with root package name */
    public String f9877b;

    /* renamed from: c  reason: collision with root package name */
    public zzjx f9878c;

    /* renamed from: d  reason: collision with root package name */
    public long f9879d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9880e;

    /* renamed from: f  reason: collision with root package name */
    public String f9881f;

    /* renamed from: g  reason: collision with root package name */
    public zzeu f9882g;

    /* renamed from: h  reason: collision with root package name */
    public long f9883h;

    /* renamed from: i  reason: collision with root package name */
    public zzeu f9884i;

    /* renamed from: j  reason: collision with root package name */
    public long f9885j;

    /* renamed from: k  reason: collision with root package name */
    public zzeu f9886k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzed(zzed zzedVar) {
        i.k(zzedVar);
        this.f9876a = zzedVar.f9876a;
        this.f9877b = zzedVar.f9877b;
        this.f9878c = zzedVar.f9878c;
        this.f9879d = zzedVar.f9879d;
        this.f9880e = zzedVar.f9880e;
        this.f9881f = zzedVar.f9881f;
        this.f9882g = zzedVar.f9882g;
        this.f9883h = zzedVar.f9883h;
        this.f9884i = zzedVar.f9884i;
        this.f9885j = zzedVar.f9885j;
        this.f9886k = zzedVar.f9886k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzed(String str, String str2, zzjx zzjxVar, long j10, boolean z10, String str3, zzeu zzeuVar, long j11, zzeu zzeuVar2, long j12, zzeu zzeuVar3) {
        this.f9876a = str;
        this.f9877b = str2;
        this.f9878c = zzjxVar;
        this.f9879d = j10;
        this.f9880e = z10;
        this.f9881f = str3;
        this.f9882g = zzeuVar;
        this.f9883h = j11;
        this.f9884i = zzeuVar2;
        this.f9885j = j12;
        this.f9886k = zzeuVar3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.t(parcel, 2, this.f9876a, false);
        a.t(parcel, 3, this.f9877b, false);
        a.r(parcel, 4, this.f9878c, i10, false);
        a.o(parcel, 5, this.f9879d);
        a.c(parcel, 6, this.f9880e);
        a.t(parcel, 7, this.f9881f, false);
        a.r(parcel, 8, this.f9882g, i10, false);
        a.o(parcel, 9, this.f9883h);
        a.r(parcel, 10, this.f9884i, i10, false);
        a.o(parcel, 11, this.f9885j);
        a.r(parcel, 12, this.f9886k, i10, false);
        a.b(parcel, a10);
    }
}
