package com.google.gson.internal;

import com.google.gson.JsonIOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
/* compiled from: ConstructorConstructor.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Type, com.google.gson.g<?>> f12616a;

    /* renamed from: b  reason: collision with root package name */
    private final k8.b f12617b = k8.b.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class a implements com.google.gson.internal.g<T> {
        a(c cVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.concurrent.ConcurrentHashMap] */
        @Override // com.google.gson.internal.g
        public T a() {
            return new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class b implements com.google.gson.internal.g<T> {
        b(c cVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.TreeMap, T] */
        @Override // com.google.gson.internal.g
        public T a() {
            return new TreeMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.internal.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0164c implements com.google.gson.internal.g<T> {
        C0164c(c cVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, T] */
        @Override // com.google.gson.internal.g
        public T a() {
            return new LinkedHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class d implements com.google.gson.internal.g<T> {
        d(c cVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, com.google.gson.internal.LinkedTreeMap] */
        @Override // com.google.gson.internal.g
        public T a() {
            return new LinkedTreeMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class e implements com.google.gson.internal.g<T> {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.gson.internal.k f12618a = com.google.gson.internal.k.b();

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f12619b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Type f12620c;

        e(c cVar, Class cls, Type type) {
            this.f12619b = cls;
            this.f12620c = type;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
        @Override // com.google.gson.internal.g
        public T a() {
            try {
                return this.f12618a.c(this.f12619b);
            } catch (Exception e10) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.f12620c + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e10);
            }
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    class f implements com.google.gson.internal.g<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.gson.g f12621a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Type f12622b;

        f(c cVar, com.google.gson.g gVar, Type type) {
            this.f12621a = gVar;
            this.f12622b = type;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // com.google.gson.internal.g
        public T a() {
            return this.f12621a.a(this.f12622b);
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    class g implements com.google.gson.internal.g<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.gson.g f12623a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Type f12624b;

        g(c cVar, com.google.gson.g gVar, Type type) {
            this.f12623a = gVar;
            this.f12624b = type;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // com.google.gson.internal.g
        public T a() {
            return this.f12623a.a(this.f12624b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class h implements com.google.gson.internal.g<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Constructor f12625a;

        h(c cVar, Constructor constructor) {
            this.f12625a = constructor;
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [T, java.lang.Object] */
        @Override // com.google.gson.internal.g
        public T a() {
            try {
                return this.f12625a.newInstance(null);
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Failed to invoke " + this.f12625a + " with no args", e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("Failed to invoke " + this.f12625a + " with no args", e12.getTargetException());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class i implements com.google.gson.internal.g<T> {
        i(c cVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.TreeSet] */
        @Override // com.google.gson.internal.g
        public T a() {
            return new TreeSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class j implements com.google.gson.internal.g<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Type f12626a;

        j(c cVar, Type type) {
            this.f12626a = type;
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [T, java.util.EnumSet] */
        @Override // com.google.gson.internal.g
        public T a() {
            Type type = this.f12626a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new JsonIOException("Invalid EnumSet type: " + this.f12626a.toString());
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.f12626a.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class k implements com.google.gson.internal.g<T> {
        k(c cVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.LinkedHashSet] */
        @Override // com.google.gson.internal.g
        public T a() {
            return new LinkedHashSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class l implements com.google.gson.internal.g<T> {
        l(c cVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayDeque] */
        @Override // com.google.gson.internal.g
        public T a() {
            return new ArrayDeque();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class m implements com.google.gson.internal.g<T> {
        m(c cVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayList] */
        @Override // com.google.gson.internal.g
        public T a() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class n implements com.google.gson.internal.g<T> {
        n(c cVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.ConcurrentSkipListMap, T] */
        @Override // com.google.gson.internal.g
        public T a() {
            return new ConcurrentSkipListMap();
        }
    }

    public c(Map<Type, com.google.gson.g<?>> map) {
        this.f12616a = map;
    }

    private <T> com.google.gson.internal.g<T> b(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f12617b.b(declaredConstructor);
            }
            return new h(this, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> com.google.gson.internal.g<T> c(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new i(this);
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new j(this, type);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new k(this);
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new l(this);
            }
            return new m(this);
        } else if (!Map.class.isAssignableFrom(cls)) {
            return null;
        } else {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new n(this);
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new a(this);
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new b(this);
            }
            if (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(com.google.gson.reflect.a.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                return new d(this);
            }
            return new C0164c(this);
        }
    }

    private <T> com.google.gson.internal.g<T> d(Type type, Class<? super T> cls) {
        return new e(this, cls, type);
    }

    public <T> com.google.gson.internal.g<T> a(com.google.gson.reflect.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        com.google.gson.g<?> gVar = this.f12616a.get(type);
        if (gVar != null) {
            return new f(this, gVar, type);
        }
        com.google.gson.g<?> gVar2 = this.f12616a.get(rawType);
        if (gVar2 != null) {
            return new g(this, gVar2, type);
        }
        com.google.gson.internal.g<T> b10 = b(rawType);
        if (b10 != null) {
            return b10;
        }
        com.google.gson.internal.g<T> c10 = c(type, rawType);
        return c10 != null ? c10 : d(type, rawType);
    }

    public String toString() {
        return this.f12616a.toString();
    }
}
