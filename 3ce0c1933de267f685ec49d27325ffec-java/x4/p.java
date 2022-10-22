package x4;

import j0.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: ModelLoaderRegistry.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private final r f36405a;

    /* renamed from: b  reason: collision with root package name */
    private final a f36406b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ModelLoaderRegistry.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<?>, C0531a<?>> f36407a = new HashMap();

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ModelLoaderRegistry.java */
        /* renamed from: x4.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0531a<Model> {

            /* renamed from: a  reason: collision with root package name */
            final List<n<Model, ?>> f36408a;

            public C0531a(List<n<Model, ?>> list) {
                this.f36408a = list;
            }
        }

        a() {
        }

        public void a() {
            this.f36407a.clear();
        }

        public <Model> List<n<Model, ?>> b(Class<Model> cls) {
            C0531a<?> aVar = this.f36407a.get(cls);
            if (aVar == null) {
                return null;
            }
            return (List<n<Model, ?>>) aVar.f36408a;
        }

        public <Model> void c(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.f36407a.put(cls, new C0531a<>(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }
    }

    public p(e<List<Throwable>> eVar) {
        this(new r(eVar));
    }

    private static <A> Class<A> b(A a10) {
        return (Class<A>) a10.getClass();
    }

    private synchronized <A> List<n<A, ?>> e(Class<A> cls) {
        List<n<A, ?>> b10;
        b10 = this.f36406b.b(cls);
        if (b10 == null) {
            b10 = Collections.unmodifiableList(this.f36405a.c(cls));
            this.f36406b.c(cls, b10);
        }
        return b10;
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        this.f36405a.b(cls, cls2, oVar);
        this.f36406b.a();
    }

    public synchronized List<Class<?>> c(Class<?> cls) {
        return this.f36405a.g(cls);
    }

    public <A> List<n<A, ?>> d(A a10) {
        List<n<A, ?>> e10 = e(b(a10));
        int size = e10.size();
        List<n<A, ?>> emptyList = Collections.emptyList();
        boolean z10 = true;
        for (int i10 = 0; i10 < size; i10++) {
            n<A, ?> nVar = e10.get(i10);
            if (nVar.a(a10)) {
                if (z10) {
                    emptyList = new ArrayList<>(size - i10);
                    z10 = false;
                }
                emptyList.add(nVar);
            }
        }
        return emptyList;
    }

    private p(r rVar) {
        this.f36406b = new a();
        this.f36405a = rVar;
    }
}
