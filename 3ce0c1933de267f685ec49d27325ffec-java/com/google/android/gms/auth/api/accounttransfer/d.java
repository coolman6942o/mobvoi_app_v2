package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.HashSet;
/* loaded from: classes.dex */
public final class d implements Parcelable.Creator<zzt> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzt createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        HashSet hashSet = new HashSet();
        int i10 = 0;
        String str = null;
        byte[] bArr = null;
        PendingIntent pendingIntent = null;
        DeviceMetaData deviceMetaData = null;
        int i11 = 0;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i11 = SafeParcelReader.D(parcel, B);
                    hashSet.add(1);
                    break;
                case 2:
                    str = SafeParcelReader.o(parcel, B);
                    hashSet.add(2);
                    break;
                case 3:
                    i10 = SafeParcelReader.D(parcel, B);
                    hashSet.add(3);
                    break;
                case 4:
                    bArr = SafeParcelReader.g(parcel, B);
                    hashSet.add(4);
                    break;
                case 5:
                    pendingIntent = (PendingIntent) SafeParcelReader.n(parcel, B, PendingIntent.CREATOR);
                    hashSet.add(5);
                    break;
                case 6:
                    deviceMetaData = (DeviceMetaData) SafeParcelReader.n(parcel, B, DeviceMetaData.CREATOR);
                    hashSet.add(6);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == L) {
            return new zzt(hashSet, i11, str, i10, bArr, pendingIntent, deviceMetaData);
        }
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("Overread allowed size end=");
        sb2.append(L);
        throw new SafeParcelReader.ParseException(sb2.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzt[] newArray(int i10) {
        return new zzt[i10];
    }
}
