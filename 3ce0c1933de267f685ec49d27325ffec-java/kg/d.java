package kg;

import android.content.Context;
import com.huawei.agconnect.exception.AGCServerException;
import com.mobvoi.android.common.utils.k;
import fg.u;
import gp.b;
import java.io.IOException;
import okhttp3.Protocol;
import okhttp3.b0;
import okhttp3.v;
import ta.a;
/* compiled from: PiiInterceptor.java */
/* loaded from: classes2.dex */
public class d implements v {

    /* renamed from: a  reason: collision with root package name */
    private final Context f29889a;

    public d(Context context) {
        this.f29889a = context;
    }

    @Override // okhttp3.v
    public b0 intercept(v.a aVar) throws IOException {
        String h10 = aVar.request().h();
        k.a("PiiInterceptor", h10);
        if (a.b() || "GET".equals(h10)) {
            return aVar.a(aVar.request());
        }
        return new b0.a().s(aVar.request()).p(Protocol.HTTP_1_1).g(AGCServerException.TOKEN_INVALID).m(this.f29889a.getString(u.f26883e4)).b(b.f27627c).t(-1L).q(System.currentTimeMillis()).c();
    }
}
