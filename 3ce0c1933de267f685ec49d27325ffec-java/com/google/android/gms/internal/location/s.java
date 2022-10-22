package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes.dex */
public final class s implements Parcelable.Creator<zzbf> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbf createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        zzbd zzbdVar = null;
        int i10 = 1;
        IBinder iBinder = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 2:
                    zzbdVar = (zzbd) SafeParcelReader.n(parcel, B, zzbd.CREATOR);
                    break;
                case 3:
                    iBinder = SafeParcelReader.C(parcel, B);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) SafeParcelReader.n(parcel, B, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = SafeParcelReader.C(parcel, B);
                    break;
                case 6:
                    iBinder3 = SafeParcelReader.C(parcel, B);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzbf(i10, zzbdVar, iBinder, pendingIntent, iBinder2, iBinder3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbf[] newArray(int i10) {
        return new zzbf[i10];
    }
}
