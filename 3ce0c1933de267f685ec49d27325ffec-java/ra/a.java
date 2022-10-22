package ra;

import okhttp3.a0;
import okhttp3.x;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.c;
import sa.b;
import sa.d;
import sa.e;
import sa.f;
import sa.g;
import sa.h;
import sa.i;
import sa.j;
import sa.k;
import sa.l;
import sa.m;
import sa.n;
import sa.o;
/* compiled from: AccountApi.java */
/* loaded from: classes2.dex */
public interface a {
    @POST("v3/thirdparty/bind")
    c<sa.c> a(@Body k kVar);

    @POST("v3/login")
    c<g> b(@Body e eVar);

    @POST("v3/logout")
    c<sa.c> c(@Query("session_id") String str);

    @POST("v3/password/reset")
    c<sa.c> d(@Body i iVar);

    @POST("v3/info/update")
    c<sa.c> e(@Body sa.a aVar);

    @PUT("v3/pii/session-id")
    c<sa.c> f(@Query("session_id") String str, @Query("pii") boolean z10);

    @POST("v3/thirdparty/auth")
    c<g> g(@Body l lVar);

    @POST("/v3/login/captcha")
    c<g> h(@Body f fVar);

    @GET("v3/captcha/{type}")
    c<sa.c> i(@Path("type") String str, @Query("phone") String str2, @Query("email") String str3, @Query("usage") String str4, @Query("language") String str5);

    @GET("v3/info/session-id")
    c<g> j(@Query("session_id") String str, @Query("phoneId") String str2, @Query("app") String str3);

    @POST("img/upload")
    @Multipart
    c<d> k(@Part("description") a0 a0Var, @Part x.c cVar);

    @Headers({"base_url:https://galaxy.mobvoi.com"})
    @GET("/toc/jwt/cardiex/authorize")
    c<b> l(@Query("token") String str);

    @PUT("/v3/update/country")
    c<sa.c> m(@Query("session_id") String str, @Query("country") String str2);

    @POST("v3/agree/session-id")
    c<sa.c> n(@Query("session_id") String str, @Query("agree") boolean z10);

    @POST("v3/register")
    c<sa.c> o(@Query("country") String str, @Query("timeZone") String str2, @Body j jVar);

    @POST("/time-zone/save")
    c<o> p(@Body n nVar);

    @POST("v3/rebind/token")
    c<sa.c> q(@Query("session_id") String str, @Body h hVar);

    @Headers({"base_url:https://galaxy.mobvoi.com"})
    @POST("/toc/jwt/cardiex/authorize")
    c<b> r(@Query("token") String str, @Query("authorize") boolean z10);

    @POST("v3/thirdparty/register")
    c<sa.c> s(@Query("country") String str, @Query("timeZone") String str2, @Body m mVar);
}
