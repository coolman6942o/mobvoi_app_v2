package com.google.common.util.concurrent;

import java.util.function.ToLongFunction;
/* loaded from: classes.dex */
public final /* synthetic */ class i implements ToLongFunction {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ i f12405a = new i();

    private /* synthetic */ i() {
    }

    @Override // java.util.function.ToLongFunction
    public final long applyAsLong(Object obj) {
        return ((Long) obj).longValue();
    }
}
