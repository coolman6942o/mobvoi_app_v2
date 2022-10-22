package e3;

import java.util.ArrayList;
import java.util.List;
/* compiled from: BaseKeyframeAnimation.java */
/* loaded from: classes.dex */
public abstract class a<K, A> {

    /* renamed from: c  reason: collision with root package name */
    private final d<K> f25730c;

    /* renamed from: e  reason: collision with root package name */
    protected l3.c<A> f25732e;

    /* renamed from: a  reason: collision with root package name */
    final List<b> f25728a = new ArrayList(1);

    /* renamed from: b  reason: collision with root package name */
    private boolean f25729b = false;

    /* renamed from: d  reason: collision with root package name */
    protected float f25731d = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private A f25733f = null;

    /* renamed from: g  reason: collision with root package name */
    private float f25734g = -1.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f25735h = -1.0f;

    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: classes.dex */
    public interface b {
        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: classes.dex */
    public static final class c<T> implements d<T> {
        private c() {
        }

        @Override // e3.a.d
        public boolean a(float f10) {
            throw new IllegalStateException("not implemented");
        }

        @Override // e3.a.d
        public l3.a<T> b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // e3.a.d
        public boolean c(float f10) {
            return false;
        }

        @Override // e3.a.d
        public float d() {
            return 1.0f;
        }

        @Override // e3.a.d
        public float e() {
            return 0.0f;
        }

        @Override // e3.a.d
        public boolean isEmpty() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: classes.dex */
    public interface d<T> {
        boolean a(float f10);

        l3.a<T> b();

        boolean c(float f10);

        float d();

        float e();

        boolean isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: classes.dex */
    public static final class e<T> implements d<T> {

        /* renamed from: a  reason: collision with root package name */
        private final List<? extends l3.a<T>> f25736a;

        /* renamed from: c  reason: collision with root package name */
        private l3.a<T> f25738c = null;

        /* renamed from: d  reason: collision with root package name */
        private float f25739d = -1.0f;

        /* renamed from: b  reason: collision with root package name */
        private l3.a<T> f25737b = f(0.0f);

        e(List<? extends l3.a<T>> list) {
            this.f25736a = list;
        }

        private l3.a<T> f(float f10) {
            List<? extends l3.a<T>> list = this.f25736a;
            l3.a<T> aVar = list.get(list.size() - 1);
            if (f10 >= aVar.e()) {
                return aVar;
            }
            for (int size = this.f25736a.size() - 2; size >= 1; size--) {
                l3.a<T> aVar2 = this.f25736a.get(size);
                if (this.f25737b != aVar2 && aVar2.a(f10)) {
                    return aVar2;
                }
            }
            return this.f25736a.get(0);
        }

        @Override // e3.a.d
        public boolean a(float f10) {
            l3.a<T> aVar = this.f25738c;
            l3.a<T> aVar2 = this.f25737b;
            if (aVar == aVar2 && this.f25739d == f10) {
                return true;
            }
            this.f25738c = aVar2;
            this.f25739d = f10;
            return false;
        }

        @Override // e3.a.d
        public l3.a<T> b() {
            return this.f25737b;
        }

        @Override // e3.a.d
        public boolean c(float f10) {
            if (this.f25737b.a(f10)) {
                return !this.f25737b.h();
            }
            this.f25737b = f(f10);
            return true;
        }

        @Override // e3.a.d
        public float d() {
            List<? extends l3.a<T>> list = this.f25736a;
            return list.get(list.size() - 1).b();
        }

        @Override // e3.a.d
        public float e() {
            return this.f25736a.get(0).e();
        }

        @Override // e3.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: classes.dex */
    public static final class f<T> implements d<T> {

        /* renamed from: a  reason: collision with root package name */
        private final l3.a<T> f25740a;

        /* renamed from: b  reason: collision with root package name */
        private float f25741b = -1.0f;

        f(List<? extends l3.a<T>> list) {
            this.f25740a = list.get(0);
        }

        @Override // e3.a.d
        public boolean a(float f10) {
            if (this.f25741b == f10) {
                return true;
            }
            this.f25741b = f10;
            return false;
        }

        @Override // e3.a.d
        public l3.a<T> b() {
            return this.f25740a;
        }

        @Override // e3.a.d
        public boolean c(float f10) {
            return !this.f25740a.h();
        }

        @Override // e3.a.d
        public float d() {
            return this.f25740a.b();
        }

        @Override // e3.a.d
        public float e() {
            return this.f25740a.e();
        }

        @Override // e3.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends l3.a<K>> list) {
        this.f25730c = n(list);
    }

    private float g() {
        if (this.f25734g == -1.0f) {
            this.f25734g = this.f25730c.e();
        }
        return this.f25734g;
    }

    private static <T> d<T> n(List<? extends l3.a<T>> list) {
        if (list.isEmpty()) {
            return new c();
        }
        if (list.size() == 1) {
            return new f(list);
        }
        return new e(list);
    }

    public void a(b bVar) {
        this.f25728a.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public l3.a<K> b() {
        com.airbnb.lottie.c.a("BaseKeyframeAnimation#getCurrentKeyframe");
        l3.a<K> b10 = this.f25730c.b();
        com.airbnb.lottie.c.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return b10;
    }

    float c() {
        if (this.f25735h == -1.0f) {
            this.f25735h = this.f25730c.d();
        }
        return this.f25735h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float d() {
        l3.a<K> b10 = b();
        if (b10.h()) {
            return 0.0f;
        }
        return b10.f30406d.getInterpolation(e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        if (this.f25729b) {
            return 0.0f;
        }
        l3.a<K> b10 = b();
        if (b10.h()) {
            return 0.0f;
        }
        return (this.f25731d - b10.e()) / (b10.b() - b10.e());
    }

    public float f() {
        return this.f25731d;
    }

    public A h() {
        float d10 = d();
        if (this.f25732e == null && this.f25730c.a(d10)) {
            return this.f25733f;
        }
        A i10 = i(b(), d10);
        this.f25733f = i10;
        return i10;
    }

    abstract A i(l3.a<K> aVar, float f10);

    public void j() {
        for (int i10 = 0; i10 < this.f25728a.size(); i10++) {
            this.f25728a.get(i10).b();
        }
    }

    public void k() {
        this.f25729b = true;
    }

    public void l(float f10) {
        if (!this.f25730c.isEmpty()) {
            if (f10 < g()) {
                f10 = g();
            } else if (f10 > c()) {
                f10 = c();
            }
            if (f10 != this.f25731d) {
                this.f25731d = f10;
                if (this.f25730c.c(f10)) {
                    j();
                }
            }
        }
    }

    public void m(l3.c<A> cVar) {
        l3.c<A> cVar2 = this.f25732e;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.f25732e = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}
