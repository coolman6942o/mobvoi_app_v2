package com.huawei.hms.framework.common;

import android.text.TextUtils;
import com.huawei.secure.android.common.util.SafeString;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
/* loaded from: classes.dex */
public class StringUtils {
    private static final int INIT_CAPACITY = 1024;
    private static boolean IS_AEGIS_STRING_LIBRARY_LOADED = false;
    private static final String SAFE_STRING_PATH = "com.huawei.secure.android.common.util.SafeString";
    private static final String TAG = "StringUtils";

    public static String anonymizeMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i10 = 0; i10 < charArray.length; i10++) {
            if (i10 % 2 != 0) {
                charArray[i10] = '*';
            }
        }
        return new String(charArray);
    }

    public static String byte2Str(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            Logger.w("StringUtils.byte2str error: UnsupportedEncodingException", e10);
            return "";
        }
    }

    private static boolean checkCompatible(String str) {
        ClassLoader classLoader = SecurityBase64Utils.class.getClassLoader();
        if (classLoader == null) {
            return false;
        }
        try {
            classLoader.loadClass(str);
            synchronized (StringUtils.class) {
                IS_AEGIS_STRING_LIBRARY_LOADED = true;
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static String format(String str, Object... objArr) {
        return str == null ? "" : String.format(Locale.ROOT, str, objArr);
    }

    public static byte[] getBytes(long j10) {
        return getBytes(String.valueOf(j10));
    }

    public static byte[] getBytes(String str) {
        byte[] bArr = new byte[0];
        if (str == null) {
            return bArr;
        }
        try {
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            Logger.w(TAG, "the content has error while it is converted to bytes");
            return bArr;
        }
    }

    public static String getTraceInfo(Throwable th2) {
        StackTraceElement[] stackTrace = th2.getStackTrace();
        StringBuilder sb2 = new StringBuilder(1024);
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb2.append("at ");
            sb2.append(stackTraceElement.toString());
            sb2.append(";");
        }
        return sb2.toString();
    }

    public static String replace(String str, CharSequence charSequence, CharSequence charSequence2) {
        if (IS_AEGIS_STRING_LIBRARY_LOADED || checkCompatible(SAFE_STRING_PATH)) {
            return SafeString.replace(str, charSequence, charSequence2);
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(charSequence)) {
            return str;
        }
        try {
            return str.replace(charSequence, charSequence2);
        } catch (Exception unused) {
            return str;
        }
    }

    public static byte[] str2Byte(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e10) {
            Logger.w("StringUtils.str2Byte error: UnsupportedEncodingException", e10);
            return new byte[0];
        }
    }

    public static boolean strEquals(String str, String str2) {
        return str == str2 || (str != null && str.equals(str2));
    }

    public static int stringToInteger(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return i10;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e10) {
            Logger.w(TAG, "String to Integer catch NumberFormatException.", e10);
            return i10;
        }
    }

    public static long stringToLong(String str, long j10) {
        if (TextUtils.isEmpty(str)) {
            return j10;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e10) {
            Logger.w(TAG, "String to Long catch NumberFormatException.", e10);
            return j10;
        }
    }

    public static String substring(String str, int i10) {
        if (checkCompatible(SAFE_STRING_PATH)) {
            return SafeString.substring(str, i10);
        }
        if (!TextUtils.isEmpty(str) && str.length() >= i10 && i10 >= 0) {
            try {
                return str.substring(i10);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String substring(String str, int i10, int i11) {
        if (IS_AEGIS_STRING_LIBRARY_LOADED || checkCompatible(SAFE_STRING_PATH)) {
            return SafeString.substring(str, i10, i11);
        }
        if (!TextUtils.isEmpty(str) && i10 >= 0 && i11 <= str.length() && i11 >= i10) {
            try {
                return str.substring(i10, i11);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String toLowerCase(String str) {
        return str == null ? str : str.toLowerCase(Locale.ROOT);
    }
}
