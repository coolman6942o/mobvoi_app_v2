package com.google.android.gms.location;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.api.internal.p;
import com.google.android.gms.internal.location.e;
import com.google.android.gms.internal.location.zzad;
import com.google.android.gms.internal.location.zzbd;
import com.google.android.gms.tasks.b;
import w6.d;
/* loaded from: classes.dex */
public class a extends c<Object> {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.gms.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class BinderC0114a extends e {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.android.gms.tasks.c<Void> f9951a;

        public BinderC0114a(com.google.android.gms.tasks.c<Void> cVar) {
            this.f9951a = cVar;
        }

        @Override // com.google.android.gms.internal.location.d
        public final void C(zzad zzadVar) {
            p.a(zzadVar.getStatus(), this.f9951a);
        }
    }

    public a(Context context) {
        super(context, (com.google.android.gms.common.api.a<a.d>) d.f36007c, (a.d) null, (m) new com.google.android.gms.common.api.internal.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.google.android.gms.internal.location.d t(com.google.android.gms.tasks.c<Boolean> cVar) {
        return new p(this, cVar);
    }

    public b<Location> p() {
        return c(new m(this));
    }

    public b<Void> q(w6.b bVar) {
        return p.c(e(j.b(bVar, w6.b.class.getSimpleName())));
    }

    public b<Void> r(LocationRequest locationRequest, w6.b bVar, Looper looper) {
        zzbd G0 = zzbd.G0(locationRequest);
        i a10 = j.a(bVar, t6.e.a(looper), w6.b.class.getSimpleName());
        return d(new n(this, a10, G0, a10), new o(this, a10.b()));
    }
}
