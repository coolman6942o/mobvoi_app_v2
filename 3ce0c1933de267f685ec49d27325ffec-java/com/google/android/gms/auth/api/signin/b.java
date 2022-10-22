package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class b implements Parcelable.Creator<GoogleSignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        int i10 = 0;
        long j10 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 2:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 3:
                    str2 = SafeParcelReader.o(parcel, B);
                    break;
                case 4:
                    str3 = SafeParcelReader.o(parcel, B);
                    break;
                case 5:
                    str4 = SafeParcelReader.o(parcel, B);
                    break;
                case 6:
                    uri = (Uri) SafeParcelReader.n(parcel, B, Uri.CREATOR);
                    break;
                case 7:
                    str5 = SafeParcelReader.o(parcel, B);
                    break;
                case 8:
                    j10 = SafeParcelReader.G(parcel, B);
                    break;
                case 9:
                    str6 = SafeParcelReader.o(parcel, B);
                    break;
                case 10:
                    arrayList = SafeParcelReader.s(parcel, B, Scope.CREATOR);
                    break;
                case 11:
                    str7 = SafeParcelReader.o(parcel, B);
                    break;
                case 12:
                    str8 = SafeParcelReader.o(parcel, B);
                    break;
                default:
                    SafeParcelReader.K(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, L);
        return new GoogleSignInAccount(i10, str, str2, str3, str4, uri, str5, j10, str6, arrayList, str7, str8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i10) {
        return new GoogleSignInAccount[i10];
    }
}
