package com.huawei.hianalytics.mn.op.no;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Pair;
import com.huawei.hianalytics.mn.no.b.no;
import com.huawei.hianalytics.mn.no.no.mn;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.mobvoi.wear.lpa.LpaConstants;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class op extends mn {
    public static String op() {
        String str;
        String str2 = "";
        try {
            String str3 = (String) Class.forName("com.huawei.android.os.BuildEx").getMethod("getUDID", new Class[0]).invoke(null, new Object[0]);
            try {
                com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "getUDID success");
                return str3;
            } catch (AndroidRuntimeException unused) {
                str2 = str3;
                str = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
                com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", str);
                return str2;
            } catch (ClassNotFoundException unused2) {
                str2 = str3;
                str = "getUDID method invoke failed";
                com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", str);
                return str2;
            } catch (IllegalAccessException unused3) {
                str2 = str3;
                str = "getUDID method invoke failed : Illegal AccessException";
                com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", str);
                return str2;
            } catch (IllegalArgumentException unused4) {
                str2 = str3;
                str = "getUDID method invoke failed : Illegal ArgumentException";
                com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", str);
                return str2;
            } catch (NoSuchMethodException unused5) {
                str2 = str3;
                str = "getUDID method invoke failed : NoSuchMethodException";
                com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", str);
                return str2;
            } catch (InvocationTargetException unused6) {
                str2 = str3;
                str = "getUDID method invoke failed : InvocationTargetException";
                com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", str);
                return str2;
            }
        } catch (AndroidRuntimeException unused7) {
        } catch (ClassNotFoundException unused8) {
        } catch (IllegalAccessException unused9) {
        } catch (IllegalArgumentException unused10) {
        } catch (NoSuchMethodException unused11) {
        } catch (InvocationTargetException unused12) {
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String qr(Context context) {
        if (no.mn(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
            return telephonyManager != null ? telephonyManager.getDeviceId() : "";
        } catch (SecurityException unused) {
            com.huawei.hianalytics.mn.no.qr.mn.pq("hmsSdk", "getDeviceID Incorrect permissions!");
            return "";
        }
    }

    public static String rs(Context context) {
        String str = Build.SERIAL;
        return (TextUtils.isEmpty(str) || str.equalsIgnoreCase("unknown")) ? tu(context) : str;
    }

    public static Pair<String, String> st(Context context) {
        if (no.mn(context, "android.permission.READ_PHONE_STATE")) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "getMccAndMnc() Pair value is empty");
            return new Pair<>("", "");
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
        if (telephonyManager != null && telephonyManager.getSimState() == 5) {
            String networkOperator = telephonyManager.getNetworkOperator();
            return (TextUtils.isEmpty(networkOperator) || TextUtils.equals(networkOperator, LpaConstants.VALUE_NULL)) ? new Pair<>("", "") : networkOperator.length() > 3 ? new Pair<>(networkOperator.substring(0, 3), networkOperator.substring(3)) : new Pair<>("", "");
        }
        return new Pair<>("", "");
    }

    private static String tu(Context context) {
        com.huawei.hianalytics.mn.no.qr.mn.mn("hmsSdk", "getSerial : is executed.");
        if (context == null || no.mn(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        try {
            return Build.VERSION.SDK_INT >= 26 ? Build.getSerial() : "";
        } catch (SecurityException unused) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "getSerial() Incorrect permissions!");
            return "";
        }
    }
}
