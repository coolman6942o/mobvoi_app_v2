package com.mobvoi.companion.health.thirdparty.wechat;

import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.y;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/* compiled from: WechatRetrofit.java */
/* loaded from: classes2.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private final w f17088a;

    public v() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.d(HttpLoggingInterceptor.Level.BODY);
        this.f17088a = (w) new Retrofit.Builder().baseUrl("https://tic-assistant.mobvoi.com/").addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client(new y.a().a(httpLoggingInterceptor).c()).build().create(w.class);
    }

    public w a() {
        return this.f17088a;
    }
}
