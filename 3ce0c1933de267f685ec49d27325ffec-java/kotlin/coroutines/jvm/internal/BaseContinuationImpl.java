package kotlin.coroutines.jvm.internal;

import io.h;
import io.m;
import java.io.Serializable;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.i;
/* compiled from: ContinuationImpl.kt */
/* loaded from: classes3.dex */
public abstract class BaseContinuationImpl implements c<Object>, c, Serializable {
    private final c<Object> completion;

    public BaseContinuationImpl(c<Object> cVar) {
        this.completion = cVar;
    }

    public c<m> create(c<?> completion) {
        i.f(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // kotlin.coroutines.jvm.internal.c
    public c getCallerFrame() {
        c<Object> cVar = this.completion;
        if (!(cVar instanceof c)) {
            cVar = null;
        }
        return (c) cVar;
    }

    public final c<Object> getCompletion() {
        return this.completion;
    }

    @Override // kotlin.coroutines.c
    public abstract /* synthetic */ f getContext();

    @Override // kotlin.coroutines.jvm.internal.c
    public StackTraceElement getStackTraceElement() {
        return e.d(this);
    }

    protected abstract Object invokeSuspend(Object obj);

    protected void releaseIntercepted() {
    }

    @Override // kotlin.coroutines.c
    public final void resumeWith(Object obj) {
        Object invokeSuspend;
        Object d10;
        BaseContinuationImpl baseContinuationImpl = this;
        while (true) {
            f.b(baseContinuationImpl);
            c<Object> cVar = baseContinuationImpl.completion;
            i.d(cVar);
            try {
                invokeSuspend = baseContinuationImpl.invokeSuspend(obj);
                d10 = b.d();
            } catch (Throwable th2) {
                Result.a aVar = Result.Companion;
                obj = Result.m28constructorimpl(h.a(th2));
            }
            if (invokeSuspend != d10) {
                Result.a aVar2 = Result.Companion;
                obj = Result.m28constructorimpl(invokeSuspend);
                baseContinuationImpl.releaseIntercepted();
                if (cVar instanceof BaseContinuationImpl) {
                    baseContinuationImpl = (BaseContinuationImpl) cVar;
                } else {
                    cVar.resumeWith(obj);
                    return;
                }
            } else {
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb2.append(stackTraceElement);
        return sb2.toString();
    }

    public c<m> create(Object obj, c<?> completion) {
        i.f(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
