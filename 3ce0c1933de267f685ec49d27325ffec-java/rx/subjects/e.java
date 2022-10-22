package rx.subjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.c;
import rx.i;
import yp.d;
/* compiled from: SubjectSubscriptionManager.java */
/* loaded from: classes3.dex */
final class e<T> extends AtomicReference<b<T>> implements c.a<T> {
    private static final long serialVersionUID = 6035251036011671568L;
    volatile Object latest;
    boolean active = true;
    yp.b<c<T>> onStart = d.a();
    yp.b<c<T>> onAdded = d.a();
    yp.b<c<T>> onTerminated = d.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SubjectSubscriptionManager.java */
    /* loaded from: classes3.dex */
    public class a implements yp.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f34190a;

        a(c cVar) {
            this.f34190a = cVar;
        }

        @Override // yp.a
        public void call() {
            e.this.i(this.f34190a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: SubjectSubscriptionManager.java */
    /* loaded from: classes3.dex */
    public static final class b<T> {

        /* renamed from: c  reason: collision with root package name */
        static final c[] f34192c;

        /* renamed from: d  reason: collision with root package name */
        static final b f34193d;

        /* renamed from: e  reason: collision with root package name */
        static final b f34194e;

        /* renamed from: a  reason: collision with root package name */
        final boolean f34195a;

        /* renamed from: b  reason: collision with root package name */
        final c[] f34196b;

        static {
            c[] cVarArr = new c[0];
            f34192c = cVarArr;
            f34193d = new b(true, cVarArr);
            f34194e = new b(false, cVarArr);
        }

        public b(boolean z10, c[] cVarArr) {
            this.f34195a = z10;
            this.f34196b = cVarArr;
        }

        public b a(c cVar) {
            c[] cVarArr = this.f34196b;
            int length = cVarArr.length;
            c[] cVarArr2 = new c[length + 1];
            System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
            cVarArr2[length] = cVar;
            return new b(this.f34195a, cVarArr2);
        }

        public b b(c cVar) {
            c[] cVarArr = this.f34196b;
            int length = cVarArr.length;
            if (length == 1 && cVarArr[0] == cVar) {
                return f34194e;
            }
            if (length == 0) {
                return this;
            }
            int i10 = length - 1;
            c[] cVarArr2 = new c[i10];
            int i11 = 0;
            for (c cVar2 : cVarArr) {
                if (cVar2 != cVar) {
                    if (i11 == i10) {
                        return this;
                    }
                    i11++;
                    cVarArr2[i11] = cVar2;
                }
            }
            if (i11 == 0) {
                return f34194e;
            }
            if (i11 < i10) {
                c[] cVarArr3 = new c[i11];
                System.arraycopy(cVarArr2, 0, cVarArr3, 0, i11);
                cVarArr2 = cVarArr3;
            }
            return new b(this.f34195a, cVarArr2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: SubjectSubscriptionManager.java */
    /* loaded from: classes3.dex */
    public static final class c<T> implements rx.d<T> {

        /* renamed from: a  reason: collision with root package name */
        final i<? super T> f34197a;

        /* renamed from: b  reason: collision with root package name */
        boolean f34198b = true;

        /* renamed from: c  reason: collision with root package name */
        boolean f34199c;

        /* renamed from: d  reason: collision with root package name */
        List<Object> f34200d;

        /* renamed from: e  reason: collision with root package name */
        boolean f34201e;

        public c(i<? super T> iVar) {
            this.f34197a = iVar;
        }

        void b(Object obj) {
            if (obj != null) {
                rx.internal.operators.d.a(this.f34197a, obj);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c(Object obj) {
            synchronized (this) {
                if (this.f34198b && !this.f34199c) {
                    boolean z10 = false;
                    this.f34198b = false;
                    if (obj != null) {
                        z10 = true;
                    }
                    this.f34199c = z10;
                    if (obj != null) {
                        d(null, obj);
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0038  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void d(List<Object> list, Object obj) {
            boolean z10 = true;
            boolean z11 = true;
            while (true) {
                if (list != null) {
                    try {
                        for (Object obj2 : list) {
                            b(obj2);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z10 = false;
                        if (!z10) {
                        }
                        throw th;
                    }
                }
                if (z11) {
                    b(obj);
                    z11 = false;
                }
                try {
                    synchronized (this) {
                        try {
                            list = this.f34200d;
                            this.f34200d = null;
                            if (list == null) {
                                this.f34199c = false;
                                return;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            z10 = false;
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                th = th4;
                                if (!z10) {
                                    synchronized (this) {
                                        this.f34199c = false;
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void e(Object obj) {
            if (!this.f34201e) {
                synchronized (this) {
                    this.f34198b = false;
                    if (this.f34199c) {
                        if (this.f34200d == null) {
                            this.f34200d = new ArrayList();
                        }
                        this.f34200d.add(obj);
                        return;
                    }
                    this.f34201e = true;
                }
            }
            rx.internal.operators.d.a(this.f34197a, obj);
        }

        @Override // rx.d
        public void onCompleted() {
            this.f34197a.onCompleted();
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            this.f34197a.onError(th2);
        }

        @Override // rx.d
        public void onNext(T t10) {
            this.f34197a.onNext(t10);
        }
    }

    public e() {
        super(b.f34194e);
    }

    boolean a(c<T> cVar) {
        b<T> bVar;
        do {
            bVar = get();
            if (bVar.f34195a) {
                this.onTerminated.call(cVar);
                return false;
            }
        } while (!compareAndSet(bVar, bVar.a(cVar)));
        this.onAdded.call(cVar);
        return true;
    }

    void b(i<? super T> iVar, c<T> cVar) {
        iVar.add(dq.e.a(new a(cVar)));
    }

    /* renamed from: c */
    public void call(i<? super T> iVar) {
        c<T> cVar = new c<>(iVar);
        b(iVar, cVar);
        this.onStart.call(cVar);
        if (!iVar.isUnsubscribed() && a(cVar) && iVar.isUnsubscribed()) {
            i(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object d() {
        return this.latest;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c<T>[] g(Object obj) {
        j(obj);
        return get().f34196b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c<T>[] h() {
        return get().f34196b;
    }

    void i(c<T> cVar) {
        b<T> bVar;
        b<T> b10;
        do {
            bVar = get();
            if (bVar.f34195a || (b10 = bVar.b(cVar)) == bVar) {
                return;
            }
        } while (!compareAndSet(bVar, b10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Object obj) {
        this.latest = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c<T>[] k(Object obj) {
        j(obj);
        this.active = false;
        if (get().f34195a) {
            return b.f34192c;
        }
        return getAndSet(b.f34193d).f34196b;
    }
}
