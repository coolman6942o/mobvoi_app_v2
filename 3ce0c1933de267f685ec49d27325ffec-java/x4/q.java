package x4;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import j0.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import n5.j;
import q4.b;
import r4.d;
import x4.n;
/* compiled from: MultiModelLoader.java */
/* loaded from: classes.dex */
class q<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n<Model, Data>> f36409a;

    /* renamed from: b  reason: collision with root package name */
    private final e<List<Throwable>> f36410b;

    /* compiled from: MultiModelLoader.java */
    /* loaded from: classes.dex */
    static class a<Data> implements d<Data>, d.a<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final List<d<Data>> f36411a;

        /* renamed from: b  reason: collision with root package name */
        private final e<List<Throwable>> f36412b;

        /* renamed from: c  reason: collision with root package name */
        private int f36413c = 0;

        /* renamed from: d  reason: collision with root package name */
        private Priority f36414d;

        /* renamed from: e  reason: collision with root package name */
        private d.a<? super Data> f36415e;

        /* renamed from: f  reason: collision with root package name */
        private List<Throwable> f36416f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f36417g;

        a(List<d<Data>> list, e<List<Throwable>> eVar) {
            this.f36412b = eVar;
            j.c(list);
            this.f36411a = list;
        }

        private void g() {
            if (!this.f36417g) {
                if (this.f36413c < this.f36411a.size() - 1) {
                    this.f36413c++;
                    e(this.f36414d, this.f36415e);
                    return;
                }
                j.d(this.f36416f);
                this.f36415e.d(new GlideException("Fetch failed", new ArrayList(this.f36416f)));
            }
        }

        @Override // r4.d
        public Class<Data> a() {
            return this.f36411a.get(0).a();
        }

        @Override // r4.d
        public DataSource b() {
            return this.f36411a.get(0).b();
        }

        @Override // r4.d
        public void c() {
            List<Throwable> list = this.f36416f;
            if (list != null) {
                this.f36412b.a(list);
            }
            this.f36416f = null;
            for (d<Data> dVar : this.f36411a) {
                dVar.c();
            }
        }

        @Override // r4.d
        public void cancel() {
            this.f36417g = true;
            for (d<Data> dVar : this.f36411a) {
                dVar.cancel();
            }
        }

        @Override // r4.d.a
        public void d(Exception exc) {
            ((List) j.d(this.f36416f)).add(exc);
            g();
        }

        @Override // r4.d
        public void e(Priority priority, d.a<? super Data> aVar) {
            this.f36414d = priority;
            this.f36415e = aVar;
            this.f36416f = this.f36412b.b();
            this.f36411a.get(this.f36413c).e(priority, this);
            if (this.f36417g) {
                cancel();
            }
        }

        @Override // r4.d.a
        public void f(Data data) {
            if (data != null) {
                this.f36415e.f(data);
            } else {
                g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(List<n<Model, Data>> list, e<List<Throwable>> eVar) {
        this.f36409a = list;
        this.f36410b = eVar;
    }

    @Override // x4.n
    public boolean a(Model model) {
        for (n<Model, Data> nVar : this.f36409a) {
            if (nVar.a(model)) {
                return true;
            }
        }
        return false;
    }

    @Override // x4.n
    public n.a<Data> b(Model model, int i10, int i11, q4.e eVar) {
        n.a<Data> b10;
        int size = this.f36409a.size();
        ArrayList arrayList = new ArrayList(size);
        b bVar = null;
        for (int i12 = 0; i12 < size; i12++) {
            n<Model, Data> nVar = this.f36409a.get(i12);
            if (nVar.a(model) && (b10 = nVar.b(model, i10, i11, eVar)) != null) {
                bVar = b10.f36402a;
                arrayList.add(b10.f36404c);
            }
        }
        if (arrayList.isEmpty() || bVar == null) {
            return null;
        }
        return new n.a<>(bVar, new a(arrayList, this.f36410b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f36409a.toArray()) + '}';
    }
}
