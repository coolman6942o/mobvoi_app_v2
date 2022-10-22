package x5;

import android.content.Intent;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import w5.a;
import w5.b;
/* loaded from: classes.dex */
public final class e implements a {
    private static GoogleSignInOptions e(d dVar) {
        return ((c) dVar.m(t5.a.f35054b)).q0();
    }

    @Override // w5.a
    public final Intent a(d dVar) {
        return com.google.android.gms.auth.api.signin.internal.d.b(dVar.n(), e(dVar));
    }

    @Override // w5.a
    public final b b(Intent intent) {
        return com.google.android.gms.auth.api.signin.internal.d.a(intent);
    }

    @Override // w5.a
    public final com.google.android.gms.common.api.e<Status> c(d dVar) {
        return com.google.android.gms.auth.api.signin.internal.d.e(dVar, dVar.n(), false);
    }

    @Override // w5.a
    public final com.google.android.gms.common.api.e<Status> d(d dVar) {
        return com.google.android.gms.auth.api.signin.internal.d.c(dVar, dVar.n(), false);
    }
}
