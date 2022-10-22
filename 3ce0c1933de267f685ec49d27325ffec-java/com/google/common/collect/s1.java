package com.google.common.collect;

import java.util.TreeMap;
import java.util.function.Function;
/* loaded from: classes.dex */
public final /* synthetic */ class s1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ s1 f12164a = new s1();

    private /* synthetic */ s1() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ImmutableSortedMap.copyOfSorted((TreeMap) obj);
    }
}
