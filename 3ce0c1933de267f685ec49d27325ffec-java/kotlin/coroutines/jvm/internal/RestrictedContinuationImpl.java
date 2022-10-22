package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
/* compiled from: ContinuationImpl.kt */
/* loaded from: classes3.dex */
public abstract class RestrictedContinuationImpl extends BaseContinuationImpl {
    public RestrictedContinuationImpl(c<Object> cVar) {
        super(cVar);
        if (cVar != null) {
            if (!(cVar.getContext() == EmptyCoroutineContext.INSTANCE)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.c
    public f getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
