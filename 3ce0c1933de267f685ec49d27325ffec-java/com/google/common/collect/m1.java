package com.google.common.collect;

import com.google.common.collect.ImmutableSortedSet;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class m1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ m1 f12117a = new m1();

    private /* synthetic */ m1() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((ImmutableSortedSet.b) obj).g();
    }
}
