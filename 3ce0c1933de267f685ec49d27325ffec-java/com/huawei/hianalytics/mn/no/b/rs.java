package com.huawei.hianalytics.mn.no.b;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hianalytics.mn.no.mn.no;
import com.huawei.hianalytics.mn.no.qr.mn;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
/* loaded from: classes.dex */
public class rs {

    /* renamed from: mn  reason: collision with root package name */
    private static final String[] f13533mn = {"e2f856b9f9a4fd4cb2795aeaf83268e4bff189aaec05d691ffde76e075b82648", "173cf86fe9894a0f70dadd09d4fd88c380836099d4939f8c3754361bdc16a32b", "b368b110e3b565fe97c91f786e11bc48754cc8e4e6f21d8a94a68ac6ad67aaaf", "db48223fd9e143f7e133c57f5d08a4e38549ce3ebd921fe3b4003c26e5e35bed", "4bdecdf772491e35c4e8b48f88aee22bae1311984f2e1da4dfad0b78ee7f5163", "3081a0adab3018d57165e6dd24074bdbac640f6dbe21a9e24d3474a87ebf38b8", "db53fcdc9ab71e9bdd4eab257fe1aba7989ad2b24fbe3a85dfef72ea1dd6bae2", "d80f18e8081b624cc64985f87f70118f1702985d2e10dbc985ee7be334fd3c7d", "5fed96c85bd58c58aadbd465c172a4c9a794d8eb2f86cbc7bcee6caf4c7a2c5f", "07ff9b7aeeff969173c45b285fe0fecdbaae244576ff7a2796a36f1c0c11adb4", "92974c6802419e4d18b5ec536cbfa167b8e8eff09ec4c8510a5b95750b1e0c82", "403f14ad2f0e5eb3c4f3a0bcd5c1592cc4492662ad53191c92905255d4990656", "4230baa077b401374d0fc012375047e79ea0790d58d095ef18d97d95470c738d"};

    private static String mn(String str, int i10) {
        if (TextUtils.isEmpty(str) || i10 <= 0) {
            mn.no("UriUtil", "url is null");
            return str;
        }
        String[] split = str.split("\\.");
        if (split.length < i10) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(split[split.length - i10]);
        for (int i11 = 1; i11 < i10; i11++) {
            stringBuffer.append(".");
            stringBuffer.append(split[(split.length - i10) + i11]);
        }
        return stringBuffer.toString();
    }

    public static boolean mn(String str) {
        if (com.huawei.hianalytics.mn.st.mn.f13649mn.booleanValue()) {
            return true;
        }
        for (String str2 : f13533mn) {
            if (mn(str, str2, 2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean mn(String str, String str2, int i10) {
        String str3;
        StringBuilder sb2;
        String message;
        String no2 = no(str);
        if (TextUtils.isEmpty(no2) || TextUtils.isEmpty(str2)) {
            str3 = "url or whitelistHash is null";
        } else {
            String mn2 = mn(no2, i10);
            if (TextUtils.isEmpty(mn2)) {
                str3 = "get urlLastNStr is null";
            } else if (str2.equals(no.mn().mn(no2))) {
                return true;
            } else {
                if (!str2.equals(no.mn().mn(mn2))) {
                    return false;
                }
                try {
                    String substring = no2.substring(0, no2.length() - mn2.length());
                    if (!substring.endsWith(".")) {
                        return false;
                    }
                    return substring.matches("^[A-Za-z0-9.-]+$");
                } catch (IndexOutOfBoundsException e10) {
                    sb2 = new StringBuilder("IndexOutOfBoundsException");
                    message = e10.getMessage();
                    sb2.append(message);
                    str3 = sb2.toString();
                    mn.pq("UriUtil", str3);
                    return false;
                } catch (Exception e11) {
                    sb2 = new StringBuilder("Exception : ");
                    message = e11.getMessage();
                    sb2.append(message);
                    str3 = sb2.toString();
                    mn.pq("UriUtil", str3);
                    return false;
                }
            }
        }
        mn.pq("UriUtil", str3);
        return false;
    }

    @TargetApi(9)
    public static String no(String str) {
        if (TextUtils.isEmpty(str)) {
            mn.no("UriUtil", "url is null");
            return str;
        }
        try {
            if (URLUtil.isNetworkUrl(str) && !str.toLowerCase(Locale.US).startsWith("http:")) {
                return new URI(str).getHost();
            }
            mn.pq("UriUtil", "url don't starts with https");
            return null;
        } catch (URISyntaxException e10) {
            mn.pq("UriUtil", "getHostByURI error : " + e10.getMessage());
            return null;
        }
    }
}
