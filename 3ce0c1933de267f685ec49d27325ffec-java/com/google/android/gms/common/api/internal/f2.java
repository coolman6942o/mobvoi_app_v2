package com.google.android.gms.common.api.internal;

import b6.h;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
/* loaded from: classes.dex */
public final class f2<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f8603a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8604b;

    /* renamed from: c  reason: collision with root package name */
    private final a<O> f8605c;

    /* renamed from: d  reason: collision with root package name */
    private final O f8606d;

    private f2(a<O> aVar, O o10) {
        this.f8603a = false;
        this.f8605c = aVar;
        this.f8606d = o10;
        this.f8604b = h.b(aVar, o10);
    }

    public static <O extends a.d> f2<O> a(a<O> aVar) {
        return new f2<>(aVar);
    }

    public static <O extends a.d> f2<O> b(a<O> aVar, O o10) {
        return new f2<>(aVar, o10);
    }

    public final String c() {
        return this.f8605c.b();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f2)) {
            return false;
        }
        f2 f2Var = (f2) obj;
        return !this.f8603a && !f2Var.f8603a && h.a(this.f8605c, f2Var.f8605c) && h.a(this.f8606d, f2Var.f8606d);
    }

    public final int hashCode() {
        return this.f8604b;
    }

    private f2(a<O> aVar) {
        this.f8603a = true;
        this.f8605c = aVar;
        this.f8606d = null;
        this.f8604b = System.identityHashCode(this);
    }
}
