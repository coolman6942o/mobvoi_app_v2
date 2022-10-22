package com.cardiex.arty.lite.networking;

import com.cardiex.arty.lite.models.coach.Advice;
import com.huawei.agconnect.exception.AGCServerException;
import io.h;
import io.m;
import java.util.Date;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.l0;
import qo.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ApiRepository.kt */
@d(c = "com.cardiex.arty.lite.networking.ApiRepository$markAdviceSeen$3", f = "ApiRepository.kt", l = {397, AGCServerException.AUTHENTICATION_INVALID}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ApiRepository$markAdviceSeen$3 extends SuspendLambda implements p<l0, c<? super m>, Object> {
    final /* synthetic */ ApiResultCallback<Advice[]> $callback;
    final /* synthetic */ Date $dateToConsider;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ApiRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ApiRepository$markAdviceSeen$3(ApiRepository apiRepository, Date date, ApiResultCallback<? super Advice[]> apiResultCallback, c<? super ApiRepository$markAdviceSeen$3> cVar) {
        super(2, cVar);
        this.this$0 = apiRepository;
        this.$dateToConsider = date;
        this.$callback = apiResultCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<m> create(Object obj, c<?> cVar) {
        ApiRepository$markAdviceSeen$3 apiRepository$markAdviceSeen$3 = new ApiRepository$markAdviceSeen$3(this.this$0, this.$dateToConsider, this.$callback, cVar);
        apiRepository$markAdviceSeen$3.L$0 = obj;
        return apiRepository$markAdviceSeen$3;
    }

    public final Object invoke(l0 l0Var, c<? super m> cVar) {
        return ((ApiRepository$markAdviceSeen$3) create(l0Var, cVar)).invokeSuspend(m.f28349a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d10;
        Object obj2;
        d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            h.b(obj);
            l0 l0Var = (l0) this.L$0;
            ApiRepository apiRepository = this.this$0;
            Date date = this.$dateToConsider;
            try {
                Result.a aVar = Result.Companion;
                obj2 = Result.m28constructorimpl(apiRepository.getApiClient().markAdviceSeen(date));
            } catch (Throwable th2) {
                Result.a aVar2 = Result.Companion;
                obj2 = Result.m28constructorimpl(h.a(th2));
            }
            ApiRepository apiRepository2 = this.this$0;
            ApiResultCallback<Advice[]> apiResultCallback = this.$callback;
            Throwable th3 = Result.m31exceptionOrNullimpl(obj2);
            if (th3 == null) {
                this.label = 1;
                if (apiRepository2.handleResponse((software.tingle.api.d) obj2, apiResultCallback, this) == d10) {
                    return d10;
                }
            } else {
                this.label = 2;
                if (apiRepository2.dispatchError(th3, apiResultCallback, this) == d10) {
                    return d10;
                }
            }
        } else if (i10 == 1 || i10 == 2) {
            h.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return m.f28349a;
    }
}
