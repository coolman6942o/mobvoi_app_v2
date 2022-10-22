package w6;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class h implements Parcelable.Creator<ActivityRecognitionResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityRecognitionResult createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        long j10 = 0;
        ArrayList arrayList = null;
        int i10 = 0;
        long j11 = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                arrayList = SafeParcelReader.s(parcel, B, DetectedActivity.CREATOR);
            } else if (u10 == 2) {
                j10 = SafeParcelReader.G(parcel, B);
            } else if (u10 == 3) {
                j11 = SafeParcelReader.G(parcel, B);
            } else if (u10 == 4) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.K(parcel, B);
            } else {
                bundle = SafeParcelReader.f(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new ActivityRecognitionResult(arrayList, j10, j11, i10, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityRecognitionResult[] newArray(int i10) {
        return new ActivityRecognitionResult[i10];
    }
}
