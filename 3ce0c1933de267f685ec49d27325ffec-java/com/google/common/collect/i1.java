package com.google.common.collect;

import com.google.common.collect.ImmutableRangeSet;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class i1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ i1 f12016a = new i1();

    private /* synthetic */ i1() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((ImmutableRangeSet.c) obj).c();
    }
}
