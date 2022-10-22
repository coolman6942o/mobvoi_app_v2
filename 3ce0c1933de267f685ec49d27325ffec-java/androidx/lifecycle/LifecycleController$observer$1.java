package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.j1;
/* compiled from: LifecycleController.kt */
/* loaded from: classes.dex */
final class LifecycleController$observer$1 implements n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f3244a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ j1 f3245b;

    @Override // androidx.lifecycle.n
    public final void c(p source, Lifecycle.Event event) {
        i.f(source, "source");
        i.f(event, "<anonymous parameter 1>");
        Lifecycle lifecycle = source.getLifecycle();
        i.e(lifecycle, "source.lifecycle");
        if (lifecycle.b() != Lifecycle.State.DESTROYED) {
            Lifecycle lifecycle2 = source.getLifecycle();
            i.e(lifecycle2, "source.lifecycle");
            if (lifecycle2.b().compareTo(k.b(this.f3244a)) < 0) {
                k.a(this.f3244a);
                throw null;
            } else {
                k.a(this.f3244a);
                throw null;
            }
        } else {
            j1.a.a(this.f3245b, null, 1, null);
            throw null;
        }
    }
}
