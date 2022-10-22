package com.huawei.hms.framework.network.grs.d;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, a> f13956a = new ConcurrentHashMap(16);

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private long f13957a;

        /* renamed from: b  reason: collision with root package name */
        private long f13958b;

        public a(long j10, long j11) {
            this.f13957a = j10;
            this.f13958b = j11;
        }

        public boolean a() {
            return SystemClock.elapsedRealtime() - this.f13958b <= this.f13957a;
        }
    }

    public static a a(String str) {
        Logger.v("RequestUtil", "map size of get is before:" + f13956a.size());
        a aVar = f13956a.get(str);
        Logger.v("RequestUtil", "map size of get is after:" + f13956a.size());
        return aVar;
    }

    public static void a(String str, a aVar) {
        Logger.v("RequestUtil", "map size of put is before:" + f13956a.size());
        f13956a.put(str, aVar);
        Logger.v("RequestUtil", "map size of put is after:" + f13956a.size());
    }
}
