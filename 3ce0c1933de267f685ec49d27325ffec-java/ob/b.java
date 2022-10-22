package ob;

import com.mobvoi.android.common.utils.f;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import okhttp3.b0;
import okhttp3.v;
import okhttp3.z;
/* compiled from: ReqAppkeyInterceptor.java */
/* loaded from: classes2.dex */
public class b implements v {
    @Override // okhttp3.v
    public b0 intercept(v.a aVar) throws IOException {
        z request = aVar.request();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            request = request.i().a("appkey", "vpa-android").a("timestamp", String.valueOf(currentTimeMillis)).a("sign", f.g("vpa-androidhEawSDVirkQFl4VI0IvdyKwJCaMaTEC8" + currentTimeMillis, "SHA-256")).b();
        } catch (NoSuchAlgorithmException unused) {
        }
        return aVar.a(request);
    }
}
