package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzfw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfw> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    private final int f10290a;

    /* renamed from: b  reason: collision with root package name */
    private final f f10291b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfw(int i10, IBinder iBinder) {
        f fVar;
        this.f10290a = i10;
        if (iBinder != null) {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
            if (queryLocalInterface instanceof f) {
                fVar = (f) queryLocalInterface;
            } else {
                fVar = new h(iBinder);
            }
            this.f10291b = fVar;
            return;
        }
        this.f10291b = null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f10290a);
        f fVar = this.f10291b;
        a.k(parcel, 2, fVar == null ? null : fVar.asBinder(), false);
        a.b(parcel, a10);
    }
}
