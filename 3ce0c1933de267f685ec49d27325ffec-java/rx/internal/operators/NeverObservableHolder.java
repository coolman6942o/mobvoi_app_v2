package rx.internal.operators;

import rx.c;
import rx.i;
/* loaded from: classes3.dex */
public enum NeverObservableHolder implements c.a<Object> {
    INSTANCE;
    
    static final c<Object> NEVER = c.i0(INSTANCE);

    public static <T> c<T> instance() {
        return (c<T>) NEVER;
    }

    public void call(i<? super Object> iVar) {
    }
}
