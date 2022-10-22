package com.google.common.collect;

import com.google.common.collect.ImmutableSortedSet;
import java.util.function.BinaryOperator;
/* loaded from: classes.dex */
public final /* synthetic */ class t0 implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ t0 f12182a = new t0();

    private /* synthetic */ t0() {
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableSortedSet.b) obj).h((ImmutableSortedSet.b) obj2);
    }
}
