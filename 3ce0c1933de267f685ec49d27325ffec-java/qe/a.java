package qe;

import com.mobvoi.android.common.utils.k;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.y;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/* compiled from: BaseRetrofitApi.java */
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected Retrofit f33122a = new Retrofit.Builder().baseUrl(b()).client(c()).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseRetrofitApi.java */
    /* renamed from: qe.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0454a implements HttpLoggingInterceptor.a {
        C0454a(a aVar) {
        }

        @Override // okhttp3.logging.HttpLoggingInterceptor.a
        public void a(String str) {
            k.a("BaseAccountApi", str);
        }
    }

    private y c() {
        y.a aVar = new y.a();
        a(aVar);
        if (k.j()) {
            HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new C0454a(this));
            httpLoggingInterceptor.d(level);
            aVar.a(httpLoggingInterceptor);
        }
        return aVar.c();
    }

    protected void a(y.a aVar) {
    }

    protected abstract String b();
}
