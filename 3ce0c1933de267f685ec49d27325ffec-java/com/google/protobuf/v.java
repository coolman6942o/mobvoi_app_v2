package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;
/* compiled from: LazyField.java */
/* loaded from: classes.dex */
public class v extends w {

    /* renamed from: e  reason: collision with root package name */
    private final e0 f13367e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazyField.java */
    /* loaded from: classes.dex */
    public static class b<K> implements Map.Entry<K, Object> {

        /* renamed from: a  reason: collision with root package name */
        private Map.Entry<K, v> f13368a;

        public v a() {
            return this.f13368a.getValue();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f13368a.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            v value = this.f13368a.getValue();
            if (value == null) {
                return null;
            }
            return value.g();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof e0) {
                return this.f13368a.getValue().e((e0) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        private b(Map.Entry<K, v> entry) {
            this.f13368a = entry;
        }
    }

    /* compiled from: LazyField.java */
    /* loaded from: classes.dex */
    static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: a  reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f13369a;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f13369a = it;
        }

        /* renamed from: a */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f13369a.next();
            return next.getValue() instanceof v ? new b(next) : next;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13369a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f13369a.remove();
        }
    }

    public v(e0 e0Var, q qVar, ByteString byteString) {
        super(qVar, byteString);
        this.f13367e = e0Var;
    }

    public boolean equals(Object obj) {
        return g().equals(obj);
    }

    public e0 g() {
        return d(this.f13367e);
    }

    public int hashCode() {
        return g().hashCode();
    }

    public String toString() {
        return g().toString();
    }
}
