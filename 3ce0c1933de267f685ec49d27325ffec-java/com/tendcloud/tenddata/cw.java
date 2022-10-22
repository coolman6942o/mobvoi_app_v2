package com.tendcloud.tenddata;

import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class cw extends JSONObject {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22865a = "category";

    /* renamed from: b  reason: collision with root package name */
    private static final String f22866b = "content";

    /* renamed from: c  reason: collision with root package name */
    private static final String f22867c = "item_id";

    /* renamed from: d  reason: collision with root package name */
    private static final String f22868d = "item_location_id";

    /* renamed from: e  reason: collision with root package name */
    private static final String f22869e = "destination";

    /* renamed from: f  reason: collision with root package name */
    private static final String f22870f = "origin";

    /* renamed from: g  reason: collision with root package name */
    private static final String f22871g = "start_date";

    /* renamed from: h  reason: collision with root package name */
    private static final String f22872h = "end_date";

    private cw() {
    }

    public static cw a() {
        return new cw();
    }

    public cw b(String str) {
        try {
            put("content", str);
        } catch (Throwable th2) {
            g.a("set content error ", th2);
        }
        return this;
    }

    public cw c(String str) {
        try {
            put(f22867c, str);
        } catch (Throwable th2) {
            g.a("set item id error ", th2);
        }
        return this;
    }

    public cw d(String str) {
        try {
            put(f22868d, str);
        } catch (Throwable th2) {
            g.a("set item location id error ", th2);
        }
        return this;
    }

    public cw e(String str) {
        try {
            put(f22869e, str);
        } catch (Throwable th2) {
            g.a("set destination error ", th2);
        }
        return this;
    }

    public cw f(String str) {
        try {
            put(f22870f, str);
        } catch (Throwable th2) {
            g.a("set origin error ", th2);
        }
        return this;
    }

    public cw a(String str) {
        try {
            put(f22865a, str);
        } catch (Throwable th2) {
            g.a("set category error ", th2);
        }
        return this;
    }

    public cw b(long j10) {
        try {
            put(f22872h, j10);
        } catch (Throwable th2) {
            g.a("set start date error ", th2);
        }
        return this;
    }

    public cw a(long j10) {
        try {
            put(f22871g, j10);
        } catch (Throwable th2) {
            g.a("set start date error ", th2);
        }
        return this;
    }
}
