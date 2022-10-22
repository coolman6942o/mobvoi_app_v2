package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.h;
/* loaded from: classes.dex */
public final class h1<O extends a.d> extends x {

    /* renamed from: c  reason: collision with root package name */
    private final c<O> f8618c;

    public h1(c<O> cVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f8618c = cVar;
    }

    @Override // com.google.android.gms.common.api.d
    public final <A extends a.b, R extends h, T extends c<R, A>> T j(T t10) {
        return (T) this.f8618c.b(t10);
    }

    @Override // com.google.android.gms.common.api.d
    public final <A extends a.b, T extends c<? extends h, A>> T k(T t10) {
        return (T) this.f8618c.f(t10);
    }

    @Override // com.google.android.gms.common.api.d
    public final Context n() {
        return this.f8618c.h();
    }

    @Override // com.google.android.gms.common.api.d
    public final Looper o() {
        return this.f8618c.j();
    }
}
