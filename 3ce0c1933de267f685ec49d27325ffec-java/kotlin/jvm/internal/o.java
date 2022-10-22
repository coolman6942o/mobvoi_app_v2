package kotlin.jvm.internal;

import com.mobvoi.wear.lpa.LpaConstants;
import java.util.List;
import qo.c;
import qo.d;
import qo.e;
import qo.f;
import qo.g;
import qo.h;
import qo.i;
import qo.j;
import qo.k;
import qo.l;
import qo.m;
import qo.n;
import qo.p;
import qo.q;
import qo.r;
import qo.s;
import qo.t;
import qo.u;
import qo.v;
import qo.w;
import ro.a;
import ro.b;
/* compiled from: TypeIntrinsics.java */
/* loaded from: classes3.dex */
public class o {
    public static List a(Object obj) {
        if ((obj instanceof a) && !(obj instanceof b)) {
            h(obj, "kotlin.collections.MutableList");
        }
        return c(obj);
    }

    public static Object b(Object obj, int i10) {
        if (obj != null && !e(obj, i10)) {
            h(obj, "kotlin.jvm.functions.Function" + i10);
        }
        return obj;
    }

    public static List c(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e10) {
            throw g(e10);
        }
    }

    public static int d(Object obj) {
        if (obj instanceof g) {
            return ((g) obj).getArity();
        }
        if (obj instanceof qo.a) {
            return 0;
        }
        if (obj instanceof l) {
            return 1;
        }
        if (obj instanceof p) {
            return 2;
        }
        if (obj instanceof q) {
            return 3;
        }
        if (obj instanceof r) {
            return 4;
        }
        if (obj instanceof s) {
            return 5;
        }
        if (obj instanceof t) {
            return 6;
        }
        if (obj instanceof u) {
            return 7;
        }
        if (obj instanceof v) {
            return 8;
        }
        if (obj instanceof w) {
            return 9;
        }
        if (obj instanceof qo.b) {
            return 10;
        }
        if (obj instanceof c) {
            return 11;
        }
        if (obj instanceof d) {
            return 12;
        }
        if (obj instanceof e) {
            return 13;
        }
        if (obj instanceof f) {
            return 14;
        }
        if (obj instanceof g) {
            return 15;
        }
        if (obj instanceof h) {
            return 16;
        }
        if (obj instanceof i) {
            return 17;
        }
        if (obj instanceof j) {
            return 18;
        }
        if (obj instanceof k) {
            return 19;
        }
        if (obj instanceof m) {
            return 20;
        }
        if (obj instanceof n) {
            return 21;
        }
        return obj instanceof qo.o ? 22 : -1;
    }

    public static boolean e(Object obj, int i10) {
        return (obj instanceof io.c) && d(obj) == i10;
    }

    private static <T extends Throwable> T f(T t10) {
        return (T) i.m(t10, o.class.getName());
    }

    public static ClassCastException g(ClassCastException classCastException) {
        throw ((ClassCastException) f(classCastException));
    }

    public static void h(Object obj, String str) {
        String name = obj == null ? LpaConstants.VALUE_NULL : obj.getClass().getName();
        i(name + " cannot be cast to " + str);
    }

    public static void i(String str) {
        throw g(new ClassCastException(str));
    }
}
