package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.location.Location;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Build;
import android.widget.LinearLayout;
import com.mobvoi.wear.common.base.Constants;
import com.mobvoi.wear.companion.setup.settings.SettingConstants;
import com.mobvoi.wear.util.TelephonyUtil;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.f;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.widgets.ad;
import com.unionpay.tsmservice.mi.data.Constant;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class bh {
    public static LinearLayout a(Context context, JSONArray jSONArray, int i10, int i11) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(-1);
        linearLayout.setOrientation(1);
        new LinearLayout.LayoutParams(-1, -2).topMargin = a.f23313d;
        JSONObject jSONObject = null;
        while (i10 < i11 && i10 < jSONArray.length()) {
            try {
                jSONObject = jSONArray.getJSONObject(i10);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            linearLayout.addView(new ad(context, a.I, jSONObject, ""));
            i10++;
        }
        return linearLayout;
    }

    public static String a(Context context, String str, String str2, String str3, String str4, String str5) {
        NfcAdapter defaultAdapter;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tn", str);
            jSONObject.put(Constants.Setting.SUPER_POWER_SAVE_MODE_REASON_USER, f.c(context));
            jSONObject.put("locale", a(f.a()));
            jSONObject.put("terminal_version", c.bD.f23425a);
            jSONObject.put("terminal_resolution", f.d());
            jSONObject.put("os_name", str2);
            jSONObject.put("os_version", Build.VERSION.RELEASE.trim());
            jSONObject.put("device_model", a(f.c()));
            jSONObject.put("terminal_type", str3);
            jSONObject.put("appId", str4);
            jSONObject.put("uid", PreferenceUtils.a(context));
            jSONObject.put(Constant.KEY_MAC, a(f.b(context)));
            try {
                jSONObject.put("time_zone", a(f.f()));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            try {
                jSONObject.put("network_mode", f.e(context));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            try {
                jSONObject.put("imsi", a(f.d(context)));
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            try {
                jSONObject.put("baseband_version", a(f.e()));
            } catch (Exception e13) {
                e13.printStackTrace();
            }
            try {
                StringBuffer stringBuffer = new StringBuffer(com.unionpay.tsmservice.data.Constant.DEFAULT_CVN2);
                if (!com.unionpay.tsmservice.data.Constant.DEFAULT_CVN2.equals(str5)) {
                    stringBuffer.setCharAt(2, '1');
                }
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 10 && (defaultAdapter = ((NfcManager) context.getSystemService("nfc")).getDefaultAdapter()) != null) {
                    if (defaultAdapter.isEnabled()) {
                        stringBuffer.setCharAt(0, '1');
                    } else {
                        stringBuffer.setCharAt(0, '2');
                    }
                    if (i10 >= 19 && context.getPackageManager().hasSystemFeature("android.hardware.nfc.hce")) {
                        stringBuffer.setCharAt(1, '1');
                    }
                }
                jSONObject.put("support_map", stringBuffer.toString());
            } catch (Exception e14) {
                e14.printStackTrace();
            }
            try {
                jSONObject.put("se_map", str5);
            } catch (Exception e15) {
                e15.printStackTrace();
            }
            jSONObject.put("root", f.b());
            jSONObject.put(SettingConstants.COUNTRY, a(Locale.getDefault().getCountry()));
            jSONObject.put("package", a(f.a(context)));
            Location f10 = f.f(context);
            String str6 = "";
            jSONObject.put("latitude", a(f10 != null ? Double.valueOf(f10.getLatitude()).toString() : str6));
            Location f11 = f.f(context);
            if (f11 != null) {
                str6 = Double.valueOf(f11.getLongitude()).toString();
            }
            jSONObject.put("longitude", a(str6));
            jSONObject.put("tel", a(f.g(context)));
            jSONObject.put("packageId", com.unionpay.mobile.android.utils.c.b(context));
        } catch (PatternSyntaxException e16) {
            e16.printStackTrace();
        } catch (JSONException e17) {
            e17.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        String substring = jSONObject2.substring(1, jSONObject2.length() - 1);
        k.a("uppay", "init: " + substring);
        return substring;
    }

    private static String a(String str) throws PatternSyntaxException {
        return str != null ? Pattern.compile("[\":,\\[\\]{}]").matcher(str).replaceAll("").trim() : "";
    }

    public static String a(String str, String str2, String str3, String str4) {
        return String.format("\"first_pay_flag\":\"%s\",\"card\":\"%s\",\"pay_type\":\"%s\",\"pay_mode\":\"%s\"", str, str2, str3, str4);
    }

    public static String a(JSONObject jSONObject) {
        k.a("uppay", "action:" + j.a(jSONObject, TelephonyUtil.KEY_SIM_ACTION));
        return j.a(jSONObject, TelephonyUtil.KEY_SIM_ACTION);
    }

    public static String b(Context context, String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("amount", str);
            jSONObject.put("aid", str5);
            jSONObject.put(Constants.Setting.SUPER_POWER_SAVE_MODE_REASON_USER, f.c(context));
            jSONObject.put("locale", a(f.a()));
            jSONObject.put("terminal_version", c.bD.f23425a);
            jSONObject.put("terminal_resolution", f.d());
            jSONObject.put("os_name", str2);
            jSONObject.put("os_version", Build.VERSION.RELEASE.trim());
            jSONObject.put("device_model", a(f.c()));
            jSONObject.put("terminal_type", str3);
            jSONObject.put("appId", str4);
            jSONObject.put("uid", PreferenceUtils.a(context));
            jSONObject.put(Constant.KEY_MAC, a(f.b(context)));
            try {
                jSONObject.put("time_zone", a(f.f()));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            try {
                jSONObject.put("network_mode", f.e(context));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            try {
                jSONObject.put("imsi", a(f.d(context)));
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            try {
                jSONObject.put("baseband_version", a(f.e()));
            } catch (Exception e13) {
                e13.printStackTrace();
            }
            jSONObject.put("root", f.b());
            jSONObject.put(SettingConstants.COUNTRY, a(Locale.getDefault().getCountry()));
            jSONObject.put("package", a(f.a(context)));
        } catch (PatternSyntaxException e14) {
            e14.printStackTrace();
        } catch (JSONException e15) {
            e15.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        String substring = jSONObject2.substring(1, jSONObject2.length() - 1);
        k.c("uppay", "init: " + substring);
        return substring;
    }

    public static String b(String str, String str2, String str3, String str4) {
        return String.format("\"first_pay_flag\":\"%s\",%s,\"pay_type\":\"%s\",\"pay_mode\":\"%s\"", str, str2, str3, str4);
    }

    public static String c(String str, String str2, String str3, String str4) {
        return (str3 == null || str3.length() <= 0) ? String.format("\"pay_type\":\"%s\",\"pay_mode\":\"%s\",%s", str, str2, str4) : String.format("\"pay_type\":\"%s\",\"pay_mode\":\"%s\",%s,%s", str, str2, str3, str4);
    }
}
