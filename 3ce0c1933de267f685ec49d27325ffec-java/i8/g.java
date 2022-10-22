package i8;

import com.google.gson.JsonSyntaxException;
import com.google.gson.e;
import com.google.gson.internal.c;
import com.google.gson.internal.f;
import com.google.gson.internal.j;
import com.google.gson.k;
import com.google.gson.n;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.b;
import com.mobvoi.wear.lpa.LpaConstants;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* compiled from: MapTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class g implements r {

    /* renamed from: a  reason: collision with root package name */
    private final c f28125a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f28126b;

    /* compiled from: MapTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    private final class a<K, V> extends q<Map<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private final q<K> f28127a;

        /* renamed from: b  reason: collision with root package name */
        private final q<V> f28128b;

        /* renamed from: c  reason: collision with root package name */
        private final com.google.gson.internal.g<? extends Map<K, V>> f28129c;

        public a(e eVar, Type type, q<K> qVar, Type type2, q<V> qVar2, com.google.gson.internal.g<? extends Map<K, V>> gVar) {
            this.f28127a = new m(eVar, qVar, type);
            this.f28128b = new m(eVar, qVar2, type2);
            this.f28129c = gVar;
        }

        private String e(k kVar) {
            if (kVar.g()) {
                n c10 = kVar.c();
                if (c10.q()) {
                    return String.valueOf(c10.m());
                }
                if (c10.o()) {
                    return Boolean.toString(c10.h());
                }
                if (c10.s()) {
                    return c10.n();
                }
                throw new AssertionError();
            } else if (kVar.e()) {
                return LpaConstants.VALUE_NULL;
            } else {
                throw new AssertionError();
            }
        }

        /* renamed from: f */
        public Map<K, V> b(com.google.gson.stream.a aVar) throws IOException {
            JsonToken k02 = aVar.k0();
            if (k02 == JsonToken.NULL) {
                aVar.g0();
                return null;
            }
            Map<K, V> a10 = this.f28129c.a();
            if (k02 == JsonToken.BEGIN_ARRAY) {
                aVar.c();
                while (aVar.v()) {
                    aVar.c();
                    K b10 = this.f28127a.b(aVar);
                    if (a10.put(b10, this.f28128b.b(aVar)) == null) {
                        aVar.o();
                    } else {
                        throw new JsonSyntaxException("duplicate key: " + b10);
                    }
                }
                aVar.o();
            } else {
                aVar.d();
                while (aVar.v()) {
                    f.f12641a.a(aVar);
                    K b11 = this.f28127a.b(aVar);
                    if (a10.put(b11, this.f28128b.b(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + b11);
                    }
                }
                aVar.q();
            }
            return a10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: g */
        public void d(b bVar, Map<K, V> map) throws IOException {
            if (map == null) {
                bVar.I();
            } else if (!g.this.f28126b) {
                bVar.i();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.x(String.valueOf(entry.getKey()));
                    this.f28128b.d(bVar, entry.getValue());
                }
                bVar.q();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i10 = 0;
                boolean z10 = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    k c10 = this.f28127a.c(entry2.getKey());
                    arrayList.add(c10);
                    arrayList2.add(entry2.getValue());
                    z10 |= c10.d() || c10.f();
                }
                if (z10) {
                    bVar.h();
                    int size = arrayList.size();
                    while (i10 < size) {
                        bVar.h();
                        j.b((k) arrayList.get(i10), bVar);
                        this.f28128b.d(bVar, arrayList2.get(i10));
                        bVar.o();
                        i10++;
                    }
                    bVar.o();
                    return;
                }
                bVar.i();
                int size2 = arrayList.size();
                while (i10 < size2) {
                    bVar.x(e((k) arrayList.get(i10)));
                    this.f28128b.d(bVar, arrayList2.get(i10));
                    i10++;
                }
                bVar.q();
            }
        }
    }

    public g(c cVar, boolean z10) {
        this.f28125a = cVar;
        this.f28126b = z10;
    }

    private q<?> b(e eVar, Type type) {
        if (type == Boolean.TYPE || type == Boolean.class) {
            return n.f28169f;
        }
        return eVar.l(com.google.gson.reflect.a.get(type));
    }

    @Override // com.google.gson.r
    public <T> q<T> a(e eVar, com.google.gson.reflect.a<T> aVar) {
        Type type = aVar.getType();
        if (!Map.class.isAssignableFrom(aVar.getRawType())) {
            return null;
        }
        Type[] j10 = com.google.gson.internal.b.j(type, com.google.gson.internal.b.k(type));
        return new a(eVar, j10[0], b(eVar, j10[0]), j10[1], eVar.l(com.google.gson.reflect.a.get(j10[1])), this.f28125a.a(aVar));
    }
}
