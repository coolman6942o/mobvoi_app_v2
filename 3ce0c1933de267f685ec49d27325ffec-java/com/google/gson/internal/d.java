package com.google.gson.internal;

import com.google.gson.b;
import com.google.gson.c;
import com.google.gson.e;
import com.google.gson.q;
import com.google.gson.r;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: Excluder.java */
/* loaded from: classes.dex */
public final class d implements r, Cloneable {

    /* renamed from: g  reason: collision with root package name */
    public static final d f12627g = new d();

    /* renamed from: d  reason: collision with root package name */
    private boolean f12631d;

    /* renamed from: a  reason: collision with root package name */
    private double f12628a = -1.0d;

    /* renamed from: b  reason: collision with root package name */
    private int f12629b = 136;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12630c = true;

    /* renamed from: e  reason: collision with root package name */
    private List<b> f12632e = Collections.emptyList();

    /* renamed from: f  reason: collision with root package name */
    private List<b> f12633f = Collections.emptyList();

    /* compiled from: Excluder.java */
    /* loaded from: classes.dex */
    class a extends q<T> {

        /* renamed from: a  reason: collision with root package name */
        private q<T> f12634a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f12635b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f12636c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e f12637d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ com.google.gson.reflect.a f12638e;

        a(boolean z10, boolean z11, e eVar, com.google.gson.reflect.a aVar) {
            this.f12635b = z10;
            this.f12636c = z11;
            this.f12637d = eVar;
            this.f12638e = aVar;
        }

        private q<T> e() {
            q<T> qVar = this.f12634a;
            if (qVar != 0) {
                return qVar;
            }
            q<T> n10 = this.f12637d.n(d.this, this.f12638e);
            this.f12634a = n10;
            return n10;
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
        @Override // com.google.gson.q
        public T b(com.google.gson.stream.a aVar) throws IOException {
            if (!this.f12635b) {
                return e().b(aVar);
            }
            aVar.H0();
            return null;
        }

        @Override // com.google.gson.q
        public void d(com.google.gson.stream.b bVar, T t10) throws IOException {
            if (this.f12636c) {
                bVar.I();
            } else {
                e().d(bVar, t10);
            }
        }
    }

    private boolean d(Class<?> cls) {
        if (this.f12628a == -1.0d || n((h8.d) cls.getAnnotation(h8.d.class), (h8.e) cls.getAnnotation(h8.e.class))) {
            return (!this.f12630c && j(cls)) || i(cls);
        }
        return true;
    }

    private boolean e(Class<?> cls, boolean z10) {
        for (b bVar : z10 ? this.f12632e : this.f12633f) {
            if (bVar.b(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean i(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean j(Class<?> cls) {
        return cls.isMemberClass() && !k(cls);
    }

    private boolean k(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean l(h8.d dVar) {
        return dVar == null || dVar.value() <= this.f12628a;
    }

    private boolean m(h8.e eVar) {
        return eVar == null || eVar.value() > this.f12628a;
    }

    private boolean n(h8.d dVar, h8.e eVar) {
        return l(dVar) && m(eVar);
    }

    @Override // com.google.gson.r
    public <T> q<T> a(e eVar, com.google.gson.reflect.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        boolean d10 = d(rawType);
        boolean z10 = d10 || e(rawType, true);
        boolean z11 = d10 || e(rawType, false);
        if (z10 || z11) {
            return new a(z11, z10, eVar, aVar);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public boolean c(Class<?> cls, boolean z10) {
        return d(cls) || e(cls, z10);
    }

    public boolean f(Field field, boolean z10) {
        h8.a aVar;
        if ((this.f12629b & field.getModifiers()) != 0) {
            return true;
        }
        if (!(this.f12628a == -1.0d || n((h8.d) field.getAnnotation(h8.d.class), (h8.e) field.getAnnotation(h8.e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f12631d && ((aVar = (h8.a) field.getAnnotation(h8.a.class)) == null || (!z10 ? !aVar.deserialize() : !aVar.serialize()))) {
            return true;
        }
        if ((!this.f12630c && j(field.getType())) || i(field.getType())) {
            return true;
        }
        List<b> list = z10 ? this.f12632e : this.f12633f;
        if (list.isEmpty()) {
            return false;
        }
        c cVar = new c(field);
        for (b bVar : list) {
            if (bVar.a(cVar)) {
                return true;
            }
        }
        return false;
    }

    public d g() {
        d b10 = clone();
        b10.f12631d = true;
        return b10;
    }

    public d o(b bVar, boolean z10, boolean z11) {
        d b10 = clone();
        if (z10) {
            ArrayList arrayList = new ArrayList(this.f12632e);
            b10.f12632e = arrayList;
            arrayList.add(bVar);
        }
        if (z11) {
            ArrayList arrayList2 = new ArrayList(this.f12633f);
            b10.f12633f = arrayList2;
            arrayList2.add(bVar);
        }
        return b10;
    }
}
