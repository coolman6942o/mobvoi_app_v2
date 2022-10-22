package androidx.room;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import androidx.room.o;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RoomTrackingLiveData.java */
/* loaded from: classes.dex */
public class i0<T> extends LiveData<T> {

    /* renamed from: l  reason: collision with root package name */
    final RoomDatabase f4245l;

    /* renamed from: m  reason: collision with root package name */
    final boolean f4246m;

    /* renamed from: n  reason: collision with root package name */
    final Callable<T> f4247n;

    /* renamed from: o  reason: collision with root package name */
    private final m f4248o;

    /* renamed from: p  reason: collision with root package name */
    final o.c f4249p;

    /* renamed from: q  reason: collision with root package name */
    final AtomicBoolean f4250q = new AtomicBoolean(true);

    /* renamed from: r  reason: collision with root package name */
    final AtomicBoolean f4251r = new AtomicBoolean(false);

    /* renamed from: s  reason: collision with root package name */
    final AtomicBoolean f4252s = new AtomicBoolean(false);

    /* renamed from: t  reason: collision with root package name */
    final Runnable f4253t = new a();

    /* renamed from: u  reason: collision with root package name */
    final Runnable f4254u = new b();

    /* compiled from: RoomTrackingLiveData.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            if (i0.this.f4252s.compareAndSet(false, true)) {
                i0.this.f4245l.k().b(i0.this.f4249p);
            }
            do {
                if (i0.this.f4251r.compareAndSet(false, true)) {
                    T t10 = null;
                    z10 = false;
                    while (i0.this.f4250q.compareAndSet(true, false)) {
                        try {
                            try {
                                t10 = i0.this.f4247n.call();
                                z10 = true;
                            } catch (Exception e10) {
                                throw new RuntimeException("Exception while computing database live data.", e10);
                            }
                        } finally {
                            i0.this.f4251r.set(false);
                        }
                    }
                    if (z10) {
                        i0.this.m(t10);
                    }
                } else {
                    z10 = false;
                }
                if (!z10) {
                    return;
                }
            } while (i0.this.f4250q.get());
        }
    }

    /* compiled from: RoomTrackingLiveData.java */
    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean h10 = i0.this.h();
            if (i0.this.f4250q.compareAndSet(false, true) && h10) {
                i0.this.q().execute(i0.this.f4253t);
            }
        }
    }

    /* compiled from: RoomTrackingLiveData.java */
    /* loaded from: classes.dex */
    class c extends o.c {
        c(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.o.c
        public void b(Set<String> set) {
            k.a.f().b(i0.this.f4254u);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"RestrictedApi"})
    public i0(RoomDatabase roomDatabase, m mVar, boolean z10, Callable<T> callable, String[] strArr) {
        this.f4245l = roomDatabase;
        this.f4246m = z10;
        this.f4247n = callable;
        this.f4248o = mVar;
        this.f4249p = new c(strArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void k() {
        super.k();
        this.f4248o.b(this);
        q().execute(this.f4253t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void l() {
        super.l();
        this.f4248o.c(this);
    }

    Executor q() {
        if (this.f4246m) {
            return this.f4245l.o();
        }
        return this.f4245l.m();
    }
}
