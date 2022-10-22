package okhttp3.internal.connection;

import java.io.IOException;
import jp.g;
import kotlin.jvm.internal.i;
import okhttp3.b0;
import okhttp3.v;
/* compiled from: ConnectInterceptor.kt */
/* loaded from: classes3.dex */
public final class a implements v {

    /* renamed from: a  reason: collision with root package name */
    public static final a f31944a = new a();

    private a() {
    }

    @Override // okhttp3.v
    public b0 intercept(v.a chain) throws IOException {
        i.f(chain, "chain");
        g gVar = (g) chain;
        return g.d(gVar, 0, gVar.e().r(gVar), null, 0, 0, 0, 61, null).a(gVar.i());
    }
}
