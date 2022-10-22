package com.huawei.hms.framework.network.grs.c.b;

import android.os.SystemClock;
import com.huawei.hms.framework.network.grs.c.f;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Future<f> f13868a;

    /* renamed from: b  reason: collision with root package name */
    private long f13869b = SystemClock.elapsedRealtime();

    public b(Future<f> future) {
        this.f13868a = future;
    }

    public Future<f> a() {
        return this.f13868a;
    }

    public boolean b() {
        return SystemClock.elapsedRealtime() - this.f13869b <= 300000;
    }
}
