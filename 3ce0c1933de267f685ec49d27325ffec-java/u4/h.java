package u4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import u4.m;
/* compiled from: GroupedLinkedMap.java */
/* loaded from: classes.dex */
class h<K extends m, V> {

    /* renamed from: a  reason: collision with root package name */
    private final a<K, V> f35296a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<K, a<K, V>> f35297b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GroupedLinkedMap.java */
    /* loaded from: classes.dex */
    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f35298a;

        /* renamed from: b  reason: collision with root package name */
        private List<V> f35299b;

        /* renamed from: c  reason: collision with root package name */
        a<K, V> f35300c;

        /* renamed from: d  reason: collision with root package name */
        a<K, V> f35301d;

        a() {
            this(null);
        }

        public void a(V v10) {
            if (this.f35299b == null) {
                this.f35299b = new ArrayList();
            }
            this.f35299b.add(v10);
        }

        public V b() {
            int c10 = c();
            if (c10 > 0) {
                return this.f35299b.remove(c10 - 1);
            }
            return null;
        }

        public int c() {
            List<V> list = this.f35299b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(K k10) {
            this.f35301d = this;
            this.f35300c = this;
            this.f35298a = k10;
        }
    }

    private void b(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f35296a;
        aVar.f35301d = aVar2;
        aVar.f35300c = aVar2.f35300c;
        g(aVar);
    }

    private void c(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f35296a;
        aVar.f35301d = aVar2.f35301d;
        aVar.f35300c = aVar2;
        g(aVar);
    }

    private static <K, V> void e(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f35301d;
        aVar2.f35300c = aVar.f35300c;
        aVar.f35300c.f35301d = aVar2;
    }

    private static <K, V> void g(a<K, V> aVar) {
        aVar.f35300c.f35301d = aVar;
        aVar.f35301d.f35300c = aVar;
    }

    public V a(K k10) {
        a<K, V> aVar = this.f35297b.get(k10);
        if (aVar == null) {
            aVar = new a<>(k10);
            this.f35297b.put(k10, aVar);
        } else {
            k10.a();
        }
        b(aVar);
        return aVar.b();
    }

    public void d(K k10, V v10) {
        a<K, V> aVar = this.f35297b.get(k10);
        if (aVar == null) {
            aVar = new a<>(k10);
            c(aVar);
            this.f35297b.put(k10, aVar);
        } else {
            k10.a();
        }
        aVar.a(v10);
    }

    public V f() {
        for (a aVar = this.f35296a.f35301d; !aVar.equals(this.f35296a); aVar = aVar.f35301d) {
            V v10 = (V) aVar.b();
            if (v10 != null) {
                return v10;
            }
            e(aVar);
            this.f35297b.remove(aVar.f35298a);
            ((m) aVar.f35298a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("GroupedLinkedMap( ");
        boolean z10 = false;
        for (a aVar = this.f35296a.f35300c; !aVar.equals(this.f35296a); aVar = aVar.f35300c) {
            z10 = true;
            sb2.append('{');
            sb2.append(aVar.f35298a);
            sb2.append(':');
            sb2.append(aVar.c());
            sb2.append("}, ");
        }
        if (z10) {
            sb2.delete(sb2.length() - 2, sb2.length());
        }
        sb2.append(" )");
        return sb2.toString();
    }
}
