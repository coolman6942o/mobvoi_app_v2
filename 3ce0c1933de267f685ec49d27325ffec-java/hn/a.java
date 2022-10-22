package hn;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.widget.Toast;
import com.mobvoi.wear.companion.setup.settings.SettingConstants;
import com.mobvoi.wear.providers.OtaColumn;
import com.unionpay.tsmservice.mi.data.Constant;
import gn.u;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f27887a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f27888b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f27889c = "";

    /* renamed from: d  reason: collision with root package name */
    private static String f27890d = "";

    /* renamed from: f  reason: collision with root package name */
    private static Handler f27892f;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f27891e = true;

    /* renamed from: g  reason: collision with root package name */
    private static AbstractC0303a f27893g = null;

    /* renamed from: hn.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0303a {
        void a(ArrayList<String> arrayList, ArrayList<String> arrayList2, String str, String str2, String str3, String str4, String str5, String str6, int i10, boolean z10);

        void b(ArrayList<String> arrayList, ArrayList<String> arrayList2, String str, String str2, String str3, String str4, String str5, String str6, int i10, boolean z10);
    }

    /* loaded from: classes2.dex */
    static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f27894a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f27895b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f27896c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f27897d;

        b(Context context, String str, String str2, boolean z10) {
            this.f27894a = context;
            this.f27895b = str;
            this.f27896c = str2;
            this.f27897d = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = a.f27888b = in.a.b(this.f27894a);
            } catch (Exception unused2) {
                Toast.makeText(this.f27894a, a.f27887a.toString(), 1).show();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appkey", a.f27888b);
                jSONObject.put("btname", this.f27895b);
                jSONObject.put("versionname", this.f27896c);
                if (a.f27890d != null && !a.f27890d.equals("")) {
                    jSONObject.put(Constant.KEY_MAC, a.f27890d);
                }
                if (a.f27889c != null && !a.f27889c.equals("")) {
                    jSONObject.put(SettingConstants.LANGUAGE, a.f27889c);
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            if (!in.a.c(this.f27894a)) {
                return;
            }
            if (!this.f27897d || in.a.d(this.f27894a)) {
                jn.a a10 = in.d.a(in.b.f28345c + "/api/client/getBtVersionUpdate", jSONObject.toString());
                u.d("onBtImgUpdate", "gsj--BleUp--updateObject=" + jSONObject + ",url=" + in.b.f28345c + "/api/client/getBtVersionUpdate");
                if (a10.b() == 200) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(a10.a());
                        if (Integer.parseInt(jSONObject2.getString("flag")) > 0) {
                            JSONArray jSONArray = jSONObject2.getJSONArray("fileurl");
                            ArrayList<String> arrayList = new ArrayList<>();
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                                String string = jSONArray.getJSONObject(i10).getString("urlname");
                                String string2 = jSONArray.getJSONObject(i10).getString("urladdress");
                                arrayList.add(string);
                                arrayList2.add(string2);
                            }
                            String string3 = jSONObject2.getString("msg");
                            String string4 = jSONObject2.getString("forceupdate");
                            String string5 = jSONObject2.getString(OtaColumn.COLUMN_DESCRIPTION);
                            String string6 = jSONObject2.getString("pubtime");
                            String string7 = jSONObject2.getString("versionname");
                            String string8 = jSONObject2.getString("btname");
                            if (a.f27893g != null) {
                                a.f27893g.a(arrayList, arrayList2, string3, string4, string5, string6, string7, string8, a10.b(), true);
                            }
                        } else if (a.f27893g != null) {
                            a.f27893g.a(null, null, "", "", "", "", "", "", a10.b(), false);
                        }
                    } catch (JSONException e11) {
                        e11.printStackTrace();
                    }
                } else {
                    if (a.f27893g != null) {
                        a.f27893g.a(null, null, "", "", "", "", "", "", a10.b(), false);
                    }
                    in.a.f("error", a10.a());
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f27898a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f27899b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f27900c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f27901d;

        c(Context context, String str, String str2, boolean z10) {
            this.f27898a = context;
            this.f27899b = str;
            this.f27900c = str2;
            this.f27901d = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = a.f27888b = in.a.b(this.f27898a);
            } catch (Exception unused2) {
                Toast.makeText(this.f27898a, a.f27887a.toString(), 0).show();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appkey", a.f27888b);
                jSONObject.put("btname", this.f27899b);
                jSONObject.put("versioncode", this.f27900c);
                if (a.f27890d != null && !a.f27890d.equals("")) {
                    jSONObject.put(Constant.KEY_MAC, a.f27890d);
                }
                if (a.f27889c != null && !a.f27889c.equals("")) {
                    jSONObject.put(SettingConstants.LANGUAGE, a.f27889c);
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            if (!in.a.c(this.f27898a)) {
                return;
            }
            if (!this.f27901d || in.a.d(this.f27898a)) {
                jn.a a10 = in.d.a(in.b.f28345c + "/api/client/getPatchlicationUpdate", jSONObject.toString());
                if (a10.b() == 200) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(a10.a());
                        if (Integer.parseInt(jSONObject2.getString("flag")) > 0) {
                            JSONArray jSONArray = jSONObject2.getJSONArray("fileurl");
                            ArrayList<String> arrayList = new ArrayList<>();
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                                String string = jSONArray.getJSONObject(i10).getString("urlname");
                                String string2 = jSONArray.getJSONObject(i10).getString("urladdress");
                                arrayList.add(string);
                                arrayList2.add(string2);
                            }
                            String string3 = jSONObject2.getString("msg");
                            String string4 = jSONObject2.getString("forceupdate");
                            String string5 = jSONObject2.getString(OtaColumn.COLUMN_DESCRIPTION);
                            String string6 = jSONObject2.getString("pubtime");
                            String string7 = jSONObject2.getString("versionname");
                            String string8 = jSONObject2.getString("versioncode");
                            if (a.f27893g != null) {
                                a.f27893g.b(arrayList, arrayList2, string3, string4, string5, string6, string7, string8, a10.b(), true);
                            }
                        } else if (a.f27893g != null) {
                            a.f27893g.b(null, null, "", "", "", "", "", "", a10.b(), false);
                        }
                    } catch (JSONException e11) {
                        e11.printStackTrace();
                    }
                } else {
                    if (a.f27893g != null) {
                        a.f27893g.b(null, null, "", "", "", "", "", "", a10.b(), false);
                    }
                    in.a.f("error", a10.a());
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    static class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f27902a;

        d(Context context) {
            this.f27902a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.q(this.f27902a);
        }
    }

    static {
        new a();
    }

    private a() {
        HandlerThread handlerThread = new HandlerThread("yc_sdk");
        handlerThread.start();
        f27892f = new Handler(handlerThread.getLooper());
    }

    public static void h(Context context, String str, String str2, boolean z10, String str3, String str4) {
        f27890d = str3;
        f27889c = str4;
        f27892f.post(new b(context, str, str2, z10));
    }

    public static void i(Context context) {
        f27892f.post(new d(context));
    }

    public static void j(Context context, String str, String str2, boolean z10, String str3, String str4) {
        f27890d = str3;
        f27889c = str4;
        f27892f.post(new c(context, str, str2, z10));
    }

    public static void k(boolean z10) {
    }

    public static void l(String str) {
        in.b.f28345c = str;
    }

    public static void m(boolean z10) {
        in.b.f28344b = z10;
    }

    public static void n(Context context, int i10) {
        in.a.e("setDefaultReportPolicy->reportModel=" + i10);
        if (i10 == 0 || i10 == 1) {
            String packageName = context.getPackageName();
            SharedPreferences sharedPreferences = context.getSharedPreferences("agent_online_setting_" + packageName, 0);
            synchronized (in.b.f28346d) {
                sharedPreferences.edit().putInt("local_report_policy", i10).commit();
            }
        }
    }

    public static void o(AbstractC0303a aVar) {
        f27893g = aVar;
    }

    public static void p(boolean z10) {
        f27891e = z10;
        in.a.e("Agent.setUpdateOnlyWifi->mUpdateOnlyWifi value=" + f27891e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(Context context) {
        f27888b = in.a.b(context);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkey", f27888b);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        SharedPreferences.Editor edit = context.getSharedPreferences("agent_online_setting_" + context.getPackageName(), 0).edit();
        if (in.a.c(context)) {
            jn.a a10 = in.d.a(in.b.f28345c + "/api/client/getOnlineConfiguration", jSONObject2);
            try {
                in.a.e("Agent.updateOnlineConfigs->message=" + a10.a());
                if (a10.b() == 200) {
                    JSONObject jSONObject3 = new JSONObject(a10.a());
                    in.a.e("Agent.updateOnlineConfigs->uploadJSON=" + jSONObject3.toString());
                    Iterator<String> keys = jSONObject3.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string = jSONObject3.getString(next);
                        edit.putString(next, string);
                        if (next.equals("autogetlocation") && !string.toLowerCase().equals("true")) {
                            k(false);
                        }
                        if (next.equals("updateonlywifi") && !string.toLowerCase().equals("true")) {
                            p(false);
                        }
                        if (next.equals("reportpolicy") && string.equals("1")) {
                            n(context, 1);
                        }
                        if (next.equals("sessionmillis")) {
                            in.b.f28343a = Integer.parseInt(string) * 1000;
                        }
                    }
                    edit.commit();
                    return;
                }
                in.a.e("Agent.updateOnlineConfigs->error=" + a10.a());
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        } else {
            in.a.e("Agent.updateOnlineConfigs-> updateOnlineConfig network error");
        }
    }
}
