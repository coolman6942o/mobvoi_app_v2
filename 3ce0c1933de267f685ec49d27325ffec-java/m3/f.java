package m3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import n3.a;
import org.json.alipay.b;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static List<j> f30603a;

    static {
        ArrayList arrayList = new ArrayList();
        f30603a = arrayList;
        arrayList.add(new l());
        f30603a.add(new d());
        f30603a.add(new c());
        f30603a.add(new h());
        f30603a.add(new b());
        f30603a.add(new a());
        f30603a.add(new g());
    }

    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object b10 = b(obj);
        if (a.b(b10.getClass())) {
            return b.c(b10.toString());
        }
        if (Collection.class.isAssignableFrom(b10.getClass())) {
            return new org.json.alipay.a((Collection) ((List) b10)).toString();
        }
        if (Map.class.isAssignableFrom(b10.getClass())) {
            return new b((Map) b10).toString();
        }
        throw new IllegalArgumentException("Unsupported Class : " + b10.getClass());
    }

    public static Object b(Object obj) {
        Object a10;
        if (obj == null) {
            return null;
        }
        for (j jVar : f30603a) {
            if (jVar.a(obj.getClass()) && (a10 = jVar.a(obj)) != null) {
                return a10;
            }
        }
        throw new IllegalArgumentException("Unsupported Class : " + obj.getClass());
    }
}
