package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class e1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ e1 f11965a = new e1();

    private /* synthetic */ e1() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((ImmutableList.b) obj).h();
    }
}
