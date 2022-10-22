package com.google.common.collect;

import java.util.function.ToIntFunction;
/* loaded from: classes.dex */
public final /* synthetic */ class b5 implements ToIntFunction {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ b5 f11942a = new b5();

    private /* synthetic */ b5() {
    }

    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        int u10;
        u10 = ImmutableSortedMultiset.u(obj);
        return u10;
    }
}
