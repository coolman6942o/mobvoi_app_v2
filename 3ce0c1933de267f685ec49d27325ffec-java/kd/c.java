package kd;

import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
/* compiled from: BirthdayUtils.java */
/* loaded from: classes2.dex */
class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(int i10, int i11, int i12) {
        return i10 + "." + i11 + "." + i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] b(String str, int i10, int i11, int i12) {
        int[] iArr = {i10, i11, i12};
        if (TextUtils.isEmpty(str)) {
            return iArr;
        }
        String[] split = str.split("\\.");
        if (split.length != 3) {
            return iArr;
        }
        try {
            return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])};
        } catch (NumberFormatException e10) {
            k.e("BirthdayUtils", "parse number err", e10);
            return iArr;
        }
    }
}
