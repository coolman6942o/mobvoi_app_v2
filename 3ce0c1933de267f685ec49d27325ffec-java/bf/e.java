package bf;

import android.content.Context;
import com.mobvoi.wear.info.AccountInfoHelper;
import com.tendcloud.tenddata.ab;
import java.util.concurrent.TimeUnit;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.y;
import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastJsonConverterFactory;
import uf.b;
/* compiled from: SportServerWear.java */
/* loaded from: classes2.dex */
public class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5136a;

    /* renamed from: b  reason: collision with root package name */
    private final Retrofit f5137b;

    public e(Context context) {
        this.f5136a = context;
        this.f5137b = d(context);
    }

    private Retrofit d(Context context) {
        y.a a10 = new y.a().a(new HttpLoggingInterceptor(d.f5135b).d(HttpLoggingInterceptor.Level.BODY)).a(new b(context)).a(new b(context));
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return new Retrofit.Builder().baseUrl("https://health.ticwear.com/").client(a10.M(ab.Y, timeUnit).O(ab.Y, timeUnit).c()).addConverterFactory(FastJsonConverterFactory.create()).build();
    }

    @Override // bf.c
    public <T> T a(Class<T> cls) {
        return (T) this.f5137b.create(cls);
    }

    @Override // bf.c
    public String b() {
        return AccountInfoHelper.getInstance(this.f5136a).getAccountId();
    }
}
