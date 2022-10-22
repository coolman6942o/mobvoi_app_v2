package com.google.common.collect;

import com.google.common.collect.ImmutableSet;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class j1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ j1 f12056a = new j1();

    private /* synthetic */ j1() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((ImmutableSet.a) obj).g();
    }
}
