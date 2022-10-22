package w6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.ActivityTransition;
import com.google.android.gms.location.ActivityTransitionRequest;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class j implements Parcelable.Creator<ActivityTransitionRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityTransitionRequest createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        ArrayList arrayList = null;
        String str = null;
        ArrayList arrayList2 = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                arrayList = SafeParcelReader.s(parcel, B, ActivityTransition.CREATOR);
            } else if (u10 == 2) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                arrayList2 = SafeParcelReader.s(parcel, B, ClientIdentity.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new ActivityTransitionRequest(arrayList, str, arrayList2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityTransitionRequest[] newArray(int i10) {
        return new ActivityTransitionRequest[i10];
    }
}
