package com.google.common.cache;

import com.google.common.base.p;
import java.util.AbstractMap;
/* loaded from: classes.dex */
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    private RemovalNotification(K k10, V v10, RemovalCause removalCause) {
        super(k10, v10);
        this.cause = (RemovalCause) p.o(removalCause);
    }

    public static <K, V> RemovalNotification<K, V> create(K k10, V v10, RemovalCause removalCause) {
        return new RemovalNotification<>(k10, v10, removalCause);
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.b();
    }
}
