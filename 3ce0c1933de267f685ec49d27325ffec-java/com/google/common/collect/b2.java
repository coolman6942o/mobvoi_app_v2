package com.google.common.collect;

import java.util.function.Supplier;
/* loaded from: classes.dex */
public final /* synthetic */ class b2 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ b2 f11941a = new b2();

    private /* synthetic */ b2() {
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return ImmutableRangeMap.builder();
    }
}
