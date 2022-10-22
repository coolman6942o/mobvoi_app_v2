package com.google.common.collect;

import java.util.Map;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class l4 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ l4 f12095a = new l4();

    private /* synthetic */ l4() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((Map.Entry) obj).getValue();
    }
}
