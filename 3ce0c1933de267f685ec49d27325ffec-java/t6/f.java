package t6;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class f {
    static {
        f.class.getClassLoader();
    }

    private f() {
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    public static void b(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    public static void c(Parcel parcel, boolean z10) {
        parcel.writeInt(z10 ? 1 : 0);
    }
}
