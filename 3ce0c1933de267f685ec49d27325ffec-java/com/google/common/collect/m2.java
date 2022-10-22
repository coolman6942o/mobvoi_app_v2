package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import java.util.function.BiConsumer;
/* loaded from: classes.dex */
public final /* synthetic */ class m2 implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ m2 f12118a = new m2();

    private /* synthetic */ m2() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((ImmutableList.b) obj).a(obj2);
    }
}
