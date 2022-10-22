package kg;

import android.content.Context;
import bf.c;
import com.tendcloud.tenddata.ab;
import java.util.concurrent.TimeUnit;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.y;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;
/* compiled from: UserSportTypeSettingClient.java */
/* loaded from: classes2.dex */
public class j implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f29896a;

    /* renamed from: b  reason: collision with root package name */
    private final Retrofit f29897b;

    public j(Context context) {
        this.f29896a = context;
        this.f29897b = d(context);
    }

    private Retrofit d(Context context) {
        y.a a10 = new y.a().a(new HttpLoggingInterceptor(i.f29895b).d(HttpLoggingInterceptor.Level.BODY)).a(new e(context)).a(new d(context));
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return new Retrofit.Builder().baseUrl("https://health.ticwear.com/").client(a10.M(ab.Y, timeUnit).O(ab.Y, timeUnit).c()).addConverterFactory(FastJsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
    }

    @Override // bf.c
    public <T> T a(Class<T> cls) {
        return (T) this.f29897b.create(cls);
    }

    @Override // bf.c
    public String b() {
        return com.mobvoi.health.companion.system.c.a().a(this.f29896a);
    }
}
