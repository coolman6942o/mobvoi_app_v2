package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.coroutines.f;
import kotlin.jvm.internal.i;
/* compiled from: ContinuationImpl.kt */
/* loaded from: classes3.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final f _context;
    private transient c<Object> intercepted;

    public ContinuationImpl(c<Object> cVar, f fVar) {
        super(cVar);
        this._context = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.c
    public f getContext() {
        f fVar = this._context;
        i.d(fVar);
        return fVar;
    }

    public final c<Object> intercepted() {
        c<Object> cVar = this.intercepted;
        if (cVar == null) {
            d dVar = (d) getContext().get(d.f30064e0);
            if (dVar == null || (cVar = dVar.h(this)) == null) {
                cVar = this;
            }
            this.intercepted = cVar;
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        c<?> cVar = this.intercepted;
        if (!(cVar == null || cVar == this)) {
            f.b bVar = getContext().get(d.f30064e0);
            i.d(bVar);
            ((d) bVar).d(cVar);
        }
        this.intercepted = b.f30066a;
    }

    public ContinuationImpl(c<Object> cVar) {
        this(cVar, cVar != null ? cVar.getContext() : null);
    }
}
