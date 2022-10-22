package kotlin.coroutines.jvm.internal;

import com.mobvoi.wear.contacts.ContactConstant;
import java.lang.reflect.Method;
import kotlin.jvm.internal.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DebugMetadata.kt */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: b  reason: collision with root package name */
    private static a f30068b;

    /* renamed from: c  reason: collision with root package name */
    public static final g f30069c = new g();

    /* renamed from: a  reason: collision with root package name */
    private static final a f30067a = new a(null, null, null);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DebugMetadata.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Method f30070a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f30071b;

        /* renamed from: c  reason: collision with root package name */
        public final Method f30072c;

        public a(Method method, Method method2, Method method3) {
            this.f30070a = method;
            this.f30071b = method2;
            this.f30072c = method3;
        }
    }

    private g() {
    }

    private final a a(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(ContactConstant.CallsRecordKeys.NAME, new Class[0]));
            f30068b = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f30067a;
            f30068b = aVar2;
            return aVar2;
        }
    }

    public final String b(BaseContinuationImpl continuation) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        i.f(continuation, "continuation");
        a aVar = f30068b;
        if (aVar == null) {
            aVar = a(continuation);
        }
        String str = null;
        if (aVar == f30067a || (method = aVar.f30070a) == null || (invoke = method.invoke(continuation.getClass(), new Object[0])) == null || (method2 = aVar.f30071b) == null || (invoke2 = method2.invoke(invoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVar.f30072c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (invoke3 instanceof String) {
            str = invoke3;
        }
        return str;
    }
}
