package s0;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.collection.f;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimationHandler.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static final ThreadLocal<a> f34228g = new ThreadLocal<>();

    /* renamed from: d  reason: collision with root package name */
    private c f34232d;

    /* renamed from: a  reason: collision with root package name */
    private final f<b, Long> f34229a = new f<>();

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<b> f34230b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final C0489a f34231c = new C0489a();

    /* renamed from: e  reason: collision with root package name */
    long f34233e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f34234f = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimationHandler.java */
    /* renamed from: s0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0489a {
        C0489a() {
        }

        void a() {
            a.this.f34233e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.c(aVar.f34233e);
            if (a.this.f34230b.size() > 0) {
                a.this.e().a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimationHandler.java */
    /* loaded from: classes.dex */
    public interface b {
        boolean a(long j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimationHandler.java */
    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final C0489a f34236a;

        c(C0489a aVar) {
            this.f34236a = aVar;
        }

        abstract void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimationHandler.java */
    /* loaded from: classes.dex */
    public static class d extends c {

        /* renamed from: d  reason: collision with root package name */
        long f34239d = -1;

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f34237b = new RunnableC0490a();

        /* renamed from: c  reason: collision with root package name */
        private final Handler f34238c = new Handler(Looper.myLooper());

        /* compiled from: AnimationHandler.java */
        /* renamed from: s0.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0490a implements Runnable {
            RunnableC0490a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f34239d = SystemClock.uptimeMillis();
                d.this.f34236a.a();
            }
        }

        d(C0489a aVar) {
            super(aVar);
        }

        @Override // s0.a.c
        void a() {
            this.f34238c.postDelayed(this.f34237b, Math.max(10 - (SystemClock.uptimeMillis() - this.f34239d), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimationHandler.java */
    /* loaded from: classes.dex */
    public static class e extends c {

        /* renamed from: b  reason: collision with root package name */
        private final Choreographer f34241b = Choreographer.getInstance();

        /* renamed from: c  reason: collision with root package name */
        private final Choreographer.FrameCallback f34242c = new Choreographer$FrameCallbackC0491a();

        /* compiled from: AnimationHandler.java */
        /* renamed from: s0.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class Choreographer$FrameCallbackC0491a implements Choreographer.FrameCallback {
            Choreographer$FrameCallbackC0491a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j10) {
                e.this.f34236a.a();
            }
        }

        e(C0489a aVar) {
            super(aVar);
        }

        @Override // s0.a.c
        void a() {
            this.f34241b.postFrameCallback(this.f34242c);
        }
    }

    a() {
    }

    private void b() {
        if (this.f34234f) {
            for (int size = this.f34230b.size() - 1; size >= 0; size--) {
                if (this.f34230b.get(size) == null) {
                    this.f34230b.remove(size);
                }
            }
            this.f34234f = false;
        }
    }

    public static a d() {
        ThreadLocal<a> threadLocal = f34228g;
        if (threadLocal.get() == null) {
            threadLocal.set(new a());
        }
        return threadLocal.get();
    }

    private boolean f(b bVar, long j10) {
        Long l10 = this.f34229a.get(bVar);
        if (l10 == null) {
            return true;
        }
        if (l10.longValue() >= j10) {
            return false;
        }
        this.f34229a.remove(bVar);
        return true;
    }

    public void a(b bVar, long j10) {
        if (this.f34230b.size() == 0) {
            e().a();
        }
        if (!this.f34230b.contains(bVar)) {
            this.f34230b.add(bVar);
        }
        if (j10 > 0) {
            this.f34229a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j10));
        }
    }

    void c(long j10) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i10 = 0; i10 < this.f34230b.size(); i10++) {
            b bVar = this.f34230b.get(i10);
            if (bVar != null && f(bVar, uptimeMillis)) {
                bVar.a(j10);
            }
        }
        b();
    }

    c e() {
        if (this.f34232d == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f34232d = new e(this.f34231c);
            } else {
                this.f34232d = new d(this.f34231c);
            }
        }
        return this.f34232d;
    }

    public void g(b bVar) {
        this.f34229a.remove(bVar);
        int indexOf = this.f34230b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f34230b.set(indexOf, null);
            this.f34234f = true;
        }
    }
}
