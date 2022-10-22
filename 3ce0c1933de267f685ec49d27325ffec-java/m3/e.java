package m3;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import n3.a;
import org.json.alipay.b;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static List<i> f30602a;

    static {
        ArrayList arrayList = new ArrayList();
        f30602a = arrayList;
        arrayList.add(new l());
        f30602a.add(new d());
        f30602a.add(new c());
        f30602a.add(new h());
        f30602a.add(new k());
        f30602a.add(new b());
        f30602a.add(new a());
        f30602a.add(new g());
    }

    public static final <T> T a(Object obj, Type type) {
        T t10;
        for (i iVar : f30602a) {
            if (iVar.a(a.a(type)) && (t10 = (T) iVar.b(obj, type)) != null) {
                return t10;
            }
        }
        return null;
    }

    public static final Object b(String str, Type type) {
        Object bVar;
        if (str == null || str.length() == 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("[") && trim.endsWith("]")) {
            bVar = new org.json.alipay.a(trim);
        } else if (!trim.startsWith("{") || !trim.endsWith("}")) {
            return a(trim, type);
        } else {
            bVar = new b(trim);
        }
        return a(bVar, type);
    }
}
