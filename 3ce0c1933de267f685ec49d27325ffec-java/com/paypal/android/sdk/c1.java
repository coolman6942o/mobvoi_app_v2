package com.paypal.android.sdk;

import okhttp3.b0;
import okhttp3.v;
/* loaded from: classes2.dex */
public final class c1 implements v {

    /* renamed from: a  reason: collision with root package name */
    private final String f21083a;

    public c1(String str) {
        this.f21083a = str == null ? null : str.replaceAll("[^\\x00-\\x7F]", "");
    }

    @Override // okhttp3.v
    public final b0 intercept(v.a aVar) {
        return aVar.a(aVar.request().i().m("User-Agent").a("User-Agent", this.f21083a).b());
    }
}
