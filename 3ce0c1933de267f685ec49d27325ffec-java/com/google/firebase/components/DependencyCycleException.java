package com.google.firebase.components;

import b8.a;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class DependencyCycleException extends DependencyException {
    private final List<a<?>> zzap;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DependencyCycleException(List<a<?>> list) {
        super(r0.length() != 0 ? "Dependency cycle detected: ".concat(r0) : new String("Dependency cycle detected: "));
        String valueOf = String.valueOf(Arrays.toString(list.toArray()));
        this.zzap = list;
    }

    public List<a<?>> getComponentsInCycle() {
        return this.zzap;
    }
}
