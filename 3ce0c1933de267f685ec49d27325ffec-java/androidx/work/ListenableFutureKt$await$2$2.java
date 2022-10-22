package androidx.work;

import com.google.common.util.concurrent.j;
import io.m;
import kotlin.jvm.internal.Lambda;
import qo.l;
/* compiled from: ListenableFuture.kt */
/* loaded from: classes.dex */
public final class ListenableFutureKt$await$2$2 extends Lambda implements l<Throwable, m> {
    final /* synthetic */ j<Object> $this_await;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListenableFutureKt$await$2$2(j<Object> jVar) {
        super(1);
        this.$this_await = jVar;
    }

    @Override // qo.l
    public /* bridge */ /* synthetic */ m invoke(Throwable th2) {
        invoke2(th2);
        return m.f28349a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th2) {
        this.$this_await.cancel(false);
    }
}
