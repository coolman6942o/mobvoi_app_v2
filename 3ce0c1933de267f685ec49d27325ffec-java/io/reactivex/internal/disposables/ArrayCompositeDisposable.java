package io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicReferenceArray;
import xn.b;
/* loaded from: classes.dex */
public final class ArrayCompositeDisposable extends AtomicReferenceArray<b> implements b {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeDisposable(int i10) {
        super(i10);
    }

    @Override // xn.b
    public void dispose() {
        b andSet;
        if (get(0) != DisposableHelper.DISPOSED) {
            int length = length();
            for (int i10 = 0; i10 < length; i10++) {
                b bVar = get(i10);
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (!(bVar == disposableHelper || (andSet = getAndSet(i10, disposableHelper)) == disposableHelper || andSet == null)) {
                    andSet.dispose();
                }
            }
        }
    }

    @Override // xn.b
    public boolean isDisposed() {
        return get(0) == DisposableHelper.DISPOSED;
    }

    public b replaceResource(int i10, b bVar) {
        b bVar2;
        do {
            bVar2 = get(i10);
            if (bVar2 == DisposableHelper.DISPOSED) {
                bVar.dispose();
                return null;
            }
        } while (!compareAndSet(i10, bVar2, bVar));
        return bVar2;
    }

    public boolean setResource(int i10, b bVar) {
        b bVar2;
        do {
            bVar2 = get(i10);
            if (bVar2 == DisposableHelper.DISPOSED) {
                bVar.dispose();
                return false;
            }
        } while (!compareAndSet(i10, bVar2, bVar));
        if (bVar2 == null) {
            return true;
        }
        bVar2.dispose();
        return true;
    }
}
