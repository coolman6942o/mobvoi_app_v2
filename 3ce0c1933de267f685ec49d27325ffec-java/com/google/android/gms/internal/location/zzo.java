package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.r;
import w6.m;
/* loaded from: classes.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new x();

    /* renamed from: a  reason: collision with root package name */
    private int f9145a;

    /* renamed from: b  reason: collision with root package name */
    private zzm f9146b;

    /* renamed from: c  reason: collision with root package name */
    private m f9147c;

    /* renamed from: d  reason: collision with root package name */
    private d f9148d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(int i10, zzm zzmVar, IBinder iBinder, IBinder iBinder2) {
        this.f9145a = i10;
        this.f9146b = zzmVar;
        d dVar = null;
        this.f9147c = iBinder == null ? null : r.m1(iBinder);
        if (iBinder2 != null) {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            dVar = queryLocalInterface instanceof d ? (d) queryLocalInterface : new f(iBinder2);
        }
        this.f9148d = dVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f9145a);
        a.r(parcel, 2, this.f9146b, i10, false);
        m mVar = this.f9147c;
        IBinder iBinder = null;
        a.k(parcel, 3, mVar == null ? null : mVar.asBinder(), false);
        d dVar = this.f9148d;
        if (dVar != null) {
            iBinder = dVar.asBinder();
        }
        a.k(parcel, 4, iBinder, false);
        a.b(parcel, a10);
    }
}
