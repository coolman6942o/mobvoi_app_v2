package com.google.common.collect;

import java.util.Map;
import java.util.Spliterator;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class y7 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ y7 f12271a = new y7();

    private /* synthetic */ y7() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        Spliterator s10;
        s10 = z7.s((Map.Entry) obj);
        return s10;
    }
}
