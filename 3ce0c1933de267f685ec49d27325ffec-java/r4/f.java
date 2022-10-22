package r4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import n5.j;
import r4.e;
/* compiled from: DataRewinderRegistry.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    private static final e.a<?> f33410b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, e.a<?>> f33411a = new HashMap();

    /* compiled from: DataRewinderRegistry.java */
    /* loaded from: classes.dex */
    class a implements e.a<Object> {
        a() {
        }

        @Override // r4.e.a
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // r4.e.a
        public e<Object> b(Object obj) {
            return new b(obj);
        }
    }

    /* compiled from: DataRewinderRegistry.java */
    /* loaded from: classes.dex */
    private static final class b implements e<Object> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f33412a;

        b(Object obj) {
            this.f33412a = obj;
        }

        @Override // r4.e
        public Object a() {
            return this.f33412a;
        }

        @Override // r4.e
        public void c() {
        }
    }

    public synchronized <T> e<T> a(T t10) {
        e.a<?> aVar;
        j.d(t10);
        aVar = this.f33411a.get(t10.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it = this.f33411a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.a<?> next = it.next();
                if (next.a().isAssignableFrom(t10.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f33410b;
        }
        return (e<T>) aVar.b(t10);
    }

    public synchronized void b(e.a<?> aVar) {
        this.f33411a.put(aVar.a(), aVar);
    }
}
