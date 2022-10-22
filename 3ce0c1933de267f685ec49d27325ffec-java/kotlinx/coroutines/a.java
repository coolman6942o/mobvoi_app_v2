package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.jvm.internal.i;
import qo.p;
/* compiled from: AbstractCoroutine.kt */
/* loaded from: classes3.dex */
public abstract class a<T> extends p1 implements j1, c<T> {

    /* renamed from: b  reason: collision with root package name */
    private final f f30114b;

    public a(f fVar, boolean z10, boolean z11) {
        super(z11);
        if (z10) {
            R((j1) fVar.get(j1.f30248g0));
        }
        this.f30114b = fVar.plus(this);
    }

    @Override // kotlinx.coroutines.p1
    public final void Q(Throwable th2) {
        i0.a(this.f30114b, th2);
    }

    @Override // kotlinx.coroutines.p1
    public String X() {
        String b10 = f0.b(this.f30114b);
        if (b10 == null) {
            return super.X();
        }
        return '\"' + b10 + "\":" + super.X();
    }

    @Override // kotlinx.coroutines.p1, kotlinx.coroutines.j1
    public boolean c() {
        return super.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.p1
    protected final void c0(Object obj) {
        if (obj instanceof a0) {
            a0 a0Var = (a0) obj;
            t0(a0Var.f30116a, a0Var.a());
            return;
        }
        u0(obj);
    }

    @Override // kotlin.coroutines.c
    public final f getContext() {
        return this.f30114b;
    }

    public f getCoroutineContext() {
        return this.f30114b;
    }

    @Override // kotlin.coroutines.c
    public final void resumeWith(Object obj) {
        Object V = V(d0.d(obj, null, 1, null));
        if (V != q1.f30277b) {
            s0(V);
        }
    }

    protected void s0(Object obj) {
        n(obj);
    }

    protected void t0(Throwable th2, boolean z10) {
    }

    protected void u0(T t10) {
    }

    public final <R> void v0(CoroutineStart coroutineStart, R r10, p<? super R, ? super c<? super T>, ? extends Object> pVar) {
        coroutineStart.invoke(pVar, r10, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.p1
    public String y() {
        return i.n(o0.a(this), " was cancelled");
    }
}
