package ra;

import com.mobvoi.android.common.utils.k;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.y;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/* compiled from: BaseAccountApi.java */
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    protected Retrofit f33485a = new Retrofit.Builder().baseUrl(q()).client(r()).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(y.a aVar) {
    }

    protected String q() {
        return "https://ticwear-account.mobvoi.com/";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public y r() {
        y.a aVar = new y.a();
        p(aVar);
        if (k.j()) {
            HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(e.f33484b);
            httpLoggingInterceptor.d(level);
            aVar.a(httpLoggingInterceptor);
        }
        return aVar.c();
    }
}
