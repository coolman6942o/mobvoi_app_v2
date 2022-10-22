package com.google.common.collect;

import java.util.Map;
import java.util.Spliterator;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class q4 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ q4 f12153a = new q4();

    private /* synthetic */ q4() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        Spliterator v10;
        v10 = ImmutableMultimap.v((Map.Entry) obj);
        return v10;
    }
}
