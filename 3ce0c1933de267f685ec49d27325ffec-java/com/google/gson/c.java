package com.google.gson;

import com.google.gson.internal.a;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
/* compiled from: FieldAttributes.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Field f12546a;

    public c(Field field) {
        a.b(field);
        this.f12546a = field;
    }

    public <T extends Annotation> T a(Class<T> cls) {
        return (T) this.f12546a.getAnnotation(cls);
    }
}
