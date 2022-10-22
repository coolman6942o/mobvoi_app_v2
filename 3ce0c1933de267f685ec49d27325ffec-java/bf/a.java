package bf;

import android.text.TextUtils;
import gp.b;
import java.io.IOException;
import java.util.List;
import okhttp3.Protocol;
import okhttp3.b0;
import okhttp3.u;
import okhttp3.v;
import okhttp3.z;
/* compiled from: AuthInterceptor.java */
/* loaded from: classes2.dex */
public abstract class a implements v {
    public abstract String a();

    public abstract String b();

    public abstract String c();

    @Override // okhttp3.v
    public b0 intercept(v.a aVar) throws IOException {
        z request = aVar.request();
        if (!TextUtils.isEmpty(request.d("skip_auth"))) {
            return aVar.a(request);
        }
        String a10 = a();
        String b10 = b();
        String c10 = c();
        if (TextUtils.isEmpty(a10) || TextUtils.isEmpty(b10)) {
            return new b0.a().s(aVar.request()).p(Protocol.HTTP_1_1).g(TextUtils.isEmpty(a10) ? 1400100 : 1400101).m("Login required").b(b.f27627c).c();
        }
        u.a j10 = request.l().j();
        List<String> m10 = request.l().m();
        for (int i10 = 0; i10 < m10.size(); i10++) {
            String str = m10.get(i10);
            if ("{account-id}".equalsIgnoreCase(str)) {
                j10.x(i10, a10);
            } else if ("{careWwid}".equalsIgnoreCase(str)) {
                j10.x(i10, c10);
            }
        }
        j10.d("sessionId", b10);
        return aVar.a(request.i().q(j10.e()).h("Token", b10).b());
    }
}
