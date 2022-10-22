package com.google.common.collect;

import java.util.Map;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class f4 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ f4 f11982a = new f4();

    private /* synthetic */ f4() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((Map.Entry) obj).getKey();
    }
}
