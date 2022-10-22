package com.google.android.gms.internal.measurement;

import b6.i;
/* loaded from: classes.dex */
public final class q0<V> {

    /* renamed from: a  reason: collision with root package name */
    private final v6<V> f9601a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9602b;

    private q0(String str, v6<V> v6Var) {
        i.k(v6Var);
        this.f9601a = v6Var;
        this.f9602b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q0<Double> d(String str, double d10, double d11) {
        f7 f7Var;
        f7Var = p0.f9559a;
        return new q0<>(str, f7Var.b(str, -3.0d));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q0<Long> e(String str, long j10, long j11) {
        f7 f7Var;
        f7Var = p0.f9559a;
        return new q0<>(str, f7Var.f(str, j10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q0<Boolean> f(String str, boolean z10, boolean z11) {
        f7 f7Var;
        f7Var = p0.f9559a;
        return new q0<>(str, f7Var.g(str, z10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q0<Integer> g(String str, int i10, int i11) {
        f7 f7Var;
        f7Var = p0.f9559a;
        return new q0<>(str, f7Var.e(str, i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q0<String> h(String str, String str2, String str3) {
        f7 f7Var;
        f7Var = p0.f9559a;
        return new q0<>(str, f7Var.h(str, str2));
    }

    public final V a() {
        return this.f9601a.a();
    }

    public final V b(V v10) {
        return v10 != null ? v10 : this.f9601a.a();
    }

    public final String c() {
        return this.f9602b;
    }
}
