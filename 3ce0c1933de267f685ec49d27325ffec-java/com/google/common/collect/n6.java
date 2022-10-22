package com.google.common.collect;

import java.util.Map;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class n6 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ n6 f12132a = new n6();

    private /* synthetic */ n6() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        Map.Entry h10;
        h10 = MutableClassToInstanceMap.h((Map.Entry) obj);
        return h10;
    }
}
