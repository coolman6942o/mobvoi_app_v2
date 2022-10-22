package l;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* compiled from: SafeIterableMap.java */
/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    c<K, V> f30386a;

    /* renamed from: b  reason: collision with root package name */
    private c<K, V> f30387b;

    /* renamed from: c  reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f30388c = new WeakHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private int f30389d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // l.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f30393d;
        }

        @Override // l.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f30392c;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: l.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0379b<K, V> extends e<K, V> {
        C0379b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // l.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f30392c;
        }

        @Override // l.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f30393d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f30390a;

        /* renamed from: b  reason: collision with root package name */
        final V f30391b;

        /* renamed from: c  reason: collision with root package name */
        c<K, V> f30392c;

        /* renamed from: d  reason: collision with root package name */
        c<K, V> f30393d;

        c(K k10, V v10) {
            this.f30390a = k10;
            this.f30391b = v10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f30390a.equals(cVar.f30390a) && this.f30391b.equals(cVar.f30391b);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f30390a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f30391b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f30390a.hashCode() ^ this.f30391b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f30390a + ContainerUtils.KEY_VALUE_DELIMITER + this.f30391b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private c<K, V> f30394a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f30395b = true;

        d() {
        }

        @Override // l.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f30394a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f30393d;
                this.f30394a = cVar3;
                this.f30395b = cVar3 == null;
            }
        }

        /* renamed from: b */
        public Map.Entry<K, V> next() {
            if (this.f30395b) {
                this.f30395b = false;
                this.f30394a = b.this.f30386a;
            } else {
                c<K, V> cVar = this.f30394a;
                this.f30394a = cVar != null ? cVar.f30392c : null;
            }
            return this.f30394a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f30395b) {
                return b.this.f30386a != null;
            }
            c<K, V> cVar = this.f30394a;
            return (cVar == null || cVar.f30392c == null) ? false : true;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a  reason: collision with root package name */
        c<K, V> f30397a;

        /* renamed from: b  reason: collision with root package name */
        c<K, V> f30398b;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f30397a = cVar2;
            this.f30398b = cVar;
        }

        private c<K, V> e() {
            c<K, V> cVar = this.f30398b;
            c<K, V> cVar2 = this.f30397a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // l.b.f
        public void a(c<K, V> cVar) {
            if (this.f30397a == cVar && cVar == this.f30398b) {
                this.f30398b = null;
                this.f30397a = null;
            }
            c<K, V> cVar2 = this.f30397a;
            if (cVar2 == cVar) {
                this.f30397a = b(cVar2);
            }
            if (this.f30398b == cVar) {
                this.f30398b = e();
            }
        }

        abstract c<K, V> b(c<K, V> cVar);

        abstract c<K, V> c(c<K, V> cVar);

        /* renamed from: d */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f30398b;
            this.f30398b = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30398b != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public Map.Entry<K, V> a() {
        return this.f30386a;
    }

    protected c<K, V> b(K k10) {
        c<K, V> cVar = this.f30386a;
        while (cVar != null && !cVar.f30390a.equals(k10)) {
            cVar = cVar.f30392c;
        }
        return cVar;
    }

    public b<K, V>.d c() {
        b<K, V>.d dVar = new d();
        this.f30388c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> d() {
        return this.f30387b;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0379b bVar = new C0379b(this.f30387b, this.f30386a);
        this.f30388c.put(bVar, Boolean.FALSE);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c<K, V> e(K k10, V v10) {
        c<K, V> cVar = new c<>(k10, v10);
        this.f30389d++;
        c<K, V> cVar2 = this.f30387b;
        if (cVar2 == null) {
            this.f30386a = cVar;
            this.f30387b = cVar;
            return cVar;
        }
        cVar2.f30392c = cVar;
        cVar.f30393d = cVar2;
        this.f30387b = cVar;
        return cVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return !it.hasNext() && !it2.hasNext();
    }

    public V f(K k10, V v10) {
        c<K, V> b10 = b(k10);
        if (b10 != null) {
            return b10.f30391b;
        }
        e(k10, v10);
        return null;
    }

    public V g(K k10) {
        c<K, V> b10 = b(k10);
        if (b10 == null) {
            return null;
        }
        this.f30389d--;
        if (!this.f30388c.isEmpty()) {
            for (f<K, V> fVar : this.f30388c.keySet()) {
                fVar.a(b10);
            }
        }
        c<K, V> cVar = b10.f30393d;
        if (cVar != null) {
            cVar.f30392c = b10.f30392c;
        } else {
            this.f30386a = b10.f30392c;
        }
        c<K, V> cVar2 = b10.f30392c;
        if (cVar2 != null) {
            cVar2.f30393d = cVar;
        } else {
            this.f30387b = cVar;
        }
        b10.f30392c = null;
        b10.f30393d = null;
        return b10.f30391b;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += it.next().hashCode();
        }
        return i10;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f30386a, this.f30387b);
        this.f30388c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f30389d;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb2.append(it.next().toString());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }
}
