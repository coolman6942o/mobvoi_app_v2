package com.google.common.collect;

import com.google.common.collect.ImmutableListMultimap;
import java.util.function.BinaryOperator;
/* loaded from: classes.dex */
public final /* synthetic */ class l0 implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ l0 f12087a = new l0();

    private /* synthetic */ l0() {
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableListMultimap.a) obj).i((ImmutableListMultimap.a) obj2);
    }
}
