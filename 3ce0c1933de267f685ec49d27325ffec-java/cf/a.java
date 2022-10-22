package cf;

import df.b;
import df.c;
import df.d;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
/* compiled from: SportRecordApi.java */
/* loaded from: classes2.dex */
public interface a {
    @POST("/data/accounts/{account-id}/records/motion")
    Call<d> a(@Body b bVar);

    @DELETE("/data/accounts/{account-id}/records/motion")
    Call<d> b(@Query("recordId") String str);

    @GET("/data/accounts/{account-id}/records/care/{careWwid}/motion")
    Call<c> c(@Query("motionIds") String str);

    @GET("/data/accounts/{account-id}/records/care/{careWwid}/motion")
    Call<c> d(@Query("timeBefore") long j10, @Query("timeAfter") long j11, @Query("size") int i10, @Query("motionType") String str, @Query("noPoints") boolean z10);

    @GET("/data/accounts/{account-id}/records/motion")
    Call<c> e(@Query("motionIds") String str);

    @GET("/data/accounts/{account-id}/records/motion")
    Call<c> f(@Query("timeBefore") long j10, @Query("timeAfter") long j11, @Query("size") int i10, @Query("motionType") String str, @Query("noPoints") boolean z10);
}
