package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class a implements Parcelable.Creator<WakeLockEvent> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        long j10 = 0;
        int i10 = 0;
        String str = null;
        float f10 = 0.0f;
        long j11 = 0;
        long j12 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        boolean z10 = false;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 2:
                    j10 = SafeParcelReader.G(parcel, B);
                    break;
                case 3:
                case 7:
                case 9:
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
                case 4:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 5:
                    i12 = SafeParcelReader.D(parcel, B);
                    break;
                case 6:
                    arrayList = SafeParcelReader.q(parcel, B);
                    break;
                case 8:
                    j11 = SafeParcelReader.G(parcel, B);
                    break;
                case 10:
                    str3 = SafeParcelReader.o(parcel, B);
                    break;
                case 11:
                    i11 = SafeParcelReader.D(parcel, B);
                    break;
                case 12:
                    str2 = SafeParcelReader.o(parcel, B);
                    break;
                case 13:
                    str4 = SafeParcelReader.o(parcel, B);
                    break;
                case 14:
                    i13 = SafeParcelReader.D(parcel, B);
                    break;
                case 15:
                    f10 = SafeParcelReader.z(parcel, B);
                    break;
                case 16:
                    j12 = SafeParcelReader.G(parcel, B);
                    break;
                case 17:
                    str5 = SafeParcelReader.o(parcel, B);
                    break;
                case 18:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new WakeLockEvent(i10, j10, i11, str, i12, arrayList, str2, j11, i13, str3, str4, f10, j12, str5, z10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent[] newArray(int i10) {
        return new WakeLockEvent[i10];
    }
}
