package com.google.common.hash;

import java.util.function.BinaryOperator;
/* loaded from: classes.dex */
public final /* synthetic */ class e implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ e f12311a = new e();

    private /* synthetic */ e() {
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        BloomFilter putAll;
        putAll = ((BloomFilter) obj).putAll((BloomFilter) obj2);
        return putAll;
    }
}
