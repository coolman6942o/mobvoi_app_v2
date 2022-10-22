package i8;

import com.google.gson.JsonSyntaxException;
import com.google.gson.d;
import com.google.gson.e;
import com.google.gson.internal.g;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* compiled from: ReflectiveTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class i implements r {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.gson.internal.c f28134a;

    /* renamed from: b  reason: collision with root package name */
    private final d f28135b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.gson.internal.d f28136c;

    /* renamed from: d  reason: collision with root package name */
    private final d f28137d;

    /* renamed from: e  reason: collision with root package name */
    private final k8.b f28138e = k8.b.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    public class a extends c {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Field f28139d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f28140e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ q f28141f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ e f28142g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ com.google.gson.reflect.a f28143h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ boolean f28144i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(i iVar, String str, boolean z10, boolean z11, Field field, boolean z12, q qVar, e eVar, com.google.gson.reflect.a aVar, boolean z13) {
            super(str, z10, z11);
            this.f28139d = field;
            this.f28140e = z12;
            this.f28141f = qVar;
            this.f28142g = eVar;
            this.f28143h = aVar;
            this.f28144i = z13;
        }

        @Override // i8.i.c
        void a(com.google.gson.stream.a aVar, Object obj) throws IOException, IllegalAccessException {
            Object b10 = this.f28141f.b(aVar);
            if (b10 != null || !this.f28144i) {
                this.f28139d.set(obj, b10);
            }
        }

        @Override // i8.i.c
        void b(com.google.gson.stream.b bVar, Object obj) throws IOException, IllegalAccessException {
            (this.f28140e ? this.f28141f : new m(this.f28142g, this.f28141f, this.f28143h.getType())).d(bVar, this.f28139d.get(obj));
        }

        @Override // i8.i.c
        public boolean c(Object obj) throws IOException, IllegalAccessException {
            return this.f28148b && this.f28139d.get(obj) != obj;
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    public static final class b<T> extends q<T> {

        /* renamed from: a  reason: collision with root package name */
        private final g<T> f28145a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, c> f28146b;

        b(g<T> gVar, Map<String, c> map) {
            this.f28145a = gVar;
            this.f28146b = map;
        }

        @Override // com.google.gson.q
        public T b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.k0() == JsonToken.NULL) {
                aVar.g0();
                return null;
            }
            T a10 = this.f28145a.a();
            try {
                aVar.d();
                while (aVar.v()) {
                    c cVar = this.f28146b.get(aVar.V());
                    if (cVar != null && cVar.f28149c) {
                        cVar.a(aVar, a10);
                    }
                    aVar.H0();
                }
                aVar.q();
                return a10;
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (IllegalStateException e11) {
                throw new JsonSyntaxException(e11);
            }
        }

        @Override // com.google.gson.q
        public void d(com.google.gson.stream.b bVar, T t10) throws IOException {
            if (t10 == null) {
                bVar.I();
                return;
            }
            bVar.i();
            try {
                for (c cVar : this.f28146b.values()) {
                    if (cVar.c(t10)) {
                        bVar.x(cVar.f28147a);
                        cVar.b(bVar, t10);
                    }
                }
                bVar.q();
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final String f28147a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f28148b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f28149c;

        protected c(String str, boolean z10, boolean z11) {
            this.f28147a = str;
            this.f28148b = z10;
            this.f28149c = z11;
        }

        abstract void a(com.google.gson.stream.a aVar, Object obj) throws IOException, IllegalAccessException;

        abstract void b(com.google.gson.stream.b bVar, Object obj) throws IOException, IllegalAccessException;

        abstract boolean c(Object obj) throws IOException, IllegalAccessException;
    }

    public i(com.google.gson.internal.c cVar, d dVar, com.google.gson.internal.d dVar2, d dVar3) {
        this.f28134a = cVar;
        this.f28135b = dVar;
        this.f28136c = dVar2;
        this.f28137d = dVar3;
    }

    private c b(e eVar, Field field, String str, com.google.gson.reflect.a<?> aVar, boolean z10, boolean z11) {
        boolean b10 = com.google.gson.internal.i.b(aVar.getRawType());
        h8.b bVar = (h8.b) field.getAnnotation(h8.b.class);
        q<?> b11 = bVar != null ? this.f28137d.b(this.f28134a, eVar, aVar, bVar) : null;
        boolean z12 = b11 != null;
        if (b11 == null) {
            b11 = eVar.l(aVar);
        }
        return new a(this, str, z10, z11, field, z12, b11, eVar, aVar, b10);
    }

    static boolean d(Field field, boolean z10, com.google.gson.internal.d dVar) {
        return !dVar.c(field.getType(), z10) && !dVar.f(field, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    private Map<String, c> e(e eVar, com.google.gson.reflect.a<?> aVar, Class<?> cls) {
        c cVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = aVar.getType();
        com.google.gson.reflect.a<?> aVar2 = aVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z10 = false;
            int i10 = 0;
            while (i10 < length) {
                Field field = declaredFields[i10];
                boolean c10 = c(field, true);
                boolean c11 = c(field, z10);
                if (c10 || c11) {
                    this.f28138e.b(field);
                    Type p10 = com.google.gson.internal.b.p(aVar2.getType(), cls2, field.getGenericType());
                    List<String> f10 = f(field);
                    c cVar2 = null;
                    int size = f10.size();
                    int i11 = z10;
                    while (i11 < size) {
                        String str = f10.get(i11);
                        boolean z11 = i11 != 0 ? z10 : c10;
                        int i12 = i11;
                        Field field2 = field;
                        c cVar3 = cVar2;
                        size = size;
                        f10 = f10;
                        field = field;
                        cVar2 = (c) linkedHashMap.put(str, b(eVar, field2, str, com.google.gson.reflect.a.get(p10), z11, c11));
                        if (cVar3 != null) {
                            cVar2 = cVar3;
                        }
                        c10 = z11;
                        z10 = false;
                        i11 = i12 + 1;
                    }
                    if (cVar2 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + cVar.f28147a);
                    }
                }
                i10++;
                z10 = false;
            }
            aVar2 = com.google.gson.reflect.a.get(com.google.gson.internal.b.p(aVar2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.getRawType();
        }
        return linkedHashMap;
    }

    private List<String> f(Field field) {
        h8.c cVar = (h8.c) field.getAnnotation(h8.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f28135b.translateName(field));
        }
        String value = cVar.value();
        String[] alternate = cVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.r
    public <T> q<T> a(e eVar, com.google.gson.reflect.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        return new b(this.f28134a.a(aVar), e(eVar, aVar, rawType));
    }

    public boolean c(Field field, boolean z10) {
        return d(field, z10, this.f28136c);
    }
}
