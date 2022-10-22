package com.cardiex.arty.lite.utils;

import io.h;
import io.m;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.l0;
import qo.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtyAuthenticationHeaderProvider.kt */
@d(c = "com.cardiex.arty.lite.utils.ArtyAuthenticationHeaderProvider$jwt$response$1", f = "ArtyAuthenticationHeaderProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ArtyAuthenticationHeaderProvider$jwt$response$1 extends SuspendLambda implements p<l0, c<? super MobVoiTokenResponse>, Object> {
    int label;
    final /* synthetic */ ArtyAuthenticationHeaderProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtyAuthenticationHeaderProvider$jwt$response$1(ArtyAuthenticationHeaderProvider artyAuthenticationHeaderProvider, c<? super ArtyAuthenticationHeaderProvider$jwt$response$1> cVar) {
        super(2, cVar);
        this.this$0 = artyAuthenticationHeaderProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<m> create(Object obj, c<?> cVar) {
        return new ArtyAuthenticationHeaderProvider$jwt$response$1(this.this$0, cVar);
    }

    public final Object invoke(l0 l0Var, c<? super MobVoiTokenResponse> cVar) {
        return ((ArtyAuthenticationHeaderProvider$jwt$response$1) create(l0Var, cVar)).invokeSuspend(m.f28349a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MobVoiTokenResponse requestMobVoiToken;
        b.d();
        if (this.label == 0) {
            h.b(obj);
            requestMobVoiToken = this.this$0.getRequestMobVoiToken();
            return requestMobVoiToken;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
