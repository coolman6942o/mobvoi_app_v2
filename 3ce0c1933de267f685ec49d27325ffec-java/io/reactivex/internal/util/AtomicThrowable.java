package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean addThrowable(Throwable th2) {
        return f.a(this, th2);
    }

    public boolean isTerminated() {
        return get() == f.f29256a;
    }

    public Throwable terminate() {
        return f.b(this);
    }
}
