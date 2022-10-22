package com.tendcloud.tenddata;

import android.util.EventLogTags;
import android.util.Pair;
import com.mobvoi.companion.common.analytics.Module;
import com.mobvoi.wear.common.base.Constants;
import com.mobvoi.wear.providers.OtaColumn;
import com.mobvoi.wear.util.TelephonyUtil;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class ct {

    /* renamed from: c  reason: collision with root package name */
    private static cf f22843c;

    /* renamed from: d  reason: collision with root package name */
    private static ci f22844d;

    /* renamed from: e  reason: collision with root package name */
    private static cm f22845e = new cm();

    /* renamed from: f  reason: collision with root package name */
    private static cj f22846f = null;

    /* renamed from: g  reason: collision with root package name */
    private static volatile ct f22847g = null;

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f22848a = null;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f22849b = null;

    public synchronized JSONObject a(ce ceVar, boolean z10) {
        return a(ceVar, z10, null);
    }

    public synchronized JSONObject a(ce ceVar, boolean z10, a aVar) {
        return a(ceVar, z10, aVar, null);
    }

    public synchronized JSONObject a(ce ceVar, boolean z10, a aVar, Pair<String, JSONArray> pair) {
        JSONObject jSONObject;
        if (ceVar != null) {
            if (ceVar.b() != null) {
                synchronized (EventLogTags.class) {
                    jSONObject = new JSONObject();
                    l.getFileLock(ay.a().b());
                    this.f22848a = new JSONObject();
                    this.f22849b = new JSONObject();
                    try {
                        if (f22843c == null) {
                            f22843c = cf.a();
                            f22843c.setUniqueId(cs.a(ab.f22568h, ab.f22568h.getPackageName()));
                        }
                        f22843c.setSubmitAppId(aVar);
                        f22843c.setSubmitChannelId(aVar);
                        if (f22845e == null) {
                            f22845e = new cm();
                        }
                        cm.f22819a.a();
                        f22845e.c().setSlots(m.B(ab.f22568h));
                        if (f22844d == null) {
                            f22844d = new ci();
                        }
                        if (f22846f == null) {
                            cj cjVar = new cj();
                            f22846f = cjVar;
                            cjVar.a();
                        }
                    } catch (Throwable unused) {
                    }
                    f22846f.c();
                    try {
                        jSONObject.put("version", "2.0");
                        jSONObject.put(TelephonyUtil.KEY_SIM_ACTION, ceVar.b());
                        jSONObject.put(Module.DEVICE, f22845e.b());
                        jSONObject.put(OtaColumn.COLUMN_APP, f22843c.b());
                        jSONObject.put("sdk", f22844d.b());
                        jSONObject.put("appContext", cc.a().b());
                        jSONObject.put(Constants.Setting.SUPER_POWER_SAVE_MODE_REASON_USER, f22846f.b());
                        long currentTimeMillis = System.currentTimeMillis();
                        jSONObject.put("ts", currentTimeMillis);
                        jSONObject.put("fingerprint", u.c(currentTimeMillis + cs.a(ab.f22568h) + f22845e.a().a() + f22845e.a().c()));
                        if (z10) {
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(new cq(cr.WIFI).b());
                            jSONArray.put(new cq(cr.CELLULAR).b());
                            try {
                                if (u.b(ab.f22568h, "android.permission.BLUETOOTH")) {
                                    jSONArray.put(new cq(cr.BLUETOOTH).b());
                                }
                            } catch (Throwable unused2) {
                            }
                            jSONObject.put("networks", jSONArray);
                            JSONArray a10 = ay.a().a("Location");
                            if (a10 != null) {
                                jSONObject.put("locations", new cg().b());
                                if (a10.length() > 0) {
                                    a("Location", a10);
                                }
                            }
                        }
                        if (pair != null && ((JSONArray) pair.second).length() > 0) {
                            a((String) pair.first, (JSONArray) pair.second);
                        }
                        if (!ab.f22578r) {
                            jSONObject.put("cloudcontrol", this.f22848a);
                        }
                        ay.a().c();
                    } catch (Throwable th2) {
                        bf.postSDKError(th2);
                    }
                    l.releaseFileLock(ay.a().b());
                }
                return jSONObject;
            }
        }
        return null;
    }

    public void a(String str, JSONArray jSONArray) {
        try {
            if (!ab.f22578r && this.f22848a != null && jSONArray.length() > 0) {
                this.f22848a.put(str, jSONArray);
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    public static ct a() {
        if (f22847g == null) {
            synchronized (ct.class) {
                if (f22847g == null) {
                    f22847g = new ct();
                }
            }
        }
        return f22847g;
    }
}
