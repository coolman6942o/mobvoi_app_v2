package com.google.common.hash;

import java.util.function.BiConsumer;
/* loaded from: classes.dex */
public final /* synthetic */ class d implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ d f12310a = new d();

    private /* synthetic */ d() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((BloomFilter) obj).put(obj2);
    }
}
