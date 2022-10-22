package com.google.common.reflect;

import com.google.common.base.k;
import com.google.common.base.p;
import com.google.common.base.q;
import com.google.common.base.r;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.l3;
import com.google.common.collect.p8;
import com.google.common.collect.q6;
import com.google.common.collect.t3;
import com.google.common.collect.w5;
import com.google.common.reflect.b;
import com.google.common.reflect.h;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class TypeToken<T> extends com.google.common.reflect.d<T> implements Serializable {
    private static final long serialVersionUID = 3637540370352322684L;
    private transient com.google.common.reflect.f covariantTypeResolver;
    private transient com.google.common.reflect.f invariantTypeResolver;
    private final Type runtimeType;

    /* loaded from: classes.dex */
    public class TypeSet extends t3<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;
        private transient ImmutableSet<TypeToken<? super T>> types;

        TypeSet() {
        }

        public TypeToken<T>.TypeSet classes() {
            return new e(TypeToken.this, null);
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new f(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.t3
        /* renamed from: l */
        public Set<TypeToken<? super T>> b() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.types;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> f10 = l3.d(h.f12363a.d(TypeToken.this)).c(i.IGNORE_TYPE_VARIABLE_OR_WILDCARD).f();
            this.types = f10;
            return f10;
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) h.f12364b.c(TypeToken.this.v()));
        }
    }

    /* loaded from: classes.dex */
    class a extends b.C0157b<T> {
        a(Method method) {
            super(method);
        }

        @Override // com.google.common.reflect.a
        public TypeToken<T> a() {
            return TypeToken.this;
        }

        @Override // com.google.common.reflect.a
        public String toString() {
            String valueOf = String.valueOf(a());
            String bVar = super.toString();
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + String.valueOf(bVar).length());
            sb2.append(valueOf);
            sb2.append(".");
            sb2.append(bVar);
            return sb2.toString();
        }
    }

    /* loaded from: classes.dex */
    class b extends b.a<T> {
        b(Constructor constructor) {
            super(constructor);
        }

        @Override // com.google.common.reflect.a
        public TypeToken<T> a() {
            return TypeToken.this;
        }

        @Override // com.google.common.reflect.b.a
        Type[] b() {
            return TypeToken.this.t().l(super.b());
        }

        @Override // com.google.common.reflect.a
        public String toString() {
            String valueOf = String.valueOf(a());
            String e10 = k.g(", ").e(b());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 2 + String.valueOf(e10).length());
            sb2.append(valueOf);
            sb2.append("(");
            sb2.append(e10);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends com.google.common.reflect.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ImmutableSet.a f12360b;

        c(TypeToken typeToken, ImmutableSet.a aVar) {
            this.f12360b = aVar;
        }

        @Override // com.google.common.reflect.g
        void b(Class<?> cls) {
            this.f12360b.a(cls);
        }

        @Override // com.google.common.reflect.g
        void c(GenericArrayType genericArrayType) {
            this.f12360b.a(com.google.common.reflect.h.i(TypeToken.of(genericArrayType.getGenericComponentType()).getRawType()));
        }

        @Override // com.google.common.reflect.g
        void d(ParameterizedType parameterizedType) {
            this.f12360b.a((Class) parameterizedType.getRawType());
        }

        @Override // com.google.common.reflect.g
        void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.common.reflect.g
        void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private final Type[] f12361a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f12362b;

        d(Type[] typeArr, boolean z10) {
            this.f12361a = typeArr;
            this.f12362b = z10;
        }

        boolean a(Type type) {
            for (Type type2 : this.f12361a) {
                boolean isSubtypeOf = TypeToken.of(type2).isSubtypeOf(type);
                boolean z10 = this.f12362b;
                if (isSubtypeOf == z10) {
                    return z10;
                }
            }
            return !this.f12362b;
        }

        boolean b(Type type) {
            TypeToken<?> of2 = TypeToken.of(type);
            for (Type type2 : this.f12361a) {
                boolean isSubtypeOf = of2.isSubtypeOf(type2);
                boolean z10 = this.f12362b;
                if (isSubtypeOf == z10) {
                    return z10;
                }
            }
            return !this.f12362b;
        }
    }

    /* loaded from: classes.dex */
    private final class e extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        private transient ImmutableSet<TypeToken<? super T>> classes;

        private e() {
            super();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.t3
        /* renamed from: l */
        public Set<TypeToken<? super T>> b() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.classes;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> f10 = l3.d(h.f12363a.a().d(TypeToken.this)).c(i.IGNORE_TYPE_VARIABLE_OR_WILDCARD).f();
            this.classes = f10;
            return f10;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) h.f12364b.a().c(TypeToken.this.v()));
        }

        /* synthetic */ e(TypeToken typeToken, a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private final class f extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        private final transient TypeToken<T>.TypeSet allTypes;
        private transient ImmutableSet<TypeToken<? super T>> interfaces;

        /* loaded from: classes.dex */
        class a implements r<Class<?>> {
            a(f fVar) {
            }

            /* renamed from: a */
            public boolean apply(Class<?> cls) {
                return cls.isInterface();
            }

            @Override // com.google.common.base.r, java.util.function.Predicate
            public /* synthetic */ boolean test(Object obj) {
                return q.a(this, obj);
            }
        }

        f(TypeToken<T>.TypeSet typeSet) {
            super();
            this.allTypes = typeSet;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.t3
        /* renamed from: l */
        public Set<TypeToken<? super T>> b() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.interfaces;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> f10 = l3.d(this.allTypes).c(i.INTERFACE_ONLY).f();
            this.interfaces = f10;
            return f10;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return l3.d(h.f12364b.c(TypeToken.this.v())).c(new a(this)).f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class g<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        g(Type type) {
            super(type, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class h<K> {

        /* renamed from: a  reason: collision with root package name */
        static final h<TypeToken<?>> f12363a = new a();

        /* renamed from: b  reason: collision with root package name */
        static final h<Class<?>> f12364b = new b();

        /* loaded from: classes.dex */
        class a extends h<TypeToken<?>> {
            a() {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: i */
            public Iterable<? extends TypeToken<?>> e(TypeToken<?> typeToken) {
                return typeToken.r();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: j */
            public Class<?> f(TypeToken<?> typeToken) {
                return typeToken.getRawType();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: k */
            public TypeToken<?> g(TypeToken<?> typeToken) {
                return typeToken.s();
            }
        }

        /* loaded from: classes.dex */
        class b extends h<Class<?>> {
            b() {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: i */
            public Iterable<? extends Class<?>> e(Class<?> cls) {
                return Arrays.asList(cls.getInterfaces());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: j */
            public Class<?> f(Class<?> cls) {
                return cls;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: k */
            public Class<?> g(Class<?> cls) {
                return cls.getSuperclass();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class c extends e<K> {
            c(h hVar, h hVar2) {
                super(hVar2);
            }

            @Override // com.google.common.reflect.TypeToken.h
            ImmutableList<K> c(Iterable<? extends K> iterable) {
                ImmutableList.b builder = ImmutableList.builder();
                for (K k10 : iterable) {
                    if (!f(k10).isInterface()) {
                        builder.a(k10);
                    }
                }
                return super.c(builder.h());
            }

            @Override // com.google.common.reflect.TypeToken.h
            Iterable<? extends K> e(K k10) {
                return ImmutableSet.of();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class d extends q6<K> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Comparator f12365a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Map f12366b;

            d(Comparator comparator, Map map) {
                this.f12365a = comparator;
                this.f12366b = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.q6, java.util.Comparator
            public int compare(K k10, K k11) {
                return this.f12365a.compare(this.f12366b.get(k10), this.f12366b.get(k11));
            }
        }

        /* loaded from: classes.dex */
        private static class e<K> extends h<K> {

            /* renamed from: c  reason: collision with root package name */
            private final h<K> f12367c;

            e(h<K> hVar) {
                super(null);
                this.f12367c = hVar;
            }

            @Override // com.google.common.reflect.TypeToken.h
            Class<?> f(K k10) {
                return this.f12367c.f(k10);
            }

            @Override // com.google.common.reflect.TypeToken.h
            K g(K k10) {
                return this.f12367c.g(k10);
            }
        }

        private h() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        private int b(K k10, Map<? super K, Integer> map) {
            Integer num = map.get(k10);
            if (num != null) {
                return num.intValue();
            }
            boolean isInterface = f(k10).isInterface();
            int i10 = isInterface;
            for (K k11 : e(k10)) {
                i10 = Math.max(i10, b(k11, map));
            }
            K g10 = g(k10);
            int i11 = i10;
            if (g10 != null) {
                i11 = Math.max(i10, b(g10, map));
            }
            int i12 = i11 + 1;
            map.put(k10, Integer.valueOf(i12));
            return i12;
        }

        private static <K, V> ImmutableList<K> h(Map<K, V> map, Comparator<? super V> comparator) {
            return (ImmutableList<K>) new d(comparator, map).b(map.keySet());
        }

        final h<K> a() {
            return new c(this, this);
        }

        ImmutableList<K> c(Iterable<? extends K> iterable) {
            HashMap k10 = w5.k();
            for (K k11 : iterable) {
                b(k11, k10);
            }
            return h(k10, q6.g().j());
        }

        final ImmutableList<K> d(K k10) {
            return c(ImmutableList.of(k10));
        }

        abstract Iterable<? extends K> e(K k10);

        abstract Class<?> f(K k10);

        abstract K g(K k10);

        /* synthetic */ h(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: classes.dex */
    public static abstract class i extends Enum<i> implements r<TypeToken<?>> {
        public static final i IGNORE_TYPE_VARIABLE_OR_WILDCARD = new a("IGNORE_TYPE_VARIABLE_OR_WILDCARD", 0);
        public static final i INTERFACE_ONLY = new b("INTERFACE_ONLY", 1);
        private static final /* synthetic */ i[] $VALUES = a();

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes.dex */
        final class a extends i {
            a(String str, int i10) {
                super(str, i10, null);
            }

            /* renamed from: b */
            public boolean apply(TypeToken<?> typeToken) {
                return !(((TypeToken) typeToken).runtimeType instanceof TypeVariable) && !(((TypeToken) typeToken).runtimeType instanceof WildcardType);
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes.dex */
        final class b extends i {
            b(String str, int i10) {
                super(str, i10, null);
            }

            /* renamed from: b */
            public boolean apply(TypeToken<?> typeToken) {
                return typeToken.getRawType().isInterface();
            }
        }

        private i(String str, int i10) {
        }

        private static /* synthetic */ i[] a() {
            return new i[]{IGNORE_TYPE_VARIABLE_OR_WILDCARD, INTERFACE_ONLY};
        }

        public static i valueOf(String str) {
            return (i) Enum.valueOf(i.class, str);
        }

        public static i[] values() {
            return (i[]) $VALUES.clone();
        }

        @Override // com.google.common.base.r, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return q.a(this, obj);
        }

        /* synthetic */ i(String str, int i10, a aVar) {
            this(str, i10);
        }
    }

    /* synthetic */ TypeToken(Type type, a aVar) {
        this(type);
    }

    private boolean A(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (!cls.isArray()) {
                return false;
            }
            return of((Class) cls.getComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
        } else if (type instanceof GenericArrayType) {
            return of(((GenericArrayType) type).getGenericComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
        } else {
            return false;
        }
    }

    private boolean B(ParameterizedType parameterizedType) {
        Class<? super Object> rawType = of(parameterizedType).getRawType();
        if (!H(rawType)) {
            return false;
        }
        TypeVariable<Class<? super Object>>[] typeParameters = rawType.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i10 = 0; i10 < typeParameters.length; i10++) {
            if (!of(q().j(typeParameters[i10])).y(actualTypeArguments[i10], typeParameters[i10])) {
                return false;
            }
        }
        return Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers()) || parameterizedType.getOwnerType() == null || z(parameterizedType.getOwnerType());
    }

    private boolean C(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (!cls.isArray()) {
                return cls.isAssignableFrom(Object[].class);
            }
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(cls.getComponentType());
        } else if (type instanceof GenericArrayType) {
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(((GenericArrayType) this.runtimeType).getGenericComponentType());
        } else {
            return false;
        }
    }

    private boolean D() {
        return com.google.common.primitives.g.b().contains(this.runtimeType);
    }

    private static Type E(Type type) {
        return h.e.JAVA7.c(type);
    }

    private TypeToken<?> F(Type type) {
        TypeToken<?> of2 = of(q().j(type));
        of2.covariantTypeResolver = this.covariantTypeResolver;
        of2.invariantTypeResolver = this.invariantTypeResolver;
        return of2;
    }

    private Type G(Class<?> cls) {
        if ((this.runtimeType instanceof Class) && (cls.getTypeParameters().length == 0 || getRawType().getTypeParameters().length != 0)) {
            return cls;
        }
        TypeToken I = I(cls);
        return new com.google.common.reflect.f().n(I.getSupertype(getRawType()).runtimeType, this.runtimeType).j(I.runtimeType);
    }

    private boolean H(Class<?> cls) {
        p8<Class<? super T>> it = v().iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(it.next())) {
                return true;
            }
        }
        return false;
    }

    static <T> TypeToken<? extends T> I(Class<T> cls) {
        if (cls.isArray()) {
            return (TypeToken<? extends T>) of(com.google.common.reflect.h.k(I(cls.getComponentType()).runtimeType));
        }
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type type = (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? null : I(cls.getEnclosingClass()).runtimeType;
        if (typeParameters.length > 0 || (type != null && type != cls.getEnclosingClass())) {
            return (TypeToken<? extends T>) of(com.google.common.reflect.h.n(type, cls, typeParameters));
        }
        return of((Class) cls);
    }

    private static d g(Type[] typeArr) {
        return new d(typeArr, true);
    }

    private TypeToken<? super T> h(Type type) {
        TypeToken<? super T> typeToken = (TypeToken<? super T>) of(type);
        if (typeToken.getRawType().isInterface()) {
            return null;
        }
        return typeToken;
    }

    private ImmutableList<TypeToken<? super T>> i(Type[] typeArr) {
        ImmutableList.b builder = ImmutableList.builder();
        for (Type type : typeArr) {
            TypeToken<?> of2 = of(type);
            if (of2.getRawType().isInterface()) {
                builder.a(of2);
            }
        }
        return builder.h();
    }

    private static Type j(TypeVariable<?> typeVariable, Type type) {
        if (type instanceof WildcardType) {
            return k(typeVariable, (WildcardType) type);
        }
        return m(type);
    }

    private static WildcardType k(TypeVariable<?> typeVariable, WildcardType wildcardType) {
        Type[] upperBounds;
        Type[] bounds = typeVariable.getBounds();
        ArrayList arrayList = new ArrayList();
        for (Type type : wildcardType.getUpperBounds()) {
            if (!g(bounds).a(type)) {
                arrayList.add(m(type));
            }
        }
        return new h.j(wildcardType.getLowerBounds(), (Type[]) arrayList.toArray(new Type[0]));
    }

    private static ParameterizedType l(ParameterizedType parameterizedType) {
        Class cls = (Class) parameterizedType.getRawType();
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i10 = 0; i10 < actualTypeArguments.length; i10++) {
            actualTypeArguments[i10] = j(typeParameters[i10], actualTypeArguments[i10]);
        }
        return com.google.common.reflect.h.n(parameterizedType.getOwnerType(), cls, actualTypeArguments);
    }

    private static Type m(Type type) {
        if (type instanceof ParameterizedType) {
            return l((ParameterizedType) type);
        }
        return type instanceof GenericArrayType ? com.google.common.reflect.h.k(m(((GenericArrayType) type).getGenericComponentType())) : type;
    }

    private static d n(Type[] typeArr) {
        return new d(typeArr, false);
    }

    private TypeToken<? extends T> o(Class<?> cls) {
        return (TypeToken<? extends T>) of(E(getComponentType().getSubtype(cls.getComponentType()).runtimeType));
    }

    public static <T> TypeToken<T> of(Class<T> cls) {
        return new g(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeToken<? super T> p(Class<? super T> cls) {
        return (TypeToken<? super T>) of(E(((TypeToken) p.q(getComponentType(), "%s isn't a super type of %s", cls, this)).getSupertype(cls.getComponentType()).runtimeType));
    }

    private com.google.common.reflect.f q() {
        com.google.common.reflect.f fVar = this.covariantTypeResolver;
        if (fVar != null) {
            return fVar;
        }
        com.google.common.reflect.f d10 = com.google.common.reflect.f.d(this.runtimeType);
        this.covariantTypeResolver = d10;
        return d10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.common.reflect.f t() {
        com.google.common.reflect.f fVar = this.invariantTypeResolver;
        if (fVar != null) {
            return fVar;
        }
        com.google.common.reflect.f f10 = com.google.common.reflect.f.f(this.runtimeType);
        this.invariantTypeResolver = f10;
        return f10;
    }

    private Type u() {
        Type type = this.runtimeType;
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType) type).getOwnerType();
        }
        if (type instanceof Class) {
            return ((Class) type).getEnclosingClass();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImmutableSet<Class<? super T>> v() {
        ImmutableSet.a builder = ImmutableSet.builder();
        new c(this, builder).a(this.runtimeType);
        return builder.g();
    }

    private TypeToken<? extends T> w(Class<?> cls, Type[] typeArr) {
        if (typeArr.length > 0) {
            return (TypeToken<? extends T>) of(typeArr[0]).getSubtype(cls);
        }
        String valueOf = String.valueOf(cls);
        String valueOf2 = String.valueOf(this);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 21 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append(" isn't a subclass of ");
        sb2.append(valueOf2);
        throw new IllegalArgumentException(sb2.toString());
    }

    private TypeToken<? super T> x(Class<? super T> cls, Type[] typeArr) {
        for (Type type : typeArr) {
            TypeToken<?> of2 = of(type);
            if (of2.isSubtypeOf(cls)) {
                return (TypeToken<? super T>) of2.getSupertype(cls);
            }
        }
        String valueOf = String.valueOf(cls);
        String valueOf2 = String.valueOf(this);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 23 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append(" isn't a super type of ");
        sb2.append(valueOf2);
        throw new IllegalArgumentException(sb2.toString());
    }

    private boolean y(Type type, TypeVariable<?> typeVariable) {
        if (this.runtimeType.equals(type)) {
            return true;
        }
        if (!(type instanceof WildcardType)) {
            return m(this.runtimeType).equals(m(type));
        }
        WildcardType k10 = k(typeVariable, (WildcardType) type);
        return n(k10.getUpperBounds()).b(this.runtimeType) && n(k10.getLowerBounds()).a(this.runtimeType);
    }

    private boolean z(Type type) {
        Iterator<TypeToken<? super T>> it = getTypes().iterator();
        while (it.hasNext()) {
            Type u10 = it.next().u();
            if (u10 != null && of(u10).isSubtypeOf(type)) {
                return true;
            }
        }
        return false;
    }

    public final com.google.common.reflect.b<T, T> constructor(Constructor<?> constructor) {
        p.k(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", constructor, getRawType());
        return new b(constructor);
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeToken) {
            return this.runtimeType.equals(((TypeToken) obj).runtimeType);
        }
        return false;
    }

    public final TypeToken<?> getComponentType() {
        Type j10 = com.google.common.reflect.h.j(this.runtimeType);
        if (j10 == null) {
            return null;
        }
        return of(j10);
    }

    public final Class<? super T> getRawType() {
        return v().iterator().next();
    }

    public final TypeToken<? extends T> getSubtype(Class<?> cls) {
        p.j(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        Type type = this.runtimeType;
        if (type instanceof WildcardType) {
            return w(cls, ((WildcardType) type).getLowerBounds());
        }
        if (isArray()) {
            return o(cls);
        }
        p.k(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        TypeToken<? extends T> typeToken = (TypeToken<? extends T>) of(G(cls));
        p.k(typeToken.isSubtypeOf((TypeToken<?>) this), "%s does not appear to be a subtype of %s", typeToken, this);
        return typeToken;
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> cls) {
        p.k(H(cls), "%s is not a super class of %s", cls, this);
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return x(cls, ((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return x(cls, ((WildcardType) type).getUpperBounds());
        }
        if (cls.isArray()) {
            return p(cls);
        }
        return (TypeToken<? super T>) F(I(cls).runtimeType);
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet();
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    public final boolean isPrimitive() {
        Type type = this.runtimeType;
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    public final boolean isSubtypeOf(TypeToken<?> typeToken) {
        return isSubtypeOf(typeToken.getType());
    }

    public final boolean isSupertypeOf(TypeToken<?> typeToken) {
        return typeToken.isSubtypeOf(getType());
    }

    public final com.google.common.reflect.b<T, Object> method(Method method) {
        p.k(H(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new a(method);
    }

    final ImmutableList<TypeToken<? super T>> r() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return i(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return i(((WildcardType) type).getUpperBounds());
        }
        ImmutableList.b builder = ImmutableList.builder();
        for (Type type2 : getRawType().getGenericInterfaces()) {
            builder.a(F(type2));
        }
        return builder.h();
    }

    public final TypeToken<?> resolveType(Type type) {
        p.o(type);
        return of(t().j(type));
    }

    final TypeToken<? super T> s() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return h(((TypeVariable) type).getBounds()[0]);
        }
        if (type instanceof WildcardType) {
            return h(((WildcardType) type).getUpperBounds()[0]);
        }
        Type genericSuperclass = getRawType().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return (TypeToken<? super T>) F(genericSuperclass);
    }

    public String toString() {
        return com.google.common.reflect.h.t(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        return D() ? of(com.google.common.primitives.g.c((Class) this.runtimeType)) : this;
    }

    public final <X> TypeToken<T> where(com.google.common.reflect.e<X> eVar, TypeToken<X> typeToken) {
        new com.google.common.reflect.f();
        throw null;
    }

    public final TypeToken<T> wrap() {
        return isPrimitive() ? of(com.google.common.primitives.g.d((Class) this.runtimeType)) : this;
    }

    protected TypeToken() {
        Type a10 = a();
        this.runtimeType = a10;
        p.x(!(a10 instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", a10);
    }

    public static TypeToken<?> of(Type type) {
        return new g(type);
    }

    public final boolean isSubtypeOf(Type type) {
        p.o(type);
        if (type instanceof WildcardType) {
            return g(((WildcardType) type).getLowerBounds()).b(this.runtimeType);
        }
        Type type2 = this.runtimeType;
        if (type2 instanceof WildcardType) {
            return g(((WildcardType) type2).getUpperBounds()).a(type);
        }
        if (type2 instanceof TypeVariable) {
            return type2.equals(type) || g(((TypeVariable) this.runtimeType).getBounds()).a(type);
        }
        if (type2 instanceof GenericArrayType) {
            return of(type).C((GenericArrayType) this.runtimeType);
        }
        if (type instanceof Class) {
            return H((Class) type);
        }
        if (type instanceof ParameterizedType) {
            return B((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return A((GenericArrayType) type);
        }
        return false;
    }

    public final boolean isSupertypeOf(Type type) {
        return of(type).isSubtypeOf(getType());
    }

    public final <X> TypeToken<T> where(com.google.common.reflect.e<X> eVar, Class<X> cls) {
        return where(eVar, of((Class) cls));
    }

    private TypeToken(Type type) {
        this.runtimeType = (Type) p.o(type);
    }
}
