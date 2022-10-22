package androidx.lifecycle;

import kotlin.jvm.internal.Lambda;
import qo.a;
/* compiled from: WithLifecycleState.kt */
/* loaded from: classes.dex */
public final class WithLifecycleStateKt$withStateAtLeastUnchecked$2 extends Lambda implements a<Object> {
    final /* synthetic */ a $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WithLifecycleStateKt$withStateAtLeastUnchecked$2(a aVar) {
        super(0);
        this.$block = aVar;
    }

    @Override // qo.a
    public final Object invoke() {
        return this.$block.invoke();
    }
}
