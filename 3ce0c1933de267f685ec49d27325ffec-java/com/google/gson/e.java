package com.google.gson;

import com.google.gson.internal.i;
import com.google.gson.internal.j;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import i8.g;
import i8.h;
import i8.k;
import i8.n;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
/* compiled from: Gson.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: n  reason: collision with root package name */
    private static final com.google.gson.reflect.a<?> f12547n = com.google.gson.reflect.a.get(Object.class);

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal<Map<com.google.gson.reflect.a<?>, f<?>>> f12548a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<com.google.gson.reflect.a<?>, q<?>> f12549b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.gson.internal.c f12550c;

    /* renamed from: d  reason: collision with root package name */
    private final i8.d f12551d;

    /* renamed from: e  reason: collision with root package name */
    final List<r> f12552e;

    /* renamed from: f  reason: collision with root package name */
    final Map<Type, g<?>> f12553f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f12554g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f12555h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f12556i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f12557j;

    /* renamed from: k  reason: collision with root package name */
    final boolean f12558k;

    /* renamed from: l  reason: collision with root package name */
    final List<r> f12559l;

    /* renamed from: m  reason: collision with root package name */
    final List<r> f12560m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    public class a extends q<Number> {
        a(e eVar) {
        }

        /* renamed from: e */
        public Double b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() != JsonToken.NULL) {
                return Double.valueOf(aVar.O());
            }
            aVar.g0();
            return null;
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, Number number) throws IOException {
            if (number == null) {
                bVar.I();
                return;
            }
            e.d(number.doubleValue());
            bVar.o0(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    public class b extends q<Number> {
        b(e eVar) {
        }

        /* renamed from: e */
        public Float b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() != JsonToken.NULL) {
                return Float.valueOf((float) aVar.O());
            }
            aVar.g0();
            return null;
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, Number number) throws IOException {
            if (number == null) {
                bVar.I();
                return;
            }
            e.d(number.floatValue());
            bVar.o0(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    public static class c extends q<Number> {
        c() {
        }

        /* renamed from: e */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() != JsonToken.NULL) {
                return Long.valueOf(aVar.T());
            }
            aVar.g0();
            return null;
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, Number number) throws IOException {
            if (number == null) {
                bVar.I();
            } else {
                bVar.r0(number.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    public static class d extends q<AtomicLong> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f12561a;

        d(q qVar) {
            this.f12561a = qVar;
        }

        /* renamed from: e */
        public AtomicLong b(com.google.gson.stream.a aVar) throws IOException {
            return new AtomicLong(((Number) this.f12561a.b(aVar)).longValue());
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, AtomicLong atomicLong) throws IOException {
            this.f12561a.d(bVar, Long.valueOf(atomicLong.get()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* renamed from: com.google.gson.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0162e extends q<AtomicLongArray> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f12562a;

        C0162e(q qVar) {
            this.f12562a = qVar;
        }

        /* renamed from: e */
        public AtomicLongArray b(com.google.gson.stream.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.c();
            while (aVar.v()) {
                arrayList.add(Long.valueOf(((Number) this.f12562a.b(aVar)).longValue()));
            }
            aVar.o();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicLongArray.set(i10, ((Long) arrayList.get(i10)).longValue());
            }
            return atomicLongArray;
        }

        /* renamed from: f */
        public void d(com.google.gson.stream.b bVar, AtomicLongArray atomicLongArray) throws IOException {
            bVar.h();
            int length = atomicLongArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                this.f12562a.d(bVar, Long.valueOf(atomicLongArray.get(i10)));
            }
            bVar.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    public static class f<T> extends q<T> {

        /* renamed from: a  reason: collision with root package name */
        private q<T> f12563a;

        f() {
        }

        @Override // com.google.gson.q
        public T b(com.google.gson.stream.a aVar) throws IOException {
            q<T> qVar = this.f12563a;
            if (qVar != null) {
                return qVar.b(aVar);
            }
            throw new IllegalStateException();
        }

        @Override // com.google.gson.q
        public void d(com.google.gson.stream.b bVar, T t10) throws IOException {
            q<T> qVar = this.f12563a;
            if (qVar != null) {
                qVar.d(bVar, t10);
                return;
            }
            throw new IllegalStateException();
        }

        public void e(q<T> qVar) {
            if (this.f12563a == null) {
                this.f12563a = qVar;
                return;
            }
            throw new AssertionError();
        }
    }

    public e() {
        this(com.google.gson.internal.d.f12627g, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    private static void a(Object obj, com.google.gson.stream.a aVar) {
        if (obj != null) {
            try {
                if (aVar.k0() != JsonToken.END_DOCUMENT) {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e10) {
                throw new JsonSyntaxException(e10);
            } catch (IOException e11) {
                throw new JsonIOException(e11);
            }
        }
    }

    private static q<AtomicLong> b(q<Number> qVar) {
        return new d(qVar).a();
    }

    private static q<AtomicLongArray> c(q<Number> qVar) {
        return new C0162e(qVar).a();
    }

    static void d(double d10) {
        if (Double.isNaN(d10) || Double.isInfinite(d10)) {
            throw new IllegalArgumentException(d10 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private q<Number> e(boolean z10) {
        if (z10) {
            return n.f28185v;
        }
        return new a(this);
    }

    private q<Number> f(boolean z10) {
        if (z10) {
            return n.f28184u;
        }
        return new b(this);
    }

    private static q<Number> o(LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == LongSerializationPolicy.DEFAULT) {
            return n.f28183t;
        }
        return new c();
    }

    public <T> T g(com.google.gson.stream.a aVar, Type type) throws JsonIOException, JsonSyntaxException {
        boolean w10 = aVar.w();
        boolean z10 = true;
        aVar.u0(true);
        try {
            try {
                try {
                    aVar.k0();
                    z10 = false;
                    T b10 = l(com.google.gson.reflect.a.get(type)).b(aVar);
                    aVar.u0(w10);
                    return b10;
                } catch (IOException e10) {
                    throw new JsonSyntaxException(e10);
                } catch (IllegalStateException e11) {
                    throw new JsonSyntaxException(e11);
                }
            } catch (EOFException e12) {
                if (z10) {
                    aVar.u0(w10);
                    return null;
                }
                throw new JsonSyntaxException(e12);
            } catch (AssertionError e13) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e13.getMessage(), e13);
            }
        } catch (Throwable th2) {
            aVar.u0(w10);
            throw th2;
        }
    }

    public <T> T h(Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        com.google.gson.stream.a p10 = p(reader);
        Object g10 = g(p10, cls);
        a(g10, p10);
        return (T) i.c(cls).cast(g10);
    }

    public <T> T i(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        com.google.gson.stream.a p10 = p(reader);
        T t10 = (T) g(p10, type);
        a(t10, p10);
        return t10;
    }

    public <T> T j(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) i.c(cls).cast(k(str, cls));
    }

    public <T> T k(String str, Type type) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T) i(new StringReader(str), type);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> q<T> l(com.google.gson.reflect.a<T> aVar) {
        q<T> qVar = (q<T>) this.f12549b.get(aVar == null ? f12547n : aVar);
        if (qVar != null) {
            return qVar;
        }
        Map<com.google.gson.reflect.a<?>, f<?>> map = this.f12548a.get();
        boolean z10 = false;
        if (map == null) {
            map = new HashMap<>();
            this.f12548a.set(map);
            z10 = true;
        }
        f<?> fVar = map.get(aVar);
        if (fVar != null) {
            return fVar;
        }
        try {
            f<?> fVar2 = new f<>();
            map.put(aVar, fVar2);
            for (r rVar : this.f12552e) {
                q qVar2 = (q<T>) rVar.a(this, aVar);
                if (qVar2 != null) {
                    fVar2.e(qVar2);
                    this.f12549b.put(aVar, qVar2);
                    return qVar2;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.5) cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z10) {
                this.f12548a.remove();
            }
        }
    }

    public <T> q<T> m(Class<T> cls) {
        return l(com.google.gson.reflect.a.get((Class) cls));
    }

    public <T> q<T> n(r rVar, com.google.gson.reflect.a<T> aVar) {
        if (!this.f12552e.contains(rVar)) {
            rVar = this.f12551d;
        }
        boolean z10 = false;
        for (r rVar2 : this.f12552e) {
            if (z10) {
                q<T> a10 = rVar2.a(this, aVar);
                if (a10 != null) {
                    return a10;
                }
            } else if (rVar2 == rVar) {
                z10 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public com.google.gson.stream.a p(Reader reader) {
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(reader);
        aVar.u0(this.f12558k);
        return aVar;
    }

    public com.google.gson.stream.b q(Writer writer) throws IOException {
        if (this.f12555h) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.b bVar = new com.google.gson.stream.b(writer);
        if (this.f12557j) {
            bVar.g0("  ");
        }
        bVar.i0(this.f12554g);
        return bVar;
    }

    public String r(k kVar) {
        StringWriter stringWriter = new StringWriter();
        v(kVar, stringWriter);
        return stringWriter.toString();
    }

    public String s(Object obj) {
        if (obj == null) {
            return r(l.f12652a);
        }
        return t(obj, obj.getClass());
    }

    public String t(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        x(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public String toString() {
        return "{serializeNulls:" + this.f12554g + ",factories:" + this.f12552e + ",instanceCreators:" + this.f12550c + "}";
    }

    public void u(k kVar, com.google.gson.stream.b bVar) throws JsonIOException {
        boolean w10 = bVar.w();
        bVar.h0(true);
        boolean v10 = bVar.v();
        bVar.W(this.f12556i);
        boolean u10 = bVar.u();
        bVar.i0(this.f12554g);
        try {
            try {
                j.b(kVar, bVar);
            } catch (IOException e10) {
                throw new JsonIOException(e10);
            } catch (AssertionError e11) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e11.getMessage(), e11);
            }
        } finally {
            bVar.h0(w10);
            bVar.W(v10);
            bVar.i0(u10);
        }
    }

    public void v(k kVar, Appendable appendable) throws JsonIOException {
        try {
            u(kVar, q(j.c(appendable)));
        } catch (IOException e10) {
            throw new JsonIOException(e10);
        }
    }

    public void w(Object obj, Type type, com.google.gson.stream.b bVar) throws JsonIOException {
        q l10 = l(com.google.gson.reflect.a.get(type));
        boolean w10 = bVar.w();
        bVar.h0(true);
        boolean v10 = bVar.v();
        bVar.W(this.f12556i);
        boolean u10 = bVar.u();
        bVar.i0(this.f12554g);
        try {
            try {
                l10.d(bVar, obj);
            } catch (IOException e10) {
                throw new JsonIOException(e10);
            } catch (AssertionError e11) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e11.getMessage(), e11);
            }
        } finally {
            bVar.h0(w10);
            bVar.W(v10);
            bVar.i0(u10);
        }
    }

    public void x(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            w(obj, type, q(j.c(appendable)));
        } catch (IOException e10) {
            throw new JsonIOException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.google.gson.internal.d dVar, com.google.gson.d dVar2, Map<Type, g<?>> map, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, LongSerializationPolicy longSerializationPolicy, String str, int i10, int i11, List<r> list, List<r> list2, List<r> list3) {
        this.f12548a = new ThreadLocal<>();
        this.f12549b = new ConcurrentHashMap();
        this.f12553f = map;
        com.google.gson.internal.c cVar = new com.google.gson.internal.c(map);
        this.f12550c = cVar;
        this.f12554g = z10;
        this.f12555h = z12;
        this.f12556i = z13;
        this.f12557j = z14;
        this.f12558k = z15;
        this.f12559l = list;
        this.f12560m = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(n.Y);
        arrayList.add(h.f28131b);
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(n.D);
        arrayList.add(n.f28176m);
        arrayList.add(n.f28170g);
        arrayList.add(n.f28172i);
        arrayList.add(n.f28174k);
        q<Number> o10 = o(longSerializationPolicy);
        arrayList.add(n.b(Long.TYPE, Long.class, o10));
        arrayList.add(n.b(Double.TYPE, Double.class, e(z16)));
        arrayList.add(n.b(Float.TYPE, Float.class, f(z16)));
        arrayList.add(n.f28187x);
        arrayList.add(n.f28178o);
        arrayList.add(n.f28180q);
        arrayList.add(n.a(AtomicLong.class, b(o10)));
        arrayList.add(n.a(AtomicLongArray.class, c(o10)));
        arrayList.add(n.f28182s);
        arrayList.add(n.f28189z);
        arrayList.add(n.F);
        arrayList.add(n.H);
        arrayList.add(n.a(BigDecimal.class, n.B));
        arrayList.add(n.a(BigInteger.class, n.C));
        arrayList.add(n.J);
        arrayList.add(n.L);
        arrayList.add(n.P);
        arrayList.add(n.R);
        arrayList.add(n.W);
        arrayList.add(n.N);
        arrayList.add(n.f28167d);
        arrayList.add(i8.c.f28112b);
        arrayList.add(n.U);
        arrayList.add(k.f28152b);
        arrayList.add(i8.j.f28150b);
        arrayList.add(n.S);
        arrayList.add(i8.a.f28106c);
        arrayList.add(n.f28165b);
        arrayList.add(new i8.b(cVar));
        arrayList.add(new g(cVar, z11));
        i8.d dVar3 = new i8.d(cVar);
        this.f12551d = dVar3;
        arrayList.add(dVar3);
        arrayList.add(n.Z);
        arrayList.add(new i8.i(cVar, dVar2, dVar, dVar3));
        this.f12552e = Collections.unmodifiableList(arrayList);
    }
}
