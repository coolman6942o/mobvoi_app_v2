package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import com.google.common.util.concurrent.j;
import io.h;
import io.m;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.g0;
import kotlinx.coroutines.j1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.t0;
import kotlinx.coroutines.y;
import qo.p;
/* compiled from: CoroutineWorker.kt */
/* loaded from: classes.dex */
public abstract class CoroutineWorker extends ListenableWorker {

    /* renamed from: f  reason: collision with root package name */
    private final y f4667f;

    /* renamed from: g  reason: collision with root package name */
    private final androidx.work.impl.utils.futures.c<ListenableWorker.a> f4668g;

    /* renamed from: h  reason: collision with root package name */
    private final g0 f4669h = t0.a();

    /* compiled from: CoroutineWorker.kt */
    /* loaded from: classes.dex */
    static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (CoroutineWorker.this.v().isCancelled()) {
                j1.a.a(CoroutineWorker.this.w(), null, 1, null);
            }
        }
    }

    /* compiled from: CoroutineWorker.kt */
    @d(c = "androidx.work.CoroutineWorker$getForegroundInfoAsync$1", f = "CoroutineWorker.kt", l = {134}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    static final class b extends SuspendLambda implements p<l0, kotlin.coroutines.c<? super m>, Object> {
        final /* synthetic */ j<e> $jobFuture;
        Object L$0;
        int label;
        final /* synthetic */ CoroutineWorker this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(j<e> jVar, CoroutineWorker coroutineWorker, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.$jobFuture = jVar;
            this.this$0 = coroutineWorker;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new b(this.$jobFuture, this.this$0, cVar);
        }

        public final Object invoke(l0 l0Var, kotlin.coroutines.c<? super m> cVar) {
            return ((b) create(l0Var, cVar)).invokeSuspend(m.f28349a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d10;
            j<e> jVar;
            d10 = kotlin.coroutines.intrinsics.b.d();
            int i10 = this.label;
            if (i10 == 0) {
                h.b(obj);
                j<e> jVar2 = this.$jobFuture;
                CoroutineWorker coroutineWorker = this.this$0;
                this.L$0 = jVar2;
                this.label = 1;
                Object t10 = coroutineWorker.t(this);
                if (t10 == d10) {
                    return d10;
                }
                jVar = jVar2;
                obj = t10;
            } else if (i10 == 1) {
                jVar = (j) this.L$0;
                h.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jVar.c(obj);
            return m.f28349a;
        }
    }

    /* compiled from: CoroutineWorker.kt */
    @d(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", l = {68}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    static final class c extends SuspendLambda implements p<l0, kotlin.coroutines.c<? super m>, Object> {
        int label;

        c(kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new c(cVar);
        }

        public final Object invoke(l0 l0Var, kotlin.coroutines.c<? super m> cVar) {
            return ((c) create(l0Var, cVar)).invokeSuspend(m.f28349a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d10;
            d10 = kotlin.coroutines.intrinsics.b.d();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    h.b(obj);
                    CoroutineWorker coroutineWorker = CoroutineWorker.this;
                    this.label = 1;
                    obj = coroutineWorker.r(this);
                    if (obj == d10) {
                        return d10;
                    }
                } else if (i10 == 1) {
                    h.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                CoroutineWorker.this.v().p((ListenableWorker.a) obj);
            } catch (Throwable th2) {
                CoroutineWorker.this.v().q(th2);
            }
            return m.f28349a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context appContext, WorkerParameters params) {
        super(appContext, params);
        y b10;
        i.f(appContext, "appContext");
        i.f(params, "params");
        b10 = n1.b(null, 1, null);
        this.f4667f = b10;
        androidx.work.impl.utils.futures.c<ListenableWorker.a> t10 = androidx.work.impl.utils.futures.c.t();
        i.e(t10, "create()");
        this.f4668g = t10;
        t10.a(new a(), h().c());
    }

    static /* synthetic */ Object u(CoroutineWorker coroutineWorker, kotlin.coroutines.c cVar) {
        throw new IllegalStateException("Not implemented");
    }

    @Override // androidx.work.ListenableWorker
    public final j<e> d() {
        y b10;
        b10 = n1.b(null, 1, null);
        l0 a10 = m0.a(s().plus(b10));
        j jVar = new j(b10, null, 2, null);
        kotlinx.coroutines.j.b(a10, null, null, new b(jVar, this, null), 3, null);
        return jVar;
    }

    @Override // androidx.work.ListenableWorker
    public final void m() {
        super.m();
        this.f4668g.cancel(false);
    }

    @Override // androidx.work.ListenableWorker
    public final j<ListenableWorker.a> p() {
        kotlinx.coroutines.j.b(m0.a(s().plus(this.f4667f)), null, null, new c(null), 3, null);
        return this.f4668g;
    }

    public abstract Object r(kotlin.coroutines.c<? super ListenableWorker.a> cVar);

    public g0 s() {
        return this.f4669h;
    }

    public Object t(kotlin.coroutines.c<? super e> cVar) {
        return u(this, cVar);
    }

    public final androidx.work.impl.utils.futures.c<ListenableWorker.a> v() {
        return this.f4668g;
    }

    public final y w() {
        return this.f4667f;
    }
}
