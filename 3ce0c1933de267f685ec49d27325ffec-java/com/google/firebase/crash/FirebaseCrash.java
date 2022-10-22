package com.google.firebase.crash;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.internal.measurement.i7;
import com.google.android.gms.internal.measurement.j7;
import com.google.android.gms.internal.measurement.k7;
import com.google.android.gms.internal.measurement.m7;
import com.google.android.gms.internal.measurement.q7;
import com.google.firebase.iid.FirebaseInstanceId;
import java.lang.Thread;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
@UsedByReflection("FirebaseApp")
@Deprecated
/* loaded from: classes.dex */
public class FirebaseCrash {

    /* renamed from: h  reason: collision with root package name */
    private static volatile FirebaseCrash f12430h;

    /* renamed from: a  reason: collision with root package name */
    private final Context f12431a;

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f12432b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.a f12433c;

    /* renamed from: f  reason: collision with root package name */
    private q7 f12436f;

    /* renamed from: g  reason: collision with root package name */
    private String f12437g;

    /* renamed from: e  reason: collision with root package name */
    private final CountDownLatch f12435e = new CountDownLatch(1);

    /* renamed from: d  reason: collision with root package name */
    private final b f12434d = new b(null);

    /* loaded from: classes.dex */
    public interface a {
        m7 a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private final Object f12438a;

        /* renamed from: b  reason: collision with root package name */
        private m7 f12439b;

        private b() {
            this.f12438a = new Object();
        }

        /* synthetic */ b(com.google.firebase.crash.a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(m7 m7Var) {
            synchronized (this.f12438a) {
                this.f12439b = m7Var;
            }
        }

        @Override // com.google.firebase.crash.FirebaseCrash.a
        public final m7 a() {
            m7 m7Var;
            synchronized (this.f12438a) {
                m7Var = this.f12439b;
            }
            return m7Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Thread.UncaughtExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        private final Thread.UncaughtExceptionHandler f12440a;

        public c(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f12440a = uncaughtExceptionHandler;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread thread, Throwable th2) {
            Log.e("UncaughtException", "", th2);
            if (!FirebaseCrash.this.g()) {
                try {
                    FirebaseCrash.this.i();
                    Future<?> c10 = FirebaseCrash.this.c(th2);
                    if (c10 != null) {
                        c10.get(10000L, TimeUnit.MILLISECONDS);
                    }
                } catch (Exception e10) {
                    Log.e("UncaughtException", "Ouch! My own exception handler threw an exception.", e10);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f12440a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th2);
            }
        }
    }

    private FirebaseCrash(com.google.firebase.a aVar, ExecutorService executorService) {
        this.f12433c = aVar;
        this.f12432b = executorService;
        this.f12431a = aVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        try {
            this.f12435e.await(20000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            Log.e("FirebaseCrash", "Failed waiting for crash api to load.", e10);
        }
    }

    public static FirebaseCrash f() {
        return f12430h != null ? f12430h : getInstance(com.google.firebase.a.c());
    }

    @UsedByReflection("FirebaseApp")
    @Keep
    public static FirebaseCrash getInstance(com.google.firebase.a aVar) {
        if (f12430h == null) {
            synchronized (FirebaseCrash.class) {
                if (f12430h == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    FirebaseCrash firebaseCrash = new FirebaseCrash(aVar, threadPoolExecutor);
                    com.google.firebase.crash.c cVar = new com.google.firebase.crash.c(aVar);
                    Thread.setDefaultUncaughtExceptionHandler(new c(Thread.getDefaultUncaughtExceptionHandler()));
                    com.google.firebase.crash.b bVar = new com.google.firebase.crash.b(firebaseCrash);
                    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
                    newFixedThreadPool.submit(new e(cVar, newFixedThreadPool.submit(new d(cVar)), 10000L, bVar));
                    newFixedThreadPool.shutdown();
                    firebaseCrash.f12432b.execute(new com.google.firebase.crash.a(firebaseCrash));
                    f12430h = firebaseCrash;
                }
            }
        }
        return f12430h;
    }

    private final boolean h() {
        if (g()) {
            return false;
        }
        e();
        m7 a10 = this.f12434d.a();
        if (a10 != null) {
            try {
                return a10.x1();
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(m7 m7Var) {
        if (m7Var == null) {
            this.f12432b.shutdownNow();
        } else {
            this.f12436f = q7.c(this.f12431a);
            this.f12434d.c(m7Var);
            if (this.f12436f != null && !g()) {
                this.f12436f.a(this.f12431a, this.f12432b, this.f12434d);
                Log.d("FirebaseCrash", "Firebase Analytics Listener for Firebase Crash is initialized");
            }
        }
        this.f12435e.countDown();
    }

    final Future<?> c(Throwable th2) {
        if (th2 == null || g()) {
            return null;
        }
        return this.f12432b.submit(new i7(this.f12431a, this.f12434d, th2, this.f12436f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(boolean z10) {
        if (!g()) {
            this.f12432b.submit(new j7(this.f12431a, this.f12434d, z10));
        }
    }

    public final boolean g() {
        return this.f12432b.isShutdown();
    }

    final void i() {
        if (!g() && h() && this.f12437g == null) {
            String a10 = FirebaseInstanceId.b().a();
            this.f12437g = a10;
            this.f12432b.submit(new k7(this.f12431a, this.f12434d, a10));
        }
    }
}
