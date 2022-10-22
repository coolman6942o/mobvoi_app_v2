package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class l implements ab {

    /* renamed from: b  reason: collision with root package name */
    public static l f6753b;

    /* renamed from: i  reason: collision with root package name */
    public static final ThreadFactory f6754i = new n();

    /* renamed from: a  reason: collision with root package name */
    public Context f6755a;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f6756c;

    /* renamed from: d  reason: collision with root package name */
    public b f6757d = b.a("android");

    /* renamed from: e  reason: collision with root package name */
    public long f6758e;

    /* renamed from: f  reason: collision with root package name */
    public long f6759f;

    /* renamed from: g  reason: collision with root package name */
    public long f6760g;

    /* renamed from: h  reason: collision with root package name */
    public int f6761h;

    public l(Context context) {
        this.f6755a = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 11, 3L, TimeUnit.SECONDS, new ArrayBlockingQueue(20), f6754i, new ThreadPoolExecutor.CallerRunsPolicy());
        this.f6756c = threadPoolExecutor;
        try {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception unused) {
        }
        CookieSyncManager.createInstance(this.f6755a);
        CookieManager.getInstance().setAcceptCookie(true);
    }

    public static final l a(Context context) {
        l lVar = f6753b;
        return lVar != null ? lVar : b(context);
    }

    public static final synchronized l b(Context context) {
        synchronized (l.class) {
            l lVar = f6753b;
            if (lVar != null) {
                return lVar;
            }
            l lVar2 = new l(context);
            f6753b = lVar2;
            return lVar2;
        }
    }

    public final b a() {
        return this.f6757d;
    }

    @Override // com.alipay.android.phone.mrpc.core.ab
    public final Future<u> a(t tVar) {
        if (s.a(this.f6755a)) {
            String str = "HttpManager" + hashCode() + ": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times";
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(this.f6756c.getActiveCount());
            objArr[1] = Long.valueOf(this.f6756c.getCompletedTaskCount());
            objArr[2] = Long.valueOf(this.f6756c.getTaskCount());
            long j10 = this.f6760g;
            long j11 = 0;
            objArr[3] = Long.valueOf(j10 == 0 ? 0L : ((this.f6758e * 1000) / j10) >> 10);
            int i10 = this.f6761h;
            if (i10 != 0) {
                j11 = this.f6759f / i10;
            }
            objArr[4] = Long.valueOf(j11);
            objArr[5] = Long.valueOf(this.f6758e);
            objArr[6] = Long.valueOf(this.f6759f);
            objArr[7] = Long.valueOf(this.f6760g);
            objArr[8] = Integer.valueOf(this.f6761h);
            String.format(str, objArr);
        }
        q qVar = new q(this, (o) tVar);
        m mVar = new m(this, qVar, qVar);
        this.f6756c.execute(mVar);
        return mVar;
    }

    public final void a(long j10) {
        this.f6758e += j10;
    }

    public final void b(long j10) {
        this.f6759f += j10;
        this.f6761h++;
    }

    public final void c(long j10) {
        this.f6760g += j10;
    }
}
