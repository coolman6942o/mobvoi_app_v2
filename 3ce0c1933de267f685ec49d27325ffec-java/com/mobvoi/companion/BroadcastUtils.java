package com.mobvoi.companion;

import android.content.ComponentName;
import android.content.Context;
import com.mobvoi.health.companion.provider.SportLocationReceiver;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class BroadcastUtils {
    private static boolean isEnabled = false;
    private static List<String> sPkgReceiver;

    static {
        ArrayList arrayList = new ArrayList();
        sPkgReceiver = arrayList;
        arrayList.add(SportLocationReceiver.class.getName());
    }

    public static void disableAllBroadcast(Context context) {
        if (!isEnabled) {
            for (int i10 = 0; i10 < sPkgReceiver.size(); i10++) {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context.getPackageName(), sPkgReceiver.get(i10)), 2, 1);
            }
        }
    }
}
