package com.google.common.collect;

import java.util.Collection;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class h implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ h f11998a = new h();

    private /* synthetic */ h() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((Collection) obj).spliterator();
    }
}
