package com.google.common.collect;

import com.google.common.collect.s2;
import java.util.Spliterator;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class x2 implements s2.d.a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ x2 f12255a = new x2();

    private /* synthetic */ x2() {
    }

    @Override // com.google.common.collect.s2.d.a
    public final Spliterator a(Spliterator spliterator, Spliterator spliterator2, Function function, int i10, long j10) {
        return new s2.e(spliterator, spliterator2, function, i10, j10);
    }
}
