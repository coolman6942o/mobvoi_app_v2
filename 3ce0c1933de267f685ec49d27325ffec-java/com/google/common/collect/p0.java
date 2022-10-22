package com.google.common.collect;

import com.google.common.collect.ImmutableSet;
import java.util.function.BinaryOperator;
/* loaded from: classes.dex */
public final /* synthetic */ class p0 implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ p0 f12145a = new p0();

    private /* synthetic */ p0() {
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableSet.a) obj).h((ImmutableSet.a) obj2);
    }
}
