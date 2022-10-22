package com.cardiex.arty.lite.networking;

import com.cardiex.arty.lite.exceptions.ArtyException;
import io.h;
import io.m;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.l0;
import qo.p;
/* compiled from: BaseApiRepository.kt */
@d(c = "com.cardiex.arty.lite.networking.BaseApiRepository$dispatchError$2", f = "BaseApiRepository.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class BaseApiRepository$dispatchError$2 extends SuspendLambda implements p<l0, c<? super m>, Object> {
    final /* synthetic */ ApiResultCallback<?> $callback;
    final /* synthetic */ Throwable $throwable;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseApiRepository$dispatchError$2(ApiResultCallback<?> apiResultCallback, Throwable th2, c<? super BaseApiRepository$dispatchError$2> cVar) {
        super(2, cVar);
        this.$callback = apiResultCallback;
        this.$throwable = th2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<m> create(Object obj, c<?> cVar) {
        return new BaseApiRepository$dispatchError$2(this.$callback, this.$throwable, cVar);
    }

    public final Object invoke(l0 l0Var, c<? super m> cVar) {
        return ((BaseApiRepository$dispatchError$2) create(l0Var, cVar)).invokeSuspend(m.f28349a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b.d();
        if (this.label == 0) {
            h.b(obj);
            this.$callback.onError(ArtyException.Companion.create(this.$throwable));
            return m.f28349a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
