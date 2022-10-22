package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.d;
/* loaded from: classes.dex */
final class c extends e {

    /* renamed from: a  reason: collision with root package name */
    private final d<Status> f9100a;

    public c(d<Status> dVar) {
        this.f9100a = dVar;
    }

    @Override // com.google.android.gms.internal.location.d
    public final void C(zzad zzadVar) {
        this.f9100a.a(zzadVar.getStatus());
    }
}
