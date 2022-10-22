package ld;

import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.m;
import java.io.IOException;
import okhttp3.b0;
import okhttp3.d;
import okhttp3.v;
import okhttp3.z;
/* compiled from: CacheInterceptor.java */
/* loaded from: classes2.dex */
public class a implements v {
    @Override // okhttp3.v
    public b0 intercept(v.a aVar) throws IOException {
        z request = aVar.request();
        if (m.b(b.e().getApplicationContext())) {
            b0 a10 = aVar.a(request);
            request.b().toString();
            b0.a r10 = a10.Q().r("Pragma").r("Cache-Control");
            return r10.j("Cache-Control", "public, max-age=1").c();
        }
        b0.a r11 = aVar.a(request.i().c(d.f31817n).b()).Q().r("Pragma").r("Cache-Control");
        return r11.j("Cache-Control", "public, only-if-cached, max-stale=259200").c();
    }
}
