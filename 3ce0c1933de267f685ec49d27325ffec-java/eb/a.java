package eb;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.data.AccountManager;
import db.b;
/* compiled from: GoogleLoginListener.java */
/* loaded from: classes2.dex */
public class a implements d.c {

    /* renamed from: a  reason: collision with root package name */
    private b f25878a;

    public a(b bVar) {
        this.f25878a = bVar;
    }

    private void a(w5.b bVar) {
        if (bVar == null || !bVar.b()) {
            b bVar2 = this.f25878a;
            if (bVar2 != null) {
                bVar2.d("google", "login error");
                return;
            }
            return;
        }
        k.c("GoogleLoginListener", "handleSignInResult status : %s", bVar.getStatus());
        GoogleSignInAccount a10 = bVar.a();
        if (a10 != null) {
            String id2 = a10.getId();
            String Q = a10.Q();
            String G0 = a10.G0();
            String uri = a10.K0().toString();
            sa.a aVar = new sa.a();
            aVar.email = G0;
            aVar.nickName = Q;
            aVar.headUrl = uri;
            ta.a.E(aVar);
            AccountManager.h().o(aVar);
            b bVar3 = this.f25878a;
            if (bVar3 != null) {
                bVar3.g("google", id2);
            }
            ta.a.L(true);
        }
    }

    public void b(w5.b bVar) {
        a(bVar);
    }

    public void c(Status status) {
        if (status != null) {
            ta.a.L(false);
        }
    }

    public void d(b bVar) {
        this.f25878a = bVar;
    }

    @Override // com.google.android.gms.common.api.d.c
    public void onConnectionFailed(ConnectionResult connectionResult) {
        k.d("GoogleLoginListener", "onFailure : " + connectionResult.H0());
        b bVar = this.f25878a;
        if (bVar != null) {
            bVar.d("google", "onGoogleLoginException : " + connectionResult.H0());
        }
    }
}
