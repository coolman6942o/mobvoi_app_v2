package rx.internal.operators;

import dq.d;
import java.util.concurrent.TimeUnit;
import rx.c;
import rx.f;
import rx.i;
/* compiled from: OperatorDebounceWithTime.java */
/* loaded from: classes3.dex */
public final class w<T> implements c.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final long f33940a;

    /* renamed from: b  reason: collision with root package name */
    final TimeUnit f33941b;

    /* renamed from: c  reason: collision with root package name */
    final f f33942c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorDebounceWithTime.java */
    /* loaded from: classes3.dex */
    public class a extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        final b<T> f33943a = new b<>();

        /* renamed from: b  reason: collision with root package name */
        final i<?> f33944b = this;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f33945c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ f.a f33946d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ aq.d f33947e;

        /* compiled from: OperatorDebounceWithTime.java */
        /* renamed from: rx.internal.operators.w$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0476a implements yp.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f33949a;

            C0476a(int i10) {
                this.f33949a = i10;
            }

            @Override // yp.a
            public void call() {
                a aVar = a.this;
                aVar.f33943a.b(this.f33949a, aVar.f33947e, aVar.f33944b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(i iVar, d dVar, f.a aVar, aq.d dVar2) {
            super(iVar);
            this.f33945c = dVar;
            this.f33946d = aVar;
            this.f33947e = dVar2;
        }

        @Override // rx.d
        public void onCompleted() {
            this.f33943a.c(this.f33947e, this);
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            this.f33947e.onError(th2);
            unsubscribe();
            this.f33943a.a();
        }

        @Override // rx.d
        public void onNext(T t10) {
            int d10 = this.f33943a.d(t10);
            d dVar = this.f33945c;
            f.a aVar = this.f33946d;
            C0476a aVar2 = new C0476a(d10);
            w wVar = w.this;
            dVar.a(aVar.c(aVar2, wVar.f33940a, wVar.f33941b));
        }

        @Override // rx.i
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* compiled from: OperatorDebounceWithTime.java */
    /* loaded from: classes3.dex */
    static final class b<T> {

        /* renamed from: a  reason: collision with root package name */
        int f33951a;

        /* renamed from: b  reason: collision with root package name */
        T f33952b;

        /* renamed from: c  reason: collision with root package name */
        boolean f33953c;

        /* renamed from: d  reason: collision with root package name */
        boolean f33954d;

        /* renamed from: e  reason: collision with root package name */
        boolean f33955e;

        b() {
        }

        public synchronized void a() {
            this.f33951a++;
            this.f33952b = null;
            this.f33953c = false;
        }

        public void b(int i10, i<T> iVar, i<?> iVar2) {
            synchronized (this) {
                if (!this.f33955e && this.f33953c && i10 == this.f33951a) {
                    T t10 = this.f33952b;
                    this.f33952b = null;
                    this.f33953c = false;
                    this.f33955e = true;
                    try {
                        iVar.onNext(t10);
                        synchronized (this) {
                            if (!this.f33954d) {
                                this.f33955e = false;
                            } else {
                                iVar.onCompleted();
                            }
                        }
                    } catch (Throwable th2) {
                        rx.exceptions.a.g(th2, iVar2, t10);
                    }
                }
            }
        }

        public void c(i<T> iVar, i<?> iVar2) {
            synchronized (this) {
                if (this.f33955e) {
                    this.f33954d = true;
                    return;
                }
                T t10 = this.f33952b;
                boolean z10 = this.f33953c;
                this.f33952b = null;
                this.f33953c = false;
                this.f33955e = true;
                if (z10) {
                    try {
                        iVar.onNext(t10);
                    } catch (Throwable th2) {
                        rx.exceptions.a.g(th2, iVar2, t10);
                        return;
                    }
                }
                iVar.onCompleted();
            }
        }

        public synchronized int d(T t10) {
            int i10;
            this.f33952b = t10;
            this.f33953c = true;
            i10 = this.f33951a + 1;
            this.f33951a = i10;
            return i10;
        }
    }

    public w(long j10, TimeUnit timeUnit, f fVar) {
        this.f33940a = j10;
        this.f33941b = timeUnit;
        this.f33942c = fVar;
    }

    /* renamed from: a */
    public i<? super T> call(i<? super T> iVar) {
        f.a a10 = this.f33942c.a();
        aq.d dVar = new aq.d(iVar);
        d dVar2 = new d();
        dVar.add(a10);
        dVar.add(dVar2);
        return new a(iVar, dVar2, a10, dVar);
    }
}
