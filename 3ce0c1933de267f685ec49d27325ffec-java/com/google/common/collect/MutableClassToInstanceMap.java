package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.primitives.g;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
/* loaded from: classes.dex */
public final class MutableClassToInstanceMap<B> extends o3<Class<? extends B>, B> implements Serializable {
    private final Map<Class<? extends B>, B> delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends p3<Class<? extends B>, B> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map.Entry f11859a;

        a(Map.Entry entry) {
            this.f11859a = entry;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.p3
        /* renamed from: b */
        public Map.Entry<Class<? extends B>, B> a() {
            return this.f11859a;
        }

        @Override // com.google.common.collect.p3, java.util.Map.Entry
        public B setValue(B b10) {
            return (B) super.setValue(MutableClassToInstanceMap.i(getKey(), b10));
        }
    }

    /* loaded from: classes.dex */
    class b extends t3<Map.Entry<Class<? extends B>, B>> {

        /* loaded from: classes.dex */
        class a extends n8<Map.Entry<Class<? extends B>, B>, Map.Entry<Class<? extends B>, B>> {
            a(b bVar, Iterator it) {
                super(it);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: b */
            public Map.Entry<Class<? extends B>, B> a(Map.Entry<Class<? extends B>, B> entry) {
                return MutableClassToInstanceMap.j(entry);
            }
        }

        b() {
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Class<? extends B>, B>> iterator() {
            return new a(this, b().iterator());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.t3
        /* renamed from: l */
        public Set<Map.Entry<Class<? extends B>, B>> b() {
            return MutableClassToInstanceMap.this.a().entrySet();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<Map.Entry<Class<? extends B>, B>> spliterator() {
            return s2.e(b().spliterator(), n6.f12132a);
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return i();
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) j(tArr);
        }
    }

    private MutableClassToInstanceMap(Map<Class<? extends B>, B> map) {
        this.delegate = (Map) p.o(map);
    }

    public static <B> MutableClassToInstanceMap<B> create() {
        return new MutableClassToInstanceMap<>(new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map.Entry h(Map.Entry entry) {
        return j(entry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <B, T extends B> T i(Class<T> cls, B b10) {
        return (T) g.d(cls).cast(b10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <B> Map.Entry<Class<? extends B>, B> j(Map.Entry<Class<? extends B>, B> entry) {
        return new a(entry);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.o3
    /* renamed from: b */
    public Map<Class<? extends B>, B> a() {
        return this.delegate;
    }

    @Override // com.google.common.collect.o3, java.util.Map
    public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
        return new b();
    }

    public <T extends B> T getInstance(Class<T> cls) {
        return (T) i(cls, get(cls));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.o3, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((Class<? extends Class<? extends B>>) obj, (Class<? extends B>) obj2);
    }

    @Override // com.google.common.collect.o3, java.util.Map
    public void putAll(Map<? extends Class<? extends B>, ? extends B> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            i((Class) entry.getKey(), entry.getValue());
        }
        super.putAll(linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends B> T putInstance(Class<T> cls, T t10) {
        return (T) i(cls, put((Class<? extends Class<T>>) cls, (Class<T>) t10));
    }

    public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> map) {
        return new MutableClassToInstanceMap<>(map);
    }

    public B put(Class<? extends B> cls, B b10) {
        return (B) super.put((MutableClassToInstanceMap<B>) cls, (Class<? extends B>) i(cls, b10));
    }
}
