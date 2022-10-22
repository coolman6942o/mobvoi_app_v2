package w6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.ActivityTransitionEvent;
import com.google.android.gms.location.ActivityTransitionResult;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class k implements Parcelable.Creator<ActivityTransitionResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityTransitionResult createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        ArrayList arrayList = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            if (SafeParcelReader.u(B) != 1) {
                SafeParcelReader.K(parcel, B);
            } else {
                arrayList = SafeParcelReader.s(parcel, B, ActivityTransitionEvent.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new ActivityTransitionResult(arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityTransitionResult[] newArray(int i10) {
        return new ActivityTransitionResult[i10];
    }
}
