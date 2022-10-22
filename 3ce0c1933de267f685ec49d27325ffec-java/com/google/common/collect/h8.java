package com.google.common.collect;

import com.google.common.collect.ImmutableTable;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class h8 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ h8 f12013a = new h8();

    private /* synthetic */ h8() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((ImmutableTable.a) obj).a();
    }
}
