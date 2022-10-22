package kotlinx.coroutines.internal;

import kotlinx.coroutines.o0;
/* compiled from: Atomic.kt */
/* loaded from: classes3.dex */
public abstract class s {
    public abstract c<?> a();

    public final boolean b(s sVar) {
        c<?> a10;
        c<?> a11 = a();
        return (a11 == null || (a10 = sVar.a()) == null || a11.f() >= a10.f()) ? false : true;
    }

    public abstract Object c(Object obj);

    public String toString() {
        return o0.a(this) + '@' + o0.b(this);
    }
}
