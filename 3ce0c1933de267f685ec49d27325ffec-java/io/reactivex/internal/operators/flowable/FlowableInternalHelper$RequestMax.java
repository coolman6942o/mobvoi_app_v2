package io.reactivex.internal.operators.flowable;

import vp.c;
import zn.g;
/* loaded from: classes2.dex */
public enum FlowableInternalHelper$RequestMax implements g<c> {
    INSTANCE;

    public void accept(c cVar) throws Exception {
        cVar.request(Long.MAX_VALUE);
    }
}
