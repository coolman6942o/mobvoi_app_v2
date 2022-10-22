package com.paypal.android.sdk;

import android.location.Location;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class s {
    public String B;
    public String C;
    public Boolean D;
    public String E;
    public String F;
    public Boolean G;
    public String H;
    public String I;
    public long J;
    public long K;
    public String L;
    public Boolean M;
    public Integer N;
    public String Q;
    public String S;
    public Boolean T;
    public Boolean U;
    public String V;
    public long W;
    public long X;
    public String Y;
    public String Z;

    /* renamed from: a  reason: collision with root package name */
    public String f21899a;

    /* renamed from: a0  reason: collision with root package name */
    public String f21900a0;

    /* renamed from: b  reason: collision with root package name */
    public String f21901b;

    /* renamed from: b0  reason: collision with root package name */
    public String f21902b0;

    /* renamed from: c  reason: collision with root package name */
    public String f21903c;

    /* renamed from: c0  reason: collision with root package name */
    public String f21904c0;

    /* renamed from: d0  reason: collision with root package name */
    public String f21906d0;

    /* renamed from: e  reason: collision with root package name */
    public String f21907e;

    /* renamed from: e0  reason: collision with root package name */
    public String f21908e0;

    /* renamed from: f0  reason: collision with root package name */
    public String f21910f0;

    /* renamed from: g  reason: collision with root package name */
    public String f21911g;

    /* renamed from: g0  reason: collision with root package name */
    public String f21912g0;

    /* renamed from: h  reason: collision with root package name */
    public String f21913h;

    /* renamed from: h0  reason: collision with root package name */
    public List f21914h0;

    /* renamed from: i  reason: collision with root package name */
    public String f21915i;

    /* renamed from: i0  reason: collision with root package name */
    public Map f21916i0;

    /* renamed from: j  reason: collision with root package name */
    public String f21917j;

    /* renamed from: k  reason: collision with root package name */
    public String f21918k;

    /* renamed from: l  reason: collision with root package name */
    public String f21919l;

    /* renamed from: m  reason: collision with root package name */
    public String f21920m;

    /* renamed from: o  reason: collision with root package name */
    public String f21922o;

    /* renamed from: p  reason: collision with root package name */
    public List f21923p;

    /* renamed from: q  reason: collision with root package name */
    public List f21924q;

    /* renamed from: r  reason: collision with root package name */
    public String f21925r;

    /* renamed from: s  reason: collision with root package name */
    public String f21926s;

    /* renamed from: t  reason: collision with root package name */
    public String f21927t;

    /* renamed from: u  reason: collision with root package name */
    public String f21928u;

    /* renamed from: v  reason: collision with root package name */
    public Location f21929v;

    /* renamed from: x  reason: collision with root package name */
    public String f21931x;

    /* renamed from: z  reason: collision with root package name */
    public String f21933z;

    /* renamed from: d  reason: collision with root package name */
    public int f21905d = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f21909f = -1;

    /* renamed from: n  reason: collision with root package name */
    public long f21921n = -1;

    /* renamed from: w  reason: collision with root package name */
    public int f21930w = -1;
    public int O = -1;
    public int P = -1;
    public int R = -1;

    /* renamed from: y  reason: collision with root package name */
    public String f21932y = "Android";
    private String A = "full";

    private static JSONObject b(Location location) {
        if (location != null) {
            try {
                return new JSONObject("{\"lat\":" + location.getLatitude() + ",\"lng\":" + location.getLongitude() + ",\"acc\":" + location.getAccuracy() + ",\"timestamp\":" + location.getTime() + "}");
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private void d(JSONObject jSONObject) {
        Map map = this.f21916i0;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                try {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                } catch (JSONException e10) {
                    m0.m(null, null, e10);
                }
            }
        }
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_guid", this.f21899a);
            jSONObject.put("app_id", this.f21901b);
            jSONObject.put("app_version", this.f21903c);
            int i10 = this.f21905d;
            jSONObject.put("base_station_id", i10 == -1 ? null : Integer.valueOf(i10));
            jSONObject.put("bssid", this.f21907e);
            jSONObject.put("bssid_array", this.f21914h0 == null ? null : new JSONArray((Collection) this.f21914h0));
            int i11 = this.f21909f;
            jSONObject.put("cell_id", i11 == -1 ? null : Integer.valueOf(i11));
            jSONObject.put("comp_version", this.f21911g);
            jSONObject.put("conf_url", this.f21913h);
            jSONObject.put("conf_version", this.f21915i);
            jSONObject.put("conn_type", this.f21917j);
            jSONObject.put("device_id", this.f21918k);
            jSONObject.put("dc_id", this.f21910f0);
            jSONObject.put("device_model", this.f21919l);
            jSONObject.put("device_name", this.f21920m);
            long j10 = this.f21921n;
            jSONObject.put("device_uptime", j10 == -1 ? null : Long.valueOf(j10));
            jSONObject.put("ip_addrs", this.f21922o);
            jSONObject.put("ip_addresses", this.f21923p == null ? null : new JSONArray((Collection) this.f21923p));
            jSONObject.put("known_apps", this.f21924q == null ? null : new JSONArray((Collection) this.f21924q));
            jSONObject.put("line_1_number", "".equals(this.f21925r) ? null : this.f21925r);
            jSONObject.put("linker_id", this.f21926s);
            jSONObject.put("locale_country", this.f21927t);
            jSONObject.put("locale_lang", this.f21928u);
            jSONObject.put(SharedWearInfoHelper.LocationInfo.TABLE, b(this.f21929v));
            int i12 = this.f21930w;
            jSONObject.put("location_area_code", i12 == -1 ? null : Integer.valueOf(i12));
            jSONObject.put("mac_addrs", this.f21931x);
            jSONObject.put("os_type", this.f21932y);
            jSONObject.put("os_version", this.f21933z);
            jSONObject.put("payload_type", this.A);
            jSONObject.put("phone_type", this.B);
            jSONObject.put("risk_comp_session_id", this.C);
            jSONObject.put("roaming", this.D);
            jSONObject.put("sim_operator_name", "".equals(this.E) ? null : this.E);
            jSONObject.put("sim_serial_number", this.F);
            jSONObject.put("sms_enabled", this.G);
            jSONObject.put("ssid", this.H);
            int i13 = this.P;
            jSONObject.put("cdma_network_id", i13 == -1 ? null : Integer.valueOf(i13));
            int i14 = this.O;
            jSONObject.put("cdma_system_id", i14 == -1 ? null : Integer.valueOf(i14));
            jSONObject.put("subscriber_id", this.I);
            jSONObject.put("timestamp", this.J);
            jSONObject.put("total_storage_space", this.K);
            jSONObject.put("tz_name", this.L);
            jSONObject.put("ds", this.M);
            jSONObject.put("tz", this.N);
            jSONObject.put("network_operator", this.Q);
            int i15 = this.R;
            jSONObject.put("source_app", i15 == -1 ? null : Integer.valueOf(i15));
            jSONObject.put("source_app_version", this.S);
            jSONObject.put("is_emulator", this.T);
            jSONObject.put("is_rooted", this.U);
            jSONObject.put("pairing_id", this.V);
            jSONObject.put("app_first_install_time", this.W);
            jSONObject.put("app_last_update_time", this.X);
            jSONObject.put("android_id", this.Y);
            jSONObject.put("serial_number", this.f21900a0);
            jSONObject.put("notif_token", this.Z);
            jSONObject.put("bluetooth_mac_addrs", (Object) null);
            jSONObject.put("gsf_id", this.f21902b0);
            jSONObject.put("VPN_setting", this.f21906d0);
            jSONObject.put("proxy_setting", this.f21904c0);
            jSONObject.put("c", this.f21908e0);
            jSONObject.put("pm", this.f21912g0);
            d(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final JSONObject c(s sVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_emulator", sVar.T);
            jSONObject.put("is_rooted", sVar.U);
            jSONObject.put("app_guid", sVar.f21899a);
            jSONObject.put("risk_comp_session_id", sVar.C);
            jSONObject.put("timestamp", sVar.J);
            jSONObject.put("payload_type", "incremental");
            jSONObject.put("source_app", sVar.R);
            jSONObject.put("pairing_id", sVar.V);
            d(jSONObject);
            String str = this.f21901b;
            if (str != null && !str.equals(sVar.f21901b)) {
                jSONObject.put("app_id", sVar.f21901b);
            }
            String str2 = this.f21903c;
            if (str2 != null && !str2.equals(sVar.f21903c)) {
                jSONObject.put("app_version", sVar.f21903c);
            }
            int i10 = this.f21905d;
            int i11 = sVar.f21905d;
            if (i10 != i11) {
                jSONObject.put("base_station_id", i11);
            }
            String str3 = this.f21907e;
            if (str3 != null && !str3.equals(sVar.f21907e)) {
                jSONObject.put("bssid", sVar.f21907e);
            }
            int i12 = this.f21909f;
            int i13 = sVar.f21909f;
            if (i12 != i13) {
                jSONObject.put("cell_id", i13);
            }
            String str4 = this.f21911g;
            if (str4 != null && !str4.equals(sVar.f21911g)) {
                jSONObject.put("comp_version", sVar.f21911g);
            }
            String str5 = this.f21915i;
            if (str5 != null && !str5.equals(sVar.f21915i)) {
                jSONObject.put("conf_version", sVar.f21915i);
            }
            String str6 = this.f21913h;
            if (str6 != null && !str6.equals(sVar.f21913h)) {
                jSONObject.put("conf_url", sVar.f21913h);
            }
            String str7 = this.f21917j;
            if (str7 != null && !str7.equals(sVar.f21917j)) {
                jSONObject.put("conn_type", sVar.f21917j);
            }
            String str8 = this.f21918k;
            if (str8 != null && !str8.equals(sVar.f21918k)) {
                jSONObject.put("device_id", sVar.f21918k);
            }
            String str9 = this.f21919l;
            if (str9 != null && !str9.equals(sVar.f21919l)) {
                jSONObject.put("device_model", sVar.f21919l);
            }
            String str10 = this.f21920m;
            if (str10 != null && !str10.equals(sVar.f21920m)) {
                jSONObject.put("device_name", sVar.f21920m);
            }
            long j10 = this.f21921n;
            long j11 = sVar.f21921n;
            if (j10 != j11) {
                jSONObject.put("device_uptime", j11);
            }
            String str11 = this.f21922o;
            if (str11 != null && !str11.equals(sVar.f21922o)) {
                jSONObject.put("ip_addrs", sVar.f21922o);
            }
            List list = this.f21923p;
            if (!(list == null || sVar.f21923p == null || list.toString().equals(sVar.f21923p.toString()))) {
                jSONObject.put("ip_addresses", new JSONArray((Collection) sVar.f21923p));
            }
            List list2 = this.f21924q;
            if (!(list2 == null || sVar.f21924q == null || list2.toString().equals(sVar.f21924q.toString()))) {
                jSONObject.put("known_apps", new JSONArray((Collection) sVar.f21924q));
            }
            String str12 = this.f21925r;
            if (str12 != null && !str12.equals(sVar.f21925r)) {
                jSONObject.put("line_1_number", sVar.f21925r);
            }
            String str13 = this.f21926s;
            if (str13 != null && !str13.equals(sVar.f21926s)) {
                jSONObject.put("linker_id", sVar.f21926s);
            }
            String str14 = this.f21927t;
            if (str14 != null && !str14.equals(sVar.f21927t)) {
                jSONObject.put("locale_country", sVar.f21927t);
            }
            String str15 = this.f21928u;
            if (str15 != null && !str15.equals(sVar.f21928u)) {
                jSONObject.put("locale_lang", sVar.f21928u);
            }
            Location location = this.f21929v;
            if (!(location == null || sVar.f21929v == null || location.toString().equals(sVar.f21929v.toString()))) {
                jSONObject.put(SharedWearInfoHelper.LocationInfo.TABLE, b(sVar.f21929v));
            }
            int i14 = this.f21930w;
            int i15 = sVar.f21930w;
            if (i14 != i15) {
                jSONObject.put("location_area_code", i15);
            }
            String str16 = this.f21931x;
            if (str16 != null && !str16.equals(sVar.f21931x)) {
                jSONObject.put("mac_addrs", sVar.f21931x);
            }
            String str17 = this.f21932y;
            if (str17 != null && !str17.equals(sVar.f21932y)) {
                jSONObject.put("os_type", sVar.f21932y);
            }
            String str18 = this.f21933z;
            if (str18 != null && !str18.equals(sVar.f21933z)) {
                jSONObject.put("os_version", sVar.f21933z);
            }
            String str19 = this.B;
            if (str19 != null && !str19.equals(sVar.B)) {
                jSONObject.put("phone_type", sVar.B);
            }
            Boolean bool = this.D;
            if (bool != null && bool.equals(sVar.D)) {
                jSONObject.put("roaming", sVar.D);
            }
            String str20 = this.E;
            if (str20 != null && !str20.equals(sVar.E)) {
                jSONObject.put("sim_operator_name", sVar.E);
            }
            String str21 = this.F;
            if (str21 != null && !str21.equals(sVar.F)) {
                jSONObject.put("sim_serial_number", sVar.F);
            }
            Boolean bool2 = this.G;
            if (bool2 != null && bool2.equals(sVar.G)) {
                jSONObject.put("sms_enabled", sVar.G);
            }
            String str22 = this.H;
            if (str22 != null && !str22.equals(sVar.H)) {
                jSONObject.put("ssid", sVar.H);
            }
            int i16 = this.P;
            int i17 = sVar.P;
            if (i16 != i17) {
                jSONObject.put("cdma_network_id", i17);
            }
            int i18 = this.O;
            int i19 = sVar.O;
            if (i18 != i19) {
                jSONObject.put("cdma_system_id", i19);
            }
            String str23 = this.I;
            if (str23 != null && !str23.equals(sVar.I)) {
                jSONObject.put("subscriber_id", sVar.I);
            }
            long j12 = this.K;
            long j13 = sVar.K;
            if (j12 != j13) {
                jSONObject.put("total_storage_space", j13);
            }
            String str24 = this.L;
            if (str24 != null && !str24.equals(sVar.L)) {
                jSONObject.put("tz_name", sVar.L);
            }
            Boolean bool3 = this.M;
            if (bool3 != null && !bool3.equals(sVar.M)) {
                jSONObject.put("ds", sVar.M);
            }
            Integer num = this.N;
            if (num != null && !num.equals(sVar.N)) {
                jSONObject.put("tz", sVar.N);
            }
            String str25 = this.Q;
            if (str25 != null && !str25.equals(sVar.Q)) {
                jSONObject.put("network_operator", sVar.Q);
            }
            String str26 = this.S;
            if (str26 != null && !str26.equals(sVar.S)) {
                jSONObject.put("source_app_version", sVar.S);
            }
            long j14 = this.W;
            long j15 = sVar.W;
            if (j14 != j15) {
                jSONObject.put("app_first_install_time", j15);
            }
            long j16 = this.X;
            long j17 = sVar.X;
            if (j16 != j17) {
                jSONObject.put("app_last_update_time", j17);
            }
            String str27 = this.Y;
            if (str27 != null && !str27.equals(sVar.Y)) {
                jSONObject.put("android_id", sVar.Y);
            }
            String str28 = this.f21900a0;
            if (str28 != null && !str28.equals(sVar.f21900a0)) {
                jSONObject.put("serial_number", sVar.f21900a0);
            }
            String str29 = this.Z;
            if (str29 != null && !str29.equals(sVar.Z)) {
                jSONObject.put("notif_token", sVar.Z);
            }
            String str30 = this.f21902b0;
            if (str30 != null && !str30.equals(sVar.f21902b0)) {
                jSONObject.put("gsf_id", sVar.f21902b0);
            }
            String str31 = this.f21906d0;
            if (str31 != null && !str31.equals(sVar.f21906d0)) {
                jSONObject.put("VPN_setting", sVar.f21906d0);
            }
            String str32 = this.f21904c0;
            if (str32 != null && !str32.equals(sVar.f21904c0)) {
                jSONObject.put("proxy_setting", sVar.f21904c0);
            }
            String str33 = this.f21908e0;
            if (str33 != null && !str33.equals(sVar.f21908e0)) {
                jSONObject.put("c", sVar.f21908e0);
            }
            String str34 = this.f21912g0;
            if (str34 != null && !str34.equals(sVar.f21912g0)) {
                jSONObject.put("pm", sVar.f21912g0);
            }
            List list3 = this.f21914h0;
            if (list3 != null && !list3.equals(sVar.f21914h0)) {
                jSONObject.put("bssid_arr", sVar.f21914h0);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
