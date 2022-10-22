package eb;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.mobvoi.android.common.utils.k;
import db.b;
import t5.a;
/* compiled from: GoogleLoginManager.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static c f25880c;

    /* renamed from: a  reason: collision with root package name */
    private a f25881a = null;

    /* renamed from: b  reason: collision with root package name */
    private d f25882b;

    private c(Context context) {
        context.getApplicationContext();
    }

    public static synchronized c b(Context context) {
        c cVar;
        synchronized (c.class) {
            if (f25880c == null) {
                synchronized (c.class) {
                    if (f25880c == null) {
                        f25880c = new c(context);
                    }
                }
            }
            cVar = f25880c;
        }
        return cVar;
    }

    private void d(f fVar, String str) {
        GoogleSignInOptions a10 = new GoogleSignInOptions.a(GoogleSignInOptions.f8392p).b().e().d(str).a();
        d dVar = this.f25882b;
        if (dVar == null || !dVar.p()) {
            this.f25882b = new d.a(fVar.getApplicationContext()).h(fVar, this.f25881a).b(a.f35057e, a10).e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Status status) {
        a aVar = this.f25881a;
        if (aVar != null) {
            aVar.c(status);
        }
    }

    public void c(f fVar, String str) {
        d(fVar, str);
    }

    public void f(Fragment fragment, b bVar) {
        k.a("GoogleLoginManager", "login");
        d dVar = this.f25882b;
        if (dVar != null) {
            fragment.startActivityForResult(a.f35058f.a(dVar), 12345);
            this.f25881a = new a(bVar);
        }
    }

    public void g(Context context) {
        k.a("GoogleLoginManager", "logout");
        d dVar = this.f25882b;
        if (dVar != null) {
            a.f35058f.d(dVar).e(new i() { // from class: eb.b
                @Override // com.google.android.gms.common.api.i
                public final void a(h hVar) {
                    c.this.e((Status) hVar);
                }
            });
        }
    }

    public void h(int i10, int i11, Intent intent) {
        k.a("GoogleLoginManager", "onActivityResult");
        if (i10 == 12345 && this.f25881a != null) {
            this.f25881a.b(a.f35058f.b(intent));
        }
    }

    public void i(b bVar) {
        a aVar = this.f25881a;
        if (aVar != null) {
            aVar.d(bVar);
        }
    }
}
