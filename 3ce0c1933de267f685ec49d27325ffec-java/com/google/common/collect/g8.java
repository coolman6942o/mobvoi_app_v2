package com.google.common.collect;

import com.google.common.collect.ImmutableTable;
import java.util.function.BinaryOperator;
/* loaded from: classes.dex */
public final /* synthetic */ class g8 implements BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ g8 f11997a = new g8();

    private /* synthetic */ g8() {
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableTable.a) obj).b((ImmutableTable.a) obj2);
    }
}
