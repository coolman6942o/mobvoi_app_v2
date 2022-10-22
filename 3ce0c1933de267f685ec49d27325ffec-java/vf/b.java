package vf;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;
import wf.i;
import wf.j;
import wf.k;
/* compiled from: DataSetApi.java */
/* loaded from: classes2.dex */
public interface b {
    @PATCH("/v1/users/me/data-sources/{data_source_name}/data-sets")
    Call<j> a(@Path("data_source_name") String str, @Body i iVar);

    @GET("/v1/users/me/data-sources/{data_source_name}/data-sets/care/{care_wwid}/{start_in_ms}-{end_in_ms}")
    Call<k> b(@Path("data_source_name") String str, @Path("care_wwid") String str2, @Path("start_in_ms") long j10, @Path("end_in_ms") long j11, @Query("data_type") String str3);

    @GET("/v1/users/me/data-sources/{data_source_name}/data-sets/{start_in_ms}-{end_in_ms}")
    Call<k> c(@Path("data_source_name") String str, @Path("start_in_ms") long j10, @Path("end_in_ms") long j11);

    @GET("/v1/users/me/data-sources/{data_source_name}/data-sets/{start_in_ms}-{end_in_ms}")
    Call<k> d(@Path("data_source_name") String str, @Path("start_in_ms") long j10, @Path("end_in_ms") long j11, @Query("data_type") String str2);

    @GET("/v1/users/me/data-sources/{data_source_name}/data-sets/care/{care_wwid}/{start_in_ms}-{end_in_ms}")
    Call<k> e(@Path("data_source_name") String str, @Path("care_wwid") String str2, @Path("start_in_ms") long j10, @Path("end_in_ms") long j11);
}
