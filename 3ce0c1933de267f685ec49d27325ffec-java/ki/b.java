package ki;

import com.mobvoi.android.common.utils.k;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.y;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.protobuf.ProtoConverterFactory;
/* compiled from: BaseService.kt */
/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private final Retrofit f29982a;

    /* compiled from: BaseService.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    public b() {
        Retrofit build = new Retrofit.Builder().baseUrl(c()).client(e()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(ProtoConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
        i.e(build, "Builder()\n            .baseUrl(getBaseUrl())\n            .client(okHttpClient())\n            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())\n            .addConverterFactory(ProtoConverterFactory.create())\n            .addConverterFactory(GsonConverterFactory.create())\n            .build()");
        this.f29982a = build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String message) {
        i.f(message, "message");
        k.a("BaseService", message);
    }

    public abstract void b(y.a aVar);

    public abstract String c();

    public final Retrofit d() {
        return this.f29982a;
    }

    public y e() {
        y.a aVar = new y.a();
        if (k.j()) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(ki.a.f29981b);
            httpLoggingInterceptor.b(HttpLoggingInterceptor.Level.BODY);
            aVar.a(httpLoggingInterceptor);
        }
        b(aVar);
        return aVar.c();
    }
}
