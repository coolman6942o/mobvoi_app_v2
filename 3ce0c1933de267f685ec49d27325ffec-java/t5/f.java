package t5;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.c;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
final class f extends a.AbstractC0105a<c, GoogleSignInOptions> {
    @Override // com.google.android.gms.common.api.a.e
    public final /* synthetic */ List a(Object obj) {
        GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
        if (googleSignInOptions == null) {
            return Collections.emptyList();
        }
        return googleSignInOptions.H0();
    }

    @Override // com.google.android.gms.common.api.a.AbstractC0105a
    public final /* synthetic */ c c(Context context, Looper looper, b6.c cVar, GoogleSignInOptions googleSignInOptions, d.b bVar, d.c cVar2) {
        return new c(context, looper, cVar, googleSignInOptions, bVar, cVar2);
    }
}
