package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.t;
import com.google.android.gms.location.u;
import com.google.android.gms.location.w;
import com.google.android.gms.location.x;
/* loaded from: classes.dex */
public final class zzbf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbf> CREATOR = new s();

    /* renamed from: a  reason: collision with root package name */
    private int f9125a;

    /* renamed from: b  reason: collision with root package name */
    private zzbd f9126b;

    /* renamed from: c  reason: collision with root package name */
    private w f9127c;

    /* renamed from: d  reason: collision with root package name */
    private PendingIntent f9128d;

    /* renamed from: e  reason: collision with root package name */
    private t f9129e;

    /* renamed from: f  reason: collision with root package name */
    private d f9130f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbf(int i10, zzbd zzbdVar, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        this.f9125a = i10;
        this.f9126b = zzbdVar;
        d dVar = null;
        this.f9127c = iBinder == null ? null : x.m1(iBinder);
        this.f9128d = pendingIntent;
        this.f9129e = iBinder2 == null ? null : u.m1(iBinder2);
        if (iBinder3 != null) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            dVar = queryLocalInterface instanceof d ? (d) queryLocalInterface : new f(iBinder3);
        }
        this.f9130f = dVar;
    }

    public static zzbf G0(t tVar, d dVar) {
        return new zzbf(2, null, null, null, tVar.asBinder(), dVar != null ? dVar.asBinder() : null);
    }

    public static zzbf H0(w wVar, d dVar) {
        return new zzbf(2, null, wVar.asBinder(), null, null, dVar != null ? dVar.asBinder() : null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f9125a);
        a.r(parcel, 2, this.f9126b, i10, false);
        w wVar = this.f9127c;
        IBinder iBinder = null;
        a.k(parcel, 3, wVar == null ? null : wVar.asBinder(), false);
        a.r(parcel, 4, this.f9128d, i10, false);
        t tVar = this.f9129e;
        a.k(parcel, 5, tVar == null ? null : tVar.asBinder(), false);
        d dVar = this.f9130f;
        if (dVar != null) {
            iBinder = dVar.asBinder();
        }
        a.k(parcel, 6, iBinder, false);
        a.b(parcel, a10);
    }
}
