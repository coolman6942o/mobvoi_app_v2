package kotlinx.coroutines;

import io.m;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.u;
/* compiled from: CoroutineContext.kt */
/* loaded from: classes3.dex */
public final class c2<T> extends u<T> {

    /* renamed from: d  reason: collision with root package name */
    private f f30126d;

    /* renamed from: e  reason: collision with root package name */
    private Object f30127e;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c2(f fVar, c<? super T> cVar) {
        super(fVar.get(r0) == null ? fVar.plus(r0) : fVar, cVar);
        d2 d2Var = d2.f30166a;
    }

    @Override // kotlinx.coroutines.internal.u, kotlinx.coroutines.a
    protected void s0(Object obj) {
        f fVar = this.f30126d;
        c2<?> c2Var = null;
        if (fVar != null) {
            a0.a(fVar, this.f30127e);
            this.f30126d = null;
            this.f30127e = null;
        }
        Object a10 = d0.a(obj, this.f30242c);
        c<T> cVar = this.f30242c;
        f context = cVar.getContext();
        Object c10 = a0.c(context, null);
        if (c10 != a0.f30198a) {
            c2Var = f0.e(cVar, context, c10);
        }
        try {
            this.f30242c.resumeWith(a10);
            m mVar = m.f28349a;
        } finally {
            if (c2Var == null || c2Var.x0()) {
                a0.a(context, c10);
            }
        }
    }

    public final boolean x0() {
        if (this.f30126d == null) {
            return false;
        }
        this.f30126d = null;
        this.f30127e = null;
        return true;
    }

    public final void y0(f fVar, Object obj) {
        this.f30126d = fVar;
        this.f30127e = obj;
    }
}
