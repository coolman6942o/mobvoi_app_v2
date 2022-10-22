package n6;

import android.os.Parcel;
/* loaded from: classes.dex */
public class c {
    static {
        c.class.getClassLoader();
    }

    private c() {
    }

    public static void a(Parcel parcel, boolean z10) {
        parcel.writeInt(1);
    }

    public static boolean b(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
