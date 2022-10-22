package bh;

import android.content.Context;
import com.mobvoi.wear.util.UnitsUtility;
import fg.u;
/* compiled from: StrideLenUnitsUtility.java */
/* loaded from: classes2.dex */
public class g {
    public static String a(Context context, boolean z10) {
        if (z10) {
            return context.getString(u.B2);
        }
        return context.getString(u.A2);
    }

    public static float b(float f10, boolean z10) {
        return z10 ? UnitsUtility.Length.m2ft(f10) : f10;
    }
}
