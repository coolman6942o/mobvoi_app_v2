package rx;

import yp.e;
/* loaded from: classes3.dex */
public interface Emitter<T> extends d<T> {

    /* loaded from: classes3.dex */
    public enum BackpressureMode {
        NONE,
        ERROR,
        BUFFER,
        DROP,
        LATEST
    }

    void a(e eVar);
}
