package vf;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import wf.b;
import wf.n;
/* compiled from: DataSourceApi.java */
/* loaded from: classes2.dex */
public interface c {
    @GET("/v1/users/me/care/{care_wwid}/data_sources")
    Call<n> a(@Path("care_wwid") String str);

    @GET("/v1/users/me/data_sources")
    Call<n> b();

    @POST("/v1/users/me/data_sources")
    Call<wf.c> c(@Body b bVar);
}
