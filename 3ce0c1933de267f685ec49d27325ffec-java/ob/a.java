package ob;

import com.mobvoi.android.common.utils.o;
import com.mobvoi.be.ticassistant.DeviceInfoProto;
import java.util.concurrent.TimeUnit;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.y;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.protobuf.ProtoConverterFactory;
import rx.c;
/* compiled from: DeviceListApiHelper.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private pb.a f31488a;

    /* renamed from: b  reason: collision with root package name */
    private pb.a f31489b;

    /* compiled from: DeviceListApiHelper.java */
    /* loaded from: classes2.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private static a f31490a = new a();
    }

    private pb.a b(y yVar) {
        return (pb.a) new Retrofit.Builder().client(yVar).baseUrl("https://tic-assistant.mobvoi.com/").addConverterFactory(ProtoConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build().create(pb.a.class);
    }

    public static a c() {
        return b.f31490a;
    }

    public c<DeviceInfoProto.DeviceInfoResponse> a(DeviceInfoProto.BindDataCollection bindDataCollection) {
        o.e(bindDataCollection);
        return this.f31489b.a(bindDataCollection);
    }

    private a() {
        y.a aVar = new y.a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        y.a e10 = aVar.e(20L, timeUnit);
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        this.f31488a = b(e10.a(httpLoggingInterceptor.d(level)).c());
        this.f31489b = b(new y.a().e(20L, timeUnit).a(new HttpLoggingInterceptor().d(level)).a(new ob.b()).c());
    }
}
