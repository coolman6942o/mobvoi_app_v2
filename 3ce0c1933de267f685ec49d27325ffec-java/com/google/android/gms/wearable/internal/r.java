package com.google.android.gms.wearable.internal;

import c7.a;
import com.google.android.gms.common.api.internal.d;
/* loaded from: classes.dex */
class r<T> extends a {

    /* renamed from: a  reason: collision with root package name */
    private d<T> f10223a;

    public r(d<T> dVar) {
        this.f10223a = dVar;
    }

    public final void m1(T t10) {
        d<T> dVar = this.f10223a;
        if (dVar != null) {
            dVar.a(t10);
            this.f10223a = null;
        }
    }
}
