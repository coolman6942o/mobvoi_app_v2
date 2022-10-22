package com.google.common.collect;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class r1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ r1 f12156a = new r1();

    private /* synthetic */ r1() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ImmutableMap.copyOf((Map) ((LinkedHashMap) obj));
    }
}
