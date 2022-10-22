package io.reactivex.parallel;

import zn.c;
/* loaded from: classes3.dex */
public enum ParallelFailureHandling implements c<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    public ParallelFailureHandling apply(Long l10, Throwable th2) {
        return this;
    }
}
