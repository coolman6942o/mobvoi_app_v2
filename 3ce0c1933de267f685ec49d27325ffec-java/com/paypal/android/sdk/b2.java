package com.paypal.android.sdk;

import java.util.UUID;
/* loaded from: classes2.dex */
public final class b2 {

    /* renamed from: a  reason: collision with root package name */
    public ev f20999a = new ev();

    /* renamed from: b  reason: collision with root package name */
    public dt f21000b;

    /* renamed from: c  reason: collision with root package name */
    public String f21001c;

    /* renamed from: d  reason: collision with root package name */
    public dj f21002d;

    /* renamed from: e  reason: collision with root package name */
    public dv f21003e;

    /* renamed from: f  reason: collision with root package name */
    public p2 f21004f;

    /* renamed from: g  reason: collision with root package name */
    public dt f21005g;

    /* renamed from: h  reason: collision with root package name */
    private String f21006h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21007i;

    /* renamed from: j  reason: collision with root package name */
    public String f21008j;

    public b2() {
        new dy();
        a();
    }

    public final void a() {
        this.f21006h = UUID.randomUUID().toString();
    }

    public final String b() {
        return this.f21006h;
    }

    public final boolean c() {
        dt dtVar = this.f21000b;
        return dtVar != null && dtVar.a();
    }

    public final String toString() {
        return "BackendState(accessTokenState:" + this.f21000b + " loginAccessToken:" + this.f21005g + ")";
    }
}
