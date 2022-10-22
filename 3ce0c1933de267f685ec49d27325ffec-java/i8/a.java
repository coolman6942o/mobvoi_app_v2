package i8;

import com.google.gson.e;
import com.google.gson.internal.b;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* compiled from: ArrayTypeAdapter.java */
/* loaded from: classes.dex */
public final class a<E> extends q<Object> {

    /* renamed from: c  reason: collision with root package name */
    public static final r f28106c = new C0309a();

    /* renamed from: a  reason: collision with root package name */
    private final Class<E> f28107a;

    /* renamed from: b  reason: collision with root package name */
    private final q<E> f28108b;

    /* compiled from: ArrayTypeAdapter.java */
    /* renamed from: i8.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0309a implements r {
        C0309a() {
        }

        @Override // com.google.gson.r
        public <T> q<T> a(e eVar, com.google.gson.reflect.a<T> aVar) {
            Type type = aVar.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type g10 = b.g(type);
            return new a(eVar, eVar.l(com.google.gson.reflect.a.get(g10)), b.k(g10));
        }
    }

    public a(e eVar, q<E> qVar, Class<E> cls) {
        this.f28108b = new m(eVar, qVar, cls);
        this.f28107a = cls;
    }

    @Override // com.google.gson.q
    public Object b(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.k0() == JsonToken.NULL) {
            aVar.g0();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.c();
        while (aVar.v()) {
            arrayList.add(this.f28108b.b(aVar));
        }
        aVar.o();
        int size = arrayList.size();
        Object newInstance = Array.newInstance((Class<?>) this.f28107a, size);
        for (int i10 = 0; i10 < size; i10++) {
            Array.set(newInstance, i10, arrayList.get(i10));
        }
        return newInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.q
    public void d(com.google.gson.stream.b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.I();
            return;
        }
        bVar.h();
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            this.f28108b.d(bVar, Array.get(obj, i10));
        }
        bVar.o();
    }
}
