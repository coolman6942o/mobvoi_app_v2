package com.google.common.collect;

import com.google.common.collect.j6;
import java.util.Spliterator;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class k6 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ k6 f12084a = new k6();

    private /* synthetic */ k6() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        Spliterator j10;
        j10 = m6.j((j6.a) obj);
        return j10;
    }
}
