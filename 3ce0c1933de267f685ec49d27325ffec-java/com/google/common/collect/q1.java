package com.google.common.collect;

import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class q1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ q1 f12150a = new q1();

    private /* synthetic */ q1() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ImmutableSetMultimap.copyOf((b6) ((k7) obj));
    }
}
