package com.google.android.gms.wearable.internal;

import c7.c1;
import c7.d1;
import c7.o0;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.wearable.a;
/* loaded from: classes.dex */
final class s extends r<a.b> {
    public s(d<a.b> dVar) {
        super(dVar);
    }

    @Override // c7.a, com.google.android.gms.wearable.internal.d
    public final void N0(zzdk zzdkVar) {
        Status a10 = o0.a(zzdkVar.f10249a);
        zzah zzahVar = zzdkVar.f10250b;
        m1(new d1(a10, zzahVar == null ? null : new c1(zzahVar)));
    }
}
