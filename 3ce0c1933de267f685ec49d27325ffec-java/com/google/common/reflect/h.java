package com.google.common.reflect;

import com.google.common.base.k;
import com.google.common.base.m;
import com.google.common.base.p;
import com.google.common.base.s;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.h5;
import com.google.common.collect.p8;
import com.mobvoi.wear.lpa.LpaConstants;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Types.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final com.google.common.base.h<Type, String> f12384a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final k f12385b = k.g(", ").i(LpaConstants.VALUE_NULL);

    /* compiled from: Types.java */
    /* loaded from: classes.dex */
    class a implements com.google.common.base.h<Type, String> {
        a() {
        }

        /* renamed from: a */
        public String apply(Type type) {
            return e.CURRENT.d(type);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Types.java */
    /* loaded from: classes.dex */
    public class b extends com.google.common.reflect.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicReference f12386b;

        b(AtomicReference atomicReference) {
            this.f12386b = atomicReference;
        }

        @Override // com.google.common.reflect.g
        void b(Class<?> cls) {
            this.f12386b.set(cls.getComponentType());
        }

        @Override // com.google.common.reflect.g
        void c(GenericArrayType genericArrayType) {
            this.f12386b.set(genericArrayType.getGenericComponentType());
        }

        @Override // com.google.common.reflect.g
        void e(TypeVariable<?> typeVariable) {
            this.f12386b.set(h.q(typeVariable.getBounds()));
        }

        @Override // com.google.common.reflect.g
        void f(WildcardType wildcardType) {
            this.f12386b.set(h.q(wildcardType.getUpperBounds()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: Types.java */
    /* loaded from: classes.dex */
    public static abstract class c extends Enum<c> {
        public static final c OWNED_BY_ENCLOSING_CLASS = new a("OWNED_BY_ENCLOSING_CLASS", 0);
        public static final c LOCAL_CLASS_HAS_NO_OWNER = new C0158c("LOCAL_CLASS_HAS_NO_OWNER", 1);
        private static final /* synthetic */ c[] $VALUES = a();
        static final c JVM_BEHAVIOR = b();

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Types.java */
        /* loaded from: classes.dex */
        final class a extends c {
            a(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.reflect.h.c
            Class<?> c(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Types.java */
        /* loaded from: classes.dex */
        public class b<T> {
            b() {
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Types.java */
        /* renamed from: com.google.common.reflect.h$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        final class C0158c extends c {
            C0158c(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.reflect.h.c
            Class<?> c(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Types.java */
        /* loaded from: classes.dex */
        public class d extends b<String> {
            d() {
            }
        }

        private c(String str, int i10) {
        }

        private static /* synthetic */ c[] a() {
            return new c[]{OWNED_BY_ENCLOSING_CLASS, LOCAL_CLASS_HAS_NO_OWNER};
        }

        private static c b() {
            c[] values;
            new d();
            ParameterizedType parameterizedType = (ParameterizedType) d.class.getGenericSuperclass();
            for (c cVar : values()) {
                if (cVar.c(b.class) == parameterizedType.getOwnerType()) {
                    return cVar;
                }
            }
            throw new AssertionError();
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) $VALUES.clone();
        }

        abstract Class<?> c(Class<?> cls);

        /* synthetic */ c(String str, int i10, a aVar) {
            this(str, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Types.java */
    /* loaded from: classes.dex */
    public static final class d implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        d(Type type) {
            this.componentType = e.CURRENT.h(type);
        }

        public boolean equals(Object obj) {
            if (obj instanceof GenericArrayType) {
                return m.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return String.valueOf(h.t(this.componentType)).concat("[]");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: Types.java */
    /* loaded from: classes.dex */
    public static abstract class e extends Enum<e> {
        private static final /* synthetic */ e[] $VALUES = a();
        static final e CURRENT;
        public static final e JAVA6;
        public static final e JAVA7;
        public static final e JAVA8;
        public static final e JAVA9;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Types.java */
        /* loaded from: classes.dex */
        final class a extends e {
            a(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.reflect.h.e
            Type h(Type type) {
                p.o(type);
                if (!(type instanceof Class)) {
                    return type;
                }
                Class cls = (Class) type;
                return cls.isArray() ? new d(cls.getComponentType()) : type;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: i */
            public GenericArrayType c(Type type) {
                return new d(type);
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Types.java */
        /* loaded from: classes.dex */
        final class b extends e {
            b(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.reflect.h.e
            Type c(Type type) {
                if (type instanceof Class) {
                    return h.i((Class) type);
                }
                return new d(type);
            }

            @Override // com.google.common.reflect.h.e
            Type h(Type type) {
                return (Type) p.o(type);
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Types.java */
        /* loaded from: classes.dex */
        final class c extends e {
            c(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.reflect.h.e
            Type c(Type type) {
                return e.JAVA7.c(type);
            }

            @Override // com.google.common.reflect.h.e
            String d(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                } catch (IllegalAccessException e10) {
                    throw new RuntimeException(e10);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e11) {
                    throw new RuntimeException(e11);
                }
            }

            @Override // com.google.common.reflect.h.e
            Type h(Type type) {
                return e.JAVA7.h(type);
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Types.java */
        /* loaded from: classes.dex */
        final class d extends e {
            d(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.reflect.h.e
            boolean b() {
                return false;
            }

            @Override // com.google.common.reflect.h.e
            Type c(Type type) {
                return e.JAVA8.c(type);
            }

            @Override // com.google.common.reflect.h.e
            String d(Type type) {
                return e.JAVA8.d(type);
            }

            @Override // com.google.common.reflect.h.e
            Type h(Type type) {
                return e.JAVA8.h(type);
            }
        }

        /* compiled from: Types.java */
        /* renamed from: com.google.common.reflect.h$e$e  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0159e extends com.google.common.reflect.d<Map.Entry<String, int[][]>> {
            C0159e() {
            }
        }

        /* compiled from: Types.java */
        /* loaded from: classes.dex */
        class f extends com.google.common.reflect.d<int[]> {
            f() {
            }
        }

        static {
            a aVar = new a("JAVA6", 0);
            JAVA6 = aVar;
            b bVar = new b("JAVA7", 1);
            JAVA7 = bVar;
            c cVar = new c("JAVA8", 2);
            JAVA8 = cVar;
            d dVar = new d("JAVA9", 3);
            JAVA9 = dVar;
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                if (new C0159e().a().toString().contains("java.util.Map.java.util.Map")) {
                    CURRENT = cVar;
                } else {
                    CURRENT = dVar;
                }
            } else if (new f().a() instanceof Class) {
                CURRENT = bVar;
            } else {
                CURRENT = aVar;
            }
        }

        private e(String str, int i10) {
        }

        private static /* synthetic */ e[] a() {
            return new e[]{JAVA6, JAVA7, JAVA8, JAVA9};
        }

        public static e valueOf(String str) {
            return (e) Enum.valueOf(e.class, str);
        }

        public static e[] values() {
            return (e[]) $VALUES.clone();
        }

        boolean b() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Type c(Type type);

        String d(Type type) {
            return h.t(type);
        }

        final ImmutableList<Type> g(Type[] typeArr) {
            ImmutableList.b builder = ImmutableList.builder();
            for (Type type : typeArr) {
                builder.a(h(type));
            }
            return builder.h();
        }

        abstract Type h(Type type);

        /* synthetic */ e(String str, int i10, a aVar) {
            this(str, i10);
        }
    }

    /* compiled from: Types.java */
    /* loaded from: classes.dex */
    static final class f<X> {

        /* renamed from: a  reason: collision with root package name */
        static final boolean f12387a = !f.class.getTypeParameters()[0].equals(h.l(f.class, "X", new Type[0]));

        f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Types.java */
    /* loaded from: classes.dex */
    public static final class g implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> argumentsList;
        private final Type ownerType;
        private final Class<?> rawType;

        g(Type type, Class<?> cls, Type[] typeArr) {
            p.o(cls);
            p.d(typeArr.length == cls.getTypeParameters().length);
            h.g(typeArr, "type parameter");
            this.ownerType = type;
            this.rawType = cls;
            this.argumentsList = e.CURRENT.g(typeArr);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            return getRawType().equals(parameterizedType.getRawType()) && m.a(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return h.s(this.argumentsList);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            Type type = this.ownerType;
            return ((type == null ? 0 : type.hashCode()) ^ this.argumentsList.hashCode()) ^ this.rawType.hashCode();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            if (this.ownerType != null) {
                e eVar = e.CURRENT;
                if (eVar.b()) {
                    sb2.append(eVar.d(this.ownerType));
                    sb2.append('.');
                }
            }
            sb2.append(this.rawType.getName());
            sb2.append('<');
            sb2.append(h.f12385b.c(h5.n(this.argumentsList, h.f12384a)));
            sb2.append('>');
            return sb2.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Types.java */
    /* renamed from: com.google.common.reflect.h$h  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0160h<D extends GenericDeclaration> {

        /* renamed from: a  reason: collision with root package name */
        private final D f12388a;

        /* renamed from: b  reason: collision with root package name */
        private final String f12389b;

        /* renamed from: c  reason: collision with root package name */
        private final ImmutableList<Type> f12390c;

        C0160h(D d10, String str, Type[] typeArr) {
            h.g(typeArr, "bound for type variable");
            this.f12388a = (D) p.o(d10);
            this.f12389b = (String) p.o(str);
            this.f12390c = ImmutableList.copyOf(typeArr);
        }

        public D a() {
            return this.f12388a;
        }

        public String b() {
            return this.f12389b;
        }

        public boolean equals(Object obj) {
            if (f.f12387a) {
                if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof i)) {
                    return false;
                }
                C0160h hVar = ((i) Proxy.getInvocationHandler(obj)).f12392a;
                return this.f12389b.equals(hVar.b()) && this.f12388a.equals(hVar.a()) && this.f12390c.equals(hVar.f12390c);
            } else if (!(obj instanceof TypeVariable)) {
                return false;
            } else {
                TypeVariable typeVariable = (TypeVariable) obj;
                return this.f12389b.equals(typeVariable.getName()) && this.f12388a.equals(typeVariable.getGenericDeclaration());
            }
        }

        public int hashCode() {
            return this.f12388a.hashCode() ^ this.f12389b.hashCode();
        }

        public String toString() {
            return this.f12389b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Types.java */
    /* loaded from: classes.dex */
    public static final class i implements InvocationHandler {

        /* renamed from: b  reason: collision with root package name */
        private static final ImmutableMap<String, Method> f12391b;

        /* renamed from: a  reason: collision with root package name */
        private final C0160h<?> f12392a;

        static {
            Method[] methods;
            ImmutableMap.b builder = ImmutableMap.builder();
            for (Method method : C0160h.class.getMethods()) {
                if (method.getDeclaringClass().equals(C0160h.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    builder.d(method.getName(), method);
                }
            }
            f12391b = builder.a();
        }

        i(C0160h<?> hVar) {
            this.f12392a = hVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Method method2 = f12391b.get(name);
            if (method2 != null) {
                try {
                    return method2.invoke(this.f12392a, objArr);
                } catch (InvocationTargetException e10) {
                    throw e10.getCause();
                }
            } else {
                throw new UnsupportedOperationException(name);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Types.java */
    /* loaded from: classes.dex */
    public static final class j implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> lowerBounds;
        private final ImmutableList<Type> upperBounds;

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(Type[] typeArr, Type[] typeArr2) {
            h.g(typeArr, "lower bound for wildcard");
            h.g(typeArr2, "upper bound for wildcard");
            e eVar = e.CURRENT;
            this.lowerBounds = eVar.g(typeArr);
            this.upperBounds = eVar.g(typeArr2);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) obj;
            return this.lowerBounds.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.upperBounds.equals(Arrays.asList(wildcardType.getUpperBounds()));
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return h.s(this.lowerBounds);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return h.s(this.upperBounds);
        }

        public int hashCode() {
            return this.lowerBounds.hashCode() ^ this.upperBounds.hashCode();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("?");
            p8<Type> it = this.lowerBounds.iterator();
            while (it.hasNext()) {
                sb2.append(" super ");
                sb2.append(e.CURRENT.d(it.next()));
            }
            for (Type type : h.h(this.upperBounds)) {
                sb2.append(" extends ");
                sb2.append(e.CURRENT.d(type));
            }
            return sb2.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Type[] typeArr, String str) {
        Class cls;
        for (Type type : typeArr) {
            if (type instanceof Class) {
                p.k(!cls.isPrimitive(), "Primitive type '%s' used as %s", (Class) type, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Iterable<Type> h(Iterable<Type> iterable) {
        return h5.d(iterable, s.f(s.c(Object.class)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> i(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type j(Type type) {
        p.o(type);
        AtomicReference atomicReference = new AtomicReference();
        new b(atomicReference).a(type);
        return (Type) atomicReference.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type k(Type type) {
        if (!(type instanceof WildcardType)) {
            return e.CURRENT.c(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        boolean z10 = true;
        p.e(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return r(k(lowerBounds[0]));
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length != 1) {
            z10 = false;
        }
        p.e(z10, "Wildcard should have only one upper bound.");
        return p(k(upperBounds[0]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <D extends GenericDeclaration> TypeVariable<D> l(D d10, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return o(d10, str, typeArr);
    }

    static ParameterizedType m(Class<?> cls, Type... typeArr) {
        return new g(c.JVM_BEHAVIOR.c(cls), cls, typeArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ParameterizedType n(Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return m(cls, typeArr);
        }
        p.o(typeArr);
        p.j(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new g(type, cls, typeArr);
    }

    private static <D extends GenericDeclaration> TypeVariable<D> o(D d10, String str, Type[] typeArr) {
        return (TypeVariable) com.google.common.reflect.c.a(TypeVariable.class, new i(new C0160h(d10, str, typeArr)));
    }

    static WildcardType p(Type type) {
        return new j(new Type[0], new Type[]{type});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Type q(Type[] typeArr) {
        for (Type type : typeArr) {
            Type j10 = j(type);
            if (j10 != null) {
                if (j10 instanceof Class) {
                    Class cls = (Class) j10;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return p(j10);
            }
        }
        return null;
    }

    static WildcardType r(Type type) {
        return new j(new Type[]{type}, new Type[]{Object.class});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Type[] s(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String t(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
