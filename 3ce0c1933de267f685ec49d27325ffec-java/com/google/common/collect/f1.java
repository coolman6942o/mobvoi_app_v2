package com.google.common.collect;

import com.google.common.collect.ImmutableListMultimap;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class f1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ f1 f11980a = new f1();

    private /* synthetic */ f1() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((ImmutableListMultimap.a) obj).h();
    }
}
