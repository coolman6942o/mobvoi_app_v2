package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.n1;
/* compiled from: Lifecycle.kt */
/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends l implements n {

    /* renamed from: a  reason: collision with root package name */
    private final Lifecycle f3246a;

    /* renamed from: b  reason: collision with root package name */
    private final f f3247b;

    @Override // androidx.lifecycle.n
    public void c(p source, Lifecycle.Event event) {
        i.f(source, "source");
        i.f(event, "event");
        if (d().b().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            d().c(this);
            n1.d(getCoroutineContext(), null, 1, null);
        }
    }

    public Lifecycle d() {
        return this.f3246a;
    }

    @Override // kotlinx.coroutines.l0
    public f getCoroutineContext() {
        return this.f3247b;
    }
}
