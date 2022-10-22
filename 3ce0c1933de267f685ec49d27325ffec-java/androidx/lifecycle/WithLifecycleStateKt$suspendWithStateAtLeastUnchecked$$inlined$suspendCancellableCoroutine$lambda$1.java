package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import io.h;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.m;
import qo.a;
/* compiled from: WithLifecycleState.kt */
/* loaded from: classes.dex */
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1 implements n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f3275a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Lifecycle f3276b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Lifecycle.State f3277c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ a f3278d;

    @Override // androidx.lifecycle.n
    public void c(p source, Lifecycle.Event event) {
        Object obj;
        i.f(source, "source");
        i.f(event, "event");
        if (event == Lifecycle.Event.upTo(this.f3277c)) {
            this.f3276b.c(this);
            m mVar = this.f3275a;
            a aVar = this.f3278d;
            try {
                Result.a aVar2 = Result.Companion;
                obj = Result.m28constructorimpl(aVar.invoke());
            } catch (Throwable th2) {
                Result.a aVar3 = Result.Companion;
                obj = Result.m28constructorimpl(h.a(th2));
            }
            mVar.resumeWith(obj);
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            this.f3276b.c(this);
            m mVar2 = this.f3275a;
            LifecycleDestroyedException lifecycleDestroyedException = new LifecycleDestroyedException();
            Result.a aVar4 = Result.Companion;
            mVar2.resumeWith(Result.m28constructorimpl(h.a(lifecycleDestroyedException)));
        }
    }
}
