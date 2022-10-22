package com.cardiex.arty.lite.networking;

import com.cardiex.arty.lite.models.dashboard.Dashboard;
import com.huawei.hms.ml.camera.CameraConfig;
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
@d(c = "com.cardiex.arty.lite.networking.ApiRepository$getDashboard$1", f = "ApiRepository.kt", l = {174, 177, CameraConfig.CAMERA_THIRD_DEGREE}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ApiRepository$getDashboard$1 extends SuspendLambda implements p<l0, c<? super m>, Object> {
    final /* synthetic */ ApiResultCallback<Dashboard> $callback;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ApiRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ApiRepository$getDashboard$1(ApiRepository apiRepository, ApiResultCallback<? super Dashboard> apiResultCallback, c<? super ApiRepository$getDashboard$1> cVar) {
        super(2, cVar);
        this.this$0 = apiRepository;
        this.$callback = apiResultCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<m> create(Object obj, c<?> cVar) {
        ApiRepository$getDashboard$1 apiRepository$getDashboard$1 = new ApiRepository$getDashboard$1(this.this$0, this.$callback, cVar);
        apiRepository$getDashboard$1.L$0 = obj;
        return apiRepository$getDashboard$1;
    }

    public final Object invoke(l0 l0Var, c<? super m> cVar) {
        return ((ApiRepository$getDashboard$1) create(l0Var, cVar)).invokeSuspend(m.f28349a);
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
            Result.a aVar2 = Result.Companion;
            ArtyApiClient apiClient = apiRepository.getApiClient();
            this.label = 1;
            obj = apiClient.getDashboard(this);
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
        ApiResultCallback<Dashboard> apiResultCallback = this.$callback;
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
