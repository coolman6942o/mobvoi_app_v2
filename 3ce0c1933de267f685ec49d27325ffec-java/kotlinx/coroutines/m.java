package kotlinx.coroutines;

import kotlin.coroutines.c;
import qo.l;
/* compiled from: CancellableContinuation.kt */
/* loaded from: classes3.dex */
public interface m<T> extends c<T> {
    Object a(T t10, Object obj);

    Object b(T t10, Object obj, l<? super Throwable, io.m> lVar);

    void g(T t10, l<? super Throwable, io.m> lVar);

    void j(l<? super Throwable, io.m> lVar);

    void k(Object obj);
}
