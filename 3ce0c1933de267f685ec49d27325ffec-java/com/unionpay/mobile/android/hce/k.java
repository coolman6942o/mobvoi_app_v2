package com.unionpay.mobile.android.hce;

import com.mobvoi.wear.ble.BleProtocol;
import com.mobvoi.wear.permission.PermissionConstant;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private String f23411a;

    /* renamed from: b  reason: collision with root package name */
    private String f23412b;

    /* renamed from: c  reason: collision with root package name */
    private String f23413c;

    /* renamed from: d  reason: collision with root package name */
    private String f23414d;

    /* renamed from: e  reason: collision with root package name */
    private String f23415e;

    /* renamed from: f  reason: collision with root package name */
    private String f23416f;

    /* renamed from: g  reason: collision with root package name */
    private JSONObject f23417g;

    public k(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f23417g = jSONObject;
            this.f23411a = j.a(jSONObject, "package");
            this.f23412b = j.a(jSONObject, "issuer");
            this.f23413c = j.a(jSONObject, "syn_key");
            this.f23414d = j.a(jSONObject, "pub_key");
            this.f23415e = j.a(jSONObject, PermissionConstant.Columns.STATUS);
            this.f23416f = j.a(jSONObject, BleProtocol.PRIORITY);
        }
    }

    public final boolean a() {
        return this.f23415e.equals("D");
    }

    public final String b() {
        return this.f23411a;
    }

    public final String c() {
        return this.f23412b;
    }

    public final String d() {
        return this.f23413c;
    }

    public final String e() {
        return this.f23414d;
    }

    public final JSONObject f() {
        return this.f23417g;
    }
}
