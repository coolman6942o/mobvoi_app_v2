package com.tendcloud.tenddata;
/* compiled from: td */
/* loaded from: classes2.dex */
public class cm extends ch {

    /* renamed from: a  reason: collision with root package name */
    public static cl f22819a = null;

    /* renamed from: c  reason: collision with root package name */
    private static final String f22820c = "type";

    /* renamed from: d  reason: collision with root package name */
    private static final String f22821d = "deviceId";

    /* renamed from: e  reason: collision with root package name */
    private static final String f22822e = "runtimeConfig";

    /* renamed from: f  reason: collision with root package name */
    private static final String f22823f = "hardwareConfig";

    /* renamed from: g  reason: collision with root package name */
    private static final String f22824g = "softwareConfig";

    /* renamed from: h  reason: collision with root package name */
    private cn f22825h = new cn();

    /* renamed from: i  reason: collision with root package name */
    private ck f22826i = new ck();

    public cm() {
        d();
    }

    private void d() {
        a("type", "mobile");
        cl clVar = new cl();
        f22819a = clVar;
        a(f22821d, clVar.b());
        a(f22822e, new cp().b());
        a(f22823f, this.f22826i.b());
        a(f22824g, this.f22825h.b());
    }

    public cn a() {
        return this.f22825h;
    }

    public ck c() {
        return this.f22826i;
    }
}
