package com.tendcloud.tenddata;

import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class TalkingDataSearch extends JSONObject {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22507a = "category";

    /* renamed from: b  reason: collision with root package name */
    private static final String f22508b = "content";

    /* renamed from: c  reason: collision with root package name */
    private static final String f22509c = "item_id";

    /* renamed from: d  reason: collision with root package name */
    private static final String f22510d = "item_location_id";

    /* renamed from: e  reason: collision with root package name */
    private static final String f22511e = "destination";

    /* renamed from: f  reason: collision with root package name */
    private static final String f22512f = "origin";

    /* renamed from: g  reason: collision with root package name */
    private static final String f22513g = "start_date";

    /* renamed from: h  reason: collision with root package name */
    private static final String f22514h = "end_date";

    private TalkingDataSearch() {
    }

    public static TalkingDataSearch createSearch() {
        return new TalkingDataSearch();
    }

    public TalkingDataSearch setCategory(String str) {
        try {
            put(f22507a, str);
        } catch (Throwable th2) {
            g.a("set category error ", th2);
        }
        return this;
    }

    public TalkingDataSearch setContent(String str) {
        try {
            put("content", str);
        } catch (Throwable th2) {
            g.a("set content error ", th2);
        }
        return this;
    }

    public TalkingDataSearch setDestination(String str) {
        try {
            put(f22511e, str);
        } catch (Throwable th2) {
            g.a("set destination error ", th2);
        }
        return this;
    }

    public TalkingDataSearch setEndDate(long j10) {
        try {
            put(f22514h, j10);
        } catch (Throwable th2) {
            g.a("set start date error ", th2);
        }
        return this;
    }

    public TalkingDataSearch setItemId(String str) {
        try {
            put(f22509c, str);
        } catch (Throwable th2) {
            g.a("set item id error ", th2);
        }
        return this;
    }

    public TalkingDataSearch setItemLocationId(String str) {
        try {
            put(f22510d, str);
        } catch (Throwable th2) {
            g.a("set item location id error ", th2);
        }
        return this;
    }

    public TalkingDataSearch setOrigin(String str) {
        try {
            put(f22512f, str);
        } catch (Throwable th2) {
            g.a("set origin error ", th2);
        }
        return this;
    }

    public TalkingDataSearch setStartDate(long j10) {
        try {
            put(f22513g, j10);
        } catch (Throwable th2) {
            g.a("set start date error ", th2);
        }
        return this;
    }
}
