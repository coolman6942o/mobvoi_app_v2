package vf;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import wf.p;
import wf.q;
import wf.r;
/* compiled from: UserSettingApi.java */
/* loaded from: classes2.dex */
public interface d {
    @POST("/v1/users/setting/base")
    Call<r> a(@Header("token") String str, @Body q qVar);

    @GET("/v1/users/setting/base")
    Call<r> b(@Header("Token") String str, @Query("type") String str2);

    @GET("/user/country_code")
    Call<p> c(@Query("wwid") String str, @Query("countryCode") String str2, @Query("timeZone") String str3);
}
