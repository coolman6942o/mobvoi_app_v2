package com.unionpay.mobile.android.nocard.utils;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.mobvoi.wear.util.TelephonyUtil;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.plugin.c;
import com.unionpay.mobile.android.utils.k;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public final class a {
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r2.containsKey(r0) != false) goto L5;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(Bundle bundle) {
        String str;
        if (bundle != null) {
            String str2 = "paydata";
            if (!bundle.containsKey(str2)) {
                str2 = "tn";
            }
            str = bundle.getString(str2);
            return str != null ? "" : str;
        }
        str = null;
        if (str != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(String str) {
        byte[] a10;
        k.a("uppay", "decodePayInfo +++ \n");
        String str2 = null;
        String decode = str != null ? URLDecoder.decode(str) : null;
        k.b("uppay", "url deocode result:" + decode);
        if (decode != null) {
            try {
                a10 = com.unionpay.mobile.android.utils.a.a(decode);
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            if (a10 != null) {
                try {
                    str2 = new String(a10, "UTF-8");
                } catch (UnsupportedEncodingException e11) {
                    e11.printStackTrace();
                }
            }
            k.a("uppay", "order info:" + str2 + "\n");
            k.a("uppay", "decodePayInfo --- \n");
            return str2;
        }
        a10 = null;
        if (a10 != null) {
        }
        k.a("uppay", "order info:" + str2 + "\n");
        k.a("uppay", "decodePayInfo --- \n");
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x014b, code lost:
        if (android.text.TextUtils.isEmpty(r17.f23528d) == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01ab, code lost:
        if (r1.trim().length() > 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01ad, code lost:
        r1 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Intent intent, b bVar) {
        boolean z10;
        int i10;
        String str;
        if (intent == null) {
            return false;
        }
        k.c("uppay", " ===>" + intent.toString());
        String dataString = intent.getDataString();
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey("reqOriginalId")) {
            k.c("uppay", " bundle===>" + extras.toString());
            bVar.I.f23861a = extras.getInt("reqOriginalId");
            k.b("uppay", "reqID:" + bVar.I.f23861a);
            bVar.I.f23865e = extras.getBoolean("invokedbyplugin");
        } else if (dataString == null || dataString.length() <= 0) {
            return false;
        } else {
            bVar.I.f23861a = 1000;
            k.b("uppay", "nativeBrowser data:" + dataString);
        }
        int i11 = -13268007;
        if (extras != null) {
            bVar.aM = extras.getBoolean("dlgstyle", false);
            String string = extras.getString("url_index");
            if (string != null && Pattern.compile("[^0-9]+").matcher(string).matches()) {
                bVar.aO = Integer.parseInt(string);
            }
            String string2 = extras.getString("server");
            if (string2 != null && !TextUtils.isEmpty(string2)) {
                bVar.f23524bk = string2;
            }
            com.unionpay.mobile.android.global.a.M = extras.getInt("navbargb", -10705958);
            i11 = extras.getInt("divlinecolor", -13268007);
        } else {
            bVar.aM = false;
            com.unionpay.mobile.android.global.a.M = -10705958;
        }
        com.unionpay.mobile.android.global.a.N = i11;
        c cVar = bVar.I;
        int i12 = cVar.f23861a;
        if (i12 != 0) {
            if (i12 == 1) {
                String string3 = extras.getString("uppayuri");
                bVar.I.f23862b = extras.getString("resultIntentAction");
                k.a("uppay", " result Action=" + bVar.I.f23862b);
                z10 = a(string3, bVar);
            } else if (i12 != 2) {
                if (i12 == 3) {
                    cVar.f23863c = extras.getString("ex_mode");
                    bVar.I.f23867g = extras.getString("tencentUID");
                    bVar.I.f23868h = extras.getString("tencentWID");
                    String a10 = a(extras);
                    bVar.f23515b = a10;
                    if (a10 != null) {
                        if (a10.trim().length() > 0) {
                            String str2 = bVar.I.f23868h;
                            if (str2 != null) {
                            }
                        }
                    }
                    z10 = false;
                } else if (i12 != 4) {
                    if (i12 == 5) {
                        cVar.f23863c = extras.getString("ex_mode");
                        k.a("uppay", "mServerIdentifier = " + bVar.I.f23863c);
                        String string4 = extras.getString("appID");
                        bVar.f23531g = string4;
                        if (string4 == null) {
                            bVar.f23531g = "";
                        }
                        bVar.f23529e = extras.getString("amt");
                        bVar.f23528d = extras.getString("aid");
                        bVar.f23530f = true;
                        bVar.f23527c = true;
                        if (!TextUtils.isEmpty(bVar.f23529e)) {
                        }
                    } else if (i12 == 1000) {
                        z10 = a(dataString, bVar);
                    }
                    z10 = false;
                } else {
                    String string5 = extras.getString("paydata");
                    k.b("PluginEx", " paydata=" + string5);
                    z10 = b(a(string5), bVar);
                }
            }
            if (bVar.aM && !b.f23494bm) {
                com.unionpay.mobile.android.global.b.f23337b = -1;
                com.unionpay.mobile.android.global.b.f23338c = -2513882;
                com.unionpay.mobile.android.global.b.f23339d = -6745;
            }
            c cVar2 = bVar.I;
            i10 = cVar2.f23861a;
            if (i10 != 2 || i10 == 5 || i10 == 3) {
                cVar2.f23864d = true;
            }
            bVar.f23497a = !bVar.f23527c ? "1.9" : "1.4";
            return z10;
        }
        String string6 = extras.getString("ex_mode");
        if (string6 != null) {
            bVar.I.f23863c = string6;
        }
        k.a("uppay", "mServerIdentifier = " + bVar.I.f23863c);
        bVar.f23515b = a(extras);
        String string7 = extras.getString("appID");
        bVar.f23531g = string7;
        if (string7 == null) {
            bVar.f23531g = "";
        }
        String string8 = extras.getString(TelephonyUtil.KEY_SIM_ACTIVITIED_SOURCE);
        if (string8 != null) {
            b.f23494bm = string8.equals("samsung_out");
        }
        String string9 = extras.getString("frontNotifyByPlugin");
        bVar.U = string9 == null || string9.length() == 0;
        if (bVar.f23530f || (str = bVar.f23515b) == null || str.trim().length() <= 0) {
            z10 = false;
        } else {
            k.a("uppay", "tn from bundle:" + bVar.f23515b);
            bVar.f23527c = true;
            k.a("uppay", "dw.isNewTypeTn=" + bVar.f23527c);
            z10 = true;
        }
        bVar.f23542r = extras.getString("ResultURL");
        k.a("uppay", "result URL:" + bVar.f23542r);
        if (bVar.aM) {
            com.unionpay.mobile.android.global.b.f23337b = -1;
            com.unionpay.mobile.android.global.b.f23338c = -2513882;
            com.unionpay.mobile.android.global.b.f23339d = -6745;
        }
        c cVar22 = bVar.I;
        i10 = cVar22.f23861a;
        if (i10 != 2) {
        }
        cVar22.f23864d = true;
        bVar.f23497a = !bVar.f23527c ? "1.9" : "1.4";
        return z10;
    }

    private static boolean a(String str, b bVar) {
        boolean z10 = false;
        if (str != null) {
            String[] split = str.split("\\?");
            if (split.length < 2) {
                k.c("uppay", "uppay protocol params error!");
            } else {
                String str2 = split[1];
                k.a("uppay", "parseUPPayURIParams() +++ ");
                k.a("uppay", str2);
                String str3 = null;
                String str4 = null;
                for (String str5 : str2.split(ContainerUtils.FIELD_DELIMITER)) {
                    String[] split2 = str5.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split2.length >= 2) {
                        if (split2[0].equalsIgnoreCase("style")) {
                            str3 = split2[1];
                        } else if (split2[0].equalsIgnoreCase("paydata")) {
                            str4 = split2[1];
                        }
                    }
                }
                if (!(str3 == null || !str3.equalsIgnoreCase("token") || str4 == null)) {
                    k.a("uppay", "paydata=" + str4);
                    z10 = b(a(str4), bVar);
                }
                k.a("uppay", "parseUPPayURIParams() ---");
            }
        }
        return z10;
    }

    private static boolean b(String str, b bVar) {
        c cVar;
        String str2;
        if (str == null || str.length() == 0) {
            return false;
        }
        bVar.I.f23863c = "00";
        for (String str3 : str.split(",")) {
            String[] split = str3.trim().split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length >= 2) {
                if (split[0].trim().equalsIgnoreCase("tn")) {
                    bVar.f23515b = split[1].trim();
                } else if (split[0].trim().equalsIgnoreCase("usetestmode")) {
                    if (split[1].trim().equalsIgnoreCase("true")) {
                        cVar = bVar.I;
                        str2 = "01";
                    } else if (split[1].trim().equalsIgnoreCase("test")) {
                        cVar = bVar.I;
                        str2 = "02";
                    } else if (split[1].trim().equalsIgnoreCase("inner")) {
                        cVar = bVar.I;
                        str2 = "98";
                    }
                    cVar.f23863c = str2;
                } else if (split[0].trim().equalsIgnoreCase("ResultURL")) {
                    try {
                        bVar.f23542r = URLDecoder.decode(split[1].trim(), "UTF-8");
                    } catch (UnsupportedEncodingException e10) {
                        e10.printStackTrace();
                    }
                }
            }
        }
        String str4 = bVar.f23515b;
        return str4 != null && str4.length() > 0;
    }
}
