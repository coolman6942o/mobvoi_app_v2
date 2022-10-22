package np;

import java.lang.reflect.Method;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: CloseGuard.kt */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: d  reason: collision with root package name */
    public static final a f31332d = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final Method f31333a;

    /* renamed from: b  reason: collision with root package name */
    private final Method f31334b;

    /* renamed from: c  reason: collision with root package name */
    private final Method f31335c;

    /* compiled from: CloseGuard.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final h a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method = cls.getMethod("open", String.class);
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method2 = null;
                method = null;
            }
            return new h(method3, method, method2);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public h(Method method, Method method2, Method method3) {
        this.f31333a = method;
        this.f31334b = method2;
        this.f31335c = method3;
    }

    public final Object a(String closer) {
        i.f(closer, "closer");
        Method method = this.f31333a;
        if (method != null) {
            try {
                Object invoke = method.invoke(null, new Object[0]);
                Method method2 = this.f31334b;
                i.d(method2);
                method2.invoke(invoke, closer);
                return invoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final boolean b(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            Method method = this.f31335c;
            i.d(method);
            method.invoke(obj, new Object[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
