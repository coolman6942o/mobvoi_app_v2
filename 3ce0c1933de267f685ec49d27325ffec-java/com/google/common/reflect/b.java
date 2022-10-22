package com.google.common.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
/* compiled from: Invokable.java */
/* loaded from: classes.dex */
public abstract class b<T, R> extends com.google.common.reflect.a implements GenericDeclaration {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Invokable.java */
    /* loaded from: classes.dex */
    public static class a<T> extends b<T, T> {

        /* renamed from: c  reason: collision with root package name */
        final Constructor<?> f12370c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Constructor<?> constructor) {
            super(constructor);
            this.f12370c = constructor;
        }

        private boolean c() {
            Class<?> declaringClass = this.f12370c.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            Method enclosingMethod = declaringClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                return !Modifier.isStatic(enclosingMethod.getModifiers());
            }
            return declaringClass.getEnclosingClass() != null && !Modifier.isStatic(declaringClass.getModifiers());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Type[] b() {
            Type[] genericParameterTypes = this.f12370c.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !c()) {
                return genericParameterTypes;
            }
            Class<?>[] parameterTypes = this.f12370c.getParameterTypes();
            return (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) ? (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length) : genericParameterTypes;
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            TypeVariable<Class<? super T>>[] typeParameters = getDeclaringClass().getTypeParameters();
            TypeVariable<Constructor<?>>[] typeParameters2 = this.f12370c.getTypeParameters();
            TypeVariable<?>[] typeVariableArr = new TypeVariable[typeParameters.length + typeParameters2.length];
            System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
            return typeVariableArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Invokable.java */
    /* renamed from: com.google.common.reflect.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0157b<T> extends b<T, Object> {

        /* renamed from: c  reason: collision with root package name */
        final Method f12371c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0157b(Method method) {
            super(method);
            this.f12371c = method;
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            return this.f12371c.getTypeParameters();
        }
    }

    <M extends AccessibleObject & Member> b(M m10) {
        super(m10);
    }

    @Override // com.google.common.reflect.a, java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) super.getDeclaringClass();
    }
}
