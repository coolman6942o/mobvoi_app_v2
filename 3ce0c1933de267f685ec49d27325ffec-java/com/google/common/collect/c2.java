package com.google.common.collect;

import java.util.function.Supplier;
/* loaded from: classes.dex */
public final /* synthetic */ class c2 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ c2 f11949a = new c2();

    private /* synthetic */ c2() {
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return ImmutableRangeSet.builder();
    }
}
