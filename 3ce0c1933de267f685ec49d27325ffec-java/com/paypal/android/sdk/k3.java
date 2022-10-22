package com.paypal.android.sdk;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public final class k3 extends s3 {

    /* renamed from: p  reason: collision with root package name */
    public final String f21406p;

    /* renamed from: q  reason: collision with root package name */
    private List f21407q;

    /* renamed from: r  reason: collision with root package name */
    private final String f21408r;

    public k3(s1 s1Var, z zVar, String str, String str2, String str3, String str4, List list) {
        super(dc.ConsentRequest, s1Var, zVar, s3.C(str, str2));
        this.f21406p = str3;
        this.f21408r = str4;
        this.f21407q = list;
    }

    @Override // com.paypal.android.sdk.r1
    public final String h() {
        HashMap hashMap = new HashMap();
        hashMap.put("code", this.f21406p);
        hashMap.put("nonce", this.f21408r);
        hashMap.put("scope", TextUtils.join(" ", this.f21407q));
        return y1.d(hashMap);
    }

    @Override // com.paypal.android.sdk.r1
    public final void j() {
    }

    @Override // com.paypal.android.sdk.r1
    public final void l() {
        D(u());
    }

    @Override // com.paypal.android.sdk.r1
    public final String m() {
        return "{\"code\":\"EOTHbvqh0vwM2ldM2QIXbjVw0hZNuZEJLqdWmfTBLLSvGfqgyy9GKvjGybIxyGMd7gHXCXVtymqFQHS-J-4-Ir6u2LUVVdyLKonwTtdFw9qhBaMb4NZuZHKS0bGxdZlRAB3_Fk8HX2r3z8j03xScx4M\",\"scope\":\"https://uri.paypal.com/services/payments/futurepayments\"}";
    }
}
