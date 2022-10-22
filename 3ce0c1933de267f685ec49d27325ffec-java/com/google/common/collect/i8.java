package com.google.common.collect;

import com.google.common.collect.l8;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class i8 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ i8 f12021a = new i8();

    private /* synthetic */ i8() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        ImmutableTable c10;
        c10 = ((l8.b) obj).c();
        return c10;
    }
}
