package nc;

import com.google.common.base.v;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.y;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.protobuf.ProtoConverterFactory;
/* compiled from: MobvoiPushModule.kt */
/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f31129a = new i();

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a d(Retrofit retrofit) {
        kotlin.jvm.internal.i.f(retrofit, "$retrofit");
        return (a) retrofit.create(a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a f(Retrofit retrofit) {
        kotlin.jvm.internal.i.f(retrofit, "$retrofit");
        return (a) retrofit.create(a.class);
    }

    public final v<a> c(final Retrofit retrofit) {
        kotlin.jvm.internal.i.f(retrofit, "retrofit");
        return new v() { // from class: nc.g
            @Override // com.google.common.base.v, java.util.function.Supplier
            public final Object get() {
                a d10;
                d10 = i.d(Retrofit.this);
                return d10;
            }
        };
    }

    public final v<a> e(final Retrofit retrofit) {
        kotlin.jvm.internal.i.f(retrofit, "retrofit");
        return new v() { // from class: nc.h
            @Override // com.google.common.base.v, java.util.function.Supplier
            public final Object get() {
                a f10;
                f10 = i.f(Retrofit.this);
                return f10;
            }
        };
    }

    public final y g() {
        y.a aVar = new y.a();
        aVar.a(new HttpLoggingInterceptor(null, 1, null).d(HttpLoggingInterceptor.Level.BODY));
        aVar.a(new o());
        return aVar.c();
    }

    public final Retrofit h(y client) {
        kotlin.jvm.internal.i.f(client, "client");
        Retrofit build = new Retrofit.Builder().baseUrl("https://push-unicorn.tiktime.net/").client(client).addConverterFactory(ProtoConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        kotlin.jvm.internal.i.e(build, "Builder()\n            .baseUrl(NetworkConstant.PUSH_BASE_URL)\n            .client(client)\n            .addConverterFactory(ProtoConverterFactory.create())\n            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())\n            .build()");
        return build;
    }

    public final Retrofit i(y client) {
        kotlin.jvm.internal.i.f(client, "client");
        Retrofit build = new Retrofit.Builder().baseUrl("https://push-unicorn.ekswaizei.xyz/").client(client).addConverterFactory(ProtoConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        kotlin.jvm.internal.i.e(build, "Builder()\n            .baseUrl(NetworkConstant.PUSH_DEV_URL)\n            .client(client)\n            .addConverterFactory(ProtoConverterFactory.create())\n            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())\n            .build()");
        return build;
    }
}
