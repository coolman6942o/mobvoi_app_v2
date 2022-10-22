package com.google.common.util.concurrent;

import java.util.function.Predicate;
/* loaded from: classes.dex */
public final /* synthetic */ class h implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ h f12404a = new h();

    private /* synthetic */ h() {
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        boolean n10;
        n10 = AtomicLongMap.n((Long) obj);
        return n10;
    }
}
