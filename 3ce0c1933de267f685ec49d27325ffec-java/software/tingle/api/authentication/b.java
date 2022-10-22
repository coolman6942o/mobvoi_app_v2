package software.tingle.api.authentication;

import java.io.IOException;
import kotlin.jvm.internal.i;
import okhttp3.b0;
import okhttp3.v;
/* compiled from: EmptyAuthenticationProvider.kt */
/* loaded from: classes3.dex */
public final class b implements c {
    @Override // okhttp3.v
    public b0 intercept(v.a chain) throws IOException {
        i.f(chain, "chain");
        return chain.a(chain.request());
    }
}
