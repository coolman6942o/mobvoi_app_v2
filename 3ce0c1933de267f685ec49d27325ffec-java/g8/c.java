package g8;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.messaging.RemoteMessage;
/* loaded from: classes.dex */
public final class c implements Parcelable.Creator<RemoteMessage> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ RemoteMessage createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            if (SafeParcelReader.u(B) != 2) {
                SafeParcelReader.K(parcel, B);
            } else {
                bundle = SafeParcelReader.f(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new RemoteMessage(bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ RemoteMessage[] newArray(int i10) {
        return new RemoteMessage[i10];
    }
}
