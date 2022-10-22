package com.alibaba.fastjson.util;

import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class IdentityHashMap<V> {
    private final Entry<V>[] buckets;
    private final int indexMask;

    /* loaded from: classes.dex */
    protected static final class Entry<V> {
        public final int hashCode;
        public final Type key;
        public final Entry<V> next;
        public V value;

        public Entry(Type type, V v10, int i10, Entry<V> entry) {
            this.key = type;
            this.value = v10;
            this.next = entry;
            this.hashCode = i10;
        }
    }

    public IdentityHashMap(int i10) {
        this.indexMask = i10 - 1;
        this.buckets = new Entry[i10];
    }

    public final V get(Type type) {
        for (Entry<V> entry = this.buckets[System.identityHashCode(type) & this.indexMask]; entry != null; entry = entry.next) {
            if (type == entry.key) {
                return entry.value;
            }
        }
        return null;
    }

    public boolean put(Type type, V v10) {
        int identityHashCode = System.identityHashCode(type);
        int i10 = this.indexMask & identityHashCode;
        for (Entry<V> entry = this.buckets[i10]; entry != null; entry = entry.next) {
            if (type == entry.key) {
                entry.value = v10;
                return true;
            }
        }
        this.buckets[i10] = new Entry<>(type, v10, identityHashCode, this.buckets[i10]);
        return false;
    }
}
