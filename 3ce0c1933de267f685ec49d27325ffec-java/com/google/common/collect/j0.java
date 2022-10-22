package com.google.common.collect;

import com.google.common.collect.ImmutableBiMap;
import java.util.function.BinaryOperator;
/* loaded from: classes.dex */
public final /* synthetic */ class j0 implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ j0 f12055a = new j0();

    private /* synthetic */ j0() {
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableBiMap.a) obj).b((ImmutableBiMap.a) obj2);
    }
}
