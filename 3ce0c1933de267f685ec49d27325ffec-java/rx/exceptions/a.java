package rx.exceptions;

import java.util.HashSet;
import java.util.List;
import rx.d;
/* compiled from: Exceptions.java */
/* loaded from: classes3.dex */
public final class a {
    public static void a(Throwable th2, Throwable th3) {
        HashSet hashSet = new HashSet();
        int i10 = 0;
        while (th2.getCause() != null) {
            i10++;
            if (i10 < 25) {
                th2 = th2.getCause();
                if (!hashSet.contains(th2.getCause())) {
                    hashSet.add(th2.getCause());
                }
            } else {
                return;
            }
        }
        try {
            th2.initCause(th3);
        } catch (Throwable unused) {
        }
    }

    public static Throwable b(Throwable th2) {
        int i10 = 0;
        while (th2.getCause() != null) {
            i10++;
            if (i10 >= 25) {
                return new RuntimeException("Stack too deep to get final cause");
            }
            th2 = th2.getCause();
        }
        return th2;
    }

    public static RuntimeException c(Throwable th2) {
        if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        } else if (th2 instanceof Error) {
            throw ((Error) th2);
        } else {
            throw new RuntimeException(th2);
        }
    }

    public static void d(List<? extends Throwable> list) {
        if (list != null && !list.isEmpty()) {
            if (list.size() == 1) {
                Throwable th2 = list.get(0);
                if (th2 instanceof RuntimeException) {
                    throw ((RuntimeException) th2);
                } else if (th2 instanceof Error) {
                    throw ((Error) th2);
                } else {
                    throw new RuntimeException(th2);
                }
            } else {
                throw new CompositeException(list);
            }
        }
    }

    public static void e(Throwable th2) {
        if (th2 instanceof OnErrorNotImplementedException) {
            throw ((OnErrorNotImplementedException) th2);
        } else if (th2 instanceof OnErrorFailedException) {
            throw ((OnErrorFailedException) th2);
        } else if (th2 instanceof OnCompletedFailedException) {
            throw ((OnCompletedFailedException) th2);
        } else if (th2 instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th2);
        } else if (th2 instanceof ThreadDeath) {
            throw ((ThreadDeath) th2);
        } else if (th2 instanceof LinkageError) {
            throw ((LinkageError) th2);
        }
    }

    public static void f(Throwable th2, d<?> dVar) {
        e(th2);
        dVar.onError(th2);
    }

    public static void g(Throwable th2, d<?> dVar, Object obj) {
        e(th2);
        dVar.onError(OnErrorThrowable.addValueAsLastCause(th2, obj));
    }
}
