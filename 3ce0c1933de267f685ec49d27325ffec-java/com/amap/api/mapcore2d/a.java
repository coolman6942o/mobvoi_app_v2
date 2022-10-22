package com.amap.api.mapcore2d;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Arrays;
/* compiled from: Util.java */
/* loaded from: classes.dex */
public class a {
    public static float a(float f10) {
        if (f10 < 0.0f) {
            return 0.0f;
        }
        if (f10 > 45.0f) {
            return 45.0f;
        }
        return f10;
    }

    public static int b(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    public static String c(String str, Object obj) {
        return str + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(obj);
    }

    public static String d(String... strArr) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (String str : strArr) {
            sb2.append(str);
            if (i10 != strArr.length - 1) {
                sb2.append(",");
            }
            i10++;
        }
        return sb2.toString();
    }

    public static void e(Throwable th2, String str, String str2) {
        try {
            i c10 = i.c();
            if (c10 != null) {
                c10.e(th2, str, str2);
            }
            th2.printStackTrace();
        } catch (Throwable unused) {
        }
    }

    public static float f(float f10) {
        int i10 = t.f7048a;
        if (f10 <= i10) {
            i10 = t.f7049b;
            if (f10 >= i10) {
                return f10;
            }
        }
        return i10;
    }
}
