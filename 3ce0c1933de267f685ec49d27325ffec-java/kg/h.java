package kg;

import android.content.Context;
import com.mobvoi.health.companion.system.c;
import java.io.IOException;
import okhttp3.b0;
import okhttp3.v;
/* compiled from: TokenInterceptor.java */
/* loaded from: classes2.dex */
public class h implements v {

    /* renamed from: a  reason: collision with root package name */
    private final Context f29894a;

    public h(Context context) {
        this.f29894a = context;
    }

    private String a() {
        return c.a().b(this.f29894a);
    }

    @Override // okhttp3.v
    public b0 intercept(v.a aVar) throws IOException {
        return aVar.a(aVar.request().i().h("Token", a()).b());
    }
}
