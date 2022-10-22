package com.cardiex.arty.lite.networking;

import android.content.Context;
import io.m;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.t0;
import kotlinx.coroutines.y;
import software.tingle.api.d;
/* compiled from: BaseApiRepository.kt */
/* loaded from: classes.dex */
public abstract class BaseApiRepository implements l0 {
    private final ArtyApiClient apiClient;
    private final String baseUrl = "https://api.myarty.com/rest/v1";

    public BaseApiRepository(Context context, String accessToken, boolean z10) {
        i.f(context, "context");
        i.f(accessToken, "accessToken");
        this.apiClient = new ArtyApiClient(context, accessToken, "https://api.myarty.com/rest/v1", z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object dispatchError(Throwable th2, ApiResultCallback<?> apiResultCallback, c<? super m> cVar) {
        Object d10;
        Object d11 = h.d(t0.c(), new BaseApiRepository$dispatchError$2(apiResultCallback, th2, null), cVar);
        d10 = b.d();
        return d11 == d10 ? d11 : m.f28349a;
    }

    public final ArtyApiClient getApiClient() {
        return this.apiClient;
    }

    @Override // kotlinx.coroutines.l0
    public f getCoroutineContext() {
        y b10;
        b10 = n1.b(null, 1, null);
        return b10.plus(t0.c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <TResource> Object handleResponse(d<TResource> dVar, ApiResultCallback<? super TResource> apiResultCallback, c<? super m> cVar) {
        Object d10;
        Object d11 = h.d(t0.c(), new BaseApiRepository$handleResponse$2(dVar, apiResultCallback, this, null), cVar);
        d10 = b.d();
        return d11 == d10 ? d11 : m.f28349a;
    }
}
