package nc;

import android.text.TextUtils;
import java.io.IOException;
import kotlin.jvm.internal.i;
import okhttp3.b0;
import okhttp3.v;
import okhttp3.z;
import ta.a;
/* compiled from: TokenInterceptor.kt */
/* loaded from: classes2.dex */
public final class o implements v {
    @Override // okhttp3.v
    public b0 intercept(v.a chain) throws IOException {
        i.f(chain, "chain");
        z.a i10 = chain.request().i();
        String wwToken = a.s();
        if (!TextUtils.isEmpty(wwToken)) {
            i.e(wwToken, "wwToken");
            i10.a("token", wwToken);
        }
        return chain.a(i10.b());
    }
}
