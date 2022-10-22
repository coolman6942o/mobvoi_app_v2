package uf;

import android.content.Context;
import com.huawei.agconnect.exception.AGCServerException;
import eg.g;
import java.io.IOException;
import okhttp3.Protocol;
import okhttp3.b0;
import okhttp3.v;
import okhttp3.z;
/* compiled from: PermissionInterceptor.java */
/* loaded from: classes2.dex */
public class b implements v {

    /* renamed from: a  reason: collision with root package name */
    private final Context f35413a;

    public b(Context context) {
        this.f35413a = context;
    }

    @Override // okhttp3.v
    public b0 intercept(v.a aVar) throws IOException {
        z request = aVar.request();
        if (!g.a(this.f35413a)) {
            return new b0.a().s(request).p(Protocol.HTTP_1_1).g(AGCServerException.TOKEN_INVALID).m("CMIIT permission not allowed").b(gp.b.f27627c).t(-1L).q(System.currentTimeMillis()).c();
        }
        if (g.b(this.f35413a) || "GET".equals(request.h())) {
            return aVar.a(request);
        }
        return new b0.a().s(request).p(Protocol.HTTP_1_1).g(AGCServerException.TOKEN_INVALID).m("GDPR privacy not enabled").b(gp.b.f27627c).t(-1L).q(System.currentTimeMillis()).c();
    }
}
