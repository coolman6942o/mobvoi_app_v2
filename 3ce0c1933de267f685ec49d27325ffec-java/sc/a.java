package sc;

import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.c;
import tc.b;
import tc.h;
import tc.j;
import tc.m;
/* compiled from: HealthDataApi.kt */
/* loaded from: classes2.dex */
public interface a {
    @GET("/v1/api/user/vpa/home_card/new")
    c<j> a(@Query("wwid") String str);

    @GET("/v1/api/user/vpa/heart_health")
    c<tc.c> b(@Query("wwid") String str);

    @GET
    c<h> c(@Url String str, @Query("sessionId") String str2);

    @GET("/v1/api/user/vpa/setting/get")
    c<m> d(@Query("wwid") String str, @Query("oversea") boolean z10);

    @POST("/v1/api/user/vpa/setting/update/{wwid}")
    c<j> e(@Body List<String> list, @Path("wwid") String str);

    @GET("/v1/api/user/vpa/watchBanner")
    c<b> f(@Query("wwid") String str, @Query("pkg") String str2, @Query("version") String str3, @Query("language") String str4);
}
