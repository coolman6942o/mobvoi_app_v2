package com.google.common.collect;

import java.util.function.Supplier;
/* loaded from: classes.dex */
public final /* synthetic */ class f2 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ f2 f11981a = new f2();

    private /* synthetic */ f2() {
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return LinkedHashMultiset.create();
    }
}
