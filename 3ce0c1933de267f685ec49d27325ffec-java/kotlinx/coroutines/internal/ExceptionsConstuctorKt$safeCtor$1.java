package kotlinx.coroutines.internal;

import io.h;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;
import qo.l;
/* compiled from: ExceptionsConstuctor.kt */
/* loaded from: classes3.dex */
public final class ExceptionsConstuctorKt$safeCtor$1 extends Lambda implements l<Throwable, Throwable> {
    final /* synthetic */ l<Throwable, Throwable> $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ExceptionsConstuctorKt$safeCtor$1(l<? super Throwable, ? extends Throwable> lVar) {
        super(1);
        this.$block = lVar;
    }

    public final Throwable invoke(Throwable th2) {
        Object obj;
        l<Throwable, Throwable> lVar = this.$block;
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m28constructorimpl(lVar.invoke(th2));
        } catch (Throwable th3) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m28constructorimpl(h.a(th3));
        }
        if (Result.m33isFailureimpl(obj)) {
            obj = null;
        }
        return (Throwable) obj;
    }
}
