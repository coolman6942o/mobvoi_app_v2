package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import java.util.function.BinaryOperator;
/* loaded from: classes.dex */
public final /* synthetic */ class k0 implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ k0 f12079a = new k0();

    private /* synthetic */ k0() {
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableList.b) obj).i((ImmutableList.b) obj2);
    }
}
