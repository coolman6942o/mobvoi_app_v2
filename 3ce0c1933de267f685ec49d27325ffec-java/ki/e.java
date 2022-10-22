package ki;

import com.mobvoi.assistant.account.data.d;
import kotlin.jvm.internal.i;
import okhttp3.y;
import th.c;
/* compiled from: WeatherApiService.kt */
/* loaded from: classes2.dex */
public final class e extends b {

    /* renamed from: b  reason: collision with root package name */
    public static final e f29987b;

    /* renamed from: c  reason: collision with root package name */
    private static final c f29988c;

    static {
        e eVar = new e();
        f29987b = eVar;
        f29988c = (c) eVar.d().create(c.class);
    }

    private e() {
    }

    @Override // ki.b
    public void b(y.a clientBuilder) {
        i.f(clientBuilder, "clientBuilder");
        clientBuilder.a(new d());
    }

    @Override // ki.b
    public String c() {
        return "https://cardstream.mobvoi.com";
    }

    public final c g() {
        c api = f29988c;
        i.e(api, "api");
        return api;
    }
}
