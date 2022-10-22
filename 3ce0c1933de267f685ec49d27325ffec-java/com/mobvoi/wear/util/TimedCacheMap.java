package com.mobvoi.wear.util;

import q.a;
/* loaded from: classes2.dex */
public class TimedCacheMap<T> {
    private a<String, TimedCache<T>> caches;

    public TimedCacheMap(int i10) {
        this.caches = new a<>(i10);
    }

    public T getCache(String str) {
        synchronized (this.caches) {
            TimedCache<T> c10 = this.caches.c(str);
            if (c10 == null) {
                return null;
            }
            if (c10.getTimestamp() < System.currentTimeMillis()) {
                this.caches.e(str);
                return null;
            }
            return c10.getValue();
        }
    }

    public void putCache(String str, T t10, long j10) {
        synchronized (this.caches) {
            this.caches.d(str, new TimedCache<>(t10, System.currentTimeMillis() + j10));
        }
    }
}
