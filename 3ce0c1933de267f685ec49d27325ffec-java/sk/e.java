package sk;

import android.content.Context;
import android.os.Build;
/* compiled from: TelephonyInterfaceFactory.java */
/* loaded from: classes2.dex */
public class e {
    public static d a(Context context) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            return new b(context);
        }
        if (i10 >= 21) {
            return new a(context);
        }
        return new c(context);
    }
}
