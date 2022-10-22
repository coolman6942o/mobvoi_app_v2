package t6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zzad;
/* loaded from: classes.dex */
public final class a implements Parcelable.Creator<zzad> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzad createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        Status status = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            if (SafeParcelReader.u(B) != 1) {
                SafeParcelReader.K(parcel, B);
            } else {
                status = (Status) SafeParcelReader.n(parcel, B, Status.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new zzad(status);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzad[] newArray(int i10) {
        return new zzad[i10];
    }
}
