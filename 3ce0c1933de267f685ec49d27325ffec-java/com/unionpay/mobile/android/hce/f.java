package com.unionpay.mobile.android.hce;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.unionpay.mobile.android.fully.a;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.model.d;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.c;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.tsmservice.data.Constant;
import com.unionpay.tsmservice.data.ResultCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: w  reason: collision with root package name */
    private static final Object f23378w = new Object();

    /* renamed from: a  reason: collision with root package name */
    private Context f23379a;

    /* renamed from: b  reason: collision with root package name */
    private a f23380b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f23381c;

    /* renamed from: d  reason: collision with root package name */
    private String f23382d;

    /* renamed from: e  reason: collision with root package name */
    private String f23383e;

    /* renamed from: x  reason: collision with root package name */
    private final Handler.Callback f23401x;

    /* renamed from: y  reason: collision with root package name */
    private Handler f23402y;

    /* renamed from: f  reason: collision with root package name */
    private int f23384f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f23385g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f23386h = 10;

    /* renamed from: i  reason: collision with root package name */
    private int f23387i = 1000;

    /* renamed from: j  reason: collision with root package name */
    private String f23388j = "hce";

    /* renamed from: k  reason: collision with root package name */
    private String f23389k = "";

    /* renamed from: m  reason: collision with root package name */
    private String f23391m = "";

    /* renamed from: n  reason: collision with root package name */
    private HashMap<String, k> f23392n = new HashMap<>(0);

    /* renamed from: o  reason: collision with root package name */
    private List<k> f23393o = new ArrayList(0);

    /* renamed from: p  reason: collision with root package name */
    private HashMap<Integer, k> f23394p = new HashMap<>(0);

    /* renamed from: q  reason: collision with root package name */
    private int f23395q = 0;

    /* renamed from: r  reason: collision with root package name */
    private int f23396r = 1;

    /* renamed from: s  reason: collision with root package name */
    private int f23397s = 0;

    /* renamed from: t  reason: collision with root package name */
    private int f23398t = 5;

    /* renamed from: u  reason: collision with root package name */
    private ConcurrentHashMap<String, d> f23399u = new ConcurrentHashMap<>(0);

    /* renamed from: v  reason: collision with root package name */
    private ConcurrentHashMap<String, l> f23400v = new ConcurrentHashMap<>(0);

    /* renamed from: l  reason: collision with root package name */
    private String f23390l = "20150801000000000000";

    public f(Context context) {
        g gVar = new g(this);
        this.f23401x = gVar;
        this.f23379a = context;
        this.f23402y = new Handler(gVar);
        this.f23380b = (a) ((BaseActivity) context).a(UPPayEngine.class.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar) {
        for (Map.Entry<String, k> entry : fVar.f23392n.entrySet()) {
            k value = entry.getValue();
            if (!value.a()) {
                String b10 = value.b();
                String e10 = value.e();
                if (c.a(fVar.f23379a, b10) && e10.equalsIgnoreCase(c.b(fVar.f23379a, b10))) {
                    int i10 = fVar.f23395q + 1;
                    fVar.f23395q = i10;
                    fVar.f23394p.put(Integer.valueOf(i10), value);
                    fVar.f23400v.put(b10, new l(b10));
                    fVar.f23399u.put(b10, new d(b10));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, String str) {
        d dVar = fVar.f23399u.get(str);
        l lVar = fVar.f23400v.get(str);
        if (dVar.a() && lVar.a()) {
            fVar.f23402y.removeMessages(2006, str);
            String c10 = lVar.c();
            com.unionpay.mobile.android.hce.service.a b10 = lVar.b();
            String c11 = dVar.c();
            ServiceConnection d10 = dVar.d();
            if (c10 != null && !TextUtils.isEmpty(c10) && c11 != null && !TextUtils.isEmpty(c11)) {
                String a10 = a.a(c11, c10);
                k.c("uppay-hce", str + " card after: " + a10);
                try {
                    JSONArray jSONArray = new JSONArray(a10);
                    int length = jSONArray.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        Object obj = jSONArray.get(i10);
                        if (obj != null) {
                            JSONObject jSONObject = (JSONObject) obj;
                            if (b.f23492bb == null) {
                                b.f23492bb = new ArrayList(1);
                            }
                            c cVar = new c(jSONObject, c10, b10, d10);
                            int i11 = 0;
                            boolean z10 = false;
                            while (true) {
                                List<d> list = b.f23492bb;
                                if (list == null || i11 >= list.size()) {
                                    break;
                                }
                                if (!TextUtils.isEmpty(cVar.a()) && cVar.a().equalsIgnoreCase(b.f23492bb.get(i11).a())) {
                                    z10 = true;
                                }
                                i11++;
                            }
                            if (!z10) {
                                b.f23492bb.add(cVar);
                            }
                        }
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            dVar.f();
            fVar.f23399u.put(str, dVar);
            lVar.e();
            fVar.f23400v.put(str, lVar);
            synchronized (f23378w) {
                fVar.f23397s--;
            }
            fVar.b();
        }
        for (Map.Entry<String, d> entry : fVar.f23399u.entrySet()) {
            if (!entry.getValue().b()) {
                return;
            }
        }
        k.c("uppay", "hce finished !!!!!!!!!!!!");
        b.f23493bl = true;
        Handler handler = fVar.f23381c;
        if (handler != null) {
            fVar.f23381c.sendMessage(handler.obtainMessage(0));
        }
    }

    private boolean a(Bundle bundle) {
        String string = bundle.getString("action_resp_code");
        String string2 = bundle.getString("action_resp_message");
        if ("0000".equalsIgnoreCase(string) && string2 != null) {
            try {
                JSONObject jSONObject = new JSONObject(string2);
                String a10 = j.a(jSONObject, "resp");
                j.a(jSONObject, "msg");
                JSONObject c10 = j.c(jSONObject, Constant.KEY_PARAMS);
                if (a10.equalsIgnoreCase("00")) {
                    this.f23382d = j.c(c10, "signature").toString();
                    JSONArray d10 = j.d(c10, "configs");
                    if (d10 != null) {
                        for (int i10 = 0; i10 < d10.length(); i10++) {
                            this.f23393o.add(new k(d10.getJSONObject(i10)));
                            this.f23391m = j.a(c10, "version");
                        }
                    }
                    int intValue = Integer.decode(j.a(c10, "total_count")).intValue();
                    int i11 = this.f23386h;
                    if (intValue > i11) {
                        this.f23385g = intValue / i11;
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2) {
        i iVar = new i(this, str, str2);
        d dVar = new d(str);
        dVar.a(iVar);
        this.f23399u.put(str, dVar);
        try {
            Intent intent = new Intent();
            intent.setAction("com.unionpay.uppay.action.HCE");
            intent.setPackage(str);
            this.f23379a.startService(intent);
            return this.f23379a.bindService(intent, iVar, 1);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle d(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action_resp_code", "0000");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("v", "1.9");
            jSONObject.put("cmd", this.f23388j);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(Constant.KEY_PARAMS, jSONObject2);
            jSONObject2.put("base_version", str);
            bundle.putString("action_resp_message", this.f23380b.a(jSONObject.toString()));
            a(bundle);
            int i10 = this.f23384f + 1;
            this.f23384f = i10;
            if (i10 <= this.f23385g) {
                d(this.f23390l);
            }
            return bundle;
        } catch (JSONException unused) {
            bundle.putString("action_resp_code", ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE);
            return bundle;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k(f fVar) {
        HashMap<String, k> hashMap;
        if (!TextUtils.isEmpty(fVar.f23391m)) {
            for (k kVar : fVar.f23393o) {
                fVar.f23392n.put(kVar.b(), kVar);
            }
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, k> entry : fVar.f23392n.entrySet()) {
                jSONArray.put(entry.getValue().f());
            }
            PreferenceUtils.a(fVar.f23379a, fVar.f23391m, "hce_version");
            PreferenceUtils.a(fVar.f23379a, jSONArray.toString(), "hce_info");
        }
        if (!(TextUtils.isEmpty(fVar.f23389k) || (hashMap = fVar.f23392n) == null || hashMap.size() <= 0)) {
            Iterator<Map.Entry<String, k>> it = fVar.f23392n.entrySet().iterator();
            while (it.hasNext()) {
                if (!fVar.f23389k.equals(it.next().getValue().c())) {
                    it.remove();
                }
            }
        }
    }

    public final void a() {
        this.f23384f = 1;
    }

    public final void a(int i10) {
        this.f23386h = i10;
    }

    public final void a(Handler handler) {
        this.f23381c = handler;
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f23388j = str;
        }
    }

    public final void b() {
        if (this.f23395q == 0) {
            b.f23493bl = true;
            Handler handler = this.f23381c;
            if (handler != null) {
                this.f23381c.sendMessage(handler.obtainMessage(0));
                return;
            }
            return;
        }
        synchronized (f23378w) {
            for (int i10 = this.f23396r; i10 <= this.f23395q && this.f23397s < this.f23398t; i10++) {
                k kVar = this.f23394p.get(Integer.valueOf(i10));
                String b10 = kVar.b();
                String d10 = kVar.d();
                this.f23397s++;
                new h(this, b10, d10).start();
                this.f23396r++;
            }
        }
    }

    public final void b(int i10) {
        if (i10 > 0) {
            this.f23387i = i10;
        }
    }

    public final void b(String str) {
        this.f23383e = str;
    }

    public final void c() {
        List<d> list = b.f23492bb;
        if (list != null) {
            list.clear();
            b.f23492bb = null;
        }
        String a10 = PreferenceUtils.a(this.f23379a, "hce_version");
        if (!TextUtils.isEmpty(a10)) {
            this.f23390l = a10;
        }
        String a11 = PreferenceUtils.a(this.f23379a, "hce_info");
        if (TextUtils.isEmpty(a11)) {
            a11 = "[{\"package\":\"com.yitong.mbank0408\",\"issuer\":\"64083300\",\"syn_key\":\"0123456789ABCDEF1010101010101010\",\"pub_key\":\"268576AF6F50DA40196E18D6E059D2A721373638\",\"status\":\"I\",\"priority\":\"1\"}]";
        }
        try {
            JSONArray jSONArray = new JSONArray(a11);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                k kVar = new k(jSONArray.getJSONObject(i10));
                this.f23392n.put(kVar.b(), kVar);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        new Thread(new j(this)).start();
    }

    public final void c(int i10) {
        if (i10 > 0) {
            this.f23398t = i10;
        }
    }

    public final void c(String str) {
        this.f23389k = str;
    }
}
