package com.google.android.gms.common.api.internal;

import androidx.collection.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.b;
import com.google.android.gms.tasks.c;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class h2 {

    /* renamed from: d  reason: collision with root package name */
    private int f8622d;

    /* renamed from: b  reason: collision with root package name */
    private final a<f2<?>, String> f8620b = new a<>();

    /* renamed from: c  reason: collision with root package name */
    private final c<Map<f2<?>, String>> f8621c = new c<>();

    /* renamed from: e  reason: collision with root package name */
    private boolean f8623e = false;

    /* renamed from: a  reason: collision with root package name */
    private final a<f2<?>, ConnectionResult> f8619a = new a<>();

    public h2(Iterable<? extends com.google.android.gms.common.api.c<?>> iterable) {
        for (com.google.android.gms.common.api.c<?> cVar : iterable) {
            this.f8619a.put(cVar.o(), null);
        }
        this.f8622d = this.f8619a.keySet().size();
    }

    public final b<Map<f2<?>, String>> a() {
        return this.f8621c.a();
    }

    public final void b(f2<?> f2Var, ConnectionResult connectionResult, String str) {
        this.f8619a.put(f2Var, connectionResult);
        this.f8620b.put(f2Var, str);
        this.f8622d--;
        if (!connectionResult.K0()) {
            this.f8623e = true;
        }
        if (this.f8622d != 0) {
            return;
        }
        if (this.f8623e) {
            this.f8621c.b(new AvailabilityException(this.f8619a));
            return;
        }
        this.f8621c.c(this.f8620b);
    }

    public final Set<f2<?>> c() {
        return this.f8619a.keySet();
    }
}
