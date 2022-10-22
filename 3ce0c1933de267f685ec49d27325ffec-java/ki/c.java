package ki;

import com.mobvoi.assistant.account.data.d;
import kotlin.jvm.internal.i;
import okhttp3.y;
import th.a;
/* compiled from: JsonWebTokenApiService.kt */
/* loaded from: classes2.dex */
public final class c extends b {

    /* renamed from: b  reason: collision with root package name */
    public static final c f29983b;

    /* renamed from: c  reason: collision with root package name */
    private static final a f29984c;

    static {
        c cVar = new c();
        f29983b = cVar;
        f29984c = (a) cVar.d().create(a.class);
    }

    private c() {
    }

    @Override // ki.b
    public void b(y.a clientBuilder) {
        i.f(clientBuilder, "clientBuilder");
        clientBuilder.a(new d());
    }

    @Override // ki.b
    public String c() {
        return "https://galaxy.mobvoi.com";
    }

    public final a g() {
        a api = f29984c;
        i.e(api, "api");
        return api;
    }
}
