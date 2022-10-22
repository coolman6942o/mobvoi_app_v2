package com.google.common.collect;

import com.google.common.collect.ImmutableRangeSet;
import java.util.function.BiConsumer;
/* loaded from: classes.dex */
public final /* synthetic */ class n2 implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ n2 f12130a = new n2();

    private /* synthetic */ n2() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((ImmutableRangeSet.c) obj).a((Range) obj2);
    }
}
