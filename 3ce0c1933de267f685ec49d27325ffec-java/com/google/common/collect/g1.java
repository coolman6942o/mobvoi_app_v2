package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class g1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ g1 f11988a = new g1();

    private /* synthetic */ g1() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((ImmutableMap.b) obj).a();
    }
}
