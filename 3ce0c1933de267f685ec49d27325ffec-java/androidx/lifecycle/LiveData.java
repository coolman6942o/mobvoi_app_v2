package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: k  reason: collision with root package name */
    static final Object f3249k = new Object();

    /* renamed from: a  reason: collision with root package name */
    final Object f3250a;

    /* renamed from: b  reason: collision with root package name */
    private l.b<x<? super T>, LiveData<T>.c> f3251b;

    /* renamed from: c  reason: collision with root package name */
    int f3252c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3253d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Object f3254e;

    /* renamed from: f  reason: collision with root package name */
    volatile Object f3255f;

    /* renamed from: g  reason: collision with root package name */
    private int f3256g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3257h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3258i;

    /* renamed from: j  reason: collision with root package name */
    private final Runnable f3259j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class LifecycleBoundObserver extends LiveData<T>.c implements n {

        /* renamed from: e  reason: collision with root package name */
        final p f3260e;

        LifecycleBoundObserver(p pVar, x<? super T> xVar) {
            super(xVar);
            this.f3260e = pVar;
        }

        @Override // androidx.lifecycle.n
        public void c(p pVar, Lifecycle.Event event) {
            Lifecycle.State b10 = this.f3260e.getLifecycle().b();
            if (b10 == Lifecycle.State.DESTROYED) {
                LiveData.this.n(this.f3263a);
                return;
            }
            for (Lifecycle.State state = null; state != b10; state = b10) {
                d(k());
                b10 = this.f3260e.getLifecycle().b();
            }
        }

        @Override // androidx.lifecycle.LiveData.c
        void h() {
            this.f3260e.getLifecycle().c(this);
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean j(p pVar) {
            return this.f3260e == pVar;
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean k() {
            return this.f3260e.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED);
        }
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f3250a) {
                obj = LiveData.this.f3255f;
                LiveData.this.f3255f = LiveData.f3249k;
            }
            LiveData.this.o(obj);
        }
    }

    /* loaded from: classes.dex */
    private class b extends LiveData<T>.c {
        b(LiveData liveData, x<? super T> xVar) {
            super(xVar);
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean k() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final x<? super T> f3263a;

        /* renamed from: b  reason: collision with root package name */
        boolean f3264b;

        /* renamed from: c  reason: collision with root package name */
        int f3265c = -1;

        c(x<? super T> xVar) {
            this.f3263a = xVar;
        }

        void d(boolean z10) {
            if (z10 != this.f3264b) {
                this.f3264b = z10;
                LiveData.this.c(z10 ? 1 : -1);
                if (this.f3264b) {
                    LiveData.this.e(this);
                }
            }
        }

        void h() {
        }

        boolean j(p pVar) {
            return false;
        }

        abstract boolean k();
    }

    public LiveData(T t10) {
        this.f3250a = new Object();
        this.f3251b = new l.b<>();
        this.f3252c = 0;
        this.f3255f = f3249k;
        this.f3259j = new a();
        this.f3254e = t10;
        this.f3256g = 0;
    }

    static void b(String str) {
        if (!k.a.f().c()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }

    private void d(LiveData<T>.c cVar) {
        if (cVar.f3264b) {
            if (!cVar.k()) {
                cVar.d(false);
                return;
            }
            int i10 = cVar.f3265c;
            int i11 = this.f3256g;
            if (i10 < i11) {
                cVar.f3265c = i11;
                cVar.f3263a.a((Object) this.f3254e);
            }
        }
    }

    void c(int i10) {
        int i11 = this.f3252c;
        this.f3252c = i10 + i11;
        if (!this.f3253d) {
            this.f3253d = true;
            while (true) {
                try {
                    int i12 = this.f3252c;
                    if (i11 != i12) {
                        boolean z10 = i11 == 0 && i12 > 0;
                        boolean z11 = i11 > 0 && i12 == 0;
                        if (z10) {
                            k();
                        } else if (z11) {
                            l();
                        }
                        i11 = i12;
                    } else {
                        return;
                    }
                } finally {
                    this.f3253d = false;
                }
            }
        }
    }

    void e(LiveData<T>.c cVar) {
        if (this.f3257h) {
            this.f3258i = true;
            return;
        }
        this.f3257h = true;
        do {
            this.f3258i = false;
            if (cVar == null) {
                l.b<x<? super T>, LiveData<T>.c>.d c10 = this.f3251b.c();
                while (c10.hasNext()) {
                    d((c) c10.next().getValue());
                    if (this.f3258i) {
                        break;
                    }
                }
            } else {
                d(cVar);
                cVar = null;
            }
        } while (this.f3258i);
        this.f3257h = false;
    }

    public T f() {
        T t10 = (T) this.f3254e;
        if (t10 != f3249k) {
            return t10;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f3256g;
    }

    public boolean h() {
        return this.f3252c > 0;
    }

    public void i(p pVar, x<? super T> xVar) {
        b("observe");
        if (pVar.getLifecycle().b() != Lifecycle.State.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(pVar, xVar);
            LiveData<T>.c f10 = this.f3251b.f(xVar, lifecycleBoundObserver);
            if (f10 != null && !f10.j(pVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (f10 == null) {
                pVar.getLifecycle().a(lifecycleBoundObserver);
            }
        }
    }

    public void j(x<? super T> xVar) {
        b("observeForever");
        b bVar = new b(this, xVar);
        LiveData<T>.c f10 = this.f3251b.f(xVar, bVar);
        if (f10 instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (f10 == null) {
            bVar.d(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(T t10) {
        boolean z10;
        synchronized (this.f3250a) {
            z10 = this.f3255f == f3249k;
            this.f3255f = t10;
        }
        if (z10) {
            k.a.f().d(this.f3259j);
        }
    }

    public void n(x<? super T> xVar) {
        b("removeObserver");
        LiveData<T>.c g10 = this.f3251b.g(xVar);
        if (g10 != null) {
            g10.h();
            g10.d(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(T t10) {
        b("setValue");
        this.f3256g++;
        this.f3254e = t10;
        e(null);
    }

    public LiveData() {
        this.f3250a = new Object();
        this.f3251b = new l.b<>();
        this.f3252c = 0;
        Object obj = f3249k;
        this.f3255f = obj;
        this.f3259j = new a();
        this.f3254e = obj;
        this.f3256g = -1;
    }
}
