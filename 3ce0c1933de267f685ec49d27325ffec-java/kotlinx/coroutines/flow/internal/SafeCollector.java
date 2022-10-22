package kotlinx.coroutines.flow.internal;

import io.m;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.m1;
import qo.p;
import qo.q;
/* compiled from: SafeCollector.kt */
/* loaded from: classes3.dex */
public final class SafeCollector<T> extends ContinuationImpl implements c<T> {
    public final f collectContext;
    public final int collectContextSize;
    public final c<T> collector;
    private kotlin.coroutines.c<? super m> completion;
    private f lastEmissionContext;

    /* compiled from: SafeCollector.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements p<Integer, f.b, Integer> {
        public static final a INSTANCE = new a();

        a() {
            super(2);
        }

        public final int a(int i10, f.b bVar) {
            return i10 + 1;
        }

        @Override // qo.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, f.b bVar) {
            return Integer.valueOf(a(num.intValue(), bVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(c<? super T> cVar, f fVar) {
        super(f.f30181a, EmptyCoroutineContext.INSTANCE);
        this.collector = cVar;
        this.collectContext = fVar;
        this.collectContextSize = ((Number) fVar.fold(0, a.INSTANCE)).intValue();
    }

    private final void c(f fVar, f fVar2, T t10) {
        if (fVar2 instanceof c) {
            h((c) fVar2, t10);
        }
        i.a(this, fVar);
        this.lastEmissionContext = fVar;
    }

    private final Object d(kotlin.coroutines.c<? super m> cVar, T t10) {
        q qVar;
        f context = cVar.getContext();
        m1.e(context);
        f fVar = this.lastEmissionContext;
        if (fVar != context) {
            c(context, fVar, t10);
        }
        this.completion = cVar;
        qVar = h.f30184a;
        return qVar.invoke(this.collector, t10, this);
    }

    private final void h(c cVar, Object obj) {
        String f10;
        f10 = kotlin.text.m.f("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + cVar.f30179a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
        throw new IllegalStateException(f10.toString());
    }

    @Override // kotlinx.coroutines.flow.c
    public Object emit(T t10, kotlin.coroutines.c<? super m> cVar) {
        Object d10;
        Object d11;
        try {
            Object d12 = d(cVar, t10);
            d10 = b.d();
            if (d12 == d10) {
                kotlin.coroutines.jvm.internal.f.c(cVar);
            }
            d11 = b.d();
            return d12 == d11 ? d12 : m.f28349a;
        } catch (Throwable th2) {
            this.lastEmissionContext = new c(th2);
            throw th2;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.c
    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        kotlin.coroutines.c<? super m> cVar = this.completion;
        if (cVar instanceof kotlin.coroutines.jvm.internal.c) {
            return (kotlin.coroutines.jvm.internal.c) cVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.c
    public f getContext() {
        kotlin.coroutines.c<? super m> cVar = this.completion;
        f context = cVar == null ? null : cVar.getContext();
        return context == null ? EmptyCoroutineContext.INSTANCE : context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.c
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public Object invokeSuspend(Object obj) {
        Object d10;
        Throwable th2 = Result.m31exceptionOrNullimpl(obj);
        if (th2 != null) {
            this.lastEmissionContext = new c(th2);
        }
        kotlin.coroutines.c<? super m> cVar = this.completion;
        if (cVar != null) {
            cVar.resumeWith(obj);
        }
        d10 = b.d();
        return d10;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
