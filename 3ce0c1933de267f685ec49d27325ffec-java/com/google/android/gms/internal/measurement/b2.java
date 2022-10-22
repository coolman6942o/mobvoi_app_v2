package com.google.android.gms.internal.measurement;

import b6.i;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b2<V> extends FutureTask<V> implements Comparable<b2> {

    /* renamed from: a  reason: collision with root package name */
    private final long f9177a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f9178b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9179c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ z1 f9180d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b2(z1 z1Var, Runnable runnable, boolean z10, String str) {
        super(runnable, null);
        AtomicLong atomicLong;
        this.f9180d = z1Var;
        i.k(str);
        atomicLong = z1.f9837m;
        long andIncrement = atomicLong.getAndIncrement();
        this.f9177a = andIncrement;
        this.f9179c = str;
        this.f9178b = false;
        if (andIncrement == Long.MAX_VALUE) {
            z1Var.c().K().a("Tasks index overflow");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b2(z1 z1Var, Callable<V> callable, boolean z10, String str) {
        super(callable);
        AtomicLong atomicLong;
        this.f9180d = z1Var;
        i.k(str);
        atomicLong = z1.f9837m;
        long andIncrement = atomicLong.getAndIncrement();
        this.f9177a = andIncrement;
        this.f9179c = str;
        this.f9178b = z10;
        if (andIncrement == Long.MAX_VALUE) {
            z1Var.c().K().a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(b2 b2Var) {
        b2 b2Var2 = b2Var;
        boolean z10 = this.f9178b;
        if (z10 != b2Var2.f9178b) {
            return z10 ? -1 : 1;
        }
        long j10 = this.f9177a;
        long j11 = b2Var2.f9177a;
        if (j10 < j11) {
            return -1;
        }
        if (j10 > j11) {
            return 1;
        }
        this.f9180d.c().L().d("Two tasks share the same index. index", Long.valueOf(this.f9177a));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th2) {
        this.f9180d.c().K().d(this.f9179c, th2);
        super.setException(th2);
    }
}
