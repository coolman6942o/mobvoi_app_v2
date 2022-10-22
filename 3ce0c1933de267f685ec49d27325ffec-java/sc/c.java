package sc;

import com.mobvoi.assistant.account.data.d;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.i;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.y;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.protobuf.ProtoConverterFactory;
/* compiled from: RetrofitModule.kt */
/* loaded from: classes2.dex */
public final class c {
    public final a a(Retrofit retrofit) {
        i.f(retrofit, "retrofit");
        Object create = retrofit.create(a.class);
        i.e(create, "retrofit.create(HealthDataApi::class.java)");
        return (a) create;
    }

    public final Retrofit b() {
        Retrofit build = new Retrofit.Builder().client(new y.a().e(20L, TimeUnit.SECONDS).a(new HttpLoggingInterceptor(null, 1, null).d(HttpLoggingInterceptor.Level.BODY)).c()).baseUrl("https://fitness.mobvoi.com").addConverterFactory(ProtoConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        i.e(build, "Builder()\n            .client(builder.build())\n            .baseUrl(HEALTH_BASE_URL)\n            .addConverterFactory(ProtoConverterFactory.create())\n            .addConverterFactory(GsonConverterFactory.create())\n            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())\n            .build()");
        return build;
    }

    public final Retrofit c() {
        y.a a10 = new y.a().a(new HttpLoggingInterceptor(null, 1, null).d(HttpLoggingInterceptor.Level.BODY)).a(new d());
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Retrofit build = new Retrofit.Builder().client(a10.e(30L, timeUnit).M(20L, timeUnit).O(20L, timeUnit).c()).baseUrl("http://health.ticwear.com").addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        i.e(build, "Builder()\n            .client(okHttpClient)\n            .baseUrl(SPORT_BASE_URL)\n            .addConverterFactory(GsonConverterFactory.create())\n            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())\n            .build()");
        return build;
    }

    public final h d(Retrofit retrofit) {
        i.f(retrofit, "retrofit");
        Object create = retrofit.create(h.class);
        i.e(create, "retrofit.create(SportMedalApi::class.java)");
        return (h) create;
    }
}
