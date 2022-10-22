package com.tendcloud.tenddata;

import android.net.Proxy;
import com.mobvoi.wear.contacts.ContactConstant;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class cq extends ch {

    /* renamed from: a  reason: collision with root package name */
    private au f22836a;

    /* renamed from: c  reason: collision with root package name */
    private String f22837c;

    /* compiled from: td */
    /* renamed from: com.tendcloud.tenddata.cq$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$talkingdata$sdk$saf$datamodel$network$TDNetworkType;

        static {
            int[] iArr = new int[cr.values().length];
            $SwitchMap$com$talkingdata$sdk$saf$datamodel$network$TDNetworkType = iArr;
            try {
                iArr[cr.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$talkingdata$sdk$saf$datamodel$network$TDNetworkType[cr.CELLULAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$talkingdata$sdk$saf$datamodel$network$TDNetworkType[cr.BLUETOOTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public cq(cr crVar) {
        this.f22837c = UUID.randomUUID().toString();
        int i10 = AnonymousClass1.$SwitchMap$com$talkingdata$sdk$saf$datamodel$network$TDNetworkType[crVar.ordinal()];
        if (i10 != 1) {
            try {
                if (i10 != 2) {
                    if (i10 == 3) {
                        a("type", cr.BLUETOOTH.a());
                        return;
                    }
                }
                a("type", cr.CELLULAR.a());
                a("available", Boolean.valueOf(m.e(ab.f22568h)));
                a("connected", Boolean.valueOf(m.j(ab.f22568h)));
                a("ip", m.a("cell_ip"));
                a("ipv6", m.a("cell_ipv6"));
                if (m.b(ab.f22568h)) {
                    a("current", m.a(ab.f22568h, false));
                }
                if (m.b()) {
                    a("proxy", Proxy.getDefaultHost() + ":" + Proxy.getDefaultPort());
                }
                a("scannable", m.v(ab.f22568h));
            } catch (Throwable unused) {
            }
        } else {
            a("type", cr.WIFI.a());
            a("available", Boolean.valueOf(m.d(ab.f22568h)));
            if (m.i(ab.f22568h)) {
                a("connected", Boolean.TRUE);
                JSONArray a10 = ay.a().a("WiFi", ct.a().f22848a, ct.a().f22849b);
                if (a10 != null) {
                    a("current", m.y(ab.f22568h));
                    if (a10.length() > 0) {
                        ct.a().a("WiFi", a10);
                    }
                } else {
                    a("current", this.f22803b);
                }
                JSONArray z10 = m.z(ab.f22568h);
                au a11 = a(z10);
                if (this.f22836a == null) {
                    a("scannable", z10);
                    this.f22836a = a11;
                } else if (new av().a(this.f22836a, a11) > 0.8d) {
                    a("scannable", (Object) null);
                } else {
                    a("scannable", z10);
                    this.f22836a = a11;
                    this.f22837c = UUID.randomUUID().toString();
                }
                JSONArray a12 = ay.a().a("WiFi", ct.a().f22848a, ct.a().f22849b);
                if (a12 != null) {
                    a("configured", m.x(ab.f22568h));
                    if (a12.length() > 0) {
                        ct.a().a("WiFi", a12);
                    }
                } else {
                    a("configured", this.f22803b);
                }
                JSONArray a13 = ay.a().a("IP", ct.a().f22848a, ct.a().f22849b);
                if (a13 != null) {
                    a("ip", m.a("ip"));
                    a("ipv6", m.a("ipv6"));
                    if (a13.length() > 0) {
                        ct.a().a("IP", a13);
                    }
                } else {
                    a("ip", this.f22803b);
                }
            } else {
                a("connected", Boolean.FALSE);
            }
            if (m.b()) {
                a("proxy", Proxy.getDefaultHost() + ":" + Proxy.getDefaultPort());
            }
            a("scannableFingerId", this.f22837c);
        }
    }

    private static au a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                arrayList.add(new ar(jSONObject.getString(ContactConstant.CallsRecordKeys.NAME), jSONObject.getString("id"), (byte) jSONObject.getInt("level"), (byte) 0, (byte) 0));
            } catch (Throwable th2) {
                g.eForInternal(th2);
            }
        }
        au auVar = new au();
        auVar.setBsslist(arrayList);
        return auVar;
    }
}
