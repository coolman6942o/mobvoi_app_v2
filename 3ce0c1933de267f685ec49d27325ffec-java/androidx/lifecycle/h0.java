package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: ViewModelProvider.kt */
/* loaded from: classes.dex */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    private final i0 f3315a;

    /* renamed from: b  reason: collision with root package name */
    private final b f3316b;

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public static class a extends d {

        /* renamed from: d  reason: collision with root package name */
        public static final C0033a f3317d = new C0033a(null);

        /* renamed from: e  reason: collision with root package name */
        private static a f3318e;

        /* renamed from: c  reason: collision with root package name */
        private final Application f3319c;

        /* compiled from: ViewModelProvider.kt */
        /* renamed from: androidx.lifecycle.h0$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0033a {
            private C0033a() {
            }

            public /* synthetic */ C0033a(f fVar) {
                this();
            }

            public final b a(j0 owner) {
                i.f(owner, "owner");
                if (!(owner instanceof j)) {
                    return d.f3320a.a();
                }
                b defaultViewModelProviderFactory = ((j) owner).getDefaultViewModelProviderFactory();
                i.e(defaultViewModelProviderFactory, "owner.defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }

            public final a b(Application application) {
                i.f(application, "application");
                if (a.f3318e == null) {
                    a.f3318e = new a(application);
                }
                a aVar = a.f3318e;
                i.d(aVar);
                return aVar;
            }
        }

        public a(Application application) {
            i.f(application, "application");
            this.f3319c = application;
        }

        public static final a g(Application application) {
            return f3317d.b(application);
        }

        @Override // androidx.lifecycle.h0.d, androidx.lifecycle.h0.b
        public <T extends f0> T a(Class<T> modelClass) {
            i.f(modelClass, "modelClass");
            if (!androidx.lifecycle.b.class.isAssignableFrom(modelClass)) {
                return (T) super.a(modelClass);
            }
            try {
                T newInstance = modelClass.getConstructor(Application.class).newInstance(this.f3319c);
                i.e(newInstance, "{\n                try {\n…          }\n            }");
                return newInstance;
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(i.n("Cannot create an instance of ", modelClass), e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException(i.n("Cannot create an instance of ", modelClass), e11);
            } catch (NoSuchMethodException e12) {
                throw new RuntimeException(i.n("Cannot create an instance of ", modelClass), e12);
            } catch (InvocationTargetException e13) {
                throw new RuntimeException(i.n("Cannot create an instance of ", modelClass), e13);
            }
        }
    }

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public interface b {
        <T extends f0> T a(Class<T> cls);
    }

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public static abstract class c extends e implements b {
        public <T extends f0> T a(Class<T> modelClass) {
            i.f(modelClass, "modelClass");
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementations of KeyedFactory");
        }

        public abstract <T extends f0> T c(String str, Class<T> cls);
    }

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public static class d implements b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f3320a = new a(null);

        /* renamed from: b  reason: collision with root package name */
        private static d f3321b;

        /* compiled from: ViewModelProvider.kt */
        /* loaded from: classes.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }

            public final d a() {
                if (d.f3321b == null) {
                    d.f3321b = new d();
                }
                d dVar = d.f3321b;
                i.d(dVar);
                return dVar;
            }
        }

        public static final d d() {
            return f3320a.a();
        }

        @Override // androidx.lifecycle.h0.b
        public <T extends f0> T a(Class<T> modelClass) {
            i.f(modelClass, "modelClass");
            try {
                T newInstance = modelClass.newInstance();
                i.e(newInstance, "{\n                modelC…wInstance()\n            }");
                return newInstance;
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(i.n("Cannot create an instance of ", modelClass), e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException(i.n("Cannot create an instance of ", modelClass), e11);
            }
        }
    }

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public static class e {
        public void b(f0 viewModel) {
            i.f(viewModel, "viewModel");
        }
    }

    public h0(i0 store, b factory) {
        i.f(store, "store");
        i.f(factory, "factory");
        this.f3315a = store;
        this.f3316b = factory;
    }

    public <T extends f0> T a(Class<T> modelClass) {
        i.f(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return (T) b(i.n("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName), modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends f0> T b(String key, Class<T> modelClass) {
        T viewModel;
        i.f(key, "key");
        i.f(modelClass, "modelClass");
        T viewModel2 = (T) this.f3315a.b(key);
        if (modelClass.isInstance(viewModel2)) {
            b bVar = this.f3316b;
            e eVar = bVar instanceof e ? (e) bVar : null;
            if (eVar != null) {
                i.e(viewModel2, "viewModel");
                eVar.b(viewModel2);
            }
            Objects.requireNonNull(viewModel2, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return viewModel2;
        }
        b bVar2 = this.f3316b;
        if (bVar2 instanceof c) {
            viewModel = (T) ((c) bVar2).c(key, modelClass);
        } else {
            viewModel = (T) bVar2.a(modelClass);
        }
        this.f3315a.d(key, viewModel);
        i.e(viewModel, "viewModel");
        return viewModel;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h0(j0 owner) {
        this(r0, a.f3317d.a(owner));
        i.f(owner, "owner");
        i0 viewModelStore = owner.getViewModelStore();
        i.e(viewModelStore, "owner.viewModelStore");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h0(j0 owner, b factory) {
        this(r2, factory);
        i.f(owner, "owner");
        i.f(factory, "factory");
        i0 viewModelStore = owner.getViewModelStore();
        i.e(viewModelStore, "owner.viewModelStore");
    }
}
