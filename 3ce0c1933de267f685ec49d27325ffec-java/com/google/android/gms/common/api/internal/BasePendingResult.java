package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.internal.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
@KeepName
/* loaded from: classes.dex */
public abstract class BasePendingResult<R extends h> extends e<R> {

    /* renamed from: p  reason: collision with root package name */
    static final ThreadLocal<Boolean> f8487p = new m2();

    /* renamed from: a  reason: collision with root package name */
    private final Object f8488a;

    /* renamed from: b  reason: collision with root package name */
    private final a<R> f8489b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<d> f8490c;

    /* renamed from: d  reason: collision with root package name */
    private final CountDownLatch f8491d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<e.a> f8492e;

    /* renamed from: f  reason: collision with root package name */
    private i<? super R> f8493f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicReference<z1> f8494g;

    /* renamed from: h  reason: collision with root package name */
    private R f8495h;

    /* renamed from: i  reason: collision with root package name */
    private Status f8496i;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f8497j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8498k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f8499l;

    /* renamed from: m  reason: collision with root package name */
    private g f8500m;
    @KeepName
    private b mResultGuardian;

    /* renamed from: n  reason: collision with root package name */
    private volatile v1<R> f8501n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f8502o;

    /* loaded from: classes.dex */
    public static class a<R extends h> extends q6.i {
        public a(Looper looper) {
            super(looper);
        }

        public final void a(i<? super R> iVar, R r10) {
            sendMessage(obtainMessage(1, new Pair(iVar, r10)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                Pair pair = (Pair) message.obj;
                i iVar = (i) pair.first;
                h hVar = (h) pair.second;
                try {
                    iVar.a(hVar);
                } catch (RuntimeException e10) {
                    BasePendingResult.n(hVar);
                    throw e10;
                }
            } else if (i10 != 2) {
                StringBuilder sb2 = new StringBuilder(45);
                sb2.append("Don't know how to handle message: ");
                sb2.append(i10);
                Log.wtf("BasePendingResult", sb2.toString(), new Exception());
            } else {
                ((BasePendingResult) message.obj).o(Status.f8446g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b {
        private b() {
        }

        protected final void finalize() throws Throwable {
            BasePendingResult.n(BasePendingResult.this.f8495h);
            super.finalize();
        }

        /* synthetic */ b(BasePendingResult basePendingResult, m2 m2Var) {
            this();
        }
    }

    @Deprecated
    BasePendingResult() {
        this.f8488a = new Object();
        this.f8491d = new CountDownLatch(1);
        this.f8492e = new ArrayList<>();
        this.f8494g = new AtomicReference<>();
        this.f8502o = false;
        this.f8489b = new a<>(Looper.getMainLooper());
        this.f8490c = new WeakReference<>(null);
    }

    private final R h() {
        R r10;
        synchronized (this.f8488a) {
            b6.i.o(!this.f8497j, "Result has already been consumed.");
            b6.i.o(i(), "Result is not ready.");
            r10 = this.f8495h;
            this.f8495h = null;
            this.f8493f = null;
            this.f8497j = true;
        }
        z1 andSet = this.f8494g.getAndSet(null);
        if (andSet != null) {
            andSet.a(this);
        }
        return r10;
    }

    private final void l(R r10) {
        this.f8495h = r10;
        this.f8500m = null;
        this.f8491d.countDown();
        this.f8496i = this.f8495h.getStatus();
        if (this.f8498k) {
            this.f8493f = null;
        } else if (this.f8493f != null) {
            this.f8489b.removeMessages(2);
            this.f8489b.a(this.f8493f, h());
        } else if (this.f8495h instanceof com.google.android.gms.common.api.g) {
            this.mResultGuardian = new b(this, null);
        }
        ArrayList<e.a> arrayList = this.f8492e;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            e.a aVar = arrayList.get(i10);
            i10++;
            aVar.a(this.f8496i);
        }
        this.f8492e.clear();
    }

    public static void n(h hVar) {
        if (hVar instanceof com.google.android.gms.common.api.g) {
            try {
                ((com.google.android.gms.common.api.g) hVar).release();
            } catch (RuntimeException e10) {
                String valueOf = String.valueOf(hVar);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 18);
                sb2.append("Unable to release ");
                sb2.append(valueOf);
                Log.w("BasePendingResult", sb2.toString(), e10);
            }
        }
    }

    @Override // com.google.android.gms.common.api.e
    public final void b(e.a aVar) {
        b6.i.b(aVar != null, "Callback cannot be null.");
        synchronized (this.f8488a) {
            if (i()) {
                aVar.a(this.f8496i);
            } else {
                this.f8492e.add(aVar);
            }
        }
    }

    @Override // com.google.android.gms.common.api.e
    public void c() {
        synchronized (this.f8488a) {
            if (!this.f8498k && !this.f8497j) {
                g gVar = this.f8500m;
                if (gVar != null) {
                    try {
                        gVar.cancel();
                    } catch (RemoteException unused) {
                    }
                }
                n(this.f8495h);
                this.f8498k = true;
                l(g(Status.f8447h));
            }
        }
    }

    @Override // com.google.android.gms.common.api.e
    public boolean d() {
        boolean z10;
        synchronized (this.f8488a) {
            z10 = this.f8498k;
        }
        return z10;
    }

    @Override // com.google.android.gms.common.api.e
    public final void e(i<? super R> iVar) {
        synchronized (this.f8488a) {
            if (iVar == null) {
                this.f8493f = null;
                return;
            }
            boolean z10 = true;
            b6.i.o(!this.f8497j, "Result has already been consumed.");
            if (this.f8501n != null) {
                z10 = false;
            }
            b6.i.o(z10, "Cannot set callbacks if then() has been called.");
            if (!d()) {
                if (i()) {
                    this.f8489b.a(iVar, h());
                } else {
                    this.f8493f = iVar;
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.e
    public final Integer f() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract R g(Status status);

    public final boolean i() {
        return this.f8491d.getCount() == 0;
    }

    public final void j(R r10) {
        synchronized (this.f8488a) {
            if (this.f8499l || this.f8498k) {
                n(r10);
                return;
            }
            i();
            boolean z10 = true;
            b6.i.o(!i(), "Results have already been set");
            if (this.f8497j) {
                z10 = false;
            }
            b6.i.o(z10, "Result has already been consumed");
            l(r10);
        }
    }

    public final void m(z1 z1Var) {
        this.f8494g.set(z1Var);
    }

    public final void o(Status status) {
        synchronized (this.f8488a) {
            if (!i()) {
                j(g(status));
                this.f8499l = true;
            }
        }
    }

    public final boolean p() {
        boolean d10;
        synchronized (this.f8488a) {
            if (this.f8490c.get() == null || !this.f8502o) {
                c();
            }
            d10 = d();
        }
        return d10;
    }

    public final void q() {
        this.f8502o = this.f8502o || f8487p.get().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BasePendingResult(d dVar) {
        this.f8488a = new Object();
        this.f8491d = new CountDownLatch(1);
        this.f8492e = new ArrayList<>();
        this.f8494g = new AtomicReference<>();
        this.f8502o = false;
        this.f8489b = new a<>(dVar != null ? dVar.o() : Looper.getMainLooper());
        this.f8490c = new WeakReference<>(dVar);
    }
}
