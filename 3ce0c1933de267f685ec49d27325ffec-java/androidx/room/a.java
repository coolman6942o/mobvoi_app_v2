package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import h1.e;
import i1.c;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
/* compiled from: AutoCloser.java */
/* loaded from: classes.dex */
final class a {

    /* renamed from: e  reason: collision with root package name */
    final long f4180e;

    /* renamed from: f  reason: collision with root package name */
    final Executor f4181f;

    /* renamed from: i  reason: collision with root package name */
    i1.b f4184i;

    /* renamed from: a  reason: collision with root package name */
    private c f4176a = null;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f4177b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    Runnable f4178c = null;

    /* renamed from: d  reason: collision with root package name */
    final Object f4179d = new Object();

    /* renamed from: g  reason: collision with root package name */
    int f4182g = 0;

    /* renamed from: h  reason: collision with root package name */
    long f4183h = SystemClock.uptimeMillis();

    /* renamed from: j  reason: collision with root package name */
    private boolean f4185j = false;

    /* renamed from: k  reason: collision with root package name */
    private final Runnable f4186k = new RunnableC0044a();

    /* renamed from: l  reason: collision with root package name */
    final Runnable f4187l = new b();

    /* compiled from: AutoCloser.java */
    /* renamed from: androidx.room.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0044a implements Runnable {
        RunnableC0044a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.f4181f.execute(aVar.f4187l);
        }
    }

    /* compiled from: AutoCloser.java */
    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (a.this.f4179d) {
                long uptimeMillis = SystemClock.uptimeMillis();
                a aVar = a.this;
                if (uptimeMillis - aVar.f4183h >= aVar.f4180e) {
                    if (aVar.f4182g == 0) {
                        Runnable runnable = aVar.f4178c;
                        if (runnable != null) {
                            runnable.run();
                            i1.b bVar = a.this.f4184i;
                            if (bVar != null && bVar.isOpen()) {
                                try {
                                    a.this.f4184i.close();
                                } catch (IOException e10) {
                                    e.a(e10);
                                }
                                a.this.f4184i = null;
                            }
                            return;
                        }
                        throw new IllegalStateException("mOnAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(long j10, TimeUnit timeUnit, Executor executor) {
        this.f4180e = timeUnit.toMillis(j10);
        this.f4181f = executor;
    }

    public void a() throws IOException {
        synchronized (this.f4179d) {
            this.f4185j = true;
            i1.b bVar = this.f4184i;
            if (bVar != null) {
                bVar.close();
            }
            this.f4184i = null;
        }
    }

    public void b() {
        synchronized (this.f4179d) {
            int i10 = this.f4182g;
            if (i10 > 0) {
                int i11 = i10 - 1;
                this.f4182g = i11;
                if (i11 == 0) {
                    if (this.f4184i != null) {
                        this.f4177b.postDelayed(this.f4186k, this.f4180e);
                    } else {
                        return;
                    }
                }
                return;
            }
            throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");
        }
    }

    public <V> V c(m.a<i1.b, V> aVar) {
        try {
            return aVar.apply(e());
        } finally {
            b();
        }
    }

    public i1.b d() {
        i1.b bVar;
        synchronized (this.f4179d) {
            bVar = this.f4184i;
        }
        return bVar;
    }

    public i1.b e() {
        synchronized (this.f4179d) {
            this.f4177b.removeCallbacks(this.f4186k);
            this.f4182g++;
            if (!this.f4185j) {
                i1.b bVar = this.f4184i;
                if (bVar == null || !bVar.isOpen()) {
                    c cVar = this.f4176a;
                    if (cVar != null) {
                        i1.b S = cVar.S();
                        this.f4184i = S;
                        return S;
                    }
                    throw new IllegalStateException("AutoCloser has not been initialized. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                }
                return this.f4184i;
            }
            throw new IllegalStateException("Attempting to open already closed database.");
        }
    }

    public void f(c cVar) {
        if (this.f4176a != null) {
            Log.e("ROOM", "AutoCloser initialized multiple times. Please file a bug against room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
        } else {
            this.f4176a = cVar;
        }
    }

    public boolean g() {
        return !this.f4185j;
    }

    public void h(Runnable runnable) {
        this.f4178c = runnable;
    }
}
