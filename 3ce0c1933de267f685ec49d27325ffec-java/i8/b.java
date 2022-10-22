package i8;

import com.google.gson.e;
import com.google.gson.internal.c;
import com.google.gson.internal.g;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* compiled from: CollectionTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class b implements r {

    /* renamed from: a  reason: collision with root package name */
    private final c f28109a;

    /* compiled from: CollectionTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    private static final class a<E> extends q<Collection<E>> {

        /* renamed from: a  reason: collision with root package name */
        private final q<E> f28110a;

        /* renamed from: b  reason: collision with root package name */
        private final g<? extends Collection<E>> f28111b;

        public a(e eVar, Type type, q<E> qVar, g<? extends Collection<E>> gVar) {
            this.f28110a = new m(eVar, qVar, type);
            this.f28111b = gVar;
        }

        /* renamed from: e */
        public Collection<E> b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == JsonToken.NULL) {
                aVar.g0();
                return null;
            }
            Collection<E> a10 = this.f28111b.a();
            aVar.c();
            while (aVar.v()) {
                a10.add(this.f28110a.b(aVar));
            }
            aVar.o();
            return a10;
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                bVar.I();
                return;
            }
            bVar.h();
            for (E e10 : collection) {
                this.f28110a.d(bVar, e10);
            }
            bVar.o();
        }
    }

    public b(c cVar) {
        this.f28109a = cVar;
    }

    @Override // com.google.gson.r
    public <T> q<T> a(e eVar, com.google.gson.reflect.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type h10 = com.google.gson.internal.b.h(type, rawType);
        return new a(eVar, h10, eVar.l(com.google.gson.reflect.a.get(h10)), this.f28109a.a(aVar));
    }
}
