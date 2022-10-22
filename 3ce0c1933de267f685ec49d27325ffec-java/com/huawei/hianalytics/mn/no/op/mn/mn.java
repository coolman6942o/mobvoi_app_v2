package com.huawei.hianalytics.mn.no.op.mn;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class mn {

    /* renamed from: mn  reason: collision with root package name */
    static Map<String, qr> f13546mn = new HashMap();

    /* renamed from: op  reason: collision with root package name */
    private static mn f13547op;

    /* renamed from: no  reason: collision with root package name */
    private pq f13548no = new pq();

    private mn() {
    }

    public static mn mn() {
        if (f13547op == null) {
            pq();
        }
        return f13547op;
    }

    private static synchronized void pq() {
        synchronized (mn.class) {
            if (f13547op == null) {
                f13547op = new mn();
            }
        }
    }

    public final qr mn(String str) {
        return f13546mn.get(str);
    }

    public final void mn(String str, qr qrVar) {
        f13546mn.put(str, qrVar);
    }

    public final Set<String> no() {
        return f13546mn.keySet();
    }

    public final pq op() {
        return this.f13548no;
    }
}
