package io.reactivex.internal.operators.maybe;

import io.reactivex.i;
import vp.a;
import zn.o;
/* loaded from: classes2.dex */
public enum MaybeToPublisher implements o<i<Object>, a<Object>> {
    INSTANCE;

    public static <T> o<i<T>, a<T>> instance() {
        return INSTANCE;
    }

    public a<Object> apply(i<Object> iVar) throws Exception {
        return new a(iVar);
    }
}
