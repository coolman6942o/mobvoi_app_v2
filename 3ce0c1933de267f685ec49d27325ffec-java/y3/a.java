package y3;

import a4.d;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.util.b;
import com.huawei.hms.framework.common.ContainerUtils;
import com.mobvoi.wear.lpa.LpaConstants;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f36735a;

    /* renamed from: b  reason: collision with root package name */
    public String f36736b;

    /* renamed from: c  reason: collision with root package name */
    public Context f36737c;

    /* renamed from: d  reason: collision with root package name */
    public final String f36738d;

    /* renamed from: e  reason: collision with root package name */
    public final long f36739e = SystemClock.elapsedRealtime();

    /* renamed from: f  reason: collision with root package name */
    public final int f36740f = b.N();

    /* renamed from: g  reason: collision with root package name */
    public final String f36741g;

    /* renamed from: h  reason: collision with root package name */
    public final ActivityInfo f36742h;

    /* renamed from: i  reason: collision with root package name */
    public final p3.b f36743i;

    /* renamed from: y3.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0536a {

        /* renamed from: a  reason: collision with root package name */
        public static final HashMap<UUID, a> f36744a = new HashMap<>();

        /* renamed from: b  reason: collision with root package name */
        public static final HashMap<String, a> f36745b = new HashMap<>();

        public static a a(Intent intent) {
            if (intent == null) {
                return null;
            }
            Serializable serializableExtra = intent.getSerializableExtra("i_uuid_b_c");
            if (serializableExtra instanceof UUID) {
                return f36744a.remove((UUID) serializableExtra);
            }
            return null;
        }

        public static a b(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return f36745b.remove(str);
        }

        public static void c(a aVar, Intent intent) {
            if (aVar != null && intent != null) {
                UUID randomUUID = UUID.randomUUID();
                f36744a.put(randomUUID, aVar);
                intent.putExtra("i_uuid_b_c", randomUUID);
            }
        }

        public static void d(a aVar, String str) {
            if (aVar != null && !TextUtils.isEmpty(str)) {
                f36745b.put(str, aVar);
            }
        }
    }

    public a(Context context, String str, String str2) {
        String str3;
        this.f36735a = "";
        this.f36736b = "";
        this.f36737c = null;
        boolean isEmpty = TextUtils.isEmpty(str2);
        this.f36743i = new p3.b(context, isEmpty);
        String l10 = l(str, this.f36736b);
        this.f36738d = l10;
        ActivityInfo a10 = b.a(context);
        this.f36742h = a10;
        this.f36741g = str2;
        if (!isEmpty) {
            p3.a.c(this, "biz", "eptyp", str2 + "|" + l10);
            if (a10 != null) {
                str3 = a10.name + "|" + a10.launchMode;
            } else {
                str3 = LpaConstants.VALUE_NULL;
            }
            p3.a.c(this, "biz", "actInfo", str3);
            p3.a.c(this, "biz", "sys", b.l(this));
        }
        try {
            this.f36737c = context.getApplicationContext();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.f36735a = packageInfo.versionName;
            this.f36736b = packageInfo.packageName;
        } catch (Exception e10) {
            d.d(e10);
        }
        if (!isEmpty) {
            p3.a.b(this, "biz", "u" + b.N());
            p3.a.c(this, "biz", "PgApiInvoke", "" + SystemClock.elapsedRealtime());
            p3.a.a(context, this, str, this.f36738d);
        }
        if (!isEmpty && r3.a.G().B()) {
            r3.a.G().g(this, this.f36737c, true);
        }
    }

    private String d(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(str2);
        for (int i10 = 0; i10 < split.length; i10++) {
            if (!TextUtils.isEmpty(split[i10]) && split[i10].startsWith(str3)) {
                return split[i10];
            }
        }
        return null;
    }

    private String e(String str, String str2, String str3, boolean z10) throws JSONException, UnsupportedEncodingException {
        JSONObject jSONObject;
        String substring = str.substring(str2.length());
        boolean z11 = false;
        String substring2 = substring.substring(0, substring.length() - str3.length());
        if (substring2.length() < 2 || !substring2.startsWith("\"") || !substring2.endsWith("\"")) {
            jSONObject = new JSONObject(substring2);
        } else {
            jSONObject = new JSONObject(substring2.substring(1, substring2.length() - 1));
            z11 = true;
        }
        if (!jSONObject.has("appkey")) {
            jSONObject.put("appkey", "2014052600006128");
        }
        if (!jSONObject.has("ty")) {
            jSONObject.put("ty", "and_lite");
        }
        if (!jSONObject.has("sv")) {
            jSONObject.put("sv", "h.a.3.8.02");
        }
        if (!jSONObject.has("an") && (!this.f36736b.contains("setting") || !b.T(this.f36737c))) {
            jSONObject.put("an", this.f36736b);
        }
        if (!jSONObject.has("av")) {
            jSONObject.put("av", this.f36735a);
        }
        if (!jSONObject.has("sdk_start_time")) {
            jSONObject.put("sdk_start_time", System.currentTimeMillis());
        }
        if (!jSONObject.has("extInfo")) {
            jSONObject.put("extInfo", m());
        }
        String jSONObject2 = jSONObject.toString();
        if (z11) {
            jSONObject2 = "\"" + jSONObject2 + "\"";
        }
        return str2 + jSONObject2 + str3;
    }

    public static HashMap<String, String> f(a aVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (aVar != null) {
            hashMap.put("sdk_ver", "15.8.02");
            hashMap.put("app_name", aVar.f36736b);
            hashMap.put("token", aVar.f36738d);
            hashMap.put("call_type", aVar.f36741g);
            hashMap.put("ts_api_invoke", String.valueOf(aVar.f36739e));
        }
        return hashMap;
    }

    private String h(String str) {
        try {
            String d10 = d(str, ContainerUtils.FIELD_DELIMITER, "bizcontext=");
            if (TextUtils.isEmpty(d10)) {
                str = str + ContainerUtils.FIELD_DELIMITER + i("bizcontext=", "");
            } else {
                int indexOf = str.indexOf(d10);
                str = str.substring(0, indexOf) + e(d10, "bizcontext=", "", true) + str.substring(indexOf + d10.length());
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    private String i(String str, String str2) throws JSONException, UnsupportedEncodingException {
        String c10 = c("", "");
        return str + c10 + str2;
    }

    private String k(String str) {
        try {
            String d10 = d(str, "\"&", "bizcontext=\"");
            if (TextUtils.isEmpty(d10)) {
                return str + ContainerUtils.FIELD_DELIMITER + i("bizcontext=\"", "\"");
            }
            if (!d10.endsWith("\"")) {
                d10 = d10 + "\"";
            }
            int indexOf = str.indexOf(d10);
            return str.substring(0, indexOf) + e(d10, "bizcontext=\"", "\"", false) + str.substring(indexOf + d10.length());
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String l(String str, String str2) {
        try {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[4];
            if (str == null) {
                str = "";
            }
            objArr[0] = str;
            if (str2 == null) {
                str2 = "";
            }
            objArr[1] = str2;
            objArr[2] = Long.valueOf(System.currentTimeMillis());
            objArr[3] = UUID.randomUUID().toString();
            return String.format("EP%s%s_%s", "1", b.L(String.format(locale, "%s%s%d%s", objArr)), Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable unused) {
            return "-";
        }
    }

    private JSONObject m() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ap_link_token", this.f36738d);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private boolean n(String str) {
        return !str.contains("\"&");
    }

    public static a o() {
        return null;
    }

    public Context a() {
        return this.f36737c;
    }

    public String b(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("new_external_info==")) {
            return str;
        }
        if (n(str)) {
            return h(str);
        }
        return k(str);
    }

    public String c(String str, String str2) {
        String str3;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", "2014052600006128");
            jSONObject.put("ty", "and_lite");
            jSONObject.put("sv", "h.a.3.8.02");
            if (!this.f36736b.contains("setting") || !b.T(this.f36737c)) {
                jSONObject.put("an", this.f36736b);
            }
            jSONObject.put("av", this.f36735a);
            jSONObject.put("sdk_start_time", System.currentTimeMillis());
            jSONObject.put("extInfo", m());
            if (this.f36742h != null) {
                str3 = this.f36742h.name + "|" + this.f36742h.launchMode;
            } else {
                str3 = LpaConstants.VALUE_NULL;
            }
            jSONObject.put("act_info", str3);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(str, str2);
            }
            return jSONObject.toString();
        } catch (Throwable th2) {
            d.d(th2);
            return "";
        }
    }

    public String g() {
        return this.f36736b;
    }

    public String j() {
        return this.f36735a;
    }
}
