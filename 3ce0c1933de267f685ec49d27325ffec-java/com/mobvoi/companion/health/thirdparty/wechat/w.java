package com.mobvoi.companion.health.thirdparty.wechat;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.c;
/* compiled from: WechatSportApi.java */
/* loaded from: classes2.dex */
public interface w {
    @GET("http://wechat-platform.chumenwenwen.com/services/pedometer/authencrypt")
    c<u> a(@Query("wwid") String str, @Query("mac") String str2, @Query("version") String str3);

    @POST("http://wechat-platform.chumenwenwen.com/api/wechat/hardwear/bind")
    c<f> b(@Body c cVar);

    @GET("http://wechat-platform.chumenwenwen.com/services/pedometer/setstepwithsign")
    c<y> c(@Query("deviceId") String str, @Query("step") String str2, @Query("version") String str3, @Query("MVSAccessKeyId") String str4, @Query("Signature") String str5, @Query("wwid") String str6, @Query("appkey") String str7);

    @Headers({"sign: d863-48c5d98755d7c13cb1a823c142684b"})
    @GET("/api/wechat/token/")
    c<z> d();

    @GET("https://api.weixin.qq.com/device/get_stat")
    c<y> e(@Query("access_token") String str, @Query("device_id") String str2);

    @POST("http://wechat-platform.chumenwenwen.com/api/wechat/hardwear/bind_status")
    c<d> f(@Body e eVar);
}
