package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.a;
/* loaded from: classes.dex */
public class k<T extends IInterface> extends c<T> {
    private final a.h<T> E;

    @Override // com.google.android.gms.common.internal.b
    protected void M(int i10, T t10) {
        this.E.k(i10, t10);
    }

    @Override // com.google.android.gms.common.internal.b
    protected String m() {
        return this.E.m();
    }

    @Override // com.google.android.gms.common.internal.b
    protected T n(IBinder iBinder) {
        return this.E.n(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public int p() {
        return super.p();
    }

    public a.h<T> q0() {
        return this.E;
    }

    @Override // com.google.android.gms.common.internal.b
    protected String v() {
        return this.E.v();
    }
}
