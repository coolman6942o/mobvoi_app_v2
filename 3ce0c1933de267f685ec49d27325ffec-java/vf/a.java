package vf;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import wf.e;
import wf.f;
import wf.g;
/* compiled from: DataSessionApi.java */
/* loaded from: classes2.dex */
public interface a {
    @GET("/v1/users/me/data-sources/{data_source_name}/data-sessions/care/{care_wwid}/{start_in_ms}-{end_in_ms}")
    Call<g> a(@Path("data_source_name") String str, @Path("care_wwid") String str2, @Path("start_in_ms") long j10, @Path("end_in_ms") long j11, @Query("activity_type") String str3);

    @GET("/v1/users/me/data-sources/{data_source_name}/data-sessions/care/{care_wwid}/{start_in_ms}-{end_in_ms}")
    Call<g> b(@Path("data_source_name") String str, @Path("care_wwid") String str2, @Path("start_in_ms") long j10, @Path("end_in_ms") long j11);

    @POST("/v1/users/me/data-sources/{data_source_name}/data-sessions")
    Call<f> c(@Path("data_source_name") String str, @Body e eVar);

    @GET("/v1/users/me/data-sources/{data_source_name}/data-sessions/{start_in_ms}-{end_in_ms}")
    Call<g> d(@Path("data_source_name") String str, @Path("start_in_ms") long j10, @Path("end_in_ms") long j11);

    @GET("/v1/users/me/data-sources/{data_source_name}/data-sessions/{start_in_ms}-{end_in_ms}")
    Call<g> e(@Path("data_source_name") String str, @Path("start_in_ms") long j10, @Path("end_in_ms") long j11, @Query("activity_type") String str2);
}
