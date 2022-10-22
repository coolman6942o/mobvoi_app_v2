package com.google.android.gms.tasks;

import b6.i;
import b7.c;
import b7.d;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public final class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b extends b7.a, c, d<Object> {
    }

    public static <TResult> TResult a(com.google.android.gms.tasks.b<TResult> bVar) throws ExecutionException, InterruptedException {
        i.i();
        i.l(bVar, "Task must not be null");
        if (bVar.n()) {
            return (TResult) g(bVar);
        }
        a aVar = new a(null);
        f(bVar, aVar);
        aVar.a();
        return (TResult) g(bVar);
    }

    public static <TResult> TResult b(com.google.android.gms.tasks.b<TResult> bVar, long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        i.i();
        i.l(bVar, "Task must not be null");
        i.l(timeUnit, "TimeUnit must not be null");
        if (bVar.n()) {
            return (TResult) g(bVar);
        }
        a aVar = new a(null);
        f(bVar, aVar);
        if (aVar.b(j10, timeUnit)) {
            return (TResult) g(bVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static <TResult> com.google.android.gms.tasks.b<TResult> c(Executor executor, Callable<TResult> callable) {
        i.l(executor, "Executor must not be null");
        i.l(callable, "Callback must not be null");
        s sVar = new s();
        executor.execute(new t(sVar, callable));
        return sVar;
    }

    public static <TResult> com.google.android.gms.tasks.b<TResult> d(Exception exc) {
        s sVar = new s();
        sVar.p(exc);
        return sVar;
    }

    public static <TResult> com.google.android.gms.tasks.b<TResult> e(TResult tresult) {
        s sVar = new s();
        sVar.q(tresult);
        return sVar;
    }

    private static void f(com.google.android.gms.tasks.b<?> bVar, b bVar2) {
        Executor executor = d.f10151b;
        bVar.g(executor, bVar2);
        bVar.e(executor, bVar2);
        bVar.a(executor, bVar2);
    }

    private static <TResult> TResult g(com.google.android.gms.tasks.b<TResult> bVar) throws ExecutionException {
        if (bVar.o()) {
            return bVar.k();
        }
        if (bVar.m()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(bVar.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private final CountDownLatch f10153a;

        private a() {
            this.f10153a = new CountDownLatch(1);
        }

        public final void a() throws InterruptedException {
            this.f10153a.await();
        }

        public final boolean b(long j10, TimeUnit timeUnit) throws InterruptedException {
            return this.f10153a.await(j10, timeUnit);
        }

        @Override // b7.a
        public final void onCanceled() {
            this.f10153a.countDown();
        }

        @Override // b7.c
        public final void onFailure(Exception exc) {
            this.f10153a.countDown();
        }

        @Override // b7.d
        public final void onSuccess(Object obj) {
            this.f10153a.countDown();
        }

        /* synthetic */ a(t tVar) {
            this();
        }
    }
}
