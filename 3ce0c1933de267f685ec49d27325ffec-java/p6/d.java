package p6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.p000authapi.zzs;
/* loaded from: classes.dex */
public final class d implements Parcelable.Creator<zzs> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzs createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        Credential credential = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            if (SafeParcelReader.u(B) != 1) {
                SafeParcelReader.K(parcel, B);
            } else {
                credential = (Credential) SafeParcelReader.n(parcel, B, Credential.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzs(credential);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzs[] newArray(int i10) {
        return new zzs[i10];
    }
}
