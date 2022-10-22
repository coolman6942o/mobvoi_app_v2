package kotlin.jvm.internal;

import wo.c;
import wo.d;
import wo.e;
import wo.g;
import wo.h;
import wo.i;
import wo.k;
import wo.l;
/* compiled from: ReflectionFactory.java */
/* loaded from: classes3.dex */
public class m {
    public e a(FunctionReference functionReference) {
        return functionReference;
    }

    public c b(Class cls) {
        return new d(cls);
    }

    public d c(Class cls, String str) {
        return new k(cls, str);
    }

    public g d(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public h e(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public i f(MutablePropertyReference2 mutablePropertyReference2) {
        return mutablePropertyReference2;
    }

    public k g(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public l h(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public wo.m i(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }

    public String j(g gVar) {
        String obj = gVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    public String k(Lambda lambda) {
        return j(lambda);
    }
}
