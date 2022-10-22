package com.google.common.collect;

import java.util.function.ToIntFunction;
/* loaded from: classes.dex */
public final /* synthetic */ class r4 implements ToIntFunction {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ r4 f12159a = new r4();

    private /* synthetic */ r4() {
    }

    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        int m10;
        m10 = ImmutableMultiset.m(obj);
        return m10;
    }
}
