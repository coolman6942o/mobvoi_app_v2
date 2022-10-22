package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.f;
import e6.a;
import w5.b;
import x5.c;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static a f8428a = new a("GoogleSignInCommon", new String[0]);

    public static b a(Intent intent) {
        if (intent == null) {
            return null;
        }
        if (!intent.hasExtra("googleSignInStatus") && !intent.hasExtra("googleSignInAccount")) {
            return null;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
        if (googleSignInAccount != null) {
            status = Status.f8444e;
        }
        return new b(googleSignInAccount, status);
    }

    public static Intent b(Context context, GoogleSignInOptions googleSignInOptions) {
        f8428a.a("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }

    public static e<Status> c(com.google.android.gms.common.api.d dVar, Context context, boolean z10) {
        f8428a.a("Signing out", new Object[0]);
        d(context);
        if (z10) {
            return f.b(Status.f8444e, dVar);
        }
        return dVar.k(new e(dVar));
    }

    private static void d(Context context) {
        x5.f.c(context).a();
        for (com.google.android.gms.common.api.d dVar : com.google.android.gms.common.api.d.l()) {
            dVar.r();
        }
        com.google.android.gms.common.api.internal.e.b();
    }

    public static e<Status> e(com.google.android.gms.common.api.d dVar, Context context, boolean z10) {
        f8428a.a("Revoking access", new Object[0]);
        String e10 = x5.b.b(context).e();
        d(context);
        if (z10) {
            return c.a(e10);
        }
        return dVar.k(new g(dVar));
    }
}
