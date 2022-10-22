package r3;

import a4.d;
import a4.f;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: v  reason: collision with root package name */
    public static a f33365v;

    /* renamed from: w  reason: collision with root package name */
    public static final char[] f33366w = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '+', '/'};

    /* renamed from: a  reason: collision with root package name */
    public int f33367a = 10000;

    /* renamed from: b  reason: collision with root package name */
    public boolean f33368b = false;

    /* renamed from: c  reason: collision with root package name */
    public String f33369c = "https://h5.m.taobao.com/mlapp/olist.html";

    /* renamed from: d  reason: collision with root package name */
    public int f33370d = 10;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33371e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f33372f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33373g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f33374h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33375i = true;

    /* renamed from: j  reason: collision with root package name */
    public boolean f33376j = true;

    /* renamed from: k  reason: collision with root package name */
    public String f33377k = "";

    /* renamed from: l  reason: collision with root package name */
    public boolean f33378l = false;

    /* renamed from: m  reason: collision with root package name */
    public boolean f33379m = false;

    /* renamed from: n  reason: collision with root package name */
    public boolean f33380n = false;

    /* renamed from: o  reason: collision with root package name */
    public boolean f33381o = false;

    /* renamed from: p  reason: collision with root package name */
    public boolean f33382p = true;

    /* renamed from: q  reason: collision with root package name */
    public String f33383q = "";

    /* renamed from: r  reason: collision with root package name */
    public String f33384r = "";

    /* renamed from: s  reason: collision with root package name */
    public boolean f33385s = false;

    /* renamed from: t  reason: collision with root package name */
    public List<b> f33386t = null;

    /* renamed from: u  reason: collision with root package name */
    public int f33387u = -1;

    /* renamed from: r3.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0457a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y3.a f33388a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f33389b;

        public RunnableC0457a(y3.a aVar, Context context) {
            this.f33388a = aVar;
            this.f33389b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                v3.b g10 = new w3.b().g(this.f33388a, this.f33389b);
                if (g10 != null) {
                    a.this.n(g10.a());
                    a.this.f(y3.a.o());
                }
            } catch (Throwable th2) {
                d.d(th2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f33391a;

        /* renamed from: b  reason: collision with root package name */
        public final int f33392b;

        /* renamed from: c  reason: collision with root package name */
        public final String f33393c;

        public b(String str, int i10, String str2) {
            this.f33391a = str;
            this.f33392b = i10;
            this.f33393c = str2;
        }

        public static List<b> a(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                b d10 = d(jSONArray.optJSONObject(i10));
                if (d10 != null) {
                    arrayList.add(d10);
                }
            }
            return arrayList;
        }

        public static JSONArray b(List<b> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (b bVar : list) {
                jSONArray.put(c(bVar));
            }
            return jSONArray;
        }

        public static JSONObject c(b bVar) {
            if (bVar == null) {
                return null;
            }
            try {
                return new JSONObject().put("pn", bVar.f33391a).put("v", bVar.f33392b).put("pk", bVar.f33393c);
            } catch (JSONException e10) {
                d.d(e10);
                return null;
            }
        }

        public static b d(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new b(jSONObject.optString("pn"), jSONObject.optInt("v", 0), jSONObject.optString("pk"));
        }

        public String toString() {
            return String.valueOf(c(this));
        }
    }

    private int F() {
        String d10 = y3.b.e().d();
        if (TextUtils.isEmpty(d10)) {
            return -1;
        }
        String replaceAll = d10.replaceAll(ContainerUtils.KEY_VALUE_DELIMITER, "");
        if (replaceAll.length() >= 5) {
            replaceAll = replaceAll.substring(0, 5);
        }
        int a10 = (int) (a(replaceAll) % 10000);
        return a10 < 0 ? a10 * (-1) : a10;
    }

    public static a G() {
        if (f33365v == null) {
            a aVar = new a();
            f33365v = aVar;
            aVar.C();
        }
        return f33365v;
    }

    private JSONObject H() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timeout", u());
        jSONObject.put("h5_port_degrade", D());
        jSONObject.put("tbreturl", A());
        jSONObject.put("configQueryInterval", l());
        jSONObject.put("launchAppSwitch", b.b(v()));
        jSONObject.put("scheme_pay_2", s());
        jSONObject.put("intercept_batch", r());
        jSONObject.put("deg_log_mcgw", o());
        jSONObject.put("deg_start_srv_first", p());
        jSONObject.put("prev_jump_dual", w());
        jSONObject.put("use_sc_only", q());
        jSONObject.put("bind_use_imp", h());
        jSONObject.put("retry_bnd_once", x());
        jSONObject.put("skip_trans", z());
        jSONObject.put("start_trans", E());
        jSONObject.put("up_before_pay", B());
        jSONObject.put("use_sc_lck_a", y());
        jSONObject.put("lck_k", t());
        jSONObject.put("bind_with_startActivity", k());
        return jSONObject;
    }

    public static long a(String str) {
        return b(str, 6);
    }

    public static long b(String str, int i10) {
        int i11;
        int pow = (int) Math.pow(2.0d, i10);
        int length = str.length();
        long j10 = 0;
        int i12 = length;
        for (int i13 = 0; i13 < length; i13++) {
            j10 += Integer.parseInt(String.valueOf(j(str.substring(i13, i11)))) * ((long) Math.pow(pow, i12 - 1));
            i12--;
        }
        return j10;
    }

    private void c(JSONObject jSONObject) {
        this.f33367a = jSONObject.optInt("timeout", 10000);
        this.f33368b = jSONObject.optBoolean("h5_port_degrade", false);
        this.f33369c = jSONObject.optString("tbreturl", "https://h5.m.taobao.com/mlapp/olist.html").trim();
        this.f33370d = jSONObject.optInt("configQueryInterval", 10);
        this.f33386t = b.a(jSONObject.optJSONArray("launchAppSwitch"));
        this.f33371e = jSONObject.optBoolean("scheme_pay_2", true);
        this.f33372f = jSONObject.optBoolean("intercept_batch", true);
        this.f33374h = jSONObject.optBoolean("deg_log_mcgw", false);
        this.f33375i = jSONObject.optBoolean("deg_start_srv_first", true);
        this.f33376j = jSONObject.optBoolean("prev_jump_dual", true);
        this.f33377k = jSONObject.optString("use_sc_only", "");
        this.f33378l = jSONObject.optBoolean("bind_use_imp", false);
        this.f33379m = jSONObject.optBoolean("retry_bnd_once", false);
        this.f33380n = jSONObject.optBoolean("skip_trans", false);
        this.f33381o = jSONObject.optBoolean("start_trans", false);
        this.f33382p = jSONObject.optBoolean("up_before_pay", true);
        this.f33383q = jSONObject.optString("lck_k", "");
        this.f33385s = jSONObject.optBoolean("use_sc_lck_a", false);
        this.f33384r = jSONObject.optString("bind_with_startActivity", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(y3.a aVar) {
        try {
            JSONObject H = H();
            f.c(aVar, y3.b.e().c(), "alipay_cashier_dynamic_config", H.toString());
        } catch (Exception e10) {
            d.d(e10);
        }
    }

    public static int j(String str) {
        for (int i10 = 0; i10 < 64; i10++) {
            if (str.equals(String.valueOf(f33366w[i10]))) {
                return i10;
            }
        }
        return 0;
    }

    private void m(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                c(new JSONObject(str));
            } catch (Throwable th2) {
                d.d(th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("st_sdk_config");
                if (optJSONObject != null) {
                    c(optJSONObject);
                } else {
                    d.i("DynCon", "empty config");
                }
            } catch (Throwable th2) {
                d.d(th2);
            }
        }
    }

    public String A() {
        return this.f33369c;
    }

    public boolean B() {
        return this.f33382p;
    }

    public void C() {
        Context c10 = y3.b.e().c();
        String b10 = f.b(y3.a.o(), c10, "alipay_cashier_dynamic_config", null);
        try {
            this.f33387u = Integer.parseInt(f.b(y3.a.o(), c10, "utdid_factor", "-1"));
        } catch (Exception unused) {
        }
        m(b10);
    }

    public boolean D() {
        return this.f33368b;
    }

    public boolean E() {
        return this.f33381o;
    }

    public void g(y3.a aVar, Context context, boolean z10) {
        RunnableC0457a aVar2 = new RunnableC0457a(aVar, context);
        if (!z10) {
            Thread thread = new Thread(aVar2);
            thread.setName("AlipayDCP");
            thread.start();
        } else if (!com.alipay.sdk.util.b.q(600L, aVar2, "AlipayDCPBlok")) {
            p3.a.h(aVar, "biz", "LogAppFetchConfigTimeout", "");
        }
    }

    public boolean h() {
        return this.f33378l;
    }

    public boolean i(Context context, int i10) {
        if (this.f33387u == -1) {
            this.f33387u = F();
            f.c(y3.a.o(), context, "utdid_factor", String.valueOf(this.f33387u));
        }
        return this.f33387u < i10;
    }

    public String k() {
        return this.f33384r;
    }

    public int l() {
        return this.f33370d;
    }

    public boolean o() {
        return this.f33374h;
    }

    public boolean p() {
        return this.f33375i;
    }

    public String q() {
        return this.f33377k;
    }

    public boolean r() {
        return this.f33372f;
    }

    public boolean s() {
        return this.f33371e;
    }

    public String t() {
        return this.f33383q;
    }

    public int u() {
        int i10 = this.f33367a;
        if (i10 < 1000 || i10 > 20000) {
            d.f("DynCon", "time(def) = 10000");
            return 10000;
        }
        d.f("DynCon", "time = " + this.f33367a);
        return this.f33367a;
    }

    public List<b> v() {
        return this.f33386t;
    }

    public boolean w() {
        return this.f33376j;
    }

    public boolean x() {
        return this.f33379m;
    }

    public boolean y() {
        return this.f33385s;
    }

    public boolean z() {
        return this.f33380n;
    }
}
