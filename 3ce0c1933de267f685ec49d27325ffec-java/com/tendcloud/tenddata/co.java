package com.tendcloud.tenddata;
/* compiled from: td */
/* loaded from: classes2.dex */
public class co extends ch {

    /* renamed from: j  reason: collision with root package name */
    private static volatile co f22827j;

    /* renamed from: a  reason: collision with root package name */
    private final String f22828a = "oaid";

    /* renamed from: c  reason: collision with root package name */
    private final String f22829c = "vaid";

    /* renamed from: d  reason: collision with root package name */
    private final String f22830d = "aaid";

    /* renamed from: e  reason: collision with root package name */
    private final String f22831e = "udid";

    /* renamed from: f  reason: collision with root package name */
    private volatile String f22832f = "";

    /* renamed from: g  reason: collision with root package name */
    private volatile String f22833g = "";

    /* renamed from: h  reason: collision with root package name */
    private volatile String f22834h = "";

    /* renamed from: i  reason: collision with root package name */
    private volatile String f22835i = "";

    private co() {
    }

    public static co a() {
        if (f22827j == null) {
            synchronized (co.class) {
                if (f22827j == null) {
                    f22827j = new co();
                }
            }
        }
        return f22827j;
    }

    public String c() {
        return this.f22832f;
    }

    public String d() {
        return this.f22833g;
    }

    public String e() {
        return this.f22834h;
    }

    public String f() {
        return this.f22835i;
    }

    public void setAAID(String str) {
        this.f22833g = str;
        a("aaid", str);
    }

    public void setOAID(String str) {
        this.f22832f = str;
        a("oaid", str);
    }

    public void setUDID(String str) {
        this.f22835i = str;
        a("udid", str);
    }

    public void setVAID(String str) {
        this.f22834h = str;
        a("vaid", str);
    }
}
