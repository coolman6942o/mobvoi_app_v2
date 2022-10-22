package sc;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.c;
import tc.e;
import tc.f;
/* compiled from: SportMedalApi.java */
/* loaded from: classes2.dex */
public interface h {
    @Headers({"sign_appkey: sign_appkey"})
    @GET("/user/vpa/medal/curr_high_strength")
    c<f> a(@Query("sessionId") String str);

    @Headers({"sign_appkey: sign_appkey"})
    @GET("/user/vpa/medals")
    c<e> b(@Query("sessionId") String str, @Query("startMonth") String str2, @Query("endMonth") String str3);
}
