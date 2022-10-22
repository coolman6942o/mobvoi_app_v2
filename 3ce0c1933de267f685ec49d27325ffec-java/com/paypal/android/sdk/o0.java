package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class o0 {

    /* renamed from: a  reason: collision with root package name */
    private String f21480a;

    /* renamed from: b  reason: collision with root package name */
    private String f21481b;

    /* renamed from: c  reason: collision with root package name */
    private Map f21482c = new HashMap();

    public o0(String str, String str2) {
        this.f21480a = str;
        this.f21481b = str2;
    }

    public final String a() {
        return this.f21480a;
    }

    public final String b() {
        return this.f21481b;
    }

    public final Map c() {
        return this.f21482c;
    }

    public final String toString() {
        return o0.class.getSimpleName() + "(" + this.f21480a + ",mEndpoints=" + this.f21482c + ")";
    }
}
