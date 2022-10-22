package com.mobvoi.wear.privacy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.base.Constants;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class PrivacyCheckHelper {
    private static final String TAG = "priv.CheckHelper";

    public static boolean check(Context context, String[] strArr, String[] strArr2) {
        return check(context, strArr, strArr2, 0, false);
    }

    public static boolean checkWithResult(Context context, String[] strArr, String[] strArr2, int i10) {
        return check(context, strArr, strArr2, i10, true);
    }

    private static boolean check(Context context, String[] strArr, String[] strArr2, int i10, boolean z10) {
        boolean z11;
        if (strArr.length == 0) {
            return false;
        }
        if (strArr.length != strArr2.length) {
            k.f(TAG, "privacy %s and refused impact %s size dose not match!", Arrays.toString(strArr), Arrays.toString(strArr2));
            if (!k.j()) {
                return false;
            }
            throw new IllegalArgumentException("privacy list and refused list size must match.");
        }
        int length = strArr.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                z11 = true;
                break;
            } else if (!SharedWearInfoHelper.getInstance(context).isGdprDataEnabled(strArr[i11])) {
                z11 = false;
                break;
            } else {
                i11++;
            }
        }
        if (z11) {
            return false;
        }
        Intent intent = new Intent(Constants.Privacy.ACTION_SETTINGS);
        intent.putExtra(Constants.Privacy.KEY_CHECK_PRIVACY_LIST, strArr);
        intent.putExtra(Constants.Privacy.KEY_CHECK_IMPACT_LIST, strArr2);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            if (!z10 || !(context instanceof Activity)) {
                intent.addFlags(268435456);
                context.startActivity(intent);
            } else {
                k.c(TAG, "Has privacy check activity, start with requestCode %d", Integer.valueOf(i10));
                intent.addFlags(4194304);
                ((Activity) context).startActivityForResult(intent, i10);
            }
            return true;
        }
        k.q(TAG, "Privacy check activity not found, skip check.");
        return false;
    }
}
