package io.reactivex.internal.util;

import fo.a;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* compiled from: EndConsumerHelper.java */
/* loaded from: classes3.dex */
public final class e {
    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void b(Class<?> cls) {
        a.s(new ProtocolViolationException(a(cls.getName())));
    }

    public static boolean c(AtomicReference<b> atomicReference, b bVar, Class<?> cls) {
        bo.b.e(bVar, "next is null");
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() == DisposableHelper.DISPOSED) {
            return false;
        }
        b(cls);
        return false;
    }

    public static boolean d(b bVar, b bVar2, Class<?> cls) {
        bo.b.e(bVar2, "next is null");
        if (bVar == null) {
            return true;
        }
        bVar2.dispose();
        if (bVar == DisposableHelper.DISPOSED) {
            return false;
        }
        b(cls);
        return false;
    }
}
