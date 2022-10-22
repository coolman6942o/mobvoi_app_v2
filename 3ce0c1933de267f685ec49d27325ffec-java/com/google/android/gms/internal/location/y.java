package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.location.LocationRequest;
import w6.a;
import w6.c;
/* loaded from: classes.dex */
public final class y implements a {
    @Override // w6.a
    public final Location a(d dVar) {
        try {
            return w6.d.b(dVar).r0();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // w6.a
    public final e<Status> b(d dVar, c cVar) {
        return dVar.k(new a0(this, dVar, cVar));
    }

    @Override // w6.a
    public final e<Status> c(d dVar, LocationRequest locationRequest, c cVar, Looper looper) {
        return dVar.k(new z(this, dVar, locationRequest, cVar, looper));
    }
}
