package com.google.android.gms.signin.internal;

import a7.e;
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import b6.i;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.f;
/* loaded from: classes.dex */
public class a extends c<f> implements e {
    private final boolean E;
    private final b6.c F;
    private final Bundle G;
    private Integer H;

    private a(Context context, Looper looper, boolean z10, b6.c cVar, Bundle bundle, d.b bVar, d.c cVar2) {
        super(context, looper, 44, cVar, bVar, cVar2);
        this.E = true;
        this.F = cVar;
        this.G = bundle;
        this.H = cVar.f();
    }

    public static Bundle q0(b6.c cVar) {
        a7.a k10 = cVar.k();
        Integer f10 = cVar.f();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", cVar.a());
        if (f10 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", f10.intValue());
        }
        if (k10 != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", k10.g());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", k10.f());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", k10.d());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", k10.e());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", k10.b());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", k10.h());
            if (k10.a() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", k10.a().longValue());
            }
            if (k10.c() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", k10.c().longValue());
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.b
    protected Bundle D() {
        if (!C().getPackageName().equals(this.F.i())) {
            this.G.putString("com.google.android.gms.signin.internal.realClientPackageName", this.F.i());
        }
        return this.G;
    }

    @Override // a7.e
    public final void b() {
        j(new b.d());
    }

    @Override // a7.e
    public final void c(f fVar, boolean z10) {
        try {
            ((f) G()).n0(fVar, this.H.intValue(), z10);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // a7.e
    public final void d() {
        try {
            ((f) G()).B(this.H.intValue());
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    @Override // com.google.android.gms.common.internal.b
    protected String m() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected /* synthetic */ IInterface n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof f) {
            return (f) queryLocalInterface;
        }
        return new g(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public int p() {
        return com.google.android.gms.common.e.f8830a;
    }

    @Override // a7.e
    public final void q(d dVar) {
        i.l(dVar, "Expecting a valid ISignInCallbacks");
        try {
            Account c10 = this.F.c();
            GoogleSignInAccount googleSignInAccount = null;
            if ("<<default account>>".equals(c10.name)) {
                googleSignInAccount = x5.b.b(C()).c();
            }
            ((f) G()).y0(new zah(new ResolveAccountRequest(c10, this.H.intValue(), googleSignInAccount)), dVar);
        } catch (RemoteException e10) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                dVar.A(new zaj(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e10);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public boolean t() {
        return this.E;
    }

    @Override // com.google.android.gms.common.internal.b
    protected String v() {
        return "com.google.android.gms.signin.service.START";
    }

    public a(Context context, Looper looper, boolean z10, b6.c cVar, a7.a aVar, d.b bVar, d.c cVar2) {
        this(context, looper, true, cVar, q0(cVar), bVar, cVar2);
    }
}
