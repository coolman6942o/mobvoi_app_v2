package com.google.common.collect;

import com.google.common.collect.ImmutableBiMap;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class d1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ d1 f11951a = new d1();

    private /* synthetic */ d1() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((ImmutableBiMap.a) obj).a();
    }
}
