package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.e;
/* loaded from: classes.dex */
public final class c extends com.google.android.gms.common.internal.c<n> {
    private final GoogleSignInOptions E;

    public c(Context context, Looper looper, b6.c cVar, GoogleSignInOptions googleSignInOptions, d.b bVar, d.c cVar2) {
        super(context, looper, 91, cVar, bVar, cVar2);
        googleSignInOptions = googleSignInOptions == null ? new GoogleSignInOptions.a().a() : googleSignInOptions;
        if (!cVar.d().isEmpty()) {
            GoogleSignInOptions.a aVar = new GoogleSignInOptions.a(googleSignInOptions);
            for (Scope scope : cVar.d()) {
                aVar.f(scope, new Scope[0]);
            }
            googleSignInOptions = aVar.a();
        }
        this.E = googleSignInOptions;
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final boolean f() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String m() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final /* synthetic */ IInterface n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        if (queryLocalInterface instanceof n) {
            return (n) queryLocalInterface;
        }
        return new o(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final int p() {
        return e.f8830a;
    }

    public final GoogleSignInOptions q0() {
        return this.E;
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final Intent s() {
        return d.b(C(), this.E);
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String v() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }
}
