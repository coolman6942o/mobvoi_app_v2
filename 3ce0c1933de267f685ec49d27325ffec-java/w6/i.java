package w6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.ActivityTransitionEvent;
/* loaded from: classes.dex */
public final class i implements Parcelable.Creator<ActivityTransitionEvent> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityTransitionEvent createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        long j10 = 0;
        int i11 = 0;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                i11 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                j10 = SafeParcelReader.G(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new ActivityTransitionEvent(i10, i11, j10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityTransitionEvent[] newArray(int i10) {
        return new ActivityTransitionEvent[i10];
    }
}
