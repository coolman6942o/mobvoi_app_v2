package p3;

import a4.d;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;
import p3.a;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f32552a;

    /* renamed from: b  reason: collision with root package name */
    public String f32553b;

    /* renamed from: c  reason: collision with root package name */
    public String f32554c;

    /* renamed from: d  reason: collision with root package name */
    public String f32555d;

    /* renamed from: e  reason: collision with root package name */
    public String f32556e;

    /* renamed from: f  reason: collision with root package name */
    public String f32557f;

    /* renamed from: g  reason: collision with root package name */
    public String f32558g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f32559h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f32560i;

    public b(Context context, boolean z10) {
        context = context != null ? context.getApplicationContext() : context;
        this.f32552a = k();
        this.f32553b = c(context);
        this.f32554c = b(z10 ? 0L : a.c.a(context));
        this.f32555d = a();
        this.f32556e = l(context);
        this.f32557f = "-";
        this.f32560i = "-";
    }

    public static String a() {
        return String.format("%s,%s,-,-,-", p(z3.a.a(y3.b.e().c()).g()), p(y3.b.e().d()));
    }

    public static String b(long j10) {
        String p10 = p("15.8.02");
        String p11 = p("h.a.3.8.02");
        return String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,%s,-", p10, p11, "~" + j10);
    }

    public static String c(Context context) {
        String packageName;
        String str = "-";
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                packageName = applicationContext.getPackageName();
                try {
                    PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(packageName, 64);
                    str = packageInfo.versionName + "|" + d(packageInfo);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
            }
            return String.format("%s,%s,-,-,-", p(packageName), p(str));
        }
        packageName = str;
        return String.format("%s,%s,-,-,-", p(packageName), p(str));
    }

    public static String d(PackageInfo packageInfo) {
        Signature[] signatureArr;
        String str;
        String m10;
        if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length == 0) {
            return "0";
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(packageInfo.signatures.length);
            for (Signature signature : packageInfo.signatures) {
                try {
                    m10 = com.alipay.sdk.util.b.m(null, signature.toByteArray());
                } catch (Throwable unused) {
                }
                if (TextUtils.isEmpty(m10)) {
                    str = "?";
                    sb2.append("-");
                    sb2.append(str);
                } else {
                    str = com.alipay.sdk.util.b.L(m10).substring(0, 8);
                    sb2.append("-");
                    sb2.append(str);
                }
            }
            return sb2.toString();
        } catch (Throwable unused2) {
            return "?";
        }
    }

    public static String f(Throwable th2) {
        if (th2 == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(th2.getClass().getName());
            stringBuffer.append(":");
            stringBuffer.append(th2.getMessage());
            stringBuffer.append(" 》 ");
            StackTraceElement[] stackTrace = th2.getStackTrace();
            if (stackTrace != null) {
                int i10 = 0;
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString());
                    stringBuffer.append(" 》 ");
                    i10++;
                    if (i10 > 5) {
                        break;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String k() {
        return String.format("%s,%s", t(), new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date()));
    }

    public static String l(Context context) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", p(a4.b.d(context)), "android", p(Build.VERSION.RELEASE), p(Build.MODEL), "-", p(a4.b.a(context).c()), p(a4.b.e(context).b()), "gw", p(a4.b.a(context).b()));
    }

    public static String m(String str) {
        String str2;
        String str3;
        if (str == null) {
            str = "";
        }
        String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
        String str4 = null;
        if (split != null) {
            str3 = null;
            str2 = null;
            for (String str5 : split) {
                String[] split2 = str5.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2 != null && split2.length == 2) {
                    if (split2[0].equalsIgnoreCase("partner")) {
                        str4 = split2[1].replace("\"", "");
                    } else if (split2[0].equalsIgnoreCase("out_trade_no")) {
                        str3 = split2[1].replace("\"", "");
                    } else if (split2[0].equalsIgnoreCase("trade_no")) {
                        str2 = split2[1].replace("\"", "");
                    } else if (split2[0].equalsIgnoreCase("biz_content")) {
                        try {
                            JSONObject jSONObject = new JSONObject(com.alipay.sdk.util.b.M(y3.a.o(), split2[1]));
                            if (TextUtils.isEmpty(str3)) {
                                str3 = jSONObject.getString("out_trade_no");
                            }
                        } catch (Throwable unused) {
                        }
                    } else if (split2[0].equalsIgnoreCase("app_id") && TextUtils.isEmpty(str4)) {
                        str4 = split2[1];
                    }
                }
            }
        } else {
            str3 = null;
            str2 = null;
        }
        return String.format("%s,%s,-,%s,-,-,-", p(str2), p(str3), p(str4));
    }

    public static String o() {
        return new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(new Date());
    }

    public static String p(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("[", "【").replace("]", "】").replace("(", "（").replace(")", "）").replace(",", "，").replace("^", "~").replace("#", "＃");
    }

    private synchronized void q(String str, String str2, String str3) {
        d.h("mspl", String.format("event %s %s %s", str, str2, str3));
        String str4 = "";
        if (!TextUtils.isEmpty(this.f32558g)) {
            str4 = str4 + "^";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str4);
        Object[] objArr = new Object[4];
        objArr[0] = TextUtils.isEmpty(str) ? "-" : p(str);
        objArr[1] = p(str2);
        objArr[2] = p(str3);
        objArr[3] = p(o());
        sb2.append(String.format("%s,%s,%s,-,-,-,-,-,-,-,-,-,-,%s", objArr));
        this.f32558g += sb2.toString();
    }

    public static String r(String str) {
        return TextUtils.isEmpty(str) ? "-" : str;
    }

    private synchronized void s(String str, String str2, String str3) {
        d.g("mspl", String.format("err %s %s %s", str, str2, str3));
        String str4 = "";
        if (!TextUtils.isEmpty(this.f32559h)) {
            str4 = str4 + "^";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str4);
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = TextUtils.isEmpty(str3) ? "-" : p(str3);
        objArr[3] = p(o());
        sb2.append(String.format("%s,%s,%s,%s", objArr));
        this.f32559h += sb2.toString();
    }

    public static String t() {
        try {
            return UUID.randomUUID().toString();
        } catch (Throwable unused) {
            return "12345678uuid";
        }
    }

    public String e(String str) {
        return String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", this.f32552a, m(str), this.f32553b, this.f32554c, this.f32555d, this.f32556e, this.f32557f, r(this.f32558g), r(this.f32559h), this.f32560i);
    }

    public void g(String str, String str2) {
        q("", str, str2);
    }

    public void h(String str, String str2, String str3) {
        q("", str, str2 + "|" + str3);
    }

    public void i(String str, String str2, Throwable th2) {
        s(str, str2, f(th2));
    }

    public void j(String str, String str2, Throwable th2, String str3) {
        String f10 = f(th2);
        s(str, str2, str3 + ": " + f10);
    }

    public void n(String str, String str2, String str3) {
        s(str, str2, str3);
    }
}
