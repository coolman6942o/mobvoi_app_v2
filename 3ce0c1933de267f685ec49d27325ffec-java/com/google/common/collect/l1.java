package com.google.common.collect;

import com.google.common.collect.ImmutableSortedMap;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class l1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ l1 f12088a = new l1();

    private /* synthetic */ l1() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((ImmutableSortedMap.c) obj).a();
    }
}
