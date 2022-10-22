package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.x;
import kotlinx.coroutines.internal.z;
import vo.f;
/* compiled from: Tasks.kt */
/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final long f30325a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f30326b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f30327c;

    /* renamed from: d  reason: collision with root package name */
    public static final long f30328d;

    /* renamed from: e  reason: collision with root package name */
    public static g f30329e = e.f30319a;

    static {
        long e10;
        int c10;
        int d10;
        int h10;
        int d11;
        long e11;
        e10 = z.e("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        f30325a = e10;
        z.d("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
        c10 = f.c(x.a(), 2);
        d10 = z.d("kotlinx.coroutines.scheduler.core.pool.size", c10, 1, 0, 8, null);
        f30326b = d10;
        h10 = f.h(x.a() * 128, d10, 2097150);
        d11 = z.d("kotlinx.coroutines.scheduler.max.pool.size", h10, 0, 2097150, 4, null);
        f30327c = d11;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e11 = z.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f30328d = timeUnit.toNanos(e11);
    }
}
