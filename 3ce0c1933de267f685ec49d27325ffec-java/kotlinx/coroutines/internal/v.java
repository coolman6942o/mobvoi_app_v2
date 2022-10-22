package kotlinx.coroutines.internal;

import io.h;
import io.j;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import kotlinx.coroutines.e0;
/* compiled from: StackTraceRecovery.kt */
/* loaded from: classes3.dex */
public final class v {

    /* renamed from: a */
    private static final String f30243a;

    static {
        Object obj;
        Object obj2;
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m28constructorimpl(Class.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl").getCanonicalName());
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m28constructorimpl(h.a(th2));
        }
        if (Result.m31exceptionOrNullimpl(obj) != null) {
            obj = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f30243a = (String) obj;
        try {
            Result.a aVar3 = Result.Companion;
            obj2 = Result.m28constructorimpl(v.class.getCanonicalName());
        } catch (Throwable th3) {
            Result.a aVar4 = Result.Companion;
            obj2 = Result.m28constructorimpl(h.a(th3));
        }
        if (Result.m31exceptionOrNullimpl(obj2) != null) {
            obj2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        String str = (String) obj2;
    }

    public static final /* synthetic */ Throwable a(Throwable th2, c cVar) {
        return j(th2, cVar);
    }

    public static final StackTraceElement b(String str) {
        return new StackTraceElement(i.n("\b\b\b(", str), "\b", "\b", -1);
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> c(E e10) {
        boolean z10;
        Throwable cause = e10.getCause();
        if (cause == null || !i.b(cause.getClass(), e10.getClass())) {
            return j.a(e10, new StackTraceElement[0]);
        }
        StackTraceElement[] stackTrace = e10.getStackTrace();
        int length = stackTrace.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                z10 = false;
                break;
            } else if (h(stackTrace[i10])) {
                z10 = true;
                break;
            } else {
                i10++;
            }
        }
        if (z10) {
            return j.a(cause, stackTrace);
        }
        return j.a(e10, new StackTraceElement[0]);
    }

    private static final <E extends Throwable> E d(E e10, E e11, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(b("Coroutine boundary"));
        StackTraceElement[] stackTrace = e10.getStackTrace();
        int g10 = g(stackTrace, f30243a);
        int i10 = 0;
        if (g10 == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            e11.setStackTrace((StackTraceElement[]) array);
            return e11;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + g10];
        if (g10 > 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                stackTraceElementArr[i11] = stackTrace[i11];
                if (i12 >= g10) {
                    break;
                }
                i11 = i12;
            }
        }
        Iterator<StackTraceElement> it = arrayDeque.iterator();
        while (it.hasNext()) {
            i10++;
            stackTraceElementArr[i10 + g10] = it.next();
        }
        e11.setStackTrace(stackTraceElementArr);
        return e11;
    }

    private static final ArrayDeque<StackTraceElement> e(c cVar) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = cVar.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            cVar = cVar.getCallerFrame();
            if (cVar == null) {
                return arrayDeque;
            }
            StackTraceElement stackTraceElement2 = cVar.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
    }

    private static final boolean f(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && i.b(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && i.b(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && i.b(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    private static final int g(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i.b(str, stackTraceElementArr[i10].getClassName())) {
                return i10;
            }
        }
        return -1;
    }

    public static final boolean h(StackTraceElement stackTraceElement) {
        boolean D;
        D = t.D(stackTraceElement.getClassName(), "\b\b\b", false, 2, null);
        return D;
    }

    private static final void i(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            } else if (h(stackTraceElementArr[i10])) {
                break;
            } else {
                i10++;
            }
        }
        int i11 = i10 + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (i11 <= length2) {
            while (true) {
                length2--;
                if (f(stackTraceElementArr[length2], arrayDeque.getLast())) {
                    arrayDeque.removeLast();
                }
                arrayDeque.addFirst(stackTraceElementArr[length2]);
                if (length2 == i11) {
                    return;
                }
            }
        }
    }

    public static final <E extends Throwable> E j(E e10, c cVar) {
        Pair c10 = c(e10);
        Throwable th2 = (Throwable) c10.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) c10.component2();
        Throwable k10 = k(th2);
        if (k10 == null) {
            return e10;
        }
        ArrayDeque<StackTraceElement> e11 = e(cVar);
        if (e11.isEmpty()) {
            return e10;
        }
        if (th2 != e10) {
            i(stackTraceElementArr, e11);
        }
        return (E) d(th2, k10, e11);
    }

    private static final <E extends Throwable> E k(E e10) {
        E e11 = (E) ExceptionsConstuctorKt.e(e10);
        if (e11 == null) {
            return null;
        }
        if ((e10 instanceof e0) || i.b(e11.getMessage(), e10.getMessage())) {
            return e11;
        }
        return null;
    }

    public static final <E extends Throwable> E l(E e10) {
        E e11 = (E) e10.getCause();
        if (e11 != null && i.b(e11.getClass(), e10.getClass())) {
            StackTraceElement[] stackTrace = e10.getStackTrace();
            int length = stackTrace.length;
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                } else if (h(stackTrace[i10])) {
                    z10 = true;
                    break;
                } else {
                    i10++;
                }
            }
            if (z10) {
                return e11;
            }
        }
        return e10;
    }
}
