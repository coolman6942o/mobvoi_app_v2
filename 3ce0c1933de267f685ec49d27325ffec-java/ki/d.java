package ki;

import kotlin.jvm.internal.i;
import li.a;
import okhttp3.y;
import th.b;
/* compiled from: WatchFaceApiService.kt */
/* loaded from: classes2.dex */
public final class d extends b {

    /* renamed from: b  reason: collision with root package name */
    public static final d f29985b;

    /* renamed from: c  reason: collision with root package name */
    private static final b f29986c;

    static {
        d dVar = new d();
        f29985b = dVar;
        f29986c = (b) dVar.d().create(b.class);
    }

    private d() {
    }

    @Override // ki.b
    public void b(y.a clientBuilder) {
        i.f(clientBuilder, "clientBuilder");
        clientBuilder.a(new com.mobvoi.assistant.account.data.d()).a(new a());
    }

    @Override // ki.b
    public String c() {
        return "https://discovery.chumenwenwen.com/";
    }

    public final b g() {
        b api = f29986c;
        i.e(api, "api");
        return api;
    }
}
