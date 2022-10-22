package com.google.common.collect;

import com.google.common.collect.ImmutableRangeMap;
import java.util.function.BinaryOperator;
/* loaded from: classes.dex */
public final /* synthetic */ class n0 implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ n0 f12127a = new n0();

    private /* synthetic */ n0() {
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableRangeMap.c) obj).b((ImmutableRangeMap.c) obj2);
    }
}
