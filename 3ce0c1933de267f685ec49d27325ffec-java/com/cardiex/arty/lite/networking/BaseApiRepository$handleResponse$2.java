package com.cardiex.arty.lite.networking;

import com.cardiex.arty.lite.exceptions.APIException;
import io.h;
import io.m;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.l0;
import qo.p;
/* compiled from: BaseApiRepository.kt */
@d(c = "com.cardiex.arty.lite.networking.BaseApiRepository$handleResponse$2", f = "BaseApiRepository.kt", l = {45}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class BaseApiRepository$handleResponse$2 extends SuspendLambda implements p<l0, c<? super m>, Object> {
    final /* synthetic */ ApiResultCallback<TResource> $callbacks;
    final /* synthetic */ software.tingle.api.d<TResource> $response;
    int label;
    final /* synthetic */ BaseApiRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseApiRepository$handleResponse$2(software.tingle.api.d<TResource> dVar, ApiResultCallback<? super TResource> apiResultCallback, BaseApiRepository baseApiRepository, c<? super BaseApiRepository$handleResponse$2> cVar) {
        super(2, cVar);
        this.$response = dVar;
        this.$callbacks = apiResultCallback;
        this.this$0 = baseApiRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<m> create(Object obj, c<?> cVar) {
        return new BaseApiRepository$handleResponse$2(this.$response, this.$callbacks, this.this$0, cVar);
    }

    public final Object invoke(l0 l0Var, c<? super m> cVar) {
        return ((BaseApiRepository$handleResponse$2) create(l0Var, cVar)).invokeSuspend(m.f28349a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d10;
        d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            h.b(obj);
            software.tingle.api.b bVar = this.$response;
            if (bVar == null || !bVar.d() || this.$response.b() == null) {
                software.tingle.api.b bVar2 = this.$response;
                software.tingle.api.c cVar = bVar2 == null ? null : (software.tingle.api.c) bVar2.a();
                software.tingle.api.b bVar3 = this.$response;
                Throwable aPIException = new APIException(cVar, bVar3 == null ? null : a.b(bVar3.c()), null, null, null, 28, null);
                BaseApiRepository baseApiRepository = this.this$0;
                ApiResultCallback<TResource> apiResultCallback = this.$callbacks;
                this.label = 1;
                if (baseApiRepository.dispatchError(aPIException, apiResultCallback, this) == d10) {
                    return d10;
                }
            } else {
                ApiResultCallback<TResource> apiResultCallback2 = this.$callbacks;
                Object b10 = this.$response.b();
                i.d(b10);
                apiResultCallback2.onSuccess(b10);
                return m.f28349a;
            }
        } else if (i10 == 1) {
            h.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return m.f28349a;
    }
}
