package com.tendcloud.tenddata;

import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class cx extends JSONObject {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22873a = "transactionId";

    /* renamed from: b  reason: collision with root package name */
    private static final String f22874b = "category";

    /* renamed from: c  reason: collision with root package name */
    private static final String f22875c = "amount";

    /* renamed from: d  reason: collision with root package name */
    private static final String f22876d = "personA";

    /* renamed from: e  reason: collision with root package name */
    private static final String f22877e = "personB";

    /* renamed from: f  reason: collision with root package name */
    private static final String f22878f = "start_date";

    /* renamed from: g  reason: collision with root package name */
    private static final String f22879g = "end_date";

    /* renamed from: h  reason: collision with root package name */
    private static final String f22880h = "currencyType";

    /* renamed from: i  reason: collision with root package name */
    private static final String f22881i = "content";

    private cx() {
    }

    public static cx a() {
        return new cx();
    }

    public cx b(String str) {
        try {
            put(f22874b, str);
        } catch (Throwable th2) {
            g.a("set category error ", th2);
        }
        return this;
    }

    public cx c(String str) {
        try {
            put(f22876d, str);
        } catch (Throwable th2) {
            g.a("set personA error ", th2);
        }
        return this;
    }

    public cx d(String str) {
        try {
            put(f22877e, str);
        } catch (Throwable th2) {
            g.a("set personB error ", th2);
        }
        return this;
    }

    public cx e(String str) {
        try {
            put(f22880h, str);
        } catch (Throwable th2) {
            g.a("set currency type error ", th2);
        }
        return this;
    }

    public cx f(String str) {
        try {
            put("content", str);
        } catch (Throwable th2) {
            g.a("set content error ", th2);
        }
        return this;
    }

    public cx a(String str) {
        try {
            put(f22873a, str);
        } catch (Throwable th2) {
            g.a("set transactionId error ", th2);
        }
        return this;
    }

    public cx b(long j10) {
        try {
            put(f22879g, j10);
        } catch (Throwable th2) {
            g.a("set end date error ", th2);
        }
        return this;
    }

    public cx a(int i10) {
        try {
            put("amount", i10);
        } catch (Throwable th2) {
            g.a("set amount error ", th2);
        }
        return this;
    }

    public cx a(long j10) {
        try {
            put(f22878f, j10);
        } catch (Throwable th2) {
            g.a("set start date error ", th2);
        }
        return this;
    }
}
