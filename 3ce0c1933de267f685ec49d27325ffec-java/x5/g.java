package x5;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.k;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.e;
import t5.a;
/* loaded from: classes.dex */
public final class g extends k {

    /* renamed from: a  reason: collision with root package name */
    private final Context f36458a;

    public g(Context context) {
        this.f36458a = context;
    }

    private final void m1() {
        if (!e.h(this.f36458a, Binder.getCallingUid())) {
            int callingUid = Binder.getCallingUid();
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Calling UID ");
            sb2.append(callingUid);
            sb2.append(" is not Google Play services.");
            throw new SecurityException(sb2.toString());
        }
    }

    @Override // com.google.android.gms.auth.api.signin.internal.j
    public final void h2() {
        m1();
        f.c(this.f36458a).a();
    }

    @Override // com.google.android.gms.auth.api.signin.internal.j
    public final void n() {
        m1();
        b b10 = b.b(this.f36458a);
        GoogleSignInAccount c10 = b10.c();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.f8392p;
        if (c10 != null) {
            googleSignInOptions = b10.d();
        }
        d e10 = new d.a(this.f36458a).b(a.f35057e, googleSignInOptions).e();
        try {
            if (e10.d().K0()) {
                if (c10 != null) {
                    a.f35058f.c(e10);
                } else {
                    e10.e();
                }
            }
        } finally {
            e10.h();
        }
    }
}
