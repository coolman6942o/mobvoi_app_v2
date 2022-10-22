package x5;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: b  reason: collision with root package name */
    private static f f36456b;

    /* renamed from: a  reason: collision with root package name */
    private b f36457a;

    private f(Context context) {
        b b10 = b.b(context);
        this.f36457a = b10;
        b10.c();
        this.f36457a.d();
    }

    public static synchronized f c(Context context) {
        f d10;
        synchronized (f.class) {
            d10 = d(context.getApplicationContext());
        }
        return d10;
    }

    private static synchronized f d(Context context) {
        f fVar;
        synchronized (f.class) {
            if (f36456b == null) {
                f36456b = new f(context);
            }
            fVar = f36456b;
        }
        return fVar;
    }

    public final synchronized void a() {
        this.f36457a.a();
    }

    public final synchronized void b(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.f36457a.f(googleSignInAccount, googleSignInOptions);
    }
}
