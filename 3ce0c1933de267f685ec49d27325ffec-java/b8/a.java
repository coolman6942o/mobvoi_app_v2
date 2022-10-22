package b8;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Class<? super T>> f5077a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<f> f5078b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5079c;

    /* renamed from: d  reason: collision with root package name */
    private final d<T> f5080d;

    /* renamed from: b8.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0071a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Set<Class<? super T>> f5081a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<f> f5082b;

        /* renamed from: c  reason: collision with root package name */
        private int f5083c;

        /* renamed from: d  reason: collision with root package name */
        private d<T> f5084d;

        private C0071a(Class<T> cls, Class<? super T>... clsArr) {
            HashSet hashSet = new HashSet();
            this.f5081a = hashSet;
            this.f5082b = new HashSet();
            this.f5083c = 0;
            q.b(cls, "Null interface");
            hashSet.add(cls);
            for (Class<? super T> cls2 : clsArr) {
                q.b(cls2, "Null interface");
            }
            Collections.addAll(this.f5081a, clsArr);
        }

        private final C0071a<T> e(int i10) {
            q.a(this.f5083c == 0, "Instantiation type has already been set.");
            this.f5083c = i10;
            return this;
        }

        public C0071a<T> a(f fVar) {
            q.b(fVar, "Null dependency");
            if (!this.f5081a.contains(fVar.b())) {
                this.f5082b.add(fVar);
                return this;
            }
            throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        }

        public C0071a<T> b() {
            return e(1);
        }

        public a<T> c() {
            q.a(this.f5084d != null, "Missing required property: factory.");
            return new a<>(new HashSet(this.f5081a), new HashSet(this.f5082b), this.f5083c, this.f5084d);
        }

        public C0071a<T> d(d<T> dVar) {
            this.f5084d = (d) q.b(dVar, "Null factory");
            return this;
        }
    }

    private a(Set<Class<? super T>> set, Set<f> set2, int i10, d<T> dVar) {
        this.f5077a = Collections.unmodifiableSet(set);
        this.f5078b = Collections.unmodifiableSet(set2);
        this.f5079c = i10;
        this.f5080d = dVar;
    }

    public static <T> C0071a<T> a(Class<T> cls) {
        return new C0071a<>(cls, new Class[0]);
    }

    public static <T> a<T> b(Class<T> cls, final T t10) {
        return a(cls).d(new d(t10) { // from class: b8.g

            /* renamed from: a  reason: collision with root package name */
            private final Object f5088a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f5088a = t10;
            }

            @Override // b8.d
            public final Object a(c cVar) {
                return this.f5088a;
            }
        }).c();
    }

    public final Set<Class<? super T>> c() {
        return this.f5077a;
    }

    public final Set<f> d() {
        return this.f5078b;
    }

    public final d<T> e() {
        return this.f5080d;
    }

    public final boolean f() {
        return this.f5079c == 1;
    }

    public final boolean g() {
        return this.f5079c == 2;
    }

    public final String toString() {
        return "Component<" + Arrays.toString(this.f5077a.toArray()) + ">{" + this.f5079c + ", deps=" + Arrays.toString(this.f5078b.toArray()) + "}";
    }
}
