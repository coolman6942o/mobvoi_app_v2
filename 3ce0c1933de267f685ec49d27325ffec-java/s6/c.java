package s6;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class c {
    static {
        c.class.getClassLoader();
    }

    private c() {
    }

    public static void a(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }
}
