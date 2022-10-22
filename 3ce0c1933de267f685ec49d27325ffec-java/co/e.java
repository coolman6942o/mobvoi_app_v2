package co;

import java.util.concurrent.Callable;
/* compiled from: ScalarCallable.java */
/* loaded from: classes2.dex */
public interface e<T> extends Callable<T> {
    @Override // java.util.concurrent.Callable
    T call();
}
