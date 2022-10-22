package com.huawei.hianalytics.mn.no.b;

import android.text.TextUtils;
import com.huawei.hianalytics.mn.no.qr.mn;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class op {
    public static String mn(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str2)) {
            return mn(str, str2, str3) ? str2 : str4;
        }
        mn.op("hmsSdk", "checkStrParameter() Parameter verification failure! Parameter:".concat(String.valueOf(str)));
        return str4;
    }

    public static boolean mn(String str) {
        return !mn("eventId", str, 256);
    }

    public static boolean mn(String str, String str2, int i10) {
        String valueOf;
        String str3;
        if (TextUtils.isEmpty(str2)) {
            valueOf = String.valueOf(str);
            str3 = "checkString() Parameter is empty : ";
        } else if (str2.length() <= i10) {
            return true;
        } else {
            valueOf = String.valueOf(str);
            str3 = "checkString() Failure of parameter length check! Parameter:";
        }
        mn.op("hmsSdk", str3.concat(valueOf));
        return false;
    }

    public static boolean mn(String str, String str2, String str3) {
        String valueOf;
        String str4;
        if (TextUtils.isEmpty(str2)) {
            valueOf = String.valueOf(str);
            str4 = "checkString() Parameter is null! Parameter:";
        } else if (Pattern.compile(str3).matcher(str2).matches()) {
            return true;
        } else {
            valueOf = String.valueOf(str);
            str4 = "checkString() Parameter verification failure! Parameter:";
        }
        mn.op("hmsSdk", str4.concat(valueOf));
        return false;
    }

    public static boolean mn(Map<String, String> map) {
        String str;
        if (map == null || map.size() == 0) {
            str = "onEvent() mapValue has not data.so,The data will be empty";
        } else if (map.size() == 1 && (map.get("constants") != null || map.get("_constants") != null)) {
            str = "checkMap() the key can't be constants or _constants";
        } else if (map.size() <= 2048 && map.toString().length() <= 204800) {
            return true;
        } else {
            str = "checkMap Map data is too big! size: " + map.size() + " length: " + map.toString().length();
        }
        mn.op("hmsSdk", str);
        return false;
    }
}
