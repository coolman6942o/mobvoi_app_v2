package com.google.android.gms.internal.location;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.c;
/* loaded from: classes.dex */
public class u extends c<g> {
    private final String E;
    protected final t<g> F = new v(this);

    public u(Context context, Looper looper, d.b bVar, d.c cVar, String str, b6.c cVar2) {
        super(context, looper, 23, cVar2, bVar, cVar);
        this.E = str;
    }

    @Override // com.google.android.gms.common.internal.b
    protected Bundle D() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.E);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.b
    protected String m() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected /* synthetic */ IInterface n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return queryLocalInterface instanceof g ? (g) queryLocalInterface : new h(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public int p() {
        return 11925000;
    }

    @Override // com.google.android.gms.common.internal.b
    protected String v() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }
}
