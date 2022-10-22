package com.google.common.reflect;

import com.google.common.base.k;
import com.google.common.base.m;
import com.google.common.base.p;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.w5;
import com.google.common.reflect.h;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: TypeResolver.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final c f12372a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeResolver.java */
    /* loaded from: classes.dex */
    public class a extends g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f12373b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Type f12374c;

        a(Map map, Type type) {
            this.f12373b = map;
            this.f12374c = type;
        }

        @Override // com.google.common.reflect.g
        void b(Class<?> cls) {
            if (!(this.f12374c instanceof WildcardType)) {
                String valueOf = String.valueOf(cls);
                String valueOf2 = String.valueOf(this.f12374c);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 25 + valueOf2.length());
                sb2.append("No type mapping from ");
                sb2.append(valueOf);
                sb2.append(" to ");
                sb2.append(valueOf2);
                throw new IllegalArgumentException(sb2.toString());
            }
        }

        @Override // com.google.common.reflect.g
        void c(GenericArrayType genericArrayType) {
            Type type = this.f12374c;
            if (!(type instanceof WildcardType)) {
                Type j10 = h.j(type);
                p.j(j10 != null, "%s is not an array type.", this.f12374c);
                f.g(this.f12373b, genericArrayType.getGenericComponentType(), j10);
            }
        }

        @Override // com.google.common.reflect.g
        void d(ParameterizedType parameterizedType) {
            Type type = this.f12374c;
            if (!(type instanceof WildcardType)) {
                ParameterizedType parameterizedType2 = (ParameterizedType) f.e(ParameterizedType.class, type);
                if (!(parameterizedType.getOwnerType() == null || parameterizedType2.getOwnerType() == null)) {
                    f.g(this.f12373b, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
                }
                p.k(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, this.f12374c);
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                p.k(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
                for (int i10 = 0; i10 < actualTypeArguments.length; i10++) {
                    f.g(this.f12373b, actualTypeArguments[i10], actualTypeArguments2[i10]);
                }
            }
        }

        @Override // com.google.common.reflect.g
        void e(TypeVariable<?> typeVariable) {
            this.f12373b.put(new d(typeVariable), this.f12374c);
        }

        @Override // com.google.common.reflect.g
        void f(WildcardType wildcardType) {
            Type type = this.f12374c;
            if (type instanceof WildcardType) {
                WildcardType wildcardType2 = (WildcardType) type;
                Type[] upperBounds = wildcardType.getUpperBounds();
                Type[] upperBounds2 = wildcardType2.getUpperBounds();
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                p.k(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, this.f12374c);
                for (int i10 = 0; i10 < upperBounds.length; i10++) {
                    f.g(this.f12373b, upperBounds[i10], upperBounds2[i10]);
                }
                for (int i11 = 0; i11 < lowerBounds.length; i11++) {
                    f.g(this.f12373b, lowerBounds[i11], lowerBounds2[i11]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TypeResolver.java */
    /* loaded from: classes.dex */
    public static final class b extends g {

        /* renamed from: b  reason: collision with root package name */
        private final Map<d, Type> f12375b = w5.k();

        private b() {
        }

        static ImmutableMap<d, Type> g(Type type) {
            p.o(type);
            b bVar = new b();
            bVar.a(type);
            return ImmutableMap.copyOf((Map) bVar.f12375b);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
            r4 = r2.f12375b.remove(com.google.common.reflect.f.d.c(r4));
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
            if (r4 == null) goto L17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void h(d dVar, Type type) {
            if (!this.f12375b.containsKey(dVar)) {
                Type type2 = type;
                while (type2 != null) {
                    if (dVar.a(type2)) {
                        break;
                    }
                    type2 = this.f12375b.get(d.c(type2));
                }
                this.f12375b.put(dVar, type);
            }
        }

        @Override // com.google.common.reflect.g
        void b(Class<?> cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        @Override // com.google.common.reflect.g
        void d(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            p.u(typeParameters.length == actualTypeArguments.length);
            for (int i10 = 0; i10 < typeParameters.length; i10++) {
                h(new d(typeParameters[i10]), actualTypeArguments[i10]);
            }
            a(cls);
            a(parameterizedType.getOwnerType());
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeResolver.java */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final TypeVariable<?> f12379a;

        d(TypeVariable<?> typeVariable) {
            this.f12379a = (TypeVariable) p.o(typeVariable);
        }

        private boolean b(TypeVariable<?> typeVariable) {
            return this.f12379a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.f12379a.getName().equals(typeVariable.getName());
        }

        static d c(Type type) {
            if (type instanceof TypeVariable) {
                return new d((TypeVariable) type);
            }
            return null;
        }

        boolean a(Type type) {
            if (type instanceof TypeVariable) {
                return b((TypeVariable) type);
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return b(((d) obj).f12379a);
            }
            return false;
        }

        public int hashCode() {
            return m.b(this.f12379a.getGenericDeclaration(), this.f12379a.getName());
        }

        public String toString() {
            return this.f12379a.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TypeResolver.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: b  reason: collision with root package name */
        static final e f12380b = new e();

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f12381a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TypeResolver.java */
        /* loaded from: classes.dex */
        public class a extends e {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ TypeVariable f12382c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(e eVar, AtomicInteger atomicInteger, TypeVariable typeVariable) {
                super(atomicInteger, null);
                this.f12382c = typeVariable;
            }

            @Override // com.google.common.reflect.f.e
            TypeVariable<?> b(Type[] typeArr) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                linkedHashSet.addAll(Arrays.asList(this.f12382c.getBounds()));
                if (linkedHashSet.size() > 1) {
                    linkedHashSet.remove(Object.class);
                }
                return super.b((Type[]) linkedHashSet.toArray(new Type[0]));
            }
        }

        /* synthetic */ e(AtomicInteger atomicInteger, a aVar) {
            this(atomicInteger);
        }

        private Type c(Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        private e d(TypeVariable<?> typeVariable) {
            return new a(this, this.f12381a, typeVariable);
        }

        private e e() {
            return new e(this.f12381a);
        }

        final Type a(Type type) {
            p.o(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return h.k(e().a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class cls = (Class) parameterizedType.getRawType();
                TypeVariable<?>[] typeParameters = cls.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i10 = 0; i10 < actualTypeArguments.length; i10++) {
                    actualTypeArguments[i10] = d(typeParameters[i10]).a(actualTypeArguments[i10]);
                }
                return h.n(e().c(parameterizedType.getOwnerType()), cls, actualTypeArguments);
            } else if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? b(wildcardType.getUpperBounds()) : type;
            } else {
                throw new AssertionError("must have been one of the known types");
            }
        }

        TypeVariable<?> b(Type[] typeArr) {
            int incrementAndGet = this.f12381a.incrementAndGet();
            String e10 = k.f('&').e(typeArr);
            StringBuilder sb2 = new StringBuilder(String.valueOf(e10).length() + 33);
            sb2.append("capture#");
            sb2.append(incrementAndGet);
            sb2.append("-of ? extends ");
            sb2.append(e10);
            return h.l(e.class, sb2.toString(), typeArr);
        }

        private e() {
            this(new AtomicInteger());
        }

        private e(AtomicInteger atomicInteger) {
            this.f12381a = atomicInteger;
        }
    }

    /* synthetic */ f(c cVar, a aVar) {
        this(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f d(Type type) {
        return new f().o(b.g(type));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T e(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            String valueOf = String.valueOf(obj);
            String simpleName = cls.getSimpleName();
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 10 + simpleName.length());
            sb2.append(valueOf);
            sb2.append(" is not a ");
            sb2.append(simpleName);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f f(Type type) {
        return new f().o(b.g(e.f12380b.a(type)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Map<d, Type> map, Type type, Type type2) {
        if (!type.equals(type2)) {
            new a(map, type2).a(type);
        }
    }

    private Type h(GenericArrayType genericArrayType) {
        return h.k(j(genericArrayType.getGenericComponentType()));
    }

    private ParameterizedType i(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        return h.n(ownerType == null ? null : j(ownerType), (Class) j(parameterizedType.getRawType()), k(parameterizedType.getActualTypeArguments()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Type[] k(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i10 = 0; i10 < typeArr.length; i10++) {
            typeArr2[i10] = j(typeArr[i10]);
        }
        return typeArr2;
    }

    private WildcardType m(WildcardType wildcardType) {
        return new h.j(k(wildcardType.getLowerBounds()), k(wildcardType.getUpperBounds()));
    }

    public Type j(Type type) {
        p.o(type);
        if (type instanceof TypeVariable) {
            return this.f12372a.a((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return i((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return h((GenericArrayType) type);
        }
        return type instanceof WildcardType ? m((WildcardType) type) : type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Type[] l(Type[] typeArr) {
        for (int i10 = 0; i10 < typeArr.length; i10++) {
            typeArr[i10] = j(typeArr[i10]);
        }
        return typeArr;
    }

    public f n(Type type, Type type2) {
        HashMap k10 = w5.k();
        g(k10, (Type) p.o(type), (Type) p.o(type2));
        return o(k10);
    }

    f o(Map<d, ? extends Type> map) {
        return new f(this.f12372a.c(map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TypeResolver.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private final ImmutableMap<d, Type> f12376a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TypeResolver.java */
        /* loaded from: classes.dex */
        public class a extends c {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TypeVariable f12377b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ c f12378c;

            a(c cVar, TypeVariable typeVariable, c cVar2) {
                this.f12377b = typeVariable;
                this.f12378c = cVar2;
            }

            @Override // com.google.common.reflect.f.c
            public Type b(TypeVariable<?> typeVariable, c cVar) {
                return typeVariable.getGenericDeclaration().equals(this.f12377b.getGenericDeclaration()) ? typeVariable : this.f12378c.b(typeVariable, cVar);
            }
        }

        c() {
            this.f12376a = ImmutableMap.of();
        }

        final Type a(TypeVariable<?> typeVariable) {
            return b(typeVariable, new a(this, typeVariable, this));
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.reflect.GenericDeclaration] */
        Type b(TypeVariable<?> typeVariable, c cVar) {
            Type type = this.f12376a.get(new d(typeVariable));
            if (type != null) {
                return new f(cVar, null).j(type);
            }
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length == 0) {
                return typeVariable;
            }
            Type[] k10 = new f(cVar, null).k(bounds);
            return (!h.f.f12387a || !Arrays.equals(bounds, k10)) ? h.l(typeVariable.getGenericDeclaration(), typeVariable.getName(), k10) : typeVariable;
        }

        final c c(Map<d, ? extends Type> map) {
            ImmutableMap.b builder = ImmutableMap.builder();
            builder.g(this.f12376a);
            for (Map.Entry<d, ? extends Type> entry : map.entrySet()) {
                d key = entry.getKey();
                Type value = entry.getValue();
                p.j(!key.a(value), "Type variable %s bound to itself", key);
                builder.d(key, value);
            }
            return new c(builder.a());
        }

        private c(ImmutableMap<d, Type> immutableMap) {
            this.f12376a = immutableMap;
        }
    }

    public f() {
        this.f12372a = new c();
    }

    private f(c cVar) {
        this.f12372a = cVar;
    }
}
