package o5;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* compiled from: FactoryPools.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final g<Object> f31446a = new C0420a();

    /* compiled from: FactoryPools.java */
    /* renamed from: o5.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0420a implements g<Object> {
        C0420a() {
        }

        @Override // o5.a.g
        public void a(Object obj) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public class b implements d<List<T>> {
        b() {
        }

        /* renamed from: b */
        public List<T> a() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public class c implements g<List<T>> {
        c() {
        }

        /* renamed from: b */
        public void a(List<T> list) {
            list.clear();
        }
    }

    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public interface d<T> {
        T a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public static final class e<T> implements j0.e<T> {

        /* renamed from: a  reason: collision with root package name */
        private final d<T> f31447a;

        /* renamed from: b  reason: collision with root package name */
        private final g<T> f31448b;

        /* renamed from: c  reason: collision with root package name */
        private final j0.e<T> f31449c;

        e(j0.e<T> eVar, d<T> dVar, g<T> gVar) {
            this.f31449c = eVar;
            this.f31447a = dVar;
            this.f31448b = gVar;
        }

        @Override // j0.e
        public boolean a(T t10) {
            if (t10 instanceof f) {
                ((f) t10).f().b(true);
            }
            this.f31448b.a(t10);
            return this.f31449c.a(t10);
        }

        @Override // j0.e
        public T b() {
            T b10 = this.f31449c.b();
            if (b10 == null) {
                b10 = this.f31447a.a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + b10.getClass());
                }
            }
            if (b10 instanceof f) {
                ((f) b10).f().b(false);
            }
            return b10;
        }
    }

    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public interface f {
        o5.c f();
    }

    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public interface g<T> {
        void a(T t10);
    }

    private static <T extends f> j0.e<T> a(j0.e<T> eVar, d<T> dVar) {
        return b(eVar, dVar, c());
    }

    private static <T> j0.e<T> b(j0.e<T> eVar, d<T> dVar, g<T> gVar) {
        return new e(eVar, dVar, gVar);
    }

    private static <T> g<T> c() {
        return (g<T>) f31446a;
    }

    public static <T extends f> j0.e<T> d(int i10, d<T> dVar) {
        return a(new j0.g(i10), dVar);
    }

    public static <T> j0.e<List<T>> e() {
        return f(20);
    }

    public static <T> j0.e<List<T>> f(int i10) {
        return b(new j0.g(i10), new b(), new c());
    }
}
