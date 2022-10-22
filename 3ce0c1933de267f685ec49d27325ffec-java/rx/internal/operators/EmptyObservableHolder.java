package rx.internal.operators;

import rx.c;
import rx.i;
/* loaded from: classes3.dex */
public enum EmptyObservableHolder implements c.a<Object> {
    INSTANCE;
    
    static final c<Object> EMPTY = c.i0(INSTANCE);

    public static <T> c<T> instance() {
        return (c<T>) EMPTY;
    }

    public void call(i<? super Object> iVar) {
        iVar.onCompleted();
    }
}
