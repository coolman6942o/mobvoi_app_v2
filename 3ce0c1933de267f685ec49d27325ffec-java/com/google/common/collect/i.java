package com.google.common.collect;

import java.util.Map;
import java.util.Spliterator;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class i implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ i f12014a = new i();

    private /* synthetic */ i() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        Spliterator F;
        F = j.F((Map.Entry) obj);
        return F;
    }
}
