package io.reactivex.internal.disposables;

import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
import zn.f;
/* loaded from: classes.dex */
public final class CancellableDisposable extends AtomicReference<f> implements b {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(f fVar) {
        super(fVar);
    }

    @Override // xn.b
    public void dispose() {
        f andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e10) {
                a.b(e10);
                fo.a.s(e10);
            }
        }
    }

    @Override // xn.b
    public boolean isDisposed() {
        return get() == null;
    }
}
