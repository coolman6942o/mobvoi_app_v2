package androidx.work;

import androidx.work.impl.utils.futures.c;
import io.m;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.j1;
import qo.l;
/* compiled from: ListenableFuture.kt */
/* loaded from: classes.dex */
public final class j<R> implements com.google.common.util.concurrent.j<R> {

    /* renamed from: a  reason: collision with root package name */
    private final j1 f4888a;

    /* renamed from: b  reason: collision with root package name */
    private final c<R> f4889b;

    /* compiled from: ListenableFuture.kt */
    /* loaded from: classes.dex */
    static final class a extends Lambda implements l<Throwable, m> {
        final /* synthetic */ j<R> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(j<R> jVar) {
            super(1);
            this.this$0 = jVar;
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ m invoke(Throwable th2) {
            invoke2(th2);
            return m.f28349a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th2) {
            if (th2 == null) {
                if (!((j) this.this$0).f4889b.isDone()) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            } else if (th2 instanceof CancellationException) {
                ((j) this.this$0).f4889b.cancel(true);
            } else {
                c cVar = ((j) this.this$0).f4889b;
                Throwable cause = th2.getCause();
                if (cause != null) {
                    th2 = cause;
                }
                cVar.q(th2);
            }
        }
    }

    public j(j1 job, c<R> underlying) {
        i.f(job, "job");
        i.f(underlying, "underlying");
        this.f4888a = job;
        this.f4889b = underlying;
        job.i(new a(this));
    }

    @Override // com.google.common.util.concurrent.j
    public void a(Runnable runnable, Executor executor) {
        this.f4889b.a(runnable, executor);
    }

    public final void c(R r10) {
        this.f4889b.p(r10);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        return this.f4889b.cancel(z10);
    }

    @Override // java.util.concurrent.Future
    public R get() {
        return this.f4889b.get();
    }

    @Override // java.util.concurrent.Future
    public R get(long j10, TimeUnit timeUnit) {
        return this.f4889b.get(j10, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f4889b.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f4889b.isDone();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ j(j1 j1Var, c cVar, int i10, f fVar) {
        this(j1Var, cVar);
        if ((i10 & 2) != 0) {
            cVar = c.t();
            i.e(cVar, "create()");
        }
    }
}
