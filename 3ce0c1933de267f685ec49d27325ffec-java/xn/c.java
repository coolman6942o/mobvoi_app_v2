package xn;

import bo.b;
import io.reactivex.internal.disposables.EmptyDisposable;
/* compiled from: Disposables.java */
/* loaded from: classes2.dex */
public final class c {
    public static b a() {
        return EmptyDisposable.INSTANCE;
    }

    public static b b(Runnable runnable) {
        b.e(runnable, "run is null");
        return new e(runnable);
    }
}
