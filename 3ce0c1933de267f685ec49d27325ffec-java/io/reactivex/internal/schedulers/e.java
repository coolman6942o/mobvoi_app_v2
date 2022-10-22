package io.reactivex.internal.schedulers;

import io.reactivex.s;
import java.util.concurrent.ThreadFactory;
/* compiled from: NewThreadScheduler.java */
/* loaded from: classes3.dex */
public final class e extends s {

    /* renamed from: c  reason: collision with root package name */
    private static final RxThreadFactory f29220c = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: b  reason: collision with root package name */
    final ThreadFactory f29221b;

    public e() {
        this(f29220c);
    }

    @Override // io.reactivex.s
    public s.c a() {
        return new f(this.f29221b);
    }

    public e(ThreadFactory threadFactory) {
        this.f29221b = threadFactory;
    }
}
