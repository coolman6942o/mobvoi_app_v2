package com.unionpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.amap.api.services.core.AMapException;
import com.huawei.nfc.sdk.service.HwOpenPayTask;
import com.mobvoi.wear.companion.setup.settings.SettingConstants;
import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import com.mobvoi.wear.providers.OtaColumn;
import com.unionpay.a.d;
import com.unionpay.b.g;
import com.unionpay.tsmservice.mi.data.Constant;
import com.unionpay.uppay.PayActivity;
import com.unionpay.utils.UPUtils;
import com.unionpay.utils.b;
import com.unionpay.utils.e;
import com.unionpay.utils.i;
import com.unionpay.utils.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class UPPayAssistEx {
    private static String A = null;
    private static String B = null;
    private static String C = "";
    private static String D = "";
    private static String E = "";
    private static String F = "";
    private static boolean G = false;
    private static int H = 10;
    private static Context I = null;
    private static String J = "";
    private static String K = null;
    private static String L = null;
    private static String M = "";
    private static String N = "";
    private static boolean O = false;
    private static String P = "";
    public static final int PLUGIN_NOT_FOUND = -1;
    public static final int PLUGIN_VALID = 0;
    private static int Q = 0;
    private static boolean R = false;
    private static boolean S = false;
    private static d T = null;
    private static Handler U = null;
    private static String V = "[{\"type\":\"app\",\"sort\":100,\"package_info\":[{\"schema\":\"com.unionpay\",\"version\":\"^[5-9]{1}+(.[0-9]{1})+(.[0-9]{1,3})?$\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":101}],\"need_install\":false,\"install_msg\":\"请先安装银联在线支付服务，安装完成后重新发起付款\",\"url\":\"https://mobile.unionpay.com/getclient?platform=android&type=securepayplugin\",\"download_app\":\"UPPayPluginEx.apk\",\"download_title\":\"银联在线支付服务\",\"download_desp\":\"正在下载银联在线支付服务…\",\"md5\":\"D75BB2802E61738A9A03BF014F927D9A\"},{\"type\":\"jar\",\"sort\":200}]";
    public static final String VERSION = "3.5.1";
    private static String W = "[{\"type\":\"app\",\"sort\":100,\"package_info\":[{\"schema\":\"com.unionpay.tsmservice\",\"version\":\"^[1-9].*|^0[2-9].*|^01\\.[1-9].*|^01\\.0[1-9].*|^01\\.00\\.[2-9].*|^01\\.00\\.1[012789].*|^01\\.00\\.0[8-9].*\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":102},{\"schema\":\"com.unionpay.tsmservice.mi\",\"version\":\"^[1-9].*|^0[2-9].*|^01\\.[1-9].*|^01\\.0[1-9].*|^01\\.00\\.[1-9].*|^01\\.00\\.0[8-9].*\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":103}],\"need_install\":false,\"install_msg\":\"请先安装银联在线支付服务，安装完成后重新发起付款\",\"url\":\"https://mobile.unionpay.com/getclient?platform=android&type=securepayplugin\",\"download_app\":\"UPPayPluginEx.apk\",\"download_title\":\"银联在线支付服务\",\"download_desp\":\"正在下载银联在线支付服务…\",\"md5\":\"D75BB2802E61738A9A03BF014F927D9A\"}]";
    private static JSONArray X = null;
    private static final Handler.Callback Y = new a();

    /* renamed from: a  reason: collision with root package name */
    private static String f23223a = "SpId";

    /* renamed from: b  reason: collision with root package name */
    private static String f23224b = "paydata";

    /* renamed from: c  reason: collision with root package name */
    private static String f23225c = "SysProvide";

    /* renamed from: d  reason: collision with root package name */
    private static String f23226d = "UseTestMode";

    /* renamed from: e  reason: collision with root package name */
    private static String f23227e = "SecurityChipType";

    /* renamed from: f  reason: collision with root package name */
    private static String f23228f = "uppayuri";

    /* renamed from: g  reason: collision with root package name */
    private static String f23229g = "resultIntentAction";

    /* renamed from: h  reason: collision with root package name */
    private static String f23230h = "reqOriginalId";

    /* renamed from: i  reason: collision with root package name */
    private static String f23231i = "wapurl";

    /* renamed from: j  reason: collision with root package name */
    private static String f23232j = "dlgstyle";

    /* renamed from: k  reason: collision with root package name */
    private static String f23233k = "com.unionpay.uppay";

    /* renamed from: l  reason: collision with root package name */
    private static String f23234l = "com.unionpay.uppay.PayActivity";

    /* renamed from: m  reason: collision with root package name */
    private static String f23235m = "com.huawei.wallet";

    /* renamed from: n  reason: collision with root package name */
    private static String f23236n = "com.huawei.wallet.action.onlinepay.startpay";

    /* renamed from: o  reason: collision with root package name */
    private static String f23237o = "ex_mode";

    /* renamed from: p  reason: collision with root package name */
    private static String f23238p = "server";

    /* renamed from: q  reason: collision with root package name */
    private static String f23239q = "source";

    /* renamed from: r  reason: collision with root package name */
    private static String f23240r = "samsung_out";

    /* renamed from: s  reason: collision with root package name */
    private static String f23241s = "se_type";

    /* renamed from: t  reason: collision with root package name */
    private static String f23242t = "se_title_logo";

    /* renamed from: u  reason: collision with root package name */
    private static String f23243u = "se_loading_logo";

    /* renamed from: v  reason: collision with root package name */
    private static String f23244v = "se_title_bg_color";

    /* renamed from: w  reason: collision with root package name */
    private static String f23245w = "se_cancel_bg_color";

    /* renamed from: x  reason: collision with root package name */
    private static String f23246x = "02";

    /* renamed from: y  reason: collision with root package name */
    private static String f23247y;

    /* renamed from: z  reason: collision with root package name */
    private static String f23248z;

    private static int a(Activity activity, String str, String str2) {
        try {
            String[] strArr = {"30820267308201d0a00302010202044", "ecb7d98300d06092a8", "64886f70d01010505003078310b30090603550", "406130238363111300f060355040813085", "368616e676", "861693111300f060355040713085368616e67686169311730", "15060355040a130e4368696e6120556e696f6e50617931173015060355040b130e4", "368696e612055", "6e696f6e5061793111300f06035504031308556e696f6e5061", "79301e170d3131313132323130343634385a170d333631313135313034", "3634385a3078310b300906035504061302383631", "11300f060355040813085368616e67686169311130", "0f060355040713085368616e676861693117", "3015060355040a130e4368696e6120556e696", "f6e50617931173015060355040b130e4368696e6120556e696", "f6e5061793111300f06035504031308556e696f6e50617930819f300d060", "92a864886f70d010101050003818d0030818902818100c42e6236d5054ffccaa", "a430ecd929d562", "b1ff56cef0e21c87260c63ce3ca868bf5974c14", "d9255940da7b6cd07483f4b4243fd1825b2705", "08eb9b5c67474d027fa03ce35109b11604083ab6bb4df2c46240f879f", "8cc1d6ed5e1b2cc00489215aec3fc2eac008e767b0215981cb5e", "e94ddc285669ec06b8a405dd4341eac4ea7030203010001300d06092a864886f70d010105050003818", "1001a3e74c601e3beb1b7ae4f9ab2872a0aaf1dbc2cba89c7528cd", "54aa526e7a37d8ba2311a1d3d2ab79b3fbeaf3ebb9e7da9e7cdd9be1ae5a53595f47", "b1fdf62b0f540fca5458b063af9354925a6c3505a18ff164b6b195f6e517eaee1fb783", "64c2f89fdffa16729c9779f99562bc189d2ce4722ba0faedb11aa22d0d9db228fda"};
            PackageManager packageManager = activity.getPackageManager();
            packageManager.getActivityInfo(activity.getComponentName(), 128);
            packageManager.getApplicationInfo("com.unionpay.uppay", 8192);
            PackageInfo packageInfo = packageManager.getPackageInfo("com.unionpay.uppay", 4160);
            String charsString = packageInfo.signatures[0].toCharsString();
            String str3 = "";
            for (int i10 = 0; i10 < 27; i10++) {
                str3 = str3 + strArr[i10];
            }
            if (!(charsString != null && charsString.equals(str3) && packageInfo.versionCode >= 31)) {
                return -1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt(f23230h, 1);
            bundle.putString(f23228f, str);
            bundle.putString(f23229g, str2);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            intent.setClassName(f23233k, f23234l);
            activity.startActivity(intent);
            return 0;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    private static int a(Context context, UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback, boolean z10) {
        return b.d(context, "com.unionpay.tsmservice.mi") ? new g(context, uPQuerySEPayInfoCallback, z10).a() : new com.unionpay.b.b(context, uPQuerySEPayInfoCallback, z10).a();
    }

    private static int a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        I = context;
        J = str3;
        K = str;
        L = str2;
        M = str4;
        E = str6;
        D = str5;
        F = TextUtils.isEmpty(str6) ? "0" : "1";
        f23247y = null;
        f23248z = null;
        A = null;
        if (!TextUtils.isEmpty(str6)) {
            C = str6;
        } else if (TextUtils.isEmpty(UPUtils.a(context, "se_type"))) {
            if (a(I, (UPQuerySEPayInfoCallback) new b(), false) == 0) {
                return 0;
            }
        }
        p();
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context) {
        return a(context, true, "0");
    }

    private static String a(Context context, boolean z10, String str) {
        int i10;
        NfcAdapter defaultAdapter;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                i10 = Integer.parseInt(M);
            } catch (NumberFormatException unused) {
                i10 = 0;
            }
            if (!z10) {
                jSONObject.put("tn", UPUtils.forWap(i10, b.a(J)));
            }
            jSONObject.put("v", "1.3");
            jSONObject.put("imei", e.b(context));
            jSONObject.put("locale", Locale.getDefault().toString().startsWith("zh") ? "zh_CN" : "en_US");
            jSONObject.put("terminal_version", VERSION);
            jSONObject.put("terminal_resolution", (context.getResources().getDisplayMetrics().widthPixels + MessageProxyConstants.NODE_ID_ANY + context.getResources().getDisplayMetrics().heightPixels).trim());
            jSONObject.put("os_name", "android");
            jSONObject.put("os_version", Build.VERSION.RELEASE.trim());
            String trim = Build.MODEL.trim();
            String str3 = "";
            if (trim != null) {
                trim.replace(" ", str3);
            }
            jSONObject.put("device_model", trim);
            jSONObject.put(Constant.KEY_MAC, e.a(context));
            try {
                jSONObject.put("time_zone", TimeZone.getDefault().getDisplayName(false, 0));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    str2 = "disConnect";
                } else if (activeNetworkInfo.getType() != 0) {
                    str2 = activeNetworkInfo.getType() == 1 ? "wifi" : "other";
                } else if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    str2 = "mobile:" + activeNetworkInfo.getExtraInfo();
                } else {
                    str2 = "mobile";
                }
                jSONObject.put("network_mode", str2);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            try {
                jSONObject.put("imsi", e.c(context));
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            try {
                jSONObject.put("baseband_version", e(e.a()));
            } catch (Exception e13) {
                e13.printStackTrace();
            }
            try {
                jSONObject.put("root", new File("/system/bin/su").exists() ? "1" : "0");
            } catch (Exception e14) {
                e14.printStackTrace();
            }
            try {
                StringBuffer stringBuffer = new StringBuffer(com.unionpay.tsmservice.data.Constant.DEFAULT_CVN2);
                int i11 = Build.VERSION.SDK_INT;
                if (i11 >= 10 && (defaultAdapter = ((NfcManager) context.getSystemService("nfc")).getDefaultAdapter()) != null) {
                    if (defaultAdapter.isEnabled()) {
                        stringBuffer.setCharAt(0, '1');
                    } else {
                        stringBuffer.setCharAt(0, '2');
                    }
                    if (i11 >= 19 && context.getPackageManager().hasSystemFeature("android.hardware.nfc.hce")) {
                        stringBuffer.setCharAt(1, '1');
                    }
                }
                jSONObject.put("support_map", stringBuffer.toString());
            } catch (Exception e15) {
                e15.printStackTrace();
            }
            jSONObject.put(SettingConstants.COUNTRY, e(Locale.getDefault().getCountry()));
            String packageName = ((Activity) context).getPackageName();
            if (packageName == null) {
                packageName = str3;
            }
            jSONObject.put("package", e(packageName));
            Location d10 = e.d(context);
            jSONObject.put("latitude", e(d10 != null ? Double.valueOf(d10.getLatitude()).toString() : str3));
            Location d11 = e.d(context);
            if (d11 != null) {
                str3 = Double.valueOf(d11.getLongitude()).toString();
            }
            jSONObject.put("longitude", e(str3));
            jSONObject.put("tel", e(e.e(context)));
            if (z10) {
                try {
                    String str4 = PayActivity.f24577a;
                    jSONObject.put("has_sdk", "1");
                } catch (ClassNotFoundException unused2) {
                    jSONObject.put("has_sdk", "0");
                }
            }
            jSONObject.put("seType", b.b(C));
            jSONObject.put("isLimitSe", F);
            jSONObject.put("mini", "0");
            jSONObject.put("vendorCapacity", str);
        } catch (PatternSyntaxException e16) {
            e16.printStackTrace();
        } catch (JSONException e17) {
            e17.printStackTrace();
        } catch (Exception unused3) {
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Context context, JSONArray jSONArray, int i10) {
        String str;
        while (jSONArray != null && i10 < jSONArray.length()) {
            Object a10 = i.a(jSONArray, i10);
            if (a10 != null) {
                JSONObject jSONObject = (JSONObject) a10;
                String a11 = i.a(jSONObject, "type");
                int i11 = 0;
                if (OtaColumn.COLUMN_APP.equals(a11)) {
                    JSONArray b10 = i.b(jSONObject, "package_info");
                    String a12 = i.a(jSONObject, "app_server");
                    JSONArray b11 = b(b10, "sort");
                    if (b11 != null && b11.length() > 0) {
                        int length = b11.length();
                        int i12 = 0;
                        while (true) {
                            if (i12 >= length) {
                                break;
                            }
                            Object a13 = i.a(b11, i12);
                            if (a13 != null) {
                                JSONObject jSONObject2 = (JSONObject) a13;
                                String a14 = i.a(jSONObject2, "schema");
                                String a15 = i.a(jSONObject2, "sign");
                                String a16 = i.a(jSONObject2, "version");
                                if (b.a(context, a14) && a15.equalsIgnoreCase(b.b(context, a14)) && b.c(context, a14).matches(a16)) {
                                    try {
                                        Bundle bundle = new Bundle();
                                        a(J, bundle, M);
                                        bundle.putString(f23223a, K);
                                        bundle.putString(f23225c, L);
                                        bundle.putString(f23224b, J);
                                        bundle.putString(f23239q, D);
                                        bundle.putString(f23241s, E);
                                        if (!TextUtils.isEmpty(E)) {
                                            bundle.putString(f23242t, f23247y);
                                            bundle.putString(f23243u, f23248z);
                                            bundle.putString(f23244v, A);
                                            bundle.putString(f23245w, B);
                                        }
                                        bundle.putBoolean(f23232j, G);
                                        bundle.putString(f23238p, a12);
                                        bundle.putString(f23227e, null);
                                        bundle.putInt(f23230h, 0);
                                        Intent intent = new Intent();
                                        intent.putExtras(bundle);
                                        if (f23235m.equals(a14)) {
                                            intent.setAction(f23236n);
                                            intent.setPackage(a14);
                                        } else {
                                            intent.setClassName(a14, f23234l);
                                        }
                                        Context context2 = I;
                                        if (context2 instanceof Activity) {
                                            ((Activity) context2).startActivityForResult(intent, H);
                                        } else {
                                            intent.addFlags(268435456);
                                            I.startActivity(intent);
                                        }
                                        i11 = 1;
                                    } catch (Exception e10) {
                                        e10.printStackTrace();
                                    }
                                }
                            }
                            i12++;
                        }
                    }
                    if (i11 != 0) {
                        return;
                    }
                } else if ("wap".equals(a11)) {
                    if (!f23240r.equals(D)) {
                        try {
                            str = (String) jSONObject.get("url");
                        } catch (Exception unused) {
                            str = "";
                        }
                        Bundle bundle2 = new Bundle();
                        a(J, bundle2, M);
                        bundle2.putString(f23223a, K);
                        bundle2.putString(f23225c, L);
                        bundle2.putString("magic_data", "949A1CC");
                        try {
                            i11 = Integer.parseInt(M);
                        } catch (NumberFormatException unused2) {
                        }
                        bundle2.putString(f23224b, UPUtils.forWap(i11, b.a(J)));
                        bundle2.putString(f23231i, str);
                        Intent intent2 = new Intent();
                        intent2.putExtras(bundle2);
                        intent2.setClass(I, UPPayWapActivity.class);
                        ((Activity) I).startActivityForResult(intent2, 100);
                        return;
                    }
                } else if ("jar".equals(a11)) {
                    a(i.a(jSONObject, "app_server"));
                    return;
                } else {
                    return;
                }
                jSONArray = X;
                i10 = Q + 1;
                Q = i10;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str) {
        Bundle bundle = new Bundle();
        a(J, bundle, M);
        bundle.putString(f23223a, K);
        bundle.putString(f23225c, L);
        bundle.putString(f23224b, J);
        bundle.putString(f23239q, D);
        bundle.putString(f23241s, E);
        if (!TextUtils.isEmpty(E)) {
            bundle.putString(f23242t, f23247y);
            bundle.putString(f23243u, f23248z);
            bundle.putString(f23244v, A);
            bundle.putString(f23245w, B);
        }
        bundle.putString(f23238p, str);
        bundle.putBoolean(f23232j, G);
        bundle.putInt(f23230h, 2);
        try {
            String str2 = PayActivity.f24577a;
            Intent intent = new Intent();
            intent.putExtras(bundle);
            intent.setClass(I, PayActivity.class);
            Context context = I;
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, H);
                return;
            }
            intent.addFlags(268435456);
            I.startActivity(intent);
        } catch (ClassNotFoundException unused) {
        }
    }

    private static void a(String str, Bundle bundle, String str2) {
        if (str != null && str.trim().length() > 0) {
            if (str.trim().charAt(0) != '<') {
                bundle.putString(f23237o, str2);
            } else if (str2 == null || !str2.trim().equalsIgnoreCase("00")) {
                bundle.putBoolean(f23226d, true);
            } else {
                bundle.putBoolean(f23226d, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONArray b(JSONArray jSONArray, String str) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            arrayList.add(jSONArray.optJSONObject(i10));
        }
        Collections.sort(arrayList, new e(str));
        JSONArray jSONArray2 = new JSONArray();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            jSONArray2.put((JSONObject) arrayList.get(i11));
        }
        return jSONArray2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) {
        int i10;
        try {
            i10 = Integer.parseInt(M);
        } catch (NumberFormatException unused) {
            i10 = 0;
        }
        String forUrl = UPUtils.forUrl(i10);
        j.a("uppay", "url: " + forUrl);
        T = new d(forUrl);
        T.a(a(context, false, str));
        if (U == null) {
            U = new Handler(Y);
        }
        Executors.newSingleThreadExecutor().execute(new c());
    }

    public static boolean checkWalletInstalled(Context context) {
        return b.a(context, "com.unionpay") && "536C79B93ACFBEA950AE365D8CE1AEF91FEA9535".equalsIgnoreCase(b.b(context, "com.unionpay"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            f23247y = jSONObject.getString("titleLogo");
            f23248z = jSONObject.getString("loadingLogo");
            A = jSONObject.getString("backGroundColor");
            B = jSONObject.getString("textColor");
        } catch (Exception unused) {
        }
    }

    private static String e(String str) {
        return str != null ? Pattern.compile("[\":,\\[\\]{}]").matcher(str).replaceAll("").trim() : "";
    }

    public static int getSEPayInfo(Context context, UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback) {
        return a(context, uPQuerySEPayInfoCallback, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int p() {
        int i10;
        if (I == null) {
            return 1;
        }
        if (!TextUtils.isEmpty(D) || !TextUtils.isEmpty(E)) {
            G = true;
            if (f23246x.equalsIgnoreCase(E)) {
                D = f23240r;
            }
        } else {
            G = false;
        }
        Q = 0;
        R = false;
        S = false;
        System.loadLibrary("entryexpro");
        String a10 = UPUtils.a(I, "configs" + E);
        String a11 = UPUtils.a(I, "mode" + E);
        String a12 = UPUtils.a(I, "or" + E);
        if (!TextUtils.isEmpty(a10) && !TextUtils.isEmpty(a11) && !TextUtils.isEmpty(a12)) {
            try {
                JSONObject jSONObject = new JSONObject(a10);
                String a13 = i.a(jSONObject, "sign");
                try {
                    i10 = Integer.parseInt(a11);
                } catch (NumberFormatException unused) {
                    i10 = 0;
                }
                String str = new String(Base64.decode(jSONObject.getString("configs"), 2));
                String str2 = "";
                String str3 = jSONObject.has("sePayConf") ? new String(Base64.decode(jSONObject.getString("sePayConf"), 2)) : str2;
                if (!TextUtils.isEmpty(str3)) {
                    str2 = str3;
                }
                String a14 = b.a(UPUtils.a(str + str2 + a12));
                String forConfig = UPUtils.forConfig(i10, a13);
                if (!TextUtils.isEmpty(forConfig) && forConfig.equals(a14)) {
                    if (TextUtils.isEmpty(E)) {
                        V = str;
                    } else {
                        W = str;
                    }
                    if (!TextUtils.isEmpty(C)) {
                        String a15 = UPUtils.a(I, "se_configs" + C);
                        if (!TextUtils.isEmpty(a15)) {
                            d(a15);
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        }
        try {
            X = b(TextUtils.isEmpty(E) ? new JSONArray(V) : new JSONArray(W), "sort");
        } catch (Exception unused3) {
        }
        U = new Handler(Y);
        if (TextUtils.isEmpty(E) || !b.a()) {
            b(I, "0");
        } else {
            HwOpenPayTask hwOpenPayTask = new HwOpenPayTask(I);
            U.sendEmptyMessageDelayed(AMapException.CODE_AMAP_DAILY_QUERY_OVER_LIMIT, 1000L);
            hwOpenPayTask.supportCapacity("UNIONONLINEPAY", new d());
        }
        return 0;
    }

    public static void releaseMemory() {
        I = null;
    }

    public static int startPay(Context context, String str, String str2, String str3, String str4) {
        return a(context, str, str2, str3, str4, "", "");
    }

    public static void startPayByJAR(Context context, Class cls, String str, String str2, String str3, String str4) {
        startPay(context, str, str2, str3, str4);
    }

    public static int startPayFromBrowser(Activity activity, String str, String str2) {
        return a(activity, str, str2);
    }

    public static int startSEPay(Context context, String str, String str2, String str3, String str4, String str5) {
        return a(context, str, str2, str3, str4, "", str5);
    }

    public static void startSamsungPay(Context context, Class cls, String str, String str2, String str3, String str4) {
        a(context, str, str2, str3, str4, f23240r, f23246x);
    }
}
