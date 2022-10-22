package com.google.android.gms.internal.measurement;

import b6.i;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n5 implements f0 {

    /* renamed from: a  reason: collision with root package name */
    h6 f9537a;

    /* renamed from: b  reason: collision with root package name */
    List<Long> f9538b;

    /* renamed from: c  reason: collision with root package name */
    List<e6> f9539c;

    /* renamed from: d  reason: collision with root package name */
    private long f9540d;

    private n5(j5 j5Var) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n5(j5 j5Var, k5 k5Var) {
        this(j5Var);
    }

    private static long c(e6 e6Var) {
        return ((e6Var.f9259e.longValue() / 1000) / 60) / 60;
    }

    @Override // com.google.android.gms.internal.measurement.f0
    public final boolean a(long j10, e6 e6Var) {
        i.k(e6Var);
        if (this.f9539c == null) {
            this.f9539c = new ArrayList();
        }
        if (this.f9538b == null) {
            this.f9538b = new ArrayList();
        }
        if (this.f9539c.size() > 0 && c(this.f9539c.get(0)) != c(e6Var)) {
            return false;
        }
        long f10 = this.f9540d + e6Var.f();
        if (f10 >= Math.max(0, p0.f9569k.a().intValue())) {
            return false;
        }
        this.f9540d = f10;
        this.f9539c.add(e6Var);
        this.f9538b.add(Long.valueOf(j10));
        return this.f9539c.size() < Math.max(1, p0.f9570l.a().intValue());
    }

    @Override // com.google.android.gms.internal.measurement.f0
    public final void b(h6 h6Var) {
        i.k(h6Var);
        this.f9537a = h6Var;
    }
}
