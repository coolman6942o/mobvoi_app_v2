package x4;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import q4.e;
import r4.d;
import x4.n;
/* compiled from: UnitModelLoader.java */
/* loaded from: classes.dex */
public class v<Model> implements n<Model, Model> {

    /* renamed from: a  reason: collision with root package name */
    private static final v<?> f36435a = new v<>();

    /* compiled from: UnitModelLoader.java */
    /* loaded from: classes.dex */
    public static class a<Model> implements o<Model, Model> {

        /* renamed from: a  reason: collision with root package name */
        private static final a<?> f36436a = new a<>();

        public static <T> a<T> a() {
            return (a<T>) f36436a;
        }

        @Override // x4.o
        public n<Model, Model> b(r rVar) {
            return v.c();
        }
    }

    /* compiled from: UnitModelLoader.java */
    /* loaded from: classes.dex */
    private static class b<Model> implements d<Model> {

        /* renamed from: a  reason: collision with root package name */
        private final Model f36437a;

        b(Model model) {
            this.f36437a = model;
        }

        @Override // r4.d
        public Class<Model> a() {
            return (Class<Model>) this.f36437a.getClass();
        }

        @Override // r4.d
        public DataSource b() {
            return DataSource.LOCAL;
        }

        @Override // r4.d
        public void c() {
        }

        @Override // r4.d
        public void cancel() {
        }

        @Override // r4.d
        public void e(Priority priority, d.a<? super Model> aVar) {
            aVar.f((Model) this.f36437a);
        }
    }

    public static <T> v<T> c() {
        return (v<T>) f36435a;
    }

    @Override // x4.n
    public boolean a(Model model) {
        return true;
    }

    @Override // x4.n
    public n.a<Model> b(Model model, int i10, int i11, e eVar) {
        return new n.a<>(new m5.b(model), new b(model));
    }
}
