package com.google.common.collect;

import com.google.common.collect.ImmutableSortedMap;
import java.util.function.BinaryOperator;
/* loaded from: classes.dex */
public final /* synthetic */ class s0 implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ s0 f12163a = new s0();

    private /* synthetic */ s0() {
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableSortedMap.c) obj).b((ImmutableSortedMap.c) obj2);
    }
}
