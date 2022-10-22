package com.google.common.collect;

import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class o1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ o1 f12137a = new o1();

    private /* synthetic */ o1() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ImmutableListMultimap.copyOf((b6) ((q5) obj));
    }
}
