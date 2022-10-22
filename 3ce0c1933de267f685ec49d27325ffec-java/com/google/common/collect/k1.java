package com.google.common.collect;

import com.google.common.collect.ImmutableSetMultimap;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class k1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ k1 f12080a = new k1();

    private /* synthetic */ k1() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((ImmutableSetMultimap.a) obj).h();
    }
}
