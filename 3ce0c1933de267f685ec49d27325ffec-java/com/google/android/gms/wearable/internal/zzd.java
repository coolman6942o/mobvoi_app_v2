package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.s0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private final f f10238a;

    /* renamed from: b  reason: collision with root package name */
    private final IntentFilter[] f10239b;

    /* renamed from: c  reason: collision with root package name */
    private final String f10240c;

    /* renamed from: d  reason: collision with root package name */
    private final String f10241d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzd(IBinder iBinder, IntentFilter[] intentFilterArr, String str, String str2) {
        f fVar;
        if (iBinder != null) {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
            if (queryLocalInterface instanceof f) {
                fVar = (f) queryLocalInterface;
            } else {
                fVar = new h(iBinder);
            }
            this.f10238a = fVar;
        } else {
            this.f10238a = null;
        }
        this.f10239b = intentFilterArr;
        this.f10240c = str;
        this.f10241d = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        f fVar = this.f10238a;
        a.k(parcel, 2, fVar == null ? null : fVar.asBinder(), false);
        a.w(parcel, 3, this.f10239b, i10, false);
        a.t(parcel, 4, this.f10240c, false);
        a.t(parcel, 5, this.f10241d, false);
        a.b(parcel, a10);
    }

    public zzd(s0 s0Var) {
        this.f10238a = s0Var;
        this.f10239b = s0Var.m1();
        this.f10240c = s0Var.U1();
        this.f10241d = null;
    }
}
