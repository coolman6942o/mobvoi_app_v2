package xd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.q;
import com.mobvoi.companion.WearableUiUtils;
import com.mobvoi.wear.companion.setup.settings.SettingConstants;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import ra.f;
import ra.h;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.i;
/* compiled from: UnitController.java */
/* loaded from: classes2.dex */
public class c extends f {

    /* renamed from: f  reason: collision with root package name */
    private static c f36521f;

    /* renamed from: d  reason: collision with root package name */
    private JSONObject f36524d;

    /* renamed from: b  reason: collision with root package name */
    protected xd.b f36522b = (xd.b) new Retrofit.Builder().baseUrl("http://heartbeat.mobvoi.com/").addConverterFactory(xd.a.a()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build().create(xd.b.class);

    /* renamed from: c  reason: collision with root package name */
    private ua.a f36523c = h.a();

    /* renamed from: e  reason: collision with root package name */
    private Context f36525e = com.mobvoi.android.common.utils.b.e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UnitController.java */
    /* loaded from: classes2.dex */
    public class a extends i<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f36526a;

        a(Context context) {
            this.f36526a = context;
        }

        /* renamed from: b */
        public void onNext(String str) {
            if (!TextUtils.isEmpty(str)) {
                com.mobvoi.companion.base.settings.a.saveCountryUnits(this.f36526a, str);
                try {
                    c.this.f36524d = new JSONObject(str);
                    c.this.E(this.f36526a);
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
            }
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.a("UnitController", "get country unit file fail:" + th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UnitController.java */
    /* loaded from: classes2.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.LOCALE_CHANGED".equals(intent.getAction())) {
                c.this.C();
            }
        }

        /* synthetic */ b(c cVar, a aVar) {
            this();
        }
    }

    private c() {
    }

    private String A(String str) {
        JSONObject jSONObject = this.f36524d;
        if (jSONObject == null || !jSONObject.has(str)) {
            return "metric";
        }
        try {
            return this.f36524d.getJSONObject(str).has("units") ? this.f36524d.getJSONObject(str).getString("units") : "metric";
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "metric";
        }
    }

    private boolean D(Context context) {
        return System.currentTimeMillis() - q.c(context, "settings", "country_time_interval", 0L) < 1296000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(Context context) {
        Locale locale;
        if (this.f36524d != null && (locale = context.getResources().getConfiguration().locale) != null) {
            String displayCountry = locale.getDisplayCountry();
            String A = A(displayCountry);
            String y10 = y(displayCountry);
            String w10 = w(displayCountry);
            if (!TextUtils.isEmpty(A)) {
                if ("metric".equals(A)) {
                    com.mobvoi.companion.base.settings.a.setUnit(context, "metric");
                } else if ("imperial".equals(A)) {
                    com.mobvoi.companion.base.settings.a.setUnit(context, "imperial");
                }
            }
            if (!TextUtils.isEmpty(y10)) {
                if ("celsius".equals(y10)) {
                    com.mobvoi.companion.base.settings.a.setTempUnit(context, "celsius");
                } else if ("fahrenheit".equals(y10)) {
                    com.mobvoi.companion.base.settings.a.setTempUnit(context, "fahrenheit");
                }
            }
            if (!TextUtils.isEmpty(w10)) {
                com.mobvoi.companion.base.settings.a.setDateFormat(context, w10);
            }
            F();
        }
    }

    private void F() {
        if (WearableUiUtils.isWearableDeviceConnected()) {
            WearableUiUtils.sendAccountInfoToWear(this.f36525e);
        }
    }

    private void G(Context context) {
        v().Z(this.f36523c.b()).H(this.f36523c.a()).V(new a(context));
    }

    private String w(String str) {
        JSONObject jSONObject = this.f36524d;
        if (jSONObject == null || !jSONObject.has(str)) {
            return SettingConstants.DATE_FORMAT_DEFAULT;
        }
        try {
            return this.f36524d.getJSONObject(str).has("dateformat") ? this.f36524d.getJSONObject(str).getString("dateformat") : SettingConstants.DATE_FORMAT_DEFAULT;
        } catch (JSONException e10) {
            e10.printStackTrace();
            return SettingConstants.DATE_FORMAT_DEFAULT;
        }
    }

    public static synchronized c x() {
        c cVar;
        synchronized (c.class) {
            if (f36521f == null) {
                f36521f = new c();
            }
            cVar = f36521f;
        }
        return cVar;
    }

    private String y(String str) {
        JSONObject jSONObject = this.f36524d;
        if (jSONObject == null || !jSONObject.has(str)) {
            return "celsius";
        }
        try {
            return this.f36524d.getJSONObject(str).has(SettingConstants.TEMPERATURE) ? this.f36524d.getJSONObject(str).getString(SettingConstants.TEMPERATURE) : "celsius";
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "celsius";
        }
    }

    public void B() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        this.f36525e.registerReceiver(new b(this, null), intentFilter);
    }

    public void C() {
        if (!q.a(this.f36525e, "unit_user", "unit_user_key", false)) {
            if (D(this.f36525e)) {
                String countryUnits = com.mobvoi.companion.base.settings.a.getCountryUnits(this.f36525e);
                if (!TextUtils.isEmpty(countryUnits)) {
                    try {
                        this.f36524d = new JSONObject(countryUnits);
                        E(this.f36525e);
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                    }
                } else {
                    G(this.f36525e);
                }
            } else {
                G(this.f36525e);
            }
        }
    }

    public void H(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("metric".equals(str)) {
                com.mobvoi.companion.base.settings.a.setUnit(context, "metric");
                F();
            } else if ("imperial".equals(str)) {
                com.mobvoi.companion.base.settings.a.setUnit(context, "imperial");
                F();
            }
            q.e(context, "unit_user", "unit_user_key", true);
        }
    }

    @Override // ra.f
    protected String q() {
        return "http://heartbeat.mobvoi.com/";
    }

    public rx.c<String> v() {
        return this.f36522b.a();
    }

    public String z(Context context) {
        return com.mobvoi.companion.base.settings.a.getUnit(context);
    }
}
