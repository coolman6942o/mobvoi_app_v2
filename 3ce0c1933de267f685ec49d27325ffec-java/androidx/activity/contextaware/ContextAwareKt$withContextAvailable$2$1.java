package androidx.activity.contextaware;

import io.m;
import kotlin.jvm.internal.Lambda;
import qo.l;
/* compiled from: ContextAware.kt */
/* loaded from: classes.dex */
public final class ContextAwareKt$withContextAvailable$2$1 extends Lambda implements l<Throwable, m> {
    final /* synthetic */ c $listener;
    final /* synthetic */ a $this_withContextAvailable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextAwareKt$withContextAvailable$2$1(a aVar, c cVar) {
        super(1);
        this.$this_withContextAvailable = aVar;
    }

    @Override // qo.l
    public /* bridge */ /* synthetic */ m invoke(Throwable th2) {
        invoke2(th2);
        return m.f28349a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th2) {
        this.$this_withContextAvailable.removeOnContextAvailableListener(this.$listener);
    }
}
