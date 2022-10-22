package kotlin.jvm.internal;

import wo.c;
import wo.d;
import wo.e;
import wo.g;
import wo.h;
import wo.i;
import wo.k;
import wo.m;
/* compiled from: Reflection.java */
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final m f30084a;

    /* renamed from: b  reason: collision with root package name */
    private static final c[] f30085b;

    static {
        m mVar = null;
        try {
            mVar = (m) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (mVar == null) {
            mVar = new m();
        }
        f30084a = mVar;
        f30085b = new c[0];
    }

    public static e a(FunctionReference functionReference) {
        return f30084a.a(functionReference);
    }

    public static c b(Class cls) {
        return f30084a.b(cls);
    }

    public static d c(Class cls) {
        return f30084a.c(cls, "");
    }

    public static g d(MutablePropertyReference0 mutablePropertyReference0) {
        return f30084a.d(mutablePropertyReference0);
    }

    public static h e(MutablePropertyReference1 mutablePropertyReference1) {
        return f30084a.e(mutablePropertyReference1);
    }

    public static i f(MutablePropertyReference2 mutablePropertyReference2) {
        return f30084a.f(mutablePropertyReference2);
    }

    public static k g(PropertyReference0 propertyReference0) {
        return f30084a.g(propertyReference0);
    }

    public static wo.l h(PropertyReference1 propertyReference1) {
        return f30084a.h(propertyReference1);
    }

    public static m i(PropertyReference2 propertyReference2) {
        return f30084a.i(propertyReference2);
    }

    public static String j(g gVar) {
        return f30084a.j(gVar);
    }

    public static String k(Lambda lambda) {
        return f30084a.k(lambda);
    }
}
