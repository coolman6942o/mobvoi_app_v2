package com.tendcloud.tenddata;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.mobvoi.wear.providers.OtaColumn;
import com.tendcloud.tenddata.ah;
import com.tendcloud.tenddata.bh;
import com.tendcloud.tenddata.l;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class ay {

    /* renamed from: a  reason: collision with root package name */
    private static final int f22693a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final int f22694b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f22695c = 3;

    /* renamed from: i  reason: collision with root package name */
    private static String f22696i = null;

    /* renamed from: j  reason: collision with root package name */
    private static String f22697j = "TDpref_cloudcontrol";

    /* renamed from: k  reason: collision with root package name */
    private static final String f22698k = "TDpref_config";

    /* renamed from: l  reason: collision with root package name */
    private static final String f22699l = "TDpref_last_request_time";

    /* renamed from: m  reason: collision with root package name */
    private static final String f22700m = "TDpref_cloud_cv";

    /* renamed from: o  reason: collision with root package name */
    private static boolean f22702o;

    /* renamed from: s  reason: collision with root package name */
    private static String f22706s;

    /* renamed from: t  reason: collision with root package name */
    private static String f22707t;

    /* renamed from: u  reason: collision with root package name */
    private static String f22708u;

    /* renamed from: v  reason: collision with root package name */
    private static String f22709v;

    /* renamed from: d  reason: collision with root package name */
    private long f22712d = 720;

    /* renamed from: e  reason: collision with root package name */
    private long f22713e = 604800000;

    /* renamed from: f  reason: collision with root package name */
    private HashMap<String, JSONObject> f22714f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private HashSet<String> f22715g = new HashSet<>();

    /* renamed from: h  reason: collision with root package name */
    private JSONObject f22716h = new JSONObject();

    /* renamed from: x  reason: collision with root package name */
    private int f22717x;

    /* renamed from: y  reason: collision with root package name */
    private Handler f22718y;

    /* renamed from: n  reason: collision with root package name */
    private static String[] f22701n = {"232", "206", "284", "280", "219", "230", "238", "248", "244", "208", "308", "340", "543", "546", "547", "647", "742", "262", "202", "216", "272", "222", "247", "246", "270", "278", "204", "363", "362", "260", "268", "226", "231", "293", "214", "240", "234", "235", "266", "346", "348", "350", "354", "376", "750", "454", "455", "466", "525", "310", "311", "312", "313", "314", "315", "316", "330", "332", "534", "535", "544", "302", "505", "530", "548"};

    /* renamed from: p  reason: collision with root package name */
    private static boolean f22703p = true;

    /* renamed from: q  reason: collision with root package name */
    private static boolean f22704q = false;

    /* renamed from: r  reason: collision with root package name */
    private static boolean f22705r = true;

    /* renamed from: w  reason: collision with root package name */
    private static boolean f22710w = false;

    /* renamed from: z  reason: collision with root package name */
    private static boolean f22711z = true;
    private static volatile ay A = null;

    private ay() {
        this.f22718y = null;
        HandlerThread handlerThread = new HandlerThread("ModuleCloudControl", 10);
        handlerThread.start();
        this.f22718y = new Handler(handlerThread.getLooper()) { // from class: com.tendcloud.tenddata.ay.1
            String appId;
            String channelId;
            a features;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                try {
                    Object obj = message.obj;
                    if (obj != null) {
                        HashMap hashMap = (HashMap) obj;
                        this.appId = String.valueOf(hashMap.get("appId"));
                        this.channelId = String.valueOf(hashMap.get("channelId"));
                        this.features = (a) hashMap.get("Features");
                    }
                    int i10 = message.what;
                    if (i10 == 0) {
                        ay.this.b(this.appId, this.channelId, this.features);
                    } else if (i10 == 1) {
                        boolean unused = ay.f22711z = false;
                        ay.this.b(this.appId, this.channelId, this.features);
                    } else if (i10 == 3) {
                        bi biVar = new bi();
                        biVar.f22732b = OtaColumn.COLUMN_APP;
                        biVar.f22733c = "initaddition";
                        biVar.f22731a = this.features;
                        v.a().post(biVar);
                        bh bhVar = new bh();
                        bhVar.f22729a = this.features;
                        bhVar.f22730b = bh.a.IMMEDIATELY;
                        v.a().post(bhVar);
                    }
                } catch (Throwable th2) {
                    bf.postSDKError(th2);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, a aVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            a(jSONObject, "bl", Integer.valueOf(this.f22717x));
            a(jSONObject, "pl", (Object) 1);
            a(jSONObject, "sv", "5.0.0");
            a(jSONObject, "smcc", f22706s);
            a(jSONObject, "smnc", f22707t);
            a(jSONObject, "bmcc", f22708u);
            a(jSONObject, "bmnc", f22709v);
            a(jSONObject, "dt", "Mobile");
            a(jSONObject, "ov", j.a());
            a(jSONObject, "av", h.j());
            a(jSONObject, "px", j.b(ab.f22568h));
            a(jSONObject, "nt", m.l(ab.f22568h));
            a(jSONObject, "op", m.s(ab.f22568h));
            a(jSONObject, "ch", str2);
            a(jSONObject, "cv", Long.valueOf(o.b(ab.f22568h, f22697j, f22700m, 0L)));
            a(jSONObject, "TDID", i.a(ab.f22568h));
            if (!u.b(str)) {
                a(jSONObject, "AppID", str);
            }
            ak c10 = ae.c(ae.a().url(aa.f22543o).host("cloud.cpatrk.net").body(new ah(ah.a.JSON, jSONObject.toString().getBytes())).header(new ai().a("Accept-Encoding", "")).method(aj.POST).build());
            l.getFileLock(f22696i);
            String c11 = u.c(c10.c());
            if (c10.b() == 200) {
                b(a(new JSONObject(c11)));
                o.a(ab.f22568h, f22697j, f22699l, System.currentTimeMillis());
            } else if (f22711z) {
                HashMap hashMap = new HashMap();
                if (!u.b(str)) {
                    hashMap.put("appId", str);
                }
                hashMap.put("channelId", str2);
                hashMap.put("Features", aVar);
                this.f22718y.sendMessageDelayed(this.f22718y.obtainMessage(1, hashMap), 5000L);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    private void d() {
        try {
            f22697j += this.f22717x;
            f22696i = l.b.Cloud_Control_Lock_File.toString() + this.f22717x;
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    private boolean e() {
        long b10 = o.b(ab.f22568h, f22697j, f22699l, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (b10 == 0) {
            return true;
        }
        long j10 = currentTimeMillis - b10;
        return j10 > (this.f22712d * 60) * 1000 || j10 > this.f22713e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            ak c10 = ae.c(ae.a().host("cloud.cpatrk.net").url(aa.f22549u).method(aj.GET).build());
            if (c10 != null && c10.b() == 200) {
                f22703p = new JSONObject(new String(c10.c())).optBoolean("GDPRregion");
            }
        } catch (Throwable unused) {
        }
    }

    private void g() {
        try {
            if (this.f22716h.length() == 0) {
                String a10 = a(l.b(f22696i));
                JSONObject jSONObject = null;
                if (!u.b(a10)) {
                    jSONObject = new JSONObject(a10);
                }
                if (jSONObject != null && jSONObject.length() > 0) {
                    this.f22716h = jSONObject;
                }
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    private void h() {
        try {
            l.getFileLock(f22696i);
            String b10 = o.b(ab.f22568h, f22697j, f22698k, "");
            JSONObject jSONObject = null;
            if (!u.b(b10)) {
                jSONObject = new JSONObject(b10);
            }
            b(jSONObject);
        } finally {
            try {
            } finally {
            }
        }
    }

    private void i() {
        try {
            Iterator<String> keys = this.f22716h.keys();
            while (keys.hasNext()) {
                JSONObject jSONObject = this.f22716h.getJSONObject(keys.next());
                Iterator<String> keys2 = jSONObject.keys();
                ArrayList arrayList = new ArrayList();
                while (keys2.hasNext()) {
                    String next = keys2.next();
                    if (!this.f22715g.contains(next)) {
                        arrayList.add(next);
                    }
                }
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    jSONObject.remove((String) arrayList.get(i10));
                }
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    public void c() {
        a(l.b(f22696i), this.f22716h.toString());
        this.f22716h = new JSONObject();
    }

    public static ay a() {
        if (A == null) {
            synchronized (ay.class) {
                if (A == null) {
                    A = new ay();
                }
            }
        }
        return A;
    }

    public void a(String str, String str2, a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put("channelId", str2);
        hashMap.put("Features", aVar);
        this.f22717x = a(aVar);
        d();
        boolean z10 = h.e(aVar) == 1;
        f22704q = z10;
        if (z10) {
            if (!m.h(ab.f22568h)) {
                s.f22998a.execute(new Runnable() { // from class: com.tendcloud.tenddata.ay.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ay.this.f();
                    }
                });
                Handler handler = this.f22718y;
                handler.sendMessageDelayed(handler.obtainMessage(3, hashMap), 5000L);
                f22710w = true;
                return;
            }
            f22705r = false;
        }
        String p10 = m.p(ab.f22568h);
        String o10 = m.o(ab.f22568h);
        String str3 = "";
        f22706s = u.b(p10) ? str3 : p10.substring(0, 3);
        f22707t = u.b(p10) ? str3 : p10.substring(3);
        f22708u = u.b(o10) ? str3 : o10.substring(0, 3);
        if (!u.b(o10)) {
            str3 = o10.substring(3);
        }
        f22709v = str3;
        f22702o = b(f22706s) || b(f22708u);
        h();
        try {
            if (ab.f22578r || e()) {
                this.f22718y.sendMessage(this.f22718y.obtainMessage(0, hashMap));
            }
        } catch (Throwable unused) {
        }
        f22710w = true;
    }

    private void a(JSONObject jSONObject, String str, Object obj) {
        if (obj != null) {
            try {
                if (!(obj instanceof String) || ((String) obj).length() != 0) {
                    jSONObject.put(str, obj);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private JSONObject a(JSONObject jSONObject) {
        try {
            String b10 = o.b(ab.f22568h, f22697j, f22698k, "");
            if (!u.b(b10)) {
                JSONObject jSONObject2 = new JSONObject(b10);
                if (!jSONObject.has("cv") || jSONObject2.getInt("cv") != jSONObject.getInt("cv")) {
                    o.a(ab.f22568h, f22697j, f22698k, jSONObject.toString());
                    if (!jSONObject.has("cv")) {
                        return jSONObject;
                    }
                    o.a(ab.f22568h, f22697j, f22700m, jSONObject.getLong("cv"));
                    return jSONObject;
                }
                if (jSONObject.has("r")) {
                    jSONObject2.put("r", jSONObject.getJSONArray("r"));
                }
                o.a(ab.f22568h, f22697j, f22698k, jSONObject2.toString());
                return jSONObject2;
            }
            o.a(ab.f22568h, f22697j, f22698k, jSONObject.toString());
            return jSONObject;
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return null;
        }
    }

    private void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("i")) {
                    this.f22712d = jSONObject.getInt("i");
                }
                this.f22715g = new HashSet<>();
                if (jSONObject.has("c") && jSONObject.has("r")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("c");
                    JSONArray jSONArray2 = jSONObject.getJSONArray("r");
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                        int i11 = jSONObject2.getInt("id");
                        for (int i12 = 0; i12 < jSONArray2.length(); i12++) {
                            if (i11 == jSONArray2.getInt(i12)) {
                                a(jSONObject2, String.valueOf(i11));
                            }
                            this.f22715g.add(String.valueOf(i11));
                        }
                    }
                    if (jSONArray.length() == 0) {
                        this.f22714f = new HashMap<>();
                    }
                    g();
                    i();
                }
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }
    }

    private void a(JSONObject jSONObject, String str) {
        try {
            JSONArray jSONArray = (JSONArray) jSONObject.remove("clt");
            jSONObject.remove("id");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                String string = jSONArray.getString(i10);
                if (!u.b(string)) {
                    if (this.f22714f.containsKey(string)) {
                        this.f22714f.get(string).put(str, jSONObject);
                    } else {
                        this.f22714f.put(string, new JSONObject().put(str, jSONObject));
                    }
                }
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    public JSONArray a(String str) {
        return a(str, (JSONObject) null, (JSONObject) null);
    }

    public JSONArray a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray jSONArray = new JSONArray();
        if (!f22710w) {
            return jSONArray;
        }
        try {
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
        if (ab.f22578r) {
            return jSONArray;
        }
        if (!f22704q || !f22705r) {
            if (this.f22714f.containsKey(str)) {
                if (!(jSONObject == null || jSONObject2 == null)) {
                    if (jSONObject.has(str)) {
                        return jSONArray;
                    }
                    if (jSONObject2.has(str)) {
                        return null;
                    }
                    jSONObject2.put(str, true);
                }
                JSONObject jSONObject3 = this.f22714f.get(str);
                Iterator<String> keys = jSONObject3.keys();
                ArrayList arrayList = new ArrayList();
                g();
                while (keys.hasNext()) {
                    String next = keys.next();
                    arrayList.add(next);
                    JSONObject jSONObject4 = jSONObject3.getJSONObject(next);
                    long j10 = jSONObject4.getLong("st");
                    long j11 = jSONObject4.getLong("et");
                    int i10 = jSONObject4.getInt("cn");
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis >= j10 && currentTimeMillis <= j11 && i10 > 0) {
                        if (this.f22716h.has(str)) {
                            JSONObject jSONObject5 = this.f22716h.getJSONObject(str);
                            if (!jSONObject5.has(next)) {
                                this.f22716h.put(str, jSONObject5.put(next, 1));
                                jSONArray.put(Integer.parseInt(next));
                            } else if (jSONObject5.getInt(next) < i10) {
                                jSONArray.put(Integer.parseInt(next));
                                jSONObject5.put(next, jSONObject5.getInt(next) + 1);
                                this.f22716h.put(str, jSONObject5);
                            }
                        } else {
                            this.f22716h.put(str, new JSONObject().put(next, 1));
                            jSONArray.put(Integer.parseInt(next));
                        }
                    }
                }
                if (jSONArray.length() == 0) {
                    return null;
                }
                return jSONArray;
            } else if (f22702o) {
                return jSONArray;
            } else {
                return null;
            }
        } else if (f22703p) {
            return null;
        } else {
            return jSONArray;
        }
    }

    public String b() {
        return f22696i;
    }

    private boolean b(String str) {
        try {
            if (u.b(str)) {
                return false;
            }
            int i10 = 0;
            while (true) {
                String[] strArr = f22701n;
                if (i10 >= strArr.length) {
                    return true;
                }
                if (str.equals(strArr[i10])) {
                    return false;
                }
                i10++;
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return true;
        }
    }

    private int a(a aVar) {
        int index = aVar.index();
        if (index == 0) {
            return 1;
        }
        if (index == 1) {
            return 2;
        }
        if (index != 3) {
            return index != 99 ? -1 : 4;
        }
        return 3;
    }

    private void a(RandomAccessFile randomAccessFile, String str) {
        try {
            randomAccessFile.setLength(0L);
            randomAccessFile.seek(0L);
            randomAccessFile.write(str.getBytes());
        } catch (Throwable unused) {
        }
    }

    private String a(RandomAccessFile randomAccessFile) {
        try {
            byte[] bArr = new byte[(int) randomAccessFile.length()];
            randomAccessFile.seek(0L);
            randomAccessFile.read(bArr);
            return new String(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }
}
