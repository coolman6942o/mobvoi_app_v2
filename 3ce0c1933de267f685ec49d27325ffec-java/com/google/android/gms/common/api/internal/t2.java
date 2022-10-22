package com.google.android.gms.common.api.internal;

import a7.e;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.e;
/* loaded from: classes.dex */
public final class t2<O extends a.d> extends c<O> {

    /* renamed from: i  reason: collision with root package name */
    private final a.f f8733i;

    /* renamed from: j  reason: collision with root package name */
    private final n2 f8734j;

    /* renamed from: k  reason: collision with root package name */
    private final b6.c f8735k;

    /* renamed from: l  reason: collision with root package name */
    private final a.AbstractC0105a<? extends e, a7.a> f8736l;

    public t2(Context context, a<O> aVar, Looper looper, a.f fVar, n2 n2Var, b6.c cVar, a.AbstractC0105a<? extends e, a7.a> aVar2) {
        super(context, aVar, looper);
        this.f8733i = fVar;
        this.f8734j = n2Var;
        this.f8735k = cVar;
        this.f8736l = aVar2;
        this.f8462h.i(this);
    }

    @Override // com.google.android.gms.common.api.c
    public final a.f k(Looper looper, e.a<O> aVar) {
        this.f8734j.a(aVar);
        return this.f8733i;
    }

    @Override // com.google.android.gms.common.api.c
    public final q1 m(Context context, Handler handler) {
        return new q1(context, handler, this.f8735k, this.f8736l);
    }

    public final a.f p() {
        return this.f8733i;
    }
}
