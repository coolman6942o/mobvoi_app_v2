package com.huawei.hianalytics.mn.no.tu;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class mn {

    /* renamed from: mn  reason: collision with root package name */
    private static mn f13621mn;

    /* renamed from: no  reason: collision with root package name */
    private volatile Map<String, no> f13622no = new HashMap();

    private mn() {
    }

    public static mn mn() {
        if (f13621mn == null) {
            no();
        }
        return f13621mn;
    }

    private no no(String str) {
        if (!this.f13622no.containsKey(str)) {
            this.f13622no.put(str, new no());
        }
        return this.f13622no.get(str);
    }

    private static synchronized void no() {
        synchronized (mn.class) {
            if (f13621mn == null) {
                f13621mn = new mn();
            }
        }
    }

    public final no mn(String str, long j10) {
        no no2 = no(str);
        no2.mn(j10);
        return no2;
    }

    public final void mn(String str) {
        no(str).op();
    }
}
