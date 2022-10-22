package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import java.util.function.BinaryOperator;
/* loaded from: classes.dex */
public final /* synthetic */ class m0 implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ m0 f12116a = new m0();

    private /* synthetic */ m0() {
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableMap.b) obj).b((ImmutableMap.b) obj2);
    }
}
