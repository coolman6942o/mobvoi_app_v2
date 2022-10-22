package bc;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.i;
import okhttp3.b0;
import okhttp3.u;
import okhttp3.v;
import okhttp3.z;
/* compiled from: BaseUrlInterceptor.kt */
/* loaded from: classes2.dex */
public final class a implements v {
    @Override // okhttp3.v
    public b0 intercept(v.a chain) throws IOException {
        u uVar;
        i.f(chain, "chain");
        z request = chain.request();
        u l10 = request.l();
        z.a i10 = request.i();
        List<String> e10 = request.e("url_name");
        if (e10 == null || !(!e10.isEmpty())) {
            return chain.a(request);
        }
        i10.m("url_name");
        String str = e10.get(0);
        if (i.b(str, "appstore")) {
            uVar = u.f32275l.f("https://awch-appstore.ticwear.com/");
        } else {
            uVar = i.b(str, "card") ? u.f32275l.f("https://developer-center.ticwear.com/") : l10;
        }
        u.a j10 = l10.j();
        i.d(uVar);
        return chain.a(i10.q(j10.s(uVar.t()).i(uVar.h()).o(uVar.n()).e()).b());
    }
}
