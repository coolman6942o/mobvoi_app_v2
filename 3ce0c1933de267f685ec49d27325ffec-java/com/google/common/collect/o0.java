package com.google.common.collect;

import com.google.common.collect.ImmutableRangeSet;
import java.util.function.BinaryOperator;
/* loaded from: classes.dex */
public final /* synthetic */ class o0 implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ o0 f12136a = new o0();

    private /* synthetic */ o0() {
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableRangeSet.c) obj).d((ImmutableRangeSet.c) obj2);
    }
}
