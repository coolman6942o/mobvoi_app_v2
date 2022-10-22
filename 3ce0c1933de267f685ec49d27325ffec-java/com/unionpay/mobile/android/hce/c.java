package com.unionpay.mobile.android.hce;

import android.content.ServiceConnection;
import com.mobvoi.wear.contacts.ContactConstant;
import com.unionpay.mobile.android.hce.service.a;
import com.unionpay.mobile.android.model.d;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c implements d {

    /* renamed from: a  reason: collision with root package name */
    private String f23356a;

    /* renamed from: b  reason: collision with root package name */
    private String f23357b;

    /* renamed from: c  reason: collision with root package name */
    private String f23358c;

    /* renamed from: d  reason: collision with root package name */
    private String f23359d;

    /* renamed from: e  reason: collision with root package name */
    private String f23360e;

    /* renamed from: f  reason: collision with root package name */
    private String f23361f;

    /* renamed from: g  reason: collision with root package name */
    private a f23362g;

    /* renamed from: h  reason: collision with root package name */
    private ServiceConnection f23363h;

    public c(JSONObject jSONObject, String str, a aVar, ServiceConnection serviceConnection) {
        this.f23356a = j.a(jSONObject, "num");
        this.f23357b = j.a(jSONObject, ContactConstant.CallsRecordKeys.NAME);
        this.f23359d = j.a(jSONObject, "type");
        String a10 = j.a(jSONObject, "type");
        this.f23358c = e.f23370a.equals(a10) ? e.f23374e : e.f23371b.equals(a10) ? e.f23375f : e.f23372c.equals(a10) ? e.f23376g : e.f23373d.equals(a10) ? e.f23377h : "";
        this.f23360e = j.a(jSONObject, "instNum");
        this.f23361f = str;
        this.f23362g = aVar;
        this.f23363h = serviceConnection;
    }

    @Override // com.unionpay.mobile.android.model.d
    public final String a() {
        return this.f23356a;
    }

    @Override // com.unionpay.mobile.android.model.d
    public final String b() {
        return this.f23357b;
    }

    @Override // com.unionpay.mobile.android.model.d
    public final String c() {
        return this.f23358c;
    }

    @Override // com.unionpay.mobile.android.model.d
    public final String d() {
        return this.f23359d;
    }

    @Override // com.unionpay.mobile.android.model.d
    public final String e() {
        return this.f23360e;
    }

    public final String f() {
        return this.f23361f;
    }

    public final a g() {
        return this.f23362g;
    }

    public final ServiceConnection h() {
        return this.f23363h;
    }
}
