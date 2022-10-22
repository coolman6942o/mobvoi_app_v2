package lo;

import java.lang.reflect.Method;
import kotlin.collections.e;
import kotlin.jvm.internal.i;
import kotlin.random.Random;
import to.b;
/* compiled from: PlatformImplementations.kt */
/* loaded from: classes3.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlatformImplementations.kt */
    /* renamed from: lo.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0391a {

        /* renamed from: a  reason: collision with root package name */
        public static final Method f30563a;

        /* JADX WARN: Removed duplicated region for block: B:12:0x0043 A[LOOP:0: B:3:0x0013->B:12:0x0043, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0047 A[EDGE_INSN: B:20:0x0047->B:14:0x0047 ?: BREAK  , SYNTHETIC] */
        static {
            Method it;
            boolean z10;
            new C0391a();
            Method[] throwableMethods = Throwable.class.getMethods();
            i.e(throwableMethods, "throwableMethods");
            int length = throwableMethods.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    it = null;
                    break;
                }
                it = throwableMethods[i10];
                i.e(it, "it");
                if (i.b(it.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = it.getParameterTypes();
                    i.e(parameterTypes, "it.parameterTypes");
                    if (i.b((Class) e.z(parameterTypes), Throwable.class)) {
                        z10 = true;
                        if (!z10) {
                            break;
                        }
                        i10++;
                    }
                }
                z10 = false;
                if (!z10) {
                }
            }
            f30563a = it;
            for (Method it2 : throwableMethods) {
                i.e(it2, "it");
                if (i.b(it2.getName(), "getSuppressed")) {
                    return;
                }
            }
        }

        private C0391a() {
        }
    }

    public void a(Throwable cause, Throwable exception) {
        i.f(cause, "cause");
        i.f(exception, "exception");
        Method method = C0391a.f30563a;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public Random b() {
        return new b();
    }
}
