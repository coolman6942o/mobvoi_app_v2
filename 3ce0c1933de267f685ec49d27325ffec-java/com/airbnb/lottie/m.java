package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import k3.d;
/* compiled from: LottieTask.java */
/* loaded from: classes.dex */
public class m<T> {

    /* renamed from: e  reason: collision with root package name */
    public static Executor f6536e = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    private final Set<h<T>> f6537a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<h<Throwable>> f6538b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f6539c;

    /* renamed from: d  reason: collision with root package name */
    private volatile l<T> f6540d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieTask.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.f6540d != null) {
                l lVar = m.this.f6540d;
                if (lVar.b() != null) {
                    m.this.i(lVar.b());
                } else {
                    m.this.g(lVar.a());
                }
            }
        }
    }

    /* compiled from: LottieTask.java */
    /* loaded from: classes.dex */
    private class b extends FutureTask<l<T>> {
        b(Callable<l<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (!isCancelled()) {
                try {
                    m.this.l(get());
                } catch (InterruptedException | ExecutionException e10) {
                    m.this.l(new l(e10));
                }
            }
        }
    }

    public m(Callable<l<T>> callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(Throwable th2) {
        ArrayList<h> arrayList = new ArrayList(this.f6538b);
        if (arrayList.isEmpty()) {
            d.d("Lottie encountered an error but no failure listener was added:", th2);
            return;
        }
        for (h hVar : arrayList) {
            hVar.a(th2);
        }
    }

    private void h() {
        this.f6539c.post(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i(T t10) {
        for (h hVar : new ArrayList(this.f6537a)) {
            hVar.a(t10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(l<T> lVar) {
        if (this.f6540d == null) {
            this.f6540d = lVar;
            h();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized m<T> e(h<Throwable> hVar) {
        if (!(this.f6540d == null || this.f6540d.a() == null)) {
            hVar.a(this.f6540d.a());
        }
        this.f6538b.add(hVar);
        return this;
    }

    public synchronized m<T> f(h<T> hVar) {
        if (!(this.f6540d == null || this.f6540d.b() == null)) {
            hVar.a(this.f6540d.b());
        }
        this.f6537a.add(hVar);
        return this;
    }

    public synchronized m<T> j(h<Throwable> hVar) {
        this.f6538b.remove(hVar);
        return this;
    }

    public synchronized m<T> k(h<T> hVar) {
        this.f6537a.remove(hVar);
        return this;
    }

    m(Callable<l<T>> callable, boolean z10) {
        this.f6537a = new LinkedHashSet(1);
        this.f6538b = new LinkedHashSet(1);
        this.f6539c = new Handler(Looper.getMainLooper());
        this.f6540d = null;
        if (z10) {
            try {
                l(callable.call());
            } catch (Throwable th2) {
                l(new l<>(th2));
            }
        } else {
            f6536e.execute(new b(callable));
        }
    }
}
