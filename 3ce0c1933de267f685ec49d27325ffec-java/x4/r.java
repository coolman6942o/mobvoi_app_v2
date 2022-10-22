package x4;

import com.bumptech.glide.Registry;
import j0.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import n5.j;
import x4.n;
/* compiled from: MultiModelLoaderFactory.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: e  reason: collision with root package name */
    private static final c f36418e = new c();

    /* renamed from: f  reason: collision with root package name */
    private static final n<Object, Object> f36419f = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<b<?, ?>> f36420a;

    /* renamed from: b  reason: collision with root package name */
    private final c f36421b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<b<?, ?>> f36422c;

    /* renamed from: d  reason: collision with root package name */
    private final e<List<Throwable>> f36423d;

    /* compiled from: MultiModelLoaderFactory.java */
    /* loaded from: classes.dex */
    private static class a implements n<Object, Object> {
        a() {
        }

        @Override // x4.n
        public boolean a(Object obj) {
            return false;
        }

        @Override // x4.n
        public n.a<Object> b(Object obj, int i10, int i11, q4.e eVar) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MultiModelLoaderFactory.java */
    /* loaded from: classes.dex */
    public static class b<Model, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<Model> f36424a;

        /* renamed from: b  reason: collision with root package name */
        final Class<Data> f36425b;

        /* renamed from: c  reason: collision with root package name */
        final o<? extends Model, ? extends Data> f36426c;

        public b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
            this.f36424a = cls;
            this.f36425b = cls2;
            this.f36426c = oVar;
        }

        public boolean a(Class<?> cls) {
            return this.f36424a.isAssignableFrom(cls);
        }

        public boolean b(Class<?> cls, Class<?> cls2) {
            return a(cls) && this.f36425b.isAssignableFrom(cls2);
        }
    }

    /* compiled from: MultiModelLoaderFactory.java */
    /* loaded from: classes.dex */
    static class c {
        c() {
        }

        public <Model, Data> q<Model, Data> a(List<n<Model, Data>> list, e<List<Throwable>> eVar) {
            return new q<>(list, eVar);
        }
    }

    public r(e<List<Throwable>> eVar) {
        this(eVar, f36418e);
    }

    private <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar, boolean z10) {
        b<?, ?> bVar = new b<>(cls, cls2, oVar);
        List<b<?, ?>> list = this.f36420a;
        list.add(z10 ? list.size() : 0, bVar);
    }

    private <Model, Data> n<Model, Data> e(b<?, ?> bVar) {
        return (n) j.d(bVar.f36426c.b(this));
    }

    private static <Model, Data> n<Model, Data> f() {
        return (n<Model, Data>) f36419f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized <Model, Data> void b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized <Model> List<n<Model, ?>> c(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f36420a) {
                if (!this.f36422c.contains(bVar) && bVar.a(cls)) {
                    this.f36422c.add(bVar);
                    arrayList.add(e(bVar));
                    this.f36422c.remove(bVar);
                }
            }
        } catch (Throwable th2) {
            this.f36422c.clear();
            throw th2;
        }
        return arrayList;
    }

    public synchronized <Model, Data> n<Model, Data> d(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z10 = false;
            for (b<?, ?> bVar : this.f36420a) {
                if (this.f36422c.contains(bVar)) {
                    z10 = true;
                } else if (bVar.b(cls, cls2)) {
                    this.f36422c.add(bVar);
                    arrayList.add(e(bVar));
                    this.f36422c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f36421b.a(arrayList, this.f36423d);
            } else if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            } else if (z10) {
                return f();
            } else {
                throw new Registry.NoModelLoaderAvailableException(cls, cls2);
            }
        } catch (Throwable th2) {
            this.f36422c.clear();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<Class<?>> g(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f36420a) {
            if (!arrayList.contains(bVar.f36425b) && bVar.a(cls)) {
                arrayList.add(bVar.f36425b);
            }
        }
        return arrayList;
    }

    r(e<List<Throwable>> eVar, c cVar) {
        this.f36420a = new ArrayList();
        this.f36422c = new HashSet();
        this.f36423d = eVar;
        this.f36421b = cVar;
    }
}
