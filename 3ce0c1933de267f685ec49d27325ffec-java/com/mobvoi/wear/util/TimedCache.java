package com.mobvoi.wear.util;
/* loaded from: classes2.dex */
public class TimedCache<T> {
    private long timestamp;
    private T value;

    public TimedCache(T t10, long j10) {
        this.value = t10;
        this.timestamp = j10;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public T getValue() {
        return this.value;
    }
}
