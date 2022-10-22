package kotlin.coroutines;

import io.m;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.i;
import qo.l;
import qo.p;
/* compiled from: Continuation.kt */
/* loaded from: classes3.dex */
public final class e {
    public static final <T> void a(l<? super c<? super T>, ? extends Object> startCoroutine, c<? super T> completion) {
        c<m> a10;
        c c10;
        i.f(startCoroutine, "$this$startCoroutine");
        i.f(completion, "completion");
        a10 = IntrinsicsKt__IntrinsicsJvmKt.a(startCoroutine, completion);
        c10 = IntrinsicsKt__IntrinsicsJvmKt.c(a10);
        m mVar = m.f28349a;
        Result.a aVar = Result.Companion;
        c10.resumeWith(Result.m28constructorimpl(mVar));
    }

    public static final <R, T> void b(p<? super R, ? super c<? super T>, ? extends Object> startCoroutine, R r10, c<? super T> completion) {
        c<m> b10;
        c c10;
        i.f(startCoroutine, "$this$startCoroutine");
        i.f(completion, "completion");
        b10 = IntrinsicsKt__IntrinsicsJvmKt.b(startCoroutine, r10, completion);
        c10 = IntrinsicsKt__IntrinsicsJvmKt.c(b10);
        m mVar = m.f28349a;
        Result.a aVar = Result.Companion;
        c10.resumeWith(Result.m28constructorimpl(mVar));
    }
}
