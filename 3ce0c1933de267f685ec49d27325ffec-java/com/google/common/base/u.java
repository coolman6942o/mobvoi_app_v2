package com.google.common.base;

import com.mobvoi.wear.lpa.LpaConstants;
import java.util.logging.Level;
import java.util.logging.Logger;
/* compiled from: Strings.java */
/* loaded from: classes.dex */
public final class u {
    public static boolean a(String str) {
        return o.c(str);
    }

    public static String b(String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i10 = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i11 = 0; i11 < objArr.length; i11++) {
                objArr[i11] = c(objArr[i11]);
            }
        }
        StringBuilder sb2 = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i12 = 0;
        while (i10 < objArr.length && (indexOf = valueOf.indexOf("%s", i12)) != -1) {
            sb2.append((CharSequence) valueOf, i12, indexOf);
            i10++;
            sb2.append(objArr[i10]);
            i12 = indexOf + 2;
        }
        sb2.append((CharSequence) valueOf, i12, valueOf.length());
        if (i10 < objArr.length) {
            sb2.append(" [");
            int i13 = i10 + 1;
            sb2.append(objArr[i10]);
            while (i13 < objArr.length) {
                sb2.append(", ");
                i13++;
                sb2.append(objArr[i13]);
            }
            sb2.append(']');
        }
        return sb2.toString();
    }

    private static String c(Object obj) {
        if (obj == null) {
            return LpaConstants.VALUE_NULL;
        }
        try {
            return obj.toString();
        } catch (Exception e10) {
            String name = obj.getClass().getName();
            String hexString = Integer.toHexString(System.identityHashCode(obj));
            StringBuilder sb2 = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
            sb2.append(name);
            sb2.append('@');
            sb2.append(hexString);
            String sb3 = sb2.toString();
            Logger logger = Logger.getLogger("com.google.common.base.Strings");
            Level level = Level.WARNING;
            String valueOf = String.valueOf(sb3);
            logger.log(level, valueOf.length() != 0 ? "Exception during lenientFormat for ".concat(valueOf) : new String("Exception during lenientFormat for "), (Throwable) e10);
            String name2 = e10.getClass().getName();
            StringBuilder sb4 = new StringBuilder(String.valueOf(sb3).length() + 9 + name2.length());
            sb4.append("<");
            sb4.append(sb3);
            sb4.append(" threw ");
            sb4.append(name2);
            sb4.append(">");
            return sb4.toString();
        }
    }
}
