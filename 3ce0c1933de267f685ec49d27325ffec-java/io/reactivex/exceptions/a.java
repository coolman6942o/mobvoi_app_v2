package io.reactivex.exceptions;

import io.reactivex.internal.util.f;
/* compiled from: Exceptions.java */
/* loaded from: classes2.dex */
public final class a {
    public static RuntimeException a(Throwable th2) {
        throw f.d(th2);
    }

    public static void b(Throwable th2) {
        if (th2 instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th2);
        } else if (th2 instanceof ThreadDeath) {
            throw ((ThreadDeath) th2);
        } else if (th2 instanceof LinkageError) {
            throw ((LinkageError) th2);
        }
    }
}
