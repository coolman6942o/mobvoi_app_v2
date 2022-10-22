package com.airbnb.lottie;

import java.util.Arrays;
/* compiled from: LottieResult.java */
/* loaded from: classes.dex */
public final class l<V> {

    /* renamed from: a  reason: collision with root package name */
    private final V f6534a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f6535b;

    public l(V v10) {
        this.f6534a = v10;
        this.f6535b = null;
    }

    public Throwable a() {
        return this.f6535b;
    }

    public V b() {
        return this.f6534a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (b() != null && b().equals(lVar.b())) {
            return true;
        }
        if (a() == null || lVar.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public l(Throwable th2) {
        this.f6535b = th2;
        this.f6534a = null;
    }
}
