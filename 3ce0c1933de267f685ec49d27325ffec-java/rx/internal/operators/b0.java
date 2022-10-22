package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.c;
import rx.e;
import rx.i;
/* compiled from: OperatorOnBackpressureDrop.java */
/* loaded from: classes3.dex */
public class b0<T> implements c.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final yp.b<? super T> f33730a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnBackpressureDrop.java */
    /* loaded from: classes3.dex */
    public class a implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicLong f33731a;

        a(b0 b0Var, AtomicLong atomicLong) {
            this.f33731a = atomicLong;
        }

        @Override // rx.e
        public void request(long j10) {
            rx.internal.operators.a.b(this.f33731a, j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnBackpressureDrop.java */
    /* loaded from: classes3.dex */
    public class b extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        boolean f33732a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f33733b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicLong f33734c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(i iVar, i iVar2, AtomicLong atomicLong) {
            super(iVar);
            this.f33733b = iVar2;
            this.f33734c = atomicLong;
        }

        @Override // rx.d
        public void onCompleted() {
            if (!this.f33732a) {
                this.f33732a = true;
                this.f33733b.onCompleted();
            }
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            if (!this.f33732a) {
                this.f33732a = true;
                this.f33733b.onError(th2);
                return;
            }
            bq.c.i(th2);
        }

        @Override // rx.d
        public void onNext(T t10) {
            if (!this.f33732a) {
                if (this.f33734c.get() > 0) {
                    this.f33733b.onNext(t10);
                    this.f33734c.decrementAndGet();
                    return;
                }
                yp.b<? super T> bVar = b0.this.f33730a;
                if (bVar != null) {
                    try {
                        bVar.call(t10);
                    } catch (Throwable th2) {
                        rx.exceptions.a.g(th2, this, t10);
                    }
                }
            }
        }

        @Override // rx.i
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnBackpressureDrop.java */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        static final b0<Object> f33736a = new b0<>();
    }

    b0() {
        this(null);
    }

    public static <T> b0<T> b() {
        return (b0<T>) c.f33736a;
    }

    /* renamed from: a */
    public i<? super T> call(i<? super T> iVar) {
        AtomicLong atomicLong = new AtomicLong();
        iVar.setProducer(new a(this, atomicLong));
        return new b(iVar, iVar, atomicLong);
    }

    public b0(yp.b<? super T> bVar) {
        this.f33730a = bVar;
    }
}
