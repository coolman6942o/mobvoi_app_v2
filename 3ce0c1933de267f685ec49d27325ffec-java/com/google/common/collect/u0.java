package com.google.common.collect;

import java.util.function.BinaryOperator;
/* loaded from: classes.dex */
public final /* synthetic */ class u0 implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ u0 f12189a = new u0();

    private /* synthetic */ u0() {
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        b6 putAll;
        putAll = ((b6) obj).putAll((b6) obj2);
        return putAll;
    }
}
