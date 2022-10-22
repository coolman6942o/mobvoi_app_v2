package com.google.common.reflect;

import com.google.common.base.p;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
/* compiled from: Element.java */
/* loaded from: classes.dex */
class a extends AccessibleObject implements Member {

    /* renamed from: a  reason: collision with root package name */
    private final AccessibleObject f12368a;

    /* renamed from: b  reason: collision with root package name */
    private final Member f12369b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public <M extends AccessibleObject & Member> a(M m10) {
        p.o(m10);
        this.f12368a = m10;
        this.f12369b = m10;
    }

    public TypeToken<?> a() {
        return TypeToken.of((Class) getDeclaringClass());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return a().equals(aVar.a()) && this.f12369b.equals(aVar.f12369b);
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) this.f12368a.getAnnotation(cls);
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.f12368a.getAnnotations();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.f12368a.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Member
    public Class<?> getDeclaringClass() {
        return this.f12369b.getDeclaringClass();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.f12369b.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.f12369b.getName();
    }

    public int hashCode() {
        return this.f12369b.hashCode();
    }

    @Override // java.lang.reflect.AccessibleObject
    public final boolean isAccessible() {
        return this.f12368a.isAccessible();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.f12368a.isAnnotationPresent(cls);
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.f12369b.isSynthetic();
    }

    @Override // java.lang.reflect.AccessibleObject
    public final void setAccessible(boolean z10) throws SecurityException {
        this.f12368a.setAccessible(z10);
    }

    public String toString() {
        return this.f12369b.toString();
    }
}
