package lm;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import il.b;
import java.io.IOException;
import java.util.Locale;
/* loaded from: classes2.dex */
public class d {
    public static int a(int[] iArr, int i10) {
        if (iArr == null || iArr.length <= 0) {
            return -1;
        }
        int i11 = 0;
        int length = iArr.length - 1;
        while (i11 <= length) {
            int i12 = (i11 + length) >>> 1;
            int i13 = iArr[i12];
            if (i13 < i10) {
                i11 = i12 + 1;
            } else if (i13 <= i10) {
                return i12;
            } else {
                length = i12 - 1;
            }
        }
        return ~i11;
    }

    public static String b(int i10, int i11, int i12) {
        if (i12 == 1) {
            if (i10 > 0) {
                return String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i11 & 255), Integer.valueOf((i11 >> 8) & 255), Integer.valueOf((i11 >> 16) & 255), Integer.valueOf((i11 >> 24) & 255));
            }
        } else if (i12 == 2) {
            if (i10 > 0) {
                return String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf((i11 >> 24) & 255), Integer.valueOf((i11 >> 16) & 255), Integer.valueOf((i11 >> 8) & 255), Integer.valueOf(i11 & 255));
            }
        } else if (i12 == 3) {
            if (i10 > 0) {
                return String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i11 & 15), Integer.valueOf((i11 >> 4) & 255), Integer.valueOf((i11 >> 12) & 32767), Integer.valueOf((i11 >> 27) & 31));
            }
        } else if (i12 == 5) {
            return i10 <= 0 ? String.valueOf(i11) : String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i11 & 15), Integer.valueOf((i11 >> 4) & 255), Integer.valueOf((i11 >> 12) & 511), Integer.valueOf((i11 >> 21) & 2047));
        } else {
            if (i12 == 515) {
                if (i10 > 0) {
                    return String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf((i11 >> 24) & 255), Integer.valueOf((i11 >> 16) & 255), Integer.valueOf((i11 >> 8) & 255), Integer.valueOf(i11 & 255));
                }
            } else if (i12 != 4 && i12 != 7 && i12 == 514 && i10 > 0) {
                return String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf((i11 >> 8) & 255), Integer.valueOf(i11 & 255), Integer.valueOf((i11 >> 24) & 255), Integer.valueOf((i11 >> 16) & 255));
            }
        }
        return String.valueOf(i11);
    }

    public static String c(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf == -1) {
            return str;
        }
        if (lastIndexOf != 0) {
            str.substring(0, lastIndexOf + 1);
        }
        return str.substring(lastIndexOf + 1);
    }

    public static boolean d(Context context, String str) {
        String[] list;
        AssetManager assets = context.getResources().getAssets();
        if (assets == null || TextUtils.isEmpty(str)) {
            return false;
        }
        int lastIndexOf = str.lastIndexOf("/");
        String str2 = "";
        if (lastIndexOf != -1) {
            if (lastIndexOf != 0) {
                str2 = str.substring(0, lastIndexOf);
            }
            str = str.substring(lastIndexOf + 1);
        }
        try {
            list = assets.list(str2);
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        if (list != null && list.length > 0) {
            for (String str3 : list) {
                if (str.equals(str3)) {
                    b.j("\t =" + str3);
                    return true;
                }
                b.j("\t =" + str3);
            }
            b.j(String.format("not find asset file: <%s>/<%s>", str2, str));
            return false;
        }
        b.c(String.format("no asset file found: <%s>/<%s>", str2, str));
        return false;
    }
}
