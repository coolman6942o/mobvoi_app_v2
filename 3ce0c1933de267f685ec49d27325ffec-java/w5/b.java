package w5;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
/* loaded from: classes.dex */
public class b implements h {

    /* renamed from: a  reason: collision with root package name */
    private Status f36003a;

    /* renamed from: b  reason: collision with root package name */
    private GoogleSignInAccount f36004b;

    public b(GoogleSignInAccount googleSignInAccount, Status status) {
        this.f36004b = googleSignInAccount;
        this.f36003a = status;
    }

    public GoogleSignInAccount a() {
        return this.f36004b;
    }

    public boolean b() {
        return this.f36003a.K0();
    }

    @Override // com.google.android.gms.common.api.h
    public Status getStatus() {
        return this.f36003a;
    }
}
