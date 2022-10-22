package com.google.common.collect;

import com.google.common.collect.ImmutableSetMultimap;
import java.util.function.BinaryOperator;
/* loaded from: classes.dex */
public final /* synthetic */ class q0 implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ q0 f12149a = new q0();

    private /* synthetic */ q0() {
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableSetMultimap.a) obj).i((ImmutableSetMultimap.a) obj2);
    }
}
