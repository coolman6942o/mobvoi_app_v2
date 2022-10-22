package z6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.PatternItem;
/* loaded from: classes.dex */
public final class j implements Parcelable.Creator<PatternItem> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PatternItem createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i10 = 0;
        Float f10 = null;
        while (parcel.dataPosition() < L) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.K(parcel, B);
            } else {
                f10 = SafeParcelReader.A(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, L);
        return new PatternItem(i10, f10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PatternItem[] newArray(int i10) {
        return new PatternItem[i10];
    }
}
