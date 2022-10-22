package bk;

import dk.b;
import dk.c;
import io.reactivex.k;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.v;
import okhttp3.y;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/* compiled from: TicCareApiHelper.java */
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private ck.a f5167a;

    public a() {
        y.a aVar = new y.a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        y.a a10 = aVar.M(30L, timeUnit).e(30L, timeUnit).O(30L, timeUnit).a(new HttpLoggingInterceptor().d(HttpLoggingInterceptor.Level.BODY));
        if (d() != null) {
            a10.a(d());
        }
        this.f5167a = (ck.a) new Retrofit.Builder().client(a10.c()).baseUrl("https://ticwear-account.mobvoi.com/").addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(ck.a.class);
    }

    public k<c> a(String str, HashMap<String, String> hashMap) {
        return this.f5167a.h(str, hashMap).subscribeOn(go.a.b()).observeOn(wn.a.a());
    }

    public k<c> b(String str, String str2, String str3) {
        return this.f5167a.a(str, str2, str3).subscribeOn(go.a.b()).observeOn(wn.a.a());
    }

    public k<c> c(String str, String str2) {
        return this.f5167a.i(str, str2).subscribeOn(go.a.b()).observeOn(wn.a.a());
    }

    public abstract v d();

    public k<com.mobvoi.ticcare.common.model.bean.a> e(String str) {
        return this.f5167a.e(str).subscribeOn(go.a.b()).observeOn(wn.a.a());
    }

    public k<b> f(String str, String str2) {
        return this.f5167a.f(str, str2).subscribeOn(go.a.b()).observeOn(wn.a.a());
    }

    public k<com.mobvoi.ticcare.common.model.bean.b> g(String str) {
        return this.f5167a.g(str).subscribeOn(go.a.b()).observeOn(wn.a.a());
    }

    public k<dk.a> h(String str) {
        return this.f5167a.d(str).subscribeOn(go.a.b()).observeOn(wn.a.a());
    }

    public k<c> i(String str, HashMap<String, String> hashMap) {
        return this.f5167a.c(str, hashMap).subscribeOn(go.a.b()).observeOn(wn.a.a());
    }

    public k<c> j(String str, String str2, boolean z10) {
        return this.f5167a.b(str, str2, z10).subscribeOn(go.a.b()).observeOn(wn.a.a());
    }
}
