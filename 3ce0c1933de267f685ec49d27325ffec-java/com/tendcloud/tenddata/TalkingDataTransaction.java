package com.tendcloud.tenddata;

import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class TalkingDataTransaction extends JSONObject {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22520a = "transactionId";

    /* renamed from: b  reason: collision with root package name */
    private static final String f22521b = "category";

    /* renamed from: c  reason: collision with root package name */
    private static final String f22522c = "amount";

    /* renamed from: d  reason: collision with root package name */
    private static final String f22523d = "personA";

    /* renamed from: e  reason: collision with root package name */
    private static final String f22524e = "personB";

    /* renamed from: f  reason: collision with root package name */
    private static final String f22525f = "start_date";

    /* renamed from: g  reason: collision with root package name */
    private static final String f22526g = "end_date";

    /* renamed from: h  reason: collision with root package name */
    private static final String f22527h = "currencyType";

    /* renamed from: i  reason: collision with root package name */
    private static final String f22528i = "content";

    private TalkingDataTransaction() {
    }

    public static TalkingDataTransaction createTransaction() {
        return new TalkingDataTransaction();
    }

    public TalkingDataTransaction setAmount(int i10) {
        try {
            put("amount", i10);
        } catch (Throwable th2) {
            g.a("set amount error ", th2);
        }
        return this;
    }

    public TalkingDataTransaction setCategory(String str) {
        try {
            put(f22521b, str);
        } catch (Throwable th2) {
            g.a("set category error ", th2);
        }
        return this;
    }

    public TalkingDataTransaction setContent(String str) {
        try {
            put("content", str);
        } catch (Throwable th2) {
            g.a("set content error ", th2);
        }
        return this;
    }

    public TalkingDataTransaction setCurrencyType(String str) {
        try {
            put(f22527h, str);
        } catch (Throwable th2) {
            g.a("set currency type error ", th2);
        }
        return this;
    }

    public TalkingDataTransaction setEndDate(long j10) {
        try {
            put(f22526g, j10);
        } catch (Throwable th2) {
            g.a("set end date error ", th2);
        }
        return this;
    }

    public TalkingDataTransaction setPersonA(String str) {
        try {
            put(f22523d, str);
        } catch (Throwable th2) {
            g.a("set personA error ", th2);
        }
        return this;
    }

    public TalkingDataTransaction setPersonB(String str) {
        try {
            put(f22524e, str);
        } catch (Throwable th2) {
            g.a("set personB error ", th2);
        }
        return this;
    }

    public TalkingDataTransaction setStartDate(long j10) {
        try {
            put(f22525f, j10);
        } catch (Throwable th2) {
            g.a("set start date error ", th2);
        }
        return this;
    }

    public TalkingDataTransaction setTransactionId(String str) {
        try {
            put(f22520a, str);
        } catch (Throwable th2) {
            g.a("set transactionId error ", th2);
        }
        return this;
    }
}
