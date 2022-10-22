package wc;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.c;
/* compiled from: AuthorizeApi.java */
/* loaded from: classes2.dex */
public interface a {
    @GET("data/all/oauth/check/{accountId}")
    c<c> a(@Path("accountId") String str);

    @Headers({"base_url:https://passport.mobvoi.com/"})
    @GET("/oauth2/revoke/session-id?type=google")
    c<sa.c> b(@Query("session_id") String str);

    @GET("data/{source}/oauth/undo/{accountId}")
    c<sa.c> c(@Path("source") String str, @Path("accountId") String str2, @Query("token") String str3);

    @Headers({"base_url:https://passport.mobvoi.com/"})
    @GET("/oauth2/info/session-id?type=google")
    c<sa.c> d(@Query("session_id") String str);
}
