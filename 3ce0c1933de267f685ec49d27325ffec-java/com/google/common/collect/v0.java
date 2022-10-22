package com.google.common.collect;

import java.util.function.BinaryOperator;
/* loaded from: classes.dex */
public final /* synthetic */ class v0 implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ v0 f12201a = new v0();

    private /* synthetic */ v0() {
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        j6 addAll;
        addAll = ((j6) obj).addAll((j6) obj2);
        return addAll;
    }
}
