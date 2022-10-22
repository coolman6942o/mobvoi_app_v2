package kg;

import android.content.Context;
import com.mobvoi.android.common.utils.k;
import java.util.concurrent.TimeUnit;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.y;
import qf.f;
import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastJsonConverterFactory;
import uf.a;
import wf.m;
/* compiled from: HealthServerImpl.java */
/* loaded from: classes2.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final Retrofit f29885a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f29886b;

    /* renamed from: c  reason: collision with root package name */
    private final a f29887c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29888d = false;

    public c(Context context, f fVar) {
        this.f29886b = context;
        this.f29885a = g(context);
        this.f29887c = new a(this, fVar);
    }

    public static Retrofit g(Context context) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(b.f29884b);
        httpLoggingInterceptor.d(HttpLoggingInterceptor.Level.BODY);
        y.a b10 = new y.a().a(new h(context)).a(new d(context)).b(httpLoggingInterceptor);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return new Retrofit.Builder().baseUrl("https://fitness.mobvoi.com/").client(b10.e(30L, timeUnit).M(60L, timeUnit).O(60L, timeUnit).c()).addConverterFactory(FastJsonConverterFactory.create()).build();
    }

    @Override // uf.a
    public <T> T a(Class<T> cls) {
        return (T) this.f29885a.create(cls);
    }

    @Override // uf.a
    public boolean b() {
        return this.f29888d;
    }

    @Override // uf.a
    public String c(String str) {
        return this.f29887c.d(str);
    }

    @Override // uf.a
    public void d(boolean z10) {
        this.f29888d = z10;
    }

    @Override // uf.a
    public m e(String str, yf.c cVar) {
        m c10 = this.f29887c.c(str, cVar);
        if (c10 == null) {
            k.f("health.net.server", "Failed to find device for dataSource[%s]", str);
        }
        return c10;
    }

    public Context h() {
        return this.f29886b;
    }
}
