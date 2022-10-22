package io.reactivex.internal.operators.mixed;

import io.reactivex.b;
import io.reactivex.c;
import io.reactivex.exceptions.a;
import io.reactivex.i;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.r;
import io.reactivex.v;
import java.util.concurrent.Callable;
import zn.o;
/* compiled from: ScalarXMapZHelper.java */
/* loaded from: classes2.dex */
final class g {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> boolean a(Object obj, o<? super T, ? extends c> oVar, b bVar) {
        if (!(obj instanceof Callable)) {
            return false;
        }
        c cVar = null;
        try {
            Object obj2 = (Object) ((Callable) obj).call();
            if (obj2 != 0) {
                cVar = (c) bo.b.e(oVar.apply(obj2), "The mapper returned a null CompletableSource");
            }
            if (cVar == null) {
                EmptyDisposable.complete(bVar);
            } else {
                cVar.b(bVar);
            }
            return true;
        } catch (Throwable th2) {
            a.b(th2);
            EmptyDisposable.error(th2, bVar);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, R> boolean b(Object obj, o<? super T, ? extends i<? extends R>> oVar, r<? super R> rVar) {
        if (!(obj instanceof Callable)) {
            return false;
        }
        i iVar = null;
        try {
            Object obj2 = (Object) ((Callable) obj).call();
            if (obj2 != 0) {
                iVar = (i) bo.b.e(oVar.apply(obj2), "The mapper returned a null MaybeSource");
            }
            if (iVar == null) {
                EmptyDisposable.complete(rVar);
            } else {
                iVar.b(io.reactivex.internal.operators.maybe.b.b(rVar));
            }
            return true;
        } catch (Throwable th2) {
            a.b(th2);
            EmptyDisposable.error(th2, rVar);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, R> boolean c(Object obj, o<? super T, ? extends v<? extends R>> oVar, r<? super R> rVar) {
        if (!(obj instanceof Callable)) {
            return false;
        }
        v vVar = null;
        try {
            Object obj2 = (Object) ((Callable) obj).call();
            if (obj2 != 0) {
                vVar = (v) bo.b.e(oVar.apply(obj2), "The mapper returned a null SingleSource");
            }
            if (vVar == null) {
                EmptyDisposable.complete(rVar);
            } else {
                vVar.b(io.reactivex.internal.operators.single.b.b(rVar));
            }
            return true;
        } catch (Throwable th2) {
            a.b(th2);
            EmptyDisposable.error(th2, rVar);
            return true;
        }
    }
}
