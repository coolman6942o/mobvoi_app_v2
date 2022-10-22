package com.google.common.collect;

import com.google.common.collect.ImmutableSortedSet;
import java.util.function.BiConsumer;
/* loaded from: classes.dex */
public final /* synthetic */ class i0 implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ i0 f12015a = new i0();

    private /* synthetic */ i0() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((ImmutableSortedSet.b) obj).e(obj2);
    }
}
