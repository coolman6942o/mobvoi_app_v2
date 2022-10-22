package com.mobvoi.wear.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import com.mobvoi.android.common.utils.c;
import com.mobvoi.android.common.utils.k;
import java.util.Locale;
/* loaded from: classes2.dex */
public class TicAppsChecker {
    private static final String[] APPS_SIGN_WHITE_LIST = {"5cc9866db03e530a21f842a421c7eb42bac58961", "097c1dd4b2c85cde97377ceac50cfa01fb59c0c9"};
    private static final String TAG = "TicAppsChecker";

    public static void checkCallerPermission(Context context) {
        int callingUid = Binder.getCallingUid();
        if (callingUid != Process.myUid() && callingUid != 1000) {
            checkCallerSignatures(context, callingUid);
        }
    }

    private static void checkCallerSignatures(Context context, int i10) {
        String[] c10;
        boolean z10;
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i10);
        if (packagesForUid == null || packagesForUid.length == 0) {
            String format = String.format(Locale.US, "No package found for uid [%d]", Integer.valueOf(i10));
            k.d(TAG, format);
            throw new SecurityException(format);
        }
        String str = packagesForUid[0];
        try {
            for (String str2 : c.b(context).c(str)) {
                String[] strArr = APPS_SIGN_WHITE_LIST;
                int length = strArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        z10 = false;
                        break;
                    } else if (strArr[i11].equals(str2)) {
                        z10 = true;
                        break;
                    } else {
                        i11++;
                    }
                }
                if (!z10) {
                    String format2 = String.format(Locale.US, "Unknown signature [%s] found in package [%s]", str2, str);
                    k.q(TAG, format2);
                    throw new SecurityException(format2);
                }
            }
        } catch (PackageManager.NameNotFoundException e10) {
            throw new SecurityException("Cannot verify signatures", e10);
        }
    }
}
