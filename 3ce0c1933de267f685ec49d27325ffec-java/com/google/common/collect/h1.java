package com.google.common.collect;

import com.google.common.collect.ImmutableRangeMap;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class h1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ h1 f12000a = new h1();

    private /* synthetic */ h1() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((ImmutableRangeMap.c) obj).a();
    }
}
