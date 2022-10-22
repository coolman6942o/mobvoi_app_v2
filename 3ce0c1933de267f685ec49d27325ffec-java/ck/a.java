package ck;

import dk.b;
import dk.c;
import io.reactivex.k;
import java.util.HashMap;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
/* compiled from: TicCareApi.java */
/* loaded from: classes2.dex */
public interface a {
    @Headers({"sign_appkey: sign_appkey"})
    @POST("/attention/uncare")
    k<c> a(@Query("session_id") String str, @Query("care_wwid") String str2, @Query("care_device_id") String str3);

    @Headers({"sign_appkey: sign_appkey"})
    @POST("/data_share/setting")
    k<c> b(@Query("session_id") String str, @Query("share_type") String str2, @Query("status") boolean z10);

    @Headers({"sign_appkey: sign_appkey"})
    @POST("/attention")
    k<c> c(@Query("session_id") String str, @QueryMap HashMap<String, String> hashMap);

    @Headers({"sign_appkey: sign_appkey"})
    @GET("/data_share/setting")
    k<dk.a> d(@Query("session_id") String str);

    @Headers({"sign_appkey: sign_appkey"})
    @GET("/attention/care_me")
    k<com.mobvoi.ticcare.common.model.bean.a> e(@Query("session_id") String str);

    @Headers({"sign_appkey: sign_appkey"})
    @GET("/attention/check_care")
    k<b> f(@Query("session_id") String str, @Query("care_wwid") String str2);

    @Headers({"sign_appkey: sign_appkey"})
    @GET("/attention/i_care")
    k<com.mobvoi.ticcare.common.model.bean.b> g(@Query("session_id") String str);

    @Headers({"sign_appkey: sign_appkey"})
    @POST("/attention/care")
    k<c> h(@Query("session_id") String str, @QueryMap HashMap<String, String> hashMap);

    @Headers({"sign_appkey: sign_appkey"})
    @POST("/attention/care_me/delete")
    k<c> i(@Query("session_id") String str, @Query("care_me_wwid") String str2);
}
