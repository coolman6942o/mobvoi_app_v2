package com.huawei.agconnect.core;

import com.huawei.agconnect.annotation.Singleton;
import java.lang.reflect.Modifier;
/* loaded from: classes.dex */
public class Service {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f13500a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f13501b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13502c;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        Class<?> f13503a;

        /* renamed from: b  reason: collision with root package name */
        Class<?> f13504b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f13505c;

        private Builder(Class<?> cls, Class<?> cls2) {
            if (cls == null) {
                throw new IllegalArgumentException("the interface parameter cannot be NULL");
            } else if (cls2 == null) {
                throw new IllegalArgumentException("the clazz parameter cannot be NULL");
            } else if (cls2.isInterface() || !Modifier.isPublic(cls2.getModifiers())) {
                throw new IllegalArgumentException("the clazz parameter must be interface type and public");
            } else {
                this.f13503a = cls;
                this.f13504b = cls2;
                this.f13505c = cls2.isAnnotationPresent(Singleton.class);
            }
        }

        public Service build() {
            Service service = new Service(this.f13503a, this.f13504b);
            service.f13502c = this.f13505c;
            return service;
        }

        public Builder isSingleton(boolean z10) {
            this.f13505c = z10;
            return this;
        }
    }

    private Service(Class<?> cls, Class<?> cls2) {
        this.f13500a = cls;
        this.f13501b = cls2;
    }

    public static Builder builder(Class<?> cls) {
        return new Builder(cls, cls);
    }

    public static Builder builder(Class<?> cls, Class<?> cls2) {
        return new Builder(cls, cls2);
    }

    public Class<?> getInterface() {
        return this.f13500a;
    }

    public Class<?> getType() {
        return this.f13501b;
    }

    public boolean isSingleton() {
        return this.f13502c;
    }
}
