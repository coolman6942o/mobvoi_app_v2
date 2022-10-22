package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlinx.coroutines.s1;
import xo.e;
import xo.k;
import xo.m;
/* compiled from: MainDispatchers.kt */
/* loaded from: classes3.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final o f30235a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f30236b = x.e("kotlinx.coroutines.fast.service.loader", true);

    /* renamed from: c  reason: collision with root package name */
    public static final s1 f30237c;

    static {
        o oVar = new o();
        f30235a = oVar;
        f30237c = oVar.a();
    }

    private o() {
    }

    private final s1 a() {
        List<MainDispatcherFactory> list;
        Object obj;
        e c10;
        try {
            if (f30236b) {
                list = g.f30217a.c();
            } else {
                c10 = k.c(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator());
                list = m.m(c10);
            }
            Iterator it = list.iterator();
            if (!it.hasNext()) {
                obj = null;
            } else {
                obj = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) obj).getLoadPriority();
                    do {
                        Object next = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            obj = next;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) obj;
            if (mainDispatcherFactory == null) {
                return p.b(null, null, 3, null);
            }
            return p.d(mainDispatcherFactory, list);
        } catch (Throwable th2) {
            return p.b(th2, null, 2, null);
        }
    }
}
