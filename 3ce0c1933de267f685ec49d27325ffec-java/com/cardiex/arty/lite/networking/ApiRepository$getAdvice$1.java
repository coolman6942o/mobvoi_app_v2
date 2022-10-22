package com.cardiex.arty.lite.networking;

import com.cardiex.arty.lite.models.Pageable;
import com.cardiex.arty.lite.models.coach.Advice;
import io.h;
import io.m;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.l0;
import qo.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ApiRepository.kt */
@d(c = "com.cardiex.arty.lite.networking.ApiRepository$getAdvice$1", f = "ApiRepository.kt", l = {58, 61, 64}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ApiRepository$getAdvice$1 extends SuspendLambda implements p<l0, c<? super m>, Object> {
    final /* synthetic */ ApiResultCallback<Advice[]> $callback;
    final /* synthetic */ Pageable $pageable;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ApiRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ApiRepository$getAdvice$1(ApiRepository apiRepository, Pageable pageable, ApiResultCallback<? super Advice[]> apiResultCallback, c<? super ApiRepository$getAdvice$1> cVar) {
        super(2, cVar);
        this.this$0 = apiRepository;
        this.$pageable = pageable;
        this.$callback = apiResultCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<m> create(Object obj, c<?> cVar) {
        ApiRepository$getAdvice$1 apiRepository$getAdvice$1 = new ApiRepository$getAdvice$1(this.this$0, this.$pageable, this.$callback, cVar);
        apiRepository$getAdvice$1.L$0 = obj;
        return apiRepository$getAdvice$1;
    }

    public final Object invoke(l0 l0Var, c<? super m> cVar) {
        return ((ApiRepository$getAdvice$1) create(l0Var, cVar)).invokeSuspend(m.f28349a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d10;
        Object obj2;
        d10 = b.d();
        int i10 = this.label;
        try {
        } catch (Throwable th2) {
            Result.a aVar = Result.Companion;
            obj2 = Result.m28constructorimpl(h.a(th2));
        }
        if (i10 == 0) {
            h.b(obj);
            l0 l0Var = (l0) this.L$0;
            ApiRepository apiRepository = this.this$0;
            Pageable pageable = this.$pageable;
            Result.a aVar2 = Result.Companion;
            ArtyApiClient apiClient = apiRepository.getApiClient();
            this.label = 1;
            obj = apiClient.getAdvice(pageable, this);
            if (obj == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            h.b(obj);
        } else if (i10 == 2 || i10 == 3) {
            h.b(obj);
            return m.f28349a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m28constructorimpl((software.tingle.api.d) obj);
        ApiRepository apiRepository2 = this.this$0;
        ApiResultCallback<Advice[]> apiResultCallback = this.$callback;
        Throwable th3 = Result.m31exceptionOrNullimpl(obj2);
        if (th3 == null) {
            this.label = 2;
            if (apiRepository2.handleResponse((software.tingle.api.d) obj2, apiResultCallback, this) == d10) {
                return d10;
            }
        } else {
            this.label = 3;
            if (apiRepository2.dispatchError(th3, apiResultCallback, this) == d10) {
                return d10;
            }
        }
        return m.f28349a;
    }
}
